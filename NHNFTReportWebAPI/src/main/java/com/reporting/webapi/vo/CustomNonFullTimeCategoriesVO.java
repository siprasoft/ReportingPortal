package com.reporting.webapi.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CustomNonFullTimeCategories")
public class CustomNonFullTimeCategoriesVO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElementWrapper(name = "nonfulltimecategories")
	@XmlElement(name = "nonfulltimecategories")
	private List<String> nonfulltimecategories;

	public List<String> getNonFullTimeCategories() {
		return nonfulltimecategories;
	}

	public void setNonFullTimeCategories(List<String> nonfulltimecategories) {
		this.nonfulltimecategories = nonfulltimecategories;
	}
}
