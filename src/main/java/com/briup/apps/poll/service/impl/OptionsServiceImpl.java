package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.bean.OptionsExample;
import com.briup.apps.poll.dao.OptionsMapper;
import com.briup.apps.poll.service.IOptionsService;

@Service
public class OptionsServiceImpl implements IOptionsService{
	@Autowired
	private  OptionsMapper optionsMapper; 
	@Override
	public List<Options> findAll() throws Exception {
		OptionsExample example=new OptionsExample();
		return optionsMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public Options findById(long id) throws Exception {
		//通过Id查询
		return optionsMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Options> query(String keywords) throws Exception {
		//通过关键字查询
		OptionsExample example=new OptionsExample();
		example.createCriteria().andLabelLike(keywords);
		return optionsMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void saveOrUpdate(Options options) throws Exception {
		// 存储或更新
		if(options.getId()!=null){
			optionsMapper.updateByPrimaryKeyWithBLOBs(options);
		}else{
			optionsMapper.insert(options);
		}
		
	}

	@Override
	public void deleteById(long id) throws Exception {
		// 通过id删除
		optionsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void baticDelete(Long[] ids) throws Exception {
		// 批量删除
		for(long id : ids){
			optionsMapper.deleteByPrimaryKey(id);
		}
	}

}
