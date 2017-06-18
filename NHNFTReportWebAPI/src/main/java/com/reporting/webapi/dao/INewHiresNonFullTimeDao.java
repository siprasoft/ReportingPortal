package com.reporting.webapi.dao;

import java.util.List;

import com.reporting.webapi.bean.NewHireNonFullTimeReferanceDataBean;
import com.reporting.webapi.vo.ReportCountByWeekVO;
import com.reporting.webapi.vo.ReportsByWeeksCountVO;

public interface INewHiresNonFullTimeDao {

	public NewHireNonFullTimeReferanceDataBean getReportsReferenceData() throws Exception;

	public List<ReportCountByWeekVO> getReportCountByWeek(String workYear, String workMonth, String controlGroup,
			String unionType, String employeeType) throws Exception;

	public List<ReportsByWeeksCountVO> getDataByWeek(String workYear, String workMonth, String controlGroup,
			String unionType, String employeeType, String reportOfWeek)throws Exception;

	
}
