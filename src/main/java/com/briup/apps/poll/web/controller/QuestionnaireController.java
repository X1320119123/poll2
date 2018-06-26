package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.service.IQuestionnaireService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description="问卷相关接口")
@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {
	@Autowired
	private IQuestionnaireService questionnaireService;
	@ApiOperation(value="查询所有问卷")
    @GetMapping("findAllQuestionnaire")
	public MsgResponse findAllQuestionnaire(){
		try {
			List<Questionnaire> list = questionnaireService.findAll();
			//返回成功信息
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			//返回失败信息
			return MsgResponse.error(e.getMessage());
		}
	}
    @ApiOperation(value="通过id查询问卷")
    @GetMapping("findById")
    public MsgResponse findById(long id){
    	try {
    		Questionnaire questionnaire = questionnaireService.findById(id);
			return MsgResponse.success("success", questionnaire);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}		
    }
    @ApiOperation(value="通过name查询问卷详情")
    @GetMapping("query")
    public MsgResponse query(String keywords){
    	try {
			List<Questionnaire> list = questionnaireService.query(keywords);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
    }
    @ApiOperation(value="保存或更新")
    @PostMapping("saveOrUpdate")
    public String saveOrUpdate(Questionnaire questionnaire){
    	try {
    		questionnaireService.saveOrUpdate(questionnaire);
			return "success";
		} catch (Exception e) {
			return "failed"+e.getMessage();
		}
    }
    @ApiOperation(value="通过id删除问卷信息")
    @GetMapping("deleteById")
    public String deleteById(long id){
    	try {
    		questionnaireService.deleteById(id);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failed"+e.getMessage();
		}
    }
    @ApiOperation(value="批量删除问卷信息")
    @GetMapping("baticDelete")
    public String baticDelete(Long[] ids){
    	try {
    		questionnaireService.baticDelete(ids);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failed"+e.getMessage();
		}
    }
    
}
