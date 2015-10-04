package swust.edu.cn.zzxt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swust.edu.cn.zzxt.dao.StudentinfoMapper;
import swust.edu.cn.zzxt.model.Studentinfo;
import swust.edu.cn.zzxt.service.StudentinfoService;

@Service("studentinfoService")
public class StudentinfoServiceImpl implements StudentinfoService{
    private StudentinfoMapper studentinfoMapper;

    public StudentinfoMapper getStudentinfoMapper() {
        return studentinfoMapper;
    }
    
    @Autowired
    public void setStudentinfoMapper(StudentinfoMapper studentinfoMapper) {
        this.studentinfoMapper = studentinfoMapper;
    }

    public void insetUserDetail(int stuId, String politicState, String nation, String sex, String phone, String qQ,
            String email, String residence, int population, float allIncomes, String incomeType, String mailCode,
            int areaId, String areaDeatil, String department) {
        // TODO Auto-generated method stub
        
    }

    @SuppressWarnings("finally")
    public Studentinfo obtainStudentInfoByStudId(Integer studId) {
        Studentinfo studentinfo = new Studentinfo();
        try {
            studentinfo = studentinfoMapper.selectBystudInfoStudId(studId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return studentinfo;
        }
    }
    
    @SuppressWarnings("finally")
	public Studentinfo selectBystudInfoStudId(Integer studId) {
		Studentinfo studentinfo = new Studentinfo();
		try {
			studentinfo = studentinfoMapper.selectBystudInfoStudId(studId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
            return studentinfo;
        }
	}

	@SuppressWarnings("finally")
	public Studentinfo updateByStinId(Integer stinId, String vallige,Integer town,String stinResidence) {
		Studentinfo studentinfo = new Studentinfo();
		try {
			studentinfo.setStinId(stinId);
			studentinfo.setStinAreadeatilhome(vallige);
			studentinfo.setStinAreaidhome(town);
			studentinfo.setStinResidence(stinResidence);
			studentinfo = studentinfoMapper.updateByStinId(studentinfo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return studentinfo;
		}
		
	}
    
}
