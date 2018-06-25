package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Course;

public interface ICourseService {

    //查询所有
	List<Course> findAll() throws Exception;
	//通过id查询
	Course findById(long id) throws Exception;
	//通过关键字查询
	List<Course> query(String keywords) throws Exception;
	//插入和更新
	void saveOrUpdate(Course course) throws Exception;
	//通过id删除
	void deleteById(long id) throws Exception;
	//批量删除
	void baticDelete(List<Long> ids) throws Exception;
}
