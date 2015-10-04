package swust.edu.cn.zzxt.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
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

import swust.edu.cn.zzxt.selfmodel.CountModal;
import swust.edu.cn.zzxt.selfmodel.StudentTjModel;
import swust.edu.cn.zzxt.selfmodel.Studentbasiinfo;
import swust.edu.cn.zzxt.service.GjzxjService;
import swust.edu.cn.zzxt.service.InstitutionService;
import swust.edu.cn.zzxt.service.InstructorService;
import swust.edu.cn.zzxt.service.MajorService;
import swust.edu.cn.zzxt.service.ParentService;
import swust.edu.cn.zzxt.service.StudentService;
import swust.edu.cn.zzxt.service.StudentclassService;
import swust.edu.cn.zzxt.service.StudentinfoService;
import swust.edu.cn.zzxt.service.WorkService;
import swust.edu.cn.zzxt.service.WorkstepfolwService;
import swust.edu.cn.zzxt.model.GjlzjxjWithBLOBs;
import swust.edu.cn.zzxt.model.GjzxjWithBLOBs;
import swust.edu.cn.zzxt.model.Institution;
import swust.edu.cn.zzxt.model.Instructor;
import swust.edu.cn.zzxt.model.Learning;
import swust.edu.cn.zzxt.model.Major;
import swust.edu.cn.zzxt.model.Parent;
import swust.edu.cn.zzxt.model.Reward;
import swust.edu.cn.zzxt.model.Student;
import swust.edu.cn.zzxt.model.Studentclass;
import swust.edu.cn.zzxt.model.Studentinfo;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.model.Work;
import swust.edu.cn.zzxt.model.Workstepfolw;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

@Controller
@RequestMapping("/studentController")
public class StudentController {
    private WorkService workService;

    public WorkService getWorkService() {
        return workService;
    }

    @Autowired
    public void setWorkService(WorkService workService) {
        this.workService = workService;
    }

    private List<Student> allStuList;// 全部学生

    public List<Student> getAllStuList() {
        return allStuList;
    }

    public void setAllStuList(List<Student> allStuList) {
        this.allStuList = allStuList;
    }

    private InstitutionService institutionService;

    public InstitutionService getInstitutionService() {
        return institutionService;
    }

