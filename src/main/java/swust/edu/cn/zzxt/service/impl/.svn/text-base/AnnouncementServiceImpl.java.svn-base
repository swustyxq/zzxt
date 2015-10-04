package swust.edu.cn.zzxt.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import swust.edu.cn.zzxt.dao.AnnouncementMapper;
import swust.edu.cn.zzxt.dao.AnnouncementtypeMapper;
import swust.edu.cn.zzxt.dao.UserMapper;
import swust.edu.cn.zzxt.model.Announcement;
import swust.edu.cn.zzxt.model.Announcementtype;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.selfmodel.ArticleModel;
import swust.edu.cn.zzxt.service.AnnouncementService;

@Service("announcementService")
public class AnnouncementServiceImpl implements AnnouncementService{
	private AnnouncementMapper announcementMapper;
	private UserMapper userMapper;
	private AnnouncementtypeMapper announcementtypeMapper;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public AnnouncementtypeMapper getAnnouncementtypeMapper() {
		return announcementtypeMapper;
	}

	@Autowired
	public void setAnnouncementtypeMapper(
			AnnouncementtypeMapper announcementtypeMapper) {
		this.announcementtypeMapper = announcementtypeMapper;
	}

	public AnnouncementMapper getAnnouncementMapper() {
		return announcementMapper;
	}

	@Autowired
	public void setAnnouncementMapper(AnnouncementMapper announcementMapper) {
		this.announcementMapper = announcementMapper;
	}

