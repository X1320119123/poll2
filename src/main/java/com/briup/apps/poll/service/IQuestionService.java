package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Question;

public interface IQuestionService {
	//查询题库所有题目
	List<Question> findAll() throws Exception;
	//通过ID查询题库题目
	Question findById(long id) throws Exception;
	//通过关键字查询题目
	List<Question> query(String keywords) throws Exception;
	//插入或者更新题目
	void saveOrUpdate(Question question) throws Exception;
	//通过ID删除题目
	void deleteById(long id) throws Exception;
	//批量删除题目
	void baticDelete(Long[] ids) throws Exception;

}