    @Autowired
    public void setInstitutionService(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    private StudentService studentService;
    private StudentinfoService studentinfoService;
    private StudentclassService studentclassService;
    private MajorService majorService;
    private WorkstepfolwService workstepfolwService;
    private InstructorService instructorService;

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

    private ParentService parentService;

    private GjzxjService gjzxjService;

    public GjzxjService getGjzxjService() {
        return gjzxjService;
    }

    @Autowired
    public void setGjzxjService(GjzxjService gjzxjService) {
        this.gjzxjService = gjzxjService;
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

    public ParentService getParentService() {
        return parentService;
    }

    @Autowired
    public void setParentService(ParentService parentService) {
        this.parentService = parentService;
    }

    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/addParentInfo")
    public ModelAndView addParentInfo(String pare_name, String pare_phone, String pare_role, String pare_relation,
            String pare_IDNumber, String pare_occupation, String pare_work, String pare_duties,
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
            if (user.getUserType() == 1) {
                parent = parentService.selectByPrimaryName(pare_name); // 通过键入的用户名来查找用户
                if (parent == null) {// 当该用户名没有被录入时，才许可添加操作
                    student = studentService.findStudentById(id);
                    parent = new Parent();
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
                } else {
                    map.put("result", Boolean.FALSE);
                    map.put("message", "请勿重复添加");
                }
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
    @RequestMapping("/showPareInfo")
    public ModelAndView showPareInfo(int studId, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Student student = studentService.findStudentById(user.getUserId());
        try {// 查reuserrol 判断角色
            List<Parent> parents;
            if (studId != -1)
                parents = parentService.getParentsByStuid(studId);
            else {
                parents = parentService.getParentsByStuid(student.getStudId());
            }
            if (parents.size() > 0) {
                map.put("result", Boolean.TRUE);
                map.put("message", "查询成功");
                map.put("parentsList", parents);
            } else {
                map.put("result", Boolean.TRUE);
                map.put("parentsList", null);
                map.put("message", "无父母信息");
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

    // @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    // @RequestMapping("/showPareInfo")
    // public ModelAndView showPareInfo(int studId, HttpServletResponse
    // response, HttpServletRequest request) {
    // ModelAndView mav = new ModelAndView();
    // MappingJacksonJsonView view = new MappingJacksonJsonView();
    // Map map = new HashMap();
    // HttpSession session = request.getSession();
    // User user = (User) session.getAttribute("user");
    // try {
    // List<Parent> parents;
    // if(user.getUserType()==1){
    // parents = parentService.getParentsByStuid(studId);
    // if(parents.size()>0){
    // map.put("result", Boolean.TRUE);
    // map.put("message", "查询成功");
    // map.put("parentsList", parents);
    // }
    // else{
    // map.put("result", Boolean.FALSE);
    // map.put("message", "无父母信息");
    // }
    // }
    //
    // } catch (Exception e) {
    // // TODO: handle exception
    // map.put("result", Boolean.FALSE);
    // map.put("message", "添加错误");
    // e.printStackTrace();
    // }finally{
    // view.setAttributesMap(map);
    // mav.setView(view);
    // return mav;
    // }
    //
    // }

    /**
     * @Title: obtainStudentByStudNumber StudentController
     * @Description: 根据学号查询学生信息
     * @param @param request
     * @param @param response
     * @param @param studNumber
     * @param @return
     * @param @throws Exception
     * @return ModelAndView
     * @throws
     */
    @SuppressWarnings({ "finally", "rawtypes", "unchecked" })
    @RequestMapping("/obtainStudentByStudNumber")
    public ModelAndView obtainStudentByStudNumber(HttpServletRequest request, HttpServletResponse response,
            String studNumber) throws Exception {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        Student student = new Student();
        Studentinfo studentInfo = new Studentinfo();
        Studentclass studentClass = new Studentclass();
        Major major = new Major();
        try {
            System.out.println(studNumber);
            student = studentService.obtainStudentByStudNumber(studNumber);
            studentInfo = studentinfoService.obtainStudentInfoByStudId(student.getStudId());
            studentClass = studentclassService.obtainStudentClassByStudClassid(student.getStudClassid());
            major = majorService.obtainMajorByClassMajrid(studentClass.getClassMajrid());

            // 业务逻辑
            map.put("student", student);
            map.put("studentInfo", studentInfo);
            map.put("studentClass", studentClass);
            map.put("major", major);
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

    /**
     * @author Wang Jian
     * @Title: readStudentByStudNumber
     * @ClassName：StudentController.java
     * @Package: swust.edu.cn.zzxt.controller
     * @Description: 根据学生的学号查询信息
     * @createDate:
     * @email:
     * @phone:
     * @Department:
     * @Address:
     * @reviseNote:
     * @version:
     */

    @SuppressWarnings({ "rawtypes", "unchecked", "finally", "unused" })
    @RequestMapping("/readStudentByStudNumber")
    public ModelAndView readStudentByStudNumber(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        Workstepfolw workstepfolw = new Workstepfolw();
        User user = new User();
        HttpSession session = request.getSession();// 获取session
        user = (User) session.getAttribute("user");
        String studNumber = user.getUserLoginname();

        try {// 查reuserrol 判断角色
            if (user == null) {
                map.put("result", Boolean.FALSE);
                map.put("message", "用户已经退出！请重新登录");

            } else {
                if (user.getUserType() == 1) {
                    List<Student> student = new ArrayList<Student>();
                    Studentinfo studentInfo = new Studentinfo();
                    Studentclass studentClass = new Studentclass();
                    Major major = new Major();
                    List<Learning> learning = new ArrayList<Learning>();
                    GjlzjxjWithBLOBs gjlzjxjwithblobs = new GjlzjxjWithBLOBs();
                    GjzxjWithBLOBs gjzxjWithBLOBs = new GjzxjWithBLOBs();
                    List<Reward> reward = new ArrayList<Reward>();

                    student = studentService.readStudentByStudNumber(studNumber);
                    studentInfo = studentinfoService.selectBystudInfoStudId(student.get(0).getStudId());
                    System.out.println(student.get(0).getStudId());
                    studentClass = studentclassService.selectBystudInfoStudId(student.get(0).getStudClassid());
                    major = majorService.selectByPrimaryKey(studentClass.getClassMajrid());
                    gjzxjWithBLOBs = gjzxjService.findGjzxjWithBLOBsByStuId(student.get(0).getStudId());
                    if (gjzxjWithBLOBs != null) {
                        workstepfolw = workstepfolwService.findWslfByWslfId(gjzxjWithBLOBs.getGzxjWsflid());
                        map.put("workstepfolw", workstepfolw);
                    }
                    Work work = workService.selectByWorkId(10);
                    map.put("gjzxjWithBLOBs", gjzxjWithBLOBs);
                    map.put("work", work);
                    map.put("result", Boolean.TRUE);
                    map.put("student", student);
                    map.put("studentInfo", studentInfo);
                    map.put("studentClass", studentClass);
                    map.put("major", major);
                    map.put("learning", learning);
                    map.put("message", "success！");
                } else {
                    map.put("result", false);
                    map.put("message", "该用户没有可操作的权限！");
                }
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

    /**
	 * @author pengyan
	 * @Title: showAllStudents
	 * @ClassName：StudentController.java
	 * @Package: swust.edu.cn.zzxt.controller
	 * @Description: 显示当前角色所能看到的所有学生列表
	 * @createDate:2014、08、06
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/showAllStudents")
	public ModelAndView showAllStudents(HttpServletResponse response,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		HttpSession session = request.getSession();
		try {	
			User user = (User) session.getAttribute("user");
			if (user != null) {
				List<Student> list = studentService
						.selectStudentByUserType(user);
				if (list.size() > 0) {
					int recordCount = list.size();// 总记录数
					int pageCount;// 总页数
					int temp = recordCount % 10;// 10条记录一页
					if (temp == 0) {
						pageCount = recordCount / 10;
					} else {
						pageCount = recordCount / 10 + 1;
					}
					map.put("result", Boolean.TRUE);
					map.put("students", list);
					map.put("message", "查找成功！");
					map.put("pageCount", pageCount);
				}
			} else {
				map.put("result", Boolean.FALSE);
				map.put("message", "用户已经退出登录！");
			}
		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
			map.put("message", "查找错误！");
			e.printStackTrace();
		} finally {
			view.setAttributesMap(map);
			mav.setView(view);
			return mav;
		}
	}


	/**
	 * @author pengyan
	 * @Title: queryStuByConditions
	 * @ClassName：StudentController.java
	 * @Package: swust.edu.cn.zzxt.controller
	 * @Description: 条件筛选后的学生列表
	 * @createDate:2014、08、06
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/queryStuByConditions")
	public ModelAndView queryStuByConditions(int colleageId, int majorId, int classId, int stuSex, String stuNation, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {	   
			// 业务逻辑	
			Studentbasiinfo studentbasiinfo =new  Studentbasiinfo();
			studentbasiinfo.setInstId(colleageId);
			studentbasiinfo.setMajrId(majorId);
			studentbasiinfo.setClassId(classId);
			studentbasiinfo.setStudentSex(stuSex);
			studentbasiinfo.setStudentNation(stuNation);
			List<Studentbasiinfo> stuDetailList = studentService.selectStudentByAll2(studentbasiinfo);
		/*	List<Student> list= studentService.selectStudentByAll(studentbasiinfo);*/
			 //生成EXCEL表格 
			// 设置excel工作表的标题
			String[] title = { "姓名","性别","民族","学号","政治面貌","班级","专业","院系", "生源地信息", 
					"身份证号码","银行卡号","邮编","户口类型","电话号码","家庭收入来源"};
			// 输出的excel的路径
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
            String date = sdf.format(System.currentTimeMillis());
            HttpSession session = request.getSession();
            session.setAttribute("DownLoadDate", date);
            
			String filePath = request.getSession().getServletContext()
					.getRealPath("upload/studentList"+date+".xls");
			// 创建Excel工作薄
			WritableWorkbook wwb;
			OutputStream os = new FileOutputStream(filePath);
				wwb = Workbook.createWorkbook(os);
			// 添加第一个工作表并设置第一个Sheet的名字
			WritableSheet sheet = wwb.createSheet("学生统计表", 0);

			// 设置标题的格式
			WritableFont wf_title = new WritableFont(WritableFont.ARIAL, 16,
					WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.BLACK);
			WritableCellFormat wcf_title = new WritableCellFormat(wf_title);
			wcf_title.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf_title.setAlignment(Alignment.CENTRE);
			wcf_title.setBorder(jxl.format.Border.ALL,
					jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK); // 设置边框
			wcf_title.setBackground(jxl.format.Colour.BRIGHT_GREEN);
			// 设置头标题的格式
			WritableFont wf_head = new WritableFont(WritableFont.ARIAL, 12,
					WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.BLACK);
			WritableCellFormat wcf_head = new WritableCellFormat(wf_head);
			wcf_head.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf_head.setAlignment(Alignment.CENTRE);
			wcf_head.setBorder(jxl.format.Border.ALL,
					jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK); // 设置边框

			// 设置单元格的文字格式
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 11,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.BLACK);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf.setAlignment(Alignment.CENTRE);
			wcf.setBorder(jxl.format.Border.ALL,
					jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK); // 设置边框

			// 设置列宽
			sheet.setColumnView(0, 22); 
			sheet.setColumnView(1, 15); 
			sheet.setColumnView(2, 15); 
			sheet.setColumnView(3, 15); 
			sheet.setColumnView(4, 15); 
			sheet.setColumnView(5, 25); 
			sheet.setColumnView(6, 30); 
			sheet.setColumnView(7, 40); 
			sheet.setColumnView(8, 50);
			sheet.setColumnView(9, 50); 
			sheet.setColumnView(10, 50); 
			sheet.setColumnView(11, 20); 
			sheet.setColumnView(12, 20); 
			sheet.setColumnView(13, 30); 
			sheet.setColumnView(14, 30); 
			Label label;
			for (int i = 0; i < title.length; i++) {
				// Label(x,y,z) 代表单元格的第x+1列，第y+1行, 内容z
				label = new Label(i, 1, title[i], wcf_head);
				sheet.addCell(label);
			}
			//填写数据
			// 姓名
			for (int i = 0; i < stuDetailList.size(); i++) {
				label = new Label(0, i + 2, stuDetailList.get(i).getStudentName(),
						wcf);
				sheet.addCell(label);
			}
			//性别
			
			for (int i = 0; i < stuDetailList.size(); i++) {
				label = new Label(1, i + 2, stuDetailList.get(i).getStuSex(),
						wcf);
				sheet.addCell(label);
			}
			//民族
			for (int i = 0; i < stuDetailList.size(); i++) {
				label = new Label(2, i + 2, stuDetailList.get(i).getStudentNation(),
						wcf);
				sheet.addCell(label);
			}
			//学号
			for (int i = 0; i < stuDetailList.size(); i++) {
				label = new Label(3, i + 2, stuDetailList.get(i).getStudentNumber(),
						wcf);
				sheet.addCell(label);
			}
			//政治面貌
			for (int i = 0; i < stuDetailList.size(); i++) {
				label = new Label(4, i + 2, stuDetailList.get(i).getPoliticState(),
						wcf);
				sheet.addCell(label);
			}
			//班级
			for (int i = 0; i < stuDetailList.size(); i++) {
				label = new Label(5, i + 2, stuDetailList.get(i).getClassName(),
						wcf);
				sheet.addCell(label);
			}
			//专业
			for (int i = 0; i < stuDetailList.size(); i++) {
				label = new Label(6, i + 2, stuDetailList.get(i).getMajrName(),
						wcf);
				sheet.addCell(label);
			}
			//院系
			for (int i = 0; i < stuDetailList.size(); i++) {
				label = new Label(7, i + 2, stuDetailList.get(i).getInstName(),
						wcf);
				sheet.addCell(label);
			}
			//生源地
			for (int i = 0; i < stuDetailList.size(); i++) {
				label = new Label(8, i + 2, stuDetailList.get(i).getAreaDetailOrigin(),
						wcf);
				sheet.addCell(label);
			}
			//身份证
			for (int i = 0; i < stuDetailList.size(); i++) {
				label = new Label(9, i + 2, stuDetailList.get(i).getStudentIDNumber(),
						wcf);
				sheet.addCell(label);
			}
			//银行卡号
			for (int i = 0; i < stuDetailList.size(); i++) {
				label = new Label(10, i + 2, stuDetailList.get(i).getBankNumber(),
						wcf);
				sheet.addCell(label);
			}
			//邮编
			for (int i = 0; i < stuDetailList.size(); i++) {
				label = new Label(11, i + 2, stuDetailList.get(i).getMailCode(),
						wcf);
				sheet.addCell(label);
			}
			//户口类型
			for (int i = 0; i < stuDetailList.size(); i++) {
				label = new Label(12, i + 2, stuDetailList.get(i).getResidence(),
						wcf);
				sheet.addCell(label);
			}
			//电话号码
			for (int i = 0; i < stuDetailList.size(); i++) {
				label = new Label(13, i + 2, stuDetailList.get(i).getPhone(),
						wcf);
				sheet.addCell(label);
			}
			//家庭收入来源
			for (int i = 0; i < stuDetailList.size(); i++) {
				label = new Label(14, i + 2, stuDetailList.get(i).getIncomeType(),
						wcf);
				sheet.addCell(label);
			}
			
			/*
			 * 合并单元格 通过writablesheet.mergeCells(int x,int y,int m,int n);来实现的
			 * 表示将从第x+1列，y+1行到m+1列，n+1行合并
			 */
			sheet.mergeCells(0, 0, 14, 0);
			label = new Label(0, 0, "学生基本信息统计表",
					wcf_title);
			sheet.addCell(label);
			             // 写入数据
						wwb.write();
						// 关闭文件
						wwb.close();
			if(stuDetailList.size()>0){
				int recordCount =stuDetailList.size();// 总记录数
				int pageCount;// 总页数
				int temp = recordCount % 10;// 10条记录一页
				if (temp == 0) {
					pageCount = recordCount / 10;
				} else {
					pageCount = recordCount / 10 + 1;
				}
				map.put("result", Boolean.TRUE);
				map.put("students", stuDetailList);
				map.put("message", "查找成功！");
				map.put("pageCount", pageCount);
				map.put("count", recordCount );
			}
			else{
				map.put("count", 0);
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
	

    /**
	 * @author pengyan
	 * @Title: queryStuByKey
	 * @ClassName：StudentController.java
	 * @Package: swust.edu.cn.zzxt.controller
	 * @Description: 准确查找一个学生信息（学号/身份证/姓名）
	 * @createDate:2014、08、06
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/queryStuByKey")
	public ModelAndView queryStuByKey( String key, int state, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		HttpSession session = request.getSession();
		try {
			
			 User user = (User) session.getAttribute("user");
			 if (user!= null){
	         if(key.length()==8 && state==0){
	        	List<Student> list = studentService.readStudentByStudNumber(key);
	        	if(list.size()>0)
	        	{
	        	Student student = list.get(0);
	        	int userType=user.getUserType();
    				//获取班级
   				 Studentclass studentclass = new Studentclass();
   				 studentclass = studentclassService.obtainStudentClassByStudClassid(student.getStudClassid());
   				 //获取辅导员
   				 Instructor instructor = new Instructor();
   				 instructor =   instructorService.findInstructorByPrimaryKey( studentclass.getClassInstid());
   				//获取专业
   				 Major major= new Major();
   				 major = majorService.selectByPrimaryKey(studentclass.getClassMajrid());
   				 //获取学院
   				 Institution institution =new Institution();
   				 institution = institutionService.findinstitutionByMajorInstId(major.getMajrInstid());
 
	        			if (userType==2) {
	        				 if(user.getUserId().equals(instructor.getInstUserid()))
		    				{
		    					map.put("student", student);
		    					map.put("result", Boolean.TRUE);
		    	    			map.put("message", "success");		
		    				}else{
		    	        		map.put("result", Boolean.FALSE);
		    	        	}
		    			}else if (userType==3 || userType==4 || userType==5) {
		    				if(user.getUserInstid().equals(institution.getInstId())){
		    					map.put("student", student);
		    					map.put("result", Boolean.TRUE);
		    	    			map.put("message", "success");	
		    				}else{
		    	        		map.put("result", Boolean.FALSE);
		    	        	}
		    			
		    			}else if (userType==6) {
		    				map.put("student", student);
		    				map.put("result", Boolean.TRUE);
	    	    			map.put("message", "success");	
		    			}	
	        	}else{
	        		map.put("result", Boolean.FALSE);
	        	}
	         }
	         else if(key.length()==18 && state==0){
	        	 List<Student> list = studentService.readStudentByStudIdNumber(key);
	        	 if(list.size()>0)
		        	{
	           		Student student = list.get(0);
	        		int userType=user.getUserType();
    			//获取班级
   				 Studentclass studentclass = new Studentclass();
   				 studentclass = studentclassService.obtainStudentClassByStudClassid(student.getStudClassid());
   				 //获取辅导员
   				 Instructor instructor = new Instructor();
   				 instructor =   instructorService.findInstructorByPrimaryKey( studentclass.getClassInstid());
   				//获取专业
   				 Major major= new Major();
   				 major = majorService.selectByPrimaryKey(studentclass.getClassMajrid());
   				 //获取学院
   				 Institution institution =new Institution();
   				 institution = institutionService.findinstitutionByMajorInstId(major.getMajrInstid());
	        			if (userType==2) {
	        				 if(user.getUserId().equals(instructor.getInstUserid()))
		    				{
		    					map.put("student", student);
		    					map.put("result", Boolean.TRUE);
		    	    			map.put("message", "success");		
		    				}else{
		    	        		map.put("result", Boolean.FALSE);
		    	        	}
		    			}else if (userType==3 || userType==4 || userType==5) {
		    				if(user.getUserInstid().equals(institution.getInstId())){
		    					map.put("student", student);
		    					map.put("result", Boolean.TRUE);
		    	    			map.put("message", "success");	
		    				}else{
		    	        		map.put("result", Boolean.FALSE);
		    	        	}
		    			
		    			}else if (userType==6) {
		    				map.put("student", student);
		    				map.put("result", Boolean.TRUE);
	    	    			map.put("message", "success");	
		    			}		
		        	}else{
		        		map.put("result", Boolean.FALSE);
		        	}
	         }else if(state==1){
	        	  	List<Student> stuList = studentService.findStudentByStuName(key);
		        	if(stuList !=null&&stuList.size()>0)
		        	{
		        		List<Student> studentList = new ArrayList<Student>();
		        		for(int i=0;i<stuList.size();i++){
		        			Student student = stuList.get(i);
			        		int userType=user.getUserType();
		    			//获取班级
		   				 Studentclass studentclass = new Studentclass();
		   				 studentclass = studentclassService.obtainStudentClassByStudClassid(student.getStudClassid());
		   				 //获取辅导员
		   				 Instructor instructor = new Instructor();
		   				 instructor =   instructorService.findInstructorByPrimaryKey( studentclass.getClassInstid());
		   				//获取专业
		   				 Major major= new Major();
		   				 major = majorService.selectByPrimaryKey(studentclass.getClassMajrid());
		   				 //获取学院
		   				 Institution institution =new Institution();
		   				 institution = institutionService.findinstitutionByMajorInstId(major.getMajrInstid());
			        			if (userType==2) {
			        				 if(user.getUserId().equals(instructor.getInstUserid()))
				    				{
			        					 studentList.add(student);		
				    				}
				    			}else if (userType==3 || userType==4 || userType==5) {
				    				if(user.getUserInstid().equals(institution.getInstId())){
				    					 studentList.add(student);		
				    				}
				    			
				    			}else if (userType==6) {
				    				studentList.add(student);	
				    			}		
		        		}
		        		if(studentList.size()>0){
		        		map.put("stuList", stuList);	
		        		map.put("result", Boolean.TRUE);
		    			map.put("message", "success");
		    			}	
		        		else{
			        		map.put("result", Boolean.FALSE);}	
		        	}
		        	else{
		        		map.put("result", Boolean.FALSE);
		        	}
	        	 
	         }
		}else{
			map.put("result", Boolean.FALSE);
			map.put("message", "用户已经退出登录！");
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
	@RequestMapping("/showStuList")
	public ModelAndView showStuList(HttpServletResponse response,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		HttpSession session = request.getSession();
		try {	
			User user = (User) session.getAttribute("user");
			if (user != null) {
				List<Studentbasiinfo> list = studentService
						.selectStudentInfoByUserType(user);
				Institution institution =new Institution();
				institution = institutionService.findinstitutionByUserInstId(user.getUserInstid());
				List<Major> major = new ArrayList<Major>();
				major = majorService.selectClassByUserId(user.getUserId());
				if (list.size() > 0) {
					int recordCount = list.size();// 总记录数
					int pageCount;// 总页数
					int temp = recordCount % 10;// 10条记录一页
					if (temp == 0) {
						pageCount = recordCount / 10;
					} else {
						pageCount = recordCount / 10 + 1;
					}
					map.put("result", Boolean.TRUE);
					map.put("students", list);
					map.put("message", "查找成功！");
					map.put("pageCount", pageCount);
					map.put("institution", institution);
					map.put("major", major);
				}
			} else {
				map.put("result", Boolean.FALSE);
				map.put("message", "用户已经退出登录！");
			}
		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
			map.put("message", "查找错误！");
			e.printStackTrace();
		} finally {
			view.setAttributesMap(map);
			mav.setView(view);
			return mav;
		}
	}

	@SuppressWarnings({"rawtypes", "finally", "unchecked" })
	@RequestMapping("/countByAcademy")
	public ModelAndView countByAcademy(HttpServletRequest request,HttpServletResponse response){
	        ModelAndView mav = new ModelAndView();
	        MappingJacksonJsonView view = new MappingJacksonJsonView();
	        Map map = new HashMap();
	    	HttpSession session = request.getSession();
	        try {
	        	 User user = (User) session.getAttribute("user");
	        	 List< StudentTjModel>  studentTjModels = new ArrayList<StudentTjModel>();
	        	 studentTjModels=studentService.findStuCountInfo(user);
	            map.put("type", user.getUserType());
	            map.put("studentTjModels", studentTjModels);
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
}
