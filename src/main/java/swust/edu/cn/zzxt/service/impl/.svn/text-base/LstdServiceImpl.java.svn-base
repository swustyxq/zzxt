package swust.edu.cn.zzxt.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swust.edu.cn.zzxt.dao.LstdMapper;
import swust.edu.cn.zzxt.model.LstdWithBLOBs;
import swust.edu.cn.zzxt.selfmodel.LstdListModel;
import swust.edu.cn.zzxt.service.LstdService;

@Service
public class LstdServiceImpl implements LstdService{
	private LstdMapper lstdMapper;

	public LstdMapper getLstdMapper() {
		return lstdMapper;
	}
	@Autowired
	public void setLstdMapper(LstdMapper lstdMapper) {
		this.lstdMapper = lstdMapper;
	}
	
	@SuppressWarnings("finally")
	public LstdWithBLOBs selectByStudId(Integer studId) {
		LstdWithBLOBs lstdwithblobs = new LstdWithBLOBs();
		try {
			lstdwithblobs = lstdMapper.selectByStudId(studId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return lstdwithblobs;
		}
	}
	@SuppressWarnings("finally")
	public List<LstdListModel> selectinfoByStudId(Integer studId) {
		List<LstdListModel> lstd = new ArrayList<LstdListModel>();
		try {
			lstd = lstdMapper.selectinfoByStudId(studId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return lstd;
		}
	}
	public void rejectwslfId(Integer wsflPrestep, Integer lstdId) {
		LstdWithBLOBs lstd = new LstdWithBLOBs();
		try {
			lstd.setLstdId(lstdId);
			lstd.setLstdWsflid(wsflPrestep);
			
			lstdMapper.updateByPrimaryKeySelective(lstd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@SuppressWarnings("finally")
	public List<LstdListModel> selectinfoByStudNumber(String studNumber) {
		List<LstdListModel> lstd = null;
		try {
			lstd = lstdMapper.selectinfoByStudNumber(studNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return lstd;
		}
		
	}
	@SuppressWarnings("finally")
	public List<LstdListModel> selectinfoByacademyid(int academyid) {
		List<LstdListModel> lstd = new ArrayList<LstdListModel>();
		try {
			lstd = lstdMapper.selectinfoByacademyid(academyid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return lstd;
		}
	}
	@SuppressWarnings("finally")
	public List<LstdListModel> selectinfoBymajorid(int majorid) {
		List<LstdListModel> lstd = new ArrayList<LstdListModel>();
		try {
			lstd = lstdMapper.selectinfoBymajorid(majorid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return lstd;
		}
	}
	@SuppressWarnings("finally")
	public List<LstdListModel> selectinfoByclassid(int classid) {
		List<LstdListModel> lstd = new ArrayList<LstdListModel>();
		try {
			lstd = lstdMapper.selectinfoByclassid(classid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return lstd;
		}
	}
	@SuppressWarnings("finally")
	public List<LstdListModel> findStudentByUserId(Integer userId) {
		List<LstdListModel> lstd = new ArrayList<LstdListModel>();
		try {
			lstd = lstdMapper.findStudentByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return lstd;
		}
	}
	@SuppressWarnings("finally")
	public LstdWithBLOBs insertLstdByStudId(Integer studId,
			double lstdApplytuition, double lstdApplyaccommodation,
			String lstdLimittime, String lstdLoans, String classopinion,
			String academyopinion, Integer lstdOngoing, String lstdBank,
			String lstdReturncode, Integer wsflNextstep, Integer userId,
			Date lstdClassopiniontime, String lstdApplyReason, String lstdPaymentReason, String lstdRepayWay, String lstdDisaster) {
		LstdWithBLOBs lstdwithblobs = new LstdWithBLOBs();
		try {
			lstdwithblobs.setLstdStudid(studId);
			lstdwithblobs.setLstdWorkid(5);
			lstdwithblobs.setLstdWsflid(wsflNextstep);
			lstdwithblobs.setLstdApplytuition(lstdApplytuition);
			lstdwithblobs.setLstdApplyaccommodation(lstdApplyaccommodation);
			lstdwithblobs.setLstdLimittime(lstdLimittime);
			lstdwithblobs.setLstdLoans(lstdLoans);
			lstdwithblobs.setLstdClassopinion(classopinion);
			lstdwithblobs.setLstdOngoing(lstdOngoing);
			lstdwithblobs.setLstdBank(lstdBank);
			lstdwithblobs.setLstdReturncode(lstdReturncode);
			lstdwithblobs.setLstdApplyRole(userId);
			lstdwithblobs.setLstdClassopiniontime(lstdClassopiniontime);
			lstdwithblobs.setLstdApplyReason(lstdApplyReason);
			lstdwithblobs.setLstdPaymentReason(lstdPaymentReason);
			lstdwithblobs.setLstdRepayWay(lstdRepayWay);
			lstdwithblobs.setLstdDisaster(lstdDisaster);
			lstdMapper.insertSelective(lstdwithblobs);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return lstdwithblobs;
		}
	}
	@SuppressWarnings("finally")
	public LstdWithBLOBs updateLstdStudId(Integer studId, Integer lstdWorkid,
			Integer wsflNextstep, double lstdApplytuition,
			double lstdApplyaccommodation, String lstdLimittime,
			String lstdLoans, String classopinion, Date lstdClassopiniontime,
			String academyopinion, Integer lstdOngoing, String lstdBank,
			Date lstdAcademyopiniontime, String lstdReturncode,
			Integer lstdstate, String lstdApplyReason, String lstdPaymentReason, String lstdRepayWay, String lstdDisaster) {
		LstdWithBLOBs lstdwithblobs = new LstdWithBLOBs();
		try {
			lstdwithblobs.setLstdStudid(studId);
			lstdwithblobs.setLstdWorkid(lstdWorkid);
			lstdwithblobs.setLstdWsflid(wsflNextstep);
			lstdwithblobs.setLstdApplytuition(lstdApplytuition);
			lstdwithblobs.setLstdApplyaccommodation(lstdApplyaccommodation);
			lstdwithblobs.setLstdLimittime(lstdLimittime);
			lstdwithblobs.setLstdLoans(lstdLoans);
			lstdwithblobs.setLstdNotloan(null);
			lstdwithblobs.setLstdAppliedonline(null);
			lstdwithblobs.setLstdApplyRole(null);
			lstdwithblobs.setLstdOngoing(lstdOngoing);
			lstdwithblobs.setLstdBank(lstdBank);
			lstdwithblobs.setLstdReturncode(lstdReturncode);
			lstdwithblobs.setLstdState(lstdstate);
			lstdwithblobs.setLstdClassopinion(classopinion);
			lstdwithblobs.setLstdClassopiniontime(lstdClassopiniontime);
			lstdwithblobs.setLstdAcademyopinion(academyopinion);
			lstdwithblobs.setLstdAcademyopiniontime(lstdAcademyopiniontime);
			lstdwithblobs.setLstdApplyReason(lstdApplyReason);
			lstdwithblobs.setLstdPaymentReason(lstdPaymentReason);
			lstdwithblobs.setLstdRepayWay(lstdRepayWay);
			lstdwithblobs.setLstdDisaster(lstdDisaster);
			lstdMapper.updateByStudId(lstdwithblobs);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return lstdwithblobs;
		}
	}
	
	
}
