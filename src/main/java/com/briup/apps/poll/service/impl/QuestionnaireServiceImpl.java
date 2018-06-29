package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.QuestionnaireExample;
import com.briup.apps.poll.bean.QuestionnaireQuestion;
import com.briup.apps.poll.bean.QuestionnaireQuestionExample;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;
import com.briup.apps.poll.dao.QuestionnaireMapper;
import com.briup.apps.poll.dao.QuestionnaireQuestionMapper;
import com.briup.apps.poll.dao.extend.QuestionnaireVMMapper;
import com.briup.apps.poll.service.IQuestionnaireService;

@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService {
@Autowired
private QuestionnaireMapper questionnaireMapper;
@Autowired
private QuestionnaireVMMapper qnVMMapper;
@Autowired
private QuestionnaireQuestionMapper qqMapper;
	@Override
	public List<Questionnaire> findAll() throws Exception {
		QuestionnaireExample example=new QuestionnaireExample();
		return questionnaireMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public Questionnaire findById(long id) throws Exception {
		return questionnaireMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Questionnaire> query(String keywords) throws Exception {
		QuestionnaireExample example=new QuestionnaireExample();
		example.createCriteria().andNameLike(keywords);
		return questionnaireMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void saveOrUpdate(Questionnaire questionnaire) throws Exception {
		if(questionnaire.getId()!=null){
			questionnaireMapper.updateByPrimaryKeyWithBLOBs(questionnaire);
		}else{
			questionnaireMapper.insert(questionnaire);
		}
		
	}

	@Override
	public void deleteById(long id) throws Exception {
		questionnaireMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void baticDelete(Long[] ids) throws Exception {
		for(long id:ids){
			questionnaireMapper.deleteByPrimaryKey(id);
		}
		
	}

	@Override
	public QuestionnaireVM findQuestionnaireById(long id) throws Exception {
		
		return qnVMMapper.selectById(id);
	}

	@Override
	public void saveOrUpdate(Questionnaire questionnaire, long[] questionIds) throws Exception {
		if(questionnaire.getId() == null){
			questionnaireMapper.insert(questionnaire);
			long questionnaireId=questionnaire.getId();
			for(long questionId :questionIds){
				QuestionnaireQuestion qq =new QuestionnaireQuestion();
				qq.setQuestionId(questionId);
				qq.setQuestionnaireId(questionnaireId);
				qqMapper.insert(qq);
			}
			
		}else{
			questionnaireMapper.updateByPrimaryKey(questionnaire);
			long questionnaireId = questionnaire.getId();
			QuestionnaireQuestionExample example= new QuestionnaireQuestionExample();
			example.createCriteria().andQuestionnaireIdEqualTo(questionnaireId);
			qqMapper.deleteByExample(example);
			
			
			for(long questionId :questionIds){
				QuestionnaireQuestion qq =new QuestionnaireQuestion();
				qq.setQuestionId(questionId);
				qq.setQuestionnaireId(questionnaireId);
				qqMapper.insert(qq);
			}
		}
		
	}

}
