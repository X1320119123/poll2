package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.extend.AnswersVM;

public interface IAnswersService {
	
	List<Answers> findAll() throws Exception;
	
	Answers findById(long id) throws Exception;
	
	List<AnswersVM> findAllAnswersVM() throws Exception;
	
}
