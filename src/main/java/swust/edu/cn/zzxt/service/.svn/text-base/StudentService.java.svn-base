package swust.edu.cn.zzxt.service;


import java.util.List;

import swust.edu.cn.zzxt.model.Student;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.selfmodel.StudentTjModel;
import swust.edu.cn.zzxt.selfmodel.Studentbasiinfo;

public interface StudentService {
    public Student findStudentById(int id);
    
    public Student obtainStudentByStudNumber(String studNumber);

	public  List<Student> readStudentByStudNumber(String studNumber);

	public Student selectInfoByUser(Integer userId);

	public Student findStudentByStudId(Integer studId);
	public List<Student> selectByClassId(Integer classId);

    public Student findStudentByStuId(int stuid);
    
    public  List<Student> selectAllStuInfo();


	public List<Student> selectListByUserId(Integer userId);

	public List<Student> selectinfoByinstUserId(Integer userId);

	public List<Student> selectByinstId(Integer instId);//wj

	public List<Student> selectAllstud();

	public Student findStudentByUserId(Integer userId);
    
	public List<Student> selectStudentByUserType(User user);
	
	public List<Student> selectStudentByAll(Studentbasiinfo studentbasiinfo);

	public Student findStudentByIDnumber(String studNumber);
	public List<Student> readStudentByStudIdNumber(String key);

	public List<Student> selectinfoByinstUserId1(Integer userId);

	public List<Student> selectByinstId1(Integer userInstid);

	public List<Student> selectAllstud1();

	public List<Student> findStudentByStuName(String stuName);

	public List<Studentbasiinfo> selectStudentByAll2(
			Studentbasiinfo studentbasiinfo);

	public List<StudentTjModel> findStuCountInfo(User user);

    public List<Student> findAllStudentByInstId(int colleageId);//通过学院Id查找一个学院的所有学生

    public List<Student> findAllStudentByMajorId(int majorId); //通过专业Id查找一个专业的所有学生

	public List<Studentbasiinfo> selectStudentInfoByUserType(User user);
}

