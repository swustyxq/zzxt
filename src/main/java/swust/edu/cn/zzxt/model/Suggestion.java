package swust.edu.cn.zzxt.model;

import java.sql.Timestamp;

public class Suggestion {
    private Integer suggId;
    private Integer suggUserId;
    private String suggContent;
    private Timestamp suggTime;
	public Integer getSuggId() {
		return suggId;
	}
	public void setSuggId(Integer suggId) {
		this.suggId = suggId;
	}
	public Integer getSuggUserId() {
		return suggUserId;
	}
	public void setSuggUserId(Integer suggUserId) {
		this.suggUserId = suggUserId;
	}
	public String getSuggContent() {
		return suggContent;
	}
	public void setSuggContent(String suggContent) {
		this.suggContent = suggContent;
	}
	public Timestamp getSuggTime() {
		return suggTime;
	}
	public void setSuggTime(Timestamp suggTime) {
		this.suggTime = suggTime;
	}
}