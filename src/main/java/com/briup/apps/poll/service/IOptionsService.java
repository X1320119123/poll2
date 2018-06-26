package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Options;

public interface IOptionsService {
	//查询所有
	List<Options> findAll() throws Exception;
	//通过id查询
	Options findById(long id) throws Exception;
	//通过关键字查询
	List<Options> query(String keywords) throws Exception;
	//插入和更新
	void saveOrUpdate(Options options) throws Exception;
	//通过id删除
	void deleteById(long id) throws Exception;
	//批量删除
	void baticDelete(Long[] ids) throws Exception;
}
