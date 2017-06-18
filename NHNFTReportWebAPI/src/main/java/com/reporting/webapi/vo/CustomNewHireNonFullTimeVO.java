package com.reporting.webapi.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CustomNewHireNonFullTimeVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private NewHireNonFullTimeReferenceDataVO EligibilityNewHiresNonFullTimeReferenceData;
	
	

	public NewHireNonFullTimeReferenceDataVO getEligibilityNewHiresNonFullTimeReferenceData() {
		return EligibilityNewHiresNonFullTimeReferenceData;
	}

	public void setEligibilityNewHiresNonFullTimeReferenceData(
			NewHireNonFullTimeReferenceDataVO eligibilityNewHiresNonFullTimeReferenceData) {
		EligibilityNewHiresNonFullTimeReferenceData = eligibilityNewHiresNonFullTimeReferenceData;
	}

}
