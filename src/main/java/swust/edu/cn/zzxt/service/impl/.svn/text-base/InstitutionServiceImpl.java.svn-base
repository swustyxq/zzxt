package swust.edu.cn.zzxt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swust.edu.cn.zzxt.dao.InstitutionMapper;
import swust.edu.cn.zzxt.model.Institution;
import swust.edu.cn.zzxt.service.InstitutionService;

@Service("institutionService")
public class InstitutionServiceImpl implements InstitutionService{
	InstitutionMapper institutionMapper;
	public InstitutionMapper getInstitutionMapper() {
		return institutionMapper;
	}
	@Autowired
	public void setInstitutionMapper(InstitutionMapper institutionMapper) {
		this.institutionMapper = institutionMapper;
	}
	/**
	 * 按userInstId查看学院信息
	 * @author chenwenhui 2014 7 16
	 * */
	@SuppressWarnings("finally")
	public Institution findinstitutionByUserInstId(Integer userInstId)
	{
		Institution institution=null;
		try {
			institution = new Institution();
			institution = institutionMapper.selectByPrimaryKey(userInstId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		return institution;
		}
	}
	/*查找所有的机构
	 * author：yangjunhui
	 * Time：20140724*/
	@SuppressWarnings("finally")
    public List<Institution> findAllInstitutions() {
        List<Institution> institutions = new ArrayList<Institution>();
        try {
            institutions = institutionMapper.selectAllInstitutions();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return institutions;
        }
    }
	@SuppressWarnings("finally")
	public Institution findinstitutionByMajorInstId(Integer majorInstId){
	    
	    Institution institution=null;
        try {
            institution = new Institution();
            institution = institutionMapper.selectByPrimaryKey(majorInstId);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
        return institution;
        }
	    
	}
}