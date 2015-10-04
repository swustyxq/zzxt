package swust.edu.cn.zzxt.controller;

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

import swust.edu.cn.zzxt.model.Parent;
import swust.edu.cn.zzxt.model.Student;
import swust.edu.cn.zzxt.model.Studentinfo;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.service.AreaService;
import swust.edu.cn.zzxt.service.ParentService;
import swust.edu.cn.zzxt.service.StudentService;
import swust.edu.cn.zzxt.service.StudentinfoService;

@Controller
@RequestMapping("/parentController")
public class ParentController {
    private StudentService studentService;
    private StudentinfoService studentinfoService;
    private AreaService areaService;
    
    public StudentinfoService getStudentinfoService() {
		return studentinfoService;
	}
    @Autowired
	public void setStudentinfoService(StudentinfoService studentinfoService) {
		this.studentinfoService = studentinfoService;
	}

	public AreaService getAreaService() {
		return areaService;
	}
	@Autowired
	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}

	public StudentService getStudentService() {
        return studentService;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    private ParentService parentService;

    public ParentService getParentService() {
        return parentService;
    }

    @Autowired
    public void setParentService(ParentService parentService) {
        this.parentService = parentService;
    }

    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/setPareInfo")
    public ModelAndView setPareInfo(int pare_id, String pare_name, String pare_phone, String pare_role,
            String pare_relation, String pare_IDNumber, String pare_occupation, String pare_work, String pare_duties,
            HttpServletResponse response, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        Student student = new Student();
        Parent parent = new Parent();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int id = user.getUserId();
        try {
            // 业务逻辑
            student = studentService.findStudentById(id);
            int pare_stuID = student.getStudId();
            parent.setPareId(pare_id);
            parent.setPareName(pare_name);
            parent.setParePhone(pare_phone);
            parent.setPareRole(pare_role);
            parent.setPareWork(pare_work);
            parent.setPareOccupation(pare_occupation);
            parent.setPareIdnumber(pare_IDNumber);
            parent.setPareStudid(pare_stuID);
            parent.setPareRelation(pare_relation);
            parent.setPareIseditable(1);
            parent.setPareState(1);
            parent.setPareDuties(pare_duties);

            parentService.setParent(parent);
            map.put("result", Boolean.TRUE);
            map.put("message", "success");
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
    @RequestMapping("/deletePareInfo")
    public ModelAndView deletePareInfo(int pare_Id, 
            HttpServletResponse response, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            // 业务逻辑
            parentService.deleteParent(pare_Id);
            map.put("result", Boolean.TRUE);
            map.put("message", "success");
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            map.put("message", "错误");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }

    
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/addParentInfo")
    public ModelAndView addParentInfo(String pare_name,String pare_phone,String pare_role,
            String pare_relation,String pare_IDNumber,String pare_occupation,String pare_work,String pare_duties,
            HttpServletResponse response, HttpServletRequest request)
    {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        Student student = new Student();
        Parent parent = new Parent();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int id = user.getUserId();
        try {
            // 业务逻辑   
            if (user.getUserType() == 1) {
                    student = studentService.findStudentById(id);
                    parent=new Parent();
                    int pare_userID = student.getStudId();
                    parent.setPareName(pare_name);
                    parent.setParePhone(pare_phone);
                    parent.setPareRole(pare_role);
                    parent.setPareWork(pare_work);
                    parent.setPareOccupation(pare_occupation);
                    parent.setPareIdnumber(pare_IDNumber);
                    parent.setPareStudid(pare_userID);
                    parent.setPareRelation(pare_relation);
                    parent.setPareIseditable(1);
                    parent.setPareState(1);
                    parent.setPareDuties(pare_duties);

                    System.out.println(parentService.selectByPrimaryName(pare_name));
                    parentService.addParent(parent);
                    map.put("result", Boolean.TRUE);
                    map.put("message", "success");
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
    @RequestMapping("/findParentById")
    public ModelAndView findParentById(int pareId, HttpServletResponse response, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        Parent parent = new Parent();
        try {
            // 业务逻辑
            parent = parentService.selectByPareId(pareId);
            map.put("result", Boolean.TRUE);
            map.put("message", "success");
            map.put("parent", parent);
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
    //wj
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/insertParent")
    public ModelAndView insertParent(String studNumber, String phoneNumber,
    		String fatherName,String FIdNumber,String motherName,String MIdNumber,
    		int province,int city ,int county,int town,String vallige,String stinResidence,
            HttpServletResponse response, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            Student student = new Student();
            List<Parent> parent = new ArrayList<Parent>();
            Parent parent1 =new Parent();
            Parent parent2 =new Parent();
            Studentinfo studentinfo0 = new Studentinfo();
            Studentinfo studentinfo = new Studentinfo();
            student = studentService.obtainStudentByStudNumber(studNumber);
            studentinfo0 = studentinfoService.selectBystudInfoStudId(student.getStudId());
            studentinfo = studentinfoService.updateByStinId(studentinfo0.getStinId(),vallige,town,stinResidence);//更新家庭详细地址
            parent = parentService.selectByStudId(student.getStudId());
            if(parent.size() <= 0){//不存在父母信息 直接插入
            	parent1 = parentService.insertParentByStudId(student.getStudId(),phoneNumber,fatherName,FIdNumber);
            	parent2 = parentService.insertParentByStudId(student.getStudId(),phoneNumber,motherName,MIdNumber);
            }else if(parent.size() == 1){//存在父母信息就更新
            	for(int i=0;i<parent.size();i++){
            		if(Integer.parseInt(parent.get(i).getPareIdnumber().substring(16, 17)) % 2 == 1){
            			parent1 = parentService.updateBypareId(parent.get(0).getPareId(),student.getStudId(),phoneNumber,fatherName,FIdNumber);
            			parent2 = parentService.insertParentByStudId(student.getStudId(),phoneNumber,motherName,MIdNumber);
            		}else{
            			parent2 = parentService.updateBypareId(parent.get(0).getPareId(),student.getStudId(),phoneNumber,motherName,MIdNumber);
            			parent1 = parentService.insertParentByStudId(student.getStudId(),phoneNumber,fatherName,FIdNumber);
            		}
            	}
            }
            else if(parent.size() == 2){
            	parent1 = parentService.updateBypareId(parent.get(0).getPareId(),student.getStudId(),phoneNumber,fatherName,FIdNumber);
            	parent2 = parentService.updateBypareId(parent.get(1).getPareId(),student.getStudId(),phoneNumber,motherName,MIdNumber);
            }
            map.put("result", Boolean.TRUE);
            map.put("message", "success");
            map.put("parent1", parent1);
            map.put("parent1", parent2);
            map.put("studentinfo", studentinfo);
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            map.put("message", "父母信息都不能为空！");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }
}
