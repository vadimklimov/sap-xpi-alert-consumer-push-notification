
package com.sap.xi.basis.alerting.api2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sap.xi.basis.alerting.api2 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RetrieveSingleAlertsRequestV2_QNAME = new QName("http://sap.com/xi/BASIS/alerting/api2", "RetrieveSingleAlertsRequest_V2");
    private final static QName _RetrieveSingleAlertsResponseV2_QNAME = new QName("http://sap.com/xi/BASIS/alerting/api2", "RetrieveSingleAlertsResponse_V2");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sap.xi.basis.alerting.api2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RetrieveSingleAlertsInV2 }
     * 
     */
    public RetrieveSingleAlertsInV2 createRetrieveSingleAlertsInV2() {
        return new RetrieveSingleAlertsInV2();
    }

    /**
     * Create an instance of {@link RetrieveSingleAlertsOutV2 }
     * 
     */
    public RetrieveSingleAlertsOutV2 createRetrieveSingleAlertsOutV2() {
        return new RetrieveSingleAlertsOutV2();
    }

    /**
     * Create an instance of {@link SingleAlertsInformationV2 }
     * 
     */
    public SingleAlertsInformationV2 createSingleAlertsInformationV2() {
        return new SingleAlertsInformationV2();
    }

    /**
     * Create an instance of {@link OptionalDetailsOut }
     * 
     */
    public OptionalDetailsOut createOptionalDetailsOut() {
        return new OptionalDetailsOut();
    }

    /**
     * Create an instance of {@link OptionalDetailsRowIn }
     * 
     */
    public OptionalDetailsRowIn createOptionalDetailsRowIn() {
        return new OptionalDetailsRowIn();
    }

    /**
     * Create an instance of {@link OptionalDetailsRowOut }
     * 
     */
    public OptionalDetailsRowOut createOptionalDetailsRowOut() {
        return new OptionalDetailsRowOut();
    }

    /**
     * Create an instance of {@link OptionalDetailsIn }
     * 
     */
    public OptionalDetailsIn createOptionalDetailsIn() {
        return new OptionalDetailsIn();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveSingleAlertsInV2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS/alerting/api2", name = "RetrieveSingleAlertsRequest_V2")
    public JAXBElement<RetrieveSingleAlertsInV2> createRetrieveSingleAlertsRequestV2(RetrieveSingleAlertsInV2 value) {
        return new JAXBElement<RetrieveSingleAlertsInV2>(_RetrieveSingleAlertsRequestV2_QNAME, RetrieveSingleAlertsInV2 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveSingleAlertsOutV2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS/alerting/api2", name = "RetrieveSingleAlertsResponse_V2")
    public JAXBElement<RetrieveSingleAlertsOutV2> createRetrieveSingleAlertsResponseV2(RetrieveSingleAlertsOutV2 value) {
        return new JAXBElement<RetrieveSingleAlertsOutV2>(_RetrieveSingleAlertsResponseV2_QNAME, RetrieveSingleAlertsOutV2 .class, null, value);
    }

}
