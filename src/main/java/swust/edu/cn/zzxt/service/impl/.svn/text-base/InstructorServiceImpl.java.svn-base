package swust.edu.cn.zzxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swust.edu.cn.zzxt.dao.InstructorMapper;
import swust.edu.cn.zzxt.model.Instructor;
import swust.edu.cn.zzxt.selfmodel.TeacherModal;
import swust.edu.cn.zzxt.service.InstructorService;

@Service("instructorService")
public class InstructorServiceImpl implements InstructorService {
	InstructorMapper instructorMapper;

	public InstructorMapper getInstructorMapper() {
		return instructorMapper;
	}
	@Autowired
	public void setInstructorMapper(InstructorMapper instructorMapper) {
		this.instructorMapper = instructorMapper;
	}

	@SuppressWarnings("finally")
	public Instructor findInstructorByPrimaryKey(Integer classInstid) {
		Instructor instructor = null;
		instructor = new Instructor();
		try {
			instructor = instructorMapper.selectByPrimaryKey(classInstid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return instructor;
		}
	}
	@SuppressWarnings("finally")
	public Instructor findInstructorByUserId(Integer userId) {
		Instructor instructor = null;
		instructor = new Instructor();
		try {
			instructor = instructorMapper.selectByUserId(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return instructor;
		}
	}
	
	@SuppressWarnings("finally")
    public List<TeacherModal> findTeacherModals(Integer instid) {
	    List<TeacherModal> teacherModals = null;
        try {
            teacherModals = instructorMapper.selectTeacherByInstid(instid);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            return teacherModals;
        }
    }
}
