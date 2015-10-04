package swust.edu.cn.zzxt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swust.edu.cn.zzxt.dao.CzylbxMapper;
import swust.edu.cn.zzxt.model.Czylbx;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.selfmodel.Czylbxbasicinfo;
import swust.edu.cn.zzxt.selfmodel.Pabxbasicinfo;
import swust.edu.cn.zzxt.service.CzylbxService;

@Service("czylbxService")
public class CzylbxServiceImpl implements CzylbxService{
	private CzylbxMapper czylbxMapper;

	public CzylbxMapper getCzylbxMapper() {
		return czylbxMapper;
	}

	@Autowired
	public void setCzylbxMapper(CzylbxMapper czylbxMapper) {
		this.czylbxMapper = czylbxMapper;
	}

	/**
	 * author Shaozhou , 2014.07.07 
	 * 根据学生的学号来查找，城镇居民医疗保险
	 */
	@SuppressWarnings("finally")
	public List<Czylbx> findCzylbxsByStudentId(int studentId) {
		List<Czylbx> list=null;
		try {
			list=new ArrayList<Czylbx>();
			list=czylbxMapper.findCzylbxsByczylStudid(studentId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return list;
		}
	}
	@SuppressWarnings("finally")
    public void EditInfoByCzlybxId(int czylbxId,int will){
	    Czylbx czylbx= new Czylbx();
        try {
            czylbx = czylbxMapper.selectByPrimaryKey(czylbxId);
            czylbx.setCzlyIsneed(will);
            czylbxMapper.updateByPrimaryKeySelective(czylbx);
       
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally
        {
      
        }
        
    }
	/**
	 * author chenwenhui , 2014.07.17
	 * 根据学生的学号以及年份来查找，城镇居民医疗保险
	 */
	@SuppressWarnings("finally")
	public List<Czylbx> findCzylbxsByYearAndStudentId(Integer studId,String year) {
		List<Czylbx> list=null;
		try {
			list=new ArrayList<Czylbx>();
			System.out.println("hhh"+studId);
			Czylbx czylbx = new Czylbx();
			czylbx.setCzylStudid(studId);
			czylbx.setCzlyBuyannual(year);
			list=czylbxMapper.findCzylbxsByczylStudidAndYear(czylbx);
			System.out.println(list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return list;
		}
	}
	@SuppressWarnings("finally")
	public Czylbxbasicinfo findCzylbxbasiinfoByStudentId(Integer studId){
	    Czylbxbasicinfo czylbxbasicinfo=null;
	       try {
	           czylbxbasicinfo=czylbxMapper.selectCzylbxbasiinfoByStudId(studId);
	           
	       } catch (Exception e) {
	        // TODO Auto-generated catch block
	           e.printStackTrace();
	       }finally{
	           return czylbxbasicinfo;
	       } 
	     
	 }
	
	  @SuppressWarnings("finally")
	    public List<Czylbxbasicinfo> findCzylbxbasiinfoByInstId(Integer instId) {
	       List<Czylbxbasicinfo> czylbxbasicinfo=null;       
	        try {
	            czylbxbasicinfo = new ArrayList<Czylbxbasicinfo>();
	            czylbxbasicinfo = czylbxMapper.selectCzylbxbasiinfoByInstId(instId);
	        } catch (Exception e) {   
	         // TODO Auto-generated catch block
	            e.printStackTrace();
	        } finally {
	            return czylbxbasicinfo;
	        }
	    }
	    @SuppressWarnings("finally")
	    public List<Czylbxbasicinfo> findCzylbxbasiinfoByClassId(Integer classId) {
	        List<Czylbxbasicinfo> czylbxbasicinfo=null;       
            try {
                czylbxbasicinfo = new ArrayList<Czylbxbasicinfo>();
                czylbxbasicinfo = czylbxMapper.selectCzylbxbasiinfoByClassId(classId);
            } catch (Exception e) {   
             // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                return czylbxbasicinfo;
            }
	    }

	    @SuppressWarnings("finally")
	    public List<Czylbxbasicinfo> findCzylbxbasiinfoByMajrId(Integer majrId) {
	        List<Czylbxbasicinfo> czylbxbasicinfo=null;       
            try {
                czylbxbasicinfo = new ArrayList<Czylbxbasicinfo>();
                czylbxbasicinfo = czylbxMapper.selectCzylbxbasiinfoByMajrId(majrId);
            } catch (Exception e) {   
             // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                return czylbxbasicinfo;
            }
	    }

	    @SuppressWarnings("finally")
	    public List<Czylbxbasicinfo> selectAllCzylbxbasiinfo() {
	        List<Czylbxbasicinfo> czylbxbasicinfo=null;       
            try {
                czylbxbasicinfo = new ArrayList<Czylbxbasicinfo>();
                czylbxbasicinfo = czylbxMapper.selectAllCzylbxbasiinfo();
            } catch (Exception e) {   
             // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                return czylbxbasicinfo;
            }
	    }
}
