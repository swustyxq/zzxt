package swust.edu.cn.zzxt.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import swust.edu.cn.zzxt.model.Institution;
import swust.edu.cn.zzxt.model.Instructor;
import swust.edu.cn.zzxt.model.Role;
import swust.edu.cn.zzxt.model.Studentclass;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.selfmodel.ListModal;
import swust.edu.cn.zzxt.selfmodel.TeacherModal;
import swust.edu.cn.zzxt.service.InstitutionService;
import swust.edu.cn.zzxt.service.InstructorService;
import swust.edu.cn.zzxt.service.ReuserroleService;
import swust.edu.cn.zzxt.service.RoleService;
import swust.edu.cn.zzxt.service.StudentclassService;
import swust.edu.cn.zzxt.service.UserService;

@Controller
@RequestMapping("/academyRoleController")
public class AcademyRoleController {
    private UserService userService;
    private StudentclassService studentclassService;
    private InstitutionService institutionService;
    private InstructorService instructorService;
    private ReuserroleService reuserroleService;
    private List<Studentclass> studentclasses;
    private List<TeacherModal> teacherModals;
    private List<User> allTeacherList;
    private RoleService roleService;

    public RoleService getRoleService() {
        return roleService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    public List<User> getAllTeacherList() {
        return allTeacherList;
    }

    public void setAllTeacherList(List<User> allTeacherList) {
        this.allTeacherList = allTeacherList;
    }

    public List<Studentclass> getStudentclasses() {
        return studentclasses;
    }

    public void setStudentclasses(List<Studentclass> studentclasses) {
        this.studentclasses = studentclasses;
    }

    public ReuserroleService getReuserroleService() {
        return reuserroleService;
    }

    @Autowired
    public void setReuserroleService(ReuserroleService reuserroleService) {
        this.reuserroleService = reuserroleService;
    }

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public StudentclassService getStudentclassService() {
        return studentclassService;
    }

    @Autowired
    public void setStudentclassService(StudentclassService studentclassService) {
        this.studentclassService = studentclassService;
    }

    public InstitutionService getInstitutionService() {
        return institutionService;
    }

    @Autowired
    public void setInstitutionService(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    public InstructorService getInstructorService() {
        return instructorService;
    }

    @Autowired
    public void setInstructorService(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/getInstrator")
    public ModelAndView getInstrator(HttpServletResponse response, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Institution institution = null;
        teacherModals = null;
        studentclasses = null;
        allTeacherList = new ArrayList<User>();
        try {
            // 业务逻辑
            institution = institutionService.findinstitutionByUserInstId(user.getUserInstid());
            teacherModals = instructorService.findTeacherModals(institution.getInstId());
            studentclasses = studentclassService.selectByInstitutionId(institution.getInstId());
            allTeacherList = userService.findAcademyUserTeacher(institution.getInstId());
            map.put("teacher", teacherModals);
            map.put("allTeacherList", allTeacherList);
            map.put("studentclasses", studentclasses);
            map.put("institution", institution);
            map.put("result", Boolean.TRUE);
            map.put("message", "success");
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
    @RequestMapping("/editClass")
    public ModelAndView editClass(int classid, int instid, HttpServletResponse response, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();

        try {
            // 业务逻辑
            studentclassService.updateSelective(classid, instid);
            map.put("result", Boolean.TRUE);
            map.put("message", "success");

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
    @RequestMapping("/showLs")
    public ModelAndView showLs(int roleid, HttpServletResponse response, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<User> laoshi = new ArrayList<User>();

        try {
            // 业务逻辑
            laoshi = userService.findLaoshi(user.getUserInstid(), roleid);
            map.put("laoshi", laoshi);
            map.put("result", Boolean.TRUE);
            map.put("message", "success");

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
    @RequestMapping("/addJb")
    public ModelAndView addJb(int roleid, int userid, HttpServletResponse response, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();

        try {
            // 业务逻辑
            reuserroleService.addReuserrole(roleid, userid);
            map.put("result", Boolean.TRUE);
            map.put("message", "success");

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
    @RequestMapping("/deleteJb")
    public ModelAndView deleteJb(int roleid, int userid, HttpServletResponse response, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();

        try {
            // 业务逻辑
            reuserroleService.deleteReuserrole(roleid, userid);
            map.put("result", Boolean.TRUE);
            map.put("message", "success");

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

    @SuppressWarnings({ "rawtypes", "finally", "unchecked" })
    @RequestMapping("/export1")
    public ModelAndView export1(int majorid, int classid, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Institution institution = institutionService.findinstitutionByUserInstId(user.getUserInstid());
        WritableWorkbook book = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
            String date = sdf.format(System.currentTimeMillis());
            session.setAttribute("DownLoadDate", date);
            String path = request.getSession().getServletContext().getRealPath("upload/instructor" + date+".xls");

            book = Workbook.createWorkbook(new File(path));
            // 生成名为"学生"的工作表，参数0表示这是第一页
            WritableSheet sheet = book.createSheet("代班情况", 0);
            sheet.addCell(new Label(0, 1, "班级"));
            sheet.addCell(new Label(1, 1, "学院"));
            sheet.addCell(new Label(2, 1, "辅导员"));
            int row = 0;
            for (int i = 0; i < studentclasses.size(); ++i) {
                if ((majorid == 0 || majorid == studentclasses.get(i).getClassMajrid())
                        && (classid == 0 || classid == studentclasses.get(i).getClassId())) {
                    sheet.addCell(new Label(0, row + 2, studentclasses.get(i).getClassName()));
                    sheet.addCell(new Label(1, row + 2, institution.getInstName()));
                    for (int j = 0; j < teacherModals.size(); ++j) {
                        if (studentclasses.get(i).getClassInstid() == teacherModals.get(j).getInstid())
                            sheet.addCell(new Label(2, row + 2, teacherModals.get(j).getName()));
                    }
                    ++row;
                }
            }

            // 写入数据并关闭文件
            book.write();
            map.put("result", Boolean.TRUE);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (book != null) {
                try {
                    book.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }

    @RequestMapping(value = "/download1", method = RequestMethod.GET)
    public void downloadFile(int majorid, int classid, String year, String patch, HttpServletRequest request,
            HttpServletResponse response) throws IOException, RowsExceededException, WriteException {
        try {
            // 封装下载
            // path是指欲下载的文件的路径。
            HttpSession session = request.getSession();
            String date = (String)session.getAttribute("DownLoadDate");
            String path = request.getSession().getServletContext().getRealPath("upload/instructor"+date+".xls");

            System.out.println(path);
            File file = new File(path);
            // 取得文件名。
            String filename = file.getName();
            // 取得文件的后缀名。
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings({ "rawtypes", "finally", "unchecked" })
    @RequestMapping("/export2")
    public ModelAndView export2( HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Institution institution = institutionService.findinstitutionByUserInstId(user.getUserInstid());
        WritableWorkbook book = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
            String date = sdf.format(System.currentTimeMillis());
            session.setAttribute("DownLoadDate", date);
            String path = request.getSession().getServletContext().getRealPath("upload/jingban" +date+ ".xls");

            book = Workbook.createWorkbook(new File(path));
            // 生成名为"学生"的工作表，参数0表示这是第一页
            WritableSheet sheet = book.createSheet("经办老师详情", 0);
            sheet.addCell(new Label(0, 1, "职务"));
            sheet.addCell(new Label(1, 1, "学院"));
            sheet.addCell(new Label(2, 1, "经办老师"));
            int row = 0;
            for(int i = 0; i < 10; ++i){
               List<User> laoshi = userService.findLaoshi(user.getUserInstid(), i+3);
               Role role = roleService.findRoleById(i+3);
               sheet.addCell(new Label(0, row + 2, role.getRoleName()));
               sheet.addCell(new Label(1, row + 2, institution.getInstName()));
               String info = "";
               for(int j = 0; j < laoshi.size();++j){
                   info += laoshi.get(j).getUserName()+"，";
               }
               sheet.addCell(new Label(2, row + 2, info));
               ++row;
            }
            // 写入数据并关闭文件
            book.write();
            map.put("result", Boolean.TRUE);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (book != null) {
                try {
                    book.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }
    
    @RequestMapping(value = "/download2", method = RequestMethod.GET)
    public void downloadFile2(HttpServletRequest request,
            HttpServletResponse response) throws IOException, RowsExceededException, WriteException {
        try {
            // 封装下载
            // path是指欲下载的文件的路径。
            HttpSession session = request.getSession();
            String date = (String)session.getAttribute("DownLoadDate");
            String path = request.getSession().getServletContext().getRealPath("upload/jingban"+date+".xls");

            System.out.println(path);
            File file = new File(path);
            // 取得文件名。
            String filename = file.getName();
            // 取得文件的后缀名。
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
