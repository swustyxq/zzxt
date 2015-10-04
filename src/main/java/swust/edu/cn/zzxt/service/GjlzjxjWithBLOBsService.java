package swust.edu.cn.zzxt.service;

import java.util.Date;
import java.util.List;

import swust.edu.cn.zzxt.model.GjlzjxjWithBLOBs;
import swust.edu.cn.zzxt.selfmodel.GjlzjxjListModel;

public interface GjlzjxjWithBLOBsService {

	public GjlzjxjWithBLOBs selectByStudid(Integer studId);

	public GjlzjxjWithBLOBs inputStudLzInfo(Integer studId,
			String gjlzApplyreason, String gjlzResidence,
			double gjlzAllincomes, String gjlzIncometype,
			Integer gjlzPopulation, String gjlzHome, String gjlzMailcode,
			String gjlzRanking, String gjlzComprehensive,
			String gjlzComprehensiveranking, String gjlzPoliticstate,Integer wslfId,Date date);

	public GjlzjxjWithBLOBs updateStudLzInfo(Integer studId,
			String gjlzApplyreason, String gjlzResidence,
			double gjlzAllincomes, String gjlzIncometype,
			Integer gjlzPopulation, String gjlzHome, String gjlzMailcode,
			String gjlzRanking, String gjlzComprehensive,
			String gjlzComprehensiveranking, String gjlzPoliticstate,Integer wslfId,
			Date gjlzMajoropiniontime, Date gjlzAcademyopiniontime, Date gjlzSchoolopiniontime, int gjlzstate, 
			String majorOption, String academyOption, String schoolOption);

	public GjlzjxjWithBLOBs rejectwslfId(Integer prestep, Integer studId);

	public List<GjlzjxjListModel> selectinfoByStudId(Integer studId);

	public List<GjlzjxjListModel> selectinfoByacademyid(int academyid);

	public List<GjlzjxjListModel> selectinfoBymajorid(int majorid);

	public List<GjlzjxjListModel> selectinfoByclassid(int classid);
}


