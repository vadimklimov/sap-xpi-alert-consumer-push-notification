package demo.po.alert.consumer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceRef;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.sap.scheduler.runtime.JobContext;
import com.sap.scheduler.runtime.mdb.MDBJobImplementation;
import com.sap.xi.basis.alerting.api2.AlertRetrieveAPIV2;
import com.sap.xi.basis.alerting.api2.AlertRetrieveAPIV2Service;
import com.sap.xi.basis.alerting.api2.ObjectFactory;
import com.sap.xi.basis.alerting.api2.RetrieveSingleAlertsInV2;
import com.sap.xi.basis.alerting.api2.RetrieveSingleAlertsOutV2;
import com.sap.xi.basis.alerting.api2.SingleAlertsInformationV2;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

/**
 * Message-Driven Bean implementation class for:
 * AlertConsumerPushNotificationJob
 * 
 */
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "JobDefinition=\'AlertConsumerPushNotificationJob\' AND ApplicationName=\'scn.sap.com/demo.job.alert.push.app\'") })
public class AlertConsumerPushNotificationJob extends MDBJobImplementation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6776707480019063245L;

	/**
	 * @see MDBJobImplementation#MDBJobImplementation()
	 */

	@WebServiceRef(name = "AlertRetrieveAPIV2Service")
	AlertRetrieveAPIV2Service alertConsumerService;

	short rc;

	public AlertConsumerPushNotificationJob() {
		super();
	}

	@Override
	public void onJob(JobContext jobContext) throws Exception {
		rc = 0;

		List<String> alertsConsumedPayloadJson = new ArrayList<String>();
		Set<String> alertsSuppressedPayloadJson = new HashSet<String>();

		Logger log = jobContext.getLogger();

		Properties jobParameters = this.readJobParameters(jobContext);

		if (jobParameters.getProperty("AlertConsumerMethod").equalsIgnoreCase(
				"SOAP")) {
			alertsConsumedPayloadJson = this.consumeAlertsSoap(jobParameters,
					log);
		} else if (jobParameters.getProperty("AlertConsumerMethod")
				.equalsIgnoreCase("JMS")) {
			alertsConsumedPayloadJson = this.consumeAlertsJms(jobParameters,
					log);
		} else {
			log.severe("Unsupported alert consumer method");
			rc = -1;
		}

		if (rc == 0) {
			if (alertsConsumedPayloadJson.size() > 0) {
				alertsSuppressedPayloadJson = this.suppressAlerts(
						alertsConsumedPayloadJson, log);
			}
		} else {
			this.prepareExitJob(jobContext);
			return;
		}

		if (rc == 0) {
			if (alertsSuppressedPayloadJson.size() > 0) {
				this.sendPushNotifications(jobParameters,
						alertsSuppressedPayloadJson, log);
			}
		} else {
			this.prepareExitJob(jobContext);
			return;
		}

		this.prepareExitJob(jobContext);
	}

	private Properties readJobParameters(JobContext jobContext) {
		Properties jobParameters = new Properties();

		jobParameters.setProperty("AlertConsumerMethod", jobContext
				.getJobParameter("AlertConsumerMethod").getStringValue());
		jobParameters.setProperty("AlertConsumer", jobContext.getJobParameter(
				"AlertConsumer").getStringValue());
		jobParameters.setProperty("AlertLanguage", jobContext.getJobParameter(
				"AlertLanguage").getStringValue());
		jobParameters.setProperty("AlertMaximumNumber", String
				.valueOf(jobContext.getJobParameter("AlertMaximumNumber")
						.getIntegerValue()));
		jobParameters.setProperty("PushNotificationService", jobContext
				.getJobParameter("PushNotificationService").getStringValue());
		jobParameters.setProperty("PushNotificationUser", jobContext
				.getJobParameter("PushNotificationUser").getStringValue());
		jobParameters.setProperty("PushNotificationToken", jobContext
				.getJobParameter("PushNotificationToken").getStringValue());

		if (jobContext.getJobParameter("PushNotificationDevice")
				.getStringValue() != null) {
			jobParameters
					.setProperty("PushNotificationDevice", jobContext
							.getJobParameter("PushNotificationDevice")
							.getStringValue());
		}

		if (jobContext.getJobParameter("AAEUser").getStringValue() != null) {
			jobParameters.setProperty("AAEUser", jobContext.getJobParameter(
					"AAEUser").getStringValue());
		}

		if (jobContext.getJobParameter("AAEPassword").getStringValue() != null) {
			jobParameters.setProperty("AAEPassword", jobContext
					.getJobParameter("AAEPassword").getStringValue());
		}

		return jobParameters;
	}

	private List<String> consumeAlertsSoap(Properties jobParameters, Logger log) {
		List<String> alertsConsumedPayloadJson = new ArrayList<String>();

		ObjectFactory alertConsumerFactory = new ObjectFactory();

		AlertRetrieveAPIV2 alertConsumerServicePort = alertConsumerService
				.getAlertRetrieveAPI_V2_Port();

		BindingProvider alertConsumerRequestProvider = (BindingProvider) alertConsumerServicePort;
		Map<String, Object> alertConsumerRequestContext = alertConsumerRequestProvider
				.getRequestContext();

		if (jobParameters.getProperty("AAEUser") != null
				&& jobParameters.getProperty("AAEPassword") != null) {
			alertConsumerRequestContext.put(BindingProvider.USERNAME_PROPERTY,
					jobParameters.getProperty("AAEUser"));
			alertConsumerRequestContext.put(BindingProvider.PASSWORD_PROPERTY,
					jobParameters.getProperty("AAEPassword"));
		} else {
			log
					.severe("Error when consuming alerts: SOAP consumer method selected, but credentials for calling SOAP service not provided");
			rc = -1;
			return alertsConsumedPayloadJson;
		}

		RetrieveSingleAlertsInV2 alertConsumerRequest = alertConsumerFactory
				.createRetrieveSingleAlertsInV2();

		alertConsumerRequest.setConsumerID(jobParameters
				.getProperty("AlertConsumer"));
		alertConsumerRequest.setMaxAlerts(BigInteger.valueOf(Long
				.parseLong(jobParameters.getProperty("AlertMaximumNumber"))));
		alertConsumerRequest.setLanguage(jobParameters
				.getProperty("AlertLanguage"));

		try {
			RetrieveSingleAlertsOutV2 alertConsumerResponse = alertConsumerServicePort
					.retrieveSingleAlerts(alertConsumerRequest);
			List<SingleAlertsInformationV2> alerts = alertConsumerResponse
					.getAlert();

			for (SingleAlertsInformationV2 alert : alerts) {
				alertsConsumedPayloadJson.add(alert.getAlertPayload());
			}

			// } catch (P2StandardMessageFault e) {
		} catch (Exception e) {
			log.severe("Error when consuming alerts: " + e.getMessage());
			rc = -1;
		}

		log.info(alertsConsumedPayloadJson.size() + " alert(s) consumed");

		return alertsConsumedPayloadJson;

	}

	private List<String> consumeAlertsJms(Properties jobParameters, Logger log) {
		List<String> alertsConsumedPayloadJson = new ArrayList<String>();

		InitialContext context = null;
		QueueConnectionFactory jmcConnectionFactory = null;
		QueueConnection jmsConnection = null;
		QueueSession jmsSession = null;
		Queue jmsAlertQueue = null;
		QueueReceiver jmsAlertReceiver = null;
		TextMessage jmsAlertMessage = null;

		try {
			context = new InitialContext();
			jmcConnectionFactory = (QueueConnectionFactory) context
					.lookup("jmsfactory/alertingVP/AlertingConsumerConnectionFactory");
			jmsConnection = jmcConnectionFactory.createQueueConnection();
			jmsSession = jmsConnection.createQueueSession(false,
					Session.AUTO_ACKNOWLEDGE);
			jmsAlertQueue = (Queue) context
					.lookup("jmsqueues/alertingVP/jms/queue/xi/monitoring/alert/"
							+ jobParameters.getProperty("AlertConsumer"));
			jmsAlertReceiver = jmsSession.createReceiver(jmsAlertQueue);
			jmsConnection.start();

			int i = 0;

			while (i < Integer.valueOf(jobParameters
					.getProperty("AlertMaximumNumber"))) {
				jmsAlertMessage = (TextMessage) jmsAlertReceiver
						.receiveNoWait();

				if (jmsAlertMessage == null) {
					break;
				}

				alertsConsumedPayloadJson.add(jmsAlertMessage.getText());
				i++;
			}

		} catch (NamingException e) {

			if (e.getMessage().contains(
					jobParameters.getProperty("AlertConsumer"))) {
				log
						.warning("Warning when accessing alerts store JMS queue: "
								+ e.getMessage()
								+ " Alerts not produced for this consumer yet, or incorrect consumer ID");
			} else {
				log.severe("Error when accessing alerts store JMS queue: "
						+ e.getMessage());
				rc = -1;
			}
		} catch (JMSException e) {
			log.severe("Error when accessing alerts store JMS queue: "
					+ e.getMessage());
			rc = -1;
		} finally {
			try {
				if (jmsAlertReceiver != null) {
					jmsAlertReceiver.close();
				}
			} catch (Exception e) {
			}
			try {
				if (jmsSession != null) {
					jmsSession.close();
				}
			} catch (Exception e) {
			}
			try {
				if (jmsConnection != null) {
					jmsConnection.close();
				}
			} catch (Exception e) {
			}
			try {
				if (context != null) {
					context.close();
				}
			} catch (Exception e) {
				log.severe("Error when accessing alerts store JMS queue: "
						+ e.getMessage());
				rc = -1;
			}
		}

		log.info(alertsConsumedPayloadJson.size() + " alert(s) consumed");

		return alertsConsumedPayloadJson;
	}

	private Set<String> suppressAlerts(List<String> alertsConsumedPayloadJson,
			Logger log) {
		Set<String> alertsReducedPayloadJson = new HashSet<String>();

		Gson gson = new Gson();

		for (String alertConsumedPayloadJson : alertsConsumedPayloadJson) {
			try {
				Alert alertConsumedPayload = gson.fromJson(
						alertConsumedPayloadJson, Alert.class);

				Alert alertSuppressedPayload = new Alert();

				alertSuppressedPayload.setScenarioId(alertConsumedPayload
						.getScenarioId());
				alertSuppressedPayload.setScenarioName(alertConsumedPayload
						.getScenarioName());
				alertSuppressedPayload.setFromParty(alertConsumedPayload
						.getFromParty());
				alertSuppressedPayload.setFromService(alertConsumedPayload
						.getFromService());
				alertSuppressedPayload.setToParty(alertConsumedPayload
						.getToParty());
				alertSuppressedPayload.setToService(alertConsumedPayload
						.getToService());
				alertSuppressedPayload.setInterface(alertConsumedPayload
						.getInterface());
				alertSuppressedPayload.setNamespace(alertConsumedPayload
						.getNamespace());
				alertSuppressedPayload.setAdapterType(alertConsumedPayload
						.getAdapterType());
				alertSuppressedPayload.setComponent(alertConsumedPayload
						.getComponent());
				alertSuppressedPayload.setErrCat(alertConsumedPayload
						.getErrCat());
				alertSuppressedPayload.setErrCode(alertConsumedPayload
						.getErrCode());
				alertSuppressedPayload.setErrLabel(alertConsumedPayload
						.getErrLabel());
				alertSuppressedPayload.setErrText(alertConsumedPayload
						.getErrText());

				alertsReducedPayloadJson.add(gson
						.toJson(alertSuppressedPayload));

			} catch (JsonSyntaxException e) {
				log.severe("Error duing Java/JSON conversion: "
						+ e.getMessage());
				rc = -1;
			}
		}

		log.info(alertsReducedPayloadJson.size()
				+ " push notification(s) prepared");

		return alertsReducedPayloadJson;
	}

	private void sendPushNotifications(Properties jobParameters,
			Set<String> alertsPayloadJson, Logger log) {
		int pushNotificationsSuccessCounter = 0;
		int pushNotificationsErrorCounter = 0;

		Gson gson = new Gson();

		Client pushNotificationClient = Client.create();
		WebResource webResource = pushNotificationClient.resource(jobParameters
				.getProperty("PushNotificationService"));

		for (String alertPayloadJson : alertsPayloadJson) {
			try {
				Alert alertPayload = gson.fromJson(alertPayloadJson,
						Alert.class);

				String pushNotificationMessage = "Component: "
						+ alertPayload.getComponent() + "\nScenario: "
						+ alertPayload.getScenarioName() + "\nError: ["
						+ alertPayload.getErrCode() + "] "
						+ alertPayload.getErrText();

				MultivaluedMap<String, String> pushNotificationParameters = new MultivaluedMapImpl();

				pushNotificationParameters.add("user", jobParameters
						.getProperty("PushNotificationUser"));
				pushNotificationParameters.add("token", jobParameters
						.getProperty("PushNotificationToken"));

				if (jobParameters.getProperty("PushNotificationDevice") != null) {
					pushNotificationParameters.add("device", jobParameters
							.getProperty("PushNotificationDevice"));
				}

				// pushNotificationParameters.add("title", "SAP PO");
				pushNotificationParameters.add("message",
						pushNotificationMessage);

				ClientResponse pushNotificationResponse = webResource.accept(
						MediaType.APPLICATION_JSON_TYPE).type(
						MediaType.APPLICATION_FORM_URLENCODED).post(
						ClientResponse.class, pushNotificationParameters);

				if (pushNotificationResponse.getStatus() == 200) {
					pushNotificationsSuccessCounter++;
				} else {
					pushNotificationsErrorCounter++;
				}

			} catch (JsonSyntaxException e) {
				log.severe("Error duing Java/JSON conversion: "
						+ e.getMessage());
				rc = -1;
			} catch (UniformInterfaceException e) {
				log.severe("Error duing sending push notification: "
						+ e.getMessage());
				rc = -1;
			} catch (ClientHandlerException e) {
				log.severe("Error duing sending push notification: "
						+ e.getMessage());
				rc = -1;
			}

		}

		log.info(pushNotificationsSuccessCounter
				+ " push notification(s) sent successfully, "
				+ pushNotificationsErrorCounter
				+ " push notification(s) failed");

		if (pushNotificationsErrorCounter > 0) {
			rc = -1;
		}
	}

	private void prepareExitJob(JobContext jobContext) {
		jobContext.setReturnCode(rc);
		rc = 0;
	}

}
