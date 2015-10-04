package swust.edu.cn.zzxt.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import swust.edu.cn.zzxt.model.Area;
import swust.edu.cn.zzxt.model.Learning;
import swust.edu.cn.zzxt.model.Major;
import swust.edu.cn.zzxt.model.Parent;
import swust.edu.cn.zzxt.model.Prize;
import swust.edu.cn.zzxt.model.Student;
import swust.edu.cn.zzxt.model.Studentclass;
import swust.edu.cn.zzxt.model.Studentinfo;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.service.InformationService;
import swust.edu.cn.zzxt.service.LearningService;
import swust.edu.cn.zzxt.service.MajorService;
import swust.edu.cn.zzxt.service.ParentService;
import swust.edu.cn.zzxt.service.PrizService;
import swust.edu.cn.zzxt.service.StudentService;
import swust.edu.cn.zzxt.service.StudentclassService;
/**
 * @author pengyan
 * @Title:
 * @ClassName：PkController.java
 * @Package: swust.edu.cn.zzxt.controller
 * @Description: TODO
 * @createDate:2014/08/03 
 * @reviseNote:
 * @version:
 */
@Controller
@RequestMapping("/informationController")
public class InformationController {

    private InformationService informationService;

    public InformationService getInformationService() {
        return informationService;
    }

    @Autowired
    public void setInformationService(InformationService informationService) {
        this.informationService = informationService;
    }

    private StudentService studentService;

