package swust.edu.cn.zzxt.service;

import java.util.List;

import swust.edu.cn.zzxt.model.Parent;


public interface ParentService {
    
    public boolean addParent(Parent parent);
    public boolean setParent(Parent parent);
    public boolean deleteParent(int pareId);
    public Parent selectByPrimaryName(String pareName);
    public Parent selectByPareId(int pareId);
    public List<Parent> getParentsByStuid(int id);
	public List<Parent> selectByStudId(Integer studId);
	
	public Parent insertParentByStudId(Integer studId, String phoneNumber,
			String fatherName, String fIdNumber);
	public Parent updateBypareId(Integer pareId,Integer studId, String phoneNumber,
			String fatherName, String fIdNumber);
	public boolean updateParent(Parent parent);
    
}

