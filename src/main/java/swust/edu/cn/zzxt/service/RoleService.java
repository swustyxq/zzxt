package swust.edu.cn.zzxt.service;

import java.util.List;

import swust.edu.cn.zzxt.model.Role;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.selfmodel.AuthorityTopLevelModel;

public interface RoleService {
	public List<Role> findRolesByUser(User user);

    public Role findRoleById(Integer reurRoleid);

    public List<Role> findAllRole();

    List<AuthorityTopLevelModel> findRoleFunctions();
}

