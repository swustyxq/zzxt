package swust.edu.cn.zzxt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import sun.applet.resources.MsgAppletViewer;
import swust.edu.cn.zzxt.model.Institution;
import swust.edu.cn.zzxt.model.Instructor;
import swust.edu.cn.zzxt.model.Major;
import swust.edu.cn.zzxt.model.Parent;
import swust.edu.cn.zzxt.model.Reuserrole;
import swust.edu.cn.zzxt.model.Role;
import swust.edu.cn.zzxt.model.Student;
import swust.edu.cn.zzxt.model.Studentclass;
import swust.edu.cn.zzxt.model.Studentinfo;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.selfmodel.CommonUserModel;
import swust.edu.cn.zzxt.selfmodel.NavigationModel;
import swust.edu.cn.zzxt.selfmodel.Studentbasiinfo;
import swust.edu.cn.zzxt.service.FunctionService;
import swust.edu.cn.zzxt.service.InstitutionService;
import swust.edu.cn.zzxt.service.InstructorService;
import swust.edu.cn.zzxt.service.MajorService;
import swust.edu.cn.zzxt.service.ParentService;
import swust.edu.cn.zzxt.service.ReuserroleService;
import swust.edu.cn.zzxt.service.RoleService;
import swust.edu.cn.zzxt.service.StudentService;
import swust.edu.cn.zzxt.service.StudentbasiinfoService;
import swust.edu.cn.zzxt.service.StudentclassService;
import swust.edu.cn.zzxt.service.StudentinfoService;
import swust.edu.cn.zzxt.service.UserService;

@Controller
@RequestMapping("/userController")
public class UserController {
	private UserService userService;
	private RoleService roleService;
	private StudentService studentService;
	private StudentclassService studentclassService;
	private InstructorService instructorService;
	private StudentbasiinfoService studentbasiinfoService;
	private ParentService parentService;
	private StudentinfoService studentinfoService;
	
