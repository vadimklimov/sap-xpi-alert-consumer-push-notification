
package com.sap.xi.basis.alerting.api2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * This datatype specifies the consumer, for which the alerts shall be retrieved, and the maximum number of alerts to be retrieved
 * 
 * <p>Java class for RetrieveSingleAlertsIn_V2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetrieveSingleAlertsIn_V2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConsumerID" type="{http://sap.com/xi/BASIS}AlertConsumerName"/>
 *         &lt;element name="MaxAlerts" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="Language" type="{http://sap.com/xi/BASIS/Global}LanguageCode" minOccurs="0"/>
 *         &lt;element name="OptionalDetails" type="{http://sap.com/xi/BASIS/alerting/api2}OptionalDetailsIn" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveSingleAlertsIn_V2", propOrder = {
    "consumerID",
    "maxAlerts",
    "language",
    "optionalDetails"
})
public class RetrieveSingleAlertsInV2 {

    @XmlElement(name = "ConsumerID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String consumerID;
    @XmlElement(name = "MaxAlerts", required = true)
    protected BigInteger maxAlerts;
    @XmlElement(name = "Language")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String language;
    @XmlElement(name = "OptionalDetails")
    protected OptionalDetailsIn optionalDetails;

    /**
     * Gets the value of the consumerID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConsumerID() {
        return consumerID;
    }

    /**
     * Sets the value of the consumerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConsumerID(String value) {
        this.consumerID = value;
    }

    /**
     * Gets the value of the maxAlerts property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxAlerts() {
        return maxAlerts;
    }

    /**
     * Sets the value of the maxAlerts property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxAlerts(BigInteger value) {
        this.maxAlerts = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the optionalDetails property.
     * 
     * @return
     *     possible object is
     *     {@link OptionalDetailsIn }
     *     
     */
    public OptionalDetailsIn getOptionalDetails() {
        return optionalDetails;
    }

    /**
     * Sets the value of the optionalDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link OptionalDetailsIn }
     *     
     */
    public void setOptionalDetails(OptionalDetailsIn value) {
        this.optionalDetails = value;
    }

}
