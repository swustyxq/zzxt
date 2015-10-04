package swust.edu.cn.zzxt.dao;

import java.util.List;

import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.selfmodel.TiaoJianModal;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> findUserByNAP(User user);

    List<User> findUsersByUserIsDelete(int userIsdelete);

    List<User> selectByInstId(int instId);
   
    List<User> selectByInstIdAndType(User user);
    
    List<User> selectTeacher(int instId);
    
    List<User> selectLaoshi(TiaoJianModal tj);
    
    List<User> selectStuUserByClassId(int classid);
    
    List<User> selectStuUserByMajorId(int majorid);
    
    List<User> selectStuUserByInstId(int instid);
}