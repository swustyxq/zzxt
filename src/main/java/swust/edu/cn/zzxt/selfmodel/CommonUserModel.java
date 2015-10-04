package swust.edu.cn.zzxt.selfmodel;

import java.util.List;

public class CommonUserModel {
	private String username;
	private String role;
	private List<UserAuthorityModel> listUserAuthorityModel;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<UserAuthorityModel> getListUserAuthorityModel() {
		return listUserAuthorityModel;
	}
	public void setListUserAuthorityModel(
			List<UserAuthorityModel> listUserAuthorityModel) {
		this.listUserAuthorityModel = listUserAuthorityModel;
	}
}
