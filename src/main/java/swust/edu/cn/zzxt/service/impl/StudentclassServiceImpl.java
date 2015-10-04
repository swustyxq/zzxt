package swust.edu.cn.zzxt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swust.edu.cn.zzxt.dao.StudentclassMapper;
import swust.edu.cn.zzxt.model.Studentclass;
import swust.edu.cn.zzxt.service.StudentclassService;

@Service("studentclassService")
public class StudentclassServiceImpl implements StudentclassService{
    private StudentclassMapper studentclassMapper;

    public StudentclassMapper getStudentclassMapper() {
        return studentclassMapper;
    }
    
    @Autowired
    public void setStudentclassMapper(StudentclassMapper studentclassMapper) {
        this.studentclassMapper = studentclassMapper;
    }


    @SuppressWarnings("finally")
    public Studentclass obtainStudentClassByStudClassid(Integer classId) {
        Studentclass studentclass = new Studentclass();
        try {
            studentclass = studentclassMapper.selectByPrimaryKey(classId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return studentclass;
        }
    }
    @SuppressWarnings("finally")
	public Studentclass selectBystudInfoStudId(Integer Classid) {
		Studentclass studentclass = new Studentclass();
		try {
			studentclass = studentclassMapper.selectByPrimaryKey(Classid);
		} catch (Exception e) {		
			e.printStackTrace();
		}
		finally {
            return studentclass;
        }
	}

	@SuppressWarnings("finally")
	public List<Studentclass> selectByMajorId(Integer majrId) {
		List<Studentclass> studentclass = new ArrayList<Studentclass>();
		try {
			studentclass = studentclassMapper.selectByMajorId(majrId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return studentclass;
		}
	}

	@SuppressWarnings("finally")
	public List<Studentclass> selectByInstId(Integer instId) {
		List<Studentclass> studentclass = new ArrayList<Studentclass>();
		try {
			studentclass = studentclassMapper.selectByInstId(instId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return studentclass;
		}
	}
	
	@SuppressWarnings("finally")
    public List<Studentclass> selectByInstitutionId(Integer instId) {
        List<Studentclass> studentclass = new ArrayList<Studentclass>();
        try {
            studentclass = studentclassMapper.selectByInstitutionId(instId);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return studentclass;
        }
    }
	
	   @SuppressWarnings("finally")
	    public void updateSelective(int classid,int instid) {
	       Studentclass studentclass = new Studentclass();
	        try {
	            studentclass.setClassId(classid);
	            studentclass.setClassInstid(instid);
	            studentclassMapper.updateByPrimaryKeySelective(studentclass);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally{
	            return;
	        }
	    }

}
