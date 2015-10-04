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

import swust.edu.cn.zzxt.model.Announcement;
import swust.edu.cn.zzxt.model.Announcementtype;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.selfmodel.ArticleModel;
import swust.edu.cn.zzxt.service.AnnouncementService;
import swust.edu.cn.zzxt.service.AnnouncementtypeService;

@Controller
@RequestMapping("/announcementController")
public class AnnouncementController {
	private AnnouncementService announcementService;
	private AnnouncementtypeService announcementtypeService;
	
	public AnnouncementtypeService getAnnouncementtypeService() {
		return announcementtypeService;
	}
	
	@Autowired
	public void setAnnouncementtypeService(
			AnnouncementtypeService announcementtypeService) {
		this.announcementtypeService = announcementtypeService;
	}

	public AnnouncementService getAnnouncementService() {
		return announcementService;
	}
	
	@Autowired
	public void setAnnouncementService(AnnouncementService announcementService) {
		this.announcementService = announcementService;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/showAllannouncementType")
	public ModelAndView showAllannouncementType(HttpServletResponse response, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();

		try {
			// 业务逻辑
			List<Announcementtype> list=new ArrayList<Announcementtype>();
			list=announcementtypeService.findAllAnnouncementtype();
			map.put("result", Boolean.TRUE);
			map.put("message", "success");
			map.put("type", list);
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
	@RequestMapping("/publishAnnouncement")
	public ModelAndView publishAnnouncement(String title,String content,int type,HttpServletResponse response, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		User user=new User();
		try {
			user = new User();
			HttpSession session = request.getSession();
			user = (User) session.getAttribute("user");
			int userId=user.getUserId();
			// 业务逻辑
			boolean flag=announcementService.save(title, content, type,userId);
			if (flag) {
				map.put("result", Boolean.TRUE);
				map.put("message", "success");
			}else {
				map.put("result", Boolean.FALSE);
				map.put("message", "保存失败！");
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
	@RequestMapping("/showAnnouncementsByType")
	public ModelAndView showAnnouncementsByType(int page,int type,HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		User user=new User();
		try {
			user = new User();
			HttpSession session = request.getSession();
			user = (User) session.getAttribute("user");
			int userId=user.getUserId();
			
			List<ArticleModel> list=new ArrayList<ArticleModel>();
			list=announcementService.findByType(type);
			int recordCount = list.size();// 总记录数
			int pageCount;// 总页数
			int temp = recordCount % 10;// 10条记录一页
			if (temp == 0) {
				pageCount = recordCount / 10;
			} else {
				pageCount = recordCount / 10 + 1;
			}
			List<ArticleModel> pageList=new ArrayList<ArticleModel>();
			int max=list.size()>page*10?page*10:list.size();
			for (int i = (page - 1) * 10; i <max; i++) {
				pageList.add(list.get(i));
			}
			map.put("pageList", pageList);
			map.put("pageCount", pageCount);
			map.put("page", page);
			
			map.put("result", Boolean.TRUE);
			map.put("announcement", list);
			map.put("user", user);
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
	@RequestMapping("/findAnnouncementsById")
	public ModelAndView findAnnouncementsById(int id,HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			ArticleModel articleModel=new ArticleModel();
			articleModel=announcementService.findById(id);
			
			map.put("result", Boolean.TRUE);
			map.put("detail", articleModel);
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
	@RequestMapping("/updateAnnouncement")
	public ModelAndView updateAnnouncement(int id,String title,String content,int type,HttpServletResponse response, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		User user=new User();
		try {
			// 业务逻辑
			boolean flag=announcementService.update(title, content, type,id);
			if (flag) {
				map.put("result", Boolean.TRUE);
				map.put("message", "success");
			}else {
				map.put("result", Boolean.FALSE);
				map.put("message", "保存失败！");
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
	@RequestMapping("/deleteAnnouncement")
	public ModelAndView deleteAnnouncement(int id,HttpServletResponse response, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		User user=new User();
		try {
			// 业务逻辑
			boolean flag=announcementService.deleteById(id);
			if (flag) {
				map.put("result", Boolean.TRUE);
				map.put("message", "success");
			}else {
				map.put("result", Boolean.FALSE);
				map.put("message", "保存失败！");
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
	
	/**
	 * 首页显示的内容
	 * @param type
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/findAnnouncementsByType")
	public ModelAndView findAnnouncementsByType(int type,HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		User user=new User();
		try {
			user = new User();
			HttpSession session = request.getSession();
			user = (User) session.getAttribute("user");
			int userId=user.getUserId();
			
			List<ArticleModel> list=new ArrayList<ArticleModel>();
			list=announcementService.findByType(type);
			
			map.put("result", Boolean.TRUE);
			map.put("announcement", list);
			map.put("user", user);
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
	 @RequestMapping("/showWorkIntroduction")
	 public ModelAndView showWorkIntroduction(int id,HttpServletRequest request,HttpServletResponse response) {
	     ModelAndView mav = new ModelAndView();
	     MappingJacksonJsonView view = new MappingJacksonJsonView();
	     Map map = new HashMap();
	     try {
	         ArticleModel articleModel=new ArticleModel();
	         articleModel=announcementService.findWorkIntroduction(id);
	         
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
