package swust.edu.cn.zzxt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swust.edu.cn.zzxt.dao.InstitutionMapper;
import swust.edu.cn.zzxt.dao.InstructorMapper;
import swust.edu.cn.zzxt.dao.MajorMapper;
import swust.edu.cn.zzxt.dao.StudentMapper;
import swust.edu.cn.zzxt.dao.StudentclassMapper;
import swust.edu.cn.zzxt.dao.UserMapper;
import swust.edu.cn.zzxt.model.Institution;
import swust.edu.cn.zzxt.model.Major;
import swust.edu.cn.zzxt.model.Student;
import swust.edu.cn.zzxt.model.Studentclass;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.selfmodel.StudentTjModel;
import swust.edu.cn.zzxt.selfmodel.Studentbasiinfo;
import swust.edu.cn.zzxt.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	private InstructorMapper instructorMapper;
	public InstructorMapper getInstructorMapper() {
		return instructorMapper;
	}
	@Autowired
	public void setInstructorMapper(InstructorMapper instructorMapper) {
		this.instructorMapper = instructorMapper;
	}

	private StudentMapper studentMapper;
	private MajorMapper majorMapper;
	private StudentclassMapper studentclassMapper;

	public StudentclassMapper getStudentclassMapper() {
		return studentclassMapper;
	}

	@Autowired
	public void setStudentclassMapper(StudentclassMapper studentclassMapper) {
		this.studentclassMapper = studentclassMapper;
	}

	public MajorMapper getMajorMapper() {
		return majorMapper;
	}

	@Autowired
	public void setMajorMapper(MajorMapper majorMapper) {
		this.majorMapper = majorMapper;
	}

	private InstitutionMapper institutionMapper;

	public InstitutionMapper getInstitutionMapper() {
		return institutionMapper;
	}

	@Autowired
	public void setInstitutionMapper(InstitutionMapper institutionMapper) {
		this.institutionMapper = institutionMapper;
	}

	private UserMapper userMapper;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public StudentMapper getStudentMapper() {
		return studentMapper;
	}

	@Autowired
	public void setStudentMapper(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}

	@SuppressWarnings("finally")
	public Student findStudentById(int id) {
		Student student = new Student();
		try {
			List<Student> list = new ArrayList<Student>();
			list = studentMapper.selectByUserId(id);
			if (list != null && list.size() > 0) {
				student = list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return student;
		}
	}

	@SuppressWarnings("finally")
	public Student obtainStudentByStudNumber(String studNumber) {
		Student student = new Student();
		try {
			student = studentMapper.selectByStudNumber(studNumber).get(0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return student;
		}
	}

	@SuppressWarnings("finally")
	public List<Student> readStudentByStudNumber(String studNumber) {

		List<Student> student = new ArrayList<Student>();
		try {
			student = studentMapper.selectByStudNumber(studNumber);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return student;
		}
	}

	@SuppressWarnings("finally")
	public Student selectInfoByUser(Integer userId) {
		Student student = new Student();
		try {

			student = studentMapper.selectInfoByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return student;
		}

	}

	@SuppressWarnings("finally")
	public Student findStudentByStudId(Integer studId) {
		Student student = new Student();
		try {
			student = studentMapper.selectByPrimaryKey(studId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return student;
		}
	}

	@SuppressWarnings("finally")
	public List<Student> selectByClassId(Integer classId) {
		List<Student> student = new ArrayList<Student>();
		try {
			student = studentMapper.selectByClassId(classId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return student;
		}
	}

	@SuppressWarnings("finally")
	public Student findStudentByStuId(int studId) {

		Student student = new Student();
		try {

			student = studentMapper.selectByPrimaryKey(studId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return student;
		}
	}

	@SuppressWarnings("finally")
	public List<Student> selectAllStuInfo() {

		List<Student> student = new ArrayList<Student>();
		try {
			student = studentMapper.selectAllStuInfo();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return student;
		}
	}

	@SuppressWarnings("finally")
	public List<Student> selectListByUserId(Integer userId) {
		List<Student> student = new ArrayList<Student>();
		try {
			student = studentMapper.selectByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return student;
		}

	}

	@SuppressWarnings("finally")
	public List<Student> selectinfoByinstUserId(Integer userId) {
		List<Student> student = new ArrayList<Student>();
		try {
			student = studentMapper.selectInfoByinstUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return student;
		}

	}

	@SuppressWarnings("finally")
	public List<Student> selectByinstId(Integer instId) {// wj
		List<Student> student = new ArrayList<Student>();
		try {
			student = studentMapper.selectByinstId(instId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return student;
		}

	}

	@SuppressWarnings("finally")
	public List<Student> selectAllstud() {
		List<Student> student = new ArrayList<Student>();
		try {
			student = studentMapper.selectAllstud();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return student;
		}

	}

	@SuppressWarnings("finally")
	public Student findStudentByUserId(Integer userId) {
		Student student = new Student();
		try {
			student = studentMapper.findStudentByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return student;
		}

	}

	/**
	 * Author:shaozhou
	 */
	@SuppressWarnings("finally")
	public List<Student> selectStudentByUserType(User user) {
		List<Student> list = new ArrayList<Student>();
		try {
			int userType = user.getUserType();
			if (userType == 2) {
			
				list = studentMapper.selectAllStuInfoByinstUserId(user
						.getUserId());
			} else if (userType == 3 || userType == 4 || userType == 5) {
				list = studentMapper.selectAllStuInfoByinstId(user
						.getUserInstid());
			} else if (userType == 6) {
				list = studentMapper.selectAllStuInfo();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return list;
		}
	}

	/**
	 * Author:chenwenhui
	 */
	@SuppressWarnings("finally")
	public List<Student> selectStudentByAll(Studentbasiinfo studentbasiinfo) {
		List<Student> list = new ArrayList<Student>();
		try {
			list = studentMapper.selectAllStuInfoByAll(studentbasiinfo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return list;
		}
	}

	/**
	 * Author:pengyan
	 */
	@SuppressWarnings("finally")
	public List<Studentbasiinfo> selectStudentByAll2(
			Studentbasiinfo studentbasiinfo) {
		List<Studentbasiinfo> list = new ArrayList<Studentbasiinfo>();
		try {
			list = studentMapper
					.selectAllStuInfoByStudentbasiinfo(studentbasiinfo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return list;
		}
	}

	@SuppressWarnings("finally")
	public Student findStudentByIDnumber(String studNumber) {
		Student student = new Student();
		try {
			student = studentMapper.selectByIDnumber(studNumber);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return student;
		}
	}

	/**
	 * Author:pengyan
	 */
	@SuppressWarnings("finally")
	public List<Student> readStudentByStudIdNumber(String key) {
		List<Student> student = new ArrayList<Student>();
		try {
			student = studentMapper.selectByStudIdNumber(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return student;
		}
	}

	@SuppressWarnings("finally")
	public List<Student> selectinfoByinstUserId1(Integer userId) {
		List<Student> student = new ArrayList<Student>();
		try {
			student = studentMapper.selectInfoByinstUserId1(userId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return student;
		}

	}

	@SuppressWarnings("finally")
	public List<Student> selectByinstId1(Integer instId) {// wj
		List<Student> student = new ArrayList<Student>();
		try {
			student = studentMapper.selectByinstId1(instId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return student;
		}

	}

	@SuppressWarnings("finally")
	public List<Student> selectAllstud1() {
		List<Student> student = new ArrayList<Student>();
		try {
			student = studentMapper.selectAllstud1();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return student;
		}

	}

	/**
	 * Author:pengyan
	 */
	@SuppressWarnings("finally")
	public List<Student> findStudentByStuName(String stuName) {
		List<Student> student = null;
		try {
			student = new ArrayList<Student>();
			student = studentMapper.selectByStuName(stuName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return student;
		}
	}

	/**
	 * Author:pengyan
	 */
	@SuppressWarnings("finally")
	public List<StudentTjModel> findStuCountInfo(User user) {
		List<StudentTjModel> studentTjModels = new ArrayList<StudentTjModel>();
		List<Institution> institutions = new ArrayList<Institution>();
		List<Major> major = new ArrayList<Major>();
		List<Studentclass> Class = new ArrayList<Studentclass>();
		try {
			if (user.getUserType() == 2) {
				Class =	studentclassMapper.selectByInstId(instructorMapper.selectByUserId(user.getUserId()).getInstId());
				System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBB"+Class.get(0).getClassName());
				for (int i = 0; i < Class.size(); i++) {
					StudentTjModel studentTjModel = new StudentTjModel();
					List<Student> allStudents = studentMapper.selectByClassId(Class.get(i).getClassId());
					Studentbasiinfo studentbasiinfo = new Studentbasiinfo();
					studentbasiinfo.setInstId(0);
					studentbasiinfo.setMajrId(0);
					studentbasiinfo.setClassId(Class.get(i).getClassId());
					studentbasiinfo.setStudentSex(0);
					studentbasiinfo.setStudentNation("汉族");
					List<Student> list1 = studentMapper
							.selectAllStuInfoByAll(studentbasiinfo);
					// 汉族人数

					Studentbasiinfo studentbasiinfo2 = new Studentbasiinfo();
					studentbasiinfo2.setInstId(0);
					studentbasiinfo2.setMajrId(0);
					studentbasiinfo2.setClassId(Class.get(i).getClassId());
					studentbasiinfo2.setStudentSex(1);
					studentbasiinfo2.setStudentNation("全部");
					List<Student> list2 = studentMapper
							.selectAllStuInfoByAll(studentbasiinfo2);
					// 男生人数
					studentTjModel.setInstid(Class.get(i).getClassId());
					studentTjModel.setName(Class.get(i).getClassName());
					studentTjModel.setSum(allStudents.size());
					studentTjModel.setManSum(list2.size());
					studentTjModel.setWomenSum(allStudents.size()
							- list2.size());
					studentTjModel.setMinNation(allStudents.size()
							- list1.size());
					studentTjModel.setHanNation(list1.size());
					studentTjModels.add(studentTjModel);
				}

			}
			if (user.getUserType() == 3 || user.getUserType() == 4
					|| user.getUserType() == 5) {
				major = majorMapper.selectByInstId(user.getUserInstid());
				for (int i = 0; i < major.size(); i++) {
					StudentTjModel studentTjModel = new StudentTjModel();
					List<Student> allStudents = studentMapper.selectByMajorId(major.get(i).getMajrId());
					Studentbasiinfo studentbasiinfo = new Studentbasiinfo();
					studentbasiinfo.setInstId(user.getUserInstid());
					studentbasiinfo.setMajrId(major.get(i).getMajrId());
					studentbasiinfo.setClassId(0);
					studentbasiinfo.setStudentSex(0);
					studentbasiinfo.setStudentNation("汉族");
					List<Student> list1 = studentMapper
							.selectAllStuInfoByAll(studentbasiinfo);
					// 汉族人数

					Studentbasiinfo studentbasiinfo2 = new Studentbasiinfo();
					studentbasiinfo2.setInstId(user.getUserInstid());
					studentbasiinfo2.setMajrId(major.get(i).getMajrId());
					studentbasiinfo2.setClassId(0);
					studentbasiinfo2.setStudentSex(1);
					studentbasiinfo2.setStudentNation("全部");
					List<Student> list2 = studentMapper
							.selectAllStuInfoByAll(studentbasiinfo2);
					// 男生人数
					studentTjModel.setInstid(major.get(i).getMajrId());
					studentTjModel.setName(major.get(i).getMajrName());
					studentTjModel.setSum(allStudents.size());
					studentTjModel.setManSum(list2.size());
					studentTjModel.setWomenSum(allStudents.size()
							- list2.size());
					studentTjModel.setMinNation(allStudents.size()
							- list1.size());
					studentTjModel.setHanNation(list1.size());
					studentTjModels.add(studentTjModel);

				}

			}
			if (user.getUserType() == 6) {
				institutions = institutionMapper.selectAllInstitutions();// 找到所有的学院
				for (int i = 0; i < institutions.size(); ++i) {
					StudentTjModel studentTjModel = new StudentTjModel();
					List<Student> allStudents = studentMapper
							.selectAllStuInfoByinstId(institutions.get(i)
									.getInstId());
					Studentbasiinfo studentbasiinfo = new Studentbasiinfo();
					studentbasiinfo.setInstId(institutions.get(i).getInstId());
					studentbasiinfo.setMajrId(0);
					studentbasiinfo.setClassId(0);
					studentbasiinfo.setStudentSex(0);
					studentbasiinfo.setStudentNation("汉族");
					List<Student> list1 = studentMapper
							.selectAllStuInfoByAll(studentbasiinfo);
					// 汉族人数

					Studentbasiinfo studentbasiinfo2 = new Studentbasiinfo();
					studentbasiinfo2.setInstId(institutions.get(i).getInstId());
					studentbasiinfo2.setMajrId(0);
					studentbasiinfo2.setClassId(0);
					studentbasiinfo2.setStudentSex(1);
					studentbasiinfo2.setStudentNation("全部");
					List<Student> list2 = studentMapper
							.selectAllStuInfoByAll(studentbasiinfo2);
					// 男生人数
					studentTjModel.setInstid(institutions.get(i).getInstId());
					studentTjModel.setName(institutions.get(i).getInstName());
					studentTjModel.setSum(allStudents.size());
					studentTjModel.setManSum(list2.size());
					studentTjModel.setWomenSum(allStudents.size()
							- list2.size());
					studentTjModel.setMinNation(allStudents.size()
							- list1.size());
					studentTjModel.setHanNation(list1.size());
					studentTjModels.add(studentTjModel);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (studentTjModels.size() <= 0)
				studentTjModels = null;
			return studentTjModels;
		}

	}

    @SuppressWarnings("finally")//通过学院Id查找所有的学生
    public List<Student> findAllStudentByInstId(int colleageId) {
        List<Student> student = new ArrayList<Student>();
        try{
            student=studentMapper.selectAllStuInfoByinstId(colleageId);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            return student;
        }
    }

    @SuppressWarnings("finally")
    public List<Student> findAllStudentByMajorId(int majorId) {
        List<Student> student = new ArrayList<Student>();
        try {
            student = studentMapper.selectOneMajor(majorId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return student;
        }
    }
    
    @SuppressWarnings("finally")
	public List<Studentbasiinfo> selectStudentInfoByUserType(User user) {
    	List<Studentbasiinfo> list = new ArrayList<Studentbasiinfo>();
		try{
			list = studentMapper.selectAllStuInfoByInstUserId(user.getUserId());
		}catch (Exception e) {
            e.printStackTrace();
        } finally {
            return list;
        }		
	}
}
