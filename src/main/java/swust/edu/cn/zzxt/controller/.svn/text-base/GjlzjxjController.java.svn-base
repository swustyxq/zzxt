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

import swust.edu.cn.zzxt.model.GjlzjxjWithBLOBs;
import swust.edu.cn.zzxt.model.Institution;
import swust.edu.cn.zzxt.model.Learning;
import swust.edu.cn.zzxt.model.Major;
import swust.edu.cn.zzxt.model.Reward;
import swust.edu.cn.zzxt.model.Role;
import swust.edu.cn.zzxt.model.Student;
import swust.edu.cn.zzxt.model.Studentclass;
import swust.edu.cn.zzxt.model.Studentinfo;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.model.Workstepfolw;
import swust.edu.cn.zzxt.selfmodel.GjlzjxjListModel;
import swust.edu.cn.zzxt.service.GjlzjxjWithBLOBsService;
import swust.edu.cn.zzxt.service.InstitutionService;
import swust.edu.cn.zzxt.service.InstructorService;
import swust.edu.cn.zzxt.service.LearningService;
import swust.edu.cn.zzxt.service.MajorService;
import swust.edu.cn.zzxt.service.RewardService;
import swust.edu.cn.zzxt.service.RoleService;
import swust.edu.cn.zzxt.service.StudentService;
import swust.edu.cn.zzxt.service.StudentclassService;
import swust.edu.cn.zzxt.service.StudentinfoService;
import swust.edu.cn.zzxt.service.WorkstepfolwService;


@Controller
@RequestMapping("/gjlzjxjController")
public class GjlzjxjController {
	private GjlzjxjWithBLOBsService gjlzjxjwithblobsService;
	private StudentService studentService;
	private WorkstepfolwService workstepfolwService;
	private StudentinfoService studentinfoService;
	private StudentclassService studentclassService;
	private MajorService majorService;
	private LearningService learningService;
	private RewardService rewardService;
	private InstructorService instructorService;
	private InstitutionService institutionService;
	private RoleService roleService;
	
