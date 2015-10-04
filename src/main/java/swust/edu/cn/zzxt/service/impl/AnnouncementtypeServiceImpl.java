package swust.edu.cn.zzxt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swust.edu.cn.zzxt.dao.AnnouncementtypeMapper;
import swust.edu.cn.zzxt.model.Announcementtype;
import swust.edu.cn.zzxt.service.AnnouncementtypeService;

@Service("announcementtypeService")
public class AnnouncementtypeServiceImpl implements AnnouncementtypeService {
	private AnnouncementtypeMapper announcementtypeMapper;
	
	public AnnouncementtypeMapper getAnnouncementtypeMapper() {
		return announcementtypeMapper;
	}

	@Autowired
	public void setAnnouncementtypeMapper(
			AnnouncementtypeMapper announcementtypeMapper) {
		this.announcementtypeMapper = announcementtypeMapper;
	}

	@SuppressWarnings("finally")
	public List<Announcementtype> findAllAnnouncementtype() {
		List<Announcementtype> list=new ArrayList<Announcementtype>();
		try {
			list=announcementtypeMapper.selectAllAnnoucementtype();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return list;
		}
	}

}
