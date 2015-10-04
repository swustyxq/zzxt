package swust.edu.cn.zzxt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swust.edu.cn.zzxt.dao.UserMapper;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.selfmodel.CommonUserModel;
import swust.edu.cn.zzxt.selfmodel.TiaoJianModal;
import swust.edu.cn.zzxt.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @SuppressWarnings("finally")
    public User findUserById(int id) {
        User user = new User();
        try {
            user = userMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return user;
        }
    }

    @SuppressWarnings("finally")
    public User findUserByNAP(String loginname, String password) {
        User user = new User();
        try {
            User user1 = new User();
            user1.setUserLoginname(loginname);
            user1.setUserPassword(password);
            List<User> list = userMapper.findUserByNAP(user1);
            if (list.size() > 0) {
                user = list.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return user;
        }
    }

    @SuppressWarnings("finally")
    public CommonUserModel findUserCommonInfo(User user) {
        CommonUserModel commonUserModel = new CommonUserModel();
        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return commonUserModel;
        }
    }

    @SuppressWarnings("finally")
    public void EditInfoByUserId(int userId, String password) {
        User user = new User();
        try {
            user = userMapper.selectByPrimaryKey(userId);
            user.setUserPassword(password);
            userMapper.updateByPrimaryKeySelective(user);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            return;
        }

    }

    @SuppressWarnings("finally")
    public List<User> findUsersByUserIsDelete(int userIsdelete) {
        List<User> list = null;
        try {
            list = new ArrayList<User>();
            list = userMapper.findUsersByUserIsDelete(userIsdelete);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return list;
        }
    }

    @SuppressWarnings("finally")
    public void deleteByUserId(int userId) {
        User user = new User();
        try {
            user = userMapper.selectByPrimaryKey(userId);
            user.setUserIsdelete(1);
            userMapper.updateByPrimaryKeySelective(user);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            return;
        }
    }

    @SuppressWarnings("finally")
    public User findUserInfoByUserId(int userId) {
        User user = new User();
        try {
            user = userMapper.selectByPrimaryKey(userId);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            return user;
        }
    }

    @SuppressWarnings("finally")
    public void editUserInfoByUserId(int userId, String userName, int userInstid, String userLoginname,
            String userPassword, int userType) {
        User user = new User();
        try {
            user = userMapper.selectByPrimaryKey(userId);
            user.setUserName(userName);
            user.setUserInstid(userInstid);
            user.setUserLoginname(userLoginname);
            user.setUserPassword(userPassword);
            user.setUserType(userType);
            userMapper.updateByPrimaryKeySelective(user);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return;
        }
    }

    @SuppressWarnings("finally")
    public void addUser(String userName, int userInstid, String userLoginname, String userPassword, int userType) {

        User user = new User();
        try {

            user.setUserName(userName);
            user.setUserInstid(userInstid);
            user.setUserLoginname(userLoginname);
            user.setUserPassword(userPassword);
            user.setUserType(userType);
            user.setUserIsdelete(0);
            userMapper.insert(user);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return;
        }

    }

    @SuppressWarnings("finally")
    public List<User> findUserByInstId(int instId) {
        List<User> users = new ArrayList<User>();
        try {
            users = userMapper.selectByInstId(instId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return users;
        }
    }

    @SuppressWarnings("finally")
    public List<User> findAcademyUserTeacher(int instId) {
        List<User> users = new ArrayList<User>();
        try {
            users = userMapper.selectTeacher(instId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return users;
        }
    }

    @SuppressWarnings("finally")
    public List<User> findLaoshi(int instid, int roleid) {
        List<User> users = null;
        TiaoJianModal tJianModal = new TiaoJianModal();
        try {
            tJianModal.setInstid(instid);
            tJianModal.setRoleid(roleid);
            users = userMapper.selectLaoshi(tJianModal);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return users;
        }
    }

//    @SuppressWarnings("finally")
//    public List<User> findStuUserByTj(int academyid, int majorid, int classid) {
//        List<User> users = null;
//        try {
//            if (academyid != 0) {
//                if (majorid != 0) {
//                    if (classid != 0)
//                        users = userMapper.selectStuUserByClassId(classid);
//                    else {
//                        users = userMapper.selectStuUserByMajorId(majorid);
//                    }
//                }else {
//                    users = userMapper.selectStuUserByInstId(academyid);
//                }
//            } else {
//                users = userMapper.selectStuUserByInstId(academyid);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            return users;
//        }
//    }
}
