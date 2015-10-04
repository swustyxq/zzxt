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
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import swust.edu.cn.zzxt.model.Institution;
import swust.edu.cn.zzxt.model.Instructor;
import swust.edu.cn.zzxt.model.Major;
import swust.edu.cn.zzxt.model.PgsglWithBLOBs;
import swust.edu.cn.zzxt.model.Role;
import swust.edu.cn.zzxt.model.Student;
import swust.edu.cn.zzxt.model.Studentclass;
import swust.edu.cn.zzxt.model.Studentinfo;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.model.Work;
import swust.edu.cn.zzxt.model.Workstepfolw;
import swust.edu.cn.zzxt.selfmodel.Pksglbasicinfo;
import swust.edu.cn.zzxt.selfmodel.Pksgltongjiinfo;
import swust.edu.cn.zzxt.service.GjlzjxjWithBLOBsService;
import swust.edu.cn.zzxt.service.InstitutionService;
import swust.edu.cn.zzxt.service.InstructorService;
import swust.edu.cn.zzxt.service.LearningService;
import swust.edu.cn.zzxt.service.MajorService;
import swust.edu.cn.zzxt.service.PgsglService;
import swust.edu.cn.zzxt.service.RoleService;
import swust.edu.cn.zzxt.service.StudentService;
import swust.edu.cn.zzxt.service.StudentclassService;
import swust.edu.cn.zzxt.service.StudentinfoService;
import swust.edu.cn.zzxt.service.UserService;
import swust.edu.cn.zzxt.service.WorkService;
import swust.edu.cn.zzxt.service.WorkstepfolwService;

/**
 * @author chenwenhui
 * @Title:
 * @ClassName：PkController.java
 * @Package: swust.edu.cn.zzxt.controller
 * @Description: TODO
 * @createDate:2013 下午10:53:15
 * @reviseNote:
 * @version:
 */
@Controller
@RequestMapping("/pkController")
public class PkController {
	private UserService userService;
	private StudentService studentService;
	private StudentinfoService studentinfoService;
	private StudentclassService studentclassService;
	private MajorService majorService;
	private GjlzjxjWithBLOBsService gjlzjxjwithblobsService;
	private LearningService learningService;
	private InstructorService instructorService;
	private PgsglService pgsglService;
	private RoleService roleService;
	private WorkstepfolwService workstepfolwService;
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

	public RoleService getRoleService() {
		return roleService;
	}

	@Autowired
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public WorkstepfolwService getWorkstepfolwService() {
		return workstepfolwService;
	}

	@Autowired
	public void setWorkstepfolwService(WorkstepfolwService workstepfolwService) {
		this.workstepfolwService = workstepfolwService;
	}

	public PgsglService getPgsglService() {
		return pgsglService;
	}

	@Autowired
	public void setPgsglService(PgsglService pgsglService) {
		this.pgsglService = pgsglService;
	}

	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public InstructorService getInstructorService() {
		return instructorService;
	}

	@Autowired
	public void setInstructorService(InstructorService instructorService) {
		this.instructorService = instructorService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public StudentinfoService getStudentinfoService() {
		return studentinfoService;
	}

	@Autowired
	public void setStudentinfoService(StudentinfoService studentinfoService) {
		this.studentinfoService = studentinfoService;
	}

	public StudentclassService getStudentclassService() {
		return studentclassService;
	}

	@Autowired
	public void setStudentclassService(StudentclassService studentclassService) {
		this.studentclassService = studentclassService;
	}

	public MajorService getMajorService() {
		return majorService;
	}

	@Autowired
	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}

	public GjlzjxjWithBLOBsService getGjlzjxjwithblobsService() {
		return gjlzjxjwithblobsService;
	}

	@Autowired
	public void setGjlzjxjwithblobsService(
			GjlzjxjWithBLOBsService gjlzjxjwithblobsService) {
		this.gjlzjxjwithblobsService = gjlzjxjwithblobsService;
	}

	public LearningService getLearningService() {
		return learningService;
	}

