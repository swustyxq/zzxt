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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Workbook;
import jxl.biff.ContinueRecord;
import jxl.biff.WorkspaceInformationRecord;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

//import com.lowagie.text.Document;
//import com.lowagie.text.DocumentException;
//import com.lowagie.text.Element;
//import com.lowagie.text.Font;
//import com.lowagie.text.HeaderFooter;
//import com.lowagie.text.PageSize;
//import com.lowagie.text.Paragraph;
//import com.lowagie.text.Phrase;
//import com.lowagie.text.Rectangle;
//import com.lowagie.text.pdf.BaseFont;
//import com.lowagie.text.pdf.PdfContentByte;
//import com.lowagie.text.pdf.PdfPCell;
//import com.lowagie.text.pdf.PdfPTable;
//import com.lowagie.text.pdf.PdfWriter;

//import com.lowagie.text.Document;
//import com.lowagie.text.DocumentException;
//import com.lowagie.text.Element;
//import com.lowagie.text.Font;
//import com.lowagie.text.HeaderFooter;
//import com.lowagie.text.PageSize;
//import com.lowagie.text.Paragraph;
//import com.lowagie.text.Phrase;
//import com.lowagie.text.Rectangle;
//import com.lowagie.text.pdf.BaseFont;
//import com.lowagie.text.pdf.PdfPCell;
//import com.lowagie.text.pdf.PdfPTable;
//import com.lowagie.text.pdf.PdfWriter;

import swust.edu.cn.zzxt.model.GjlzjxjWithBLOBs;
import swust.edu.cn.zzxt.model.GjzxjWithBLOBs;
import swust.edu.cn.zzxt.model.Instructor;
import swust.edu.cn.zzxt.model.Learning;
import swust.edu.cn.zzxt.model.Major;
import swust.edu.cn.zzxt.model.PgsglWithBLOBs;
import swust.edu.cn.zzxt.model.Reward;
import swust.edu.cn.zzxt.model.Role;
import swust.edu.cn.zzxt.model.Student;
import swust.edu.cn.zzxt.model.Studentclass;
import swust.edu.cn.zzxt.model.Studentinfo;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.model.Workinstitutiontemoneyamount;
import swust.edu.cn.zzxt.model.Workstepfolw;
import swust.edu.cn.zzxt.selfmodel.CountModal;
import swust.edu.cn.zzxt.selfmodel.ListModal;
import swust.edu.cn.zzxt.selfmodel.LstdListModel;
import swust.edu.cn.zzxt.service.CommonService;
import swust.edu.cn.zzxt.service.GjzxjService;
import swust.edu.cn.zzxt.service.InstitutionService;
import swust.edu.cn.zzxt.service.MajorService;
import swust.edu.cn.zzxt.service.MoneyAmontService;
import swust.edu.cn.zzxt.service.StudentService;
import swust.edu.cn.zzxt.service.StudentclassService;
import swust.edu.cn.zzxt.service.StudentinfoService;
import swust.edu.cn.zzxt.service.WorkService;
import swust.edu.cn.zzxt.service.WorkstepfolwService;
import swust.edu.cn.zzxt.model.*;

@Controller
@RequestMapping("/gjzxjController")
public class GjzxjController {
    private List<ListModal> listModals;

    private InstitutionService institutionService;
    private WorkService workService;
    private MoneyAmontService moneyAmontService;

    public MoneyAmontService getMoneyAmontService() {
        return moneyAmontService;
    }

    @Autowired
    public void setMoneyAmontService(MoneyAmontService moneyAmontService) {
        this.moneyAmontService = moneyAmontService;
    }

    public WorkService getWorkService() {
        return workService;
    }

    @Autowired
    public void setWorkService(WorkService workService) {
        this.workService = workService;
    }

    public InstitutionService getInstitutionService() {
        return institutionService;
    }

