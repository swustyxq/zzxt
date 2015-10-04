package swust.edu.cn.zzxt.controller;

import java.util.HashMap;
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
import swust.edu.cn.zzxt.model.Student;
import swust.edu.cn.zzxt.model.Studentclass;
import swust.edu.cn.zzxt.model.Studentinfo;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.service.InstitutionService;
import swust.edu.cn.zzxt.service.InstructorService;
import swust.edu.cn.zzxt.service.MajorService;
import swust.edu.cn.zzxt.service.QyshjxjService;
import swust.edu.cn.zzxt.service.RoleService;
import swust.edu.cn.zzxt.service.StudentService;
import swust.edu.cn.zzxt.service.StudentclassService;
import swust.edu.cn.zzxt.service.StudentinfoService;
import swust.edu.cn.zzxt.service.UserService;
import swust.edu.cn.zzxt.service.WorkstepfolwService;

@Controller
@RequestMapping("/qyshjxjController")
public class QyshjxjController {

    private QyshjxjService qyshjxjService;
    private UserService userService;
    private MajorService majorService;
    private RoleService roleService;
    private StudentinfoService studentinfoService;
    private StudentService studentService;
    private StudentclassService studentclassService;
    private InstitutionService institutionService;
    private WorkstepfolwService workstepflowService;
    private InstructorService instructorService;
  
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

  
    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public MajorService getMajorService() {
        return majorService;
    }

    @Autowired
    public void setMajorService(MajorService majorService) {
        this.majorService = majorService;
    }

    public RoleService getRoleService() {
        return roleService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    public QyshjxjService getQyshjxjService() {
        return qyshjxjService;
    }

    @Autowired
    public void setQyshjxjService(QyshjxjService qyshjxjService) {
        this.qyshjxjService = qyshjxjService;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
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

    public WorkstepfolwService getWorkstepflowService() {
        return workstepflowService;
    }

    @Autowired
    public void setWorkstepflowService(WorkstepfolwService workstepflowService) {
        this.workstepflowService = workstepflowService;
    }
/*
*获取学生本人的信息
*初始化申请表
*Peter
*/
@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
@RequestMapping("/showApplyQyshjxjTable")
    public ModelAndView showApplyQyshjxjTable(int studId,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        User user = null;
        Student student = new Student();
          try {
              //业务逻辑,显示企业社会
            user = new User();
            HttpSession session = request.getSession();
            user = (User) session.getAttribute("user");
            map.put("user", user);
            
            if (user.getUserType() == 1) {                  
                student = studentService.findStudentById(user.getUserId());               
                Studentinfo studentinfo = studentinfoService.selectBystudInfoStudId(student.getStudId());             
                Studentclass studentclass = studentclassService.selectBystudInfoStudId(student.getStudClassid()); 
                Major major= majorService.selectByPrimaryKey(studentclass.getClassMajrid()); 
                Instructor instructor = instructorService.findInstructorByPrimaryKey(studentclass.getClassInstid());
                User instuser = userService.findUserById(instructor.getInstUserid());
                Institution institution=institutionService.findinstitutionByUserInstId(user.getUserInstid());
                               

                map.put("result", Boolean.TRUE);
                map.put("message", "success");
                map.put("student", student);
                map.put("studentinfo", studentinfo);
                map.put("studentclass", studentclass);
                map.put("instructor", instructor);
                map.put("major", major);
                map.put("instuser", instuser);
                map.put("institution", institution);
            }            
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
}

