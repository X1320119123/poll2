package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.School;
import com.briup.apps.poll.bean.SchoolExample;
import com.briup.apps.poll.dao.SchoolMapper;
import com.briup.apps.poll.service.ISchoolService;

@Service
public class SchoolServiceImpl implements ISchoolService{
	@Autowired
	private SchoolMapper schoolMapper;
	
	public List<School> findAll() throws Exception{
		SchoolExample example=new SchoolExample();
		return schoolMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void saveOrUpdate(School school) throws Exception {
		// TODO Auto-generated method stub
		if(school.getId()!=null){
			schoolMapper.updateByPrimaryKey(school);
		} else{
			schoolMapper.insert(school);
		}
	}

}
