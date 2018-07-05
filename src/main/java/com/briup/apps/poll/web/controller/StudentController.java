package com.briup.apps.poll.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.survey;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.service.IAnswersService;
import com.briup.apps.poll.service.ISurveyService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
	
@Api(description="学生相关接口")
@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private ISurveyService surveyService;
	@Autowired
	private IAnswersService  anwersService;
	
	@ApiOperation("登陆课调")
	@GetMapping("loginSurvey")
	public MsgResponse loginSurvey(long id){
		try {
			SurveyVM surveyVM=surveyService.selectById(id);
			if(surveyVM!=null && surveyVM.getStatus().equals(survey.STATUS_BEGIN)){
				return MsgResponse.success("success", surveyVM);
			}else{
				return MsgResponse.error("课调状态不合法");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="提交答卷")
	@PostMapping("submirAnwers")
		public MsgResponse submirAnwers(Answers answers){
		try {
			anwersService.saveOrUpdate(answers);
			return MsgResponse.success("提交成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
