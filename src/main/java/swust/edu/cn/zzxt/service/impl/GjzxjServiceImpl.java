package swust.edu.cn.zzxt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swust.edu.cn.zzxt.dao.GjzxjMapper;
import swust.edu.cn.zzxt.model.GjzxjWithBLOBs;
import swust.edu.cn.zzxt.service.GjzxjService;

@Service("gjzxjService")
public class GjzxjServiceImpl implements GjzxjService {
    private GjzxjMapper gjzxjMapper;

    public GjzxjMapper getGjzxjMapper() {
        return gjzxjMapper;
    }

    @Autowired
    public void setGjzxjMapper(GjzxjMapper gjzxjMapper) {
        this.gjzxjMapper = gjzxjMapper;
    }

    @SuppressWarnings("finally")
    public GjzxjWithBLOBs findGjzxjWithBLOBsByStuId(int stuId){
        GjzxjWithBLOBs gjzxjWithBLOBs = new GjzxjWithBLOBs();
        try {
            if(gjzxjMapper.selectByStuId(stuId).size()>0)
            gjzxjWithBLOBs = gjzxjMapper.selectByStuId(stuId).get(0);
            else gjzxjWithBLOBs = null;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            return gjzxjWithBLOBs;
        }
    }
    
    @SuppressWarnings("finally")
    public int AddOrModifyGjzxj(GjzxjWithBLOBs gjzxjWithBLOBs) {
        try {
            // TODO Auto-generated method stub
            if (gjzxjMapper.selectByStuId(gjzxjWithBLOBs.getGzxjStudid()).size() > 0) {
                GjzxjWithBLOBs temp=gjzxjMapper.selectByStuId(gjzxjWithBLOBs.getGzxjStudid()).get(0);
                gjzxjWithBLOBs.setGzxjId(temp.getGzxjId());
                int result = gjzxjMapper.updateByPrimaryKeyWithBLOBs(gjzxjWithBLOBs);
                System.out.println(gjzxjWithBLOBs.getGzxjAllincomes());
                System.out.println(result+"+++++++++++++11");
                return 0;
            } else {
                System.out.println("insert");
                gjzxjMapper.insert(gjzxjWithBLOBs);
                return 1;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            return 2;
        }
    }
    @SuppressWarnings("finally")
    public GjzxjWithBLOBs findGjzxjWithBLObsById(int id){
        GjzxjWithBLOBs gjzxjWithBLOBs = new GjzxjWithBLOBs();
        try {
            gjzxjWithBLOBs = gjzxjMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            return gjzxjWithBLOBs;
        }
    }
    @SuppressWarnings("finally")
    public void auditGjzxj(GjzxjWithBLOBs gjzxjWithBLOBs){
        try {
            gjzxjMapper.updateByPrimaryKeySelective(gjzxjWithBLOBs);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            return;
        }
    }
}
