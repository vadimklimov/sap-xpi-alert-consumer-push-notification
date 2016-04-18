
package com.sap.xi.basis.alerting.api2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Array of optional details with values
 * 
 * <p>Java class for OptionalDetailsOut complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OptionalDetailsOut">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DetailsValues" type="{http://sap.com/xi/BASIS/alerting/api2}OptionalDetailsRowOut" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OptionalDetailsOut", propOrder = {
    "detailsValues"
})
public class OptionalDetailsOut {

    @XmlElement(name = "DetailsValues")
    protected List<OptionalDetailsRowOut> detailsValues;

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
     * {@link OptionalDetailsRowOut }
     * 
     * 
     */
    public List<OptionalDetailsRowOut> getDetailsValues() {
        if (detailsValues == null) {
            detailsValues = new ArrayList<OptionalDetailsRowOut>();
        }
        return this.detailsValues;
    }

}
