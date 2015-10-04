package swust.edu.cn.zzxt.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import swust.edu.cn.zzxt.model.Instructor;
import swust.edu.cn.zzxt.model.Major;
import swust.edu.cn.zzxt.model.Role;
import swust.edu.cn.zzxt.model.Student;
import swust.edu.cn.zzxt.model.Studentclass;
import swust.edu.cn.zzxt.model.Sxpabx;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.selfmodel.ArticleModel;
import swust.edu.cn.zzxt.selfmodel.CountModal;
import swust.edu.cn.zzxt.selfmodel.PabxCountModle;
import swust.edu.cn.zzxt.selfmodel.Pabxbasicinfo;
import swust.edu.cn.zzxt.service.AnnouncementService;
import swust.edu.cn.zzxt.service.InstitutionService;
import swust.edu.cn.zzxt.service.InstructorService;
import swust.edu.cn.zzxt.service.MajorService;
import swust.edu.cn.zzxt.service.RoleService;
import swust.edu.cn.zzxt.service.StudentService;
import swust.edu.cn.zzxt.service.StudentclassService;
import swust.edu.cn.zzxt.service.SxpabxService;

@Controller
@RequestMapping("/paController")
public class PaController {
    
    private InstitutionService institutionService;
    private MajorService majorService;
    private StudentclassService studentclassService;    
    private AnnouncementService announcementService;
    private StudentService studentService;
    private SxpabxService  sxpabxService;
    private RoleService roleService;
    private InstructorService instructorService;
    
    
    public InstructorService getInstructorService() {
        return instructorService;
    }
    @Autowired
    public void setInstructorService(InstructorService instructorService) {
        this.instructorService = instructorService;
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
    public StudentclassService getStudentclassService() {
        return studentclassService;
    }
    @Autowired
    public void setStudentclassService(StudentclassService studentclassService) {
        this.studentclassService = studentclassService;
    }
   
	
	public SxpabxService getSxpabxService() {
        return sxpabxService;
    }
	 @Autowired
    public void setSxpabxService(SxpabxService sxpabxService) {
        this.sxpabxService = sxpabxService;
    }
    public RoleService getRoleService() {
        return roleService;
    }
    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
    public AnnouncementService getAnnouncementService() {
        return announcementService;
    }
	@Autowired
    public void setAnnouncementService(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }
    public StudentService getStudentService() {
        return studentService;
    }
    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
   
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/showPaIntroduction")
	public ModelAndView showPaIntroduction(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			ArticleModel articleModel=new ArticleModel();
			articleModel=announcementService.findWorkIntroduction(2);
			
			map.put("result", Boolean.TRUE);
			map.put("paIntroduction", articleModel);
			map.put("message", "执行成功！");
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
    
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/showPaPlan")
    public ModelAndView showPaPlan(HttpServletRequest request,HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            ArticleModel articleModel=new ArticleModel();
            articleModel=announcementService.findWorkIntroduction(7);
            
            map.put("result", Boolean.TRUE);
            map.put("paPlan", articleModel);
            map.put("message", "执行成功！");
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
/*20140716
 * Peter
 * 显示
 * 学生平安保险详情 
 * */
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/showPaDetail")
    public ModelAndView showPaDetail(String annual,int studentId, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
              try {
                  Student student = new Student();
                  student = studentService.findStudentByStudId(studentId);
                   List<Sxpabx> sxpabx=new ArrayList<Sxpabx>();  
                    List<Sxpabx> list =  sxpabxService.findSxpabxByStutId_Annual(annual,studentId);
                     if (list!=null && list.size()>0) {
                         sxpabx.addAll(list);
                    }else {
                        sxpabx=null;
                    } 
            map.put("result", Boolean.TRUE);  
            map.put("sxpabx", sxpabx);
            map.put("student", student);
            map.put("message", "执行成功！");
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
    
    
       ////////2014/08/02条件查找列表
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/showPaStud")
    public ModelAndView showPaStud(String annual,int colleageId,int majorId,int classId,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            User user = new User();
            HttpSession session = request.getSession();
            user = (User) session.getAttribute("user");
            List<Pabxbasicinfo> list = new ArrayList<Pabxbasicinfo>();
            int maxrole = user.getUserType();
            List<Role> role = (List<Role>) session.getAttribute("role");
            if(maxrole==3)
            {
                for(int i=0;i<role.size();i++)
                {
                    if(3==role.get(i).getRoleId())
                    {
                        maxrole=2;
                    }
                }
            }
            map.put("maxrole",maxrole);
            if(colleageId!=0)
            {
                if(majorId!=0)
                {
                    if(classId!=0)
                    {
                        list = sxpabxService.findPabxbasiinfoByClassId(classId);
                    }else
                    {
                        list = sxpabxService.findPabxbasiinfoByMajrId(majorId);
                    }
                }else
                {
                    list = sxpabxService.findPabxbasiinfoByInstId(colleageId);
                }
            }else
            {
                list = sxpabxService.selectAllPabxbasiinfo();
            }
            List<Pabxbasicinfo> pabxbasicinfo = new ArrayList<Pabxbasicinfo>();
            pabxbasicinfo.addAll(list);
            
            
            List<Pabxbasicinfo> pabxbasicinfo1 = new ArrayList<Pabxbasicinfo>();
            if (user.getUserType() != 1) {
                for (int i = 0; i < pabxbasicinfo.size(); i++) {
                    if (pabxbasicinfo.get(i).getBuyAnnual().equals(annual)) {
                        pabxbasicinfo1.add(pabxbasicinfo.get(i));
                    }
                }
            } else {
                for (int i = 0; i < pabxbasicinfo.size(); i++) {
                    pabxbasicinfo1.add(pabxbasicinfo.get(i));
                }
            }
            map.put("pabxbasicinfo", pabxbasicinfo1);
            map.put("result", Boolean.TRUE);
            map.put("message", "success");
            map.put("user", user);
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            map.put("message", "执行出现出错！");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }
    /*
     * Author chenwenhui,2014.07.25 查询所有学院
     */
    @SuppressWarnings({ "rawtypes", "unchecked", "finally"})
    @RequestMapping("/showAllInstitution")
    public ModelAndView showAllInstitution(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            User user = new User();
            HttpSession session = request.getSession();
            user = (User) session.getAttribute("user");
            List<Institution> institution = null;
            institution = new ArrayList<Institution>();
            if(user.getUserType()>=6)
            {
                institution=institutionService.findAllInstitutions();
            }else{
                System.out.println("hhh"+user.getUserInstid());
                Institution inst = institutionService.findinstitutionByMajorInstId(user.getUserInstid());
                System.out.println("hhh"+inst.getInstName());
                institution.add(inst);
            }
            System.out.println("hhh"+user.getUserInstid());
            map.put("result", Boolean.TRUE);
            map.put("message", "success");
            map.put("user", user);
            map.put("institution", institution);
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            map.put("message", "执行出现出错！");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }
    /*
     * Author chenwenhui,2014.07.25 按学院查询专业
     */
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/showMajor")
    public ModelAndView showMajor(int instId,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            User user = new User();
            HttpSession session = request.getSession();
            user = (User) session.getAttribute("user");
            List<Major> major = new ArrayList<Major>();
            if(user.getUserType()==3){
                List<Role> role = (List<Role>) session.getAttribute("role");
                int state=0;
                for(int i=0;i<role.size();i++)
                {
                    if(3==role.get(i).getRoleId())
                    {
                        state=1;
                    }
                }
                if(state==0){
                    user.setUserType(2);
                }
            }
            if(user.getUserType()>=6)
            {
                major = majorService.selectByInstId(instId);
            }else if(user.getUserType()>2){
                major = majorService.selectByInstId(user.getUserInstid());
            }else if(user.getUserType()==2){
                Instructor instructor = instructorService.findInstructorByUserId(user.getUserId());
                List<Studentclass> studentclass = studentclassService.selectByInstId(instructor.getInstId());
                List<Major> list = new ArrayList<Major>();
                for(int i=0;i<studentclass.size();i++)
                {
                    list.add(majorService.selectByPrimaryKey(studentclass.get(i).getClassMajrid()));
                }
                //去重
                for(int i=0;i<list.size();i++)
                {
                    boolean flag=true;
                    for(int j=0;j<major.size();j++)
                    {
                        if(list.get(i).getMajrId()==major.get(j).getMajrId())
                        {
                            flag=false;
                            break;
                        }
                    }
                    if(flag==true)
                    {
                    major.add(list.get(i));
                    }
                }
            }else{
                Student student = studentService.selectInfoByUser(user.getUserId());
                Studentclass studentclass = studentclassService.selectBystudInfoStudId(student.getStudClassid());
                Major major1 = new Major();
                System.out.println("hhh"+studentclass.getClassName());
                major1 = majorService.obtainMajorByClassMajrid(studentclass.getClassMajrid());
                major.add(major1);
            }
            map.put("major", major);
            map.put("result", Boolean.TRUE);
            map.put("message", "success");
            map.put("user", user);
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            map.put("message", "执行出现出错！");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }
    /*
     * Author chenwenhui,2014.07.25 按专业查询班级
     */
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/showClass")
    public ModelAndView showClass(int majorId,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            User user = new User();
            HttpSession session = request.getSession();
            user = (User) session.getAttribute("user");
            List<Studentclass> studentclass = new ArrayList<Studentclass>();
            if(user.getUserType()==3){
                List<Role> role = (List<Role>) session.getAttribute("role");
                int state=0;
                for(int i=0;i<role.size();i++)
                {
                    if(3==role.get(i).getRoleId())//判定是否是保险经办老师
                    {
                        state=1;
                    }
                }
                if(state==0){
                    user.setUserType(2);
                }
            }
            if(user.getUserType()>=3)
            {
                studentclass = studentclassService.selectByMajorId(majorId);
            }else if(user.getUserType()==2){
                Instructor instructor = instructorService.findInstructorByUserId(user.getUserId());
                List<Studentclass> list = studentclassService.selectByInstId(instructor.getInstId());
                for(int i=0;i<list.size();i++)
                {
                    if(list.get(i).getClassMajrid()==majorId)
                    {
                        studentclass.add(list.get(i));
                    }
                }
            }else{
                Student student = studentService.selectInfoByUser(user.getUserId());
                Studentclass studentclass1 = studentclassService.selectBystudInfoStudId(student.getStudClassid());
                studentclass.add(studentclass1);
            }
            map.put("studentclass", studentclass);
            map.put("result", Boolean.TRUE);
            map.put("message", "success");
            map.put("user", user);
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            map.put("message", "执行出现出错！");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }
  
////////2014/08/02/////////////////////////
@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
@RequestMapping("/showALLPaStud")
public ModelAndView showALLPaStud(String annual,HttpServletRequest request) {
    ModelAndView mav = new ModelAndView();
    MappingJacksonJsonView view = new MappingJacksonJsonView();
    Map map = new HashMap();
    try {
        User user = new User();
        HttpSession session = request.getSession();
        user = (User) session.getAttribute("user");
        List<Pabxbasicinfo> pabxbasicinfo = new ArrayList<Pabxbasicinfo>();
        if(user.getUserType()==1)
        {
            Student student = studentService.findStudentById(user.getUserId());            
            List<Pabxbasicinfo> pabxbasicinfo1=sxpabxService.findPabxbasiinfoByStudentId(student.getStudId());
            if(pabxbasicinfo1 !=null){
                pabxbasicinfo.addAll(pabxbasicinfo1);
            }                
        }else{
            // 获取用户最大角色
            List<Role> role = roleService.findRolesByUser(user);
            int maxrole = 0;
            for (int i = 0; i < role.size(); i++) {
                if (role.get(i).getRoleLevel() > maxrole) {
                    maxrole = role.get(i).getRoleLevel();
                }
            }
            if (maxrole == 3){ //判断保险经办老师
                maxrole = 2;
                for (int i = 0; i < role.size(); i++) {
                    if (role.get(i).getRoleId() == 3) {
                        maxrole = 3;
                    }
                }
            }
            //获取该角色所应看到的学生信息
            if (maxrole == 2)// 仅仅是辅导员
            {
                Instructor instructor = instructorService.findInstructorByUserId(user.getUserId());
                List<Studentclass> list = studentclassService.selectByInstId(instructor.getInstId());
                for(int i=0;i<list.size();i++)
                {
                    pabxbasicinfo.addAll(sxpabxService.findPabxbasiinfoByClassId(list.get(i).getClassId()));
                }
            } else if (maxrole < 6)// 经办老师或学办主任或分管委
            {
                pabxbasicinfo.addAll(sxpabxService.findPabxbasiinfoByInstId(user.getUserInstid()));
            } else {// 学生处处理有问题
                pabxbasicinfo.addAll(sxpabxService.selectAllPabxbasiinfo());
            }if(maxrole == 2)
            {
            map.put("maxrole",2);
            }
            else if(maxrole == 3)
            {
            map.put("maxrole",3);//经办老师
            }else if(maxrole == 4){
                map.put("maxrole",13);
            }else if(maxrole == 5){
                map.put("maxrole",14);
            }else if(maxrole == 6){
                map.put("maxrole",15);
            }else if(maxrole == 7){
                map.put("maxrole",16);
            }
            
        }

            List<Pabxbasicinfo> pabxbasicinfo1 = new ArrayList<Pabxbasicinfo>();
            if (user.getUserType() != 1) {
                for (int i = 0; i < pabxbasicinfo.size(); i++) {
                    if (pabxbasicinfo.get(i).getBuyAnnual().equals(annual)) {
                        pabxbasicinfo1.add(pabxbasicinfo.get(i));
                    }
                }
            } else {
                for (int i = 0; i < pabxbasicinfo.size(); i++) {
                    pabxbasicinfo1.add(pabxbasicinfo.get(i));
                }
            }
        map.put("result", Boolean.TRUE);
        map.put("message", "success");
        map.put("user", user);
        map.put("pabxbasicinfo", pabxbasicinfo1);
    } catch (Exception e) {
        map.put("result", Boolean.FALSE);
        map.put("message", "执行出现出错！");
        e.printStackTrace();
    } finally {
        view.setAttributesMap(map);
        mav.setView(view);
        return mav;
    }
}
/* * 
 * 数据信息统计
 * */
@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
@RequestMapping("/countColleage")
public ModelAndView countColleage(String annual, HttpServletRequest request) {
    ModelAndView mav = new ModelAndView();
    MappingJacksonJsonView view = new MappingJacksonJsonView();
    Map map = new HashMap();
    try {
       // 拥有这个统计的是学生处userType以上的
        User user = new User();
        HttpSession session = request.getSession();
        user = (User) session.getAttribute("user");
        List<Institution>  institutions = new ArrayList<Institution>();
        institutions=institutionService.findAllInstitutions();//找到所有学院
        List<PabxCountModle> countModals=new ArrayList<PabxCountModle>();
        List<Student> allStudent=null;//所有学生
      List<Pabxbasicinfo> buyStudent = new ArrayList<Pabxbasicinfo>();
        for(int i=0;i<institutions.size();i++){            
            PabxCountModle countModal=new PabxCountModle();
            int instId=institutions.get(i).getInstId();//获取学院Id
            int Allstudent=0;
            allStudent=studentService.findAllStudentByInstId(instId);//找到一个学院的所有学生
            Allstudent=allStudent.size();            
            buyStudent=sxpabxService.findPabxbasiinfoByInstId(instId);
            int buyNum=buyStudent.size();
            for(int j=0;j<buyStudent.size();j++){
                if (!buyStudent.get(j).getBuyAnnual().equals(annual)) {
                    buyNum--;
                }
            }
            countModal.setAllNum(Allstudent);//学院总人数
            countModal.setName(institutions.get(i).getInstShortname());//学院名称
            countModal.setBuyNum(buyNum);//购买人数
            countModals.add(countModal);
        }
        map.put("result", Boolean.TRUE);
        map.put("message", "success");
        map.put("user", user);
        map.put("countModals", countModals);
    } catch (Exception e) {
        map.put("result", Boolean.FALSE);
        map.put("message", "执行出现出错！");
        e.printStackTrace();
    } finally {
        view.setAttributesMap(map);
        mav.setView(view);
        return mav;
    }
}
@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
@RequestMapping("/countMajor")
public ModelAndView countMajor(String annual,int colleageId, HttpServletRequest request) {
    ModelAndView mav = new ModelAndView();
    MappingJacksonJsonView view = new MappingJacksonJsonView();
    Map map = new HashMap();
    try {
        User user = new User();
        HttpSession session = request.getSession();
        user = (User) session.getAttribute("user");
        List<PabxCountModle> countModals=new ArrayList<PabxCountModle>();
        List<Major> major = new ArrayList<Major>();
        List<Student> allStudent=null;//所有学生        
        major=majorService.selectByInstId(colleageId);//查找所有专业
        List<Pabxbasicinfo> buyStudent = new ArrayList<Pabxbasicinfo>();
        
        for(int i=0;i<major.size();i++){
            PabxCountModle countModal=new PabxCountModle();
            int majorId=major.get(i).getMajrId();
            allStudent=studentService.findAllStudentByMajorId(majorId);
            int allNum=allStudent.size();//所有的人数
            
            buyStudent=sxpabxService.findPabxbasiinfoByMajrId(majorId);
            int buyNum=buyStudent.size();
            for(int j=0;j<buyStudent.size();j++){
                if (!buyStudent.get(j).getBuyAnnual().equals(annual)) {
                    buyNum--;
                }
            }
            countModal.setAllNum(allNum);//专业总人数
            countModal.setBuyNum(buyNum);//专业购买人数
            countModal.setName(major.get(i).getMajrName());//专业名称
            countModals.add(countModal);  
        }
        map.put("result", Boolean.TRUE);
        map.put("message", "success");
        map.put("countModals", countModals);
    } catch (Exception e) {
        map.put("result", Boolean.FALSE);
        map.put("message", "执行出现出错！");
        e.printStackTrace();
    } finally {
        view.setAttributesMap(map);
        mav.setView(view);
        return mav;
    }
}
@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
@RequestMapping("/countClass")
public ModelAndView countClass(String annual,int colleageId, HttpServletRequest request) {
    ModelAndView mav = new ModelAndView();
    MappingJacksonJsonView view = new MappingJacksonJsonView();
    Map map = new HashMap();
    try {
        User user = new User();
        HttpSession session = request.getSession();
        user = (User) session.getAttribute("user");
        List<PabxCountModle> countModals=new ArrayList<PabxCountModle>();
        List<Studentclass> classes = new ArrayList<Studentclass>();
        List<Student> allStudent=null;//所有学生        
        classes=studentclassService.selectByInstitutionId(colleageId);//查找所有班级
        List<Pabxbasicinfo> buyStudent = new ArrayList<Pabxbasicinfo>();
        for(int i=0;i<classes.size();i++){
            PabxCountModle countModal=new PabxCountModle();
            int classId=classes.get(i).getClassId();
            allStudent=studentService.selectByClassId(classId);
            int allNum=allStudent.size();//所有的人数
            
            buyStudent=sxpabxService.findPabxbasiinfoByClassId(classId);
            int buyNum=buyStudent.size();
            for(int j=0;j<buyStudent.size();j++){
                if (!buyStudent.get(j).getBuyAnnual().equals(annual)) {
                    buyNum--;
                }
            }
            countModal.setAllNum(allNum);//专业总人数
            countModal.setBuyNum(buyNum);//专业购买人数
            countModal.setName(classes.get(i).getClassShortname());//专业名称
            countModals.add(countModal);  
        }
        map.put("result", Boolean.TRUE);
        map.put("message", "success");
        map.put("countModals", countModals);
    
    } catch (Exception e) {
        map.put("result", Boolean.FALSE);
        map.put("message", "执行出现出错！");
        e.printStackTrace();
    } finally {
        view.setAttributesMap(map);
        mav.setView(view);
        return mav;
    }
}
/* * 
 * 数据导出
 * */
@SuppressWarnings({"rawtypes", "finally", "unchecked"})
@RequestMapping("/export")
public ModelAndView export(HttpServletRequest request,HttpServletResponse response){
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            List<Pabxbasicinfo> list = new ArrayList<Pabxbasicinfo>();
            list = sxpabxService.selectAllPabxbasiinfo();
             WritableWorkbook book = null;
                try {
                    
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
                    String date = sdf.format(System.currentTimeMillis());
                    HttpSession session = request.getSession();
                    session.setAttribute("DownLoadDate", date);
                    String filePath = request.getSession().getServletContext()
                            .getRealPath("upload/pabxlist"+date+".xls");
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
                            //设置内容日期格式
                    String[] title = { "年度","姓名", "学号", "学院", "专业","班级","购买时间"}; 
                    for (int i = 0; i < title.length; i++) { 
                        Label excelTitle = new Label(i, 0, title[i],titleFormat); 
                        sheet.addCell(excelTitle); 
                        } 
                    if(list!=null && !list.isEmpty()){
                        for(int i=0; i<list.size(); i++){
                            sheet.addCell(new Label(0, i+1, list.get(i).getBuyAnnual()));
                            sheet.addCell(new Label(1, i+1, list.get(i).getStudentName()));
                            sheet.addCell(new Label(2, i+1, list.get(i).getStudentNumber()));
                            sheet.addCell(new Label(3, i+1, list.get(i).getInstName()));
                            sheet.addCell(new Label(4, i+1, list.get(i).getMajrName()));
                            sheet.addCell(new Label(5, i+1, list.get(i).getClassName()));
                            sheet.addCell(new Label(6, i+1, list.get(i).getBuyTime()));
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
            map.put("list", list);
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
 * 
 * @param id
 * @param request
 * @param response
 * @throws IOException
 */
    @SuppressWarnings("unused")
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void downloadFile(Integer id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            HttpSession session = request.getSession();
            String date = (String)session.getAttribute("DownLoadDate");
            String path = request.getSession().getServletContext().getRealPath("upload/pabxlist"+date+".xls");
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
