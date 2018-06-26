package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Answers;

public interface IAnswersService {
	
	List<Answers> findAll() throws Exception;
	
	Answers findById(long id) throws Exception;
	
}
