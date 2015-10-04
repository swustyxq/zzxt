package swust.edu.cn.zzxt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import swust.edu.cn.zzxt.model.Area;
import swust.edu.cn.zzxt.model.Student;
import swust.edu.cn.zzxt.model.Studentinfo;
import swust.edu.cn.zzxt.service.AreaService;
import swust.edu.cn.zzxt.service.InformationService;
import swust.edu.cn.zzxt.service.StudentService;
import swust.edu.cn.zzxt.service.StudentinfoService;

@Controller
@RequestMapping("/AreaController")
public class AreaController {
	private AreaService areaService;
	private StudentService studentService;
	private StudentinfoService studentinfoService;
	private InformationService informationService;
	
	public InformationService getInformationService() {
		return informationService;
	}
	@Autowired
	public void setInformationService(InformationService informationService) {
		this.informationService = informationService;
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

	public AreaService getAreaService() {
		return areaService;
	}

	@Autowired
	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/searchAreasByAreaParentId")
	public ModelAndView searchAreasByAreaParentId(Integer areaParentId,HttpServletRequest request)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			// 业务逻辑
			List<Area> areaList = areaService.getAreaByParentId(areaParentId);
			map.put("areaList", areaList);
			map.put("result", Boolean.TRUE);
			map.put("message", "success");
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
    @RequestMapping("/searchAreaByAreaId")
    public ModelAndView searchAreaByAreaId(Integer areaId,HttpServletRequest request)
            throws Exception {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            // 业务逻辑
            Area area = areaService.getAreaById(areaId);
            if(area!=null){
            map.put("area", area);
            map.put("result", Boolean.TRUE);
            map.put("message", "success");
            }else{
                map.put("result", Boolean.FALSE);
                map.put("message", "不存在该地区！");
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
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/readinfoByStudNumber")
    public ModelAndView readinfoByStudNumber(String studNumber,HttpServletRequest request)
            throws Exception {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
             Student student = new Student();
             Studentinfo studentinfo = new Studentinfo();
             student = studentService.obtainStudentByStudNumber(studNumber);
             if(student != null){
            	 studentinfo = studentinfoService.selectBystudInfoStudId(student.getStudId());
                 if(studentinfo != null){
                	 Area town=informationService.findAreaByAreaId(studentinfo.getStinAreaidhome());
                     Area county=informationService.findAreaByAreaId(town.getAreaParentid());    
                     Area city=informationService.findAreaByAreaId(county.getAreaParentid());               
                     Area province=informationService.findAreaByAreaId(city.getAreaParentid());
                     map.put("result", Boolean.TRUE);
                     map.put("message", "success");
                     map.put("town", town.getAreaId());
                     map.put("county", county.getAreaId());           
                     map.put("city", city.getAreaId());                    
                     map.put("province", province.getAreaId());
                 }
             }else{
            	 map.put("result", Boolean.FALSE);
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

}
