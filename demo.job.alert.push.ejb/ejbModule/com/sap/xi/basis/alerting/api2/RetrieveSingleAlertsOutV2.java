
package com.sap.xi.basis.alerting.api2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * This is the return data type for the alerts retrieval
 * 
 * <p>Java class for RetrieveSingleAlertsOut_V2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetrieveSingleAlertsOut_V2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Alert" type="{http://sap.com/xi/BASIS/alerting/api2}SingleAlertsInformation_V2" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="StatusDetails" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveSingleAlertsOut_V2", propOrder = {
    "alert",
    "statusDetails"
})
public class RetrieveSingleAlertsOutV2 {

    @XmlElement(name = "Alert")
    protected List<SingleAlertsInformationV2> alert;
    @XmlElement(name = "StatusDetails", required = true)
    protected String statusDetails;

    /**
     * Gets the value of the alert property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the alert property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAlert().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SingleAlertsInformationV2 }
     * 
     * 
     */
    public List<SingleAlertsInformationV2> getAlert() {
        if (alert == null) {
            alert = new ArrayList<SingleAlertsInformationV2>();
        }
        return this.alert;
    }

    /**
     * Gets the value of the statusDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusDetails() {
        return statusDetails;
    }

    /**
     * Sets the value of the statusDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusDetails(String value) {
        this.statusDetails = value;
    }

}
