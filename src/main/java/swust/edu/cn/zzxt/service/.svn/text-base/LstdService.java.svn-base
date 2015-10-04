package swust.edu.cn.zzxt.service;

import java.util.Date;
import java.util.List;

import swust.edu.cn.zzxt.model.LstdWithBLOBs;
import swust.edu.cn.zzxt.selfmodel.LstdListModel;

public interface LstdService {


	LstdWithBLOBs selectByStudId(Integer studId);

	List<LstdListModel> selectinfoByStudId(Integer studId);

	public void rejectwslfId(Integer wsflPrestep, Integer lstdId);

	List<LstdListModel> selectinfoByStudNumber(String studNumber);

	List<LstdListModel> selectinfoByacademyid(int academyid);

	List<LstdListModel> selectinfoBymajorid(int majorid);

	List<LstdListModel> selectinfoByclassid(int classid);

	List<LstdListModel> findStudentByUserId(Integer userId);

	LstdWithBLOBs insertLstdByStudId(Integer studId, double lstdApplytuition,
			double lstdApplyaccommodation, String lstdLimittime,
			String lstdLoans, String classopinion, String academyopinion,
			Integer lstdOngoing, String lstdBank, String lstdReturncode,
			Integer wsflNextstep, Integer userId, Date lstdClassopiniontime, String lstdApplyReason, String lstdPaymentReason, String lstdRepayWay, String lstdDisaster);

	LstdWithBLOBs updateLstdStudId(Integer studId, Integer lstdWorkid,
			Integer wsflNextstep, double lstdApplytuition,
			double lstdApplyaccommodation, String lstdLimittime,
			String lstdLoans, String classopinion,Date lstdClassopiniontime,String academyopinion,
			Integer lstdOngoing, String lstdBank, Date lstdAcademyopiniontime,
			String lstdReturncode, Integer lstdstate, String lstdApplyReason, String lstdPaymentReason, String lstdRepayWay, String lstdDisaster);


}





