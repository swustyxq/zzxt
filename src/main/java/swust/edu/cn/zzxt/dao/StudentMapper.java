package swust.edu.cn.zzxt.dao;

import java.util.List;

import swust.edu.cn.zzxt.model.Student;
import swust.edu.cn.zzxt.selfmodel.Studentbasiinfo;
public interface StudentMapper {
    int deleteByPrimaryKey(Integer studId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
    
    List<Student> selectByUserId(int studUserid);
    
    List<Student> selectByStudNumber(String studNumber);

	List<Student> selectByClassId(Integer classId);

	Student selectInfoByUserId(Integer userId);
	
	Student selectInfoByStuId(int stuId);

    List<Student> selectAllStuInfo();//查找所有学生信息

	List<Student> selectInfoByinstUserId(Integer userId);//wj（绿色通道）

	List<Student> selectByinstId(Integer instId);//wj（绿色通道）

	List<Student> selectAllstud();	//wj（绿色通道）

	Student findStudentByUserId(Integer userId);

	List<Student> selectAllStuInfoByinstUserId(Integer userId);//查找当前辅导员所带学生

	List<Student> selectAllStuInfoByinstId(Integer userInstid);//通过学院查找学生信息

	List<Student> selectAllStuInfoByAll(Studentbasiinfo studentbasiinfo);

	Student selectByIDnumber(String studNumber);

	List<Student> selectByStudIdNumber(String key);

	List<Student> selectInfoByinstUserId1(Integer userId);

	List<Student> selectByinstId1(Integer instId);

	List<Student> selectAllstud1();

	List<Student> selectByStuName(String stuName);//pengyan 通过学生姓名查找学生

	List<Studentbasiinfo> selectAllStuInfoByStudentbasiinfo(
			Studentbasiinfo studentbasiinfo);
List<Student> selectByapplyGjjxj(Integer instId);
	
	List<Student> selectByapplyGjzxj(Integer instId);

	List<Student> selectByMajorId(Integer majrId);

    List<Student> selectOneInstitution(int colleageId);//查找一个学院的所有学生

    List<Student> selectOneMajor(int majorId);//查找一个专业的所有学生

	List<Studentbasiinfo> selectAllStuInfoByInstUserId(Integer userId);
}