	@Autowired
	public void setLearningService(LearningService learningService) {
		this.learningService = learningService;
	}

	/*
	 * 获取一个学生信息 Author chenwenhui,2014.07.15
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/showApplyPkTable")
	public ModelAndView showApplyPkTable(int studId, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		User user = null;
		Student student = new Student();
		try {
			// 业务逻辑:贫困生入库申请表显示
			user = new User();
			HttpSession session = request.getSession();
			user = (User) session.getAttribute("user");
			map.put("user", user);
			// 根据角色不同查询学生信息
			if (studId == 0) {
				System.out.println("######" + user.getUserId());
				student = studentService.findStudentById(user.getUserId());
			} else {
				student = studentService.findStudentByStudId(studId);
			}
			Studentinfo studentinfo = studentinfoService
					.selectBystudInfoStudId(student.getStudId());
			Studentclass studentclass = new Studentclass();
			studentclass = studentclassService.selectBystudInfoStudId(student
					.getStudClassid());
			Instructor instructor = new Instructor();
			instructor = instructorService
					.findInstructorByPrimaryKey(studentclass.getClassInstid());
			User instUser = new User();
			instUser = userService.findUserById(instructor.getInstUserid());
			PgsglWithBLOBs pgsgl1 = pgsglService.findPkByStudId(student
					.getStudId());
			List<Major> major = majorService.selectByMajorId(studentclass
					.getClassMajrid());
			System.out.println(major.get(0).getMajrName());
			Institution institution = institutionService
					.findinstitutionByUserInstId(major.get(0).getMajrInstid());
			System.out.println(institution.getInstName());
			int exist;
			if (pgsgl1 == null) {
				exist = 0;
			} else {
				// 如果已经填写了贫困生信息
				exist = 1;
				Workstepfolw workstepfolw1 = workstepfolwService
						.findWslfByWslfId(pgsgl1.getPksgWsflid());
				map.put("workstepfolw1", workstepfolw1);
				List<Role> role = new ArrayList<Role>();
				role = roleService.findRolesByUser(user);
				// 返回最大角色id
				int maxrole = 0;
				for (int i = 0; i < role.size(); i++) {
					if (role.get(i).getRoleLevel() > maxrole) {
						maxrole = role.get(i).getRoleLevel();
					}
				}
				if (maxrole == 3) {
					maxrole = 2;
					for (int i = 0; i < role.size(); i++) {
						if (role.get(i).getRoleId() == 6) {
							maxrole = 3;
						}
					}
				}
				if (maxrole == 2) {
					map.put("maxrole", 2);
				} else if (maxrole == 3) {
					map.put("maxrole", 6);
				} else if (maxrole == 4) {
					map.put("maxrole", 13);
				} else if (maxrole == 5) {
					map.put("maxrole", 14);
				} else if (maxrole == 6) {
					map.put("maxrole", 20);
				}else{
					map.put("maxrole", 0);
				}
			}
			Work work = workService.selectByWorkId(6);
			map.put("work", work);
			map.put("exist", exist);
			map.put("result", Boolean.TRUE);
			map.put("message", "success");
			map.put("student", student);
			map.put("studentinfo", studentinfo);
			map.put("studentclass", studentclass);
			map.put("instructor", instructor);
			map.put("instUser", instUser);
			map.put("pgsgl1", pgsgl1);
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

	/*
	 * 提交贫困生申请 Author chenwenhui,2014.07.15
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/saveApplyPkTable")
	public ModelAndView saveApplyPkTable(int isDisable, String applyreason,
			int isSure, double allIncomePerYear, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		User user = null;
		Student student = new Student();
		try {
			// 业务逻辑:贫困生入库申请保存与提交
			user = new User();
			HttpSession session = request.getSession();
			user = (User) session.getAttribute("user");

			if (user.getUserType() == 1) {
				List<Role> role = (List<Role>) session.getAttribute("role");
				int situation = 1;
				for (int i = 0; i < role.size(); i++) {
					if (role.get(i).getRoleId() == 6) {
						situation = 2;
					}
					if (role.get(i).getRoleId() == 13) {
						situation = 3;
						break;
					}
				}
				int workId = 6;
				Workstepfolw workstepfolw = workstepfolwService
						.getWsflIdByWorkidAndSituation(workId, situation);
				student = studentService.findStudentById(user.getUserId());
				Studentinfo studentinfo = studentinfoService
						.selectBystudInfoStudId(student.getStudId());
				PgsglWithBLOBs pgsgl = new PgsglWithBLOBs();
				pgsgl.setPksgStudid(student.getStudId());
				pgsgl.setPksgIsdisable(isDisable);
				pgsgl.setPksgApplyreason(applyreason);
				Date date = new Date();
				date.setTime(System.currentTimeMillis());
				pgsgl.setPksgApplytime(date);
				pgsgl.setPksgPoliticstate(studentinfo.getStinPoliticstate());
				pgsgl.setPksgAllincomeperyear(allIncomePerYear);
				pgsgl.setPksgHome(studentinfo.getStinAreadeatilhome());
				pgsgl.setPksgMailcode(studentinfo.getStinMailcode());
				pgsgl.setPksgState(0);
				pgsgl.setPksgWorkid(6);
				if (isSure == 0)// 如果点击的是保存，则工作流为第一步，如果点击提交工作流为第二步
				{
					pgsgl.setPksgWsflid(workstepfolw.getWsflCurrentstep());
				} else {
					pgsgl.setPksgWsflid(workstepfolw.getWsflNextstep());
				}
				pgsgl.setPksgIsdeleted(0);
				PgsglWithBLOBs pgsgl1 = pgsglService.findPkByStudId(student
						.getStudId());
				if (pgsgl1 == null) {
					pgsglService.addOneRecord(pgsgl);
				} else {
					pgsgl.setPksgId(pgsgl1.getPksgId());
					pgsgl = pgsglService.update(pgsgl);
				}
				System.out.println("fffff");
				map.put("result", Boolean.TRUE);
				map.put("message", "success");
				map.put("role", role);
				map.put("pgsgl", pgsgl);
			} else {
				map.put("result", Boolean.TRUE);
				map.put("message", "用户查看此页面权限");
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

	/*
	 * Author chenwenhui,2014.07.16 显示当前用户（如辅导员）所应看到的学生贫困生申请列表
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/showALLPkStu")
	public ModelAndView showALLPkStu(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			User user = new User();
			HttpSession session = request.getSession();
			user = (User) session.getAttribute("user");
			List<Pksglbasicinfo> pksglbasicinfo = new ArrayList<Pksglbasicinfo>();
			if (user.getUserType() == 1) {
				Student student = studentService.findStudentById(user
						.getUserId());
				Pksglbasicinfo pksglbasicinfo1 = pgsglService
						.findPksgbasiinfoByStudentId(student.getStudId());
				if (pksglbasicinfo1 != null) {
					pksglbasicinfo.add(pksglbasicinfo1);
				}
			} else {
				// 获取用户最大角色
				List<Role> role = roleService.findRolesByUser(user);
				int maxrole = 0;
				for (int i = 0; i < role.size(); i++) {
					if (role.get(i).getRoleLevel() > maxrole) {
						maxrole = role.get(i).getRoleLevel();
					}
				}
				if (maxrole == 3) {
					maxrole = 2;
					for (int i = 0; i < role.size(); i++) {
						if (role.get(i).getRoleId() == 6) {
							maxrole = 3;
						}
					}
				}
				// 获取该角色所应看到的学生信息
				if (maxrole == 2)// 仅仅是辅导员
				{
					Instructor instructor = instructorService
							.findInstructorByUserId(user.getUserId());
					List<Studentclass> list = studentclassService
							.selectByInstId(instructor.getInstId());
					for (int i = 0; i < list.size(); i++) {
						pksglbasicinfo.addAll(pgsglService
								.findPksgbasiinfoByClassId(list.get(i)
										.getClassId()));
					}
				} else if (maxrole < 6)// 经办老师或学办主任或分管委
				{
					pksglbasicinfo.addAll(pgsglService
							.findPksgbasiinfoByInstId(user.getUserInstid()));
				} else {// 学生处
					pksglbasicinfo.addAll(pgsglService.findAllPksgbasiinfo());
				}
				if (maxrole == 2) {
					map.put("maxrole", 2);
				} else if (maxrole == 3) {
					map.put("maxrole", 6);
				} else if (maxrole == 4) {
					map.put("maxrole", 13);
				} else if (maxrole == 5) {
					map.put("maxrole", 14);
				} else if (maxrole == 6) {
					map.put("maxrole", 20);
				}
			}

			System.out.println("eee");
			map.put("result", Boolean.TRUE);
			map.put("message", "success");
			map.put("user", user);
			map.put("pksglbasicinfo", pksglbasicinfo);
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
	 * Author chenwenhui,2014.07.25 辅导员及以上角色向上提交
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/instExaminePksglApplication")
	public ModelAndView instExaminePksglApplication(int studId,
			String applyreason, int isSure, String reason, String pkLevel,
			double allIncomePerYear, String academyopinion,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			User user = new User();
			HttpSession session = request.getSession();
			user = (User) session.getAttribute("user");
			PgsglWithBLOBs pgsgl = new PgsglWithBLOBs();
			pgsgl = pgsglService.findPkByStudId(studId);
			pgsgl.setPksgApplyreason(applyreason);
			pgsgl.setPksgCommunityopinion(reason);
			pgsgl.setPksgAllincomeperyear(allIncomePerYear);
			Date date = new Date();
			if (user.getUserType() == 2) {
				pgsgl.setPksgCommunityopiniontime(date);
			}
			pgsgl.setPksgRecommendgrade(pkLevel);
			pgsgl.setPksgAcademyopinion(academyopinion);
			if (user.getUserType() == 3) {
				pgsgl.setPksgAcademyopiniontime(date);
			}
			System.out.println(academyopinion);
			if (isSure == 0) {
				pgsgl = pgsglService.update(pgsgl);
			} else if (isSure == 1) {

				if (workstepfolwService.findWslfByWslfId(pgsgl.getPksgWsflid())
						.getWsflNextstep() == -1) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
					String date2 = sdf.format(new Date());
					pgsgl.setPksgAdmittime(date2);
					pgsgl.setPksgRank(pgsgl.getPksgAcademyopinion());
				}
				pgsgl.setPksgWsflid(workstepfolwService.findWslfByWslfId(
						pgsgl.getPksgWsflid()).getWsflNextstep());
				pgsgl = pgsglService.update(pgsgl);
			} else if (isSure == -1) {
				pgsgl.setPksgWsflid(workstepfolwService.findWslfByWslfId(
						pgsgl.getPksgWsflid()).getWsflPrestep());
				pgsgl = pgsglService.update(pgsgl);
			}
			map.put("result", Boolean.TRUE);
			map.put("message", "success");
			map.put("pgsgl", pgsgl);
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

	/*
	 * Author chenwenhui,2014.07.25 查询所有学院
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
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
			if (user.getUserType() >= 6) {
				institution = institutionService.findAllInstitutions();
			} else {
				//System.out.println("hhh" + user.getUserInstid());
				Institution inst = institutionService
						.findinstitutionByMajorInstId(user.getUserInstid());
				//System.out.println("hhh" + inst.getInstName());
				institution.add(inst);
			}
			System.out.println("hhh" + user.getUserInstid());
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

	/*
	 * Author chenwenhui,2014.07.25 按学院查询专业
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/showMajor")
	public ModelAndView showMajor(int instId, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			User user = new User();
			HttpSession session = request.getSession();
			user = (User) session.getAttribute("user");
			List<Major> major = new ArrayList<Major>();
			if (user.getUserType() == 3) {
				List<Role> role = (List<Role>) session.getAttribute("role");
				int state = 0;
				for (int i = 0; i < role.size(); i++) {
					if (6 == role.get(i).getRoleId()) {
						state = 1;
					}
				}
				if (state == 0) {
					user.setUserType(2);
				}
			}
			if (user.getUserType() >= 6) {
				major = majorService.selectByInstId(instId);
			} else if (user.getUserType() > 2) {
				System.out.println("hhh" + user.getUserInstid());
				major = majorService.selectByInstId(user.getUserInstid());
			} else if (user.getUserType() == 2) {
				Instructor instructor = instructorService
						.findInstructorByUserId(user.getUserId());
				List<Studentclass> studentclass = studentclassService
						.selectByInstId(instructor.getInstId());
				List<Major> list = new ArrayList<Major>();
				for (int i = 0; i < studentclass.size(); i++) {
					list.add(majorService.selectByPrimaryKey(studentclass
							.get(i).getClassMajrid()));
				}
				// 去重
				for (int i = 0; i < list.size(); i++) {
					boolean flag = true;
					for (int j = 0; j < major.size(); j++) {
						if (list.get(i).getMajrId() == major.get(j).getMajrId()) {
							flag = false;
							break;
						}
					}
					if (flag == true) {
						major.add(list.get(i));
					}
				}
			} else {
				Student student = studentService.selectInfoByUser(user
						.getUserId());

				Studentclass studentclass = studentclassService
						.selectBystudInfoStudId(student.getStudClassid());
				Major major1 = new Major();
				System.out.println("hhh" + studentclass.getClassName());
				major1 = majorService.obtainMajorByClassMajrid(studentclass
						.getClassMajrid());
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

	/*
	 * Author chenwenhui,2014.07.25 按专业查询班级
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/showClass")
	public ModelAndView showClass(int majorId, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			User user = new User();
			HttpSession session = request.getSession();
			user = (User) session.getAttribute("user");
			List<Studentclass> studentclass = new ArrayList<Studentclass>();
			if (user.getUserType() == 3) {
				List<Role> role = (List<Role>) session.getAttribute("role");
				int state = 0;
				for (int i = 0; i < role.size(); i++) {
					if (6 == role.get(i).getRoleId()) {
						state = 1;
					}
				}
				if (state == 0) {
					user.setUserType(2);
				}
			}
			if (user.getUserType() >= 3) {
				studentclass = studentclassService.selectByMajorId(majorId);
			} else if (user.getUserType() == 2) {
				Instructor instructor = instructorService
						.findInstructorByUserId(user.getUserId());
				List<Studentclass> list = studentclassService
						.selectByInstId(instructor.getInstId());
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getClassMajrid() == majorId) {
						studentclass.add(list.get(i));
					}
				}
			} else {
				Student student = studentService.selectInfoByUser(user
						.getUserId());
				System.out.println("hhh" + student.getStudName());
				Studentclass studentclass1 = studentclassService
						.selectBystudInfoStudId(student.getStudClassid());
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

	/*
	 * Author chenwenhui,2014.07.25 按查询条件显示贫困生列表
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/showPkStud")
	public ModelAndView showPkStud(int colleageId, int majorId, int classId,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			User user = new User();
			HttpSession session = request.getSession();
			user = (User) session.getAttribute("user");
			List<Pksglbasicinfo> list = new ArrayList<Pksglbasicinfo>();
			int maxrole = user.getUserType();
			List<Role> role = (List<Role>) session.getAttribute("role");
			if (maxrole == 3) {
				int a=0;
				for (int i = 0; i < role.size(); i++) {
					if (6 == role.get(i).getRoleId()) {
						a=1;
					}
				}if(a!=1)
				{
					maxrole=2;
				}
			}
			if (maxrole == 2) {
				map.put("maxrole", 2);
			} else if (maxrole == 3) {
				map.put("maxrole", 6);
			} else if (maxrole == 4) {
				map.put("maxrole", 13);
			} else if (maxrole == 5) {
				map.put("maxrole", 14);
			} else if (maxrole == 6) {
				map.put("maxrole", 20);
			}
			if (colleageId != 0) {
				if (majorId != 0) {
					if (classId != 0) {
						list = pgsglService.findPksgbasiinfoByClassId(classId);
					} else {
						//对辅导员特殊处理
						if(maxrole!=2)
						{
						list = pgsglService.findPksgbasiinfoByMajrId(majorId);
						System.out.println("(((((" + majorId + list.size());
						}else{
							List<Pksglbasicinfo> pksglbasicinfo = new ArrayList<Pksglbasicinfo>();
							Instructor instructor = instructorService
									.findInstructorByUserId(user.getUserId());
							List<Studentclass> list1 = studentclassService
									.selectByInstId(instructor.getInstId());
							for(int i=0;i<list1.size();i++)
							{
								if(list1.get(i).getClassMajrid()==majorId)
								{
									pksglbasicinfo = pgsglService.findPksgbasiinfoByClassId(list1.get(i).getClassId());
									list.addAll(pksglbasicinfo);
								}
							}
						}
					}
				} else {
					if(maxrole!=2)
					{
					list = pgsglService.findPksgbasiinfoByInstId(colleageId);
					System.out.println(colleageId+"jjjjjjj");
					}else{
					List<Pksglbasicinfo> pksglbasicinfo = new ArrayList<Pksglbasicinfo>();
					Instructor instructor = instructorService
							.findInstructorByUserId(user.getUserId());
					List<Studentclass> list1 = studentclassService
							.selectByInstId(instructor.getInstId());
					for(int i=0;i<list1.size();i++)
					{
						pksglbasicinfo = pgsglService.findPksgbasiinfoByClassId(list1.get(i).getClassId());
						list.addAll(pksglbasicinfo);
					}
					}
				}
			} else {
				list = pgsglService.findAllPksgbasiinfo();
			}
			List<Pksglbasicinfo> pksglbasicinfo = new ArrayList<Pksglbasicinfo>();
			pksglbasicinfo.addAll(list);
			if(user.getUserType()==1){
				Student student = studentService.findStudentByUserId(user.getUserId());
				Pksglbasicinfo pksglbasicinfo1 = pgsglService.findPksgbasiinfoByStudentId(student.getStudId());
				pksglbasicinfo.clear();
				pksglbasicinfo.add(pksglbasicinfo1);
			}
			map.put("pksglbasicinfo", pksglbasicinfo);
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

	/*
	 * Author chenwenhui,2014.8.10查询统计信息
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/showTongjiinfo")
	public ModelAndView showTongjiinfo(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			User user = new User();
			HttpSession session = request.getSession();
			user = (User) session.getAttribute("user");
			List<Pksgltongjiinfo> tongjiinfo = new ArrayList<Pksgltongjiinfo>();
			List<Pksgltongjiinfo> tongjiinfo1 = new ArrayList<Pksgltongjiinfo>();
			if(user.getUserType()==6)
			{
				tongjiinfo = pgsglService.findAlltongjiinfo();
			}else{
				tongjiinfo = pgsglService.findAlltongjiinfoByinstId(user.getUserInstid());
				tongjiinfo1 = pgsglService.findAllmajrtongjiinfoByinstId(user.getUserInstid());
				map.put("tongjiinfo1", tongjiinfo1);
			}
			map.put("tongjiinfo", tongjiinfo);
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
	@SuppressWarnings({"rawtypes", "finally", "unchecked"})
	@RequestMapping("/export")
	public ModelAndView export(HttpServletRequest request,HttpServletResponse response){
	        ModelAndView mav = new ModelAndView();
	        MappingJacksonJsonView view = new MappingJacksonJsonView();
	        Map map = new HashMap();
	        try {
	        	List<Pksglbasicinfo> list = new ArrayList<Pksglbasicinfo>();
	        	
	        	User user = new User();
				HttpSession session = request.getSession();
				user = (User) session.getAttribute("user");
	        	List<Role> role = new ArrayList<Role>();
				role = roleService.findRolesByUser(user);
	        	int maxrole = 0;
				for (int i = 0; i < role.size(); i++) {
					if (role.get(i).getRoleLevel() > maxrole) {
						maxrole = role.get(i).getRoleLevel();
					}
				}
				if (maxrole == 3) {
					maxrole = 2;
					for (int i = 0; i < role.size(); i++) {
						if (role.get(i).getRoleId() == 6) {
							maxrole = 3;
						}
					}
				}
				if(maxrole==2){
					Instructor instructor= instructorService.findInstructorByUserId(user.getUserId());
					List<Studentclass> studentclass=studentclassService.selectByInstId(instructor.getInstId());
					for(int i=0;i<studentclass.size();i++)
					{
						list.addAll(pgsglService.findPksgbasiinfoByClassId(studentclass.get(i).getClassId()));
					}
				}else if(maxrole>=6){
					list = pgsglService.findAllPksgbasiinfo();
				}else{
					list = pgsglService.findPksgbasiinfoByInstId(user.getUserInstid());
				}
				 WritableWorkbook book = null;
			        try {
			            
			            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
			            String date = sdf.format(System.currentTimeMillis());
			            session.setAttribute("DownLoadDate", date);
			        	String filePath = request.getSession().getServletContext()
								.getRealPath("upload/listPk"+date+".xls");
			        	OutputStream os = new FileOutputStream(filePath);
			            // 打开文件
			            book = Workbook.createWorkbook(os);
			            // 生成名为"学生"的工作表，参数0表示这是第一页
			            WritableSheet sheet = book.createSheet("学生", 0);
			            
			            WritableFont wfont = new WritableFont(WritableFont.ARIAL, 11, 
			            		WritableFont.BOLD, false, 
			            		jxl.format.UnderlineStyle.NO_UNDERLINE, 
			            		jxl.format.Colour.BLACK); 
			            		WritableCellFormat titleFormat = new WritableCellFormat(wfont); 
			            		//设置内容日期格式
			            String[] title = { "姓名", "学号", "学院", "专业","班级","申请时间","贫困等级","政治面貌"}; 
			            for (int i = 0; i < title.length; i++) { 
			            	Label excelTitle = new Label(i, 0, title[i],titleFormat); 
			            	sheet.addCell(excelTitle); 
			            	} 
			            if(list!=null && !list.isEmpty()){
			                for(int i=0; i<list.size(); i++){
			                    sheet.addCell(new Label(0, i+1, list.get(i).getStudentName()));
			                	sheet.addCell(new Label(1, i+1, list.get(i).getStudentNumber()));
			                    sheet.addCell(new Label(2, i+1, list.get(i).getInstName()));
			                    sheet.addCell(new Label(3, i+1, list.get(i).getMajrName()));
			                    sheet.addCell(new Label(4, i+1, list.get(i).getClassName()));
			                    sheet.addCell(new Label(5, i+1, list.get(i).getApplyTime().toString()));
			                    sheet.addCell(new Label(6, i+1, list.get(i).getPksgRank()));
			                    sheet.addCell(new Label(7, i+1, list.get(i).getPoliticState()));
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
			    map.put("list", list);
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
	 * 下载检索的学生信息
	 * 
	 * @param id
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void downloadFile(Integer id,HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		try {
		    
		    HttpSession session = request.getSession();
            String date = (String)session.getAttribute("DownLoadDate");
			String path = request.getSession().getServletContext()
					.getRealPath("upload/listPk"+date+".xls");
			System.out.println(path);
			File file = new File(path);
			// 取得文件名。
			String filename = file.getName();
			// 取得文件的后缀名。
			String ext = filename.substring(filename.lastIndexOf(".") + 1)
					.toUpperCase();

			// 以流的形式下载文件。
			InputStream fis = new BufferedInputStream(new FileInputStream(path));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			// 清空response
			// response.reset();
			// 设置response的Header
			response.addHeader("Content-Disposition", "attachment;filename="
					+ new String(filename.getBytes()));
			response.addHeader("Content-Length", "" + file.length());
			OutputStream toClient = new BufferedOutputStream(
					response.getOutputStream());
			response.setContentType("application/octet-stream");
			toClient.write(buffer);
			toClient.flush();
			toClient.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}