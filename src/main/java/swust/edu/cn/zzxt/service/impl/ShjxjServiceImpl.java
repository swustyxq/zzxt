package swust.edu.cn.zzxt.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swust.edu.cn.zzxt.dao.ShjxjMapper;
import swust.edu.cn.zzxt.model.ShjxjWithBLOBs;
import swust.edu.cn.zzxt.service.ShjxjService;

@Service("shjxjService")
public class ShjxjServiceImpl implements ShjxjService{
private ShjxjMapper shjxjMapper;
	
	public ShjxjMapper getShjxjMapper() {
		return shjxjMapper;
	}

	@Autowired
	public void setShjxjMapper(ShjxjMapper shjxjMapper) {
		this.shjxjMapper = shjxjMapper;
	}
	
	@SuppressWarnings("finally")
    public int addOneStudShjxj(String sjBankNumber, String sjIspoor, String sjPoorRank, String sjInstructor,
            String sjInstrPhone, String sjStuDepartmentPhone, String sjPrizeSitu, String sjApplyReason,
            int sjReasonYear, int sjReasonMonth, 
            int sjReasonDay,int stuID,int WsflId,Boolean first){
	    ShjxjWithBLOBs shjxj = new ShjxjWithBLOBs();
	    try{
	        shjxj.setSjxjBanknumber(sjBankNumber);
	        shjxj.setSjxjIspoor(sjIspoor);
	        System.out.println(sjIspoor);
	        System.out.println(sjPoorRank);
	        if (sjIspoor.equals("是")){
	            System.out.println(sjPoorRank);
	            shjxj.setSjxjPoorrank(sjPoorRank);
	            System.out.println(shjxj.getSjxjPoorrank());
	        }
	        shjxj.setSjxjInstructor(sjInstructor);
	        shjxj.setSjxjInstructorcall(sjInstrPhone);
	        shjxj.setSjxjInstructorphone(sjStuDepartmentPhone);
	        shjxj.setSjxjAwards(sjPrizeSitu);
	        shjxj.setSjxjApplyreason(sjApplyReason);
	        SimpleDateFormat dateformat =   
	                new SimpleDateFormat("yyyy-MM-dd"); 
	        String date1 = sjReasonYear + "-" + sjReasonMonth + "-" + sjReasonDay;
	        Date date = dateformat.parse(date1);
	        shjxj.setSjxjApplytime(date);
	        shjxj.setSjxjState(0);//审核全部通过，才能为1
	        String annualString="";
	        if (sjReasonMonth >= 8 && sjReasonMonth <= 2){
	            annualString += sjReasonYear + "-" +sjReasonYear+1;
	        }else{
	            annualString += sjReasonYear-1 + "-" +sjReasonYear;
	        }
	        shjxj.setSjxjAnnual(annualString);
	        shjxj.setSjxjWorkid(8);//固定为社会奖学金申请
	        shjxj.setSjxjWsflid(WsflId);
	        shjxj.setSjxjSjtpid(1);//需修改：应该通过奖学金名字去社会奖学金类型里面去找到相应的id？
	        shjxj.setSjxjStudid(stuID);
	        if (first){
	            shjxjMapper.insert(shjxj);
	        }else{
	            shjxjMapper.updateByStudIdSelective(shjxj);
	        }
	        
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            return 0;
        }
    }

	@SuppressWarnings("finally")
    public ShjxjWithBLOBs showOneShjxjByStuID(Integer studId) {
        ShjxjWithBLOBs shjxj = new ShjxjWithBLOBs();
        try{
            shjxj = shjxjMapper.selectShjxjByStuId(studId);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            return shjxj;
        }
        
    }
	
	@SuppressWarnings("finally")
    public List<ShjxjWithBLOBs> findShjxjSelective(String annual, String colleage, String major, String stuclass) {
        List<ShjxjWithBLOBs> shjxjWithBLOBs = new ArrayList<ShjxjWithBLOBs>();
        try{
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            return shjxjWithBLOBs;
        }
    }

	@SuppressWarnings("finally")
    public ShjxjWithBLOBs findShjxjByStuId(int studId) {
	    ShjxjWithBLOBs shjxjWithBLOBs = new ShjxjWithBLOBs();
	    try{
	        shjxjWithBLOBs = shjxjMapper.selectShjxjByStuId(studId);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            return shjxjWithBLOBs;
        }
    }
	
	@SuppressWarnings("finally")
    public int checkShjxj(ShjxjWithBLOBs shjxjWithBLOBs) {
	    try{
           shjxjMapper.updateByPrimaryKey(shjxjWithBLOBs);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            return 0;
        }
    }

    @SuppressWarnings("finally")
    public List<ShjxjWithBLOBs> findAllShjxj() {
        List<ShjxjWithBLOBs> shjxjWithBLOBs = new ArrayList<ShjxjWithBLOBs>();
        try {
            shjxjWithBLOBs = shjxjMapper.selectAllShjxj();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return shjxjWithBLOBs;
        }
    }

}
