package swust.edu.cn.zzxt.service.impl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swust.edu.cn.zzxt.dao.FunctionMapper;
import swust.edu.cn.zzxt.dao.RerolefunctionMapper;
import swust.edu.cn.zzxt.dao.ReuserroleMapper;
import swust.edu.cn.zzxt.dao.RoleMapper;
import swust.edu.cn.zzxt.model.Function;
import swust.edu.cn.zzxt.model.Rerolefunction;
import swust.edu.cn.zzxt.model.Reuserrole;
import swust.edu.cn.zzxt.model.Role;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.selfmodel.NavigationModel;
import swust.edu.cn.zzxt.service.FunctionService;

@Service("functionService")
public class FunctionServiceImpl implements FunctionService {
	private FunctionMapper functionMapper;
	private ReuserroleMapper reuserroleMapper;
	private RoleMapper roleMapper;
	private RerolefunctionMapper rerolefunctionMapper;

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

	public RerolefunctionMapper getRerolefunctionMapper() {
		return rerolefunctionMapper;
	}

	@Autowired
	public void setRerolefunctionMapper(RerolefunctionMapper rerolefunctionMapper) {
		this.rerolefunctionMapper = rerolefunctionMapper;
	}

	public FunctionMapper getFunctionMapper() {
		return functionMapper;
	}

	@Autowired
	public void setFunctionMapper(FunctionMapper functionMapper) {
		this.functionMapper = functionMapper;
	}

	@SuppressWarnings("finally")
	public List<NavigationModel> findFunListByUser(User user) {
		List<NavigationModel> list=new ArrayList<NavigationModel>();
		try {
			List<Reuserrole> list2=new ArrayList<Reuserrole>();
			list2=reuserroleMapper.selectByUserId(user.getUserId());
			List<Role> list3=new ArrayList<Role>();
			for (int i = 0; i < list2.size(); i++) {
				Role role=roleMapper.selectByPrimaryKey(list2.get(i).getReurRoleid());
				list3.add(role);
			}
			List<Rerolefunction> list4=new ArrayList<Rerolefunction>();
			for (int i = 0; i < list3.size(); i++) {
				List<Rerolefunction> list5=new ArrayList<Rerolefunction>();
				list5=rerolefunctionMapper.selectByRerfRoleid(list3.get(i).getRoleId());
				list4.addAll(list5);
			}
			//这里有重复的问题，需要去重
			List<Function> list6=new ArrayList<Function>();
			for (int i = 0; i < list4.size(); i++) {
				Function function=new Function();
				function=functionMapper.selectByPrimaryKey(list4.get(i).getRerfFuncid());
				list6.add(function);
			}
			//去重
			List<Function> list8 = new ArrayList<Function>();
				for(int i=0;i<list6.size();i++)
				{
					boolean flag=true;
					for(int j=0;j<list8.size();j++)
					{
						if(list6.get(i).getFuncId()==list8.get(j).getFuncId())
						{
							flag = false;
						}
					}
					if(flag == true){
						list8.add(list6.get(i));
					}
				}
				//排序
				List<Function> list9 = new ArrayList<Function>();
				 while(list8.size()!=0)
				 {
					 int min=1000;
					 int k=0;
					 for(int j=0;j<list8.size();j++)
					 {
						 if(min>list8.get(j).getFuncOrdinal())
						 {
							 min = list8.get(j).getFuncOrdinal();
							 k= j;
						 }
					 }
					 list9.add(list8.get(k));
					 list8.remove(list8.get(k));
			      }
			list6.clear();
			list6.addAll(list9);
			for (int i = 0; i < list6.size(); i++) {
				if (list6.get(i).getFuncParentid()==0) {
					NavigationModel navigationModel=new NavigationModel();
					navigationModel.setId(list6.get(i).getFuncId());
					navigationModel.setDescription(list6.get(i).getFuncDescription());
					navigationModel.setName(list6.get(i).getFuncName());
					navigationModel.setOrdinal(list6.get(i).getFuncOrdinal());
					navigationModel.setType(list6.get(i).getFuncType());
					if(list6.get(i).getFuncWorkid()!=null)
					navigationModel.setWorkId(list6.get(i).getFuncWorkid());
					list.add(navigationModel);
				}
			}
			for (int i = 0; i < list.size(); i++) {
				List<Function> list7=new ArrayList<Function>();
				//为每一个大类找下面的子类
				for (int j = 0; j < list6.size(); j++) {
					if (list6.get(j).getFuncParentid()==list.get(i).getId()) {
						boolean flag=true;
						//去除重复的，没有对其进行排序
						for (int k = 0; k < list7.size(); k++) {
							if (list7.get(k).getFuncId()==list6.get(j).getFuncId()) {
								flag=false;
								break;
							}
						}
						if (flag) {
							list7.add(list6.get(j));
						}
					}
				}
				list.get(i).setColumns(list7);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return list;
		}
	}

    @SuppressWarnings("finally")
    public Function findFunctionById(Integer funcId) {
        Function list=new Function();
        try{
            list= functionMapper.selectByPrimaryKey(funcId);           
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            return list;
        }
    }
    
    @SuppressWarnings("finally")
    public List<Function> findAllFunction() {
        List<Function> list= new ArrayList<Function>();
        try{
            list=functionMapper.selectAllfunction();
        }
        catch (Exception e) {
            e.printStackTrace();
        }finally{
            return list;
        }
    }
}
