package swust.edu.cn.zzxt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swust.edu.cn.zzxt.dao.MajorMapper;
import swust.edu.cn.zzxt.model.Major;
import swust.edu.cn.zzxt.service.MajorService;

@Service("MajorService")
public class MajorServiceImpl implements MajorService{
    private MajorMapper majorMapper;
    
    public MajorMapper getMajorMapper() {
        return majorMapper;
    }
    
    @Autowired
    public void setMajorMapper(MajorMapper majorMapper) {
        this.majorMapper = majorMapper;
    }   


    @SuppressWarnings("finally")
    public Major obtainMajorByClassMajrid(Integer classMajrid) {
        Major major=new Major();
        try {
            major = majorMapper.selectByPrimaryKey(classMajrid);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return major;
        }
    }
    @SuppressWarnings("finally")
	public Major selectByPrimaryKey(Integer classMajrid) {
		Major major = new Major();
		try {
			major = majorMapper.selectByPrimaryKey(classMajrid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return major;
		}
	}

	@SuppressWarnings("finally")
	public List<Major> selectByInstId(Integer userInstId) {
		List<Major> major = new ArrayList<Major>();
		try {
			major = majorMapper.selectByInstId(userInstId);
			
			if(major.size() == 0)
			    major = null;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			return major;
		}
	}

	@SuppressWarnings("finally")
	public List<Major> selectByMajorId(Integer classMajrid) {
		List<Major> major = new ArrayList<Major>();
		try {
		    
			major = majorMapper.selectByMajorId(classMajrid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			return major;
		}
	}


	@SuppressWarnings("finally")
	public List<Major> selectClassByUserId(Integer userId) {
		List<Major> major = new ArrayList<Major>();
		try {
			major = majorMapper.selectClassByUserId(userId);
			//quchong
			for(int i = 0;i < major.size();i++){
				for(int j = i;j < major.size()-1;j++){
					if(major.get(j+1).getMajrId() == major.get(i).getMajrId()){
						major.remove(i);
						j--;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return major;
		}
		
	}
}
