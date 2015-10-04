package swust.edu.cn.zzxt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swust.edu.cn.zzxt.dao.AreaMapper;
import swust.edu.cn.zzxt.dao.StudentinfoMapper;
import swust.edu.cn.zzxt.model.Area;
import swust.edu.cn.zzxt.model.Studentinfo;
import swust.edu.cn.zzxt.service.InformationService;

@Service("informationService")
public class InformationServiceImpl implements InformationService {
    private StudentinfoMapper studentinfoMapper;

    public StudentinfoMapper getRoleMapper() {
        return studentinfoMapper;
    }

    @Autowired
    public void setRoleMapper(StudentinfoMapper studentinfoMapper) {
        this.studentinfoMapper = studentinfoMapper;
    }

    private AreaMapper areaMapper;

    public AreaMapper getAreaMapper() {
        return areaMapper;
    }

    @Autowired
    public void setAreaMapper(AreaMapper areaMapper) {
        this.areaMapper = areaMapper;
    }

    @SuppressWarnings("finally")
    public Studentinfo findStudentinfo(int studId) {
        Studentinfo studentinfo = new Studentinfo();
        try {
            List<Studentinfo> list=new ArrayList<Studentinfo>();
            list=studentinfoMapper.selectByInfoStudId(studId);
            if (list!=null && list.size()>0) {
                studentinfo=list.get(0);
            }else{
                studentinfo=null;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            return studentinfo;
        }
    }


    public void addInformation(int stuId, String politicState, String bankNumber, String sex, String phone, String qQ,
            String email, String residence, int population, Double allIncomes, String incomeType, String mailCode,
            String department, String areaDeatilHome, String areaDetailOrigin, int areaIdHome, int areaIdOrigin) {
        Studentinfo studentinfo = new Studentinfo();
        studentinfo.setStinStudid(stuId);
        studentinfo.setStinPoliticstate(politicState);
        studentinfo.setStinBanknumber(bankNumber);
        studentinfo.setStinSex(sex);
        studentinfo.setStinPhone(phone);
        studentinfo.setStinQq(qQ);
        studentinfo.setStinEmail(email);
        studentinfo.setStinResidence(residence);
        studentinfo.setStinPopulation(population);
        studentinfo.setStinAllincomes(allIncomes);
        studentinfo.setStinIncometype(incomeType);
        studentinfo.setStinMailcode(mailCode);
        studentinfo.setStinDepartment(department);
        studentinfo.setStinAreadeatilhome(areaDeatilHome);
       studentinfo.setStinAreadetailorigin(areaDetailOrigin);
        studentinfo.setStinAreaidhome(areaIdHome);
        studentinfo.setStinAreaidorigin(areaIdOrigin);
        studentinfo.setStinIseditable(1);
        studentinfo.setStinState(1);
        studentinfoMapper.insert(studentinfo);   
    }
    @SuppressWarnings("finally")
    public Area findAreaByAreaId(Integer areaId) {
        Area area = new Area();
        try {
            List<Area> list = new ArrayList<Area>();
            list = areaMapper.selectByAreaId(areaId);
            if (list != null && list.size() > 0) {
                area = list.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return area;
        }
    }

    public void updateInformation(int StinId, int stuId, String politicState, String bankNumber, String sex, String phone,
            String qQ, String email, String residence, int population, Double allIncomes, String incomeType,
            String mailCode, String department, String areaDeatilHome, String areaDetailOrigin, int areaIdHome,
            int areaIdOrigin) {
        Studentinfo studentinfo = new Studentinfo();
        studentinfo.setStinId(StinId);
        studentinfo.setStinStudid(stuId);
        studentinfo.setStinPoliticstate(politicState);
        studentinfo.setStinBanknumber(bankNumber);
        studentinfo.setStinSex(sex);
        studentinfo.setStinPhone(phone);
        studentinfo.setStinQq(qQ);
        studentinfo.setStinEmail(email);
        studentinfo.setStinResidence(residence);
        studentinfo.setStinPopulation(population);
        studentinfo.setStinAllincomes(allIncomes);
        studentinfo.setStinIncometype(incomeType);
        studentinfo.setStinMailcode(mailCode);
        studentinfo.setStinDepartment(department);
        studentinfo.setStinAreadeatilhome(areaDeatilHome);
        studentinfo.setStinAreadetailorigin(areaDetailOrigin);
        studentinfo.setStinAreaidhome(areaIdHome);
        studentinfo.setStinAreaidorigin(areaIdOrigin);
        studentinfo.setStinIseditable(1);
        studentinfo.setStinState(1);
        studentinfoMapper.updateByPrimaryKey(studentinfo);   
        // TODO Auto-generated method stub     
    }
    
    @SuppressWarnings("finally")
	public boolean updateStuInfo(Studentinfo studentinfo) {
    	try {
    		 studentinfoMapper.updateByPrimaryKeySelective(studentinfo);
    	}catch (Exception e) {
            e.printStackTrace();
        } finally {
            return true;
        }		
	}
}
