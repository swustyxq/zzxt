package swust.edu.cn.zzxt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swust.edu.cn.zzxt.dao.ReuserroleMapper;
import swust.edu.cn.zzxt.dao.UserMapper;
import swust.edu.cn.zzxt.model.Reuserrole;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.service.ReuserroleService;

@Service("reuserroleService")
public class ReuserroleServiceImpl implements ReuserroleService {
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    private ReuserroleMapper reuserroleMapper;

    public ReuserroleMapper getReuserroleMapper() {
        return reuserroleMapper;
    }

    @Autowired
    public void setReuserroleMapper(ReuserroleMapper reuserroleMapper) {
        this.reuserroleMapper = reuserroleMapper;
    }

    @SuppressWarnings("finally")
    public List<Reuserrole> findReuserroleByUserId(int instUserId) {
        List<Reuserrole> reuserrole = new ArrayList<Reuserrole>();
        try {
            reuserrole = reuserroleMapper.selectByUserId(instUserId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return reuserrole;
        }
    }

    @SuppressWarnings("finally")
    public void addReuserrole(int roleid, int userid) {
        Reuserrole reuserrole = new Reuserrole();
        User user = new User();
        user.setUserId(userid);
        user.setUserType(3);
        try {
            List<Reuserrole> temp = reuserroleMapper.selectByUserId(userid);
            boolean flag = true;
            for (int i = 0; i < temp.size(); ++i) {
                if (temp.get(i).getReurRoleid() == roleid)
                    flag = false;
            }
            if (flag) {
                reuserrole.setReurRoleid(roleid);
                reuserrole.setReurUserid(userid);
                reuserroleMapper.insert(reuserrole);
            }
            userMapper.updateByPrimaryKeySelective(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return;
        }
    }

    @SuppressWarnings("finally")
    public void deleteReuserrole(int roleid, int userid) {
        int reurId = -1;
        User user = new User();
        user.setUserId(userid);
        user.setUserType(2);
        try {
            List<Reuserrole> temp = reuserroleMapper.selectByUserId(userid);
            boolean flag = false;
            for (int i = 0; i < temp.size(); ++i) {
                if (temp.get(i).getReurRoleid() == roleid)
                    reurId = temp.get(i).getReurId();
                else{
                    if(temp.get(i).getReurRoleid()>2)
                        flag = true;
                }
            }
            if (reurId != -1) {
                reuserroleMapper.deleteByPrimaryKey(reurId);
            }
            if (!flag){
                userMapper.updateByPrimaryKeySelective(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return;
        }
    }

    @SuppressWarnings("finally")
    public List<Reuserrole> findReuserroleById(int UserId) {
        List<Reuserrole> reuserrole = new ArrayList<Reuserrole>();
        try {
            reuserrole = reuserroleMapper.selectByUserId(UserId);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return reuserrole;
        }
    }

    @SuppressWarnings("finally")
    public void addaReuserrole(int userId, int roleId) {
        Reuserrole reuserrole = new Reuserrole();
        try {
            reuserrole.setReurRoleid(roleId);
            reuserrole.setReurUserid(userId);
            Reuserrole list = reuserroleMapper.selectByUserAndRole(reuserrole);
            if (list == null) {
                reuserroleMapper.insert(reuserrole);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return;
        }

    }

    @SuppressWarnings("finally")
    public void deleteaReuserrole(int userId, int roleId) {
        Reuserrole reuserrole = new Reuserrole();
        try {
            reuserrole.setReurRoleid(roleId);
            reuserrole.setReurUserid(userId);
            Reuserrole list = reuserroleMapper.selectByUserAndRole(reuserrole);
            if (list != null) {
                reuserroleMapper.deleteByPrimaryKey(list.getReurId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return;
        }
    }
}
