package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.extend.AnswersVM;
import com.briup.apps.poll.service.IAnswersService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description="答题卡接口")
@RestController
@RequestMapping("/answers")
public class AnswersController {
	@Autowired
	private IAnswersService answersService;
	@ApiOperation(value="查询所有答案")
	@GetMapping("findAllAnswers")
	public MsgResponse findAllAnswers(){
		try {
			List<Answers> list = answersService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="查询所有答案")
	@GetMapping("findAllAnswersVM")
	public MsgResponse findAllAnswersVM(){
		try {
			List<AnswersVM> list = answersService.findAllAnswersVM();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="通过id查询答案")
	@GetMapping("findById")
	public MsgResponse findById(long id){
		try {
			Answers answers=answersService.findById(id);
			return MsgResponse.success("success", answers);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}
