package swust.edu.cn.zzxt.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import swust.edu.cn.zzxt.dao.SxpabxMapper;
import swust.edu.cn.zzxt.model.Sxpabx;
import swust.edu.cn.zzxt.selfmodel.Pabxbasicinfo;
import swust.edu.cn.zzxt.service.SxpabxService;



@Service("sxpnbxService")
public  class SxpabxServiceImpl implements SxpabxService{
    private SxpabxMapper sxpabxMapper;  
     
    
    public SxpabxMapper getSxpabxMapper() {
        return sxpabxMapper;
    }
    @Autowired 
    public void setSxpabxMapper(SxpabxMapper sxpabxMapper) {
        this.sxpabxMapper = sxpabxMapper;
    }
   
 /* @SuppressWarnings({ "finally" })
  public Sxpabx findSxpabxById(int id){
        Sxpabx sxpabx = new Sxpabx();
        try{
            List<Sxpabx> list =new ArrayList<Sxpabx>();
            list= sxpabxMapper.selectByStudId(id);
            if (list!=null && list.size()>0) {
            sxpabx= list.get(0);
            }            
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            return sxpabx;
        }        
    }
*/
   @SuppressWarnings("finally")
   public  List<Sxpabx> findSxpabxByStudentId(int studentId) {
       List<Sxpabx> list=null;
       try {
           list=new ArrayList<Sxpabx>();
           list=sxpabxMapper.selectBystudentId(studentId);
       } catch (Exception e) {
           e.printStackTrace();
       }finally{
           return list;
       }
   }
   @SuppressWarnings("finally")
   public  List<Sxpabx> findSxpabxByStutId_Annual(String annual,int studentId) {
       List<Sxpabx> list=null;
       try {
           list=new ArrayList<Sxpabx>();
           Sxpabx sxpabx = new Sxpabx();
           sxpabx.setXspaBuyannual(annual);
           sxpabx.setXspaStudid(studentId);
           list=sxpabxMapper.selectByStutId_Annual(sxpabx);
       } catch (Exception e) {
           e.printStackTrace();
       }finally{
           return list;
       }
   }
   @SuppressWarnings("finally")
   public List<Pabxbasicinfo> findPabxbasiinfoByStudentId(Integer studId){
       List<Pabxbasicinfo> pabxbasicinfo=null;
       try {
           pabxbasicinfo = new ArrayList<Pabxbasicinfo>();
           pabxbasicinfo=sxpabxMapper.selectPabxbasiinfoByStudId(studId);
           
       } catch (Exception e) {
        // TODO Auto-generated catch block
           e.printStackTrace();
       }finally{
           return pabxbasicinfo;
       } 
   }

    @SuppressWarnings("finally")
    public List<Pabxbasicinfo> findPabxbasiinfoByInstId(Integer instId) {
       List<Pabxbasicinfo> pabxbasicinfo=null;       
        try {
            pabxbasicinfo = new ArrayList<Pabxbasicinfo>();
            pabxbasicinfo = sxpabxMapper.selectPabxbasiinfoByInstId(instId);
        } catch (Exception e) {   
         // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            return pabxbasicinfo;
        }
    }
    @SuppressWarnings("finally")
    public List<Pabxbasicinfo> findPabxbasiinfoByClassId(Integer classId) {
        List<Pabxbasicinfo> pabxbasicinfo=null;       
        try {
            pabxbasicinfo = new ArrayList<Pabxbasicinfo>();
            pabxbasicinfo = sxpabxMapper.selectPabxbasiinfoByClassId(classId);
        } catch (Exception e) { 
         // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            return pabxbasicinfo;
        }
    }

    @SuppressWarnings("finally")
    public List<Pabxbasicinfo> findPabxbasiinfoByMajrId(Integer majrId) {
        List<Pabxbasicinfo> pabxbasicinfo=null;       
        try {
            pabxbasicinfo = new ArrayList<Pabxbasicinfo>();
            pabxbasicinfo = sxpabxMapper.selectPabxbasiinfoByMajrId(majrId);
        } catch (Exception e) {    
         // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            return pabxbasicinfo;
        }
    }

    @SuppressWarnings("finally")
    public List<Pabxbasicinfo> selectAllPabxbasiinfo() {
        List<Pabxbasicinfo> pabxbasicinfo=null;       
        try {
            pabxbasicinfo = new ArrayList<Pabxbasicinfo>();
            pabxbasicinfo = sxpabxMapper.selectAllPabxbasiinfo();
        } catch (Exception e) {   
         // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            return pabxbasicinfo;
        }
    }
   
}