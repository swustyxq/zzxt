package swust.edu.cn.zzxt.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import swust.edu.cn.zzxt.model.Czylbx;
import swust.edu.cn.zzxt.model.Institution;
import swust.edu.cn.zzxt.model.Instructor;
import swust.edu.cn.zzxt.model.Major;
import swust.edu.cn.zzxt.model.PgsglWithBLOBs;
import swust.edu.cn.zzxt.model.Role;
import swust.edu.cn.zzxt.model.Student;
import swust.edu.cn.zzxt.model.Studentclass;
import swust.edu.cn.zzxt.model.Studentinfo;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.model.YlbzWithBLOBs;
import swust.edu.cn.zzxt.selfmodel.Ylbzbasicinfo;
import swust.edu.cn.zzxt.service.CzylbxService;
import swust.edu.cn.zzxt.service.InstitutionService;
import swust.edu.cn.zzxt.service.InstructorService;
import swust.edu.cn.zzxt.service.MajorService;
import swust.edu.cn.zzxt.service.PgsglService;
import swust.edu.cn.zzxt.service.RoleService;
import swust.edu.cn.zzxt.service.StudentService;
import swust.edu.cn.zzxt.service.StudentclassService;
import swust.edu.cn.zzxt.service.StudentinfoService;
import swust.edu.cn.zzxt.service.UserService;
import swust.edu.cn.zzxt.service.WorkstepfolwService;
import swust.edu.cn.zzxt.service.YlbzService;

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
@RequestMapping("/ylController")
public class YlController {
	private StudentService studentService;
	private StudentclassService studentclassService;
	private StudentinfoService studentinfoService;
	private InstitutionService institutionService;
	private InstructorService instructorService;
	private CzylbxService czylbxService;
	private PgsglService pgsglService;
	private YlbzService ylbzService;
	private RoleService roleService;
	private WorkstepfolwService workstepfolwService;
	private MajorService majorService;
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public MajorService getMajorService() {
		return majorService;
	}
	@Autowired
	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}
	public InstructorService getInstructorService() {
		return instructorService;
	}
	@Autowired
	public void setInstructorService(InstructorService instructorService) {
		this.instructorService = instructorService;
	}
	public WorkstepfolwService getWorkstepfolwService() {
		return workstepfolwService;
	}
	@Autowired
	public void setWorkstepfolwService(WorkstepfolwService workstepfolwService) {
		this.workstepfolwService = workstepfolwService;
	}
	public RoleService getRoleService() {
		return roleService;
	}
	@Autowired
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	public YlbzService getYlbzService() {
		return ylbzService;
	}
	@Autowired
	public void setYlbzService(YlbzService ylbzService) {
		this.ylbzService = ylbzService;
	}

	public PgsglService getPgsglService() {
		return pgsglService;
	}

	@Autowired
	public void setPgsglService(PgsglService pgsglService) {
		this.pgsglService = pgsglService;
	}

	public CzylbxService getCzylbxService() {
		return czylbxService;
	}

	@Autowired
	public void setCzylbxService(CzylbxService czylbxService) {
		this.czylbxService = czylbxService;
	}

	public InstitutionService getInstitutionService() {
		return institutionService;
	}

	@Autowired
	public void setInstitutionService(InstitutionService institutionService) {
		this.institutionService = institutionService;
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

	public StudentService getStudentService() {
		return studentService;
	}

	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	/*
	 * 获取学生本人的信息 Author chenwenhui,2014.07.15
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/showApplyYlTable")
	public ModelAndView showApplyYlTable(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		User user = null;
		Student student = new Student();
		try {
			// 业务逻辑:
			user = new User();
			HttpSession session = request.getSession();
			user = (User) session.getAttribute("user");
			student = studentService.findStudentById(user.getUserId());
			Institution institution = institutionService
						.findinstitutionByUserInstId(user.getUserInstid());
				Studentclass studentclass = new Studentclass();
				studentclass = studentclassService
						.obtainStudentClassByStudClassid(student
								.getStudClassid());
				Studentinfo studentinfo = studentinfoService
						.obtainStudentInfoByStudId(student.getStudId());
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-dd hh:mm:ss");
				String year = sdf.format(date).substring(0, 4);
				List<Czylbx> czylbx1 = czylbxService
						.findCzylbxsByYearAndStudentId(student.getStudId(),
								year);
				Czylbx czylbx=null;
				if(czylbx1.size()>0)
				{
					czylbx= czylbx1.get(0);
				}
				PgsglWithBLOBs pgsgl = pgsglService.findPkByStudId(student
						.getStudId());
				
				map.put("result", Boolean.TRUE);
				map.put("message", "用户查看此页面权限");
				map.put("user", user);
				map.put("student", student);
				map.put("institution", institution);
				map.put("studentclass", studentclass);
				map.put("studentinfo", studentinfo);
				map.put("year", year);
				map.put("czylbx", czylbx);
				map.put("pgsgl", pgsgl);
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
	 * 提交医疗补助信息 Author chenwenhui,2014.07.15
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/saveYlApplication")
	public ModelAndView saveYlApplication(String MainDiagnosis2,
			Double Inovice2, Double SSSum2, Double CISum2, String safeType,
			String applyType,String inTime,String outTime, String money,HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println(inTime+"===========================================");
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		User user = null;
		Student student = new Student();
		try {
			// 业务逻辑:
			user = new User();
			HttpSession session = request.getSession();
			user = (User) session.getAttribute("user");
			if (user.getUserType() == 1) {
				student = studentService.findStudentById(user.getUserId());
				Institution institution = institutionService
						.findinstitutionByUserInstId(user.getUserId());
				Studentclass studentclass = new Studentclass();
				studentclass = studentclassService
						.obtainStudentClassByStudClassid(student
								.getStudClassid());
				Studentinfo studentinfo = studentinfoService
						.obtainStudentInfoByStudId(student.getStudId());
				// List<Czylbx> czylbx =
				// czylbxService.findCzylbxsByStudentId(student.getStudId());
				
				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				Date date = sdf.parse(sdf.format(new Date()));
				
				String year = sdf.format(date).substring(0, 4);
				/*List<Czylbx> czylbx1 = czylbxService
						.findCzylbxsByYearAndStudentId(student.getStudId(),
								year);
				Czylbx czylbx = czylbx1.get(0);*/
				PgsglWithBLOBs pgsgl = pgsglService.findPkByStudId(student
						.getStudId());
				YlbzWithBLOBs ylbz = new YlbzWithBLOBs();
				ylbz.setYlbzApplytime(date);
				ylbz.setYlbzStudid(student.getStudId());
				ylbz.setYlbzIntime(inTime);
				ylbz.setYlbzOuttime(outTime);
				ylbz.setYlbzInovice(Inovice2);
				ylbz.setYlbzCisum(CISum2);
				ylbz.setYlbzSssum(SSSum2);
				ylbz.setYlbzDiagnosis(MainDiagnosis2);
				System.out.println(MainDiagnosis2);
				ylbz.setYlbzApplytype(applyType);
				ylbz.setYlbzSafetype(safeType);
				ylbz.setYlbzSpecial(0);
				ylbz.setYlbzWorkid(12);
				ylbz.setYlbzWsflid(1);
				ylbz.setYlbzState(0);
				ylbz.setYlbzMoney(money);
				ylbz.setYlbzAnnual(year+"~"+(Integer.parseInt(year)+1));
				ylbz = ylbzService.addOneRecord(ylbz);
				map.put("result", Boolean.TRUE);
				map.put("message", "用户查看此页面权限");
				map.put("user", user);
				map.put("student", student);
				map.put("institution", institution);
				map.put("studentclass", studentclass);
				map.put("studentinfo", studentinfo);
				map.put("year", year);
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
	 * 显示医疗补助列表 Author chenwenhui,2014.8.3
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/showApplyYlList")
	public ModelAndView showApplyYlList(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		User user = null;
		try {
			// 业务逻辑:
			user = new User();
			HttpSession session = request.getSession();
			user = (User) session.getAttribute("user");
			List<Ylbzbasicinfo> ylbzbasicinfo = null;
			ylbzbasicinfo = new ArrayList<Ylbzbasicinfo>();
			if(user.getUserType()==1)
			{
				Student student = studentService.findStudentByUserId(user.getUserId());
				ylbzbasicinfo = ylbzService.findYlbzBasicinfoBystudId(student.getStudId());
			}else
			{
				// 获取用户最大角色
				List<Role> role = roleService.findRolesByUser(user);
				int maxrole = 0;
				for (int i = 0; i < role.size(); i++) {
					if (role.get(i).getRoleLevel() > maxrole) {
						maxrole = role.get(i).getRoleLevel();
					}
				}
				if (maxrole == 3)
				{	maxrole = 2;
					for (int i = 0; i < role.size(); i++) {
						if (role.get(i).getRoleId() == 6) {
							maxrole = 3;
						}
					}
				}
				//获取该角色所应看到的学生信息
				if (maxrole == 2)// 仅仅是辅导员
				{
					Instructor instructor = instructorService.findInstructorByUserId(user.getUserId());
					List<Studentclass> studentclass = studentclassService.selectByInstId(instructor.getInstId());
					for(int i=0;i<studentclass.size();i++)
					{
						ylbzbasicinfo.addAll(ylbzService.findYlbzBasicinfoByclassId(studentclass.get(i).getClassId()));
					}
				} else if (maxrole < 6)//学办主任或分管委
				{
					ylbzbasicinfo = ylbzService.findYlbzBasicinfoByinstId(user.getUserInstid());
				} else {// 学生处或校医院
					ylbzbasicinfo = ylbzService.findAllYlbzBasicinfo();
				}
				map.put("maxrole",maxrole);
				//获取学生的贫困生信息
			}
			map.put("ylbzbasicinfo", ylbzbasicinfo);
			map.put("user",user);
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
	/*
	 * 通过学生医疗补助id获取当前信息 Author chenwenhui,2014.07.15
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/showApplyYlTable1")
	public ModelAndView showApplyYlTable1(int ylbzId,HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		User user = null;
		Student student = new Student();
		try {
			// 业务逻辑:
			user = new User();
			HttpSession session = request.getSession();
			User user1 = (User) session.getAttribute("user");
			YlbzWithBLOBs ylbz = ylbzService.findYlbzByid(ylbzId);
			student = studentService.findStudentByStudId(ylbz.getYlbzStudid());
			user = userService.findUserById(student.getStudUserid());
			Institution institution = institutionService
						.findinstitutionByUserInstId(user.getUserInstid());
			Studentclass studentclass = new Studentclass();
			studentclass = studentclassService
					.obtainStudentClassByStudClassid(student
							.getStudClassid());
			Studentinfo studentinfo = studentinfoService
					.obtainStudentInfoByStudId(student.getStudId());
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat(
					"yyyy-MM-dd hh:mm:ss");
			String year = sdf.format(date).substring(0, 4);
			List<Czylbx> czylbx1 = czylbxService
					.findCzylbxsByYearAndStudentId(student.getStudId(),
							year);
			Czylbx czylbx=null;
			if(czylbx1.size()>0)
			{
				czylbx= czylbx1.get(0);
			}
			PgsglWithBLOBs pgsgl = pgsglService.findPkByStudId(student
					.getStudId());
			map.put("result", Boolean.TRUE);
			map.put("message", "用户查看此页面权限");
			map.put("user1", user1);
			map.put("student", student);
			map.put("institution", institution);
			map.put("studentclass", studentclass);
			map.put("studentinfo", studentinfo);
			map.put("ylbz", ylbz);
			map.put("year", year);
			map.put("czylbx", czylbx);
			map.put("pgsgl", pgsgl);
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
	/*
	 * Author chenwenhui,2014.07.25 按学院查询专业
	 */
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
					if(12==role.get(i).getRoleId())
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
	/*
	 * Author chenwenhui,2014.07.25 按专业查询班级
	 */
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
					if(12==role.get(i).getRoleId())
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
	/*
	 * Author chenwenhui,2014.07.25 按查询条件显示贫困生列表
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/showYlList")
	public ModelAndView showYlList(int colleageId,int majorId,int classId,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			User user = new User();
			HttpSession session = request.getSession();
			user = (User) session.getAttribute("user");
			List<Ylbzbasicinfo> list = new ArrayList<Ylbzbasicinfo>();
			int maxrole = user.getUserType();
			List<Role> role = (List<Role>) session.getAttribute("role");
			if(maxrole==3)
			{
				for(int i=0;i<role.size();i++)
				{
					if(12==role.get(i).getRoleId())
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
						list = ylbzService.findYlbzBasicinfoByclassId(classId);
					}else
					{
						list = ylbzService.findYlbzBasicinfoBymajrId(majorId);
						System.out.println("((((("+majorId+list.size());
					}
				}else
				{
					list = ylbzService.findYlbzBasicinfoByinstId(colleageId);
				}
			}else
			{
				list = ylbzService.findAllYlbzBasicinfo();
			}
			List<Ylbzbasicinfo> ylbzbasicinfo = new ArrayList<Ylbzbasicinfo>();
			ylbzbasicinfo.addAll(list);
			map.put("ylbzbasicinfo", ylbzbasicinfo);
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
	 * 审核医疗补助信息 Author chenwenhui,2014.07.15
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/saveYlApplication1")
	public ModelAndView saveYlApplication1(Double line,int ylbzId,String MainDiagnosis2,
			Double Inovice2, Double SSSum2, Double CISum2, String safeType,
			String inTime,String outTime, String money,HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		User user = null;
		try {
			// 业务逻辑:
				YlbzWithBLOBs ylbz = new YlbzWithBLOBs();
				ylbz = ylbzService.findYlbzByid(ylbzId);
				ylbz.setYlbzIntime(inTime);
				ylbz.setYlbzOuttime(outTime);
				ylbz.setYlbzInovice(Inovice2);
				ylbz.setYlbzCisum(CISum2);
				ylbz.setYlbzSssum(SSSum2);
				ylbz.setYlbzDiagnosis(MainDiagnosis2);
				ylbz.setYlbzSafetype(safeType);
				ylbz.setYlbzState(1);
				ylbz.setYlbzMoney(money);
				ylbz.setYlbzLine(line);
				ylbz = ylbzService.update(ylbz);
				map.put("result", Boolean.TRUE);
				map.put("message", "用户查看此页面权限");
				map.put("user", user);
				map.put("ylbz", ylbz);
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
