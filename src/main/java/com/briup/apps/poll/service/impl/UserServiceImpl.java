package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.User;
import com.briup.apps.poll.bean.UserExample;
import com.briup.apps.poll.bean.extend.UserVM;
import com.briup.apps.poll.dao.UserMapper;
import com.briup.apps.poll.dao.extend.UserVMMapper;
import com.briup.apps.poll.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	
	private UserMapper UserMapper;
	
	@Autowired
	private UserVMMapper userVMMapper;
	
	@Override
	public List<User> findAll() throws Exception{
		UserExample example=new UserExample();
		return UserMapper.selectByExample(example);
	} 
	
	@Override
	public User findById(long id) throws Exception{
		return UserMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> query(String keywords) throws Exception{
		UserExample example=new UserExample();
		example.createCriteria().andNameLike("%"+keywords+"%");
		return UserMapper.selectByExample(example);
	}

	@Override
	public void saveOrUpdate(User user) throws Exception {
		// TODO Auto-generated method stub
		if (user.getId()!=null) {
			UserMapper.updateByPrimaryKey(user);
			
		} else {
			UserMapper.insert(user);
		}
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		UserMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void baticDelete(Long[] ids) throws Exception {
		// TODO Auto-generated method stub
		for(long id:ids){
			UserMapper.deleteByPrimaryKey(id);
		}	
	}

	@Override
	public List<UserVM> findAllUserVM() throws Exception {
		// TODO Auto-generated method stub
		return userVMMapper.selectAll();
	} 
	
}
