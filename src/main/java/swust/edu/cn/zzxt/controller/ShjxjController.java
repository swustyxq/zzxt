package swust.edu.cn.zzxt.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import swust.edu.cn.zzxt.model.Institution;
import swust.edu.cn.zzxt.model.Instructor;
import swust.edu.cn.zzxt.model.Major;
import swust.edu.cn.zzxt.model.Role;
import swust.edu.cn.zzxt.model.ShjxjWithBLOBs;
import swust.edu.cn.zzxt.model.Student;
import swust.edu.cn.zzxt.model.Studentclass;
import swust.edu.cn.zzxt.model.Studentinfo;
import swust.edu.cn.zzxt.selfmodel.StuNeededShowInfo;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.model.Workstepfolw;
import swust.edu.cn.zzxt.selfmodel.Studentbasiinfo;
import swust.edu.cn.zzxt.service.InstitutionService;
import swust.edu.cn.zzxt.service.InstructorService;
import swust.edu.cn.zzxt.service.MajorService;
import swust.edu.cn.zzxt.service.ShjxjService;
import swust.edu.cn.zzxt.service.StudentService;
import swust.edu.cn.zzxt.service.StudentclassService;
import swust.edu.cn.zzxt.service.StudentinfoService;
import swust.edu.cn.zzxt.service.UserService;
import swust.edu.cn.zzxt.service.WorkstepfolwService;

@Controller
@RequestMapping("/shjxjController")
public class ShjxjController {
	private ShjxjService shjxjService;
	public ShjxjService getShjxjService() {
		return shjxjService;
	}
	
	@Autowired
	public void setShjxjService(ShjxjService shjxjService) {
		this.shjxjService = shjxjService;
	}
	
	private UserService userService;
	
	public UserService getUserService() {
        return userService;
    }
	@Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private StudentinfoService studentifnoService;
	public StudentinfoService getStudentifnoService() {
        return studentifnoService;
    }
	@Autowired
    public void setStudentifnoService(StudentinfoService studentifnoService) {
        this.studentifnoService = studentifnoService;
    }

	private StudentService studentService;
    public StudentService getStudentService() {
        return studentService;
    }
    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
    
    private StudentclassService studentclassService;

    public StudentclassService getStudentclassService() {
        return studentclassService;
    }
    @Autowired
    public void setStudentclassService(StudentclassService studentclassService) {
        this.studentclassService = studentclassService;
    }
    
    private InstitutionService institutionService;

    public InstitutionService getInstitutionService() {
        return institutionService;
    }
    @Autowired
    public void setInstitutionService(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }
    private WorkstepfolwService workstepflowService;

    public WorkstepfolwService getWorkstepflowService() {
        return workstepflowService;
    }
    @Autowired
    public void setWorkstepflowService(WorkstepfolwService workstepflowService) {
        this.workstepflowService = workstepflowService;
    }
    
    private MajorService majorService;

    public MajorService getMajorService() {
        return majorService;
    }
    @Autowired
    public void setMajorService(MajorService majorService) {
        this.majorService = majorService;
    }
    
