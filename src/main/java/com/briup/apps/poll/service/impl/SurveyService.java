package com.briup.apps.poll.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.survey;
import com.briup.apps.poll.bean.surveyExample;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.dao.surveyMapper;
import com.briup.apps.poll.dao.extend.SurveyVMMapper;
import com.briup.apps.poll.service.ISurveyService;

@Service

public class SurveyService implements ISurveyService{
	@Autowired
	private surveyMapper surveyMapper;
	@Autowired 
	private SurveyVMMapper surveyVMMapper;
	@Override
	public List<survey> findall() throws Exception {
		// TODO Auto-generated method stub
		surveyExample example=new surveyExample();
		return surveyMapper.selectByExample(example);
				
	}

	@Override
	public survey findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return surveyMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<survey> query(String keywords) throws Exception {
		// TODO Auto-generated method stub
		surveyExample example=new surveyExample();
//		添加一个条件，name属性中包含keywords关键字
		example.createCriteria().andCodeLike(keywords);
		return surveyMapper.selectByExample(example);
	}

	@Override
	public void saveOrUpdate(survey survey) throws Exception {
		// TODO Auto-generated method stub
		if(survey.getId()!=null){
//			更新
			surveyMapper.updateByPrimaryKey(survey);
		}else{
//			插入
			survey.setStatus(survey.STATUS_INIT);
			survey.setCode("");
			Date now =new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String surveyDate=sdf.format(now);
			survey.setSurveydate(surveyDate);
			surveyMapper.insert(survey);
		}
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		surveyMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void baticDelete(Long[] ids) throws Exception {
		// TODO Auto-generated method stub
		for(long id : ids){
			surveyMapper.deleteByPrimaryKey(id);
		}
	}


	@Override
	public List<SurveyVM> findallSurveyVM() throws Exception {
		// TODO Auto-generated method stub
		return surveyVMMapper.selectAll();
	}


	@Override
	public SurveyVM selectById(long id) throws Exception {
		// TODO Auto-generated method stub
		return surveyVMMapper.selectById(id);
	}



}
