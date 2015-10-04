package swust.edu.cn.zzxt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swust.edu.cn.zzxt.dao.InstitutionMapper;
import swust.edu.cn.zzxt.dao.InstructorMapper;
import swust.edu.cn.zzxt.dao.MajorMapper;
import swust.edu.cn.zzxt.dao.PgsglMapper;
import swust.edu.cn.zzxt.dao.RoleMapper;
import swust.edu.cn.zzxt.dao.StudentMapper;
import swust.edu.cn.zzxt.dao.StudentclassMapper;
import swust.edu.cn.zzxt.model.Institution;
import swust.edu.cn.zzxt.model.Major;
import swust.edu.cn.zzxt.model.PgsglWithBLOBs;
import swust.edu.cn.zzxt.model.Student;
import swust.edu.cn.zzxt.model.Studentclass;
import swust.edu.cn.zzxt.selfmodel.Pksglbasicinfo;
import swust.edu.cn.zzxt.selfmodel.Pksgltongjiinfo;
import swust.edu.cn.zzxt.service.PgsglService;

@Service("pgsglService")
public class PgsglServiceImpl implements PgsglService {
	PgsglMapper pgsglMapper;
	RoleMapper roleMapper;
	InstructorMapper instructorMapper;
	StudentclassMapper studentclassMapper;
	StudentMapper studentMapper;
	InstitutionMapper institutionMapper;
	MajorMapper majorMapper;
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
	public InstructorMapper getInstructorMapper() {
		return instructorMapper;
	}
	@Autowired
	public void setInstructorMapper(InstructorMapper instructorMapper) {
		this.instructorMapper = instructorMapper;
	}
	public StudentMapper getStudentMapper() {
		return studentMapper;
	}
	@Autowired
	public void setStudentMapper(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}
	public StudentclassMapper getStudentclassMapper() {
		return studentclassMapper;
	}
	@Autowired
	public void setStudentclassMapper(StudentclassMapper studentclassMapper) {
		this.studentclassMapper = studentclassMapper;
	}
	
