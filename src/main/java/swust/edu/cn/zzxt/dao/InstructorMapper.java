package swust.edu.cn.zzxt.dao;

import java.util.List;

import swust.edu.cn.zzxt.model.Instructor;
import swust.edu.cn.zzxt.selfmodel.TeacherModal;

public interface InstructorMapper {
    int deleteByPrimaryKey(Integer instId);

    int insert(Instructor record);

    int insertSelective(Instructor record);

    Instructor selectByPrimaryKey(Integer instId);

    int updateByPrimaryKeySelective(Instructor record);

    int updateByPrimaryKeyWithBLOBs(Instructor record);

    int updateByPrimaryKey(Instructor record);

	Instructor selectByUserId(Integer userId);
	
	List<TeacherModal> selectTeacherByInstid(Integer instid);
	
}