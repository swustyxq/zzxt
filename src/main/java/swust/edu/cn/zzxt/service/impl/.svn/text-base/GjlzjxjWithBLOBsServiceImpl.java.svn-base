package swust.edu.cn.zzxt.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swust.edu.cn.zzxt.dao.GjlzjxjMapper;
import swust.edu.cn.zzxt.model.GjlzjxjWithBLOBs;
import swust.edu.cn.zzxt.selfmodel.GjlzjxjListModel;
import swust.edu.cn.zzxt.service.GjlzjxjWithBLOBsService;
@Service("gjlzjxjwithblobsService")
public class GjlzjxjWithBLOBsServiceImpl implements GjlzjxjWithBLOBsService {
	private GjlzjxjMapper gjlzjxjmapper;

	

	public GjlzjxjMapper getGjlzjxjmapper() {
		return gjlzjxjmapper;
	}


	 @Autowired
	public void setGjlzjxjmapper(GjlzjxjMapper gjlzjxjmapper) {
		this.gjlzjxjmapper = gjlzjxjmapper;
	}



	@SuppressWarnings("finally")
	public GjlzjxjWithBLOBs selectByStudid(Integer studId) {
		GjlzjxjWithBLOBs gjlzjxjwithblbs = null;
		try {
			gjlzjxjwithblbs = gjlzjxjmapper.selectByStudid(studId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			return gjlzjxjwithblbs;
		}
	}


	@SuppressWarnings("finally")
	public GjlzjxjWithBLOBs inputStudLzInfo(Integer studId,
			String gjlzApplyreason, String gjlzResidence,
			double gjlzAllincomes, String gjlzIncometype,
			Integer gjlzPopulation, String gjlzHome, String gjlzMailcode,
			String gjlzRanking, String gjlzComprehensive,
			String gjlzComprehensiveranking, String gjlzPoliticstate,Integer wslfId,Date date) {
		GjlzjxjWithBLOBs gjlzjxjwithblbs = new GjlzjxjWithBLOBs();
		try {
			gjlzjxjwithblbs.setGjlzStudid(studId);
			gjlzjxjwithblbs.setGjlzApplyreason(gjlzApplyreason);
			gjlzjxjwithblbs.setGjlzApplyreasontime(date);
			gjlzjxjwithblbs.setGjlzResidence(gjlzResidence);
			gjlzjxjwithblbs.setGjlzAllincomes(gjlzAllincomes);
			gjlzjxjwithblbs.setGjlzIncometype(gjlzIncometype);
			gjlzjxjwithblbs.setGjlzPopulation(gjlzPopulation);
			gjlzjxjwithblbs.setGjlzHome(gjlzHome);
			gjlzjxjwithblbs.setGjlzMailcode(gjlzMailcode);
			gjlzjxjwithblbs.setGjlzRanking(gjlzRanking);
			gjlzjxjwithblbs.setGjlzComprehensive(gjlzComprehensive);
			gjlzjxjwithblbs.setGjlzComprehensiveranking(gjlzComprehensiveranking);
			gjlzjxjwithblbs.setGjlzPoliticstate(gjlzPoliticstate);
			gjlzjxjwithblbs.setGjlzAnnual("2014");
			gjlzjxjwithblbs.setGjlzWorkid(9);
			gjlzjxjwithblbs.setGjlzWsflid(wslfId);
			
			gjlzjxjmapper.insertSelective(gjlzjxjwithblbs);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return gjlzjxjwithblbs;
		}
		
	}


	@SuppressWarnings("finally")
	public GjlzjxjWithBLOBs updateStudLzInfo(Integer studId,
			String gjlzApplyreason, String gjlzResidence,
			double gjlzAllincomes, String gjlzIncometype,
			Integer gjlzPopulation, String gjlzHome, String gjlzMailcode,
			String gjlzRanking, String gjlzComprehensive,
			String gjlzComprehensiveranking, String gjlzPoliticstate,Integer wslfId,
			Date gjlzMajoropiniontime, Date gjlzAcademyopiniontime, Date gjlzSchoolopiniontime,int gjlzState,
			String majorOption,String academyOption,String schoolOption) {
		GjlzjxjWithBLOBs gjlzjxjwithblbs = new GjlzjxjWithBLOBs();
		try {
			gjlzjxjwithblbs.setGjlzStudid(studId);
			gjlzjxjwithblbs.setGjlzApplyreason(gjlzApplyreason);
			gjlzjxjwithblbs.setGjlzAcademyopinion(academyOption);
			gjlzjxjwithblbs.setGjlzMajoropinion(majorOption);
			gjlzjxjwithblbs.setGjlzSchoolopinion(schoolOption);
			gjlzjxjwithblbs.setGjlzAcademyopiniontime(gjlzAcademyopiniontime);
			gjlzjxjwithblbs.setGjlzMajoropiniontime(gjlzMajoropiniontime);
			gjlzjxjwithblbs.setGjlzSchoolopiniontime(gjlzSchoolopiniontime);
			gjlzjxjwithblbs.setGjlzResidence(gjlzResidence);
			gjlzjxjwithblbs.setGjlzAllincomes(gjlzAllincomes);
			gjlzjxjwithblbs.setGjlzIncometype(gjlzIncometype);
			gjlzjxjwithblbs.setGjlzPopulation(gjlzPopulation);
			gjlzjxjwithblbs.setGjlzHome(gjlzHome);
			gjlzjxjwithblbs.setGjlzMailcode(gjlzMailcode);
			gjlzjxjwithblbs.setGjlzRanking(gjlzRanking);
			gjlzjxjwithblbs.setGjlzComprehensive(gjlzComprehensive);
			gjlzjxjwithblbs.setGjlzComprehensiveranking(gjlzComprehensiveranking);
			gjlzjxjwithblbs.setGjlzPoliticstate(gjlzPoliticstate);
			gjlzjxjwithblbs.setGjlzState(gjlzState);
			gjlzjxjwithblbs.setGjlzAnnual("2014");
			gjlzjxjwithblbs.setGjlzWorkid(9);
			gjlzjxjwithblbs.setGjlzWsflid(wslfId);
			System.out.println(studId);
			System.out.println(gjlzApplyreason+"===================================================================");
			gjlzjxjmapper.updateByStudIdSelective(gjlzjxjwithblbs);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return gjlzjxjwithblbs;
		}
	}


	@SuppressWarnings("finally")
	public GjlzjxjWithBLOBs rejectwslfId(Integer prestep,Integer studId) {
		GjlzjxjWithBLOBs gjlzjxjwithblbs = new GjlzjxjWithBLOBs();
		try {
			gjlzjxjwithblbs.setGjlzId(studId);
			gjlzjxjwithblbs.setGjlzWsflid(prestep);		
			gjlzjxjmapper.updateByPrimaryKeySelective(gjlzjxjwithblbs);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return gjlzjxjwithblbs;
		}
	}


	public List<GjlzjxjListModel> selectinfoByStudId(Integer studId) {
		List<GjlzjxjListModel> gjlzjxj = new ArrayList<GjlzjxjListModel>();
		gjlzjxj = gjlzjxjmapper.selectinfoByStudId(studId);
		return gjlzjxj;
	}


	@SuppressWarnings("finally")
	public List<GjlzjxjListModel> selectinfoByacademyid(int academyid) {
		List<GjlzjxjListModel> gjlzjxj = new ArrayList<GjlzjxjListModel>();
		try {
			gjlzjxj = gjlzjxjmapper.selectinfoByacademyid(academyid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return gjlzjxj;
		}
	}


	@SuppressWarnings("finally")
	public List<GjlzjxjListModel> selectinfoBymajorid(int majorid) {
		List<GjlzjxjListModel> gjlzjxj = new ArrayList<GjlzjxjListModel>();
		try {
			gjlzjxj = gjlzjxjmapper.selectinfoBymajorid(majorid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return gjlzjxj;
		}
		
	}

	@SuppressWarnings("finally")
	public List<GjlzjxjListModel> selectinfoByclassid(int classid) {
		List<GjlzjxjListModel> gjlzjxj = new ArrayList<GjlzjxjListModel>();
		try {
			gjlzjxj = gjlzjxjmapper.selectinfoByclassid(classid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return gjlzjxj;
		}
		
	}

}
