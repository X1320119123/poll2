package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.survey;
import com.briup.apps.poll.bean.extend.SurveyVM;



public interface ISurveyService {
//	查询所有
	List<SurveyVM> findallSurveyVM() throws Exception;

	List<survey> findall() throws Exception;
//	通过ID查询
	SurveyVM selectById(long id) throws Exception;
	
	survey findById(long id) throws Exception;
//	关键字查询
	List<survey> query(String keywors) throws Exception;
	
	
	
//	插入和更新
	void saveOrUpdate(survey survey) throws Exception;
//	通过ID删除
	void deleteById(long id) throws Exception;
//	批量删除
	void baticDelete(Long[] ids)throws Exception;
}
