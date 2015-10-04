package swust.edu.cn.zzxt.service;

import java.util.List;

import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.selfmodel.CommonUserModel;

public interface UserService {
	public User findUserById(int id);
	public User findUserByNAP(String loginname,String password);
	public CommonUserModel findUserCommonInfo(User user);
	public  void EditInfoByUserId(int userId,String password );
	List<User> findUsersByUserIsDelete(int userIsdelete );
	public void deleteByUserId(int userId);
	public User findUserInfoByUserId(int userId);
	public void editUserInfoByUserId(int userId,String userName,int userInstid,String userLoginname,String userPassword,int userType);
	public void addUser(String userName,int userInstid,String userLoginname,String userPassword,int userType);
    public List<User> findUserByInstId(int instId);
    public List<User> findAcademyUserTeacher(int instId);
    
    public List<User> findLaoshi(int instid,int roleid);
    
//    public List<User> findStuUserByTj(int academyid,int majorid,int classid);
}
