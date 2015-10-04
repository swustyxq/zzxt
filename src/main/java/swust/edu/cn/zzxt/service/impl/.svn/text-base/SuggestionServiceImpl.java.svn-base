package swust.edu.cn.zzxt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swust.edu.cn.zzxt.dao.SuggestionMapper;
import swust.edu.cn.zzxt.model.Suggestion;
import swust.edu.cn.zzxt.service.SuggestionService;

@Service("suggestionService")
public class SuggestionServiceImpl implements SuggestionService{
	private SuggestionMapper suggestionMapper;
	public SuggestionMapper getSuggestionMapper() {
		return suggestionMapper;
	}
	@Autowired
	public void setSuggestionMapper(SuggestionMapper suggestionMapper) {
		this.suggestionMapper = suggestionMapper;
	}
	@SuppressWarnings("finally")
	public int addOneRecord(Suggestion suggestion){
		int success = 0;
		try {
			suggestionMapper.insertSelective(suggestion);
			success=1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			return success;
		}
	}
}