    private InstructorService instructorService;
    public InstructorService getInstructorService() {
        return instructorService;
    }
    @Autowired
    public void setInstructorService(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/readStuShjxjInfo")
	public ModelAndView readStuShjxjInfo(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
		    String msg = "loginout";
		    HttpSession session = request.getSession();
		    User user = (User) session.getAttribute("user");
		    if (user != null){
		        msg = "success";
		        Student student = studentService.findStudentById(user.getUserId());
	            Studentinfo studentinfo = studentifnoService.obtainStudentInfoByStudId(student.getStudId());
	            Studentclass studentclass = studentclassService.obtainStudentClassByStudClassid(student.getStudClassid());
	            Institution institution = institutionService.findinstitutionByUserInstId(user.getUserInstid());
	            ShjxjWithBLOBs shjxj = shjxjService.showOneShjxjByStuID(student.getStudId());
	            Instructor instructor = 
	                    instructorService.findInstructorByPrimaryKey(studentclass.getClassInstid());
	            User instUser = userService.findUserById(instructor.getInstUserid());
	            Boolean state = true;//判断社会奖学金是否为空
	            // 业务逻辑
	            map.put("user", user);
	            map.put("student", student);
	            map.put("studentInfo", studentinfo);
	            map.put("studentclass", studentclass);
	            map.put("institution",institution);
	            map.put("instructor", instructor);
	            map.put("instName", instUser.getUserName());
	            if (shjxj != null){
	                map.put("shjxj", shjxj);
	                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	                String date = sdf.format(shjxj.getSjxjApplytime());
	                state = false;
	                map.put("date", date);
	                Workstepfolw workstepfolw = new Workstepfolw();
	                workstepfolw = workstepflowService.findWslfByWslfId(shjxj.getSjxjWsflid());
	                map.put("workstepfolw", workstepfolw);
	            }
	            map.put("state", state);
	            //获取工作流
		    }
		    map.put("result", Boolean.TRUE);
            map.put("message", msg);
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
    
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/addOneStudShjxj")
    public ModelAndView addOneStudShjxj(String sjBankNumber,String sjIspoor,String sjPoorRank,
            String sjInstructor,String sjInstrPhone,String sjStuDepartmentPhone,String sjPrizeSitu,
            String sjApplyReason,int sjReasonYear,int sjReasonMonth,int sjReasonDay,Boolean SaveorApply,
            HttpServletRequest request,HttpServletResponse response){
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            String msg = "loginout";
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user != null){
                msg = "success";
                Student student = studentService.findStudentById(user.getUserId());
                int StuID = student.getStudId();
                int situationId=1;//情况id，默认第一种情况；
                List<Role> roles = (List<Role>)session.getAttribute("role");
                for (int i = 0;i < roles.size();i++){
                    if (roles.get(i).getRoleId() == 8){//判断是否是当前工作的经办老师
                        situationId = 2;
                    }else if (roles.get(i).getRoleId() == 13){
                        situationId = 3;
                    }
                }
                Workstepfolw workstepfolw = workstepflowService.getWsflIdByWorkidAndSituation(8, situationId);
                int WsflId = 0;//工作流Id
                if (SaveorApply){//申请
                    WsflId = workstepfolw.getWsflNextstep();
                }else{//保存
                    WsflId = workstepfolw.getWsflCurrentstep();
                }
                ShjxjWithBLOBs shjxjWithBLOBs = shjxjService.findShjxjByStuId(StuID);
                Boolean first = true;//判定是否是第一次填写申请表
                if ( shjxjWithBLOBs != null){
                    first = false;
                }
                shjxjService.addOneStudShjxj(sjBankNumber,sjIspoor,sjPoorRank,
                        sjInstructor,sjInstrPhone,sjStuDepartmentPhone,sjPrizeSitu,
                        sjApplyReason,sjReasonYear,sjReasonMonth,sjReasonDay,StuID,
                        WsflId,first);
            }
            // 业务逻辑
            map.put("result", Boolean.TRUE);
            map.put("message", msg);
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
    
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/showStuAllShjxjInfo")
    public ModelAndView showStuAllShjxjInfo(int studId,HttpServletRequest request,HttpServletResponse response){
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            String msg = "loginout";
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user != null){
                Student student = studentService.findStudentByStuId(studId);
                Studentinfo studentinfo = studentifnoService.obtainStudentInfoByStudId(studId);
                Studentclass studentclass = studentclassService.obtainStudentClassByStudClassid(student.getStudClassid());
                Institution institution = institutionService.findinstitutionByUserInstId(user.getUserInstid());
                ShjxjWithBLOBs shjxj = shjxjService.showOneShjxjByStuID(studId);
                List<Role> roles = (List<Role>)session.getAttribute("role");
                int maxroleId = 1;//默认为学生
                if (user.getUserType() != 1){
                    for (int i = 0;i < roles.size();i++){//选出当前用户的最大角色id
                        if (roles.get(i).getRoleId() > maxroleId){
                            maxroleId = roles.get(i).getRoleId();
                        }
                    }
                    if (maxroleId >= 3 && maxroleId <= 12){//该范围内为经办老师，判断是不是当前工作的经办老师
                        if (maxroleId != 8)
                            maxroleId = 2;
                    }
                }
                map.put("maxroleId", maxroleId);
                Workstepfolw workstepfolw = workstepflowService.findWslfByWslfId(shjxj.getSjxjWsflid());
                int wsflRoldId = workstepfolw.getWsflRoleid();
                map.put("wsflRoldId", wsflRoldId);
                Boolean state = true;//默认该学生本年度的社会奖学金为空
                map.put("user", user);
                map.put("student", student);
                map.put("studentInfo", studentinfo);
                map.put("studentclass", studentclass);
                map.put("institution",institution);
                if (shjxj != null){
                    map.put("shjxj", shjxj);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String date = sdf.format(shjxj.getSjxjApplytime());
                    map.put("date",date);
                    state = false;//该学生本年度的社会奖学金不为空
                }
                map.put("state",state);
                msg = "success";
            }
            // 业务逻辑
            map.put("result", Boolean.TRUE);
            map.put("message", msg);
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
    
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/showAllColleages")
    public ModelAndView showAllColleages(HttpServletRequest request,HttpServletResponse response){
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            String msg = "loginout";
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            List <Institution> institutions = new ArrayList<Institution>();
            if (user != null){ 
                msg = "success";
                institutions = institutionService.findAllInstitutions();
                map.put("institutions", institutions);
                map.put("user", user);
            }
            // 业务逻辑
            map.put("result", Boolean.TRUE);
            map.put("message", msg);
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
    
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/showMajors")
    public ModelAndView showMajors(int institutionId,HttpServletRequest request,HttpServletResponse response){
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            String msg = "loginout";
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            List <Major> majors = new ArrayList<Major>();
            if (user != null){ 
                msg = "success";
                majors = majorService.selectByInstId(institutionId);
                map.put("majors", majors);
            }
            // 业务逻辑
            map.put("result", Boolean.TRUE);
            map.put("message", msg);
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
    
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/showClasses")
    public ModelAndView showClasses(Integer OnemajorId,HttpServletRequest request,HttpServletResponse response){
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            String msg = "loginout";
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            List <Studentclass> stuclassesList = new ArrayList<Studentclass>();
            if (user != null){ 
                msg = "success";
                stuclassesList = studentclassService.selectByMajorId(OnemajorId);
                map.put("stuclassesList", stuclassesList);
            }
            // 业务逻辑
            map.put("result", Boolean.TRUE);
            map.put("message", msg);
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
    
    //条件查询
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/showAllSutdSelective")
    public ModelAndView showAllSutdSelective(String annual,String colleageName,String majorName,
            String className,HttpServletRequest request,HttpServletResponse response){
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            String msg = "loginout";
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user != null){ 
                msg = "success";
                List<ShjxjWithBLOBs> shjxjWithBLOBs = shjxjService.findAllShjxj();
                List<StuNeededShowInfo> stuNeededShowInfos = new ArrayList<StuNeededShowInfo>();
                
                User studUser = new User();
                Student student = new Student();
                Studentclass studentclass = new Studentclass();
                Major major = new Major();
                Institution institution = new Institution();
                int wsflRoleids[] = new int[shjxjWithBLOBs.size()];
                Workstepfolw workstepfolw = new Workstepfolw();
                String shjxjApllyTime[] = new String[shjxjWithBLOBs.size()];
                int shjxjStates[] = new int[shjxjWithBLOBs.size()];
                int studId[] = new int[shjxjWithBLOBs.size()];
                int Index = 0;
                for (int i = 0;i < shjxjWithBLOBs.size();i++){
                    student = studentService.findStudentByStuId(shjxjWithBLOBs.get(i).getSjxjStudid());
                    studentclass = 
                            studentclassService.obtainStudentClassByStudClassid(student.getStudClassid());
                    if ( !className.equals("全部") && !studentclass.getClassName().equals(className) ){
                        continue;
                    }
                    major = majorService.obtainMajorByClassMajrid(studentclass.getClassMajrid());
                    if (!majorName.equals("全部") && !majorName.equals(major.getMajrName())){
                        continue;
                    }
                    studUser = userService.findUserById(student.getStudUserid());
                    institution = institutionService.findinstitutionByUserInstId(studUser.getUserInstid());
                    if (!colleageName.equals("全部") && !colleageName.equals(institution.getInstName())){
                        continue;
                    }
                    workstepfolw = workstepflowService.findWslfByWslfId
                            (shjxjWithBLOBs.get(i).getSjxjWsflid());
                    wsflRoleids[Index] = workstepfolw.getWsflRoleid();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String date = sdf.format(shjxjWithBLOBs.get(i).getSjxjApplytime());
                    shjxjApllyTime[Index] = date;
                    studId[Index] = student.getStudId();
                    shjxjStates[Index++] = shjxjWithBLOBs.get(i).getSjxjState();
                    StuNeededShowInfo stuNeededShowInfo = new StuNeededShowInfo();
                    stuNeededShowInfo.setStudInstShortName(institution.getInstShortname());
                    stuNeededShowInfo.setStudName(student.getStudName());
                    stuNeededShowInfo.setStudNumber(student.getStudNumber());
                    stuNeededShowInfo.setStudClassShortName(studentclass.getClassShortname());
                    stuNeededShowInfo.setStudMajorName(major.getMajrName());
                    //放进传回前台的列表
                    stuNeededShowInfos.add(stuNeededShowInfo);
                } 
                map.put("stuNeededShowInfos", stuNeededShowInfos);
                map.put("wsflRoleids", wsflRoleids);
                map.put("shjxjApllyTime", shjxjApllyTime);
                map.put("shjxjStates", shjxjStates);
                map.put("studId", studId);
                List<Role> roles = (List<Role>)session.getAttribute("role");
                int maxroleId = 1;//默认为学生
                if (user.getUserType() != 1){
                    for (int i = 0;i < roles.size();i++){//选出当前用户的最大角色id
                        if (roles.get(i).getRoleId() > maxroleId){
                            maxroleId = roles.get(i).getRoleId();
                        }
                    }
                    if (maxroleId >= 3 && maxroleId <= 12){//该范围内为经办老师，判断是不是当前工作的经办老师
                        if (maxroleId != 8)
                            maxroleId = 2;
                    }
                }
                map.put("maxroleId", maxroleId);
            }//user不为空的尾括号
            // 业务逻辑
            map.put("result", Boolean.TRUE);
            map.put("message", msg);
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
    
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/showSutdList")//显示查询到的学生列表
    public ModelAndView showSutdList(HttpServletRequest request,HttpServletResponse response){
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            String msg = "loginout";
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            List<Studentbasiinfo> studentbasiinfo = new ArrayList<Studentbasiinfo>();
            if (user != null){ 
                msg = "success";
                if (user.getUserType() == 1){
                    studentbasiinfo = (List<Studentbasiinfo>)session.getAttribute("studentbasiinfo");
                }else if (user.getUserType() == 2){
                    studentbasiinfo = (List<Studentbasiinfo>)session.getAttribute("studentbasiinfo1");
                }else if (user.getUserType() > 2 && user.getUserType() < 6){
                    studentbasiinfo = (List<Studentbasiinfo>)session.getAttribute("studentbasiinfo2");
                }
                List<Studentbasiinfo> shjxjstudInfo = new ArrayList<Studentbasiinfo>();
                int wsflRoleids[] = new int[5000];
                int shjxjStates[] = new int[5000];
                String shjxjApllyTime[] = new String[5000];
                int index = 0;
                int stuID = 0;
                Workstepfolw workstepfolw = new Workstepfolw();
                for (int i = 0;i < studentbasiinfo.size();i++){
                    stuID = studentbasiinfo.get(i).getStudentId();
                    ShjxjWithBLOBs shjxjWithBLOBs = shjxjService.showOneShjxjByStuID(stuID);
                    if (shjxjWithBLOBs != null){
                        shjxjstudInfo.add(studentbasiinfo.get(i));
                        workstepfolw = 
                                workstepflowService.findWslfByWslfId(shjxjWithBLOBs.getSjxjWsflid());
                        wsflRoleids[index] = workstepfolw.getWsflRoleid();
                        shjxjStates[index] = shjxjWithBLOBs.getSjxjState();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String date = sdf.format(shjxjWithBLOBs.getSjxjApplytime());
                        shjxjApllyTime[index++] = date;
                    }
                }
                List<Role> roles = (List<Role>)session.getAttribute("role");
                int maxroleId = 1;//默认为学生
                if (user.getUserType() != 1){
                    for (int i = 0;i < roles.size();i++){//选出当前用户的最大角色id
                        if (roles.get(i).getRoleId() > maxroleId){
                            maxroleId = roles.get(i).getRoleId();
                        }
                    }
                    if (maxroleId >= 3 && maxroleId <= 12){//该范围内为经办老师，判断是不是当前工作的经办老师
                        if (maxroleId != 8)
                            maxroleId = 2;
                    }
                }
                map.put("studentbasiinfo", studentbasiinfo);
                map.put("maxroleId", maxroleId);
                map.put("shjxjstudInfo", shjxjstudInfo);
                map.put("wsflRoleids", wsflRoleids);
                map.put("shjxjStates", shjxjStates);
                map.put("shjxjApllyTime", shjxjApllyTime);
            }
            // 业务逻辑
            map.put("result", Boolean.TRUE);
            map.put("message", msg);
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
    
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/checkApply")
    public ModelAndView checkApply(Boolean result,int studId,
            HttpServletRequest request,HttpServletResponse response){
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            String msg = "loginout";
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user != null){ 
                msg = "success";
                ShjxjWithBLOBs shjxjWithBLOBs = new ShjxjWithBLOBs();
                shjxjWithBLOBs = shjxjService.findShjxjByStuId(studId);
                Workstepfolw workstepfolw = 
                        workstepflowService.findWslfByWslfId(shjxjWithBLOBs.getSjxjWsflid());
                if (result){//为真即通过审核
                    shjxjWithBLOBs.setSjxjWsflid(workstepfolw.getWsflNextstep());
                }else{
                    shjxjWithBLOBs.setSjxjWsflid(workstepfolw.getWsflPrestep());
                }
                shjxjService.checkShjxj(shjxjWithBLOBs);
            }
            // 业务逻辑
            map.put("result", Boolean.TRUE);
            map.put("message", msg);
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
}
