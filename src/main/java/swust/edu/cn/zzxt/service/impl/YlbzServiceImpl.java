package swust.edu.cn.zzxt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swust.edu.cn.zzxt.dao.YlbzMapper;
import swust.edu.cn.zzxt.model.YlbzWithBLOBs;
import swust.edu.cn.zzxt.selfmodel.Ylbzbasicinfo;
import swust.edu.cn.zzxt.service.YlbzService;

@Service("ylbzService")
public class YlbzServiceImpl implements YlbzService {
	private YlbzMapper ylbzMapper;

	public YlbzMapper getYlbzMapper() {
		return ylbzMapper;
	}

	@Autowired
	public void setYlbzMapper(YlbzMapper ylbzMapper) {
		this.ylbzMapper = ylbzMapper;
	}

	@SuppressWarnings("finally")
	public YlbzWithBLOBs addOneRecord(YlbzWithBLOBs ylbz) {
		try {

			System.out.println("ggggggggggg" + ylbz.getYlbzIntime() + "aaa");
			ylbzMapper.insertSelective(ylbz);
			System.out.println("ggggggggggg");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return ylbz;
		}
	}

	@SuppressWarnings("finally")
	public List<YlbzWithBLOBs> findYlbzByStudId(Integer studId) {
		List<YlbzWithBLOBs> ylbz = new ArrayList<YlbzWithBLOBs>();
		try {
			ylbz=ylbzMapper.selectByStudId(studId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
		return ylbz;
		}
	}
	@SuppressWarnings("finally")
	public YlbzWithBLOBs update(YlbzWithBLOBs ylbz){
		try {
			ylbzMapper.updateByPrimaryKeyWithBLOBs(ylbz);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
		return ylbz;
		}
	}
	@SuppressWarnings("finally")
	public YlbzWithBLOBs findYlbzByid(int ylbzId)
	{
		YlbzWithBLOBs ylbz = new YlbzWithBLOBs();
		try {
			ylbz = ylbzMapper.selectByPrimaryKey(ylbzId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			return ylbz;
		}
	}
	@SuppressWarnings("finally")
	public List<Ylbzbasicinfo> findAllYlbzBasicinfo()
	{
		List<Ylbzbasicinfo> ylbz = new ArrayList<Ylbzbasicinfo>();
		try {
			ylbz = ylbzMapper.selectAllYlbzbasiinfo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			return ylbz;
		}
	}
	@SuppressWarnings("finally")
	public List<Ylbzbasicinfo> findYlbzBasicinfoByinstId(Integer instId)
	{
		List<Ylbzbasicinfo> ylbz = new ArrayList<Ylbzbasicinfo>();
		try {
			ylbz = ylbzMapper.selectYlbzbasiinfoByinstId(instId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			return ylbz;
		}
	}
	@SuppressWarnings("finally")
	public List<Ylbzbasicinfo> findYlbzBasicinfoBymajrId(Integer majrId)
	{
		List<Ylbzbasicinfo> ylbz = new ArrayList<Ylbzbasicinfo>();
		try {
			ylbz = ylbzMapper.selectYlbzbasiinfoBymajrId(majrId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			return ylbz;
		}
	}
	@SuppressWarnings("finally")
	public List<Ylbzbasicinfo> findYlbzBasicinfoByclassId(Integer classId)
	{
		List<Ylbzbasicinfo> ylbz = new ArrayList<Ylbzbasicinfo>();
		try {
			ylbz = ylbzMapper.selectYlbzbasiinfoByclassId(classId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			return ylbz;
		}
	}
	@SuppressWarnings("finally")
	public List<Ylbzbasicinfo> findYlbzBasicinfoBystudId(Integer studId)
	{
		List<Ylbzbasicinfo> ylbz = new ArrayList<Ylbzbasicinfo>();
		try {
			ylbz = ylbzMapper.selectYlbzbasiinfoBystudId(studId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			return ylbz;
		}
	}
}
