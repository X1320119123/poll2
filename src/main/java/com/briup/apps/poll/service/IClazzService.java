package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.extend.ClazzVM;

public interface IClazzService {
    //查询所有
	List<Clazz> findAll() throws Exception;
	
	List<ClazzVM> findAllClazzVM() throws Exception;
	//通过id查询
	ClazzVM findById(long id) throws Exception;
	//通过关键字查询
	List<Clazz> query(String keywords) throws Exception;
	//插入和更新
	void saveOrUpdate(Clazz clazz) throws Exception;
	//通过id删除
	void deleteById(long id) throws Exception;
	//批量删除
	void baticDelete(List<Long> ids) throws Exception;
	
}
