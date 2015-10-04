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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Workbook;
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

import com.sun.org.apache.bcel.internal.generic.NEW;

import swust.edu.cn.zzxt.selfmodel.CountModal;
import swust.edu.cn.zzxt.selfmodel.ListModal;
import swust.edu.cn.zzxt.service.CommonService;
import swust.edu.cn.zzxt.service.GjjxjService;
import swust.edu.cn.zzxt.service.InstitutionService;
import swust.edu.cn.zzxt.service.LearningService;
import swust.edu.cn.zzxt.service.MajorService;
import swust.edu.cn.zzxt.service.PrizService;
import swust.edu.cn.zzxt.service.RewardService;
import swust.edu.cn.zzxt.service.StudentService;
import swust.edu.cn.zzxt.service.StudentclassService;
import swust.edu.cn.zzxt.service.StudentinfoService;
import swust.edu.cn.zzxt.service.UserService;
import swust.edu.cn.zzxt.service.WorkService;
import swust.edu.cn.zzxt.service.WorkstepfolwService;

import swust.edu.cn.zzxt.dao.UserMapper;
import swust.edu.cn.zzxt.model.Gjjxj;
import swust.edu.cn.zzxt.model.GjjxjWithBLOBs;
import swust.edu.cn.zzxt.model.GjzxjWithBLOBs;
import swust.edu.cn.zzxt.model.Institution;
import swust.edu.cn.zzxt.model.Learning;
import swust.edu.cn.zzxt.model.Major;
import swust.edu.cn.zzxt.model.Prize;
import swust.edu.cn.zzxt.model.Reward;
import swust.edu.cn.zzxt.model.Student;
import swust.edu.cn.zzxt.model.Studentclass;
import swust.edu.cn.zzxt.model.Studentinfo;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.model.Role;
import swust.edu.cn.zzxt.model.Work;
import swust.edu.cn.zzxt.model.Workstepfolw;

@Controller
@RequestMapping("/gjjxjController")
public class GjjxjController {

    private StudentService studentService;
    private GjjxjService gjjxjService;
    private RewardService rewardService;
    private PrizService prizService;
    private StudentinfoService studentinfoService;
    private WorkstepfolwService workstepfolwService;
    private CommonService commonService;
    private UserService userService;
    private List<ListModal> listModals;
    private InstitutionService institutionService;
    private WorkService workService;

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
    public UserService getUserService() {
        return userService;
    }
@Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public CommonService getCommonService() {
        return commonService;
    }

    @Autowired
    public void setCommonService(CommonService commonService) {
        this.commonService = commonService;
    }

    public WorkstepfolwService getWorkstepfolwService() {
        return workstepfolwService;
    }

    @Autowired
    public void setWorkstepfolwService(WorkstepfolwService workstepfolwService) {
        this.workstepfolwService = workstepfolwService;
    }

    public StudentinfoService getStudentinfoService() {
        return studentinfoService;
    }

    @Autowired
    public void setStudentinfoService(StudentinfoService studentinfoService) {
        this.studentinfoService = studentinfoService;
    }

    private StudentclassService studentclassService;

    public StudentclassService getStudentclassService() {
        return studentclassService;
    }

    @Autowired
    public void setStudentclassService(StudentclassService studentclassService) {
        this.studentclassService = studentclassService;
    }

    private MajorService majorService;

    public MajorService getMajorService() {
        return majorService;
    }

    @Autowired
    public void setMajorService(MajorService majorService) {
        this.majorService = majorService;
    }

    private LearningService learningService;

    public LearningService getLearningService() {
        return learningService;
    }

    @Autowired
    public void setLearningService(LearningService learningService) {
        this.learningService = learningService;
    }

    public PrizService getPrizService() {
        return prizService;
    }

    @Autowired
    public void setPrizService(PrizService prizService) {
        this.prizService = prizService;
    }

    public RewardService getRewardService() {
        return rewardService;
    }

