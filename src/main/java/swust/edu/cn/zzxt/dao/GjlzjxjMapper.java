package swust.edu.cn.zzxt.dao;

import java.util.List;

import swust.edu.cn.zzxt.model.Gjlzjxj;
import swust.edu.cn.zzxt.model.GjlzjxjWithBLOBs;
import swust.edu.cn.zzxt.selfmodel.GjlzjxjListModel;

public interface GjlzjxjMapper {
    int deleteByPrimaryKey(Integer gjlzId);

    int insert(GjlzjxjWithBLOBs record);

    int insertSelective(GjlzjxjWithBLOBs record);

    GjlzjxjWithBLOBs selectByPrimaryKey(Integer gjlzId);

    int updateByPrimaryKeySelective(GjlzjxjWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(GjlzjxjWithBLOBs record);

    int updateByPrimaryKey(Gjlzjxj record);	
	
	GjlzjxjWithBLOBs selectByStudid(Integer gjlzStudid);

	GjlzjxjWithBLOBs updateByStudIdSelective(GjlzjxjWithBLOBs gjlzjxjwithblbs);

	List<GjlzjxjListModel> selectinfoByStudId(Integer studId);

	List<GjlzjxjListModel> selectinfoByacademyid(int academyid);

	List<GjlzjxjListModel> selectinfoBymajorid(int majorid);

	List<GjlzjxjListModel> selectinfoByclassid(int classid);
	
}