    public StudentService getStudentService() {
        return studentService;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
    private ParentService parentService;

    public ParentService getParentService() {
		return parentService;
	}

	@Autowired
	public void setParentService(ParentService parentService) {
		this.parentService = parentService;
	}
	
	 private LearningService learningService;

	    public LearningService getlearningService() {
	        return learningService;
	    }

	    @Autowired
	    public void setlearningService(LearningService learningService) {
	        this.learningService = learningService;
	    }
	    
		private PrizService prizService;
		
		public PrizService getPrizService() {
			return prizService;
		}

		@Autowired
		public void setPrizService(PrizService prizService) {
			this.prizService = prizService;
		}
		private StudentclassService studentclassService;
		private MajorService majorService;

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

	public LearningService getLearningService() {
			return learningService;
		}

		public void setLearningService(LearningService learningService) {
			this.learningService = learningService;
		}

	/*
	 * 添加或者更新一个学生的详细信息 Author pengyan,2014.07.05
	 */
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/addDeatilInformation")
    public ModelAndView addDeatilInformation(String politicState, String bankNumber, String sex, String phone, String QQ,
            String email, String residence, int population, Double allIncomes, String incomeType, String mailCode,
            String department, String areaDeatilHome, String areaDetailOrigin,int areaIdHome,int areaIdOrigin, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            // 业务逻辑
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user.getUserType() == 1) {
                Student student = studentService.findStudentById(user.getUserId());
                int stuId = student.getStudId();
                Studentinfo studentinfo = new Studentinfo();
                studentinfo = informationService.findStudentinfo(student.getStudId());
               
                if( studentinfo==null)
                {            
                informationService.addInformation(stuId, politicState, bankNumber, sex, phone, QQ, email, residence,
                population, allIncomes, incomeType, mailCode, department, areaDeatilHome, areaDetailOrigin,areaIdHome,areaIdOrigin);
                map.put("result", Boolean.TRUE);
                map.put("message", "添加成功！");
                }else{
                    int StinId=studentinfo.getStinId();
                    informationService.updateInformation(StinId,stuId, politicState, bankNumber, sex, phone, QQ, email, residence,
                            population, allIncomes, incomeType, mailCode, department, areaDeatilHome, areaDetailOrigin,areaIdHome,areaIdOrigin);
                    map.put("result", Boolean.TRUE);
                    map.put("message", "修改成功！");
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
    /*
	 * 显示学生的详细信息 Author pengyan,2014.07.05
	 */
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/showDeatilInformation")
    public ModelAndView showDeatilInformation(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            // 业务逻辑
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user.getUserType() != null) {
                    Student student = null;
                    try {
                        student = studentService.findStudentById(user.getUserId());
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {

                    }
                    Studentinfo studentinfo = new Studentinfo();
                    studentinfo = informationService.findStudentinfo(student.getStudId());
                    if (studentinfo!= null) {
                    	 String HomeAddress;
                        Area town=informationService.findAreaByAreaId(studentinfo.getStinAreaidhome());
                        Area county=informationService.findAreaByAreaId(town.getAreaParentid());    
                        Area city=informationService.findAreaByAreaId(county.getAreaParentid());               
                        Area province=informationService.findAreaByAreaId(city.getAreaParentid());   
                        if(studentinfo.getStinAreaidhome()==1){
                        	HomeAddress="未填写";
                        }else{
                        HomeAddress =province.getAreaName()+city.getAreaName()+county.getAreaName()+town.getAreaName()+
                                studentinfo.getStinAreadeatilhome();
                        }
                        map.put("result", Boolean.TRUE);
                        map.put("message", "success");
                        map.put("town", town.getAreaId());
                        map.put("county", county.getAreaId());           
                        map.put("city", city.getAreaId());                    
                        map.put("province", province.getAreaId());                 
                        map.put("studentinfo", studentinfo);
                        map.put("HomeAddress", HomeAddress);
                    
                    } else {
                        map.put("message", "不存在该学生的详细信息！");
                        map.put("result", Boolean.FALSE);
                    }
                
            } else {
                map.put("result", Boolean.FALSE);
                map.put("message", "该用户不存在！");
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
	 * 显示学生的详细信息 Author pengyan,2014.08.06
	 */
    @SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/showStuDeatilInfo")
    public ModelAndView showStuDeatilInfo(HttpServletRequest request, HttpServletResponse response,int stuId) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            // 业务逻辑
                    Studentinfo studentinfo = new Studentinfo();
                    studentinfo = informationService.findStudentinfo(stuId);
                    Student student = new Student();
                    student = studentService.findStudentByStudId(stuId);
            		List<Parent> parents = parentService.getParentsByStuid(stuId);
            		List<Learning> allLearing=learningService.findAllLearning(stuId);
            		List<Prize> prize = prizService.findPrizInfoByStudId(stuId);
            		Studentclass studentClass = new Studentclass();
					Major major = new Major();
					System.out.println("+++++++++++++++++++++++"+student.getStudClassid());
					studentClass = studentclassService
							.selectBystudInfoStudId(student.getStudClassid());
				
					major = majorService.selectByPrimaryKey(studentClass
							.getClassMajrid());
                    if (studentinfo!= null) {
                   	 String HomeAddress;
                     Area town=informationService.findAreaByAreaId(studentinfo.getStinAreaidhome());
                     Area county=informationService.findAreaByAreaId(town.getAreaParentid());    
                     Area city=informationService.findAreaByAreaId(county.getAreaParentid());               
                     Area province=informationService.findAreaByAreaId(city.getAreaParentid());   
                     if(studentinfo.getStinAreaidhome()==1){
                     	HomeAddress="未填写";
                     }else{
                     HomeAddress =province.getAreaName()+city.getAreaName()+county.getAreaName()+town.getAreaName()+
                             studentinfo.getStinAreadeatilhome();
                     }
                        map.put("result", Boolean.TRUE);
                        map.put("message", "success");
                        map.put("studentinfo", studentinfo);
                        map.put("HomeAddress", HomeAddress);
                        map.put("student",student);
                        map.put("prize", prize);
                        map.put("allLearing", allLearing);
                        map.put("parents", parents);
                        map.put("studentClass", studentClass);
    					map.put("major", major);
    					}
                      
                     else {
                        map.put("message", "不存在该学生的详细信息！");
                        map.put("result", Boolean.FALSE);
                    }
                
                
            }catch (Exception e) {
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
	 * 下载检索的学生信息
	 * @param id
	 * @param request
	 * @param response
	 * @throws IOException
	 */
    
	@RequestMapping(value="/download",method=RequestMethod.GET)  
    public void downloadFile(Integer id,HttpServletRequest request,
            HttpServletResponse response) throws IOException {
		try {
		String path=request.getSession().getServletContext().getRealPath("upload/studentList.xls");
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
	

	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
    @RequestMapping("/changeOneState")
    public ModelAndView changeOneState(int prizeState, int parentState, int learningState, int detailState, int stuId, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
        	   // 业务逻辑
        	  Studentinfo studentinfo = new Studentinfo();
              studentinfo = informationService.findStudentinfo(stuId);
            /*  Student student = new Student();
              student = studentService.findStudentByStudId(stuId);*/
        	  List<Prize> prize = prizService.findPrizInfoByStudId(stuId); 
      		  List<Parent> parents = parentService.getParentsByStuid(stuId);
      		  List<Learning> allLearing=learningService.findAllLearning(stuId);
      		 for(int i=0;i<prize.size();i++){
      			prize.get(i).setPrizIseditable(prizeState);
      			prizService.updatePrize(prize.get(i));
      		 }
      		 for(int i=0;i<parents.size();i++){
      			parents.get(i).setPareIseditable(parentState);
      			parentService.updateParent(parents.get(i));
      		 }
      		 for(int i=0;i<allLearing.size();i++){
      			allLearing.get(i).setLearIseditable(learningState);
      			learningService.updateLearning(allLearing.get(i));
      		 }
      		 studentinfo.setStinIseditable(detailState);
      		 informationService.updateStuInfo(studentinfo);
              map.put("result", Boolean.TRUE);
              map.put("message", "success");
                      
   		}          
       catch (Exception e) {
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
