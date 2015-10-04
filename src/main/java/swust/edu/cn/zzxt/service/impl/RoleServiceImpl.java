package swust.edu.cn.zzxt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swust.edu.cn.zzxt.dao.FunctionMapper;
import swust.edu.cn.zzxt.dao.RerolefunctionMapper;
import swust.edu.cn.zzxt.dao.ReuserroleMapper;
import swust.edu.cn.zzxt.dao.RoleMapper;
import swust.edu.cn.zzxt.model.Reuserrole;
import swust.edu.cn.zzxt.model.Role;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.selfmodel.AuthorityTopLevelModel;
import swust.edu.cn.zzxt.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService{
	private RoleMapper roleMapper;
	private ReuserroleMapper reuserroleMapper;
	private FunctionMapper functionMapper;
	private RerolefunctionMapper rerolefunctionMapper;
	
	public FunctionMapper getFunctionMapper() {
		return functionMapper;
	}
	
	@Autowired
	public void setFunctionMapper(FunctionMapper functionMapper) {
		this.functionMapper = functionMapper;
	}
	
	public RerolefunctionMapper getRerolefunctionMapper() {
		return rerolefunctionMapper;
	}
	
	@Autowired
	public void setRerolefunctionMapper(RerolefunctionMapper rerolefunctionMapper) {
		this.rerolefunctionMapper = rerolefunctionMapper;
	}
	
	public ReuserroleMapper getReuserroleMapper() {
		return reuserroleMapper;
	}
	@Autowired
	public void setReuserroleMapper(ReuserroleMapper reuserroleMapper) {
		this.reuserroleMapper = reuserroleMapper;
	}

	public RoleMapper getRoleMapper() {
		return roleMapper;
	}
	
	@Autowired
	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}

	@SuppressWarnings("finally")
	public List<Role> findRolesByUser(User user) {
		List<Role> list1 = new ArrayList<Role>();
		try {

			List<Reuserrole> list = new ArrayList<Reuserrole>();
			list = reuserroleMapper.selectByUserId(user.getUserId());
			for(int i=0;i<list.size();i++)
			{
				Role role = new Role();
				role = roleMapper.selectByPrimaryKey(list.get(i).getReurRoleid());
				list1.add(role);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
		return list1;
		}
	}

    @SuppressWarnings("finally")
    public Role findRoleById(Integer reurRoleid) {
        Role list = new Role();
        try{
            list=roleMapper.selectByPrimaryKey(reurRoleid);            
        }catch (Exception e) {
            e.printStackTrace();
        }finally
        {
        return list;
    }
	}
    @SuppressWarnings("finally")
    public List<Role> findAllRole() {
        List<Role> list = new ArrayList<Role>();
        try {
            list = roleMapper.selectAllRole();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return list;
        }
    }
    
	public List<AuthorityTopLevelModel> findRoleFunctions() {
		List<AuthorityTopLevelModel> list=new ArrayList<AuthorityTopLevelModel>();
		try {
			List<Role> list2=new  ArrayList<Role>();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return list;
		}
	}
}
