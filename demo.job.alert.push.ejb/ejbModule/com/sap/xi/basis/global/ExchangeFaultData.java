
package com.sap.xi.basis.global;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExchangeFaultData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExchangeFaultData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="faultText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="faultUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="faultDetail" type="{http://sap.com/xi/BASIS/Global}ExchangeLogData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExchangeFaultData", propOrder = {
    "faultText",
    "faultUrl",
    "faultDetail"
})
public class ExchangeFaultData {

    @XmlElement(required = true)
    protected String faultText;
    protected String faultUrl;
    protected List<ExchangeLogData> faultDetail;

    /**
     * Gets the value of the faultText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaultText() {
        return faultText;
    }

    /**
     * Sets the value of the faultText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaultText(String value) {
        this.faultText = value;
    }

    /**
     * Gets the value of the faultUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaultUrl() {
        return faultUrl;
    }

    /**
     * Sets the value of the faultUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaultUrl(String value) {
        this.faultUrl = value;
    }

    /**
     * Gets the value of the faultDetail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the faultDetail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFaultDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExchangeLogData }
     * 
     * 
     */
    public List<ExchangeLogData> getFaultDetail() {
        if (faultDetail == null) {
            faultDetail = new ArrayList<ExchangeLogData>();
        }
        return this.faultDetail;
    }

}
