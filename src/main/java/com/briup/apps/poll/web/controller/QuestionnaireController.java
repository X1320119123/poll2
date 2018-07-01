package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;
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
			return MsgResponse.success("查询成功", list);
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
			return MsgResponse.success("查询成功", questionnaire);
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
			return MsgResponse.success("查询成功", list);
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
			return "保存或更新成功";
		} catch (Exception e) {
			return "failed"+e.getMessage();
		}
    }
    @ApiOperation(value="根据ID删除问卷信息",
    					notes="删除问卷的同时会把问卷和问题的关系解除掉，而问题保留")
    @GetMapping("deleteQuestionnaireById")
    		public MsgResponse deleteQuestionnaireById(long id){
    			try {
    				questionnaireService.deleteById(id);
    				return MsgResponse.success("删除成功", null);
    	} catch (Exception e) {
    				e.printStackTrace();
    				return MsgResponse.error(e.getMessage());
    	}
   }
    @ApiOperation(value="批量删除问卷信息")
    @GetMapping("baticDelete")
    public String baticDelete(Long[] ids){
    	try {
    		questionnaireService.baticDelete(ids);
			return "删除成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "failed"+e.getMessage();
		}
    }
    @ApiOperation(value="通过Id查询问卷" ,notes="查询问卷下所有问题")
    @GetMapping("findQuestionnaireVMById")
    public MsgResponse findQuestionnaireVMById(long id){
    	try {
			QuestionnaireVM qnVM=questionnaireService.findQuestionnaireById(id);
			return MsgResponse.success("查询成功", qnVM);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
    	
    }
    @ApiOperation(value="保存或修改问卷信息",notes="如果问卷参数中包含id执行更新操作，否则执行修改操作")
    @PostMapping("saveOrUpdateQuestionnaire")
    public MsgResponse saveOrUpdateQuestionnaire(Questionnaire questionnaire,long[] questionIds){
    	try {
			questionnaireService.saveOrUpdate(questionnaire,questionIds);
			return MsgResponse.success("保存修改陈功", null);
			
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
    }
    
}
