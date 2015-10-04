package swust.edu.cn.zzxt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swust.edu.cn.zzxt.dao.ParentMapper;
import swust.edu.cn.zzxt.model.Parent;
import swust.edu.cn.zzxt.service.ParentService;

@Service("parentService")
public class ParentServiceImpl implements ParentService {
    private ParentMapper parentMapper;

    
    public ParentMapper getParentMapper() {
        return parentMapper;
    }
    @Autowired
    public void setParentMapper(ParentMapper parentMapper) {
        this.parentMapper = parentMapper;
    }


    
    @SuppressWarnings("finally")
    public boolean addParent(Parent parent) {
        // TODO Auto-generated method stub
        try {
              parentMapper.insert(parent);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            return true;
        }  
    }
    
    @SuppressWarnings("finally")
    public boolean setParent(Parent parent) {
        // TODO Auto-generated method stub
        try {
              parentMapper.updateByPrimaryKey(parent);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            return true;
        }  
    }
    
    @SuppressWarnings("finally")
    public boolean deleteParent(int pareId){
        // TODO Auto-generated method stub
        try {
              parentMapper.deleteByPrimaryKey(pareId);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            return true;
        }  
    }
    
    
    /*author:赵学融
     * 通过用户名查找信息
     * 2014.7.6*/
    @SuppressWarnings("finally")
    public Parent selectByPrimaryName(String pareName) {
        Parent parent = new Parent();
        try {
             parent = parentMapper.selectByPrimaryName(pareName);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            return parent;
        }      
        
    }
    
    @SuppressWarnings("finally")
    public Parent selectByPareId(int pareId) {
        Parent parent = new Parent();
        try {
             parent = parentMapper.selectByPrimaryKey(pareId);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            return parent;
        }      
        
    }
    
    @SuppressWarnings("finally")
    public List<Parent> getParentsByStuid(int id){
        List<Parent> parents=new ArrayList<Parent>();
        try {
             parents = parentMapper.selectByStuId(id);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            return parents;
        }   
    }
	@SuppressWarnings("finally")
	public List<Parent> selectByStudId(Integer studId) {
		List<Parent> parent = null;
		try {
			parent = parentMapper.selectByStuId(studId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return parent;
		}
		
	}
	@SuppressWarnings("finally")
	public Parent insertParentByStudId(Integer studId, String phoneNumber,
			String fatherName, String fIdNumber) {
		Parent parent = new Parent();
		try {
			String role = "";
			String relation="";
			if(Integer.parseInt(fIdNumber.substring(16, 17)) % 2 == 1){
				 role = "父亲";
				 relation="父子";
			}else{
				role = "母亲";
				relation="母子";
			}
			System.out.println("@@@@@@@@@@@@@截取的字符"+fIdNumber.substring(16, 17));
			parent.setPareStudid(studId);
			parent.setPareName(fatherName);
			parent.setPareIdnumber(fIdNumber);
			parent.setParePhone(phoneNumber);
			parent.setPareRole(role);
			parent.setPareRelation(relation);
			parent.setPareState(null);
			parent.setPareIseditable(null);
			parent = parentMapper.insertParent(parent);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return parent;
		}
		
	}
	@SuppressWarnings("finally")
	public Parent updateBypareId(Integer pareId, Integer studId,String phoneNumber,
			String fatherName, String fIdNumber) {
		Parent parent = new Parent();
		try {
			String role = "";
			String relation="";
			if(Integer.parseInt(fIdNumber.substring(16, 17)) % 2 == 1){
				 role = "父亲";
				 relation="父子";
			}else{
				role = "母亲";
				relation="母子";
			}
			System.out.println("@@@@@@@@@@@@@截取的字符"+fIdNumber.substring(16, 17));
			System.out.println("父亲姓名"+fatherName);
			parent.setPareId(pareId);
			parent.setPareStudid(studId);
			parent.setPareName(fatherName);
			parent.setPareIdnumber(fIdNumber);
			parent.setParePhone(phoneNumber);
			parent.setPareRole(role);
			parent.setPareRelation(relation);
			parent.setPareState(null);
			parent.setPareIseditable(null);
			parent = parentMapper.updateBypareId(parent);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}finally{
			return parent;
		}
		
	}
	
	@SuppressWarnings("finally")
	public boolean updateParent(Parent parent) {
		try {
			parentMapper.updateByPrimaryKeySelective(parent);
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}finally{
			return true;
		}
		
	}
	
	
	
    

}