	public RoleMapper getRoleMapper() {
		return roleMapper;
	}
	@Autowired
	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}
	public PgsglMapper getPgsglMapper() {
		return pgsglMapper;
	}
	@Autowired
	public void setPgsglMapper(PgsglMapper pgsglMapper) {
		this.pgsglMapper = pgsglMapper;
	}

	@SuppressWarnings("finally")
	public PgsglWithBLOBs findPkByStudId(Integer studId) {
		PgsglWithBLOBs pgsgl = null;
		try {
			pgsgl = new PgsglWithBLOBs();
			pgsgl = pgsglMapper.selectByStudId(studId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return pgsgl;
		}
	}

	@SuppressWarnings("finally")
	public PgsglWithBLOBs addOneRecord(PgsglWithBLOBs pgsgl1) {
		try {
			System.out.println("enter Impl is right!");
			pgsglMapper.insertSelective(pgsgl1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return pgsgl1;
		}
	}
	@SuppressWarnings("finally")
	public PgsglWithBLOBs update(PgsglWithBLOBs pgsgl){
		try {
			pgsglMapper.updateByPrimaryKeyWithBLOBs(pgsgl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
		return pgsgl;
		}
	}
	@SuppressWarnings("finally")
	public Pksglbasicinfo findPksgbasiinfoByStudentId(Integer studId)
	{
		Pksglbasicinfo pksglbasicinfo=null;
		try {
			pksglbasicinfo = pgsglMapper.selectPksgbasiinfoByStudId(studId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		return pksglbasicinfo;
		}
	}
	@SuppressWarnings("finally")
	public List<Pksglbasicinfo> findPksgbasiinfoByInstId(Integer instId)
	{
		List<Pksglbasicinfo> pksglbasicinfo=null;
		try {
			pksglbasicinfo = new ArrayList<Pksglbasicinfo>();
			pksglbasicinfo = pgsglMapper.selectPksgbasiinfoByInstId(instId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		return pksglbasicinfo;
		}
	}
	@SuppressWarnings("finally")
	public List<Pksglbasicinfo> findPksgbasiinfoByClassId(Integer classId)
	{
		List<Pksglbasicinfo> pksglbasicinfo=null;
		try {
			pksglbasicinfo = new ArrayList<Pksglbasicinfo>();
			pksglbasicinfo = pgsglMapper.selectPksgbasiinfoByClassId(classId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		return pksglbasicinfo;
		}
	}
	@SuppressWarnings("finally")
	public List<Pksglbasicinfo> findPksgbasiinfoByMajrId(Integer majrId)
	{
		List<Pksglbasicinfo> pksglbasicinfo=null;
		try {
			pksglbasicinfo = new ArrayList<Pksglbasicinfo>();
			pksglbasicinfo = pgsglMapper.selectPksgbasiinfoByMajrId(majrId);
			System.out.println("hhh"+pksglbasicinfo.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		return pksglbasicinfo;
		}
	}
	@SuppressWarnings("finally")
	public List<Pksglbasicinfo> findAllPksgbasiinfo()
	{
		List<Pksglbasicinfo> pksglbasicinfo=null;
		try {
			pksglbasicinfo = new ArrayList<Pksglbasicinfo>();
			pksglbasicinfo = pgsglMapper.selectAllPksgbasiinfo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		return pksglbasicinfo;
		}
	}
	//统计所有
	@SuppressWarnings("finally")
	public List<Pksgltongjiinfo> findAlltongjiinfo()
	{
		List<Pksgltongjiinfo> pksgltongjiinfo=null;
		try {
			pksgltongjiinfo = new ArrayList<Pksgltongjiinfo>();
			List<Institution> institution = institutionMapper.selectAllInstitutions();

			for(int i=0;i<institution.size();i++)
			{
				int studSumNum=0;
				int studApplyNum=0;
				int yibanPkStudNum=0;
				int pinkunStudNum=0;
				int teshuPkstudNum=0;
				int bupinkunNum=0;
				int allPkNum=0;
				String instName=institution.get(i).getInstName();
				int instId=institution.get(i).getInstId();
				List<Student> student = new ArrayList<Student>();
				student = studentMapper.selectAllStuInfoByinstId(instId);
				studSumNum = student.size();
				List<Pksglbasicinfo> pksglbasicinfo = pgsglMapper.selectPksgbasiinfoByInstId(institution.get(i).getInstId());
				for(int j=0;j<pksglbasicinfo.size();j++)
				{
					studApplyNum++;
					if(pksglbasicinfo.get(j).getState()==1)
					{
						allPkNum++;
						if(pksglbasicinfo.get(j).getPksgRank()!=null)
						{
							if(pksglbasicinfo.get(j).getPksgRank().equals("一般贫困")){
								yibanPkStudNum++;
							}else if(pksglbasicinfo.get(j).getPksgRank().equals("贫困")){
								pinkunStudNum++;
							}else if(pksglbasicinfo.get(j).getPksgRank().equals("特殊贫困")){
								teshuPkstudNum++;
							}else if(pksglbasicinfo.get(j).getPksgRank().equals("不贫困")){
								bupinkunNum++;
							}
						}
					}
				}
				Pksgltongjiinfo pksgltongjiinfo1 = new Pksgltongjiinfo();
				pksgltongjiinfo1.setInstId(instId);
				pksgltongjiinfo1.setInstName(instName);
				pksgltongjiinfo1.setPinkunStudNum(pinkunStudNum);
				pksgltongjiinfo1.setStudApplyNum(studApplyNum);
				pksgltongjiinfo1.setStudSumNum(studSumNum);
				pksgltongjiinfo1.setTeshuPkstudNum(teshuPkstudNum);
				pksgltongjiinfo1.setYibanPkStudNum(yibanPkStudNum);
				pksgltongjiinfo1.setTeshuPkstudNum(teshuPkstudNum);
				pksgltongjiinfo1.setAllPkNum(allPkNum);
				pksgltongjiinfo1.setBupinkunNum(bupinkunNum);
				pksgltongjiinfo.add(pksgltongjiinfo1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		return pksgltongjiinfo;
		}
	}
	//按班级统计本学院学生申请情况
	@SuppressWarnings("finally")
	public List<Pksgltongjiinfo> findAlltongjiinfoByinstId(Integer userInstid)
	{
		List<Pksgltongjiinfo> pksgltongjiinfo=null;
		try {
			pksgltongjiinfo = new ArrayList<Pksgltongjiinfo>();
			//查询班级
			Institution institution = institutionMapper.selectByPrimaryKey(userInstid);
			List<Major> major = majorMapper.selectByInstId(userInstid);
			List<Studentclass> Studentclass = new ArrayList<Studentclass>();
			for(int i=0;i<major.size();i++)
			{
				List<Studentclass> Studentclass1 = studentclassMapper.selectByMajorId(major.get(i).getMajrId());
				Studentclass.addAll(Studentclass1);
			}
			//根据班级统计
			for(int i=0;i<Studentclass.size();i++)
			{
				
				int studSumNum=0;
				int studApplyNum=0;
				int yibanPkStudNum=0;
				int pinkunStudNum=0;
				int teshuPkstudNum=0;
				int bupinkunNum=0;
				int allPkNum=0;
				String instName = institution.getInstShortname();
				int instId = institution.getInstId();
				Major major1 =  majorMapper.selectByPrimaryKey(Studentclass.get(i).getClassMajrid());
				int majorId =major1.getMajrId();
				String majorName = major1.getMajrName();
				String className=Studentclass.get(i).getClassName();
				int classId=Studentclass.get(i).getClassId();
				List<Student> student = new ArrayList<Student>();
				student = studentMapper.selectByClassId(Studentclass.get(i).getClassId());
				studSumNum = student.size();
				List<Pksglbasicinfo> pksglbasicinfo = pgsglMapper.selectPksgbasiinfoByClassId(Studentclass.get(i).getClassId());
				for(int j=0;j<pksglbasicinfo.size();j++)
				{
					studApplyNum++;
					if(pksglbasicinfo.get(j).getState()==1)
					{
						allPkNum++;
						if(pksglbasicinfo.get(j).getPksgRank()!=null)
						{
							if(pksglbasicinfo.get(j).getPksgRank().equals("一般贫困")){
								yibanPkStudNum++;
							}else if(pksglbasicinfo.get(j).getPksgRank().equals("贫困")){
								pinkunStudNum++;
							}else if(pksglbasicinfo.get(j).getPksgRank().equals("特殊贫困")){
								teshuPkstudNum++;
							}else if(pksglbasicinfo.get(j).getPksgRank().equals("不贫困")){
								bupinkunNum++;
							}
						}
					}
				}
				Pksgltongjiinfo pksgltongjiinfo1 = new Pksgltongjiinfo();
				pksgltongjiinfo1.setMajrId(majorId);
				pksgltongjiinfo1.setMajrName(majorName);
				pksgltongjiinfo1.setStudClassId(classId);
				pksgltongjiinfo1.setStudClassName(className);
				pksgltongjiinfo1.setInstId(instId);
				pksgltongjiinfo1.setInstName(instName);
				pksgltongjiinfo1.setPinkunStudNum(pinkunStudNum);
				pksgltongjiinfo1.setStudApplyNum(studApplyNum);
				pksgltongjiinfo1.setStudSumNum(studSumNum);
				pksgltongjiinfo1.setTeshuPkstudNum(teshuPkstudNum);
				pksgltongjiinfo1.setYibanPkStudNum(yibanPkStudNum);
				pksgltongjiinfo1.setTeshuPkstudNum(teshuPkstudNum);
				pksgltongjiinfo1.setAllPkNum(allPkNum);
				pksgltongjiinfo1.setBupinkunNum(bupinkunNum);
				pksgltongjiinfo.add(pksgltongjiinfo1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return pksgltongjiinfo;
		}
	}
		//按专业统计全学院学生申请情况
		@SuppressWarnings("finally")
		public List<Pksgltongjiinfo> findAllmajrtongjiinfoByinstId(Integer userInstid)
		{
			List<Pksgltongjiinfo> pksgltongjiinfo=null;
			try {
				pksgltongjiinfo = new ArrayList<Pksgltongjiinfo>();
				//查询专业
				Institution institution = institutionMapper.selectByPrimaryKey(userInstid);
				List<Major> major = majorMapper.selectByInstId(userInstid);
				//根据专业统计
				for(int i=0;i<major.size();i++)
				{
					int studSumNum=0;
					int studApplyNum=0;
					int yibanPkStudNum=0;
					int pinkunStudNum=0;
					int teshuPkstudNum=0;
					int bupinkunNum=0;
					int allPkNum=0;
					String instName = institution.getInstShortname();
					int instId = institution.getInstId();
					int majorId =major.get(i).getMajrId();
					String majorName = major.get(i).getMajrName();
					for(int j=0;j<major.size();j++)
					{
						List<Studentclass> studentClass1 = studentclassMapper.selectByMajorId(major.get(j).getMajrId());
						for(int k=0;k<studentClass1.size();k++)
						{
							List<Student> student1 = studentMapper.selectByClassId(studentClass1.get(k).getClassId());
							studSumNum+=student1.size();
						}
					}
					List<Pksglbasicinfo> pksglbasicinfo = pgsglMapper.selectPksgbasiinfoByMajrId(major.get(i).getMajrId());
					for(int j=0;j<pksglbasicinfo.size();j++)
					{
						studApplyNum++;
						if(pksglbasicinfo.get(j).getState()==1)
						{
							if(pksglbasicinfo.get(j).getPksgRank()!=null)
							{
								allPkNum++;
								if(pksglbasicinfo.get(j).getPksgRank().equals("一般贫困")){
									yibanPkStudNum++;
								}else if(pksglbasicinfo.get(j).getPksgRank().equals("贫困")){
									pinkunStudNum++;
								}else if(pksglbasicinfo.get(j).getPksgRank().equals("特殊贫困")){
									teshuPkstudNum++;
								}else if(pksglbasicinfo.get(j).getPksgRank().equals("不贫困")){
									bupinkunNum++;
								}
							}
						}
					}
					Pksgltongjiinfo pksgltongjiinfo1 = new Pksgltongjiinfo();
					pksgltongjiinfo1.setMajrId(majorId);
					pksgltongjiinfo1.setMajrName(majorName);
					pksgltongjiinfo1.setInstId(instId);
					pksgltongjiinfo1.setInstName(instName);
					pksgltongjiinfo1.setPinkunStudNum(pinkunStudNum);
					pksgltongjiinfo1.setStudApplyNum(studApplyNum);
					pksgltongjiinfo1.setStudSumNum(studSumNum);
					pksgltongjiinfo1.setTeshuPkstudNum(teshuPkstudNum);
					pksgltongjiinfo1.setYibanPkStudNum(yibanPkStudNum);
					pksgltongjiinfo1.setTeshuPkstudNum(teshuPkstudNum);
					pksgltongjiinfo1.setAllPkNum(allPkNum);
					pksgltongjiinfo1.setBupinkunNum(bupinkunNum);
					pksgltongjiinfo.add(pksgltongjiinfo1);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				return pksgltongjiinfo;
			}
		}
}