    @Autowired
    public void setRewardService(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    public GjjxjService getGjjxjService() {
        return gjjxjService;
    }

    @Autowired
    public void setGjjxjService(GjjxjService gjjxjService) {
        this.gjjxjService = gjjxjService;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * @Title: obtainGjjxjByStudNumber GjjxjController
     * @Description: 根据学号查询国家奖学金信息
     * @param @param request
     * @param @param response
     * @param @param studNumber
     * @param @return
     * @param @throws Exception
     * @return ModelAndView
     * @throws
     */
    @SuppressWarnings({ "finally", "rawtypes", "unchecked" })
    @RequestMapping("/obtainGjjxjByStudNumber")
    public ModelAndView obtainGjjxjByStudNumber(int listid, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        User user = new User();
        HttpSession session = request.getSession();// 获取session
        user = (User) session.getAttribute("user");
        GjjxjWithBLOBs gjjxjWithBLOBS = new GjjxjWithBLOBs();
        
        try {
            if(listid != -1)
            gjjxjWithBLOBS = gjjxjService.selectByPrimaryKey(listid);
            else{
                Student student = studentService.selectInfoByUser(user.getUserId());
                gjjxjWithBLOBS = gjjxjService.obtainGjjxjWithBLOBSByStudid(student.getStudId());
            }
            String getGjxjApplytime = "";
            if (gjjxjWithBLOBS != null) {
                getGjxjApplytime = dateToStrLong(gjjxjWithBLOBS.getGjxjApplytime());
                String[] ranking = gjjxjWithBLOBS.getGjxjRanking().split("/");
                String[] comprehensiveRanking = gjjxjWithBLOBS.getGjxjComprehensiveranking().split("/");
                Workstepfolw workstepfolw = null;
                if (gjjxjWithBLOBS.getGjxjWsflid() != -1) {
                    workstepfolw = workstepfolwService.findWslfByWslfId(gjjxjWithBLOBS.getGjxjWsflid());
                }
                map.put("workstepfolw", workstepfolw);
                map.put("ranking", ranking);
                map.put("comprehensiveRanking", comprehensiveRanking);
                map.put("gjjxjWithBLOBS", gjjxjWithBLOBS);
                map.put("getGjxjApplytime", getGjxjApplytime);
                map.put("result", Boolean.TRUE);
                map.put("message", "success！");
            } else {
                map.put("result", Boolean.FALSE);
                map.put("message", "false！");
            }

            // 业务逻辑

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

    public static String dateToStrLong(java.util.Date dateDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(dateDate);
        return dateString;
    }

    @SuppressWarnings({ "finally", "rawtypes", "unchecked" })
    @RequestMapping("/findRewardByWorkId")
    public ModelAndView findRewardByWorkId(String schoolershipId, HttpServletRequest request,
            HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        List<Reward> rewards = new ArrayList<Reward>();
        try {
            rewards = rewardService.findRewardsByWorkId(7, schoolershipId);
            map.put("rewards", rewards);
            map.put("result", Boolean.TRUE);
            map.put("message", "success！");
        } catch (Exception e) {
            // TODO: handle exception
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
    @RequestMapping("/readStudentByStudNumber")
    public ModelAndView readStudentByStudNumber(int stuid, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        User user = new User();
        HttpSession session = request.getSession();// 获取session
        user = (User) session.getAttribute("user");
        if(stuid == -1){
            Student temp = studentService.selectInfoByUser(user.getUserId());
            stuid = temp.getStudId();
        }
        try {
            Student student = new Student();
            Studentinfo studentInfo = new Studentinfo();
            Studentclass studentClass = new Studentclass();
            Major major = new Major();

            List<Learning> learning = new ArrayList<Learning>();

            student = studentService.findStudentByStudId(stuid);
            studentInfo = studentinfoService.selectBystudInfoStudId(student.getStudId());
            studentClass = studentclassService.selectBystudInfoStudId(student.getStudClassid());
            major = majorService.selectByPrimaryKey(studentClass.getClassMajrid());
            learning = learningService.findAllLearning(student.getStudId());
            Work work = workService.selectByWorkId(7);
            map.put("result", Boolean.TRUE);
            map.put("work", work);
            map.put("student", student);
            map.put("studentInfo", studentInfo);
            map.put("studentClass", studentClass);
            map.put("major", major);
            if (learning.size() > 0)
                map.put("learning", learning);
            else {
                map.put("learning", null);
            }
            map.put("message", "success！");
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

    @SuppressWarnings({ "finally", "rawtypes", "unchecked" })
    @RequestMapping("/getAllPrize")
    public ModelAndView getAllPrize(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        Student student = new Student();
        List<Prize> prizes = new ArrayList<Prize>();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        try {
            if (user.getUserType() == 1) {
                student = studentService.findStudentById(user.getUserId());
                prizes = prizService.findPrizInfoByStudId(student.getStudId());
                map.put("result", Boolean.TRUE);
                map.put("message", "success！");
                map.put("prizes", prizes);
            }
        } catch (Exception e) {
            // TODO: handle exception
            map.put("result", Boolean.FALSE);
            map.put("message", "执行出现出错！");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }

    @SuppressWarnings({ "finally", "rawtypes", "unchecked" })
    @RequestMapping("/submitRewardsInfo")
    public ModelAndView submitRewardsInfo(Integer rawardFlagId0, Integer rawardFlagId1, Integer rawardFlagId2,
            Integer rawardFlagId3, String time0, String name0, String awaer0, String time1, String name1,
            String awaer1, String time2, String name2, String awaer2, String time3, String name3, String awaer3,
            Integer gjjxjFlag, Integer mingci, Integer zongrenshu, String stinPoliticstate, String comprehensive,
            Integer paiming, Integer mingcizongrenshu, String applyReason, HttpServletRequest request,
            HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        Student student = new Student();

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Role> roles = (List<Role>) session.getAttribute("role");
        Workstepfolw workstepfolws;
        try {
            // 判断是否为学生
            if (user.getUserType() == 1) {
                student = studentService.findStudentById(user.getUserId());
                GjjxjWithBLOBs gjjxjWithBLOBs = new GjjxjWithBLOBs();
                gjjxjWithBLOBs.setGjxjStudid(student.getStudId());
                int situation = 1;
                for (int i = 0; i < roles.size(); ++i) {
                    if (roles.get(i).getRoleId() == 7) {
                        situation = 2;
                    }
                    if (roles.get(i).getRoleId() == 13) {
                        situation = 3;
                        break;
                    }
                }
                workstepfolws = workstepfolwService.getWsflIdByWorkidAndSituation(7, situation);
                gjjxjWithBLOBs.setGjxjWsflid(workstepfolws.getWsflNextstep());
                gjjxjWithBLOBs.setGjxjWorkid(7);
                gjjxjWithBLOBs.setGjxjPoliticstate(stinPoliticstate);
                gjjxjWithBLOBs.setGjxjRanking(mingci + "/" + zongrenshu);
                gjjxjWithBLOBs.setGjxjAnnual("2013-2014");
                gjjxjWithBLOBs.setGjxjComprehensive(comprehensive);
                if (comprehensive != "否") {
                    gjjxjWithBLOBs.setGjxjComprehensiveranking(paiming + "/" + mingcizongrenshu);
                } else {
                    gjjxjWithBLOBs.setGjxjComprehensiveranking("");
                }
                gjjxjWithBLOBs.setGjxjApplytime(new Date());
                gjjxjWithBLOBs.setGjxjState(0);
                gjjxjWithBLOBs.setGjxjApplyreason(applyReason);
                if (gjjxjFlag == -1) {
                    gjjxjService.insert(gjjxjWithBLOBs);
                } else {
                    gjjxjWithBLOBs.setGjxjId(gjjxjFlag);
                    gjjxjService.update(gjjxjWithBLOBs);
                }

                GjjxjWithBLOBs temp = gjjxjService.obtainGjjxjWithBLOBSByStudid(student.getStudId());

                // 重置Reward表
                if (rawardFlagId0 != -1)
                    rewardService.deleteRewardById(rawardFlagId0);
                if (rawardFlagId1 != -1)
                    rewardService.deleteRewardById(rawardFlagId1);
                if (rawardFlagId2 != -1)
                    rewardService.deleteRewardById(rawardFlagId2);
                if (rawardFlagId3 != -1)
                    rewardService.deleteRewardById(rawardFlagId3);

                if (name0 != null && name0 != "" && time0 != null && time0 != "" && awaer0 != null && awaer0 != "") {
                    Reward reward = new Reward();
                    reward.setRewrName(name0);
                    reward.setRewrScholarshipid(temp.getGjxjId() + "");
                    reward.setRewrTime(time0);
                    reward.setRewrAwarded(awaer0);
                    reward.setRewrWorkid(7);
                    System.out.println(name0);
                    rewardService.insert(reward);
                }
                if (name1 != null && name1 != "" && time1 != null && time1 != "" && awaer1 != null && awaer1 != "") {
                    Reward reward = new Reward();
                    reward.setRewrName(name1);
                    reward.setRewrScholarshipid(temp.getGjxjId() + "");
                    reward.setRewrTime(time1);
                    reward.setRewrWorkid(7);
                    reward.setRewrAwarded(awaer1);
                    System.out.println(name1);
                    rewardService.insert(reward);
                }
                if (name2 != null && name2 != "" && time2 != null && time2 != "" && awaer2 != null && awaer2 != "") {
                    Reward reward = new Reward();
                    reward.setRewrName(name2);
                    reward.setRewrScholarshipid(temp.getGjxjId() + "");
                    reward.setRewrTime(time2);
                    reward.setRewrWorkid(7);
                    reward.setRewrAwarded(awaer2);
                    rewardService.insert(reward);
                }
                if (name3 != null && name3 != "" && time3 != null && time3 != "" && awaer3 != null && awaer3 != "") {
                    Reward reward = new Reward();
                    reward.setRewrName(name3);
                    reward.setRewrScholarshipid(temp.getGjxjId() + "");
                    reward.setRewrTime(time3);
                    reward.setRewrWorkid(7);
                    reward.setRewrAwarded(awaer3);
                    rewardService.insert(reward);
                }

                map.put("result", Boolean.TRUE);
                map.put("message", "success！");
            }
        } catch (Exception e) {
            // TODO: handle exception
            map.put("result", Boolean.FALSE);
            map.put("message", "执行出现出错！");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }

    @SuppressWarnings({ "finally", "rawtypes", "unchecked" })
    @RequestMapping("/saveRewardsInfo")
    public ModelAndView saveRewardsInfo(Integer rawardFlagId0, Integer rawardFlagId1, Integer rawardFlagId2,
            Integer rawardFlagId3, String time0, String name0, String awaer0, String time1, String name1,
            String awaer1, String time2, String name2, String awaer2, String time3, String name3, String awaer3,
            Integer gjjxjFlag, Integer mingci, Integer zongrenshu, String stinPoliticstate, String comprehensive,
            Integer paiming, Integer mingcizongrenshu, String applyReason, HttpServletRequest request,
            HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        Student student = new Student();

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Role> roles = (List<Role>) session.getAttribute("role");
        Workstepfolw workstepfolws;
        try {
            // 判断是否为学生
            if (user.getUserType() == 1) {
                student = studentService.findStudentById(user.getUserId());
                GjjxjWithBLOBs gjjxjWithBLOBs = new GjjxjWithBLOBs();
                gjjxjWithBLOBs.setGjxjStudid(student.getStudId());
                int situation = 1;
                for (int i = 0; i < roles.size(); ++i) {
                    if (roles.get(i).getRoleId() == 7) {
                        situation = 2;
                    }
                    if (roles.get(i).getRoleId() == 13) {
                        situation = 3;
                        break;
                    }
                }
                workstepfolws = workstepfolwService.getWsflIdByWorkidAndSituation(7, situation);
                System.out.println(situation + "@@@@@" + workstepfolws.getWsflId());
                gjjxjWithBLOBs.setGjxjWsflid(workstepfolws.getWsflId());
                gjjxjWithBLOBs.setGjxjWorkid(7);
                gjjxjWithBLOBs.setGjxjPoliticstate(stinPoliticstate);
                gjjxjWithBLOBs.setGjxjRanking(mingci + "/" + zongrenshu);
                gjjxjWithBLOBs.setGjxjAnnual("2013-2014");
                gjjxjWithBLOBs.setGjxjComprehensive(comprehensive);
                if (comprehensive != "否") {
                    gjjxjWithBLOBs.setGjxjComprehensiveranking(paiming + "/" + mingcizongrenshu);
                } else {
                    gjjxjWithBLOBs.setGjxjComprehensiveranking("");
                }
                gjjxjWithBLOBs.setGjxjApplytime(new Date());
                gjjxjWithBLOBs.setGjxjState(0);
                gjjxjWithBLOBs.setGjxjApplyreason(applyReason);
                if (gjjxjFlag == -1) {
                    gjjxjService.insert(gjjxjWithBLOBs);
                } else {
                    gjjxjWithBLOBs.setGjxjId(gjjxjFlag);
                    gjjxjService.update(gjjxjWithBLOBs);
                }

                GjjxjWithBLOBs temp = gjjxjService.obtainGjjxjWithBLOBSByStudid(student.getStudId());

                // 重置Reward表
                if (rawardFlagId0 != -1)
                    rewardService.deleteRewardById(rawardFlagId0);
                if (rawardFlagId1 != -1)
                    rewardService.deleteRewardById(rawardFlagId1);
                if (rawardFlagId2 != -1)
                    rewardService.deleteRewardById(rawardFlagId2);
                if (rawardFlagId3 != -1)
                    rewardService.deleteRewardById(rawardFlagId3);

                if (name0 != null && name0 != "" && time0 != null && time0 != "" && awaer0 != null && awaer0 != "") {
                    Reward reward = new Reward();
                    reward.setRewrName(name0);
                    reward.setRewrScholarshipid(temp.getGjxjId() + "");
                    reward.setRewrTime(time0);
                    reward.setRewrAwarded(awaer0);
                    reward.setRewrWorkid(7);
                    System.out.println(name0);
                    rewardService.insert(reward);
                }
                if (name1 != null && name1 != "" && time1 != null && time1 != "" && awaer1 != null && awaer1 != "") {
                    Reward reward = new Reward();
                    reward.setRewrName(name1);
                    reward.setRewrScholarshipid(temp.getGjxjId() + "");
                    reward.setRewrTime(time1);
                    reward.setRewrWorkid(7);
                    reward.setRewrAwarded(awaer1);
                    System.out.println(name1);
                    rewardService.insert(reward);
                }
                if (name2 != null && name2 != "" && time2 != null && time2 != "" && awaer2 != null && awaer2 != "") {
                    Reward reward = new Reward();
                    reward.setRewrName(name2);
                    reward.setRewrScholarshipid(temp.getGjxjId() + "");
                    reward.setRewrTime(time2);
                    reward.setRewrWorkid(7);
                    reward.setRewrAwarded(awaer2);
                    rewardService.insert(reward);
                }
                if (name3 != null && name3 != "" && time3 != null && time3 != "" && awaer3 != null && awaer3 != "") {
                    Reward reward = new Reward();
                    reward.setRewrName(name3);
                    reward.setRewrScholarshipid(temp.getGjxjId() + "");
                    reward.setRewrTime(time3);
                    reward.setRewrWorkid(7);
                    reward.setRewrAwarded(awaer3);
                    rewardService.insert(reward);
                }

                map.put("result", Boolean.TRUE);
                map.put("message", "success！");
            }
        } catch (Exception e) {
            // TODO: handle exception
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
                listModals = commonService.findAllInfo(1, 7, user.getUserId());
                map.put("role", 1);
                map.put("listModals", listModals);
                map.put("result", Boolean.TRUE);
                map.put("message", "success");
            } else {
                List<CountModal> countModals = new ArrayList<CountModal>();
                
                System.out.println(countModals);
                int roleid = 0;
                for (int i = 0; i < roles.size(); ++i) {
                    if (roles.get(i).getRoleId() == 2 || roles.get(i).getRoleId() == 7 || (roles.get(i).getRoleId() > 12 && roles.get(i).getRoleId()<15) || roles.get(i).getRoleId() == 21) {
                        if (roleid < roles.get(i).getRoleId())
                            roleid = roles.get(i).getRoleId();
                    }
                }
                if (roleid != 0) {
                    listModals = commonService.findAllInfo(roleid, 7, user.getUserId());
                    countModals = commonService.findAllCountInfo(user.getUserId(),7,listModals);
                    map.put("count", countModals);
                    map.put("role", roleid);
                    map.put("instid", institution.getInstId());
                    map.put("listModals", listModals);
                    map.put("result", Boolean.TRUE);
                    map.put("message", "success");
                } else {
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

    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/auditGjjxjApply")
    public ModelAndView auditGjjxjApply(Integer rawardFlagId0, Integer rawardFlagId1, Integer rawardFlagId2,
            Integer rawardFlagId3, String time0, String name0, String awaer0, String time1, String name1,
            String awaer1, String time2, String name2, String awaer2, String time3, String name3, String awaer3,
            String comprehensive, String paiming, String mingcizongrenshu, String mingci, String zongrenshu, int gjjxjid,
            int auditid, String applyReason, String classOption, String academyOption, Integer workId,
            HttpServletRequest request) {
        System.out.println("comein0");
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        System.out.println("comein1");
        GjjxjWithBLOBs gjjxjWithBLOBs = new GjjxjWithBLOBs();
        try {// 查reuserrol 判断角色
            gjjxjWithBLOBs.setGjxjRanking(mingci + "/" + zongrenshu);
            System.out.println("comein3");
            gjjxjWithBLOBs.setGjxjComprehensive(comprehensive);
            if (comprehensive == "是") {
                gjjxjWithBLOBs.setGjxjComprehensiveranking(paiming + "/" + mingcizongrenshu);
            }
            gjjxjWithBLOBs.setGjxjId(gjjxjid);
            gjjxjWithBLOBs.setGjxjApplyreason(applyReason);
            gjjxjWithBLOBs.setGjxjAcademyopinion(classOption);// 学院意见
            if (classOption != "" || classOption != null)
                gjjxjWithBLOBs.setGjxjAcademyopiniontime(new Date());
            gjjxjWithBLOBs.setGjxjSchoolopinion(academyOption);// 学意见
            if (academyOption != "" || academyOption != null)
                gjjxjWithBLOBs.setGjxjSchoolopiniontime(new Date());
            // 获取工作流
            GjjxjWithBLOBs gjjxjWithBLOBs2 = gjjxjService.selectByPrimaryKey(gjjxjid);
            Workstepfolw workstepfolw = workstepfolwService.findWslfByWslfId(gjjxjWithBLOBs2.getGjxjWsflid());
            if (auditid == 1) {
                // 审批通过
                gjjxjWithBLOBs.setGjxjWsflid(workstepfolw.getWsflNextstep());
                if (workstepfolw.getWsflNextstep() == -1)
                    gjjxjWithBLOBs.setGjxjState(1);
            } else if (auditid == 2) {
                // 驳回
                gjjxjWithBLOBs.setGjxjWsflid(workstepfolw.getWsflPrestep());
            }

            if (rawardFlagId0 != -1)
                rewardService.deleteRewardById(rawardFlagId0);
            if (rawardFlagId1 != -1)
                rewardService.deleteRewardById(rawardFlagId1);
            if (rawardFlagId2 != -1)
                rewardService.deleteRewardById(rawardFlagId2);
            if (rawardFlagId3 != -1)
                rewardService.deleteRewardById(rawardFlagId3);

            if (name0 != null && name0 != "" && time0 != null && time0 != "" && awaer0 != null && awaer0 != "") {
                Reward reward = new Reward();
                reward.setRewrName(name0);
                reward.setRewrScholarshipid(gjjxjid + "");
                reward.setRewrTime(time0);
                reward.setRewrAwarded(awaer0);
                reward.setRewrWorkid(7);
                System.out.println(name0);
                rewardService.insert(reward);
            }
            if (name1 != null && name1 != "" && time1 != null && time1 != "" && awaer1 != null && awaer1 != "") {
                Reward reward = new Reward();
                reward.setRewrName(name1);
                reward.setRewrScholarshipid(gjjxjid + "");
                reward.setRewrTime(time1);
                reward.setRewrWorkid(7);
                reward.setRewrAwarded(awaer1);
                System.out.println(name1);
                rewardService.insert(reward);
            }
            if (name2 != null && name2 != "" && time2 != null && time2 != "" && awaer2 != null && awaer2 != "") {
                Reward reward = new Reward();
                reward.setRewrName(name2);
                reward.setRewrScholarshipid(gjjxjid + "");
                reward.setRewrTime(time2);
                reward.setRewrWorkid(7);
                reward.setRewrAwarded(awaer2);
                rewardService.insert(reward);
            }
            if (name3 != null && name3 != "" && time3 != null && time3 != "" && awaer3 != null && awaer3 != "") {
                Reward reward = new Reward();
                reward.setRewrName(name3);
                reward.setRewrScholarshipid(gjjxjid + "");
                reward.setRewrTime(time3);
                reward.setRewrWorkid(7);
                reward.setRewrAwarded(awaer3);
                rewardService.insert(reward);
            }

            gjjxjService.update(gjjxjWithBLOBs);// 审批表
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
    
    @SuppressWarnings({ "rawtypes", "finally", "unchecked" })
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
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
            String date = sdf.format(System.currentTimeMillis());
            session.setAttribute("DownLoadDate", date);
            String path = request.getSession().getServletContext().getRealPath("upload/gjjxj" +date +".xls");
            map.put("date", date);
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
                int row=0;
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
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void downloadFile(int academyid,int majorid, int classid, String year, String patch,
            HttpServletRequest request, HttpServletResponse response) throws IOException, RowsExceededException,
            WriteException {
        try {
            // 封装下载
            // path是指欲下载的文件的路径。
            HttpSession session = request.getSession();
            String date = (String)session.getAttribute("DownLoadDate");
            String path = request.getSession().getServletContext().getRealPath("upload/gjjxj"+date+".xls");

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
}
