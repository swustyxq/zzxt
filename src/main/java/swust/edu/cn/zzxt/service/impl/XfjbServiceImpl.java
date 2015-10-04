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
import swust.edu.cn.zzxt.dao.XfjbMapper;
import swust.edu.cn.zzxt.model.Institution;
import swust.edu.cn.zzxt.model.Major;
import swust.edu.cn.zzxt.model.Student;
import swust.edu.cn.zzxt.model.Studentclass;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.model.Xfjb;
import swust.edu.cn.zzxt.selfmodel.StudentTjModel;
import swust.edu.cn.zzxt.selfmodel.XfjbListModel;
import swust.edu.cn.zzxt.selfmodel.XfjbTjModel;
import swust.edu.cn.zzxt.service.XfjbService;
@Service("xfjbService")
public class XfjbServiceImpl implements XfjbService {
	private MajorMapper majorMapper;
	private StudentclassMapper studentclassMapper;
	private InstructorMapper instructorMapper;
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

	private XfjbMapper xfjbMapper;
	private  StudentMapper studentMapper;

	public StudentMapper getStudentMapper() {
		return studentMapper;
	}
    @Autowired
	public void setStudentMapper(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}

	public XfjbMapper getXfjbMapper() {
		return xfjbMapper;
	}

    @Autowired
	public void setXfjbMapper(XfjbMapper xfjbMapper) {
		this.xfjbMapper = xfjbMapper;
	}

    /**
	 * Author:pengyan
	 */
    @SuppressWarnings("finally")
	public List<XfjbListModel> findAllXfjbList(User user) {
		List<XfjbListModel> list =null;
    	try {
    		list =new ArrayList<XfjbListModel>();
    		int userType=user.getUserType();
    		if(userType ==1){
    		   Student student =new Student();
    			student = studentMapper.findStudentByUserId(user.getUserId());
    			list = xfjbMapper.findJbListByStudentId(student.getStudId());
    		}
    		else if (userType==2) {
				list=xfjbMapper.findAllXfjbListByinstUserId(user.getUserId());
			}else if (userType==3 || userType==4 || userType==5) {
				list=xfjbMapper.findAllXfjbListByinstId(user.getUserInstid());
			}else if (userType==6) {
				list = xfjbMapper.findAllXfjbListByAll();
			}
    		if(list.size()<=0)
    		{
    			list=null;
    		}
    		
    	}catch (Exception e) {
            e.printStackTrace();
        }finally{
            return list;
        }
		// TODO Auto-generated method stub
	}

    /**
	 * Author:pengyan
	 */
    @SuppressWarnings("finally")
	public List<XfjbListModel> selectJbByConditions(XfjbListModel xfjbListModel) {
    	List<XfjbListModel> list =null;
    	try {
    		list =new ArrayList<XfjbListModel>();
   		list = xfjbMapper.findJbByConditions(xfjbListModel);
    		if(list.size()<=0)
    			list=null;
    	}catch (Exception e) {
            e.printStackTrace();
        }finally{
            return list;
        }
	}
    /**
 	 * Author:pengyan
 	 */
     @SuppressWarnings("finally")
	public Xfjb findjbInfoByStuId(int studId) {
		Xfjb list =null;
		try{
			list =new Xfjb();
			list = xfjbMapper.findXfjbInfoByStuId(studId);
		}
		catch (Exception e) {
            e.printStackTrace();
        }finally{
            return list;
        }
	}
     /**
  	 * Author:pengyan
  	 */
      @SuppressWarnings("finally")
	public List<XfjbTjModel> findXfjbCountInfo(User user) {
		 List<XfjbTjModel> xfjbTjModels = new ArrayList<XfjbTjModel>();
		List<Institution> institutions = new ArrayList<Institution>();
		List<Major> major = new ArrayList<Major>();
		List<Studentclass> Class = new ArrayList<Studentclass>();
		try{
			
			if (user.getUserType() == 2) {
				   int 	amount ;
					Class =	studentclassMapper.selectByInstId(instructorMapper.selectByUserId(user.getUserId()).getInstId());
				for( int i=0;i<Class.size();i++){
					amount=0;
					XfjbTjModel xfjbTjModel = new XfjbTjModel();
					List<Student> students = studentMapper.selectByClassId(Class.get(i).getClassId());
					List<Xfjb> xfjbList =new ArrayList<Xfjb>();
					xfjbList = xfjbMapper.findXfjbListByClassId(Class.get(i).getClassId());
					if(xfjbList !=null && xfjbList.size()>0){
					
						for(int j=0;j<xfjbList.size();j++){
							amount += Integer.parseInt(xfjbList.get(j).getXfjbAmount());
						}	
					}
					xfjbTjModel.setInstid(Class.get(i).getClassId());
					xfjbTjModel.setName(Class.get(i).getClassName());
					xfjbTjModel.setSum(xfjbList.size());
					xfjbTjModel.setStudentsum(students.size());
					xfjbTjModel.setAmount(amount);
					xfjbTjModels.add(xfjbTjModel);
				}
				
			}
			if (user.getUserType() == 3 || user.getUserType() == 4
					|| user.getUserType() == 5) {
				  int 	amount ;
				major = majorMapper.selectByInstId(user.getUserInstid());
				for(int i=0;i<major.size();i++){
					amount=0;
					XfjbTjModel xfjbTjModel = new XfjbTjModel();
					List<Student>students = studentMapper.selectByMajorId(major.get(i).getMajrId());
					List<Xfjb> xfjbList =new ArrayList<Xfjb>();
					xfjbList=xfjbMapper.findXfjbListByMajorId(major.get(i).getMajrId());
					if(xfjbList !=null && xfjbList.size()>0){
						
						for(int j=0;j<xfjbList.size();j++){
							amount += Integer.parseInt(xfjbList.get(j).getXfjbAmount());
						}	
					}
					xfjbTjModel.setInstid(major.get(i).getMajrId());
					xfjbTjModel.setName(major.get(i).getMajrName());
					xfjbTjModel.setSum(xfjbList.size());
					xfjbTjModel.setStudentsum(students.size());
					xfjbTjModel.setAmount(amount);
					xfjbTjModels.add(xfjbTjModel);
				}
				
			}
			if (user.getUserType() == 6) {
				  int 	amount ;
				institutions = institutionMapper.selectAllInstitutions();// 找到所有的学院
				for(int i=0;i<institutions.size();i++){
					amount=0;
					XfjbTjModel xfjbTjModel = new XfjbTjModel();
					System.out.println(institutions.get(i)
							.getInstId());
					List<Student> students = studentMapper
							.selectAllStuInfoByinstId(institutions.get(i)
									.getInstId());
					List<Xfjb> xfjbList =new ArrayList<Xfjb>();
					xfjbList = xfjbMapper.findXfjbListByInsId(institutions.get(i)
							.getInstId());
					if(xfjbList !=null && xfjbList.size()>0){
						
						for(int j=0;j<xfjbList.size();j++){
							amount += Integer.parseInt(xfjbList.get(j).getXfjbAmount());
						}	
					}
					xfjbTjModel.setInstid(institutions.get(i).getInstId());
					xfjbTjModel.setName(institutions.get(i).getInstName());
					xfjbTjModel.setSum(xfjbList.size());
					xfjbTjModel.setStudentsum(students.size());
					xfjbTjModel.setAmount(amount);
					xfjbTjModels.add(xfjbTjModel);			
				}
			}
		
		}
		catch (Exception e) {
            e.printStackTrace();
        }finally{
            return xfjbTjModels;
        }
	}
}
