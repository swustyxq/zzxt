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
import swust.edu.cn.zzxt.model.Institution;
import swust.edu.cn.zzxt.model.Instructor;
import swust.edu.cn.zzxt.model.Major;
import swust.edu.cn.zzxt.model.Student;
import swust.edu.cn.zzxt.model.Studentclass;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.selfmodel.Studentbasiinfo;
import swust.edu.cn.zzxt.service.StudentbasiinfoService;

@Service("studentbasiinfoService")
public class StudentbasiinfoServiceImpl implements StudentbasiinfoService{
	private InstructorMapper instructorMapper;
	private StudentclassMapper studentclassMapper;
	private MajorMapper majorMapper;
	private InstitutionMapper institutionMapper;
	private StudentMapper studentMapper;
	public InstructorMapper getInstructorMapper() {
		return instructorMapper;
	}
	@Autowired
	public void setInstructorMapper(InstructorMapper instructorMapper) {
		this.instructorMapper = instructorMapper;
	}
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
	public InstitutionMapper getInstitutionMapper() {
		return institutionMapper;
	}
	@Autowired
	public void setInstitutionMapper(InstitutionMapper institutionMapper) {
		this.institutionMapper = institutionMapper;
	}
	public StudentMapper getStudentMapper() {
		return studentMapper;
	}
	@Autowired
	public void setStudentMapper(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}
	@SuppressWarnings("finally")
	public List<Studentbasiinfo> findbasiinfoByinstUser(User instuser)
	{
		List<Studentbasiinfo> list = new ArrayList<Studentbasiinfo>();
		try {
			Instructor instructor = instructorMapper.selectByUserId(instuser.getUserId());
			Institution institution = institutionMapper.selectByPrimaryKey(instuser.getUserInstid());
			List<Studentclass> list2 = studentclassMapper.selectByInstId(instructor.getInstId());
			for(int i=0;i<list2.size();i++)
			{
				List<Student> list3 = studentMapper.selectByClassId(list2.get(i).getClassId());
				Major major = majorMapper.selectByPrimaryKey(list2.get(i).getClassMajrid());
				for(int j=0;j<list3.size();j++)
				{
					Studentbasiinfo studentbasiinfo = new Studentbasiinfo();
					studentbasiinfo.setStudentId(list3.get(j).getStudId());
					studentbasiinfo.setStudentIDNumber(list3.get(j).getStudIdnumber());
					studentbasiinfo.setStudentName(list3.get(j).getStudName());
					studentbasiinfo.setStudentNumber(list3.get(j).getStudNumber());
					studentbasiinfo.setClassName(list2.get(i).getClassName());
					studentbasiinfo.setClassShortName(list2.get(i).getClassShortname());
					studentbasiinfo.setInstName(institution.getInstName());
					studentbasiinfo.setInstShortName(institution.getInstShortname());
					studentbasiinfo.setMajrName(major.getMajrName());
					studentbasiinfo.setMajrShortName(major.getMajrShortname());
					studentbasiinfo.setClassId(list2.get(i).getClassId());
					studentbasiinfo.setMajrId(major.getMajrId());
					studentbasiinfo.setInstId(institution.getInstId());
					list.add(studentbasiinfo);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
		return list;
		}
	}
	@SuppressWarnings("finally")
	public List<Studentbasiinfo> findbasiinfoByStudUser(User user)
	{
		List<Studentbasiinfo> list= new ArrayList<Studentbasiinfo>();
		try {
			Student student = new Student();
			student = studentMapper.selectInfoByUserId(user.getUserId());
			Studentclass studentclass = studentclassMapper.selectByPrimaryKey(student.getStudClassid());
			Major major = majorMapper.selectByPrimaryKey(studentclass.getClassMajrid());
			Institution institution = institutionMapper.selectByPrimaryKey(major.getMajrInstid());
			Studentbasiinfo studentbasiinfo = new Studentbasiinfo();
			studentbasiinfo.setInstName(institution.getInstName());
			studentbasiinfo.setInstShortName(institution.getInstShortname());
			studentbasiinfo.setMajrName(major.getMajrName());
			studentbasiinfo.setMajrShortName(major.getMajrShortname());
			studentbasiinfo.setClassName(studentclass.getClassName());
			studentbasiinfo.setClassShortName(studentclass.getClassShortname());
			studentbasiinfo.setStudentId(student.getStudId());
			studentbasiinfo.setStudentIDNumber(student.getStudIdnumber());
			studentbasiinfo.setStudentName(student.getStudName());
			studentbasiinfo.setStudentNumber(student.getStudNumber());
			studentbasiinfo.setClassId(studentclass.getClassId());
			studentbasiinfo.setMajrId(major.getMajrId());
			studentbasiinfo.setInstId(institution.getInstId());
			list.add(studentbasiinfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
		return list;
		}
	}
	@SuppressWarnings("finally")
	public List<Studentbasiinfo> findbasiinfoByOtherUser(User user)
	{
		List<Studentbasiinfo> list= new ArrayList<Studentbasiinfo>();
		try {
			Institution institution = institutionMapper.selectByPrimaryKey(user.getUserInstid());
			List<Major> list1 = majorMapper.selectByInstId(institution.getInstId());
			for(int i=0;i<list1.size();i++)
			{
				List<Studentclass> list2 = studentclassMapper.selectByMajorId(list1.get(i).getMajrId());
				for(int j=0;j<list2.size();j++)
				{
					List<Student> list3 = studentMapper.selectByClassId(list2.get(j).getClassId());
					for(int k=0;k<list3.size();k++)
					{
						Studentbasiinfo studentbasiinfo = new Studentbasiinfo();
						studentbasiinfo.setInstName(institution.getInstName());
						studentbasiinfo.setInstShortName(institution.getInstShortname());
						studentbasiinfo.setMajrName(list1.get(i).getMajrName());
						studentbasiinfo.setMajrShortName(list1.get(i).getMajrShortname());
						studentbasiinfo.setClassName(list2.get(j).getClassName());
						studentbasiinfo.setClassShortName(list2.get(j).getClassShortname());
						studentbasiinfo.setStudentId(list3.get(k).getStudId());
						studentbasiinfo.setStudentIDNumber(list3.get(k).getStudIdnumber());
						studentbasiinfo.setStudentName(list3.get(k).getStudName());
						studentbasiinfo.setStudentNumber(list3.get(k).getStudNumber());
						studentbasiinfo.setClassId(list2.get(j).getClassId());
						studentbasiinfo.setMajrId(list1.get(i).getMajrId());
						studentbasiinfo.setInstId(institution.getInstId());
						list.add(studentbasiinfo);
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
		return list;
		}
	}
}
