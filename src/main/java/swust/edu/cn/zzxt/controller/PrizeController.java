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

import swust.edu.cn.zzxt.model.Prize;
import swust.edu.cn.zzxt.model.Student;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.service.PrizService;
import swust.edu.cn.zzxt.service.StudentService;

@Controller
@RequestMapping("/prizeController")
public class PrizeController {
	private List<Prize> allPrizeList;
	public List<Prize> getAllPrizeList() {
		return allPrizeList;
	}
	
	public void setAllPrizeList(List<Prize> allPrizeList) {
		this.allPrizeList = allPrizeList;
	}
	private PrizService prizService;
	private StudentService studentService;

	public StudentService getStudentService() {
		return studentService;
	}

	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public PrizService getPrizService() {
		return prizService;
	}

	@Autowired
	public void setPrizService(PrizService prizService) {
		this.prizService = prizService;
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/inputStuPrizInfo")
	public ModelAndView InputStuPrizInfo(String prizname, String prizlevel,
			String prizawarded, String priztime, int prizisIndividual,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			// 业务逻辑
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			System.out.println(user.getUserType() + "+++");
			if (user.getUserType() != null) {
				if (user.getUserType() == 1) {
					Student student = new Student();
					try {
						student = studentService.findStudentById(user
								.getUserId());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
					int prizStudId = student.getStudId();
					Prize prize = new Prize();
					prize = prizService
							.updateStuPrizInfo(prizname, prizlevel,
									prizawarded, priztime, prizisIndividual,
									prizStudId);
					map.put("result", Boolean.TRUE);
					map.put("message", "success");
					map.put("prize", prize);
				} else {
					map.put("result", Boolean.FALSE);
					map.put("message", "该用户没有可操作的权限！");
				}
			} else {
				map.put("result", Boolean.FALSE);
				map.put("message", "该用户没有可操作的权限！");
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
	@RequestMapping("/showAllStuPrizInfo")
	public ModelAndView ShowAllStuPrizInfo(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			// 业务逻辑
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			if (user.getUserType() != null) {
				if (user.getUserType() == 1) {
					Student student = new Student();
					student = studentService.findStudentById(user.getUserId());
					System.out.println(user.getUserType() + "+++++");
					List<Prize> prize = new ArrayList<Prize>();
					prize = prizService.findStuPrizInfoByprizStuId(student
							.getStudId());
					if(prize.size()>0)
					{
					setAllPrizeList(prize);
					int recordCount = prize.size();//总记录数
					int pageCount;//总页数
					int temp = recordCount % 10000;//10条记录一页
					if(temp == 0){
						pageCount = recordCount/10000;
					}else{
						pageCount = recordCount/10000 + 1;
					}
					List<Prize> firstPrizeList = new ArrayList<Prize>();
					int max = 0;
					int page = 1;
					max = allPrizeList.size()>page*10000?page*10000:allPrizeList.size();
					for(int j=(page-1)*10000;j<max;j++)
					{
						firstPrizeList.add(allPrizeList.get(j));
					}
					map.put("result", Boolean.TRUE);
					map.put("message", "success");
					map.put("firstPrizeList",firstPrizeList);
					map.put("pageCount", pageCount);
					map.put("page", page);
					map.put("prize", prize);
					map.put("student", student);
					}else
					{
						map.put("result", Boolean.FALSE);
						map.put("message", "未找到奖励信息");
						map.put("student", student);
					}
				} else {
					map.put("result", Boolean.FALSE);
					map.put("message", "该用户没有可操作的权限！");
				}
			} else {
				map.put("result", Boolean.FALSE);
				map.put("message", "该用户没有可操作的权限！");
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

	@SuppressWarnings({ "unchecked", "finally", "rawtypes" })
	@RequestMapping("/deletePrizInfo")
	public ModelAndView DeletePrizInfo(int prizId, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			// 业务逻辑
			Prize prize = prizService.deleteByPrizeId(prizId);
			if (prize.getPrizId() == null) {
				map.put("result", Boolean.TRUE);
				map.put("message", "删除成功");
			} else {
				map.put("result", Boolean.FALSE);
				map.put("message", "执行出现出错！");
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

	@SuppressWarnings({ "unchecked", "finally", "rawtypes" })
	@RequestMapping("/findOnePrizInfo")
	public ModelAndView FindOnePrizInfo(int prizId, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			// 业务逻辑
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			if (user.getUserType() != null) {
				if (user.getUserType() == 1) {
					Student student = new Student();
					student = studentService.findStudentById(user
								.getUserId());
					Prize prize = prizService.findPrizInfoByPrizId(prizId);
					if (prize.getPrizId() != null) {
						map.put("result", Boolean.TRUE);
						map.put("message", "success");
						map.put("prize", prize);
						map.put("student", student);
					} else {
						map.put("result", Boolean.TRUE);
						map.put("student", student);
						map.put("message", "未找到奖励信息");
					}
				} else {
					map.put("result", Boolean.FALSE);
					map.put("message", "该用户没有可操作的权限！");
				}
			} else {
				map.put("result", Boolean.FALSE);
				map.put("message", "该用户没有可操作的权限！");
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
	@SuppressWarnings({ "unchecked", "finally", "rawtypes" })
	@RequestMapping("/editPrizeInfo")
	public ModelAndView EditPrizeInfo(int prizId,String prizName, String prizLevel,
			String prizAwarded, String prizTime, int prizIsIndividual, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			// 业务逻辑
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			System.out.println(user.getUserType() + "+++");
			if (user.getUserType() != null) {
				if (user.getUserType() == 1) {
					System.out.println(user.getUserType() + "____");
					Student student = new Student();
					System.out.println(user.getUserType() + "****");
					try {
						student = studentService.findStudentById(user
								.getUserId());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("这是怎么回事啊？");
					int prizStudid=student.getStudId();
					Prize prize = prizService.EditPrizInfoByPrizId(prizId,prizName,prizLevel,prizAwarded,prizTime,prizIsIndividual,prizStudid);
					System.out.println("这是怎么回事啊？");
					if (prize.getPrizId() != null) {
						System.out.println("这是怎么回事啊？");
						map.put("result", Boolean.TRUE);
						map.put("message", "success");
						map.put("prize", prize);
						map.put("student", student);
					} else {
						map.put("result", Boolean.TRUE);
						map.put("message", "未找到奖励信息");
					}
				} else {
					map.put("result", Boolean.FALSE);
					map.put("message", "该用户没有可操作的权限！");
				}
			} else {
				map.put("result", Boolean.FALSE);
				map.put("message", "该用户没有可操作的权限！");
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
	//分页
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/showOnePageStuPrizInfo")
	public ModelAndView ShowOnePageStuPrizInfo(int page,HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			// 业务逻辑
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			System.out.println(user.getUserType() + "+++");
			if (user.getUserType() != null) {
				if (user.getUserType() == 1) {
					System.out.println(user.getUserType() + "____");
					Student student = new Student();
					System.out.println(user.getUserType() + "****");
					try {
						
						student = studentService.findStudentById(user
								.getUserId());
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(user.getUserType() + "+++++");
					
					List<Prize> prize = new ArrayList<Prize>();
					
					prize = prizService.findStuPrizInfoByprizStuId(student
							.getStudId());
					if(prize.size()>0)
					{
					setAllPrizeList(prize);
					int recordCount = prize.size();//总记录数
					int pageCount;//总页数
					int temp = recordCount % 10;//10条记录一页
					if(temp == 0){
						pageCount = recordCount/10;
					}else{
						pageCount = recordCount/10 + 1;
					}
					List<Prize> pagePrizeList = new ArrayList<Prize>();
					int max = 0;
					
					max = allPrizeList.size()>page*10?page*10:allPrizeList.size();
					for(int j=(page-1)*10;j<max;j++)
					{
						pagePrizeList.add(allPrizeList.get(j));
					}
					map.put("result", Boolean.TRUE);
					map.put("message", "success");
					map.put("pagePrizeList",pagePrizeList);
					map.put("pageCount", pageCount);
					map.put("page", page);
					map.put("student", student);
					}else
					{
						map.put("result", Boolean.FALSE);
						map.put("message", "未找到奖励信息");
					}
				} else {
					map.put("result", Boolean.FALSE);
					map.put("message", "该用户没有可操作的权限！");
				}
			} else {
				map.put("result", Boolean.FALSE);
				map.put("message", "该用户没有可操作的权限！");
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
		
		@SuppressWarnings({ "unchecked", "finally", "rawtypes" })
		@RequestMapping("/findPrizInfo")
		public ModelAndView findPrizInfo(Integer studId,HttpServletRequest request,
				HttpServletResponse response) {
			ModelAndView mav = new ModelAndView();
			MappingJacksonJsonView view = new MappingJacksonJsonView();
			Map map = new HashMap();
			System.out.println(studId+"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			try {
				// 业务逻辑
				HttpSession session = request.getSession();
				User user = (User) session.getAttribute("user");							
				Student student = new Student();
				List<Prize> prize = new ArrayList<Prize>();
				if(studId == 0){
					student = studentService.findStudentById(user.getUserId());	
				}else{
					student = studentService.findStudentByStudId(studId);
				}
							
				prize = prizService.findPrizInfoByStudId(student.getStudId());
				
				map.put("result", Boolean.TRUE);
				map.put("message", "success");
				map.put("prize", prize);
				map.put("student", student);
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
		@SuppressWarnings({ "unchecked", "finally", "rawtypes" })
		@RequestMapping("/findPrizInfo1")
		public ModelAndView findPrizInfo1(int p_id,HttpServletRequest request,
				HttpServletResponse response) {
			ModelAndView mav = new ModelAndView();
			MappingJacksonJsonView view = new MappingJacksonJsonView();
			Map map = new HashMap();
			try {
				// 业务逻辑
				Prize prize1 = new Prize();
				prize1= prizService.findPrizInfoByPrizId(p_id);
				
				map.put("result", Boolean.TRUE);
				map.put("message", "success");
				map.put("prize1", prize1);
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

