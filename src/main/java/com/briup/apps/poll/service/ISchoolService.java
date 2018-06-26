package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.School;

public interface ISchoolService {
	
	//查询所有学校
	List<School> findAll() throws Exception;
	
	//插入和更新
	void saveOrUpdate(School school) throws Exception;

}
