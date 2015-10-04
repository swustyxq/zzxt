package swust.edu.cn.zzxt.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swust.edu.cn.zzxt.dao.RerolefunctionMapper;
import swust.edu.cn.zzxt.model.Rerolefunction;
import swust.edu.cn.zzxt.model.Reuserrole;
import swust.edu.cn.zzxt.service.RerolefunctionService;

@Service("rerolefunctionService")
public class RerolefunctionServiceImpl implements RerolefunctionService{
	private RerolefunctionMapper rerolefunctionMapper;

    public RerolefunctionMapper getRerolefunctionMapper() {
        return rerolefunctionMapper;
    }
    @Autowired
    public void setRerolefunctionMapper(RerolefunctionMapper rerolefunctionMapper) {
        this.rerolefunctionMapper = rerolefunctionMapper;
    }
    
    

    @SuppressWarnings("finally")
    public List<Rerolefunction> findRolefunctionByRoleId(int roleId) {  
        List<Rerolefunction> rerolefunction = new ArrayList<Rerolefunction>();
        try{
            rerolefunction=rerolefunctionMapper.selectByRerfRoleid(roleId);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return rerolefunction;
        }
    }
}
	
  /*  @SuppressWarnings("finally")
    public Learning obtainLearningByStudid(Integer learStudid) {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return ;
        }
    }

}*/
