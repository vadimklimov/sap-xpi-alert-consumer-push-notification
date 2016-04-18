
package com.sap.xi.basis.global;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="standard" type="{http://sap.com/xi/BASIS/Global}ExchangeFaultData"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "standard"
})
@XmlRootElement(name = "StandardMessageFault")
public class StandardMessageFault {

    @XmlElement(required = true)
    protected ExchangeFaultData standard;

    /**
     * Gets the value of the standard property.
     * 
     * @return
     *     possible object is
     *     {@link ExchangeFaultData }
     *     
     */
    public ExchangeFaultData getStandard() {
        return standard;
    }

    /**
     * Sets the value of the standard property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExchangeFaultData }
     *     
     */
    public void setStandard(ExchangeFaultData value) {
        this.standard = value;
    }

}
