package swust.edu.cn.zzxt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swust.edu.cn.zzxt.dao.AreaMapper;
import swust.edu.cn.zzxt.model.Area;
import swust.edu.cn.zzxt.model.Student;
import swust.edu.cn.zzxt.service.AreaService;

@Service("AreaService")
public class AreaServiceImpl implements AreaService{
private AreaMapper areaMapper;
	
	public AreaMapper getAreaMapper() {
		return areaMapper;
	}

	@Autowired
	public void setAreaMapper(AreaMapper areaMapper) {
		this.areaMapper = areaMapper;
	}	

	@SuppressWarnings("finally")
	public List<Area> getAreaByParentId(Integer areaParentId) {
		// TODO Auto-generated method stub
		List<Area> areaList = new ArrayList<Area>();
		try {
			areaList = areaMapper.selectByParentId(areaParentId);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return areaList;
		}
	}

    @SuppressWarnings("finally")
    public Area getAreaById(Integer areaId) {
        Area area=new Area();
        try {
            List<Area> list=new ArrayList<Area>();
            list=areaMapper.selectByAreaId(areaId);
            if (list!=null && list.size()>0) {
                area=list.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return area;
        }
    }
}
