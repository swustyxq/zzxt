package swust.edu.cn.zzxt.dao;

import java.util.List;

import swust.edu.cn.zzxt.model.Lstd;
import swust.edu.cn.zzxt.model.LstdWithBLOBs;
import swust.edu.cn.zzxt.selfmodel.LstdListModel;

public interface LstdMapper {
    int deleteByPrimaryKey(Integer lstdId);

    int insert(LstdWithBLOBs record);

    int insertSelective(LstdWithBLOBs record);

    LstdWithBLOBs selectByPrimaryKey(Integer lstdId);

    int updateByPrimaryKeySelective(LstdWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(LstdWithBLOBs record);

    int updateByPrimaryKey(Lstd record);

	LstdWithBLOBs selectByStudId(Integer studId);

	LstdWithBLOBs updateByStudId(LstdWithBLOBs lstdwithblobs);

	List<LstdListModel> selectinfoByStudId(Integer studId);

	List<LstdListModel> selectinfoByStudNumber(String studNumber);

	List<LstdListModel> selectinfoByacademyid(int academyid);

	List<LstdListModel> selectinfoBymajorid(int majorid);

	List<LstdListModel> selectinfoByclassid(int classid);

	List<LstdListModel> findStudentByUserId(Integer userId);

	List<LstdListModel> selectAcademyAllList( Integer instId);


}

