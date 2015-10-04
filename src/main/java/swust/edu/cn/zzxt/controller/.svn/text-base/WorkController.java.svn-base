package swust.edu.cn.zzxt.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import swust.edu.cn.zzxt.model.Work;
import swust.edu.cn.zzxt.service.WorkService;

@Controller
@RequestMapping("/WorkController")
public class WorkController {
	private WorkService workService;

	public WorkService getWorkService() {
		return workService;
	}
	@Autowired
	public void setWorkService(WorkService workService) {
		this.workService = workService;
	}
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/showWorkTime")
    public ModelAndView showWorkTime(int workId,HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
        	Work work = workService.selectByWorkId(workId);
        	map.put("work", work);
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
    @RequestMapping("/editWorkTime")
    public ModelAndView editWorkTime(Date startTime,Date endTime,int workId,HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
        	Work work = workService.selectByWorkId(workId);
        	work.setWorkStarttime(startTime);
        	work.setWorkEndtime(endTime);
        	work = workService.update(work);
        	map.put("work", work);
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
    @RequestMapping("/showAllWorkinfo")
    public ModelAndView showAllWorkinfo(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
        	List<Work> work = workService.findAllwork();
        	map.put("work", work);
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
}
