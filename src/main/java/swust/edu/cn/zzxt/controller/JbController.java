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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import swust.edu.cn.zzxt.model.Student;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.model.Xfjb;
import swust.edu.cn.zzxt.selfmodel.ArticleModel;
import swust.edu.cn.zzxt.selfmodel.StudentTjModel;
import swust.edu.cn.zzxt.selfmodel.XfjbListModel;
import swust.edu.cn.zzxt.selfmodel.XfjbTjModel;
import swust.edu.cn.zzxt.service.AnnouncementService;
import swust.edu.cn.zzxt.service.StudentService;
import swust.edu.cn.zzxt.service.XfjbService;

@Controller
@RequestMapping("/jbController")
public class JbController {
	private XfjbService xfjbService;
    private StudentService studentService;
	public StudentService getStudentService() {
		return studentService;
	}
	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public XfjbService getXfjbService() {
		return xfjbService;
	}

	@Autowired
	public void setXfjbService(XfjbService xfjbService) {
		this.xfjbService = xfjbService;
	}

	private AnnouncementService announcementService;

	public AnnouncementService getAnnouncementService() {
		return announcementService;
	}

	@Autowired
	public void setAnnouncementService(AnnouncementService announcementService) {
		this.announcementService = announcementService;
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/showJbIntroduction")
	public ModelAndView showJbIntroduction(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			ArticleModel articleModel = new ArticleModel();
			articleModel = announcementService.findJbIntroduction();

			map.put("result", Boolean.TRUE);
			map.put("jbIntroduction", articleModel);
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
	@RequestMapping("/showJbWorkArrangement")
	public ModelAndView showJbWorkArrangement( int id, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			ArticleModel articleModel = new ArticleModel();
			articleModel = announcementService.findWorkIntroduction(id);

			map.put("result", Boolean.TRUE);
			map.put("JbWorkArrangement", articleModel);
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
	@RequestMapping("/showAllJbinfo")
	public ModelAndView showAllJbinfo(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		HttpSession session = request.getSession();
		try {
			User user = (User) session.getAttribute("user");
			if (user != null) {
				List<XfjbListModel> AllXfjbList = new ArrayList<XfjbListModel>();
				AllXfjbList = xfjbService.findAllXfjbList(user);
				if (AllXfjbList !=null) {
					int recordCount = AllXfjbList.size();// 总记录数
					int pageCount;// 总页数
					int temp = recordCount % 10;// 10条记录一页
					if (temp == 0) {
						pageCount = recordCount / 10;
					} else {
						pageCount = recordCount / 10 + 1;
					}
					map.put("pageCount", pageCount);
					map.put("result", Boolean.TRUE);
					map.put("AllXfjbList", AllXfjbList);
					map.put("message", "执行成功！");
				} else {
					map.put("result", Boolean.FALSE);
					map.put("message", "无学费奖补数据！");
				}
                map.put("userType", user.getUserType());
			} else {
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
	@RequestMapping("/queryJbByConditions")
	public ModelAndView queryJbByConditions(int colleageId, int majorId, int classId,HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			XfjbListModel xfjbListModel = new XfjbListModel();
			xfjbListModel.setColleageId(colleageId);
			xfjbListModel.setMajorId(majorId);
			xfjbListModel.setClassId(classId);
			List<XfjbListModel> xfjbListModels = new ArrayList<XfjbListModel>();
			xfjbListModels = xfjbService.selectJbByConditions(xfjbListModel);
			if(xfjbListModels!=null){
				int recordCount =xfjbListModels.size();// 总记录数
				int pageCount;// 总页数
				int temp = recordCount % 10;// 10条记录一页
				if (temp == 0) {
					pageCount = recordCount / 10;
				} else {
					pageCount = recordCount / 10 + 1;
				}
				map.put("pageCount", pageCount);
				map.put("result", Boolean.TRUE);
				map.put("message", "查找成功！");
				map.put("xfjbList",xfjbListModels);
			}else{
				map.put("result", Boolean.FALSE);
				map.put("message", "无学费奖补数据！");
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
	@RequestMapping("/downLoadJbByConditions")
	public ModelAndView downLoadJbByConditions(int colleageId, int majorId, int classId,HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			XfjbListModel xfjbListModel = new XfjbListModel();
			xfjbListModel.setColleageId(colleageId);
			xfjbListModel.setMajorId(majorId);
			xfjbListModel.setClassId(classId);
			List<XfjbListModel> xfjbListModels = new ArrayList<XfjbListModel>();
			xfjbListModels = xfjbService.selectJbByConditions(xfjbListModel);
			if(xfjbListModels !=null){
			 //生成EXCEL表格 
			// 设置excel工作表的标题
			String[] title = { "姓名","学号","学院","专业","班级","学费奖补金额","学费奖补获得时间","具体内容"};
			// 输出的excel的路径
			
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
	            String date = sdf.format(System.currentTimeMillis());
	            HttpSession session = request.getSession();
	            session.setAttribute("DownLoadDate", date);
			String filePath = request.getSession().getServletContext()
					.getRealPath("upload/xfjbList"+date+".xls");
			// 创建Excel工作薄
			WritableWorkbook wwb;
			OutputStream os = new FileOutputStream(filePath);
				wwb = Workbook.createWorkbook(os);
			// 添加第一个工作表并设置第一个Sheet的名字
			WritableSheet sheet = wwb.createSheet("学费奖补学生统计表", 0);

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
			sheet.setColumnView(0, 20); 
			sheet.setColumnView(1, 20); 
			sheet.setColumnView(2, 30); 
			sheet.setColumnView(3, 20); 
			sheet.setColumnView(4, 15); 
			sheet.setColumnView(5, 15); 
			sheet.setColumnView(6, 15); 
			sheet.setColumnView(7, 70); 
			Label label;
			for (int i = 0; i < title.length; i++) {
				// Label(x,y,z) 代表单元格的第x+1列，第y+1行, 内容z
				label = new Label(i, 0, title[i], wcf_head);
				sheet.addCell(label);
			}
			//填写数据
			// 姓名
			for (int i = 0; i < xfjbListModels.size(); i++) {
				label = new Label(0, i + 1, xfjbListModels.get(i).getStuName(),
						wcf);
				sheet.addCell(label);
			}
			//学号
			for (int i = 0; i < xfjbListModels.size(); i++) {
				label = new Label(1, i + 1, xfjbListModels.get(i).getStuNumber(),
						wcf);
				sheet.addCell(label);
			}
			//学院
			for (int i = 0; i < xfjbListModels.size(); i++) {
				label = new Label(2, i + 1, xfjbListModels.get(i).getInstName(),
						wcf);
				sheet.addCell(label);
			}
			//专业
			for (int i = 0; i < xfjbListModels.size(); i++) {
				label = new Label(3, i + 1, xfjbListModels.get(i).getMajrName(),
						wcf);
				sheet.addCell(label);
			}
			//班级
			for (int i = 0; i < xfjbListModels.size(); i++) {
				label = new Label(4, i + 1, xfjbListModels.get(i).getClassName(),
						wcf);
				sheet.addCell(label);
			}
			//金额
			for (int i = 0; i < xfjbListModels.size(); i++) {
				label = new Label(5, i + 1, xfjbListModels.get(i).getXfjbAmount(),
						wcf);
				sheet.addCell(label);
			}
			//时间
			for (int i = 0; i < xfjbListModels.size(); i++) {
				label = new Label(6, i + 1, xfjbListModels.get(i).getXfjbTime(),
						wcf);
				sheet.addCell(label);
			}
			//具体内容
			for (int i = 0; i < xfjbListModels.size(); i++) {
				label = new Label(7, i + 1, xfjbListModels.get(i).getXfjbContent(),
						wcf);
				sheet.addCell(label);
			}
			   // 写入数据
			wwb.write();
			// 关闭文件
			wwb.close();
			map.put("result", Boolean.TRUE);
			map.put("message", "查找成功！");
			map.put("xfjbList",xfjbListModels);
			}else{
				map.put("result", Boolean.FALSE);
				map.put("message", "无学费奖补数据！");
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
	@RequestMapping("/selectJbInfoByStuId")
	public ModelAndView selectJbInfoByStuId(int studId, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		try {
			    if(studId!=0){
			    	    Xfjb xfjb =new Xfjb();
					    xfjb = xfjbService.findjbInfoByStuId(studId);
					    Student student = new Student();
					    student = studentService.findStudentByStudId(studId);
					    if(xfjb!=null &&  student!=null ){
					    	map.put("student",student);
					    	map.put("xfjb",xfjb);
					    	map.put("result", Boolean.TRUE);
							map.put("message", "查找成功！");
					    }else{
					    	map.put("result", Boolean.FALSE);
							map.put("message", "无学费奖补详细数据！");
					    }
					
			    }else{
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
	
	@RequestMapping(value="/download",method=RequestMethod.GET)  
    public void downloadFile(Integer id,HttpServletRequest request,
            HttpServletResponse response) throws IOException {
		try {
		    HttpSession session = request.getSession();
            String date = (String)session.getAttribute("DownLoadDate");
		String path=request.getSession().getServletContext().getRealPath("upload/xfjbList"+date+".xls");
     //   System.out.println(path);
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
       // response.reset();
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
	
	@SuppressWarnings({"rawtypes", "finally", "unchecked" })
	@RequestMapping("/countByAcademy")
	public ModelAndView countByAcademy(HttpServletRequest request,HttpServletResponse response){
	        ModelAndView mav = new ModelAndView();
	        MappingJacksonJsonView view = new MappingJacksonJsonView();
	        Map map = new HashMap();
	    	HttpSession session = request.getSession();
	        try {
	        	 User user = (User) session.getAttribute("user");
	        	 List<XfjbTjModel> xfjbTjModels = new ArrayList<XfjbTjModel>();
	        	 xfjbTjModels=xfjbService.findXfjbCountInfo(user);
	            map.put("type", user.getUserType());
	            map.put("xfjbTjModels",xfjbTjModels);
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
