package com.briup.apps.poll.web.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.survey;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.service.IAnswersService;
import com.briup.apps.poll.service.ISurveyService;
import com.briup.apps.poll.util.MsgResponse;
import com.briup.apps.poll.vm.SurveyAndAnswersVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="课调相关接口")
@RestController
@RequestMapping("/survey")
public class SurveyController {

	@Autowired
	private ISurveyService surveyService;
	@Autowired
	private IAnswersService answersService;
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
	@ApiOperation(value="查询课调信息")
	@GetMapping("findallSurveyVM")
	
	public MsgResponse findallSurveyVM(){
		try {
			List<SurveyVM> list =surveyService.findallSurveyVM();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation(value="通过ID搜索课调信息")
	@GetMapping("findallSurveyVMID")
	
	public MsgResponse findallSurveyVMID(long id){
		try {
			SurveyVM surveyVM=surveyService.selectById(id);
			return MsgResponse.success("success",surveyVM);
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
	public MsgResponse querys(String keywords){
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
			return MsgResponse.success("success",null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		} 

	 }
	 @ApiOperation(value="保存或者更新课调信息")
	 @PostMapping("saveOrUpdateSurvey")
		public MsgResponse saveOrUpdateSurvey(survey survey){
			try {

				surveyService.saveOrUpdate(survey);
				return MsgResponse.success("success",null);
			}
			catch (Exception e){
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
	 @ApiOperation(value="批量删除课调信息")
	  @PostMapping("baticDeleteSurvey")
	  public MsgResponse baticDeleteSurvey(@RequestParam Long[] ids){
		  //调用service层代码完成课程信息的删除
		  try {
			surveyService.baticDelete(ids);
			return MsgResponse.success("success",null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		} 

	 }
	 @ApiOperation(value="开启课调",notes="只有在课调未开启的时候开启课调")
	@GetMapping("beginSurvey")
	 public MsgResponse beginSurvey(long id){
		 try {
//			 通过ID查询课调
			 survey survey=surveyService.findSurveyById(id);
//			 修改课调编号/状态
			 if(survey.getStatus().equals(survey.STATUS_INIT)){
//				 开启课调
				 survey.setStatus(survey.STATUS_BEGIN);
//				 
				 survey.setCode(survey.getId().toString());
				 surveyService.saveOrUpdate(survey);
				 return MsgResponse.success("开启成功", null);
			 }
			 else{
				 return MsgResponse.error("当前状态必须为未开启状态");
			 }
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	 }
	 @ApiOperation(value="根据班级ID查询出该班级下所有的已审核的课调", 
				notes="")
		@GetMapping("findSurveyByClazzId")
		public MsgResponse findSurveyByClazzId(long id){
			try {
				List<SurveyVM> list = surveyService.findByClazzIdAndCheckPass(id);
				return MsgResponse.success("success", list);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		
		
		
		@ApiOperation(value="预览课调", 
				notes="只有当课调状态为审核通过的时候才能预览课调")
		@GetMapping("previewSurvey")
		public MsgResponse previewSurvey(long id){
			try {
				//1. 课调的信息（课程，班级，讲师，问卷，平均分） SurveyVM
				SurveyVM surveyVM = surveyService.selectById(id);
				if(surveyVM!=null && 
						surveyVM.getStatus().equals(survey.STATUS_CHECK_PASS)){
					//2. 课调的结果 主观题列表 Answers
					List<Answers> answers = answersService.findAnswersBySurveyId(id);
					//3. 将课调信息和课调答卷信息封装到一个对象中
					SurveyAndAnswersVM savm = new SurveyAndAnswersVM();
					savm.setSurveyVM(surveyVM);
					savm.setAnswers(answers);
					return MsgResponse.success("success", savm);
				} else {
					return MsgResponse.error("课调状态不合法");
				}
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}

		
		@ApiOperation(value="审核课调", 
				notes="只有当前课调的状态为未审核的时候才能被审核，"
						+ "参数id表示课调编号，参数status的取值只能为0/1,"
						+ "如果是0表示审核不通过，如果是1表示审核通过")
		@GetMapping("checkSurvey")
		public MsgResponse checkSurvey(long id,int status){
			try {
				//1. 通过id找课调
				survey survey = surveyService.findSurveyById(id);
				//2. 判断当前课调的状态是否为未审核状态
				if(survey!=null && survey.getStatus().equals(survey.STATUS_CHECK_UN)){
					if(status == 0){
						//2.1 审核不通过
						survey.setStatus(survey.STATUS_CHECK_NOPASS);
					} else {
						//2.0 审核通过
						survey.setStatus(survey.STATUS_CHECK_PASS);
					}
					surveyService.saveOrUpdate(survey);
					return MsgResponse.success("审核完成！", null);
				} else {
					return MsgResponse.error("课调状态不合法");
				}
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		
		
		@ApiOperation(value="去审核课调", 
				notes="返回课调的信息以及课调下所有答卷信息")
		@GetMapping("toCheckSurvey")
		public MsgResponse toCheckSurvey(long id){
			try {
				//1. 通过id查询课调信息
				SurveyVM surveyVM = surveyService.selectById(id);
				//2. 如果课调状态为未审核才能审核
				if(surveyVM.getStatus().equals(survey.STATUS_CHECK_UN)){
					//查询出该课调写所有答卷
					List<Answers> list = answersService.findAnswersBySurveyId(id);
					//计算出课调的平均分
					//所有单个平均分的总和
					double total = 0;
					for(Answers answer : list){
						//["5","5","4"]
						String[] arr = answer.getSelections().split("[|]");
						double singleTotal = 0;
						for(String a: arr){
							singleTotal += Integer.parseInt(a);
						}
						//每个学生对于老师的平均分
						double singleAverage = singleTotal/arr.length;
						total += singleAverage;
					}
					double average = total/list.size();
					surveyVM.setAverage(average);
					
					//将平均分保存到数据库中
					survey survey = surveyService.findSurveyById(id);
					//如果数据库中的平均分没有设定，我们再进行设定，否则不做操作
					if(survey.getAverage()== null){
						survey.setAverage(average);
						surveyService.saveOrUpdate(survey);
					}
					
					//如何将surveyVM 和list 返回,封装到一个对象中
					SurveyAndAnswersVM savm = new SurveyAndAnswersVM();
					savm.setSurveyVM(surveyVM);
					savm.setAnswers(list);
					return MsgResponse.success("success", savm);
					
				} else {
					return MsgResponse.error("课调状态不合法");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		@ApiOperation(value="关闭课调", 
				notes="只有在课调状态为开启的时候才能关闭课调")
		@GetMapping("stopSurvey")
		public MsgResponse stopSurvey(long id){
			try {
				//1. 通过id查询出课调
				survey survey = surveyService.findSurveyById(id);
				if(survey!=null && survey.getStatus().equals(survey.STATUS_BEGIN)){
					survey.setStatus(survey.STATUS_CHECK_UN);
					surveyService.saveOrUpdate(survey);
					return MsgResponse.success("关闭课调成功",null);
				} else {
					return MsgResponse.error("当前课调状态必须为未开启状态");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
	}
}
