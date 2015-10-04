package swust.edu.cn.zzxt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swust.edu.cn.zzxt.dao.QyshjxjMapper;
import swust.edu.cn.zzxt.model.QyshjxjWithBLOBs;
import swust.edu.cn.zzxt.service.QyshjxjService;

@Service("qyshjxjService")
public class QyshjxjServiceImpl implements QyshjxjService{

    private QyshjxjMapper qyshjxjMapper;
    public QyshjxjMapper getQyshjxjMapper() {
        return qyshjxjMapper;
    }
    @Autowired
    public void setQyshjxjMapper(QyshjxjMapper qyshjxjMapper) {
        this.qyshjxjMapper = qyshjxjMapper;
    }

  
    
    @SuppressWarnings("finally")
    public QyshjxjWithBLOBs showOneQyshjxjByStuID(Integer studId) {
        QyshjxjWithBLOBs qyshjxj = new QyshjxjWithBLOBs();
        try{
            qyshjxj = qyshjxjMapper.selectShjxjByStuId(studId);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            return qyshjxj;
        }
        
    }
}
