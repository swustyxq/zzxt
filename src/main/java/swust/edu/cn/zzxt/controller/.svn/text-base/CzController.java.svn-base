package swust.edu.cn.zzxt.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import swust.edu.cn.zzxt.model.Announcement;
import swust.edu.cn.zzxt.model.Czylbx;
import swust.edu.cn.zzxt.model.Instructor;
import swust.edu.cn.zzxt.model.Institution;
import swust.edu.cn.zzxt.model.Prize;
import swust.edu.cn.zzxt.model.Role;
import swust.edu.cn.zzxt.model.Work;
import swust.edu.cn.zzxt.model.ShjxjWithBLOBs;
import swust.edu.cn.zzxt.model.Student;
import swust.edu.cn.zzxt.model.Studentclass;
import swust.edu.cn.zzxt.model.Studentinfo;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.model.Major;
import swust.edu.cn.zzxt.selfmodel.ArticleModel;
import swust.edu.cn.zzxt.selfmodel.CountModal;
import swust.edu.cn.zzxt.selfmodel.Czylbxbasicinfo;
import swust.edu.cn.zzxt.selfmodel.CzylCountModel;
import swust.edu.cn.zzxt.selfmodel.LstdListModel;
import swust.edu.cn.zzxt.selfmodel.Pabxbasicinfo;
import swust.edu.cn.zzxt.selfmodel.Studentbasiinfo;
import swust.edu.cn.zzxt.service.AnnouncementService;
import swust.edu.cn.zzxt.service.InstitutionService;
import swust.edu.cn.zzxt.service.CzylbxService;
import swust.edu.cn.zzxt.service.StudentService;
import swust.edu.cn.zzxt.service.MajorService;
import swust.edu.cn.zzxt.service.InstructorService;
import swust.edu.cn.zzxt.service.StudentclassService;
import swust.edu.cn.zzxt.service.StudentinfoService;
import swust.edu.cn.zzxt.service.RoleService;
import swust.edu.cn.zzxt.service.WorkService;

@Controller
@RequestMapping("/czController")
public class CzController {
    private WorkService workService;
    private StudentinfoService studentinfoService;
    private RoleService roleService;
    private MajorService majorService;
    private InstitutionService institutionService;
    private StudentclassService studentclassService;
    private InstructorService instructorService;
    private AnnouncementService announcementService;
    private StudentService studentService;
    private CzylbxService czylbxService;

    public CzylbxService getCzylbxService() {
        return czylbxService;
    }

