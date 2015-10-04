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

import swust.edu.cn.zzxt.model.GjlzjxjWithBLOBs;
import swust.edu.cn.zzxt.model.Reward;
import swust.edu.cn.zzxt.model.Student;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.service.GjlzjxjWithBLOBsService;
import swust.edu.cn.zzxt.service.PrizService;
import swust.edu.cn.zzxt.service.RewardService;
import swust.edu.cn.zzxt.service.StudentService;

@Controller
@RequestMapping("/rewardController")
public class RewardController {		
	private RewardService rewardService;
	private StudentService studentService;	
	private PrizService prizeService;
	private GjlzjxjWithBLOBsService gjlzjxjwithblobsService;
	
	public StudentService getStudentService() {
		return studentService;
	}
	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public GjlzjxjWithBLOBsService getGjlzjxjwithblobsService() {
		return gjlzjxjwithblobsService;
	}
	@Autowired
	public void setGjlzjxjwithblobsService(
			GjlzjxjWithBLOBsService gjlzjxjwithblobsService) {
		this.gjlzjxjwithblobsService = gjlzjxjwithblobsService;
	}
	
	public RewardService getRewardService() {
		return rewardService;
	}

	@Autowired
	public void setRewardService(RewardService rewardService) {
		this.rewardService = rewardService;
	}

	public PrizService getPrizeService() {
		return prizeService;
	}

	@Autowired
	public void setPrizeService(PrizService prizeService) {
		this.prizeService = prizeService;
	}
	/**
     * @Title: inputStudRewaInfo rewardController
     * @Description: 更新和插入获奖情况  w jian
     * @param @param request
     * @param @param response
     * @param @param 
     * @param @return
     * @param @throws Exception
     * @return ModelAndView
     * @throws
     */
	

	
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/inputStudRewaInfo")
	public ModelAndView InputStudRewaInfo(Integer studId,String rewrTime1,String rewrName1,String rewrAwarded1,String rewrTime2,String rewrName2,String rewrAwarded2,
			String rewrTime3,String rewrName3,String rewrAwarded3,String rewrTime4,String rewrName4,String rewrAwarded4,HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		HttpSession session = request.getSession();
		try {
			User user = new User();
			user = (User) session.getAttribute("user");
			if(session.getAttribute("user")==null){
				
				map.put("result", Boolean.FALSE);
				map.put("message", "用户已经退出！请重新登录");
			}else{
				Student student = new Student();
				GjlzjxjWithBLOBs gjlzjxjwithblobs = new GjlzjxjWithBLOBs();
				List<Reward> reward = new ArrayList<Reward>();
				Reward reward1 = new Reward();
				Reward reward2 = new Reward();
				Reward reward3 = new Reward();
				Reward reward4 = new Reward();
				if(studId == 0){
					student = studentService.selectInfoByUser(user.getUserId());
				}else{
					student = studentService.findStudentByStudId(studId);
				}
				gjlzjxjwithblobs = gjlzjxjwithblobsService.selectByStudid(student.getStudId());
				reward = rewardService.findRewardsByWorkId(gjlzjxjwithblobs.getGjlzWorkid(),gjlzjxjwithblobs.getGjlzId().toString());
				if(reward==null){
					reward1 = rewardService.inputRewardByWAW(gjlzjxjwithblobs.getGjlzWorkid(),gjlzjxjwithblobs.getGjlzId(),rewrTime1,rewrName1,rewrAwarded1);
					reward2 = rewardService.inputRewardByWAW(gjlzjxjwithblobs.getGjlzWorkid(),gjlzjxjwithblobs.getGjlzId(),rewrTime2,rewrName2,rewrAwarded2);
					reward3 = rewardService.inputRewardByWAW(gjlzjxjwithblobs.getGjlzWorkid(),gjlzjxjwithblobs.getGjlzId(),rewrTime3,rewrName3,rewrAwarded3);
					reward4 = rewardService.inputRewardByWAW(gjlzjxjwithblobs.getGjlzWorkid(),gjlzjxjwithblobs.getGjlzId(),rewrTime4,rewrName4,rewrAwarded4);
				}else{
					//此处写更新
				}
				map.put("result", Boolean.TRUE);
			    map.put("message", "success！");
			    map.put("reward1", reward1);
			    map.put("reward2", reward2);
			    map.put("reward3", reward3);
			    map.put("reward4", reward4);
			}
		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
            map.put("message", "执行出现出错！");
            e.printStackTrace();
		}
		finally{
			view.setAttributesMap(map);
            mav.setView(view);
			return mav;
		}
	}	
}
