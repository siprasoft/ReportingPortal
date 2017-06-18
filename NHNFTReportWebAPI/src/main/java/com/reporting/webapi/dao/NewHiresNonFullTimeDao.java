package com.reporting.webapi.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.reporting.webapi.bean.NewHireNonFullTimeReferanceDataBean;
import com.reporting.webapi.vo.ReportCountByWeekVO;
import com.reporting.webapi.vo.ReportsByWeeksCountVO;

@Repository
public class NewHiresNonFullTimeDao implements INewHiresNonFullTimeDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public NewHireNonFullTimeReferanceDataBean getReportsReferenceData() throws Exception{
		Session session = sessionFactory.openSession();
		List<String> workYearList = null;
		List<String> workMonthList = null;
		List<String> controlGroupList = null;
		List<String> unionTypeList = null;
		List<String> employeeTypeList = null;
		NewHireNonFullTimeReferanceDataBean newHireNonFullTimeReferanceData = new NewHireNonFullTimeReferanceDataBean();
		
		try{
			Query workYearQuery = session.getNamedQuery("PRC_NewHiresNonFullTime_ReferenceData_WorkYear");
			//workYearList = workYearQuery.list();
			newHireNonFullTimeReferanceData.setWorkYearList(workYearQuery.list());
			
			Query workMonthrQuery = session.getNamedQuery("PRC_NewHiresNonFullTime_ReferenceData_WorkMonth");
			//workMonthList = workMonthrQuery.list();
			newHireNonFullTimeReferanceData.setWorkMonthList(workMonthrQuery.list());
			
			Query controlGroupQuery = session.getNamedQuery("PRC_NewHiresNonFullTime_ReferenceData_ControlGroup");
			//controlGroupList = controlGroupQuery.list();
			newHireNonFullTimeReferanceData.setControlGroupList(controlGroupQuery.list());
			
			Query unionTypeQuery = session.getNamedQuery("PRC_NewHiresNonFullTime_ReferenceData_UnionType");
			//unionTypeList = unionTypeQuery.list();
			newHireNonFullTimeReferanceData.setUnionTypeList(unionTypeQuery.list());
			
			Query employeeTypeQuery = session.getNamedQuery("PRC_NewHiresNonFullTime_ReferenceData_EmployeeType");
			//employeeTypeList = employeeTypeQuery.list();
			newHireNonFullTimeReferanceData.setEmployeeTypeList(employeeTypeQuery.list());
			
			
			
			
		}catch(Exception e){

		}
		return newHireNonFullTimeReferanceData;
	}

	
	@Override
	public List<ReportCountByWeekVO> getReportCountByWeek(String workYear,String workMonth,String controlGroup,
			String unionType, String employeeType) throws Exception {
		Session session = sessionFactory.openSession();
		List<ReportCountByWeekVO> list = null;
		List<ReportCountByWeekVO> listVo = null;
		ReportCountByWeekVO reportCountByWeekVO = null;
		try {
			Query query = session.getNamedQuery("PRC_NewHiresNonFullTime_ReportCountByWeek");
			query.setParameter("workYear", workYear);
			query.setParameter("workMonth", workMonth);
			query.setParameter("controlGroup", controlGroup);
			query.setParameter("unionType", unionType);
			query.setParameter("employeeType", employeeType);
			list = query.list();

			listVo = new ArrayList<ReportCountByWeekVO>();
			if (list != null && list.size() > 0) {
				for (Object o : list) {
					
					System.out.println(o.toString());
					
					reportCountByWeekVO = new ReportCountByWeekVO();

					Object[] column = (Object[]) o;
					if (null != column[0]) {
						reportCountByWeekVO.setWEEKS_WORKED((column[0].toString()));
					}
					if (null != column[1]) {
						reportCountByWeekVO.setWEEKS_WORKED_COUNT((column[1].toString()));
					}
					listVo.add(reportCountByWeekVO);
				}

			}

		} catch (Exception e) {

		}
		return listVo;
	}


	@Override
	public List<ReportsByWeeksCountVO> getDataByWeek(String workYear, String workMonth, String controlGroup,
			String unionType, String employeeType, String reportOfWeek) throws Exception {
		Session session = sessionFactory.openSession();
		List<ReportsByWeeksCountVO> list = null;
		List<ReportsByWeeksCountVO> listVo = null;
		ReportsByWeeksCountVO reportsByWeeksCountVO = null;
		try {
			Query query = session.getNamedQuery("PRC_NewHiresNonFullTime_ReportByWeeksCount");
			query.setParameter("workYear", workYear);
			query.setParameter("workMonth", workMonth);
			query.setParameter("controlGroup", controlGroup);
			query.setParameter("unionType", unionType);
			query.setParameter("employeeType", employeeType);
			query.setParameter("reportOfWeek", reportOfWeek);
			list = query.list();

			listVo = new ArrayList<ReportsByWeeksCountVO>();
			if (list != null && list.size() > 0) {
				for (Object o : list) {
					
					System.out.println(o.toString());
					
					reportsByWeeksCountVO = new ReportsByWeeksCountVO();

					Object[] column = (Object[]) o;
					if (null != column[0]) {
						reportsByWeeksCountVO.setCONTROL_GROUP((column[0].toString()));
					}
					if (null != column[1]) {
						reportsByWeeksCountVO.setWORK_YEAR((column[1].toString()));
					}
					if (null != column[2]) {
						reportsByWeeksCountVO.setWORK_MONTH((column[2].toString()));
					}
					if (null != column[3]) {
						reportsByWeeksCountVO.setMOST_RECENT_PRODUCTION_COMPANY((column[3].toString()));
					}
					if (null != column[4]) {
						reportsByWeeksCountVO.setSSN_NUMBER((column[4].toString()));
					}
					if (null != column[5]) {
						reportsByWeeksCountVO.setFIRST_NAME((column[5].toString()));
					}
					if (null != column[6]) {
						reportsByWeeksCountVO.setLAST_NAME((column[6].toString()));
					}
					if (null != column[7]) {
						reportsByWeeksCountVO.setLAST_WORKED_DATE((column[7].toString()));
					}
					if (null != column[8]) {
						reportsByWeeksCountVO.setHIRE_DATE((column[8].toString()));
					}
					if (null != column[9]) {
						reportsByWeeksCountVO.setUNION_NON_UNION((column[9].toString()));
					}
					if (null != column[10]) {
						reportsByWeeksCountVO.setPAYROLL_SOURCE((column[10].toString()));
					}
					if (null != column[11]) {
						reportsByWeeksCountVO.setAVERAGE_HOURS((column[11].toString()));
					}
					if (null != column[12]) {
						reportsByWeeksCountVO.setTOTAL_HOURS_WEEKS((column[12].toString()));
					}
					
					listVo.add(reportsByWeeksCountVO);
				}

			}

		} catch (Exception e) {

		}
		return listVo;
	}
}
