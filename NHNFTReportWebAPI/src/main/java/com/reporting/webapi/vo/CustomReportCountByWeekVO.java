package com.reporting.webapi.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customReportCountByWeek")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomReportCountByWeekVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<ReportCountByWeekVO> reportCountByWeek;

	public List<ReportCountByWeekVO> getReportCountByWeek() {
		return reportCountByWeek;
	}

	public void setReportCountByWeek(List<ReportCountByWeekVO> reportCountByWeek) {
		this.reportCountByWeek = reportCountByWeek;
	}


}
