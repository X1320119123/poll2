package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.survey;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.service.ISurveyService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="课调相关接口")
@RestController
@RequestMapping("/survey")
public class SurveyController {

	@Autowired
	private ISurveyService surveyService;
	@ApiOperation(value="查询课调相关信息")
	@GetMapping("findallSurvey")
	
	public MsgResponse findallSurvey(){
		try {
			List<survey> list =surveyService.findall();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("findallSurveyVM")
	
	public MsgResponse findallSurveyVM(){
		try {
			List<SurveyVM> list = surveyService.findallSurveyVM();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="通过ID搜索课调信息")
	@GetMapping("findByIdSurvey")
	public MsgResponse findByIdSurvey(@RequestParam long id){
		try {
			survey survey=surveyService.findById(id);
			return MsgResponse.success("success", survey);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="关键字搜索")
	@GetMapping("querys")
	public MsgResponse query(String keywords){
		try {
			List<survey> list=surveyService.query(keywords);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	 @ApiOperation(value="通关ID删除课调信息")
	  @GetMapping("deleteByIdSurvey")
	  public MsgResponse deleteByIdSurvey(@RequestParam long id){
		  //调用service层代码完成课程信息的删除
		  try {

			  surveyService.deleteById(id);
			return MsgResponse.success("success","删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		} 

	 }
	 @ApiOperation(value="保存或者更新课调信息")
	 @GetMapping("saveOrUpdateSurvey")
		public MsgResponse saveOrUpdateSurvey(survey survey){
			try {

				surveyService.saveOrUpdate(survey);
				return MsgResponse.success("success",survey);
			}
			catch (Exception e){
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
	 @ApiOperation(value="批量删除课调信息")
	  @GetMapping("baticDeleteSurvey")
	  public MsgResponse baticDeleteSurvey(@RequestParam Long[] ids){
		  //调用service层代码完成课程信息的删除
		  try {
			surveyService.baticDelete(ids);
			return MsgResponse.success("success","删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		} 

	 }
}