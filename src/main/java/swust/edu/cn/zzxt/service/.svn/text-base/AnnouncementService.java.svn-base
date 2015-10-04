package swust.edu.cn.zzxt.service;

import java.sql.Savepoint;
import java.util.List;

import swust.edu.cn.zzxt.model.Announcement;
import swust.edu.cn.zzxt.selfmodel.ArticleModel;

public interface AnnouncementService {
	public ArticleModel findCzIntroduction();
	public ArticleModel findCzWorkIntroduction();
	public ArticleModel findPaIntroduction();
	public ArticleModel findJbIntroduction();
	public List<ArticleModel> findByType(int type);
	public boolean save(String title,String content,int type,int userid);
	public boolean update(String title,String content,int type,int id);
	public ArticleModel findById(int id);
	public boolean deleteById(int id);
	public ArticleModel findWorkIntroduction(int id);
}
