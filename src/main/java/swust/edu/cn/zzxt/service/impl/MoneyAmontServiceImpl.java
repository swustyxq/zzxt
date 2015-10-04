package swust.edu.cn.zzxt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swust.edu.cn.zzxt.dao.WorkinstitutiontemoneyamountMapper;
import swust.edu.cn.zzxt.model.Reward;
import swust.edu.cn.zzxt.model.Workinstitutiontemoneyamount;
import swust.edu.cn.zzxt.service.MoneyAmontService;

@Service("MoneyAmontService")
public class MoneyAmontServiceImpl implements MoneyAmontService {
    private WorkinstitutiontemoneyamountMapper wismMapper;

    public WorkinstitutiontemoneyamountMapper getWismMapper() {
        return wismMapper;
    }

    @Autowired
    public void setWismMapper(WorkinstitutiontemoneyamountMapper wismMapper) {

        this.wismMapper = wismMapper;
    }

    @SuppressWarnings("finally")
    public Workinstitutiontemoneyamount selectWorkinstitutiontemoneyamount(int workid, int instid) {
        // TODO Auto-generated method stub
        Workinstitutiontemoneyamount wism = new Workinstitutiontemoneyamount();
        try {
            Workinstitutiontemoneyamount temp = new Workinstitutiontemoneyamount();
            temp.setWimaWorkid(workid);
            temp.setWimaInstitutionid(instid);
            wism = wismMapper.selectByInstAndWork(temp);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            return wism;
        }
        
    }

    @SuppressWarnings("finally")
    public boolean update(Workinstitutiontemoneyamount reward) {
        // TODO Auto-generated method stub
        try {
            wismMapper.updateByPrimaryKeySelective(reward);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            return true;
        }
        
        
    }

}
