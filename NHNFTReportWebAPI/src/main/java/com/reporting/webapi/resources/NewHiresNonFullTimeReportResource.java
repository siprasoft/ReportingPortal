package com.reporting.webapi.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.reporting.webapi.annotation.ResponseType;
import com.reporting.webapi.bean.NewHireNonFullTimeReferanceDataBean;
import com.reporting.webapi.service.INewHiresNonFullTimeService;
import com.reporting.webapi.vo.CustomNewHireNonFullTimeVO;
import com.reporting.webapi.vo.CustomReportCountByWeekVO;
import com.reporting.webapi.vo.CustomReportsByWeekCountVO;
import com.reporting.webapi.vo.NewHireNonFullTimeReferenceDataVO;
import com.reporting.webapi.vo.ReportCountByWeekVO;
import com.reporting.webapi.vo.ReportsByWeeksCountVO;

@Component
@Path(value="/newHiresNonFullTime")
public class NewHiresNonFullTimeReportResource {
	
private final Logger logger = Logger.getLogger(NewHiresNonFullTimeReportResource.class);
	
	@Autowired
	private INewHiresNonFullTimeService newHiresNonFullTimeService;

	@Path("/getNewHireNonFullTImeReferenceData")
	@GET
	@Produces( { MediaType.APPLICATION_JSON})
	@ResponseType(CustomNewHireNonFullTimeVO.class)
	public Response getReportsReferenceData() {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: NewHiresNonFullTimeReportResource : getReportsReferenceData : Method to getReportsReferenceData");
		}
		
		CustomNewHireNonFullTimeVO customNewHireNonFullTimeVO = new CustomNewHireNonFullTimeVO();
		try{
			NewHireNonFullTimeReferanceDataBean newHireNonFullTimeReferanceData = newHiresNonFullTimeService.getReportsReferenceData();
			
			NewHireNonFullTimeReferenceDataVO newHireNonFullTimeReferenceDataVO =  new NewHireNonFullTimeReferenceDataVO();
			newHireNonFullTimeReferenceDataVO.setWorkYears(newHireNonFullTimeReferanceData.getWorkYearList());
			newHireNonFullTimeReferenceDataVO.setWorkMonths(newHireNonFullTimeReferanceData.getWorkMonthList());
			newHireNonFullTimeReferenceDataVO.setControlgroups(newHireNonFullTimeReferanceData.getControlGroupList());
			newHireNonFullTimeReferenceDataVO.setUnionTypes(newHireNonFullTimeReferanceData.getUnionTypeList());
			newHireNonFullTimeReferenceDataVO.setEmployeeTypes(newHireNonFullTimeReferanceData.getEmployeeTypeList());
			
			customNewHireNonFullTimeVO.setEligibilityNewHiresNonFullTimeReferenceData(newHireNonFullTimeReferenceDataVO);
			
		} catch (Exception e) {
			//logger.error("Error while invoking getHireWorkYears : " + e.getMessage());
		}
		
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: NewHiresNonFullTimeReportResource : getReportsReferenceData : Method to getReportsReferenceData");
		}
		
		return Response.ok(customNewHireNonFullTimeVO).build();
	}
	
	@Path("/getReportCountByWeek")
	@GET
	@Produces( { MediaType.APPLICATION_JSON})
	//@ResponseType(CustomSummaryWeeksVO.class)
	public Response getReportCountByWeek(@QueryParam("WorkYear") String workYear, @QueryParam("WorkMonth") String workMonth,
			@QueryParam("ControlGroup") String controlGroup, @QueryParam("UnionType") String unionType,
			@QueryParam("EmployeeType") String employeeType) {
		CustomReportCountByWeekVO customReportCountByWeekVO = new CustomReportCountByWeekVO();
		List<ReportCountByWeekVO> reportCountByWeek = null;
		try{
			
			if(null != workYear && workYear.contains("''") &&  workYear.length() == 2) {
				workYear = null;
			}
			if(null != workMonth && workMonth.contains("''") &&  workMonth.length() == 2) {
				workMonth = null;
			}
			if(null != controlGroup && controlGroup.contains("''") &&  controlGroup.length() == 2) {
				controlGroup = null;
			}
			if(null != unionType && unionType.contains("''") &&  unionType.length() == 2) {
				unionType = null;
			}
			if(null != employeeType && employeeType.contains("''") &&  employeeType.length() == 2) {
				employeeType = null;
			}
			
			reportCountByWeek =  newHiresNonFullTimeService.getReportCountByWeek(workYear,workMonth,controlGroup,
					unionType,employeeType);
			customReportCountByWeekVO.setReportCountByWeek(reportCountByWeek);
		} catch (Exception e) {
			//logger.error("Error while invoking getHireWorkYears : " + e.getMessage());
		}
		
		return Response.ok(customReportCountByWeekVO).build();
	}
	
	@Path("/getReportsByWeeksCount")
	@GET
	@Produces( { MediaType.APPLICATION_JSON})
	//@ResponseType(CustomSummaryWeeksVO.class)
	public Response getDataByWeek(@QueryParam("WorkYear") String workYear, @QueryParam("WorkMonth") String workMonth,
			@QueryParam("ControlGroup") String controlGroup, @QueryParam("UnionType") String unionType,
			@QueryParam("EmployeeType") String employeeType,@QueryParam("ReportOfWeek") String reportOfWeek) {
		CustomReportsByWeekCountVO customReportsByWeekCountVO = new CustomReportsByWeekCountVO();
		List<ReportsByWeeksCountVO> reportByWeeksCount = null;
		try{
			
			if(null != workYear && workYear.contains("''") &&  workYear.length() == 2) {
				workYear = null;
			}
			if(null != workMonth && workMonth.contains("''") &&  workMonth.length() == 2) {
				workMonth = null;
			}
			if(null != controlGroup && controlGroup.contains("''") &&  controlGroup.length() == 2) {
				controlGroup = null;
			}
			if(null != unionType && unionType.contains("''") &&  unionType.length() == 2) {
				unionType = null;
			}
			if(null != employeeType && employeeType.contains("''") &&  employeeType.length() == 2) {
				employeeType = null;
			}
			if(null != reportOfWeek && reportOfWeek.contains("''") &&  reportOfWeek.length() == 2) {
				reportOfWeek = null;
			}
			
			reportByWeeksCount =  newHiresNonFullTimeService.getDataByWeek(workYear,workMonth,controlGroup,
					unionType,employeeType,reportOfWeek);
			customReportsByWeekCountVO.setReportByWeekCount(reportByWeeksCount);
		} catch (Exception e) {
			//logger.error("Error while invoking getHireWorkYears : " + e.getMessage());
		}
		
		return Response.ok(customReportsByWeekCountVO).build();
	}

}
