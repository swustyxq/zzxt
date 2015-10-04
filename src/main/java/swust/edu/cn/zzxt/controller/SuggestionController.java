package swust.edu.cn.zzxt.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;





import swust.edu.cn.zzxt.model.Suggestion;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.service.SuggestionService;

@Controller
@RequestMapping("/suggestionController")
public class SuggestionController {
	private SuggestionService suggestionService;
	public SuggestionService getSuggestionService() {
		return suggestionService;
	}
	@Autowired
	public void setSuggestionService(SuggestionService suggestionService) {
		this.suggestionService = suggestionService;
	}
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/publishSuggestion")
	public ModelAndView publishSuggestion(String content,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		User user = new User();
		HttpSession session = request.getSession();// 获取session
		try {
			Suggestion suggestion = new Suggestion();
			user = (User)session.getAttribute("user");
			Date date = new Date();
			Timestamp ts = new Timestamp(date.getTime());
			suggestion.setSuggTime(ts);
			suggestion.setSuggUserId(user.getUserId());
			suggestion.setSuggContent(content);
			int success=suggestionService.addOneRecord(suggestion);
			map.put("success", success);
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
}
