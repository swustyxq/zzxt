package swust.edu.cn.zzxt.controller;

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

import swust.edu.cn.zzxt.model.Learning;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.model.Student;
import swust.edu.cn.zzxt.service.LearningService;
import swust.edu.cn.zzxt.service.StudentService;

@Controller
@RequestMapping("/learningController")
public class LearningController {
    private LearningService learningService;

    public LearningService getlearningService() {
        return learningService;
    }

    @Autowired
    public void setlearningService(LearningService learningService) {
        this.learningService = learningService;
    }

    private StudentService studentService;

    public StudentService getStudentService() {
        return studentService;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/addormodifyStuLearing")
    public ModelAndView addormodifyStuLearing(Boolean addormodify,String semester, int graderank,int passcourse,int 
            requiredcourse,int selectcourse,int toatlNumber,Double gradepoint,Double requirepoint,
            String iscompreRank,int comprank,int comtotoalnumvalue,
            HttpServletRequest request,HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            //业务逻辑 
           
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");
            String msg = "loginout";
            if (user != null){
                msg = "success";
                Student student= studentService.findStudentById(user.getUserId());
                int stuId = student.getStudId();
                learningService.addormodifyLearing(addormodify,semester, graderank, passcourse,requiredcourse,
                        selectcourse,toatlNumber, iscompreRank,
                        comprank, comtotoalnumvalue, stuId,gradepoint,requirepoint);
            }
            map.put("result", Boolean.TRUE);
            map.put("message", msg);
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
    
    //实现查询数据库中所有学习情况
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/showAllLearning")
    public ModelAndView showAllLearning(HttpServletRequest request,HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            //业务逻辑 
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");
            int stuId=-1;
            List<Learning> allLearing;
            //if (user.getUserType() == 1)
            {
                Student student= studentService.findStudentById(user.getUserId());
                System.out.println(student.getStudId());
                stuId = student.getStudId();
            }
            allLearing = learningService.findAllLearning(stuId);
            map.put("result", Boolean.TRUE);
            map.put("message", "success");
            map.put("AllLearing", allLearing);
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
    
  //实现删除数据库中其中一条学习情况
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/deleteLearing")
    public ModelAndView deleteLearing(int id,HttpServletRequest request,HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            //业务逻辑 
            learningService.deleteLearingById(id);
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
    
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/showOneLearning")
    public ModelAndView showOneLearning(int id,HttpServletRequest request,HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            //业务逻辑 
            Learning learning = new Learning();
            learning = learningService.findOneLearningById(id);
            map.put("learning", learning);
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
     * @Title: obtainLearningByStudNumber GjjxjController
     * @Description: 根据学号必修课和及格门数信息
     * @param @param request
     * @param @param response
     * @param @param studNumber
     * @param @return
     * @param @throws Exception
     * @return ModelAndView
     * @throws
     */
    @SuppressWarnings({ "finally", "rawtypes", "unchecked" })
    @RequestMapping("/obtainLearningByStudNumber")
    public ModelAndView obtainLearningByStudNumber(HttpServletRequest request,
            HttpServletResponse response, String studNumber) throws Exception {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        Student student = new Student();
        Learning learning = new Learning();
        try {
            System.out.println(studNumber);
            student = studentService.obtainStudentByStudNumber(studNumber);            
            learning = learningService.obtainLearningByStudid(student.getStudId());
            
            
            // 业务逻辑
            map.put("learning", learning);                        
            map.put("result", Boolean.TRUE);
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
}
