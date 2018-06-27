package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.User;
import com.briup.apps.poll.bean.extend.UserVM;

public interface IUserService {
	
	List<User> findAll() throws Exception;
	
	User findById(long id) throws Exception;
	
	List<User> query(String keywords) throws Exception;
	
	List<UserVM> findAllUserVM() throws Exception;
	
	void saveOrUpdate(User user) throws Exception;
	
	void deleteById(long id) throws Exception;
	
	void baticDelete(Long[] ids) throws Exception;

}