    @Autowired
    public void setInstitutionService(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    private MajorService majorService;

    public MajorService getMajorService() {
        return majorService;
    }

    @Autowired
    public void setMajorService(MajorService majorService) {
        this.majorService = majorService;
    }

    private StudentclassService studentclassService;

    public StudentclassService getStudentclassService() {
        return studentclassService;
    }

    @Autowired
    public void setStudentclassService(StudentclassService studentclassService) {
        this.studentclassService = studentclassService;
    }

    private StudentinfoService studentinfoService;

    public StudentinfoService getStudentinfoService() {
        return studentinfoService;
    }

    @Autowired
    public void setStudentinfoService(StudentinfoService studentinfoService) {
        this.studentinfoService = studentinfoService;
    }

    private CommonService commonService;

    public CommonService getCommonService() {
        return commonService;
    }

    @Autowired
    public void setCommonService(CommonService commonService) {
        this.commonService = commonService;
    }

    WorkstepfolwService workstepfolwService;

    public WorkstepfolwService getWorkstepfolwService() {
        return workstepfolwService;
    }

    @Autowired
    public void setWorkstepfolwService(WorkstepfolwService workstepfolwService) {
        this.workstepfolwService = workstepfolwService;
    }

    StudentService studentService;

    public StudentService getStudentService() {
        return studentService;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    GjzxjService gjzxjService;

    public GjzxjService getGjzxjService() {
        return gjzxjService;
    }

    @Autowired
    public void setGjzxjService(GjzxjService gjzxjService) {
        this.gjzxjService = gjzxjService;
    }

    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/addGjzxjApply")
    public ModelAndView addGjzxjApply(String politicState, String residence, int familySum, String applyReason,
            String classDetail, String allIncomes, String incomeType, String mailcode, String home, String annual,
            Integer workId, Integer level, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        HttpSession session = request.getSession();
        Student student = new Student();
        GjzxjWithBLOBs gjzxjWithBLOBs = new GjzxjWithBLOBs();// 国家助学金申请表
        List<Role> role = new ArrayList<Role>();
        User user = (User) session.getAttribute("user");
        role = (List<Role>) session.getAttribute("role");
        int id = user.getUserId();
        int stuId;// 学生ID

        int state = 0;// 申请状态，默认为0；
        try {// 查reuserrol 判断角色
            if (user.getUserType() == 1) {
                student = studentService.findStudentById(id);
                stuId = student.getStudId();
                int situation = 1;
                int wsflId = 0;// 工作流ID默认为1
                if (role.size() > 1) {
                    for (int i = 0; i < role.size(); ++i) {
                        if (role.get(i).getRoleId() == 10)
                            situation = 2;
                        if (role.get(i).getRoleId() >= 13)
                            situation = 3;
                    }
                }
                Workstepfolw workstepfolws = workstepfolwService.getWsflIdByWorkidAndSituation(10, situation);
                // 一旦提交 则进入辅导员修改的步骤
                wsflId = workstepfolws.getWsflNextstep();
                // 将值传入GjzxjWithBLOBs
                gjzxjWithBLOBs.setGzxjStudid(stuId);
                gjzxjWithBLOBs.setGzxjWsflid(wsflId);
                gjzxjWithBLOBs.setGzxjApplyreason(applyReason);
                gjzxjWithBLOBs.setGzxjWorkid(workId);
                gjzxjWithBLOBs.setGzxjPoliticstate(politicState);
                gjzxjWithBLOBs.setGzxjClassdetail(classDetail);
                gjzxjWithBLOBs.setGzxjResidence(residence);
                gjzxjWithBLOBs.setGzxjPopulation(familySum);
                gjzxjWithBLOBs.setGzxjAllincomes(allIncomes);
                gjzxjWithBLOBs.setGzxjIncometype(incomeType);
                gjzxjWithBLOBs.setGzxjHome(home);
                gjzxjWithBLOBs.setGzxjMailcode(mailcode);
                gjzxjWithBLOBs.setGzxjAnnual(annual);
                gjzxjWithBLOBs.setGzxjState(state);
                gjzxjWithBLOBs.setGzxjLevel(level);
                double money = (5 - level) * 1000;
                gjzxjWithBLOBs.setGzxjMoney(money);
                gjzxjWithBLOBs.setGzxjApplytime(new Date());
                
                gjzxjService.AddOrModifyGjzxj(gjzxjWithBLOBs);
                System.out.println("comin");
                map.put("result", Boolean.TRUE);
                map.put("message", "success");
            } else {
                map.put("result", Boolean.FALSE);
                map.put("message", "用户权限错误");
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
    @RequestMapping("/saveGjzxjApply")
    public ModelAndView saveGjzxjApply(String politicState, String residence, int familySum, String applyReason,
            String classDetail, String allIncomes, String incomeType, String mailcode, String home, String annual,
            Integer workId, Integer level, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        HttpSession session = request.getSession();
        Student student = new Student();
        GjzxjWithBLOBs gjzxjWithBLOBs = new GjzxjWithBLOBs();// 国家助学金申请表
        List<Role> role = new ArrayList<Role>();
        User user = (User) session.getAttribute("user");
        role = (List<Role>) session.getAttribute("role");
        int id = user.getUserId();
        int stuId;// 学生ID

        int state = 0;// 申请状态，默认为0；
        try {// 查reuserrol 判断角色
            if (user.getUserType() == 1) {
                student = studentService.findStudentById(id);
                stuId = student.getStudId();
                int situation = 1;
                int wsflId = 0;// 工作流ID默认为1
                if (role.size() > 1) {
                    for (int i = 0; i < role.size(); ++i) {
                        if (role.get(i).getRoleId() == 10)
                            situation = 2;
                        if (role.get(i).getRoleId() >= 13)
                            situation = 3;
                    }
                }
                Workstepfolw workstepfolws = workstepfolwService.getWsflIdByWorkidAndSituation(10, situation);

                wsflId = workstepfolws.getWsflId();
                // 将值传入GjzxjWithBLOBs
                gjzxjWithBLOBs.setGzxjStudid(stuId);
                gjzxjWithBLOBs.setGzxjWsflid(wsflId);
                gjzxjWithBLOBs.setGzxjApplyreason(applyReason);
                gjzxjWithBLOBs.setGzxjWorkid(workId);
                gjzxjWithBLOBs.setGzxjPoliticstate(politicState);
                gjzxjWithBLOBs.setGzxjClassdetail(classDetail);
                gjzxjWithBLOBs.setGzxjResidence(residence);
                gjzxjWithBLOBs.setGzxjPopulation(familySum);
                gjzxjWithBLOBs.setGzxjAllincomes(allIncomes);
                gjzxjWithBLOBs.setGzxjIncometype(incomeType);
                gjzxjWithBLOBs.setGzxjHome(home);
                gjzxjWithBLOBs.setGzxjMailcode(mailcode);
                gjzxjWithBLOBs.setGzxjAnnual(annual);
                gjzxjWithBLOBs.setGzxjState(state);
                gjzxjWithBLOBs.setGzxjApplytime(new Date());
                gjzxjWithBLOBs.setGzxjLevel(level);
                double money = (5 - level) * 1000;
                gjzxjWithBLOBs.setGzxjMoney(money);
                gjzxjService.AddOrModifyGjzxj(gjzxjWithBLOBs);
                map.put("result", Boolean.TRUE);
                map.put("message", "success");
            } else {
                map.put("result", Boolean.FALSE);
                map.put("message", "用户权限错误");
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
    @RequestMapping("/showList")
    public ModelAndView showList(HttpServletResponse response, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Role> roles = (List<Role>) session.getAttribute("role");
        listModals = new ArrayList<ListModal>();
        Institution institution = institutionService.findinstitutionByUserInstId(user.getUserInstid());

        try {
            // 业务逻辑
            if (user.getUserType() == 1) {
                listModals = commonService.findAllInfo(1, 10, user.getUserId());
                map.put("role", 1);
                map.put("listModals", listModals);
                map.put("result", Boolean.TRUE);
                map.put("message", "success");
            } else {
                List<CountModal> countModals = new ArrayList<CountModal>();

                int roleid = 0;
                for (int i = 0; i < roles.size(); ++i) {
                    if (roles.get(i).getRoleId() == 2 || roles.get(i).getRoleId() == 10
                            || (roles.get(i).getRoleId() > 12 && roles.get(i).getRoleId() < 15)
                            || roles.get(i).getRoleId() == 24) {
                        if (roleid < roles.get(i).getRoleId())
                            roleid = roles.get(i).getRoleId();
                    }
                }
                if (roleid != 0) {
                    listModals = commonService.findAllInfo(roleid, 10, user.getUserId());
                    countModals = commonService.findAllCountInfo(user.getUserId(), 10, listModals);
                    if(roleid == 10){
                        Workinstitutiontemoneyamount wism = moneyAmontService.selectWorkinstitutiontemoneyamount(10, user.getUserInstid());
                        map.put("zjq", wism.getWimaMoney());
                        map.put("zrs", wism.getWimaAmount());
                    }
                    map.put("instid", institution.getInstId());
                    map.put("count", countModals);
                    map.put("role", roleid);
                    map.put("listModals", listModals);
                    map.put("result", Boolean.TRUE);
                    map.put("message", "success");
                } else {
                    map.put("zjq", -1);
                    map.put("zrs", -1);
                    map.put("role", 0);
                    map.put("result", Boolean.FALSE);
                    map.put("message", "用户权限错误");
                }

            }
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            map.put("message", "信息错误");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }

    /*
     * 获取一个学生信息 Author chenwenhui,2014.07.15
     */
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/readStudentByStudNumber")
    public ModelAndView readStudentByStudNumber(int studId, int listId, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        Workstepfolw workstepfolw = new Workstepfolw();
        User user = new User();
        HttpSession session = request.getSession();// 获取session
        user = (User) session.getAttribute("user");

        try {// 查reuserrol 判断角色
            if (user == null) {
                map.put("result", Boolean.FALSE);
                map.put("message", "用户已经退出！请重新登录");

            } else {
                Student student = new Student();
                Studentinfo studentInfo = new Studentinfo();
                Studentclass studentClass = new Studentclass();
                Major major = new Major();
                List<Learning> learning = new ArrayList<Learning>();
                GjzxjWithBLOBs gjzxjWithBLOBs = new GjzxjWithBLOBs();
                student = studentService.findStudentByStudId(studId);
                studentInfo = studentinfoService.selectBystudInfoStudId(student.getStudId());
                studentClass = studentclassService.selectBystudInfoStudId(student.getStudClassid());
                major = majorService.selectByPrimaryKey(studentClass.getClassMajrid());
                gjzxjWithBLOBs = gjzxjService.findGjzxjWithBLObsById(listId);
                System.out.println("FLOW" + gjzxjWithBLOBs.getGzxjWsflid());
                workstepfolw = workstepfolwService.findWslfByWslfId(gjzxjWithBLOBs.getGzxjWsflid());
                Work work = workService.selectByWorkId(10);
                map.put("work", work);
                map.put("workstepfolw", workstepfolw);
                map.put("gjzxjWithBLOBs", gjzxjWithBLOBs);
                map.put("result", Boolean.TRUE);
                map.put("student", student);
                map.put("studentInfo", studentInfo);
                map.put("studentClass", studentClass);
                map.put("major", major);
                map.put("learning", learning);
                map.put("message", "success！");
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
    @RequestMapping("/auditGjzxjApply")
    public ModelAndView auditGjzxjApply(int gjzxjid, int auditid, int familySum, String allIncomes, String incomeType,
            String applyReason, String classOption, String academyOption, Integer workId, Integer level,
            HttpServletRequest request) {
        int flag = 0;
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Role> roles = (List<Role>) session.getAttribute("role");
        int roleid = 0;
        for(int i = 0; i < roles.size();++i){
            if (roles.get(i).getRoleId() == 2 || roles.get(i).getRoleId() == 10 || (roles.get(i).getRoleId() > 12 && roles.get(i).getRoleId() < 15) || roles.get(i).getRoleId() == 24){
                if (roleid < roles.get(i).getRoleId()){
                  roleid = roles.get(i).getRoleId();
                }
            }
        }
        GjzxjWithBLOBs gjzxjWithBLOBs = new GjzxjWithBLOBs();
        try {// 查reuserrol 判断角色
            gjzxjWithBLOBs.setGzxjId(gjzxjid);
            gjzxjWithBLOBs.setGzxjPopulation(familySum);
            gjzxjWithBLOBs.setGzxjAllincomes(allIncomes);
            gjzxjWithBLOBs.setGzxjIncometype(incomeType);
            gjzxjWithBLOBs.setGzxjApplyreason(applyReason);
            gjzxjWithBLOBs.setGzxjClassopinion(classOption);// 班级意见
            gjzxjWithBLOBs.setGzxjLevel(level);
            double money = (5 - level) * 1000;
            gjzxjWithBLOBs.setGzxjMoney(money);
            if (classOption != "" || classOption != null)
                gjzxjWithBLOBs.setGzxjClassopiniontime((new SimpleDateFormat("yyyy-MM-dd")).format(new Date()));
            gjzxjWithBLOBs.setGzxjAcademyopinion(academyOption);// 学院意见
            if (academyOption != "" || academyOption != null)
                gjzxjWithBLOBs.setGzxjAcademyopiniontime((new SimpleDateFormat("yyyy-MM-dd")).format(new Date()));
            // 获取工作流
            GjzxjWithBLOBs gjzxjWithBLOBs2 = gjzxjService.findGjzxjWithBLObsById(gjzxjid);
            Workstepfolw workstepfolw = workstepfolwService.findWslfByWslfId(gjzxjWithBLOBs2.getGzxjWsflid());
            if (auditid == 1) {
                // 审批通过
                if (roleid == 10) {// 经办老师等级卡住名额与金钱
                    Workinstitutiontemoneyamount wism = moneyAmontService.selectWorkinstitutiontemoneyamount(10,
                            user.getUserInstid());
                    if (wism.getWimaMoney() - money < 0 && wism.getWimaAmount() == 0) {
                        flag = 3;
                    } else if (wism.getWimaMoney() - money < 0 && wism.getWimaAmount() > 0) {
                        flag = 2;
                    } else if(wism.getWimaMoney() - gjzxjWithBLOBs2.getGzxjMoney() > 0 && wism.getWimaAmount() == 0) {
                        flag = 1;
                    }

                    wism.setWimaMoney(wism.getWimaMoney() - money);
                    wism.setWimaAmount(wism.getWimaAmount() - 1);
                    if (flag == 0) {
                        moneyAmontService.update(wism);
                    }
                }
                gjzxjWithBLOBs.setGzxjWsflid(workstepfolw.getWsflNextstep());
                if (workstepfolw.getWsflNextstep() == -1)
                    gjzxjWithBLOBs.setGzxjState(1);
                
                
                if(flag == 1){
                    map.put("result", Boolean.FALSE);
                    map.put("message", "名额超过规定！");
                }else if(flag == 2){
                    map.put("result", Boolean.FALSE);
                    map.put("message", "奖金超过规定！");
                }else if(flag == 3){
                    map.put("result", Boolean.FALSE);
                    map.put("message", "奖金与名额超过规定！");
                }
                
                
                
            } else if (auditid == 2) {
                // 驳回
                if(user.getUserType() == 4){//学办主任驳回时增加经办老师处理数据
                    Workinstitutiontemoneyamount wism = moneyAmontService.selectWorkinstitutiontemoneyamount(10,
                            user.getUserInstid());
                    wism.setWimaMoney(wism.getWimaMoney() + money);
                    wism.setWimaAmount(wism.getWimaAmount() + 1);
                    moneyAmontService.update(wism);
                }
                gjzxjWithBLOBs.setGzxjWsflid(workstepfolw.getWsflPrestep());
            }

            if (flag == 0) {
                gjzxjService.auditGjzxj(gjzxjWithBLOBs);// 审批表
                map.put("result", Boolean.TRUE);
                map.put("message", "执行成功！");
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
    @RequestMapping("/findMajor")
    public ModelAndView findMajor(int academyid, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        List<Major> major = new ArrayList<Major>();
        try {// 查reuserrol 判断角色

            if (academyid != 0) {
                major = majorService.selectByInstId(academyid);
                System.out.println("####" + major.get(0).getMajrName());
                map.put("major", major);
            } else {
                map.put("major", null);
            }
            map.put("result", Boolean.TRUE);
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
    @RequestMapping("/findClass")
    public ModelAndView findClass(int majorid, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        List<Studentclass> stuclass = new ArrayList<Studentclass>();
        try {// 查reuserrol 判断角色
            if (majorid != 0) {

                stuclass = studentclassService.selectByMajorId(majorid);
                map.put("stuclass", stuclass);
            } else
                map.put("stuclass", null);
            map.put("result", Boolean.TRUE);
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

    /*@SuppressWarnings({ "rawtypes", "finally", "unchecked" })
    @RequestMapping("/export")
    public ModelAndView export(int academyid, int majorid, int classid, HttpServletRequest request,
            HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        WritableWorkbook book = null;
        try {
            String path = request.getSession().getServletContext().getRealPath("upload/" + "gjzxj" + ".xls");
            System.out.println(path);
            book = Workbook.createWorkbook(new File(path));
            // 生成名为"学生"的工作表，参数0表示这是第一页
            WritableSheet sheet = book.createSheet("学生", 0);
            sheet.addCell(new Label(0, 1, "姓名"));
            sheet.addCell(new Label(1, 1, "学号"));
            sheet.addCell(new Label(2, 1, "学院"));
            sheet.addCell(new Label(3, 1, "专业"));
            sheet.addCell(new Label(4, 1, "班级"));
            sheet.addCell(new Label(5, 1, "申请年度"));
            sheet.addCell(new Label(6, 1, "审核状态"));

            if (listModals != null && !listModals.isEmpty()) {
                int row = 0;
                for (int i = 0; i < listModals.size(); i++) {
                    int a = academyid;
                    int b = majorid;
                    int c = classid;
                    if (a == 0)
                        a = listModals.get(i).getAcademyid();
                    if (b == 0)
                        b = listModals.get(i).getMajorid();
                    if (c == 0)
                        c = listModals.get(i).getStuclassid();
                    if (a == listModals.get(i).getAcademyid() && b == listModals.get(i).getMajorid()
                            && c == listModals.get(i).getStuclassid()) {
                        sheet.addCell(new Label(0, row + 2, listModals.get(i).getName()));
                        sheet.addCell(new Label(1, row + 2, listModals.get(i).getStunumber()));
                        sheet.addCell(new Label(2, row + 2, listModals.get(i).getAcademy()));
                        sheet.addCell(new Label(3, row + 2, listModals.get(i).getMajor()));
                        sheet.addCell(new Label(4, row + 2, listModals.get(i).getStuclass()));
                        sheet.addCell(new Label(5, row + 2, listModals.get(i).getAnnual()));
                        sheet.addCell(new Label(6, row + 2, listModals.get(i).getStatusdescript()));
                        ++row;
                    }
                }
            }

            // 写入数据并关闭文件
            book.write();
            map.put("result", Boolean.TRUE);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (book != null) {
                try {
                    book.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }*/

    /*@RequestMapping(value = "/download", method = RequestMethod.GET)
    public void downloadFile(int academyid, int majorid, int classid, String year, String patch,
            HttpServletRequest request, HttpServletResponse response) throws IOException, RowsExceededException,
            WriteException {
        try {
            // 封装下载
            // path是指欲下载的文件的路径。
            String path = request.getSession().getServletContext().getRealPath("upload/gjzxj.xls");

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
    }*/

    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/agreeGjzxjApply")
    public ModelAndView agreeGjzxjApply(int gjzxjid, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Role> roles = (List<Role>) session.getAttribute("role");
        int roleid = 0;
        for(int i = 0; i < roles.size();++i){
            if (roles.get(i).getRoleId() == 2 || roles.get(i).getRoleId() == 10 || (roles.get(i).getRoleId() > 12 && roles.get(i).getRoleId() < 15) || roles.get(i).getRoleId() == 24){
                if (roleid < roles.get(i).getRoleId()){
                  roleid = roles.get(i).getRoleId();
                }
            }
        }
        int flag = 0;
        GjzxjWithBLOBs gjzxjWithBLOBs = new GjzxjWithBLOBs();
        try {// 查reuserrol 判断角色
            gjzxjWithBLOBs.setGzxjId(gjzxjid);
            // 获取工作流
            GjzxjWithBLOBs gjzxjWithBLOBs2 = gjzxjService.findGjzxjWithBLObsById(gjzxjid);
            Workstepfolw workstepfolw = workstepfolwService.findWslfByWslfId(gjzxjWithBLOBs2.getGzxjWsflid());
            // 审批通过
            gjzxjWithBLOBs.setGzxjWsflid(workstepfolw.getWsflNextstep());
            if (workstepfolw.getWsflNextstep() == -1)
                gjzxjWithBLOBs.setGzxjState(1);
            
            if (roleid == 10) {// 经办老师等级卡住名额与金钱
                Workinstitutiontemoneyamount wism = moneyAmontService.selectWorkinstitutiontemoneyamount(10,
                        user.getUserInstid());
                if (wism.getWimaMoney() - gjzxjWithBLOBs2.getGzxjMoney() < 0 && wism.getWimaAmount() == 0) {
                    flag = 3;
                } else if (wism.getWimaMoney() - gjzxjWithBLOBs2.getGzxjMoney() < 0 && wism.getWimaAmount() > 0) {
                    flag = 2;
                } else if(wism.getWimaMoney() - gjzxjWithBLOBs2.getGzxjMoney() > 0 && wism.getWimaAmount() == 0) {
                    flag = 1;
                }
                
                wism.setWimaMoney(wism.getWimaMoney() - gjzxjWithBLOBs2.getGzxjMoney());
                wism.setWimaAmount(wism.getWimaAmount() - 1);
                if (flag == 0) {
                    moneyAmontService.update(wism);
                }
            }
            
            
            if(flag == 1){
                map.put("result", Boolean.FALSE);
                map.put("message", "名额超过规定！");
            }else if(flag == 2){
                map.put("result", Boolean.FALSE);
                map.put("message", "奖金超过规定！");
            }else if(flag == 3){
                map.put("result", Boolean.FALSE);
                map.put("message", "奖金与名额超过规定！");
            }else{
                gjzxjService.auditGjzxj(gjzxjWithBLOBs);// 审批表
                map.put("result", Boolean.TRUE);
                map.put("message", "执行成功！");
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
    @RequestMapping(value="/download",method=RequestMethod.GET)
    public ModelAndView download(int id,String date,HttpServletRequest request,HttpServletResponse response){
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            String msg = "loginout";
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user != null){ 
                msg = "success";
                String path=request.getSession().getServletContext().getRealPath("upload/GjzxjApply"+ date +".pdf");
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
                
                // 设置response的Header
                response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
                response.addHeader("Content-Length", "" + file.length());
                OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
                response.setContentType("application/octet-stream");
                toClient.write(buffer);
                toClient.flush();
                toClient.close();
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
    
//    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
//    @RequestMapping("/exportPdf")
//    public ModelAndView exportPdf(int academyid,int majorid,int classinfoid,
//            int exportFlag,HttpServletRequest request,HttpServletResponse response){
//        ModelAndView mav = new ModelAndView();
//        MappingJacksonJsonView view = new MappingJacksonJsonView();
//        Map map = new HashMap();
//        try {
//            String msg = "loginout";
//            HttpSession session = request.getSession();
//            User user = (User) session.getAttribute("user");
//            if (user != null){ 
//                msg = "success";
//                
//                List<Role> role = (List<Role>) session.getAttribute("role");
//                int maxrole = 0;
//                // 找到最大的等级
//                for (int i = 0; i < role.size(); i++) {
//                    if (role.get(i).getRoleLevel() > maxrole) {
//                        maxrole = role.get(i).getRoleLevel();
//                    }
//                }
//                if (maxrole == 3)// 如果最大等级为经办老师判断是不是当前功能的经办老师
//                {
//                    maxrole = 2;
//                    for (int i = 0; i < role.size(); i++) {
//                        if (role.get(i).getRoleId() == 8) {
//                            maxrole = 3;
//                        }
//                    }
//                }
//                
//                
//               /*  * 如果是纵向打印的话就用下面的代码*/
//                 
//               /* Document document = new Document();// 建立一个Document对象
//                document.setPageSize(PageSize.A4);// 设置页面大小
//*/                
//            /*     * 如果是横向打印的话就用下面的代码*/
//                 
//               
//                Document document = new Document(PageSize.A4.rotate());  
//                try {
//                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
//                    String date = sdf.format(System.currentTimeMillis());
//                    map.put("date", date);
//                    String pdfPath = request.getSession().getServletContext()
//                            .getRealPath("upload/GjzxjApply"+ date +".pdf");
//                    
//                   
//                    OutputStream os = new FileOutputStream(pdfPath);
//                    // 打开文件
//                    WritableWorkbook book = Workbook.createWorkbook(os);
//                    
//                    PdfWriter.getInstance(document, new FileOutputStream(pdfPath));// 建立一个PdfWriter对象
//                    
//                    BaseFont bfChinese =  BaseFont.createFont("C:/Windows/Fonts/SIMYOU.TTF",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);    
//                    Font titleFont = new Font(bfChinese, 18, Font.BOLD);// 设置字体大小
//                    Font headFont = new Font(bfChinese, 14, Font.BOLD);// 设置字体大小
//                    Font headFont1 = new Font(bfChinese, 10, Font.BOLD);// 设置字体大小
//                    Font headFont2 = new Font(bfChinese, 10, Font.NORMAL);// 设置字体大小
//                    
//                    Paragraph title = new Paragraph("西南科技大学2014-2015学年国家助学金受助学生领款单",titleFont);
//                    title.setAlignment(Element.ALIGN_CENTER);
//                    
//                    Paragraph title1 = new Paragraph("西南科技大学2014-2015学年国家助学金拟受助学生公示名单",titleFont);
//                    title1.setAlignment(Element.ALIGN_CENTER);
//                    
//                    float[] widths = { 140f, 250f, 180f, 180f, 200f, 180f, 360f,
//                            360f, 180f, 270f, 250f, 200f};// 设置表格的列宽
//                    
//                    float[] widths1 = { 140f, 300f, 180f, 180f, 240f, 180f,
//                            180f, 270f, 250f, 200f};// 设置表格的列宽
//                    
//                    PdfPTable table;
//                    if (exportFlag == 0){
//                        table = new PdfPTable(widths);// 建立一个pdf表格
//                    }else{
//                        table = new PdfPTable(widths1);// 建立一个pdf表格
//                    }
//                    
//                    table.setSpacingBefore(20f);// 设置表格上面空白宽度
//                    table.setTotalWidth(535);// 设置表格的宽度
//                    //table.setLockedWidth(true);// 设置表格的宽度固定
//                    table.getDefaultCell().setBorder(1);// 设置表格默认为边框1
//                    
//                    String titles[] = {"序号","学  院","姓 名","学 号","专 业","班 级",
//                            "身份证号码","农行卡号","等级","金额（元）","本人签字","备注"};
//                    String titles1[] = {"序号","学  院","姓 名","学 号","专 业","班 级",
//                            "等级","金额（元）","本人签字","备注"};
//                    PdfPCell cell;
//                    if (exportFlag == 0){
//                        for (int i = 0;i < titles.length;i++){
//                            cell = new PdfPCell(new Paragraph(titles[i], headFont));
//                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
//                            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                            table.addCell(cell);// 增加单元格
//                        }
//                    }else if(exportFlag == 1){
//                        for (int i = 0;i < titles1.length;i++){
//                            cell = new PdfPCell(new Paragraph(titles1[i], headFont));
//                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
//                            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                            table.addCell(cell);// 增加单元格
//                        }
//                    }
//                    
//                    int index = 1;
//                    if (listModals != null && !listModals.isEmpty()) {
//                        
//                        for (int i = 0; i < listModals.size(); i++) {
//                            if (academyid != 0 && academyid != listModals.get(i).getAcademyid()) {
//                                continue;
//                            }
//                            if (majorid != 0 && majorid != listModals.get(i).getMajorid()) {
//                                continue;
//                            }
//                            if (classinfoid != 0 && classinfoid != listModals.get(i).getStuclassid()) {
//                                continue;
//                            }
//
//                            cell = new PdfPCell(new Paragraph(index + "", headFont1));
//                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
//                            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                            table.addCell(cell);// 增加单元格
//                            index++;
//
//                            cell = new PdfPCell(new Paragraph(listModals.get(i).getAcademy(), headFont1));
//                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
//                            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                            table.addCell(cell);// 增加单元格
//
//                            cell = new PdfPCell(new Paragraph(listModals.get(i).getName(), headFont1));
//                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
//                            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                            table.addCell(cell);// 增加单元格
//
//                            cell = new PdfPCell(new Paragraph(listModals.get(i).getStunumber(), headFont1));
//                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
//                            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                            table.addCell(cell);// 增加单元格
//
//                            cell = new PdfPCell(new Paragraph(listModals.get(i).getMajor(), headFont1));
//                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
//                            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                            table.addCell(cell);// 增加单元格
//
//                            cell = new PdfPCell(new Paragraph(listModals.get(i).getStuclass(), headFont1));
//                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
//                            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                            table.addCell(cell);// 增加单元格
//                            if (exportFlag == 0){
//                                cell = new PdfPCell(new Paragraph(listModals.get(i).getIdNumber(), headFont1));
//                                cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
//                                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                                table.addCell(cell);// 增加单元格
//
//                                cell = new PdfPCell(new Paragraph(listModals.get(i).getBankNumber(), headFont1));
//                                cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
//                                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                                table.addCell(cell);// 增加单元格
//                            }
//                            
//                            // 助学金等级
//                            String Level = "无";
//                            if (listModals.get(i).getLevel() == 1){
//                                Level = "一等";
//                            }else if (listModals.get(i).getLevel() == 2){
//                                Level = "二等";
//                            }else if (listModals.get(i).getLevel() == 3){
//                                Level = "三等";
//                            }
//                            cell = new PdfPCell(new Paragraph(Level, headFont1));
//                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
//                            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                            table.addCell(cell);// 增加单元格
//
//                            // 助学金金额
//                            cell = new PdfPCell(new Paragraph(listModals.get(i).getMoney() + "", headFont1));
//                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
//                            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                            table.addCell(cell);// 增加单元格
//
//                            cell = new PdfPCell(new Paragraph("", headFont1));
//                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
//                            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                            table.addCell(cell);// 增加单元格
//
//                            cell = new PdfPCell(new Paragraph("", headFont1));
//                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
//                            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                            table.addCell(cell);// 增加单元格
//                        }
//                    }
//                    
//                  /*  PdfWriter writer;
//                    PdfContentByte cb = writer.getDirectContent();  
//                    cb.saveState();  
//                    String text = "第" + writer.getPageNumber() + "页,共";  
//                    cb.beginText();  
//                    cb.setFontAndSize(bfChinese, 8);  
//                    cb.setTextMatrix(460, 786);//定位“第x页,共” 在具体的页面调试时候需要更改这xy的坐标  
//                    cb.showText(text);  
//                    cb.endText();  
//                    cb.addTemplate(tpl, 492, 786);//定位“y页” 在具体的页面调试时候需要更改这xy的坐标  
//              
//                    cb.saveState();  
//                    cb.stroke();  
//                    cb.restoreState();         
//                    cb.closePath();//sanityCheck();  
//*/                    //计算总页数
//                    int totalPage = 0;
//                    if (--index <= 29 ){
//                        totalPage = 1;
//                    }else{
//                        totalPage = (index - 29) % 32 + 2;
//                    }
//                    /** 
//                     * 页眉页脚的设置一定要在open前设置好
//                     */ 
//                    HeaderFooter footer = null;
//                    footer =new HeaderFooter(new Phrase("共 "+ totalPage +" 页，第 ", new com.lowagie.text.Font(bfChinese)),new Phrase(" 页 ", new com.lowagie.text.Font(bfChinese)));
//                    footer.setBorder(Rectangle.NO_BORDER);
//                    footer.setAlignment(1);
//                    document.setFooter(footer);
//                    
//                    document.open();
//                    if (exportFlag == 0){
//                        document.add(title);
//                    }else if (exportFlag == 1){
//                        document.add(title1);
//                    }
//                    
//                    table.setWidthPercentage(100); 
//                    document.add(table);
//                    
//                    // 写入数据并关闭文件
//                    //book.write();
//                    if (book != null){
//                        book.close();
//                    } 
//                } catch (DocumentException de) {
//                    System.err.println(de.getMessage());
//                }catch (IOException ioe) {
//                    System.err.println(ioe.getMessage());
//                }
//                document.close();
//               
//            }
//            // 业务逻辑
//            map.put("result", Boolean.TRUE);
//            map.put("message", msg);
//        } catch (Exception e) {
//            map.put("result", Boolean.FALSE);
//            map.put("message", "执行出现出错！!!!!");
//            e.printStackTrace();
//        } finally {
//            view.setAttributesMap(map);
//            mav.setView(view);
//            return mav;
//        }
//    }
}
