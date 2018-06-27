package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.extend.GradeVM;

public interface IGradeService {
	
	List<Grade> findAll() throws Exception;
	
	Grade findById(long id) throws Exception;
	
	List<Grade> query(String keywords) throws Exception;
	
	List<GradeVM> findAllGradeVM() throws Exception;
	
	void saveOrUpdate(Grade grade) throws Exception;
	
	void deleteById(long id) throws Exception;
	
	void baticDelete(Long[] ids) throws Exception;



}
