
package com.sap.xi.basis.alerting.api2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * This represents a single alert for component ComponentID, rule AlertRuleID and integration flow ID and has content AlertPayload and optional details
 * 
 * <p>Java class for SingleAlertsInformation_V2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SingleAlertsInformation_V2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AlertPayload" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AlertRuleID" type="{http://sap.com/xi/BASIS}AlertRuleName"/>
 *         &lt;element name="ComponentID">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="120"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="IntegrationFlowID">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="120"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AlertsDeleted" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="ErrorLabelID" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="DetailsValues" type="{http://sap.com/xi/BASIS/alerting/api2}OptionalDetailsOut" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SingleAlertsInformation_V2", propOrder = {
    "alertPayload",
    "alertRuleID",
    "componentID",
    "integrationFlowID",
    "alertsDeleted",
    "errorLabelID",
    "detailsValues"
})
public class SingleAlertsInformationV2 {

    @XmlElement(name = "AlertPayload", required = true)
    protected String alertPayload;
    @XmlElement(name = "AlertRuleID", required = true)
    protected String alertRuleID;
    @XmlElement(name = "ComponentID", required = true)
    protected String componentID;
    @XmlElement(name = "IntegrationFlowID", required = true)
    protected String integrationFlowID;
    @XmlElement(name = "AlertsDeleted", required = true)
    protected BigInteger alertsDeleted;
    @XmlElement(name = "ErrorLabelID", required = true)
    protected BigInteger errorLabelID;
    @XmlElement(name = "DetailsValues")
    protected List<OptionalDetailsOut> detailsValues;

    /**
     * Gets the value of the alertPayload property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlertPayload() {
        return alertPayload;
    }

    /**
     * Sets the value of the alertPayload property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlertPayload(String value) {
        this.alertPayload = value;
    }

    /**
     * Gets the value of the alertRuleID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlertRuleID() {
        return alertRuleID;
    }

    /**
     * Sets the value of the alertRuleID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlertRuleID(String value) {
        this.alertRuleID = value;
    }

    /**
     * Gets the value of the componentID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComponentID() {
        return componentID;
    }

    /**
     * Sets the value of the componentID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComponentID(String value) {
        this.componentID = value;
    }

    /**
     * Gets the value of the integrationFlowID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntegrationFlowID() {
        return integrationFlowID;
    }

    /**
     * Sets the value of the integrationFlowID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntegrationFlowID(String value) {
        this.integrationFlowID = value;
    }

    /**
     * Gets the value of the alertsDeleted property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAlertsDeleted() {
        return alertsDeleted;
    }

    /**
     * Sets the value of the alertsDeleted property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAlertsDeleted(BigInteger value) {
        this.alertsDeleted = value;
    }

    /**
     * Gets the value of the errorLabelID property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getErrorLabelID() {
        return errorLabelID;
    }

    /**
     * Sets the value of the errorLabelID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setErrorLabelID(BigInteger value) {
        this.errorLabelID = value;
    }

    /**
     * Gets the value of the detailsValues property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detailsValues property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetailsValues().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OptionalDetailsOut }
     * 
     * 
     */
    public List<OptionalDetailsOut> getDetailsValues() {
        if (detailsValues == null) {
            detailsValues = new ArrayList<OptionalDetailsOut>();
        }
        return this.detailsValues;
    }

}