	public StudentinfoService getStudentinfoService() {
        return studentinfoService;
    }
	@Autowired
    public void setStudentinfoService(StudentinfoService studentinfoService) {
        this.studentinfoService = studentinfoService;
    }
    public ParentService getParentService() {
        return parentService;
    }
	@Autowired
    public void setParentService(ParentService parentService) {
        this.parentService = parentService;
    }
    public StudentbasiinfoService getStudentbasiinfoService() {
		return studentbasiinfoService;
	}
	@Autowired
	public void setStudentbasiinfoService(
			StudentbasiinfoService studentbasiinfoService) {
		this.studentbasiinfoService = studentbasiinfoService;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public StudentclassService getStudentclassService() {
		return studentclassService;
	}
	@Autowired
	public void setStudentclassService(StudentclassService studentclassService) {
		this.studentclassService = studentclassService;
	}
	public InstructorService getInstructorService() {
		return instructorService;
	}
	@Autowired
	public void setInstructorService(InstructorService instructorService) {
		this.instructorService = instructorService;
	}
	public RoleService getRoleService() {
		return roleService;
	}
	@Autowired
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	private List<User> allUserList;
	public List<User> getAllUserList() {
        return allUserList;
    }
	private FunctionService functionService;
	
	public FunctionService getFunctionService() {
		return functionService;
	}
	public void setAllUserList(List<User> allUserList) {
        this.allUserList = allUserList;
    }
	@Autowired
	public void setFunctionService(FunctionService functionService) {
		this.functionService = functionService;
	}

	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private ReuserroleService reuserroleService;

	public ReuserroleService getReuserroleService() {
        return reuserroleService;
    }
	@Autowired
    public void setReuserroleService(ReuserroleService reuserroleService) {
        this.reuserroleService = reuserroleService;
    }
	private MajorService majorService;
	
    public MajorService getMajorService() {
        return majorService;
    }
    @Autowired
    public void setMajorService(MajorService majorService) {
        this.majorService = majorService;
    }
    
    private InstitutionService institutionService;
    public InstitutionService getInstitutionService() {
        return institutionService;
    }
    @Autowired
    public void setInstitutionService(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/showUser")
	public ModelAndView showUser(int id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			//业务逻辑
			User user = userService.findUserById(id);
			map.put("result", Boolean.TRUE);
			map.put("message", "success");
			map.put("user", user);
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
    
    /*author:yangjunhui func:确定查询条件*/
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/showOneUserMsg")
    public ModelAndView showOneUserMsg(HttpServletRequest request,HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            //业务逻辑
            HttpSession session = request.getSession();//获取session
            User user = (User)session.getAttribute("user");
            String msg = "loginout";
            if (user != null){
                msg = "success";
                map.put("user", user);
                int userId = user.getUserId();
                if (user.getUserType() != 1){
                    if (user.getUserType() == 2){
                        Instructor instructor = instructorService.findInstructorByUserId(userId);
                        System.out.println(instructor.getInstId()+"你妹");
                        List<Studentclass> studentclasses = 
                                studentclassService.selectByInstId(instructor.getInstId());
                        List<Major> majors = new ArrayList<Major>();
                        for (int i = 0;i < studentclasses.size();i++){
                            Boolean flag = false;//判定专业List中是否已经有这个专业id
                            int MajorId = studentclasses.get(i).getClassMajrid();
                            for (int j = 0;j < majors.size();j++){
                               if (MajorId == majors.get(j).getMajrId()){
                                   flag = true;
                               }
                            }
                            if (!flag){
                                Major major = new Major();
                                major = majorService.selectByMajorId(MajorId).get(0);
                                majors.add(major);
                            }
                        }
                        map.put("studentclasses", studentclasses);
                        map.put("majors", majors);
                    }//userType == 2判定结束
                }else{//得到学生的专业，班级
                    Student student = studentService.findStudentById(user.getUserId());
                    Studentclass oneClass = 
                            studentclassService.selectBystudInfoStudId(student.getStudClassid());
                    Major oneMajor = majorService.selectByMajorId(oneClass.getClassMajrid()).get(0);
                    map.put("oneClass", oneClass);
                    map.put("oneMajor", oneMajor);
                }
                if (user.getUserType() < 6){
                    Institution institution = 
                            institutionService.findinstitutionByUserInstId(user.getUserInstid());
                    map.put("institution", institution);
                }
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
	
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/login")
	public ModelAndView login(String loginname,String password, HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			//业务逻辑
			
			HttpSession session = request.getSession();
		
//			if(session.getAttribute("user")==null){
				User user = new User();
				user = userService.findUserByNAP(loginname, password);
				List<Role> role =new ArrayList<Role>();//存入辅导员的所有角色				
				if (user.getUserId() != null) {
					session.setAttribute("user", user);
					if(user.getUserType()==1)//学生用户登录存储其辅导员的角色信息以及自己的信息
					{
						Student student = studentService.findStudentById(user.getUserId());
						Studentclass studentclass = studentclassService.selectBystudInfoStudId(student.getStudClassid());
						Instructor instructor = instructorService.findInstructorByPrimaryKey(studentclass.getClassInstid());
						User instUser = userService.findUserInfoByUserId(instructor.getInstUserid());
						role = roleService.findRolesByUser(instUser);
						List<Studentbasiinfo> studentbasiinfo = studentbasiinfoService.findbasiinfoByStudUser(user);
						session.setAttribute("studentbasiinfo", studentbasiinfo);
						
					}
					else if(user.getUserType()==2)//辅导员用户登录存储所带学生的信息以及本学院学生信息
					{
						role = roleService.findRolesByUser(user);
						List<Studentbasiinfo> studentbasiinfo1 = studentbasiinfoService.findbasiinfoByinstUser(user);
						List<Studentbasiinfo> studentbasiinfo2 = studentbasiinfoService.findbasiinfoByOtherUser(user);
						
						session.setAttribute("studentbasiinfo1", studentbasiinfo1);
						session.setAttribute("studentbasiinfo2", studentbasiinfo2);
                        
					}else if(user.getUserType() > 2 && user.getUserType() < 6)//学办主任存储本学院信息
					{
						role = roleService.findRolesByUser(user);
						List<Studentbasiinfo> studentbasiinfo2 = studentbasiinfoService.findbasiinfoByOtherUser(user);
						session.setAttribute("studentbasiinfo2", studentbasiinfo2);
						List<Studentbasiinfo> studentbasiinfo1 = studentbasiinfoService.findbasiinfoByinstUser(user);
						session.setAttribute("studentbasiinfo1", studentbasiinfo1);
					}else
					{
						role = roleService.findRolesByUser(user);
					}
					session.setAttribute("role", role);
					// 获取用户权限
					CommonUserModel commonUserModel=userService.findUserCommonInfo(user);
					map.put("userLoginInfo", commonUserModel);
					map.put("href", "index.html");
					map.put("user", user);
					map.put("result", Boolean.TRUE);
					map.put("message", "success");
					map.put("role", role);
				} else {
					map.put("result", Boolean.FALSE);
					map.put("message", "用户名或密码填写错误！");
				}
			/*} else {
				map.put("result", Boolean.FALSE);
				map.put("message", "该用户没有可操作的权限！");
			}*/
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
	
    @SuppressWarnings({ "rawtypes", "unchecked", "finally"  })
    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
    	ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
    	// 清空的session对象
        HttpSession session = request.getSession();
        try {
                                   // session = null; 使session对象为空
            session.invalidate(); // 此时的退出只是使session对象失效 
            map.put("result", Boolean.TRUE);
        } catch (Exception e) {
        	map.put("result", Boolean.FALSE);
        } finally {
        	view.setAttributesMap(map);
			mav.setView(view);
			return mav;
        }
    }
     
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/showAuthorityList")
	public ModelAndView showAuthorityList(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			//业务逻辑
			HttpSession session = request.getSession();
			User user=new User();
			user=(User) session.getAttribute("user");
			if(user!=null){
				List<NavigationModel> list=new ArrayList<NavigationModel>();
				list=functionService.findFunListByUser(user);
				map.put("result", Boolean.TRUE);
				map.put("user", user);
				map.put("functionList", list);
				map.put("message", "执行成功！");
			}else {
				map.put("result", Boolean.FALSE);
				map.put("message", "用户已经退出！");
			}
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
	@SuppressWarnings({ "unchecked", "finally", "rawtypes" })
    @RequestMapping("/editPassword")//修改用户密码
    public ModelAndView EditPassword(String password, HttpServletRequest request,
            HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            // 业务逻辑
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");                                  
            if (user.getUserType() != null) {
                     int userId= user.getUserId();     
                    if (user.getUserId() != null) {
                        userService.EditInfoByUserId(userId,password); 
                        map.put("result", Boolean.TRUE);
                        map.put("message", "success");
                     //   session.setAttribute("user",user.getUserPassword());//改变密码后重新设置session的值
                    } else {
                        map.put("result", Boolean.TRUE);
                        map.put("message", "未找到信息");
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
    @RequestMapping("/checkPassword")// 验证输入的当前密码是否正确
    public ModelAndView CheckPassword( HttpServletRequest request,
            HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            map.put("result", Boolean.TRUE);
            map.put("message", "success");
            map.put("user",user);//返回user信息，用于比较与输入的当前密码是否一致
           
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
    @RequestMapping("/getUserInfo")//获取当前的用户信息
    public ModelAndView getUserInfo( HttpServletRequest request,
            HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            map.put("result", Boolean.TRUE);
            map.put("message", "success");
            map.put("user",user);
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
    @RequestMapping("/showAllUser")//显示所有用户信息
    public ModelAndView showAllUser( HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            //业务逻辑
        	List<Role> role = new ArrayList<Role>();
        	role = roleService.findAllRole();
            List<User> user = userService.findUsersByUserIsDelete(0);//显示未被删除的所有用户
            if(user.size()>0)
            {
              
            setAllUserList(user);
            int recordCount = user.size();//总记录数
            int pageCount;//总页数
            int temp = recordCount % 10;//10条记录一页
            if(temp == 0){
                pageCount = recordCount/10;
            }else{
                pageCount = recordCount/10 + 1;
            }
            List<User> firstUserList = new ArrayList<User>();
            int max = 0;
            int page = 1;
            max = allUserList.size()>page*10?page*10:allUserList.size();
            for(int j=(page-1)*10;j<max;j++)
            {
                firstUserList.add(allUserList.get(j));
            }
            map.put("result", Boolean.TRUE);
            map.put("message", "success");
            map.put("firstUserList",firstUserList);
            map.put("pageCount", pageCount);
            map.put("page", page);
            map.put("user", user);
           map.put("role", role);
            }else
            {
                map.put("result", Boolean.FALSE);
                map.put("message", "未找到用户信息");
            }
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
	@SuppressWarnings({ "unchecked", "finally", "rawtypes" })
    @RequestMapping("/deleteUserInfo")//删除用户信息把Isdelete置于1
    public ModelAndView deleteUserInfo(int userId, HttpServletRequest request,
            HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            // 业务逻辑
             
                userService.deleteByUserId(userId);
                map.put("result", Boolean.TRUE);
                map.put("message", "删除成功");
            
           
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
    @RequestMapping("/findOneUserInfo")
    public ModelAndView findOneUserInfo(int userId, HttpServletRequest request,
            HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            // 业务逻辑        
                            User user=new User();
                            user=userService.findUserInfoByUserId(userId);                                                                                                                    
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
	@SuppressWarnings({ "unchecked", "finally", "rawtypes" })
    @RequestMapping("/editUserInfo")
    public ModelAndView editUserInfo(int userId,String userName,int userInstid,String userLoginname,String userPassword,int userType,HttpServletRequest request,
            HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            // 业务逻辑        
                      
                       userService.editUserInfoByUserId(userId, userName, userInstid, userLoginname, userPassword, userType);                                                                                                                    
                        map.put("result", Boolean.TRUE);
                        map.put("message", "success");                                                                                             
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
    @RequestMapping("/addUserInfo")
    public ModelAndView addUserInfo(String userName,int userInstid,String userLoginname,String userPassword,int userType,HttpServletRequest request,
            HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            // 业务逻辑                              
                       userService.addUser(userName, userInstid, userLoginname, userPassword, userType);                                                                                                         
                        map.put("result", Boolean.TRUE);
                        map.put("message", "success");                                                                                             
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
    @RequestMapping("/showOnePageUserInfo")//显示一页用户信息
    public ModelAndView showOnePageUserInfo(int page, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            //业务逻辑
            List<User> user = userService.findUsersByUserIsDelete(0);//显示未被删除的所有用户
            if(user.size()>0)
            {
            setAllUserList(user);
            int recordCount = user.size();//总记录数
            int pageCount;//总页数
            int temp = recordCount % 50;//50条记录一页
            if(temp == 0){
                pageCount = recordCount/50;
            }else{
                pageCount = recordCount/50 + 1;
            }
            List<User> pageUserList = new ArrayList<User>();
            int max = 0;
            
            max = allUserList.size()>page*50?page*50:allUserList.size();
            for(int j=(page-1)*50;j<max;j++)
            {
                pageUserList.add(allUserList.get(j));
            }
            map.put("result", Boolean.TRUE);
            map.put("message", "success");
            map.put("pageUserList",pageUserList);
            map.put("pageCount", pageCount);  
            map.put("page", page);
           
            }else
            {
                map.put("result", Boolean.FALSE);
                map.put("message", "未找到用户信息");
            }
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
    @RequestMapping("/showAllUserInst")//显示所有查找的相同学院用户信息
    public ModelAndView showAllUserInst(int userInstid, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            //业务逻辑
            List<User> user = userService.findUsersByUserIsDelete(0);//显示未被删除的所有用户
          List<User> user1 = new ArrayList<User>();
            for(int i=0;i<user.size();i++)
            {
                if(user.get(i).getUserInstid()==userInstid)
                {
                    user1.add(user.get(i));
                }
            }
            if(user1.size()>0)
            {
            setAllUserList(user1);
            int recordCount = user1.size();//总记录数
            int pageCount;//总页数
            int temp = recordCount % 50;//50条记录一页
            if(temp == 0){
                pageCount = recordCount/50;
            }else{
                pageCount = recordCount/50 + 1;
            }
            List<User> firstUserList = new ArrayList<User>();
            int max = 0;
            int page = 1;
            max = allUserList.size()>page*50?page*50:allUserList.size();
            for(int j=(page-1)*50;j<max;j++)
            {
                firstUserList.add(allUserList.get(j));
            }
            map.put("result", Boolean.TRUE);
            map.put("message", "success");
            map.put("firstUserList",firstUserList);
            map.put("pageCount", pageCount);
            map.put("page", page);
            map.put("user1", user1);
            }else
            {
                map.put("result", Boolean.FALSE);
                map.put("message", "未找到用户信息");
            }
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
    @RequestMapping("/showOnePageUserInst")//显示一页查找的相同学院用户信息
    public ModelAndView showOnePageUserInst(int page,int userInstid ,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            //业务逻辑
            List<User> user = userService.findUsersByUserIsDelete(0);//显示未被删除的所有用户
            List<User> user1 = new ArrayList<User>();
            for(int i=0;i<user.size();i++)
            {
                if(user.get(i).getUserInstid()==userInstid)
                {
                    user1.add(user.get(i));
                }
            }
            if(user1.size()>0)
            {
            setAllUserList(user1);
            int recordCount = user1.size();//总记录数
            int pageCount;//总页数
            int temp = recordCount % 50;//50条记录一页
            if(temp == 0){
                pageCount = recordCount/50;
            }else{
                pageCount = recordCount/50 + 1;
            }
            List<User> pageUserList = new ArrayList<User>();
            int max = 0;
            
            max = allUserList.size()>page*50?page*50:allUserList.size();
            for(int j=(page-1)*50;j<max;j++)
            {
                pageUserList.add(allUserList.get(j));
            }
            map.put("result", Boolean.TRUE);
            map.put("message", "success");
            map.put("pageUserList",pageUserList);
            map.put("pageCount", pageCount);  
            map.put("page", page);
           
            }else
            {
                map.put("result", Boolean.FALSE);
                map.put("message", "未找到用户信息");
            }
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
    @RequestMapping("/showAllUserInstAndType")//显示所查找的所有相同用户类型的用户信息
    public ModelAndView showAllUserInstAndType(int userInstid,int userType, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            //业务逻辑
            List<User> user = userService.findUsersByUserIsDelete(0);//显示未被删除的所有用户
          List<User> user1 = new ArrayList<User>();
            for(int i=0;i<user.size();i++)
            {
                if(user.get(i).getUserType()==userType&&user.get(i).getUserInstid()==userInstid)
                {
                    user1.add(user.get(i));
                }
            }
            if(user1.size()>0)
            {
            setAllUserList(user1);
            int recordCount = user1.size();//总记录数
            int pageCount;//总页数
            int temp = recordCount % 50;//50条记录一页
            if(temp == 0){
                pageCount = recordCount/50;
            }else{
                pageCount = recordCount/50 + 1;
            }
            List<User> firstUserList = new ArrayList<User>();
            int max = 0;
            int page = 1;
            max = allUserList.size()>page*50?page*50:allUserList.size();
            for(int j=(page-1)*50;j<max;j++)
            {
                firstUserList.add(allUserList.get(j));
            }
            map.put("result", Boolean.TRUE);
            map.put("message", "success");
            map.put("firstUserList",firstUserList);
            map.put("pageCount", pageCount);
            map.put("page", page);
            map.put("user1", user1);
            }else
            {
                map.put("result", Boolean.FALSE);
                map.put("message", "未找到用户信息");
            }
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
    @RequestMapping("/showOnePageUserInstAndType")//显示一页查找的相同用户类型的用户信息
    public ModelAndView showOnePageUserInstAndType(int userInstid,int page,int userType ,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            //业务逻辑
            List<User> user = userService.findUsersByUserIsDelete(0);//显示未被删除的所有用户
            List<User> user1 = new ArrayList<User>();
            for(int i=0;i<user.size();i++)
            {
                if(user.get(i).getUserType()==userType&&user.get(i).getUserInstid()==userInstid)
                {
                    user1.add(user.get(i));
                }
            }
            if(user1.size()>0)
            {
            setAllUserList(user1);
            int recordCount = user1.size();//总记录数
            int pageCount;//总页数
            int temp = recordCount % 50;//50条记录一页
            if(temp == 0){
                pageCount = recordCount/50;
            }else{
                pageCount = recordCount/50 + 1;
            }
            List<User> pageUserList = new ArrayList<User>();
            int max = 0;
            
            max = allUserList.size()>page*50?page*50:allUserList.size();
            for(int j=(page-1)*50;j<max;j++)
            {
                pageUserList.add(allUserList.get(j));
            }
            map.put("result", Boolean.TRUE);
            map.put("message", "success");
            map.put("pageUserList",pageUserList);
            map.put("pageCount", pageCount);  
            map.put("page", page);
           
            }else
            {
                map.put("result", Boolean.FALSE);
                map.put("message", "未找到用户信息");
            }
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
    @RequestMapping("/showAllUserType")//显示所查找的所有相同用户类型的用户信息
    public ModelAndView showAllUserType(int userType, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            //业务逻辑
            List<User> user = userService.findUsersByUserIsDelete(0);//显示未被删除的所有用户
          List<User> user1 = new ArrayList<User>();
            for(int i=0;i<user.size();i++)
            {
                if(user.get(i).getUserType()==userType)
                {
                    user1.add(user.get(i));
                }
            }
            if(user1.size()>0)
            {
            setAllUserList(user1);
            int recordCount = user1.size();//总记录数
            int pageCount;//总页数
            int temp = recordCount % 50;//50条记录一页
            if(temp == 0){
                pageCount = recordCount/50;
            }else{
                pageCount = recordCount/50 + 1;
            }
            List<User> firstUserList = new ArrayList<User>();
            int max = 0;
            int page = 1;
            max = allUserList.size()>page*50?page*50:allUserList.size();
            for(int j=(page-1)*50;j<max;j++)
            {
                firstUserList.add(allUserList.get(j));
            }
            map.put("result", Boolean.TRUE);
            map.put("message", "success");
            map.put("firstUserList",firstUserList);
            map.put("pageCount", pageCount);
            map.put("page", page);
            map.put("user1", user1);
            }else
            {
                map.put("result", Boolean.FALSE);
                map.put("message", "未找到用户信息");
            }
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
    @RequestMapping("/showOnePageUserType")//显示一页查找的相同用户类型的用户信息
    public ModelAndView showOnePageUserType(int page,int userType ,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            //业务逻辑
            List<User> user = userService.findUsersByUserIsDelete(0);//显示未被删除的所有用户
            List<User> user1 = new ArrayList<User>();
            for(int i=0;i<user.size();i++)
            {
                if(user.get(i).getUserType()==userType)
                {
                    user1.add(user.get(i));
                }
            }
            if(user1.size()>0)
            {
            setAllUserList(user1);
            int recordCount = user1.size();//总记录数
            int pageCount;//总页数
            int temp = recordCount % 50;//50条记录一页
            if(temp == 0){
                pageCount = recordCount/50;
            }else{
                pageCount = recordCount/50 + 1;
            }
            List<User> pageUserList = new ArrayList<User>();
            int max = 0;
            
            max = allUserList.size()>page*50?page*50:allUserList.size();
            for(int j=(page-1)*50;j<max;j++)
            {
                pageUserList.add(allUserList.get(j));
            }
            map.put("result", Boolean.TRUE);
            map.put("message", "success");
            map.put("pageUserList",pageUserList);
            map.put("pageCount", pageCount);  
            map.put("page", page);
           
            }else
            {
                map.put("result", Boolean.FALSE);
                map.put("message", "未找到用户信息");
            }
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
    @SuppressWarnings({ "unchecked", "finally", "rawtypes" })
    @RequestMapping("/checkUserInfo")
    public ModelAndView checkUserInfo(String userLoginnameOrName,HttpServletRequest request,
            HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            // 业务逻辑                              
            List<User> user = userService.findUsersByUserIsDelete(0);//显示未被删除的所有用户
            List<User> user1 = new ArrayList<User>();
            for(int i=0;i<user.size();i++)
            {
                if(user.get(i).getUserLoginname().equals(userLoginnameOrName)||user.get(i).getUserName().equals(userLoginnameOrName))
                {
                    user1.add(user.get(i));
                }
            }          
            if(user1.size()>0)                                                                                            
            {                 
               
                map.put("result", Boolean.TRUE);
                map.put("message", "success");        
                map.put("user1", user1);
              
             }else{
                       map.put("result", Boolean.FALSE);
                       map.put("message", "未找到用户信息！");                       
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
    @RequestMapping("/checkStuInfo")
    public ModelAndView checkStuInfo(HttpServletRequest request,HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String info = new String();
        try {
            // 业务逻辑     
            map.put("result", Boolean.TRUE);
         if(user.getUserType() == 1){
             Student student = studentService.selectInfoByUser(user.getUserId());
             List<Parent> parents = parentService.getParentsByStuid(student.getStudId());
             if(parents.size()<=0){
                 info += "家庭成员，";
                 map.put("result", Boolean.FALSE);
             }
             Studentinfo studentinfo = studentinfoService.selectBystudInfoStudId(student.getStudId());
             if(studentinfo.getStinBanknumber()=="" || studentinfo.getStinBanknumber()==null){
                 info += "银行账号，";
                 map.put("result", Boolean.FALSE);
             }
             if(studentinfo.getStinPhone()=="" || studentinfo.getStinPhone()==null){
                 info += "电话，";    
                 map.put("result", Boolean.FALSE);
             }
         }
            map.put("info", info);
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
    @RequestMapping("/findroleByuserId")
    public ModelAndView findroleByuserId(Integer userId,HttpServletRequest request,
            HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            // 业务逻辑   
        	List<Reuserrole> role = new ArrayList<Reuserrole>();
        	role = reuserroleService.findReuserroleByUserId(userId);
            map.put("result", Boolean.TRUE);
            map.put("message", "success");   
            map.put("role", role);
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