    @Autowired
    public void setCzylbxService(CzylbxService czylbxService) {
        this.czylbxService = czylbxService;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public AnnouncementService getAnnouncementService() {
        return announcementService;
    }

    @Autowired
    public void setAnnouncementService(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    public InstructorService getInstructorService() {
        return instructorService;
    }

    @Autowired
    public void setInstructorService(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    private List<Czylbxbasicinfo> allCzylList;

    public List<Czylbxbasicinfo> getAllCzylList() {
        return allCzylList;
    }

    public StudentclassService getStudentclassService() {
        return studentclassService;
    }

    public void setAllCzylList(List<Czylbxbasicinfo> allCzylList) {
        this.allCzylList = allCzylList;
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
    public RoleService getRoleService() {
        return roleService;
    }
    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
    public StudentinfoService getStudentinfoService() {
        return studentinfoService;
    }
    @Autowired
    public void setStudentinfoService(StudentinfoService studentinfoService) {
        this.studentinfoService = studentinfoService;
    }
    public WorkService getWorkService() {
        return workService;
    }
    @Autowired
    public void setWorkService(WorkService workService) {
        this.workService = workService;
    }
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/showCzIntroduction")
    public ModelAndView showCzIntroduction(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            ArticleModel articleModel = new ArticleModel();
            articleModel = announcementService.findCzIntroduction();

            map.put("result", Boolean.TRUE);
            map.put("czIntroduction", articleModel);
            map.put("message", "执行成功！");
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
     * Author shaozhou,2014.07.07
     */
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/showCzDetail")
    public ModelAndView showCzDetail(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            int id = user.getUserId();
            Czylbx czylbx = new Czylbx();// 分配了内存空间，指向new Czylbx()所创建的内存空间
            Student student = new Student();

            if (user.getUserType() != null) {
                if (user.getUserType() == 1) {
                    student = studentService.findStudentById(id);
                    List<Czylbx> list = czylbxService.findCzylbxsByStudentId(student.getStudId());
                    if (list != null && list.size() > 0) {
                        czylbx = list.get(0);
                    } else {
                        czylbx = null;
                    }
                } else {
                    student = null;
                    czylbx = null;
                }
            } else {
                student = null;
                czylbx = null;
            }

            map.put("result", Boolean.TRUE);
            map.put("czylbx", czylbx);
            map.put("student", student);
            map.put("message", "执行成功！");
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
    @RequestMapping("/checkYear")
    // 查找对应年限的对应的czylbx
    public ModelAndView checkYear(String year, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            int id = user.getUserId();
            int i;
            Czylbx czylbx = new Czylbx();// 分配了内存空间，指向new Czylbx()所创建的内存空间
            Student student = new Student();

            if (user.getUserType() != null) {
                if (user.getUserType() == 1) {
                    Work work=new Work();
                    student = studentService.findStudentById(id);
                    List<Czylbx> list = czylbxService.findCzylbxsByStudentId(student.getStudId());
                    Studentinfo studentinfo = new Studentinfo();
                    studentinfo = studentinfoService.obtainStudentInfoByStudId(student.getStudId());
                    if (list != null && list.size() > 0) {
                        for (i = 0; i < list.size(); i++) {
                            czylbx = list.get(i);
                            if (czylbx.getCzlyBuyannual().equals(year)) {
                                break;
                            }
                        }
                        work=workService.selectByWorkId(czylbx.getCzylWorkid());
                        if (i == list.size()) {
                            map.put("result", Boolean.FALSE);
                            map.put("message", "无"+year+"年度信息！");
                        } else {

                            map.put("result", Boolean.TRUE);
                            map.put("czylbx", czylbx);
                            map.put("studentinfo", studentinfo);
                            map.put("student", student);
                            map.put("message", "执行成功！");
                            map.put("year", year);
                            map.put("work", work);
                            map.put("choose", czylbx.getCzlyIsneed());
                        }
                    } else {
                        czylbx = null;
                        map.put("result", Boolean.FALSE);
                        map.put("message", "暂无任何信息！");
                    }
                } else {
                    student = null;
                    czylbx = null;
                }
            } else {
                student = null;
                czylbx = null;

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

    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/showAllCzylInfo")
    public ModelAndView showAllCzylInfo(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            int id = user.getUserId();
            List<Czylbx> czylbx = new ArrayList<Czylbx>();// 分配了内存空间，指向new Czylbx()所创建的内存空间
            Student student = new Student();
            Studentinfo studentinfo = new Studentinfo();
            if (user.getUserType() != null) {
                if (user.getUserType() == 1) {
                    student = studentService.findStudentById(id);
                    List<Czylbx> list = czylbxService.findCzylbxsByStudentId(student.getStudId());
                    
                    studentinfo = studentinfoService.obtainStudentInfoByStudId(student.getStudId());
                    if (list != null && list.size() > 0) {
                        czylbx = list;

                    } else {
                        czylbx = null;
                    }

                } else {
                    student = null;
                    czylbx = null;
                }
            } else {
                student = null;
                czylbx = null;
            }

            map.put("result", Boolean.TRUE);
            map.put("czylbx", czylbx);
            map.put("studentinfo",studentinfo);
            map.put("student", student);
            map.put("message", "执行成功！");
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
    @RequestMapping("/fillOrEditWill")
    // 查找对应年限的对应的czylbx
    public ModelAndView fillOrEditWill(int stuWill,String year ,HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            int id = user.getUserId();
            Czylbx czylbx = new Czylbx();// 分配了内存空间，指向new Czylbx()所创建的内存空间
            Student student = new Student();
            if (user.getUserType() != null) {
                if (user.getUserType() == 1) {
                    student = studentService.findStudentById(id);
                    List<Czylbx> list = czylbxService.findCzylbxsByStudentId(student.getStudId());
                    if (list != null && list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            czylbx = list.get(i);
                            if (czylbx.getCzlyBuyannual().equals(year)) {
                                break;
                            }
                        }
                        int czylbxId = czylbx.getCzylId();
                        czylbxService.EditInfoByCzlybxId(czylbxId, stuWill);

                    } else {
                        czylbx = null;
                    }
                } else {
                    student = null;
                    czylbx = null;
                }
            } else {
                student = null;
                czylbx = null;
            }

            map.put("result", Boolean.TRUE);
            map.put("message", "执行成功！");
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
    @RequestMapping("/editWills")
    public ModelAndView editWills(int czylwill,int czylbxId,HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");                    
            if (user.getUserType() != null) {
                if (user.getUserType() > 1) {

                       
                        czylbxService.EditInfoByCzlybxId(czylbxId, czylwill);
                        map.put("result", Boolean.TRUE);
                        map.put("message", "执行成功！");

                    }else{
                        map.put("result", Boolean.FALSE);
                        map.put("message", "没有可操作的权限！");
                    }
            }else{
                map.put("result", Boolean.FALSE);
                map.put("message", "没有可操作的权限！");
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
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/findoneCzyl")
    // 显示查询到的学生列表
    public ModelAndView findoneCzyl(int stuId, String year, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {

            List<Czylbx> czylbx1 = new ArrayList<Czylbx>();
            Czylbx czylbx = new Czylbx();
            Student student = new Student();
            student = studentService.findStudentByStudId(stuId);
            czylbx1 = czylbxService.findCzylbxsByYearAndStudentId(stuId, year);
            Studentinfo studentinfo = new Studentinfo();
            studentinfo = studentinfoService.obtainStudentInfoByStudId(stuId);
            if (czylbx1.size() > 0) {
                czylbx = czylbx1.get(0);
            }
            map.put("czylbx", czylbx);
            map.put("student", student);
            map.put("studentinfo", studentinfo);
            // 业务逻辑
            map.put("result", Boolean.TRUE);

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
    @RequestMapping("/showALLCzStud")
    public ModelAndView showALLCzStud(String year,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            User user = new User();
            HttpSession session = request.getSession();
            user = (User) session.getAttribute("user");
          //  List<Studentbasiinfo> studentbasiinfo = new ArrayList<Studentbasiinfo>();
            List<Czylbxbasicinfo> czylbxbasicinfo = new ArrayList<Czylbxbasicinfo>();
            List<Czylbxbasicinfo> czylbxbasicinfo2 = new ArrayList<Czylbxbasicinfo>();
            if(user.getUserType()==1)
            {
                Student student = studentService.findStudentById(user.getUserId());
               
                Czylbxbasicinfo czylbxbasicinfo1=czylbxService.findCzylbxbasiinfoByStudentId(student.getStudId());
                if(czylbxbasicinfo1 !=null){
                    czylbxbasicinfo.add(czylbxbasicinfo1);
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
                        czylbxbasicinfo2.addAll(czylbxService.findCzylbxbasiinfoByClassId(list.get(i).getClassId()));
                    }
                 
                    
                } else if (maxrole < 6)// 经办老师或学办主任或分管委
                {
                    czylbxbasicinfo2.addAll(czylbxService.findCzylbxbasiinfoByInstId(user.getUserInstid()));
                } else {// 学生处处理有问题
                    czylbxbasicinfo2.addAll(czylbxService.selectAllCzylbxbasiinfo());
                }
                for(int i=0;i<czylbxbasicinfo2.size();i++){
                    if(czylbxbasicinfo2.get(i).getczlyBuyAnnual().equals(year)){
                    czylbxbasicinfo.add(czylbxbasicinfo2.get(i));
                    }
                }
                
                if(maxrole == 2)
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
            if(czylbxbasicinfo.size()==0)
            {
                map.put("user", user);
                map.put("result", Boolean.FALSE);
                map.put("message", "没有任何信息！");
            }else{
                
                setAllCzylList(czylbxbasicinfo);
                int recordCount = czylbxbasicinfo.size();//总记录数
                int pageCount;//总页数
                int temp = recordCount % 50;//50条记录一页
                if(temp == 0){
                    pageCount = recordCount/50;
                }else{
                    pageCount = recordCount/50 + 1;
                }
                List<Czylbxbasicinfo> firstCzylList = new ArrayList<Czylbxbasicinfo>();
                int max = 0;
                int page = 1;
                max = allCzylList.size()>page*50?page*50:allCzylList.size();
                for(int j=(page-1)*50;j<max;j++)
                {
                    firstCzylList.add(allCzylList.get(j));
                }
            
            map.put("result", Boolean.TRUE);
            map.put("message", "success");
            map.put("user", user);
            map.put("czylbxbasicinfo", czylbxbasicinfo);
            map.put("firstCzylList",firstCzylList);
            map.put("pageCount", pageCount);
            map.put("page", page);
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
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/showstatistics")
    public ModelAndView showstatistics(String year,int nameid,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            User user = new User();
            HttpSession session = request.getSession();
            user = (User) session.getAttribute("user");
            int num = 0;
            int num1 = 0;
            int num2 = 0;
            int num3 = 0;
            String name="";
            List<Czylbxbasicinfo> czylbxbasicinfo = new ArrayList<Czylbxbasicinfo>();
            List<Czylbxbasicinfo> czylbxbasicinfo2 = new ArrayList<Czylbxbasicinfo>();
            List<Czylbxbasicinfo> czylbxbasicinfo3 = new ArrayList<Czylbxbasicinfo>();
            if(user.getUserType()==1)
            {
                Student student = studentService.findStudentById(user.getUserId());
               
                Czylbxbasicinfo czylbxbasicinfo1=czylbxService.findCzylbxbasiinfoByStudentId(student.getStudId());
                if(czylbxbasicinfo1 !=null){
                    czylbxbasicinfo.add(czylbxbasicinfo1);
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
                        czylbxbasicinfo2.addAll(czylbxService.findCzylbxbasiinfoByClassId(list.get(i).getClassId()));
                    }
                    for(int i=0;i<czylbxbasicinfo2.size();i++){
                        if(czylbxbasicinfo2.get(i).getczlyBuyAnnual().equals(year)){
                        czylbxbasicinfo3.add(czylbxbasicinfo2.get(i));
                        }
                    }
                    if(nameid!=0){
                        Studentclass studclass = new Studentclass();
                        studclass=studentclassService.obtainStudentClassByStudClassid(nameid);
                        name = studclass.getClassName();
                    for(int i=0;i<czylbxbasicinfo3.size();i++){
                        if(czylbxbasicinfo3.get(i).getClassName().equals(name)){
                        czylbxbasicinfo.add(czylbxbasicinfo3.get(i));
                        }
                    }
                }
                } else if (maxrole < 6)// 经办老师或学办主任或分管委
                {

                    czylbxbasicinfo2.addAll(czylbxService.findCzylbxbasiinfoByInstId(user.getUserInstid()));
                    for(int i=0;i<czylbxbasicinfo2.size();i++){
                        if(czylbxbasicinfo2.get(i).getczlyBuyAnnual().equals(year)){
                        czylbxbasicinfo3.add(czylbxbasicinfo2.get(i));
                        }
                    }
                    if(nameid!=0){                  
                        Major major = new Major();
                        major = majorService.obtainMajorByClassMajrid(nameid);
                        name = major.getMajrName();
                    for(int i=0;i<czylbxbasicinfo3.size();i++){
                        if(czylbxbasicinfo3.get(i).getMajrName().equals(name)){
                        czylbxbasicinfo.add(czylbxbasicinfo3.get(i));
                        }
                    }
                }
                } else {// 学生处处理有问题                                                        
                    czylbxbasicinfo2.addAll(czylbxService.selectAllCzylbxbasiinfo());
                    for(int i=0;i<czylbxbasicinfo2.size();i++){
                        if(czylbxbasicinfo2.get(i).getczlyBuyAnnual().equals(year)){
                        czylbxbasicinfo3.add(czylbxbasicinfo2.get(i));
                        }
                    }
                    if(nameid!=0){
                        Institution institution = new Institution();
                        institution = institutionService.findinstitutionByUserInstId(nameid);
                    name = institution.getInstName();
                    for(int i=0;i<czylbxbasicinfo3.size();i++){
                        if(czylbxbasicinfo3.get(i).getInstName().equals(name)){
                        czylbxbasicinfo.add(czylbxbasicinfo3.get(i));
                        }
                    }
                }
                }
               
                if(nameid!=0){
                num=czylbxbasicinfo.size();  
                for(int i=0;i<czylbxbasicinfo.size();i++){
                    if(czylbxbasicinfo.get(i).getczlyIsneed()==null){
                        num3++; 
                    }
                     else if(czylbxbasicinfo.get(i).getczlyIsneed().equals("1"))
                    {
                       num1++; 
                    }else if(czylbxbasicinfo.get(i).getczlyIsneed().equals("0")){
                        num2++;  
                    }
                    
                }
                }else{
                  //  if(maxrole!=2)
                 //   {
                    num=czylbxbasicinfo3.size();  
                    for(int i=0;i<czylbxbasicinfo3.size();i++){
                        if(czylbxbasicinfo3.get(i).getczlyIsneed()==null){
                            num3++; 
                        }
                         else if(czylbxbasicinfo3.get(i).getczlyIsneed().equals("1"))
                        {
                           num1++; 
                        }else if(czylbxbasicinfo3.get(i).getczlyIsneed().equals("0")){
                            num2++;  
                        }
                        
                   // }
                   
                }
                    name="所有";
            }                       
            }
            if(czylbxbasicinfo3.size()==0)
            {
                map.put("result", Boolean.FALSE);
                map.put("message", "没有任何信息！");
            }else{
                
            map.put("result", Boolean.TRUE);
            map.put("message", "success");
            map.put("userType",user.getUserType());
            map.put("num", num);
            map.put("num1", num1);
            map.put("num2", num2);
            map.put("num3", num3);
            map.put("name", name);
        
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
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/show")
    public ModelAndView show(String year,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            User user = new User();
            HttpSession session = request.getSession();
            user = (User) session.getAttribute("user");

          
            List<CzylCountModel> countModals = new ArrayList<CzylCountModel>();
                               
          if(user.getUserType()>=6){
              List<Institution> institutions = new ArrayList<Institution>();

              institutions = institutionService.findAllInstitutions();
              for(int i=1;i<=institutions.size();i++){
                  int num1 = 0;
                  int num2 = 0;
                  int num3 = 0;
           
                  List<Czylbxbasicinfo> czylbxbasicinfo2 = new ArrayList<Czylbxbasicinfo>();
                  List<Czylbxbasicinfo> czylbxbasicinfo3 = new ArrayList<Czylbxbasicinfo>();
                  CzylCountModel countModal= new CzylCountModel();
                  
                  czylbxbasicinfo2.addAll(czylbxService.findCzylbxbasiinfoByInstId(i));
                  for(int j=0;j<czylbxbasicinfo2.size();j++){
                  if(czylbxbasicinfo2.get(j).getczlyBuyAnnual().equals(year)){
                  czylbxbasicinfo3.add(czylbxbasicinfo2.get(j));
                  }
               } 
                  for(int k=0; k<czylbxbasicinfo3.size();k++){    
                      if(czylbxbasicinfo3.get(k).getczlyIsneed()==null){
                          num3++; 
                      }
                       else if(czylbxbasicinfo3.get(k).getczlyIsneed().equals("1"))
                      {
                         num1++; 
                      }else if(czylbxbasicinfo3.get(k).getczlyIsneed().equals("0")){
                          num2++;  
                      }
                  }
                  
                 countModal.setSum(czylbxbasicinfo3.size());
                 countModal.setApplyYessum(num1);
                 countModal.setApplyNosum(num2);
                 countModal.setNullsum(num3);
                 countModal.setInstid(i);
                 countModal.setName(institutions.get(i-1).getInstName());
                 countModals.add(countModal);
                  }
               
              }
                                   
            map.put("result", Boolean.TRUE);
            map.put("message", "success");
            map.put("userType",user.getUserType());
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
    @RequestMapping("/countByMajor")
    public ModelAndView countByMajor(String year,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            User user = new User();
            HttpSession session = request.getSession();
            user = (User) session.getAttribute("user");

          
            List<CzylCountModel> countModals = new ArrayList<CzylCountModel>();
                               
          if(user.getUserType()>=2&&user.getUserType()<4){

              Instructor instructor = instructorService.findInstructorByUserId(user.getUserId());
              List<Studentclass> studentclass = studentclassService.selectByInstId(instructor.getInstId());
              List<Major> list = new ArrayList<Major>();
              List<Major> major = new ArrayList<Major>();
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
                         
              for(int i=0;i<major.size();i++){
                  int num1 = 0;
                  int num2 = 0;
                  int num3 = 0;
           
                  List<Czylbxbasicinfo> czylbxbasicinfo2 = new ArrayList<Czylbxbasicinfo>();
                  List<Czylbxbasicinfo> czylbxbasicinfo3 = new ArrayList<Czylbxbasicinfo>();
                  CzylCountModel countModal= new CzylCountModel();
                  
                  czylbxbasicinfo2.addAll(czylbxService.findCzylbxbasiinfoByMajrId(major.get(i).getMajrId()));
                  for(int j=0;j<czylbxbasicinfo2.size();j++){
                  if(czylbxbasicinfo2.get(j).getczlyBuyAnnual().equals(year)){
                  czylbxbasicinfo3.add(czylbxbasicinfo2.get(j));
                  }
               } 
                  for(int k=0; k<czylbxbasicinfo3.size();k++){    
                      if(czylbxbasicinfo3.get(k).getczlyIsneed()==null){
                          num3++; 
                      }
                       else if(czylbxbasicinfo3.get(k).getczlyIsneed().equals("1"))
                      {
                         num1++; 
                      }else if(czylbxbasicinfo3.get(k).getczlyIsneed().equals("0")){
                          num2++;  
                      }
                  }
                  
                 countModal.setSum(czylbxbasicinfo3.size());
                 countModal.setApplyYessum(num1);
                 countModal.setApplyNosum(num2);
                 countModal.setNullsum(num3);
                 countModal.setInstid(i);
                 countModal.setName(major.get(i).getMajrName());
                 countModals.add(countModal);
                  }
               
              }else if(user.getUserType()>=4&&user.getUserType()<6){
                  List<Major> major = new ArrayList<Major>();
                  major = majorService.selectByInstId(user.getUserInstid());
                  for(int i=0;i<major.size();i++){
                      int num1 = 0;
                      int num2 = 0;
                      int num3 = 0;
               
                      List<Czylbxbasicinfo> czylbxbasicinfo2 = new ArrayList<Czylbxbasicinfo>();
                      List<Czylbxbasicinfo> czylbxbasicinfo3 = new ArrayList<Czylbxbasicinfo>();
                      CzylCountModel countModal= new CzylCountModel();
                      
                      czylbxbasicinfo2.addAll(czylbxService.findCzylbxbasiinfoByMajrId(major.get(i).getMajrId()));
                      for(int j=0;j<czylbxbasicinfo2.size();j++){
                      if(czylbxbasicinfo2.get(j).getczlyBuyAnnual().equals(year)){
                      czylbxbasicinfo3.add(czylbxbasicinfo2.get(j));
                      }
                   } 
                      for(int k=0; k<czylbxbasicinfo3.size();k++){    
                          if(czylbxbasicinfo3.get(k).getczlyIsneed()==null){
                              num3++; 
                          }
                           else if(czylbxbasicinfo3.get(k).getczlyIsneed().equals("1"))
                          {
                             num1++; 
                          }else if(czylbxbasicinfo3.get(k).getczlyIsneed().equals("0")){
                              num2++;  
                          }
                      }
                      
                     countModal.setSum(czylbxbasicinfo3.size());
                     countModal.setApplyYessum(num1);
                     countModal.setApplyNosum(num2);
                     countModal.setNullsum(num3);
                     countModal.setInstid(i);
                     countModal.setName(major.get(i).getMajrName());
                     countModals.add(countModal);
                      }
                   
              }
                                   
            map.put("result", Boolean.TRUE);
            map.put("message", "success");
            map.put("userType",user.getUserType());
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
    @RequestMapping("/countByClass")
    public ModelAndView countByClass(String year,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            User user = new User();
            HttpSession session = request.getSession();
            user = (User) session.getAttribute("user");

          
            List<CzylCountModel> countModals = new ArrayList<CzylCountModel>();
                               
          if(user.getUserType()>=2&&user.getUserType()<4){

              Instructor instructor = instructorService.findInstructorByUserId(user.getUserId());
              List<Studentclass> studentclass = studentclassService.selectByInstId(instructor.getInstId());                                       
              for(int i=0;i<studentclass.size();i++){
                  int num1 = 0;
                  int num2 = 0;
                  int num3 = 0;
           
                  List<Czylbxbasicinfo> czylbxbasicinfo2 = new ArrayList<Czylbxbasicinfo>();
                  List<Czylbxbasicinfo> czylbxbasicinfo3 = new ArrayList<Czylbxbasicinfo>();
                  CzylCountModel countModal= new CzylCountModel();
                  
                  czylbxbasicinfo2.addAll(czylbxService.findCzylbxbasiinfoByClassId(studentclass.get(i).getClassId()));
                  for(int j=0;j<czylbxbasicinfo2.size();j++){
                  if(czylbxbasicinfo2.get(j).getczlyBuyAnnual().equals(year)){
                  czylbxbasicinfo3.add(czylbxbasicinfo2.get(j));
                  }
               } 
                  for(int k=0; k<czylbxbasicinfo3.size();k++){    
                      if(czylbxbasicinfo3.get(k).getczlyIsneed()==null){
                          num3++; 
                      }
                       else if(czylbxbasicinfo3.get(k).getczlyIsneed().equals("1"))
                      {
                         num1++; 
                      }else if(czylbxbasicinfo3.get(k).getczlyIsneed().equals("0")){
                          num2++;  
                      }
                  }
                  
                 countModal.setSum(czylbxbasicinfo3.size());
                 countModal.setApplyYessum(num1);
                 countModal.setApplyNosum(num2);
                 countModal.setNullsum(num3);
                 countModal.setInstid(i);
                 countModal.setName(studentclass.get(i).getClassName());
                 countModals.add(countModal);
                  }
               
              }else if(user.getUserType()>=4&&user.getUserType()<6){
                  List<Major> major = new ArrayList<Major>();
                  major = majorService.selectByInstId(user.getUserInstid());
                  List<Studentclass> studentclass =  new ArrayList<Studentclass>();
                  for(int i=0;i<major.size();i++){
                      studentclass.addAll(studentclassService.selectByMajorId(major.get(i).getMajrId()));
                  }
                  
                  for(int i=0;i<studentclass.size();i++){
                      int num1 = 0;
                      int num2 = 0;
                      int num3 = 0;
               
                      List<Czylbxbasicinfo> czylbxbasicinfo2 = new ArrayList<Czylbxbasicinfo>();
                      List<Czylbxbasicinfo> czylbxbasicinfo3 = new ArrayList<Czylbxbasicinfo>();
                      CzylCountModel countModal= new CzylCountModel();
                      
                      czylbxbasicinfo2.addAll(czylbxService.findCzylbxbasiinfoByClassId(studentclass.get(i).getClassId()));
                      for(int j=0;j<czylbxbasicinfo2.size();j++){
                      if(czylbxbasicinfo2.get(j).getczlyBuyAnnual().equals(year)){
                      czylbxbasicinfo3.add(czylbxbasicinfo2.get(j));
                      }
                   } 
                      for(int k=0; k<czylbxbasicinfo3.size();k++){    
                          if(czylbxbasicinfo3.get(k).getczlyIsneed()==null){
                              num3++; 
                          }
                           else if(czylbxbasicinfo3.get(k).getczlyIsneed().equals("1"))
                          {
                             num1++; 
                          }else if(czylbxbasicinfo3.get(k).getczlyIsneed().equals("0")){
                              num2++;  
                          }
                      }
                      
                     countModal.setSum(czylbxbasicinfo3.size());
                     countModal.setApplyYessum(num1);
                     countModal.setApplyNosum(num2);
                     countModal.setNullsum(num3);
                     countModal.setInstid(i);
                     countModal.setName(studentclass.get(i).getClassName());
                     countModals.add(countModal);
                      }
                   
              }
                                   
            map.put("result", Boolean.TRUE);
            map.put("message", "success");
            map.put("userType",user.getUserType());
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
    @RequestMapping("/showOnePageCzStud")
    public ModelAndView showOnePageCzStud(String year,int page,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            User user = new User();
            HttpSession session = request.getSession();
            user = (User) session.getAttribute("user");
          //  List<Studentbasiinfo> studentbasiinfo = new ArrayList<Studentbasiinfo>();
            List<Czylbxbasicinfo> czylbxbasicinfo = new ArrayList<Czylbxbasicinfo>();
            List<Czylbxbasicinfo> czylbxbasicinfo2 = new ArrayList<Czylbxbasicinfo>();
            if(user.getUserType()==1)
            {
                Student student = studentService.findStudentById(user.getUserId());
               
                Czylbxbasicinfo czylbxbasicinfo1=czylbxService.findCzylbxbasiinfoByStudentId(student.getStudId());
                if(czylbxbasicinfo1 !=null){
                    czylbxbasicinfo.add(czylbxbasicinfo1);
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
                        czylbxbasicinfo2.addAll(czylbxService.findCzylbxbasiinfoByClassId(list.get(i).getClassId()));
                    }
                 
                    
                } else if (maxrole < 6)// 经办老师或学办主任或分管委
                {
                    czylbxbasicinfo2.addAll(czylbxService.findCzylbxbasiinfoByInstId(user.getUserInstid()));
                } else {// 学生处处理有问题
                    czylbxbasicinfo2.addAll(czylbxService.selectAllCzylbxbasiinfo());
                }
                for(int i=0;i<czylbxbasicinfo2.size();i++){
                    if(czylbxbasicinfo2.get(i).getczlyBuyAnnual().equals(year)){
                    czylbxbasicinfo.add(czylbxbasicinfo2.get(i));
                    }
                }
                
                if(maxrole == 2)
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
            if(czylbxbasicinfo.size()==0)
            {
                map.put("result", Boolean.FALSE);
                map.put("message", "没有任何信息！");
            }else{
                
                setAllCzylList(czylbxbasicinfo);
                int recordCount = czylbxbasicinfo.size();//总记录数
                int pageCount;//总页数
                int temp = recordCount % 50;//50条记录一页
                if(temp == 0){
                    pageCount = recordCount/50;
                }else{
                    pageCount = recordCount/50 + 1;
                }
                List<Czylbxbasicinfo> pageCzylList = new ArrayList<Czylbxbasicinfo>();
                int max = 0;
              
                max = allCzylList.size()>page*50?page*50:allCzylList.size();
                for(int j=(page-1)*50;j<max;j++)
                {
                    pageCzylList.add(allCzylList.get(j));
                }
            
            map.put("result", Boolean.TRUE);
            map.put("message", "success");
            map.put("user", user);
            map.put("czylbxbasicinfo", czylbxbasicinfo);
            map.put("pageCzylList",pageCzylList);
            map.put("pageCount", pageCount);
            map.put("page", page);
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
    
    ////////2014/08/06条件查找列表
 @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
 @RequestMapping("/checkOnePageCzStud")
 public ModelAndView checkOnePageCzStud(String year,int colleageId,int majorId,int classId,int page,HttpServletRequest request) {
     ModelAndView mav = new ModelAndView();
     MappingJacksonJsonView view = new MappingJacksonJsonView();
     Map map = new HashMap();
     try {
         User user = new User();
         HttpSession session = request.getSession();
         user = (User) session.getAttribute("user");
         List<Czylbxbasicinfo> list = new ArrayList<Czylbxbasicinfo>();
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
                     list = czylbxService.findCzylbxbasiinfoByClassId(classId);
                 }else
                 {
                     if(maxrole==2){//为辅导员的情况比较特殊，只显示自己所带的班级
                         Instructor instructor = instructorService.findInstructorByUserId(user.getUserId());
                         List<Studentclass> list1 = studentclassService.selectByInstId(instructor.getInstId());
                         List<Studentclass> studentclass = new ArrayList<Studentclass>();
                         for(int i=0;i<list1.size();i++)
                         {
                             if(list1.get(i).getClassMajrid()==majorId)
                             {
                                 studentclass.add(list1.get(i));
                             }
                         }
                         for(int i=0;i<studentclass.size();i++)
                         {                       
                             list.addAll(czylbxService.findCzylbxbasiinfoByClassId(studentclass.get(i).getClassId()));
                         }
                         
                        }else{
                            
                            list = czylbxService.findCzylbxbasiinfoByMajrId(majorId);
                        }
                 }
             }else
             {   if(maxrole==2){//为辅导员的情况比较特殊，只显示自己所带的班级
                 Instructor instructor = instructorService.findInstructorByUserId(user.getUserId());
                 List<Studentclass> list1 = studentclassService.selectByInstId(instructor.getInstId());

                 for(int i=0;i<list1.size();i++)
                 {                       
                     list.addAll(czylbxService.findCzylbxbasiinfoByClassId(list1.get(i).getClassId()));
                 }
                 
                }else{
                 list = czylbxService.findCzylbxbasiinfoByInstId(colleageId);
                 }
             }
         }else
         {
             list = czylbxService.selectAllCzylbxbasiinfo();
         }

      
         List<Czylbxbasicinfo> czylbxbasicinfo = new ArrayList<Czylbxbasicinfo>();
         List<Czylbxbasicinfo> czylbxbasicinfo1 = new ArrayList<Czylbxbasicinfo>();
         czylbxbasicinfo1.addAll(list);
         for(int i=0;i<czylbxbasicinfo1.size();i++){
             if(czylbxbasicinfo1.get(i).getczlyBuyAnnual().equals(year)){
             czylbxbasicinfo.add(czylbxbasicinfo1.get(i));
             }
         }
         if(czylbxbasicinfo.size()==0)
         {
             map.put("result", Boolean.FALSE);
             map.put("message", "没有任何信息！");
         }else{
             setAllCzylList(czylbxbasicinfo);
             int recordCount = czylbxbasicinfo.size();//总记录数
             int pageCount;//总页数
             int temp = recordCount % 50;//50条记录一页
             if(temp == 0){
                 pageCount = recordCount/50;
             }else{
                 pageCount = recordCount/50 + 1;
             }
             List<Czylbxbasicinfo> pageCzylList = new ArrayList<Czylbxbasicinfo>();
             int max = 0;
      
             max = allCzylList.size()>page*50?page*50:allCzylList.size();
             for(int j=(page-1)*50;j<max;j++)
             {
                 pageCzylList.add(allCzylList.get(j));
             }
         map.put("czylbxbasicinfo", czylbxbasicinfo);
         map.put("result", Boolean.TRUE);
         map.put("message", "success");
         map.put("user", user);
         map.put("pageCzylList",pageCzylList);
         map.put("pageCount", pageCount);
         map.put("page", page);
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
 @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
 @RequestMapping("/showCzStud")
 public ModelAndView showCzStud(String year,int colleageId,int majorId,int classId,HttpServletRequest request) {
     ModelAndView mav = new ModelAndView();
     MappingJacksonJsonView view = new MappingJacksonJsonView();
     Map map = new HashMap();
     try {
         User user = new User();
         HttpSession session = request.getSession();
         user = (User) session.getAttribute("user");
         List<Czylbxbasicinfo> list = new ArrayList<Czylbxbasicinfo>();
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
                     list = czylbxService.findCzylbxbasiinfoByClassId(classId);
                 }else
                 {
                     if(maxrole==2){//为辅导员的情况比较特殊，只显示自己所带的班级
                         Instructor instructor = instructorService.findInstructorByUserId(user.getUserId());
                         List<Studentclass> list1 = studentclassService.selectByInstId(instructor.getInstId());
                         List<Studentclass> studentclass = new ArrayList<Studentclass>();
                         for(int i=0;i<list1.size();i++)
                         {
                             if(list1.get(i).getClassMajrid()==majorId)
                             {
                                 studentclass.add(list1.get(i));
                             }
                         }
                         for(int i=0;i<studentclass.size();i++)
                         {                       
                             list.addAll(czylbxService.findCzylbxbasiinfoByClassId(studentclass.get(i).getClassId()));
                         }
                         
                        }else{
                            
                            list = czylbxService.findCzylbxbasiinfoByMajrId(majorId);
                        }
                 }
             }else
             {   if(maxrole==2){//为辅导员的情况比较特殊，只显示自己所带的班级
                 Instructor instructor = instructorService.findInstructorByUserId(user.getUserId());
                 List<Studentclass> list1 = studentclassService.selectByInstId(instructor.getInstId());

                 for(int i=0;i<list1.size();i++)
                 {                       
                     list.addAll(czylbxService.findCzylbxbasiinfoByClassId(list1.get(i).getClassId()));
                 }
                 
                }else{
                 list = czylbxService.findCzylbxbasiinfoByInstId(colleageId);
                 }
             }
         }else
         {
             list = czylbxService.selectAllCzylbxbasiinfo();
         }

      
         List<Czylbxbasicinfo> czylbxbasicinfo = new ArrayList<Czylbxbasicinfo>();
         List<Czylbxbasicinfo> czylbxbasicinfo1 = new ArrayList<Czylbxbasicinfo>();
         czylbxbasicinfo1.addAll(list);
         for(int i=0;i<czylbxbasicinfo1.size();i++){
             if(czylbxbasicinfo1.get(i).getczlyBuyAnnual().equals(year)){
             czylbxbasicinfo.add(czylbxbasicinfo1.get(i));
             }
         }
         if(czylbxbasicinfo.size()==0)
         {
             map.put("result", Boolean.FALSE);
             map.put("message", "没有任何信息！");
         }else{
             setAllCzylList(czylbxbasicinfo);
             int recordCount = czylbxbasicinfo.size();//总记录数
             int pageCount;//总页数
             int temp = recordCount % 50;//50条记录一页
             if(temp == 0){
                 pageCount = recordCount/50;
             }else{
                 pageCount = recordCount/50 + 1;
             }
             List<Czylbxbasicinfo> firstCzylList = new ArrayList<Czylbxbasicinfo>();
             int max = 0;
             int page = 1;
             max = allCzylList.size()>page*50?page*50:allCzylList.size();
             for(int j=(page-1)*50;j<max;j++)
             {
                 firstCzylList.add(allCzylList.get(j));
             }
         map.put("czylbxbasicinfo", czylbxbasicinfo);
         map.put("result", Boolean.TRUE);
         map.put("message", "success");
         map.put("user", user);
         map.put("firstCzylList",firstCzylList);
         map.put("pageCount", pageCount);
         map.put("page", page);
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
             System.out.println("hhh"+user.getUserInstid());
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
                 if(3==role.get(i).getRoleId())
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
             System.out.println("hhh"+student.getStudName());
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
 @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
 @RequestMapping("/checkOneCzStud")
 public ModelAndView checkOneCzStud(String year,String NameOrNumber,HttpServletRequest request) {
     ModelAndView mav = new ModelAndView();
     MappingJacksonJsonView view = new MappingJacksonJsonView();
     Map map = new HashMap();
     try {
         User user = new User();
         HttpSession session = request.getSession();
         user = (User) session.getAttribute("user");
       //  List<Studentbasiinfo> studentbasiinfo = new ArrayList<Studentbasiinfo>();
         List<Czylbxbasicinfo> czylbxbasicinfo = new ArrayList<Czylbxbasicinfo>();
         List<Czylbxbasicinfo> czylbxbasicinfo2 = new ArrayList<Czylbxbasicinfo>();
         List<Czylbxbasicinfo> czylbxbasicinfo3 = new ArrayList<Czylbxbasicinfo>();
         if(user.getUserType()==1)
         {
             Student student = studentService.findStudentById(user.getUserId());
            
             Czylbxbasicinfo czylbxbasicinfo1=czylbxService.findCzylbxbasiinfoByStudentId(student.getStudId());
             if(czylbxbasicinfo1 !=null){
                 czylbxbasicinfo.add(czylbxbasicinfo1);
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
                     czylbxbasicinfo2.addAll(czylbxService.findCzylbxbasiinfoByClassId(list.get(i).getClassId()));
                 }
              
                 
             } else if (maxrole < 6)// 经办老师或学办主任或分管委
             {
                 czylbxbasicinfo2.addAll(czylbxService.findCzylbxbasiinfoByInstId(user.getUserInstid()));
             } else {// 学生处处理有问题
                 czylbxbasicinfo2.addAll(czylbxService.selectAllCzylbxbasiinfo());
             }
             for(int i=0;i<czylbxbasicinfo2.size();i++){
                 if(czylbxbasicinfo2.get(i).getczlyBuyAnnual().equals(year)){
                 czylbxbasicinfo3.add(czylbxbasicinfo2.get(i));
                 }
             }
             for(int i=0;i<czylbxbasicinfo3.size();i++){
                 if(czylbxbasicinfo3.get(i).getStudentName().equals(NameOrNumber)||czylbxbasicinfo3.get(i).getStudentNumber().equals(NameOrNumber)){
                 czylbxbasicinfo.add(czylbxbasicinfo3.get(i));
                 }
             }
             
             if(maxrole == 2)
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
         if(czylbxbasicinfo.size()==0)
         {
             map.put("result", Boolean.FALSE);
             map.put("message", "你查询的信息不存在！");
         }else{
        
         map.put("result", Boolean.TRUE);
         map.put("message", "success");
         map.put("user", user);
         map.put("czylbxbasicinfo", czylbxbasicinfo);
       
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
 
 @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
 @RequestMapping("/EditOneStuWill")
 // 查找对应年限的对应的czylbx
 public ModelAndView EditOneStuWill(int stuWill,String year ,int studentId,HttpServletRequest request, HttpServletResponse response) {
     ModelAndView mav = new ModelAndView();
     MappingJacksonJsonView view = new MappingJacksonJsonView();
     Map map = new HashMap();
     try {
         HttpSession session = request.getSession();
         User user = (User) session.getAttribute("user");
         
         Czylbx czylbx = new Czylbx();// 分配了内存空间，指向new Czylbx()所创建的内存空间
         
         if (user.getUserType() != null) {
             if (user.getUserType() !=1 ) {
              
                 List<Czylbx> list = czylbxService.findCzylbxsByStudentId(studentId);
                 if (list != null && list.size() > 0) {
                     for (int i = 0; i < list.size(); i++) {
                         czylbx = list.get(i);
                         if (czylbx.getCzlyBuyannual().equals(year)) {
                             break;
                         }
                     }
                     int czylbxId = czylbx.getCzylId();
                     czylbxService.EditInfoByCzlybxId(czylbxId, stuWill);

                 } else {
                     czylbx = null;
                 }
             } else {
                 
                 czylbx = null;
             }
         } else {
             
             czylbx = null;
         }

         map.put("result", Boolean.TRUE);
         map.put("message", "执行成功！");
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
 @SuppressWarnings({"rawtypes", "finally", "unchecked" })
 @RequestMapping("/export")
 public ModelAndView export(String year,int colleageId,int majorId,int classId,HttpServletRequest request,HttpServletResponse response){
         ModelAndView mav = new ModelAndView();
         MappingJacksonJsonView view = new MappingJacksonJsonView();
         Map map = new HashMap();
         HttpSession session = request.getSession();
         User user = (User) session.getAttribute("user");
         try {
            
             user = (User) session.getAttribute("user");
             List<Czylbxbasicinfo> list = new ArrayList<Czylbxbasicinfo>();
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
                         list = czylbxService.findCzylbxbasiinfoByClassId(classId);
                     }else
                     {
                         if(maxrole==2){//为辅导员的情况比较特殊，只显示自己所带的班级
                             Instructor instructor = instructorService.findInstructorByUserId(user.getUserId());
                             List<Studentclass> list1 = studentclassService.selectByInstId(instructor.getInstId());
                             List<Studentclass> studentclass = new ArrayList<Studentclass>();
                             for(int i=0;i<list1.size();i++)
                             {
                                 if(list1.get(i).getClassMajrid()==majorId)
                                 {
                                     studentclass.add(list1.get(i));
                                 }
                             }
                             for(int i=0;i<studentclass.size();i++)
                             {                       
                                 list.addAll(czylbxService.findCzylbxbasiinfoByClassId(studentclass.get(i).getClassId()));
                             }
                             
                            }else{
                                
                                list = czylbxService.findCzylbxbasiinfoByMajrId(majorId);
                            }
                     }
                 }else
                 {   if(maxrole==2){//为辅导员的情况比较特殊，只显示自己所带的班级
                     Instructor instructor = instructorService.findInstructorByUserId(user.getUserId());
                     List<Studentclass> list1 = studentclassService.selectByInstId(instructor.getInstId());

                     for(int i=0;i<list1.size();i++)
                     {                       
                         list.addAll(czylbxService.findCzylbxbasiinfoByClassId(list1.get(i).getClassId()));
                     }
                     
                    }else{
                     list = czylbxService.findCzylbxbasiinfoByInstId(colleageId);
                     }
                 }
             }else
             {
                 list = czylbxService.selectAllCzylbxbasiinfo();
             }

          
             List<Czylbxbasicinfo> czylbxbasicinfo = new ArrayList<Czylbxbasicinfo>();
             List<Czylbxbasicinfo> czylbxbasicinfo1 = new ArrayList<Czylbxbasicinfo>();
             czylbxbasicinfo1.addAll(list);
             for(int i=0;i<czylbxbasicinfo1.size();i++){
                 if(czylbxbasicinfo1.get(i).getczlyBuyAnnual().equals(year)){
                 czylbxbasicinfo.add(czylbxbasicinfo1.get(i));
                 }
             }
             
              WritableWorkbook book = null;
                 try {
                     SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
                     String date = sdf.format(System.currentTimeMillis());
                     session.setAttribute("DownLoadDate", date);
                     String path = request.getSession().getServletContext().getRealPath("upload/czylbx" +date+ ".xls");
                     // 打开文件
                     book = Workbook.createWorkbook(new File(path));
                     // 生成名为"学生"的工作表，参数0表示这是第一页
                     WritableSheet sheet = book.createSheet("学生", 0);
                     
                     if(czylbxbasicinfo!=null && !czylbxbasicinfo.isEmpty()){
                         for(int i=0; i<czylbxbasicinfo.size(); i++){
                             sheet.addCell(new Label(0, 1, "姓名"));
                             sheet.addCell(new Label(1, 1, "学号"));
                             sheet.addCell(new Label(2, 1, "学院"));
                             sheet.addCell(new Label(3, 1, "专业"));
                             sheet.addCell(new Label(4, 1, "班级"));
                             sheet.addCell(new Label(5, 1, "购买年度"));
                             sheet.addCell(new Label(6, 1, "是否需要购买"));
                             sheet.addCell(new Label(7, 1, "是否能修改意愿"));
                             sheet.addCell(new Label(8, 1, "是否购买成功"));
                             sheet.addCell(new Label(9, 1, "购买时间"));
                             
                             sheet.addCell(new Label(0, i+2, czylbxbasicinfo.get(i).getStudentName()));
                             sheet.addCell(new Label(1, i+2, czylbxbasicinfo.get(i).getStudentNumber()));
                             sheet.addCell(new Label(2, i+2, czylbxbasicinfo.get(i).getInstShortName()));
                             sheet.addCell(new Label(3, i+2, czylbxbasicinfo.get(i).getMajrName()));
                             sheet.addCell(new Label(4, i+2, czylbxbasicinfo.get(i).getClassName()));
                             sheet.addCell(new Label(5, i+2, czylbxbasicinfo.get(i).getczlyBuyAnnual()));
                             if(czylbxbasicinfo.get(i).getczlyIsneed()==null){
                                 sheet.addCell(new Label(6, i+2, "还没填写意愿"));
                             }else if(czylbxbasicinfo.get(i).getczlyIsneed().equals("1")){
                                 
                                 sheet.addCell(new Label(6, i+2, "是"));
                             }else{
                                 
                                 sheet.addCell(new Label(6, i+2, "否"));
                             }
                             if(czylbxbasicinfo.get(i).getczylIseditable()==1){
                                 sheet.addCell(new Label(7, i+2, "是"));
                             }else {
                                 
                                 sheet.addCell(new Label(7, i+2, "否"));
                             }
                             
                             if(czylbxbasicinfo.get(i).getczlyIssuccess().equals("1")){
                                 sheet.addCell(new Label(8, i+2, "购买成功"));
                             }else if(czylbxbasicinfo.get(i).getczlyIssuccess().equals("0")){
                                 
                                 sheet.addCell(new Label(8, i+2, "未购买"));
                             }else{
                                 
                                 sheet.addCell(new Label(8, i+2, "购买失败"));
                             }
                            // sheet.addCell(new Label(7, i+2, czylbxbasicinfo.get(i).getczylIseditable()+""));
                            // sheet.addCell(new Label(8, i+2, czylbxbasicinfo.get(i).getczlyIssuccess()));
                             sheet.addCell(new Label(9, i+2, czylbxbasicinfo.get(i).getczlyBuyTime()));
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

             map.put("czylbxbasicinfo", czylbxbasicinfo);
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
 @RequestMapping(value = "/download", method = RequestMethod.GET)
 public void downloadFile(int colleageId, int majorId, int classId, String year, String patch,
         HttpServletRequest request, HttpServletResponse response) throws IOException, RowsExceededException,
         WriteException {
     try {
         // 封装下载
         // path是指欲下载的文件的路径。
         HttpSession session = request.getSession();
         String date = (String)session.getAttribute("DownLoadDate");
         String path = request.getSession().getServletContext().getRealPath("upload/czylbx"+date+".xls");

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
         response.reset();
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
 
 @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
 @RequestMapping("/showCzWorkIntroduction")
 public ModelAndView showCzWorkIntroduction(HttpServletRequest request,HttpServletResponse response) {
     ModelAndView mav = new ModelAndView();
     MappingJacksonJsonView view = new MappingJacksonJsonView();
     Map map = new HashMap();
     try {
         ArticleModel articleModel=new ArticleModel();
         articleModel=announcementService.findCzWorkIntroduction();
         
         map.put("result", Boolean.TRUE);
         map.put("czWorkIntroduction", articleModel);
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
}