	public RoleService getRoleService() {
		return roleService;
	}
	@Autowired
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	public InstitutionService getInstitutionService() {
		return institutionService;
	}
	@Autowired
	public void setInstitutionService(InstitutionService institutionService) {
		this.institutionService = institutionService;
	}
	public InstructorService getInstructorService() {
		return instructorService;
	}
	@Autowired
	public void setInstructorService(InstructorService instructorService) {
		this.instructorService = instructorService;
	}
	public StudentinfoService getStudentinfoService() {
		return studentinfoService;
	}
	@Autowired
	public void setStudentinfoService(StudentinfoService studentinfoService) {
		this.studentinfoService = studentinfoService;
	}
	public RewardService getRewardService() {
		return rewardService;
	}
	@Autowired
	public void setRewardService(RewardService rewardService) {
		this.rewardService = rewardService;
	}
	public LearningService getLearningService() {
		return learningService;
	}
	@Autowired
	public void setLearningService(LearningService learningService) {
		this.learningService = learningService;
	}
	public MajorService getMajorService() {
		return majorService;
	}
	@Autowired
	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}
	
	public StudentclassService getStudentclassService() {
		return studentclassService;
	}
	@Autowired
	public void setStudentclassService(StudentclassService studentclassService) {
		this.studentclassService = studentclassService;
	}
	
	public WorkstepfolwService getWorkstepfolwService() {
		return workstepfolwService;
	}
	@Autowired
	public void setWorkstepfolwService(WorkstepfolwService workstepfolwService) {
		this.workstepfolwService = workstepfolwService;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public GjlzjxjWithBLOBsService getGjlzjxjwithblobsService() {
		return gjlzjxjwithblobsService;
	}
	@Autowired
	public void setGjlzjxjwithblobsService(
			GjlzjxjWithBLOBsService gjlzjxjwithblobsService) {
		this.gjlzjxjwithblobsService = gjlzjxjwithblobsService;
	}
	 /**
     * @author Wang Jian
     * @Title: readStudentByStudNumber 
     * @ClassName：StudentController.java
     * @Package: swust.edu.cn.zzxt.controller
     * @Description: 根据学生的学号查询信息
     * @createDate:
     * @email:
     * @phone:
     * @Department:
     * @Address:
     * @reviseNote:
     * @version:
     */
    
    
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/readStudentByStudNumber")
    public ModelAndView readStudentByStudNumber(Integer studId,HttpServletRequest request,HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        
        User user = new User();
        HttpSession session = request.getSession();//获取session
        List<Role> role = (List<Role>) session.getAttribute("role");
            try {//查reuserrol 判断角色
            	user = (User)session.getAttribute("user");
                Student student = new Student();
                Studentinfo studentInfo = new Studentinfo();
                Studentclass studentClass = new Studentclass();
                Major major = new Major();
                List<Learning> learning = new ArrayList<Learning>();
                GjlzjxjWithBLOBs gjlzjxjwithblobs = new GjlzjxjWithBLOBs();
                List<Reward> reward= new ArrayList<Reward>();
                Workstepfolw workstepfolw = new Workstepfolw();
                if(studId == 0){//此处是判断Detail是页面或apply页面读取信息
                	student = studentService.selectInfoByUser(user.getUserId());
                }else{
                	student = studentService.findStudentByStudId(studId);
                }        
                studentInfo = studentinfoService.selectBystudInfoStudId(student.getStudId());
                studentClass = studentclassService.selectBystudInfoStudId(student.getStudClassid());
                System.out.println(studentClass.getClassId());
                major = majorService.selectByPrimaryKey(studentClass.getClassMajrid());
                System.out.println(studentClass.getClassMajrid());
                learning = learningService.findAllLearning(student.getStudId());
                System.out.println(student.getStudId());
                gjlzjxjwithblobs = gjlzjxjwithblobsService.selectByStudid(student.getStudId());
                //如果有学生的申请记录 就读出来//
                if(gjlzjxjwithblobs==null){
                	//用来判断没有申请过的人
                	workstepfolw=null;
                	map.put("result", Boolean.TRUE);
                    map.put("student", student);
                    map.put("studentInfo", studentInfo);
                    map.put("studentClass", studentClass);
                    map.put("major", major);
                    map.put("learning", learning);
                    map.put("workstepfolw",workstepfolw);//返回null判断未申请
                    map.put("message", "success！");
                }else{
                	if(gjlzjxjwithblobs.getGjlzWsflid() == -1){
                		workstepfolw.setWsflRoleid(1000);
                	}else{
                		workstepfolw = workstepfolwService.findWslfByWslfId(gjlzjxjwithblobs.getGjlzWsflid());//根据工作流判断是否显示申请页面
                	}
                	map.put("workstepfolw",workstepfolw);//根据工作流id判断 如果已申请 则跳转到list 
                	map.put("user", user);
                	map.put("role", role);
                	map.put("gjlzjxjwithblobs",gjlzjxjwithblobs);
                	reward = rewardService.findRewardsByWorkId(gjlzjxjwithblobs.getGjlzWorkid(),gjlzjxjwithblobs.getGjlzId().toString());
                	map.put("reward",reward);
                    //System.out.println(learning.get(0).getLearPassnumber()+"!!!!!!!!!!!!!!!!@@@@@@@@@@@#########");
                    map.put("result", Boolean.TRUE);
                    map.put("student", student);
                    map.put("studentInfo", studentInfo);
                    map.put("studentClass", studentClass);
                    map.put("major", major);
                    map.put("learning", learning);
                    map.put("workstepfolw",workstepfolw);//返回null判断未申请
                    map.put("message", "success！");		
	                    
	                   
            	}
            }catch (Exception e) {
                map.put("result", Boolean.FALSE);
                map.put("message", "执行出现出错！");
                e.printStackTrace();
            }finally{
                    view.setAttributesMap(map);
                    mav.setView(view);
                    return mav;
                    }
        }
	
	
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/inputStudLzInfo")
    public ModelAndView inputStudLzInfo(Integer studId,Boolean state,String gjlzApplyreason,String gjlzResidence,double gjlzAllincomes,String gjlzIncometype,
    		Integer gjlzPopulation,String gjlzHome,String gjlzMailcode,String gjlzRanking,String gjlzComprehensive,
    		String gjlzComprehensiveranking,String gjlzPoliticstate,String majorOption,String academyOption,String schoolOption,
            HttpServletResponse response, HttpServletRequest request) 
    {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Role> role = (List<Role>) session.getAttribute("role");
        int role0 = 0;
		for(int j=0;j<role.size();j++){
			if(role.get(j).getRoleId() == 2){
				role0 = 1;//标记 单纯的辅导员
			}else if(role.get(j).getRoleId() == 9){
				role0 = 2;//经办老师
			}else if(role.get(j).getRoleId() == 23){
				role0 =3;//学生处工作人员
			}
		}
        try {
            // 业务逻辑   
        	GjlzjxjWithBLOBs gjlzjxj0 = new GjlzjxjWithBLOBs();
        	GjlzjxjWithBLOBs gjlzjxj = new GjlzjxjWithBLOBs();
        	Student student = new Student();
        	Date gjlzMajoropiniontime=null;
        	Date gjlzAcademyopiniontime=null;
        	Date gjlzSchoolopiniontime=null;
        	int gjlzstate = 0;
            if (user.getUserType() == 1) {
            	Workstepfolw workstepfolw = new Workstepfolw();
            	int workId = 9;
            	int situId = 1;
            	for(int i=0;i<role.size();i++){
            		if(role.get(i).getRoleId() == 13){
            			situId = 3;
            		}
            		if(role.get(i).getRoleId() == 9){
            			situId = 2;
            		}
            	}
            	workstepfolw = workstepfolwService.getWsflIdByWorkidAndSituation(workId, situId);
            	student = studentService.findStudentById(user.getUserId());
            	gjlzjxj0 = gjlzjxjwithblobsService.selectByStudid(student.getStudId());
            	Date date = new Date();
            	if(state){//学生/（辅导员等>2）的判断是保存（修改）还是提交（审核通过）
	            	if(gjlzjxj0 == null){
	            		System.out.println(gjlzApplyreason+"@@@@@@@@@@@@@@");
	            		gjlzjxj = gjlzjxjwithblobsService.inputStudLzInfo(student.getStudId(), gjlzApplyreason, gjlzResidence, 
	            				gjlzAllincomes, gjlzIncometype, gjlzPopulation, gjlzHome, gjlzMailcode, gjlzRanking, 
	            				gjlzComprehensive, gjlzComprehensiveranking, gjlzPoliticstate,
	            				workstepfolw.getWsflNextstep(),date);
	            	}else{
	            		gjlzjxj = gjlzjxjwithblobsService.updateStudLzInfo(student.getStudId(), gjlzApplyreason, gjlzResidence,
	            				gjlzAllincomes, gjlzIncometype, gjlzPopulation, gjlzHome, gjlzMailcode, gjlzRanking,
	            				gjlzComprehensive, gjlzComprehensiveranking, gjlzPoliticstate, workstepfolw.getWsflNextstep(),
	            				gjlzMajoropiniontime,gjlzAcademyopiniontime,gjlzSchoolopiniontime,gjlzstate,
	            				majorOption,academyOption,schoolOption);
	            	}
            	}else{
            		if(gjlzjxj0 == null){
            			gjlzjxj = gjlzjxjwithblobsService.inputStudLzInfo(student.getStudId(), gjlzApplyreason, gjlzResidence, 
	            				gjlzAllincomes, gjlzIncometype, gjlzPopulation, gjlzHome, gjlzMailcode, gjlzRanking, 
	            				gjlzComprehensive, gjlzComprehensiveranking, gjlzPoliticstate, 
	            				workstepfolw.getWsflId(),date);
            		}else{
            			gjlzjxj = gjlzjxjwithblobsService.updateStudLzInfo(student.getStudId(), gjlzApplyreason, gjlzResidence,
	            				gjlzAllincomes, gjlzIncometype, gjlzPopulation, gjlzHome, gjlzMailcode, gjlzRanking,
	            				gjlzComprehensive, gjlzComprehensiveranking, gjlzPoliticstate, workstepfolw.getWsflId(),
	            				gjlzMajoropiniontime,gjlzAcademyopiniontime,gjlzSchoolopiniontime,gjlzstate,
	            				majorOption,academyOption,schoolOption);
            		}
            	}
            	map.put("workstepfolw", workstepfolw);
                map.put("result", Boolean.TRUE);
                map.put("message", "success");
            }else{
            	Workstepfolw workstepfolw = new Workstepfolw();
            	student = studentService.findStudentByStudId(studId);
            	System.out.println(studId+"xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            	gjlzjxj0 = gjlzjxjwithblobsService.selectByStudid(studId);
            	workstepfolw = workstepfolwService.findWslfByWslfId(gjlzjxj0.getGjlzWsflid());
            	if(state){
	            	if(role0 == 1){//辅导员
	            		gjlzMajoropiniontime = new Date();
	            		gjlzjxj = gjlzjxjwithblobsService.updateStudLzInfo(studId,gjlzApplyreason,gjlzResidence,
	        	            	gjlzAllincomes,gjlzIncometype,gjlzPopulation,gjlzHome,gjlzMailcode,gjlzRanking,
	        	            	gjlzComprehensive,gjlzComprehensiveranking,gjlzPoliticstate,workstepfolw.getWsflNextstep(),
	        	            	gjlzMajoropiniontime,gjlzAcademyopiniontime,gjlzSchoolopiniontime,gjlzstate,
	        	            	majorOption,academyOption,schoolOption);
	            	}else if(role0 == 2){//经办老师
	            		gjlzAcademyopiniontime = new Date();
	            		gjlzjxj = gjlzjxjwithblobsService.updateStudLzInfo(studId,gjlzApplyreason,gjlzResidence,
	        	            	gjlzAllincomes,gjlzIncometype,gjlzPopulation,gjlzHome,gjlzMailcode,gjlzRanking,
	        	            	gjlzComprehensive,gjlzComprehensiveranking,gjlzPoliticstate,workstepfolw.getWsflNextstep(),
	        	            	gjlzMajoropiniontime,gjlzAcademyopiniontime,gjlzSchoolopiniontime,gjlzstate,
	        	            	majorOption,academyOption,schoolOption);
	            	}else if(role0 == 3){//学生处
	            		gjlzstate = 1;
	            		gjlzSchoolopiniontime = new Date();
	            		gjlzjxj = gjlzjxjwithblobsService.updateStudLzInfo(studId,gjlzApplyreason,gjlzResidence,
	        	            	gjlzAllincomes,gjlzIncometype,gjlzPopulation,gjlzHome,gjlzMailcode,gjlzRanking,
	        	            	gjlzComprehensive,gjlzComprehensiveranking,gjlzPoliticstate,workstepfolw.getWsflNextstep(),
	        	            	gjlzMajoropiniontime,gjlzAcademyopiniontime,gjlzSchoolopiniontime,gjlzstate,
	        	            	majorOption,academyOption,schoolOption);
	            	}else{
	            		gjlzjxj = gjlzjxjwithblobsService.updateStudLzInfo(studId,gjlzApplyreason,gjlzResidence,
	        	            	gjlzAllincomes,gjlzIncometype,gjlzPopulation,gjlzHome,gjlzMailcode,gjlzRanking,
	        	            	gjlzComprehensive,gjlzComprehensiveranking,gjlzPoliticstate,workstepfolw.getWsflNextstep(),
	        	            	gjlzMajoropiniontime,gjlzAcademyopiniontime,gjlzSchoolopiniontime,gjlzstate,
	        	            	majorOption,academyOption,schoolOption);
	            	}
            	}else{
	            	gjlzjxj = gjlzjxjwithblobsService.updateStudLzInfo(studId,gjlzApplyreason,gjlzResidence,
	            	gjlzAllincomes,gjlzIncometype,gjlzPopulation,gjlzHome,gjlzMailcode,gjlzRanking,
	            	gjlzComprehensive,gjlzComprehensiveranking,gjlzPoliticstate,workstepfolw.getWsflId(),
	            	gjlzMajoropiniontime,gjlzAcademyopiniontime,gjlzSchoolopiniontime,gjlzstate,
	            	majorOption,academyOption,schoolOption);
            	}
                map.put("result", Boolean.TRUE);
                map.put("message", "success");
                map.put("gjlzjxj", gjlzjxj);
            }
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            map.put("message", "添加错误");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }
		@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	    @RequestMapping("/findApplyList")
	    public ModelAndView findApplyList(HttpServletRequest request,HttpServletResponse response) throws Exception {
	        ModelAndView mav = new ModelAndView();
	        MappingJacksonJsonView view = new MappingJacksonJsonView();
	        Map map = new HashMap();
	        try {
	            HttpSession session = request.getSession();//获取session
	            User user = (User) session.getAttribute("user");
	            List<GjlzjxjListModel> gjlzjxj = new ArrayList<GjlzjxjListModel>();
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
						if (role.get(i).getRoleId() == 9) {
							maxrole = 3;
						}
					}
				}
				System.out.println("wwwwwwwwwwwww"+maxrole);
				if(maxrole == 1){//学生
					student = studentService.selectListByUserId(user.getUserId());
					System.out.println("wwwwwwwwwwwwwwwwwwwww"+student.get(0).getStudName());
					gjlzjxj = gjlzjxjwithblobsService.selectinfoByStudId(student.get(0).getStudId());//包含学院专业班级国家励志奖学金等所有的信息
				}else if(maxrole == 2){//单纯的辅导员
					major = majorService.selectClassByUserId(user.getUserId());//fudaoyuan查找自己所带的班级
					student = studentService.selectinfoByinstUserId1(user.getUserId());//通过辅导员userid直接得到所带学生申请了的
					for(int i=0;i<student.size();i++){
						List<GjlzjxjListModel> gjlzjxj0 = new ArrayList<GjlzjxjListModel>();
						gjlzjxj0 = gjlzjxjwithblobsService.selectinfoByStudId(student.get(i).getStudId());//再查申请了的学生de信息
						gjlzjxj.addAll(gjlzjxj0);
					}
				}else if(maxrole >2 && maxrole < 6){//经办老师或学办主任或分管书记
					major = majorService.selectByInstId(user.getUserInstid());
					student = studentService.selectByinstId1(user.getUserInstid());//整个学院已经申请了的学生 学院id
					for(int i=0;i<student.size();i++){
						List<GjlzjxjListModel> gjlzjxj0 = new ArrayList<GjlzjxjListModel>();
						gjlzjxj0 = gjlzjxjwithblobsService.selectinfoByStudId(student.get(i).getStudId());//再查申请了的学生de信息
						gjlzjxj.addAll(gjlzjxj0);
					}
				}else{//学生处
					student = studentService.selectAllstud1();//所有已申请的学生
					for(int i=0;i<student.size();i++){
						List<GjlzjxjListModel> gjlzjxj0 = new ArrayList<GjlzjxjListModel>();
						gjlzjxj0 = gjlzjxjwithblobsService.selectinfoByStudId(student.get(i).getStudId());
						System.out.println("wwwwwwwwwww"+student.get(i).getStudId());
						gjlzjxj.addAll(gjlzjxj0);
					}
				}
				institution = institutionService.findinstitutionByUserInstId(user.getUserInstid());
				if(gjlzjxj != null){
					map.put("result", Boolean.TRUE);
		            map.put("message", "success");
		            map.put("major", major);
		            map.put("user", user); 
		            map.put("institution", institution);
		            map.put("student", student);
		            map.put("gjlzjxj", gjlzjxj);
				}else{
					System.out.println("小灰灰da sbwwwwwwwwwwwwwwwwwwwwww哟一个else没写");
				}
	            }catch (Exception e) {
	                map.put("result", Boolean.FALSE);
	                map.put("message", "执行出现出错！");
	                e.printStackTrace();
	            }finally{
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
				GjlzjxjWithBLOBs gjlzjxj = new GjlzjxjWithBLOBs();
				Workstepfolw workstepfolw = new Workstepfolw();
				gjlzjxj = gjlzjxjwithblobsService.selectByStudid(studId);
				workstepfolw = workstepfolwService.findWslfByWslfId(gjlzjxj.getGjlzWsflid());
				gjlzjxjwithblobsService.rejectwslfId(workstepfolw.getWsflPrestep(),gjlzjxj.getGjlzId());//驳回 工作流id变为上一步
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
	@RequestMapping("/export")
	public ModelAndView export(HttpServletRequest request,HttpServletResponse response){
	        ModelAndView mav = new ModelAndView();
	        MappingJacksonJsonView view = new MappingJacksonJsonView();
	        Map map = new HashMap();
	        HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
	        try {
	        	List<GjlzjxjListModel> lstd = new ArrayList<GjlzjxjListModel>();
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
					student = studentService.selectByinstId1(user.getUserInstid());//整个学院已经申请了的学生 学院id
					for(int i=0;i<student.size();i++){
						List<GjlzjxjListModel> lstd0 = new ArrayList<GjlzjxjListModel>();
						lstd0 = gjlzjxjwithblobsService.selectinfoByStudId(student.get(i).getStudId());//再查申请了的学生de信息
						lstd.addAll(lstd0);
					}
	        	}else if(maxrole == 2){
					student = studentService.selectinfoByinstUserId1(user.getUserId());//通过辅导员userid直接得到所带学生申请了的
					for(int i=0;i<student.size();i++){
						List<GjlzjxjListModel> lstd0 = new ArrayList<GjlzjxjListModel>();
						lstd0 = gjlzjxjwithblobsService.selectinfoByStudId(student.get(i).getStudId());//再查申请了的学生de信息
						lstd.addAll(lstd0);
					}
	        	}else{
	        		student = studentService.selectAllstud1();//所有已申请的学生
					for(int i=0;i<student.size();i++){
						List<GjlzjxjListModel> lstd0 = new ArrayList<GjlzjxjListModel>();
						lstd0 = gjlzjxjwithblobsService.selectinfoByStudId(student.get(i).getStudId());
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
								.getRealPath("upload/gjlzjxjApply"+date1+".xls");
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
			                	if(lstd.get(i).getGjlzState() == 0){
			                		if(lstd.get(i).getGjlzWsflid() == 16||lstd.get(i).getGjlzWsflid() == 22||lstd.get(i).getGjlzWsflid() == 27){
			                			lstdstate ="学生已填写申请";
			                		}else if(lstd.get(i).getGjlzWsflid() == 17){
			                			lstdstate="待辅导员审核";
			                		}else if(lstd.get(i).getGjlzWsflid() == 18||lstd.get(i).getGjlzWsflid() == 23){
			                			lstdstate="待经办老师审核";
			                		}else if(lstd.get(i).getGjlzWsflid() == 19||lstd.get(i).getGjlzWsflid() == 24||lstd.get(i).getGjlzWsflid() == 28){
			                			lstdstate="待学办主任审核";
			                		}else if(lstd.get(i).getGjlzWsflid() == 20||lstd.get(i).getGjlzWsflid() == 25||lstd.get(i).getGjlzWsflid() == 29){
			                			lstdstate="待学院分管书记审核";
			                		}else if(lstd.get(i).getGjlzWsflid() == 21||lstd.get(i).getGjlzWsflid() == 26||lstd.get(i).getGjlzWsflid() == 30){
			                			lstdstate="待学生处审核";
			                		}
			                	}else{
			                		lstdstate = "审核通过";
			                	}
			                	Date date = lstd.get(i).getGjlzApplyreasontime();
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
		String path=request.getSession().getServletContext().getRealPath("upload/gjlzjxjApply"+date+".xls");
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
}
