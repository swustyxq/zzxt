package swust.edu.cn.zzxt.service;

import swust.edu.cn.zzxt.model.Area;
import swust.edu.cn.zzxt.model.Studentinfo;

public interface InformationService {
   
    public  Studentinfo findStudentinfo(int studId);

    void addInformation(int stuId, String politicState, String bankNumber, String sex, String phone, String qQ,
            String email, String residence, int population, Double allIncomes, String incomeType, String mailCode,
            String department, String areaDeatilHome,String areaDetailOrigin, int areaIdHome, int areaIdOrigin);

    public Area findAreaByAreaId(Integer areaId);

    public void updateInformation(int StinId, int stuId, String politicState, String bankNumber, String sex, String phone,
            String qQ, String email, String residence, int population, Double allIncomes, String incomeType,
            String mailCode, String department, String areaDeatilHome, String areaDetailOrigin, /*String areaDetailOrigin,*/ int areaIdHome,
            int areaIdOrigin);

	public boolean updateStuInfo(Studentinfo studentinfo);
}
