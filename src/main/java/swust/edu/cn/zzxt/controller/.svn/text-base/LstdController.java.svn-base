package swust.edu.cn.zzxt.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import swust.edu.cn.zzxt.model.Institution;
import swust.edu.cn.zzxt.model.LstdWithBLOBs;
import swust.edu.cn.zzxt.model.Major;
import swust.edu.cn.zzxt.model.Parent;
import swust.edu.cn.zzxt.model.Role;
import swust.edu.cn.zzxt.model.Student;
import swust.edu.cn.zzxt.model.Studentclass;
import swust.edu.cn.zzxt.model.Studentinfo;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.model.Work;
import swust.edu.cn.zzxt.model.Workstepfolw;
import swust.edu.cn.zzxt.selfmodel.CountModal;
import swust.edu.cn.zzxt.selfmodel.LstdListModel;
import swust.edu.cn.zzxt.service.CommonService;
import swust.edu.cn.zzxt.service.InstitutionService;
import swust.edu.cn.zzxt.service.InstructorService;
import swust.edu.cn.zzxt.service.LstdService;
import swust.edu.cn.zzxt.service.MajorService;
import swust.edu.cn.zzxt.service.ParentService;
import swust.edu.cn.zzxt.service.RoleService;
import swust.edu.cn.zzxt.service.StudentService;
import swust.edu.cn.zzxt.service.StudentclassService;
import swust.edu.cn.zzxt.service.StudentinfoService;
import swust.edu.cn.zzxt.service.WorkService;
import swust.edu.cn.zzxt.service.WorkstepfolwService;

@Controller
@RequestMapping("/lstdController")
public class LstdController {
	private StudentService studentService;
	private StudentinfoService studentinfoService;
	private MajorService majorService;
	private InstitutionService institutionService;
	private StudentclassService studentclassService;
	private ParentService parentService;
	private LstdService lstdwithblobsService;
	private InstructorService instructorService;
	private WorkstepfolwService workstepfolwService;
	private RoleService roleService;
	private CommonService commonService;
	private WorkService workService;
	
