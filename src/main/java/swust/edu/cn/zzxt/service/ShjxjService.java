package swust.edu.cn.zzxt.service;

import java.util.List;

import swust.edu.cn.zzxt.model.ShjxjWithBLOBs;

	public interface ShjxjService {

        int addOneStudShjxj(String sjBankNumber, String sjIspoor, String sjPoorRank, String sjInstructor,
                String sjInstrPhone, String sjStuDepartmentPhone, String sjPrizeSitu, String sjApplyReason,
                int sjReasonYear, int sjReasonMonth, 
                int sjReasonDay,int stuID,int WsflId,Boolean first);

        ShjxjWithBLOBs showOneShjxjByStuID(Integer studId);

        List<ShjxjWithBLOBs> findShjxjSelective(String annual,
                String colleage, String major, String stuclass);

        ShjxjWithBLOBs findShjxjByStuId(int studId);

        int checkShjxj(ShjxjWithBLOBs shjxjWithBLOBs);

        List<ShjxjWithBLOBs> findAllShjxj();
		
	}

