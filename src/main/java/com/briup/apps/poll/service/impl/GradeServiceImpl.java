package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.GradeExample;
import com.briup.apps.poll.dao.GradeMapper;
import com.briup.apps.poll.service.IGradeService;

@Service
public class GradeServiceImpl implements IGradeService{
	@Autowired
	private GradeMapper gradeMapper;
	
	@Override
	public List<Grade> findAll() throws Exception{
		GradeExample example=new GradeExample();
		return gradeMapper.selectByExample(example);
	}
	
	@Override
	public Grade findById(long id) throws Exception{
		return gradeMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<Grade> query(String keywords) throws Exception{
		GradeExample example=new GradeExample();
		example.createCriteria().andNameLike(keywords);
		return gradeMapper.selectByExample(example);
	}
	
	@Override
	public void deleteById(long id) throws Exception{
		gradeMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public void baticDelete(Long[] ids) throws Exception{
		for(long id:ids){
			gradeMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public void saveOrUpdate(Grade grade) throws Exception {
		// TODO Auto-generated method stub
		if (grade.getId()!=null) {
			//更新
			gradeMapper.updateByPrimaryKey(grade);
		} else {
            //插入
			gradeMapper.insert(grade);
	}
	
}
	}
