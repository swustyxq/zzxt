package swust.edu.cn.zzxt.service;


import swust.edu.cn.zzxt.model.GjzxjWithBLOBs;

public interface GjzxjService {
    public int AddOrModifyGjzxj(GjzxjWithBLOBs gjzxjWithBLOBs); 
    public GjzxjWithBLOBs findGjzxjWithBLOBsByStuId(int stuId); 
    public GjzxjWithBLOBs findGjzxjWithBLObsById(int id);
    public void auditGjzxj(GjzxjWithBLOBs gjzxjWithBLOBs);
}
