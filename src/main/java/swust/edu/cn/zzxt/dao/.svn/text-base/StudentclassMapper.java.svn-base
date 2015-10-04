package swust.edu.cn.zzxt.dao;

import java.util.List;

import swust.edu.cn.zzxt.model.Studentclass;

public interface StudentclassMapper {
    int deleteByPrimaryKey(Integer classId);

    int insert(Studentclass record);

    int insertSelective(Studentclass record);

    Studentclass selectByPrimaryKey(Integer classId);

    int updateByPrimaryKeySelective(Studentclass record);

    int updateByPrimaryKeyWithBLOBs(Studentclass record);

    int updateByPrimaryKey(Studentclass record);
    
    int findClassIdByClassName(String className);

	List<Studentclass> selectByInstId(Integer instId);
	
	List<Studentclass> selectByInstitutionId(Integer instId);

	List<Studentclass> selectByMajorId(Integer majrId);

}