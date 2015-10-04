package swust.edu.cn.zzxt.selfmodel;

import java.util.List;

public class UserAuthorityModel {
	private String	name;//大类的名称
	private List<AuthorityModel> listAuthority;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<AuthorityModel> getListAuthority() {
		return listAuthority;
	}
	public void setListAuthority(List<AuthorityModel> listAuthority) {
		this.listAuthority = listAuthority;
	}
	
}
