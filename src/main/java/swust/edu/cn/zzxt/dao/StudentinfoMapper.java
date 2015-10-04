package swust.edu.cn.zzxt.dao;

import java.util.List;

import swust.edu.cn.zzxt.model.Studentinfo;

public interface StudentinfoMapper {
    int deleteByPrimaryKey(Integer stinId);

    int insert(Studentinfo record);

    int insertSelective(Studentinfo record);

    Studentinfo selectByPrimaryKey(Integer stinId);

    int updateByPrimaryKeySelective(Studentinfo record);

    int updateByPrimaryKey(Studentinfo record);
    
    List<Studentinfo> selectByInfoStudId(int studId);
    
    Studentinfo selectBystudInfoStudId(Integer studId);

	Studentinfo updateByStinId(Studentinfo studentinfo);

   
}