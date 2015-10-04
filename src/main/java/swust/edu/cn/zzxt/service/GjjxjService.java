package swust.edu.cn.zzxt.service;

import swust.edu.cn.zzxt.model.Gjjxj;
import swust.edu.cn.zzxt.model.GjjxjWithBLOBs;

public interface GjjxjService {

    public GjjxjWithBLOBs obtainGjjxjWithBLOBSByStudid(Integer gjxjStudid);
    
    public GjjxjWithBLOBs selectByPrimaryKey(Integer gjxjId);

    public Gjjxj obtainGjjxjByStudid(Integer gjxjStudid);
    
    public void insert(GjjxjWithBLOBs gjjxj);
    
    public void update(GjjxjWithBLOBs gjjxj);
    
    
}
