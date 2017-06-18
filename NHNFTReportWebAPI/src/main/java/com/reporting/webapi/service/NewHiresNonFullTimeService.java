package com.reporting.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reporting.webapi.bean.NewHireNonFullTimeReferanceDataBean;
import com.reporting.webapi.dao.INewHiresNonFullTimeDao;
import com.reporting.webapi.vo.ReportCountByWeekVO;
import com.reporting.webapi.vo.ReportsByWeeksCountVO;

@Service
public class NewHiresNonFullTimeService implements INewHiresNonFullTimeService {

	
	@Autowired
	private INewHiresNonFullTimeDao newHiresNonFullTimeDao;
	
	@Override
	public NewHireNonFullTimeReferanceDataBean getReportsReferenceData() throws Exception {
		NewHireNonFullTimeReferanceDataBean newHireNonFullTimeReferanceData = newHiresNonFullTimeDao.getReportsReferenceData();
		return newHireNonFullTimeReferanceData;
	}
	
	@Override
	public List<ReportCountByWeekVO> getReportCountByWeek(String workYear,String workMonth,String controlGroup,
			String unionType,String employeeType) throws Exception{
		List<ReportCountByWeekVO> list = newHiresNonFullTimeDao.getReportCountByWeek(workYear,workMonth,controlGroup,
				unionType,employeeType);
		return list;
	}

	@Override
	public List<ReportsByWeeksCountVO> getDataByWeek(String workYear, String workMonth, String controlGroup,
			String unionType, String employeeType, String reportOfWeek) throws Exception {
		List<ReportsByWeeksCountVO> list = newHiresNonFullTimeDao.getDataByWeek(workYear,workMonth,controlGroup,
				unionType,employeeType,reportOfWeek);
		return list;
	}
	

}