	public WorkService getWorkService() {
		return workService;
	}
	@Autowired
	public void setWorkService(WorkService workService) {
		this.workService = workService;
	}
	public CommonService getCommonService() {
		return commonService;
	}
	@Autowired
	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}
	public RoleService getRoleService() {
		return roleService;
	}
	@Autowired
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	public WorkstepfolwService getWorkstepfolwService() {
		return workstepfolwService;
	}
	@Autowired
	public void setWorkstepfolwService(WorkstepfolwService workstepfolwService) {
		this.workstepfolwService = workstepfolwService;
	}
	public InstructorService getInstructorService() {
		return instructorService;
	}
	@Autowired
	public void setInstructorService(InstructorService instructorService) {
		this.instructorService = instructorService;
	}
	public LstdService getLstdwithblobsService() {
		return lstdwithblobsService;
	}
	@Autowired
	public void setLstdwithblobsService(LstdService lstdwithblobsService) {
		this.lstdwithblobsService = lstdwithblobsService;
	}
	public ParentService getParentService() {
		return parentService;
	}
	@Autowired
	public void setParentService(ParentService parentService) {
		this.parentService = parentService;
	}
	public StudentclassService getStudentclassService() {
		return studentclassService;
	}
	@Autowired
	public void setStudentclassService(StudentclassService studentclassService) {
		this.studentclassService = studentclassService;
	}
	public InstitutionService getInstitutionService() {
		return institutionService;
	}
	@Autowired
	public void setInstitutionService(InstitutionService institutionService) {
		this.institutionService = institutionService;
	}
	public MajorService getMajorService() {
		return majorService;
	}
	@Autowired
	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}
	public StudentinfoService getStudentinfoService() {
		return studentinfoService;
	}
	@Autowired
	public void setStudentinfoService(StudentinfoService studentinfoService) {
		this.studentinfoService = studentinfoService;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/readInfoByStudNumber")
	public ModelAndView readInfoByStudNumber(Integer studId,String studNumber,HttpServletRequest request,HttpServletResponse response)
			 {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			Student student = new Student();
			Studentinfo studentinfo= new Studentinfo();
			Studentclass studentclass = new Studentclass();
			List<Parent> parent = new ArrayList<Parent>();
			LstdWithBLOBs lstd = new LstdWithBLOBs();
			Workstepfolw workstepfolw = new Workstepfolw();
			List<Role> role = (List<Role>) session.getAttribute("role");
			if(studId == 0){
				if(studNumber.length() == 8){
					student = studentService.obtainStudentByStudNumber(studNumber);//学号
				}else{
					student = studentService.findStudentByIDnumber(studNumber);//身份证号码
				}
			}else{
				student = studentService.findStudentByStudId(studId);
			}
			studentinfo = studentinfoService.selectBystudInfoStudId(student.getStudId());
			studentclass = studentclassService.selectBystudInfoStudId(student.getStudClassid());
			parent = parentService.getParentsByStuid(student.getStudId());
			lstd = lstdwithblobsService.selectByStudId(student.getStudId());
			if(lstd == null){
				workstepfolw = null;
				map.put("workstepfolw", workstepfolw);
				map.put("student", student);
				map.put("studentinfo", studentinfo);
				map.put("studentclass", studentclass);
				map.put("parent", parent);
				map.put("result", Boolean.TRUE);
				map.put("message", "success");
			}else{
				if(lstd.getLstdWsflid() == -1){
					workstepfolw.setWsflRoleid(1000);
				}else{
					workstepfolw = workstepfolwService.findWslfByWslfId(lstd.getLstdWsflid());
				}
				map.put("lstd", lstd);
				map.put("workstepfolw", workstepfolw);
				map.put("user", user);
				map.put("role", role);
				map.put("student", student);
				map.put("studentinfo", studentinfo);
				map.put("studentclass", studentclass);
				map.put("parent", parent);
				map.put("result", Boolean.TRUE);
				map.put("message", "success");
			}
		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
			map.put("message", "输入身份证号码或学号有误！");
			e.printStackTrace();
		} finally {
			view.setAttributesMap(map);
			mav.setView(view);
			return mav;
		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/inputLstdByStudId")
	public ModelAndView inputLstdByStudId(double lstdApplytuition,double lstdApplyaccommodation,
			String lstdLimittime,String lstdLoans,Integer lstdOngoing,String lstdBank,String classopinion,String academyopinion,
			String lstdReturncode,String lstdApplyReason,String lstdPaymentReason,String lstdRepayWay,String lstdDisaster,
			boolean state,Integer studId,String studNumber,HttpServletRequest request,HttpServletResponse response)
	 {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			Integer lstdstate = 0;//学生处审核完成后改变lstd表中的state
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			List<Role> role = new ArrayList<Role>();
			Student student = new Student();
			LstdWithBLOBs lstdwithblobs1 = new LstdWithBLOBs();
			LstdWithBLOBs lstd = new LstdWithBLOBs();
			Workstepfolw workstepfolw = new Workstepfolw();
			role = (List<Role>) session.getAttribute("role");
			int role0 = 0;
			for(int j=0;j<role.size();j++){
				if(role.get(j).getRoleId() == 19){
					role0 = 1;
				}
			}
			System.out.println("@@@@@@@@@@@@@@@@@@role0="+role0);
			if(studId == 0){
        		student = studentService.obtainStudentByStudNumber(studNumber);
        	}else{
        		student = studentService.findStudentByStudId(studId);
        	}
			if(user.getUserType() == 3){//判断用户类型，经办老师
				int workId = 5;
            	int situId = 3;
            	Date lstdClassopiniontime = new Date();
            	Date lstdAcademyopiniontime = null;
            	workstepfolw = workstepfolwService.getWsflIdByWorkidAndSituation(workId, situId);
				lstd = lstdwithblobsService.selectByStudId(student.getStudId());
				System.out.println("@@@@@@@@@@@@@@@classopinion======"+classopinion);
				System.out.println("comein");
				if(state){//submit
					if(lstd != null){
						lstdwithblobs1 = lstdwithblobsService.updateLstdStudId(student.getStudId(),lstd.getLstdWorkid(),workstepfolw.getWsflNextstep(),
						lstdApplytuition,lstdApplyaccommodation,
						lstdLimittime,lstdLoans,classopinion,lstdClassopiniontime,academyopinion,
						lstdOngoing,lstdBank,lstdAcademyopiniontime,lstdReturncode,lstdstate,
						lstdApplyReason,lstdPaymentReason,lstdRepayWay,lstdDisaster);
					}else{
						lstdwithblobs1 = lstdwithblobsService.insertLstdByStudId(student.getStudId(),lstdApplytuition,lstdApplyaccommodation,
								lstdLimittime,lstdLoans,classopinion,academyopinion,
						lstdOngoing,lstdBank,lstdReturncode,workstepfolw.getWsflNextstep(),user.getUserId(),lstdClassopiniontime,
						lstdApplyReason,lstdPaymentReason,lstdRepayWay,lstdDisaster);
					}
				}else{//save
					if(lstd != null){
						lstdwithblobs1 = lstdwithblobsService.updateLstdStudId(student.getStudId(),lstd.getLstdWorkid(),workstepfolw.getWsflId(),
						lstdApplytuition,lstdApplyaccommodation,lstdLimittime,
						lstdLoans,classopinion,lstdClassopiniontime,academyopinion,
						lstdOngoing,lstdBank,lstdAcademyopiniontime,lstdReturncode,lstdstate,
						lstdApplyReason,lstdPaymentReason,lstdRepayWay,lstdDisaster);
					}else{
						lstdwithblobs1 = lstdwithblobsService.insertLstdByStudId(student.getStudId(),lstdApplytuition,
								lstdApplyaccommodation,lstdLimittime,lstdLoans,classopinion,academyopinion,
								lstdOngoing,lstdBank,lstdReturncode,workstepfolw.getWsflId(),user.getUserId(),lstdClassopiniontime,
								lstdApplyReason,lstdPaymentReason,lstdRepayWay,lstdDisaster);
					}
				}
				
				map.put("lstdwithblobs1", lstdwithblobs1);
				map.put("student", student);
				map.put("result", Boolean.TRUE);
				map.put("message", "success");
			}else{//判断用户类型  非经办老师
				lstdwithblobs1 = lstdwithblobsService.selectByStudId(student.getStudId());
				workstepfolw = workstepfolwService.findWslfByWslfId(lstdwithblobs1.getLstdWsflid());
				Date lstdAcademyopiniontime = null;
				Date lstdClassopiniontime = null;
				if(state){//判断是审核还是修改
					lstdAcademyopiniontime = new Date();
					if(role0 == 1){//xueshengchu
						lstdstate = 1;
						lstdwithblobsService.updateLstdStudId(student.getStudId(),lstd.getLstdWorkid(),workstepfolw.getWsflNextstep(),
					lstdApplytuition,lstdApplyaccommodation,lstdLimittime,lstdLoans,
					classopinion,lstdClassopiniontime,academyopinion,
					lstdOngoing,lstdBank,lstdAcademyopiniontime,lstdReturncode,lstdstate,
					lstdApplyReason,lstdPaymentReason,lstdRepayWay,lstdDisaster);
					}else{
						lstd = lstdwithblobsService.updateLstdStudId(studId, workstepfolw.getWsflWorkid(), 
								workstepfolw.getWsflNextstep(), lstdApplytuition, lstdApplyaccommodation, lstdLimittime,
								lstdLoans, classopinion,lstdClassopiniontime,academyopinion,
								lstdOngoing, lstdBank,lstdAcademyopiniontime, lstdReturncode, lstdstate,
								lstdApplyReason,lstdPaymentReason,lstdRepayWay,lstdDisaster);
					}
				}else{
					System.out.println("@@@@@@@@@@@@@@@classopinion======"+classopinion);
					System.out.println("wwwwwwwwwwwwwwwwwwstate="+state+"studId="+studId);
					lstd = lstdwithblobsService.updateLstdStudId(studId, workstepfolw.getWsflWorkid(), workstepfolw.getWsflId(),
							lstdApplytuition, lstdApplyaccommodation, lstdLimittime, lstdLoans,
							classopinion,lstdClassopiniontime,academyopinion,
							lstdOngoing,lstdBank, lstdAcademyopiniontime,lstdReturncode, lstdstate,
							lstdApplyReason,lstdPaymentReason,lstdRepayWay,lstdDisaster);
				}
				map.put("lstdwithblobs1", lstdwithblobs1);
				map.put("student", student);
				map.put("result", Boolean.TRUE);
				map.put("message", "success");
			}
		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
			map.put("message", "执行出现出错！!!!!");
			e.printStackTrace();
		} finally {
			view.setAttributesMap(map);
			mav.setView(view);
			return mav;
		}	
	 }
	
	@SuppressWarnings({ "finally", "unchecked", "rawtypes" })
	@RequestMapping("/findApplyList")
	public ModelAndView findApplyList(HttpServletRequest request,HttpServletResponse response)
			 {
		ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
		try {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			List<LstdListModel> lstd = new ArrayList<LstdListModel>();//这个类中封装了要用到的大多数字段
			List<Student> student = new ArrayList<Student>();
			Institution institution = new Institution();
			List<Major> major = new ArrayList<Major>();//fudaoyuan
			List<Role> role = new ArrayList<Role>();
			role = roleService.findRolesByUser(user);//在reuserrole中查找
			//System.out.println(role.get(0).getRoleName()+"wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
			
			int maxrole = 0;
			// 找到最大的等级
			for (int i = 0; i < role.size(); i++) {
				if (role.get(i).getRoleLevel() > maxrole) {
					maxrole = role.get(i).getRoleLevel();
				}
			}
			if (maxrole == 3)// 如果最大等级为经办老师判断是不是当前功能的经办老师
			{
				maxrole = 2;
				for (int i = 0; i < role.size(); i++) {
					if (role.get(i).getRoleId() == 5) {
						maxrole = 3;
					}
				}
			}
			System.out.println("wwwwwwwwwwwww"+maxrole);
			if(maxrole == 1){//学生
				student = studentService.selectListByUserId(user.getUserId());
				System.out.println("wwwwwwwwwwwwwwwwwwwww"+student.get(0).getStudName());
				lstd = lstdwithblobsService.selectinfoByStudId(student.get(0).getStudId());//包含学院专业班级绿色通道等所有的信息
			}else if(maxrole == 2){//单纯的辅导员
				major = majorService.selectClassByUserId(user.getUserId());//fudaoyuan查找自己所带的班级
				student = studentService.selectinfoByinstUserId(user.getUserId());//通过辅导员userid直接得到所带学生申请了的
				for(int i=0;i<student.size();i++){
					List<LstdListModel> lstd0 = new ArrayList<LstdListModel>();
					lstd0 = lstdwithblobsService.selectinfoByStudId(student.get(i).getStudId());//再查申请了的学生de信息
					lstd.addAll(lstd0);
				}
			}else if(maxrole >2 && maxrole < 6){//经办老师或学办主任或分管书记
				major = majorService.selectByInstId(user.getUserInstid());
				student = studentService.selectByinstId(user.getUserInstid());//整个学院已经申请了的学生 学院id
				for(int i=0;i<student.size();i++){
					List<LstdListModel> lstd0 = new ArrayList<LstdListModel>();
					lstd0 = lstdwithblobsService.selectinfoByStudId(student.get(i).getStudId());//再查申请了的学生de信息
					lstd.addAll(lstd0);
				}
			}else{//学生处
				student = studentService.selectAllstud();//所有已申请的学生
				for(int i=0;i<student.size();i++){
					List<LstdListModel> lstd0 = new ArrayList<LstdListModel>();
					lstd0 = lstdwithblobsService.selectinfoByStudId(student.get(i).getStudId());
					System.out.println("wwwwwwwwwww"+student.get(i).getStudId());
					lstd.addAll(lstd0);
				}
			}
			institution = institutionService.findinstitutionByUserInstId(user.getUserInstid());
			if(lstd != null){
				map.put("result", Boolean.TRUE);
	            map.put("message", "success");
	            map.put("major", major);
	            map.put("user", user); 
	            map.put("institution", institution);
	            map.put("student", student);
	            map.put("lstd", lstd);
	            map.put("role", role);
			}else{
				System.out.println("小灰灰da sbwwwwwwwwwwwwwwwwwwwwww哟一个else没写");
			}
		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
            map.put("message", "执行出现出错！!!!!");
            e.printStackTrace();
		} finally {
			view.setAttributesMap(map);
            mav.setView(view);
            return mav;
		}
	}
	
	 //驳回的实现
		@SuppressWarnings({"rawtypes", "finally", "unchecked" })
		@RequestMapping("/rejectToStudent")
		public ModelAndView rejectToStudent(Integer studId,HttpServletRequest request,HttpServletResponse response){
		        ModelAndView mav = new ModelAndView();
		        MappingJacksonJsonView view = new MappingJacksonJsonView();
		        Map map = new HashMap();
		        try {
					LstdWithBLOBs lstd = new LstdWithBLOBs();
					Workstepfolw workstepfolw = new Workstepfolw();
					lstd = lstdwithblobsService.selectByStudId(studId);
					workstepfolw = workstepfolwService.findWslfByWslfId(lstd.getLstdWsflid());
					lstdwithblobsService.rejectwslfId(workstepfolw.getWsflPrestep(),lstd.getLstdId());//驳回 工作流id变为上一步
					map.put("result", Boolean.TRUE);
					map.put("message", "success");
				} catch (Exception e) {
					map.put("result", Boolean.FALSE);
	                map.put("message", "执行出现出错！");
					e.printStackTrace();
				}finally{
					view.setAttributesMap(map);
	                mav.setView(view);
					return mav;
				}
		              
		 }
		@SuppressWarnings({"rawtypes", "finally", "unchecked" })
		@RequestMapping("/findStud")
		public ModelAndView findStudent(String studNumber,HttpServletRequest request,HttpServletResponse response){
		        ModelAndView mav = new ModelAndView();
		        MappingJacksonJsonView view = new MappingJacksonJsonView();
		        Map map = new HashMap();
		        try {
					List<LstdListModel> lstd = new ArrayList<LstdListModel>();
					lstd = lstdwithblobsService.selectinfoByStudNumber(studNumber);
					if(lstd.size() <= 0){
						map.put("result", Boolean.FALSE);
					}else{
						map.put("lstd", lstd);
						map.put("result", Boolean.TRUE);
						map.put("message", "success");
					}
					
				} catch (Exception e) {
					map.put("result", Boolean.FALSE);
	                map.put("message", "执行出现出错！");
					e.printStackTrace();
				}finally{
					view.setAttributesMap(map);
	                mav.setView(view);
					return mav;
				}
		              
		 }  
		@SuppressWarnings({"rawtypes", "finally", "unchecked" })
		@RequestMapping("/findStudentByUserId")
		public ModelAndView findStudentByUserId(HttpServletRequest request,HttpServletResponse response){
		        ModelAndView mav = new ModelAndView();
		        MappingJacksonJsonView view = new MappingJacksonJsonView();
		        Map map = new HashMap();
		        HttpSession session = request.getSession();
				User user = (User) session.getAttribute("user");
		        try {
					List<LstdListModel> lstd = new ArrayList<LstdListModel>();
					Institution institution = new Institution();
					/*此处通过经办老师的userId查非本学院申请lstd的学生还有问题 */
					lstd = lstdwithblobsService.findStudentByUserId(user.getUserId());//通过经办老师userid查找学生详细信息
					institution = institutionService.findinstitutionByUserInstId(user.getUserInstid());
					int size = lstd.size();
					System.out.println("+++++++++++++++++++++size="+size);
					int i=0;
					while(i<lstd.size()){//如果经办老师所在学院和学生所在学院相同 则remove  需要的是非本学院的学生
						//System.out.println(institution.getInstId()+"xxxxxxxxxx"+lstd.get(i).getDepartmentId());
						if(institution.getInstId() == lstd.get(i).getDepartmentId()){
							lstd.remove(i);
							
						}else{
							i++;
						}
					}
					for(int k = 0;k < lstd.size();k++){
						for(int j = k;j < lstd.size()-1;j++){
							if(lstd.get(j+1).getLstdId() == lstd.get(k).getLstdId()){
								lstd.remove(k);
								j--;
							}
						}
					}
					if(lstd.size() <= 0){
						map.put("result", Boolean.FALSE);
					}else{
						System.out.println("如果"+institution.getInstId()+"等于DepartmentId则remove");
						map.put("lstd", lstd);
						map.put("institution", institution);
						map.put("result", Boolean.TRUE);
						map.put("message", "success");
					}
					
				} catch (Exception e) {
					map.put("result", Boolean.FALSE);
	                map.put("message", "执行出现出错！");
					e.printStackTrace();
				}finally{
					view.setAttributesMap(map);
	                mav.setView(view);
					return mav;
				}
		              
		 }
		
		@SuppressWarnings({"rawtypes", "finally", "unchecked" })
		@RequestMapping("/searchStudent")
		public ModelAndView searchStudent(int academyid,int majorid,int classid,HttpServletRequest request,HttpServletResponse response){
		        ModelAndView mav = new ModelAndView();
		        MappingJacksonJsonView view = new MappingJacksonJsonView();
		        Map map = new HashMap();
		        HttpSession session = request.getSession();
				User user = (User) session.getAttribute("user");
		        try {
		        	List<LstdListModel> lstd = new ArrayList<LstdListModel>();
		        	List<Student> student = new ArrayList<Student>();
		            if(majorid == 0){
		            	if(user.getUserType() == 2){
		            		student = studentService.selectinfoByinstUserId(user.getUserId());//通过辅导员userid直接得到所带学生申请了的
		    				for(int i=0;i<student.size();i++){
		    					List<LstdListModel> lstd0 = new ArrayList<LstdListModel>();
		    					lstd0 = lstdwithblobsService.selectinfoByStudId(student.get(i).getStudId());//再查申请了的学生de信息
		    					lstd.addAll(lstd0);
		    				}
		            	}else{
		            		lstd = lstdwithblobsService.selectinfoByacademyid(academyid);
		            	}
		            }else{
		            	if(classid == 0){
		            		lstd = lstdwithblobsService.selectinfoBymajorid(majorid);
		            	}else{
		            		lstd = lstdwithblobsService.selectinfoByclassid(classid);
		            	}
		            }
		            if(lstd.size() <= 0){
		            	map.put("result", Boolean.FALSE);
		            }else{
		            	map.put("lstd", lstd);
						map.put("result", Boolean.TRUE);
						map.put("message", "success");
		            }
		            
				} catch (Exception e) {
					map.put("result", Boolean.FALSE);
	                map.put("message", "执行出现出错！");
					e.printStackTrace();
				}finally{
					view.setAttributesMap(map);
	                mav.setView(view);
					return mav;
				}
		              
		 }  
		@SuppressWarnings({"rawtypes", "finally", "unchecked"})
		@RequestMapping("/export")
		public ModelAndView export(HttpServletRequest request,HttpServletResponse response){
		        ModelAndView mav = new ModelAndView();
		        MappingJacksonJsonView view = new MappingJacksonJsonView();
		        Map map = new HashMap();
		        HttpSession session = request.getSession();
				User user = (User) session.getAttribute("user");
		        try {
		        	List<LstdListModel> lstd = new ArrayList<LstdListModel>();
					List<Student> student = new ArrayList<Student>();
					List<Role> role = (List<Role>) session.getAttribute("role");
					int maxrole = 0;
					// 找到最大的等级
					for (int i = 0; i < role.size(); i++) {
						if (role.get(i).getRoleLevel() > maxrole) {
							maxrole = role.get(i).getRoleLevel();
						}
					}
					if (maxrole == 3)// 如果最大等级为经办老师判断是不是当前功能的经办老师
					{
						maxrole = 2;
						for (int i = 0; i < role.size(); i++) {
							if (role.get(i).getRoleId() == 5) {
								maxrole = 3;
							}
						}
					}
					System.out.println("wwwwwwwwwwwww"+maxrole);
		        	if(maxrole >2 && maxrole < 6){
						student = studentService.selectByinstId(user.getUserInstid());//整个学院已经申请了的学生 学院id
						for(int i=0;i<student.size();i++){
							List<LstdListModel> lstd0 = new ArrayList<LstdListModel>();
							lstd0 = lstdwithblobsService.selectinfoByStudId(student.get(i).getStudId());//再查申请了的学生de信息
							lstd.addAll(lstd0);
						}
		        	}else if(maxrole == 2){
						student = studentService.selectinfoByinstUserId(user.getUserId());//通过辅导员userid直接得到所带学生申请了的
						for(int i=0;i<student.size();i++){
							List<LstdListModel> lstd0 = new ArrayList<LstdListModel>();
							lstd0 = lstdwithblobsService.selectinfoByStudId(student.get(i).getStudId());//再查申请了的学生de信息
							lstd.addAll(lstd0);
						}
		        	}else{
		        		student = studentService.selectAllstud();//所有已申请的学生
						for(int i=0;i<student.size();i++){
							List<LstdListModel> lstd0 = new ArrayList<LstdListModel>();
							lstd0 = lstdwithblobsService.selectinfoByStudId(student.get(i).getStudId());
							System.out.println("wwwwwwwwwww"+student.get(i).getStudId());
							lstd.addAll(lstd0);
						}
		        	}
					 WritableWorkbook book = null;
				        try {
				            
				            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		                    String date1 = sdf.format(System.currentTimeMillis());
		                    map.put("date", date1);
				        	String filePath = request.getSession().getServletContext()
									.getRealPath("upload/lstdApply"+date1+".xls");
				        	OutputStream os = new FileOutputStream(filePath);
				            // 打开文件
				            book = Workbook.createWorkbook(os);
				            // 生成名为"学生"的工作表，参数0表示这是第一页
				            WritableSheet sheet = book.createSheet("学生", 0);
				            
				            WritableFont wfont = new WritableFont(WritableFont.ARIAL, 11, 
				            		WritableFont.BOLD, false, 
				            		jxl.format.UnderlineStyle.NO_UNDERLINE, 
				            		jxl.format.Colour.BLACK); 
				            		WritableCellFormat titleFormat = new WritableCellFormat(wfont); 
				            String[] title = { "姓名", "学号", "学院", "专业","班级","申请时间","审核状态" }; 
				            for (int i = 0; i < title.length; i++) { 
				            	Label excelTitle = new Label(i, 0, title[i],titleFormat); 
				            	sheet.addCell(excelTitle); 
				            	} 
				            String lstdstate = "";
				            if(lstd!=null && !lstd.isEmpty()){
				                for(int i=0; i<lstd.size(); i++){
				                	if(lstd.get(i).getLstdState() == 0){
				                		if(lstd.get(i).getLstdWsflid() == 42){
				                			lstdstate ="学生已填写申请";
				                		}else if(lstd.get(i).getLstdWsflid() == 43){
				                			lstdstate="待学办主任审核";
				                		}else if(lstd.get(i).getLstdWsflid() == 44){
				                			lstdstate="待学院分管书记审核";
				                		}else if(lstd.get(i).getLstdWsflid() == 45){
				                			lstdstate="待学生处审核";
				                		}
				                	}else{
				                		lstdstate = "审核通过";
				                	}
				                	Date date = lstd.get(i).getLstdClassopiniontime();
				                	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				                	df = DateFormat.getDateInstance(DateFormat.FULL);
				                	String time = df.format(date);
				                    sheet.addCell(new Label(0, i+1, lstd.get(i).getStuName()));
				                	sheet.addCell(new Label(1, i+1, lstd.get(i).getStuNumber()));
				                    sheet.addCell(new Label(2, i+1, lstd.get(i).getStuDepartment()));
				                    sheet.addCell(new Label(3, i+1, lstd.get(i).getStuMajor()));
				                    sheet.addCell(new Label(4, i+1, lstd.get(i).getStuClass()));
				                    sheet.addCell(new Label(5, i+1, time));
				                    sheet.addCell(new Label(6, i+1, lstdstate));
				                }
				            }
				            // 写入数据并关闭文件
				            book.write();
				        } catch (Exception e) {
				            System.out.println(e);
				        }finally{
				            if(book!=null){
				                try {
				                    book.close();
				                } catch (Exception e) {
				                    e.printStackTrace();
				                } 
				            }
				        }

					map.put("lstd", lstd);
					map.put("result", Boolean.TRUE);
					map.put("message", "success");
				} catch (Exception e) {
					map.put("result", Boolean.FALSE);
	                map.put("message", "执行出现出错！");
					e.printStackTrace();
				}finally{
					view.setAttributesMap(map);
	                mav.setView(view);
					return mav;
				}
		              
		 }  
		
		 /**
		 * 下载检索的学生信息
		 * @param id
		 * @param request
		 * @param response
		 * @throws IOException
		 */
		@SuppressWarnings("unused")
		@RequestMapping(value="/download",method=RequestMethod.GET)  
	    public void downloadFile(Integer id,String date,HttpServletRequest request,
	            HttpServletResponse response) throws IOException {
			try {
			String path=request.getSession().getServletContext().getRealPath("upload/lstdApply"+date+".xls");
	        System.out.println(path);
			File file = new File(path);
	        // 取得文件名。
	        String filename = file.getName();
	        // 取得文件的后缀名。
	        String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

	        // 以流的形式下载文件。
	        InputStream fis = new BufferedInputStream(new FileInputStream(path));
	        byte[] buffer = new byte[fis.available()];
	        fis.read(buffer);
	        fis.close();
	  // 清空response
	       // response.reset();
	        // 设置response的Header
	        response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
	        response.addHeader("Content-Length", "" + file.length());
	        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
	        response.setContentType("application/octet-stream");
	        toClient.write(buffer);
	        toClient.flush();
	        toClient.close();
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
			
		}
		@SuppressWarnings({"rawtypes", "finally", "unchecked" })
		@RequestMapping("/systemOpenTime")
		public ModelAndView systemOpenTime(HttpServletRequest request,HttpServletResponse response){
		        ModelAndView mav = new ModelAndView();
		        MappingJacksonJsonView view = new MappingJacksonJsonView();
		        Map map = new HashMap();
		        try {
		        	Work work = new Work();
		        	work = workService.selectByWorkId(5);
		        	map.put("work", work);
					map.put("result", Boolean.TRUE);
					map.put("message", "success");
				} catch (Exception e) {
					map.put("result", Boolean.FALSE);
	                map.put("message", "执行出现出错！");
					e.printStackTrace();
				}finally{
					view.setAttributesMap(map);
	                mav.setView(view);
					return mav;
				}
		              
		 }  
		
		@SuppressWarnings({"rawtypes", "finally", "unchecked" })
		@RequestMapping("/countByAcademy")
		public ModelAndView countByAcademy(HttpServletRequest request,HttpServletResponse response){
		        ModelAndView mav = new ModelAndView();
		        MappingJacksonJsonView view = new MappingJacksonJsonView();
		        Map map = new HashMap();
		        HttpSession session = request.getSession();
		        User user = (User)session.getAttribute("user");
		        List<CountModal> countModals = new ArrayList<CountModal>();
		        try {
		        	if(user.getUserType() == 2){
		        		countModals = commonService.findlstdCountInfo3(5, user);
		        	}else if(user.getUserType() > 2 && user.getUserType() < 6){
		        		countModals = commonService.findlstdCountInfo2(5,user.getUserInstid());
		        	}else if(user.getUserType() == 6){
		        		countModals = commonService.findlstdCountInfo(5);
		        	}
		             System.out.println(countModals);
					
		            map.put("countModals", countModals);
					map.put("result", Boolean.TRUE);
					map.put("message", "success");
				} catch (Exception e) {
					map.put("result", Boolean.FALSE);
	                map.put("message", "执行出现出错！");
					e.printStackTrace();
				}finally{
					view.setAttributesMap(map);
	                mav.setView(view);
					return mav;
				}
		              
		 }  
}