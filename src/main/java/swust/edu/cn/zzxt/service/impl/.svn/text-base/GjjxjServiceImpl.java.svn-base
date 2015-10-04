package swust.edu.cn.zzxt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swust.edu.cn.zzxt.dao.GjjxjMapper;
import swust.edu.cn.zzxt.model.Gjjxj;
import swust.edu.cn.zzxt.model.GjjxjWithBLOBs;
import swust.edu.cn.zzxt.service.GjjxjService;
@Service("gjjxjService")
public class GjjxjServiceImpl implements GjjxjService{
    private GjjxjMapper gjjxjMapper;
    
    public GjjxjMapper getStudentMapper() {
        return gjjxjMapper;
    }
    
    @Autowired
    public void setGjjxjMapper(GjjxjMapper gjjxjMapper) {
        this.gjjxjMapper = gjjxjMapper;
    }   

    
    @SuppressWarnings("finally")
    public GjjxjWithBLOBs obtainGjjxjWithBLOBSByStudid(Integer gjxjStudid) {
        GjjxjWithBLOBs gjjxj=new GjjxjWithBLOBs();
        try {
            gjjxj = gjjxjMapper.selectByStudid(gjxjStudid).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return gjjxj;
        }
    }
    
    @SuppressWarnings("finally")
    public GjjxjWithBLOBs selectByPrimaryKey(Integer gjxjId) {
        GjjxjWithBLOBs gjjxj=new GjjxjWithBLOBs();
        try {
            gjjxj = gjjxjMapper.selectByPrimaryKey(gjxjId);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return gjjxj;
        }
    }


    @SuppressWarnings("finally")
    public Gjjxj obtainGjjxjByStudid(Integer gjxjStudid) {
        Gjjxj gjjxj=new Gjjxj();
        try {
            gjjxj = gjjxjMapper.selectGjjxjByStudid(gjxjStudid);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return gjjxj;
        }
    }
    
    @SuppressWarnings("finally")
    public void insert(GjjxjWithBLOBs gjjxj) {
        try {
            gjjxjMapper.insert(gjjxj);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return;
        }
    }
    
    @SuppressWarnings("finally")
    public void update(GjjxjWithBLOBs gjjxj) {
        try {
            gjjxjMapper.updateByPrimaryKeySelective(gjjxj);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return;
        }
    }
}
