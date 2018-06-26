package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.AnswersExample;
import com.briup.apps.poll.dao.AnswersMapper;
import com.briup.apps.poll.service.IAnswersService;

@Service
public class AnswersServiceImpl implements IAnswersService{
		@Autowired
		private AnswersMapper answersMapper;

		@Override
		public List<Answers> findAll() throws Exception {
			AnswersExample example=new AnswersExample();
			return answersMapper.selectByExample(example);
		}

		@Override
		public Answers findById(long id) throws Exception {
			return answersMapper.selectByPrimaryKey(id);
		}

}