	@SuppressWarnings("finally")
	public ArticleModel findCzIntroduction() {
		ArticleModel articleModel=new ArticleModel();
		try {
			List<Announcement> list=announcementMapper.selectByannoAntpid(1);
			Announcement announcement=new Announcement();
			if (list!=null && list.size()>0) {
				announcement=list.get(0);
				
				User user=new User();
				user=userMapper.selectByPrimaryKey(announcement.getAnnoUserid());
				Announcementtype announcementtype=new Announcementtype();
				announcementtype=announcementtypeMapper.selectByPrimaryKey(announcement.getAnnoAntpid());
				
				articleModel.setContent(announcement.getAnnoContent());
				Date date=new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String publishtime=formatter.format(announcement.getAnnoPublishtime());
				articleModel.setLastModifyTime(publishtime);
				Date date1=new Date();
				SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String lastModifyTime=formatter1.format(announcement.getAnnoLastmodifytime());
				articleModel.setPublishTime(lastModifyTime);
				articleModel.setType(announcementtype.getAntpName());
				articleModel.setUser(user.getUserName());
				articleModel.setTitle(announcement.getAnnoTitle());
				articleModel.setId(announcement.getAnnoId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return articleModel;
		}
	}
	@SuppressWarnings("finally")
    public ArticleModel findCzWorkIntroduction() {
        ArticleModel articleModel=new ArticleModel();
        try {
          
            List<Announcement> list=announcementMapper.selectByannoAntpid(6);
            Announcement announcement=new Announcement();
            if (list!=null && list.size()>0) {
                announcement=list.get(0);
                
                User user=new User();
                user=userMapper.selectByPrimaryKey(announcement.getAnnoUserid());
                Announcementtype announcementtype=new Announcementtype();
                announcementtype=announcementtypeMapper.selectByPrimaryKey(announcement.getAnnoAntpid());
                
                articleModel.setContent(announcement.getAnnoContent());
                Date date=new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String publishtime=formatter.format(announcement.getAnnoPublishtime());
                articleModel.setLastModifyTime(publishtime);
                Date date1=new Date();
                SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String lastModifyTime=formatter1.format(announcement.getAnnoLastmodifytime());
                articleModel.setPublishTime(lastModifyTime);
                articleModel.setType(announcementtype.getAntpName());
                articleModel.setUser(user.getUserName());
                articleModel.setTitle(announcement.getAnnoTitle());
                articleModel.setId(announcement.getAnnoId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return articleModel;
        }
    }
	@SuppressWarnings("finally")
	public ArticleModel findPaIntroduction() {
		ArticleModel articleModel=new ArticleModel();
		try {
			List<Announcement> list=announcementMapper.selectByannoAntpid(2);
			Announcement announcement=new Announcement();
			if (list!=null && list.size()>0) {
				announcement=list.get(0);
				
				User user=new User();
				user=userMapper.selectByPrimaryKey(announcement.getAnnoUserid());
				Announcementtype announcementtype=new Announcementtype();
				announcementtype=announcementtypeMapper.selectByPrimaryKey(announcement.getAnnoAntpid());
				
				articleModel.setContent(announcement.getAnnoContent());
				Date date=new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String publishtime=formatter.format(announcement.getAnnoPublishtime());
				articleModel.setLastModifyTime(publishtime);
				Date date1=new Date();
				SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String lastModifyTime=formatter1.format(announcement.getAnnoLastmodifytime());
				articleModel.setPublishTime(lastModifyTime);
				articleModel.setType(announcementtype.getAntpName());
				articleModel.setUser(user.getUserName());
				articleModel.setTitle(announcement.getAnnoTitle());
				articleModel.setId(announcement.getAnnoId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return articleModel;
		}
	}
	
	@SuppressWarnings("finally")
	public ArticleModel findJbIntroduction() {
		ArticleModel articleModel=new ArticleModel();
		try {
			List<Announcement> list=announcementMapper.selectByannoAntpid(5);
			Announcement announcement=new Announcement();
			if (list!=null && list.size()>0) {
				announcement=list.get(0);
				
				User user=new User();
				user=userMapper.selectByPrimaryKey(announcement.getAnnoUserid());
				Announcementtype announcementtype=new Announcementtype();
				announcementtype=announcementtypeMapper.selectByPrimaryKey(announcement.getAnnoAntpid());
				
				articleModel.setContent(announcement.getAnnoContent());
				Date date=new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String publishtime=formatter.format(announcement.getAnnoPublishtime());
				articleModel.setLastModifyTime(publishtime);
				Date date1=new Date();
				SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String lastModifyTime=formatter1.format(announcement.getAnnoLastmodifytime());
				articleModel.setPublishTime(lastModifyTime);
				articleModel.setType(announcementtype.getAntpName());
				articleModel.setUser(user.getUserName());
				articleModel.setTitle(announcement.getAnnoTitle());
				articleModel.setId(announcement.getAnnoId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return articleModel;
		}
	}

	@SuppressWarnings("finally")
	public boolean save(String title,String content,int type,int userid) {
		boolean flag=true;
		try {
			Announcement announcement=new Announcement();
			announcement.setAnnoContent(content);
			announcement.setAnnoAntpid(type);
			Timestamp timestamp=new Timestamp(System.currentTimeMillis());
			announcement.setAnnoLastmodifytime(timestamp);
			announcement.setAnnoIsdeleted(0);
			announcement.setAnnoPublishtime(timestamp);
			announcement.setAnnoTitle(title);
			announcement.setAnnoUserid(userid);
			announcementMapper.insert(announcement);
		} catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}finally{
			return flag;
		}
	}
	
	@SuppressWarnings("finally")
	public List<ArticleModel> findByType(int type) {
		List<ArticleModel> list=new ArrayList<ArticleModel>();
		try {
			List<Announcement> list2=new ArrayList<Announcement>();
			if (type==0) {
				list2=announcementMapper.selectAllAnnouncements();
			}else {
				list2=announcementMapper.selectByannoAntpid(type);
			}
			if (list2!=null && list2.size()>0) {
				for (int i = 0; i < list2.size(); i++) {
					Announcement announcement=new Announcement();
					announcement=list2.get(i);
					ArticleModel articleModel=new ArticleModel();
					
					User user=new User();
					user=userMapper.selectByPrimaryKey(announcement.getAnnoUserid());
					Announcementtype announcementtype=new Announcementtype();
					announcementtype=announcementtypeMapper.selectByPrimaryKey(announcement.getAnnoAntpid());
					
					articleModel.setContent(announcement.getAnnoContent());
					Date date=new Date();
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String publishtime=formatter.format(announcement.getAnnoPublishtime());
					articleModel.setLastModifyTime(publishtime);
					Date date1=new Date();
					SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String lastModifyTime=formatter1.format(announcement.getAnnoLastmodifytime());
					articleModel.setPublishTime(lastModifyTime);
					articleModel.setType(announcementtype.getAntpName());
					articleModel.setUser(user.getUserName());
					articleModel.setTitle(announcement.getAnnoTitle());
					articleModel.setId(announcement.getAnnoId());
					list.add(articleModel);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return list;
		}
	}

	@SuppressWarnings("finally")
	public ArticleModel findById(int id) {
		ArticleModel articleModel=new ArticleModel();
		try {
			Announcement announcement=new Announcement();
			announcement=announcementMapper.selectByPrimaryKey(id);
			
			User user=new User();
			user=userMapper.selectByPrimaryKey(announcement.getAnnoUserid());
			Announcementtype announcementtype=new Announcementtype();
			announcementtype=announcementtypeMapper.selectByPrimaryKey(announcement.getAnnoAntpid());

			articleModel.setContent(announcement.getAnnoContent());
			Date date=new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String publishtime=formatter.format(announcement.getAnnoPublishtime());
			articleModel.setLastModifyTime(publishtime);
			Date date1=new Date();
			SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String lastModifyTime=formatter1.format(announcement.getAnnoLastmodifytime());
			articleModel.setPublishTime(lastModifyTime);
			articleModel.setType(announcementtype.getAntpName());
			articleModel.setUser(user.getUserName());
			articleModel.setTitle(announcement.getAnnoTitle());
			articleModel.setId(announcement.getAnnoId());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return articleModel;
		}
	}

	@SuppressWarnings("finally")
	public boolean update(String title, String content, int type, int id) {
		boolean flag=true;
		try {
			Announcement announcement=announcementMapper.selectByPrimaryKey(id);
			announcement.setAnnoContent(content);
			announcement.setAnnoAntpid(type);
			Timestamp timestamp=new Timestamp(System.currentTimeMillis());
			announcement.setAnnoLastmodifytime(timestamp);
			announcement.setAnnoIsdeleted(0);
			announcement.setAnnoTitle(title);
			announcementMapper.updateByPrimaryKey(announcement);
		} catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}finally{
			return flag;
		}
	}

	@SuppressWarnings("finally")
	public boolean deleteById(int id) {
		boolean flag=true;
		try {
			announcementMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}finally{
			return flag;
		}
	}
	@SuppressWarnings("finally")
    public ArticleModel findWorkIntroduction(int id) {
        ArticleModel articleModel=new ArticleModel();
        try {
          
            List<Announcement> list=announcementMapper.selectByannoAntpid(id);
            Announcement announcement=new Announcement();
            if (list!=null && list.size()>0) {
                announcement=list.get(0);
                
                User user=new User();
                user=userMapper.selectByPrimaryKey(announcement.getAnnoUserid());
                Announcementtype announcementtype=new Announcementtype();
                announcementtype=announcementtypeMapper.selectByPrimaryKey(announcement.getAnnoAntpid());
                
                articleModel.setContent(announcement.getAnnoContent());
                Date date=new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String publishtime=formatter.format(announcement.getAnnoPublishtime());
                articleModel.setLastModifyTime(publishtime);
                Date date1=new Date();
                SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String lastModifyTime=formatter1.format(announcement.getAnnoLastmodifytime());
                articleModel.setPublishTime(lastModifyTime);
                articleModel.setType(announcementtype.getAntpName());
                articleModel.setUser(user.getUserName());
                articleModel.setTitle(announcement.getAnnoTitle());
                articleModel.setId(announcement.getAnnoId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return articleModel;
        }
    }
}
