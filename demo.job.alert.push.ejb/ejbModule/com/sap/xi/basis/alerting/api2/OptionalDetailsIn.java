
package com.sap.xi.basis.alerting.api2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Array of optional details
 * 
 * <p>Java class for OptionalDetailsIn complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OptionalDetailsIn">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DetailsNames" type="{http://sap.com/xi/BASIS/alerting/api2}OptionalDetailsRowIn" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OptionalDetailsIn", propOrder = {
    "detailsNames"
})
public class OptionalDetailsIn {

    @XmlElement(name = "DetailsNames")
    protected List<OptionalDetailsRowIn> detailsNames;

    /**
     * Gets the value of the detailsNames property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detailsNames property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetailsNames().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OptionalDetailsRowIn }
     * 
     * 
     */
    public List<OptionalDetailsRowIn> getDetailsNames() {
        if (detailsNames == null) {
            detailsNames = new ArrayList<OptionalDetailsRowIn>();
        }
        return this.detailsNames;
    }

}
