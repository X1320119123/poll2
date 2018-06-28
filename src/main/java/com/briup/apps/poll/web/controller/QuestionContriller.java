package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.extend.QuestionVM;
import com.briup.apps.poll.service.IQuestionService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description="题库相关接口")
@RestController
@RequestMapping("/question")
public class QuestionContriller {
	@Autowired
	
	private IQuestionService questionService;
	@ApiOperation(value="保存或修改问题",
			notes="当id不为空时表示修改,否则表示更新,保存和更新是需要提交选项数据")
	@PostMapping("saveOrUpdateQuestion")
	public MsgResponse saveOrUpdateQuestionVM(QuestionVM questionVM){
		try {
			questionService.saveOrUpdateVM(questionVM);
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
		
	}
	
	@ApiOperation(value="查询题库所有题目",notes="单表")
	@GetMapping("findAllQuestion")
	public MsgResponse findAllQuestion(){
		try{
			List<Question> list=questionService.findAll();
			//返回查询成功信息
			return MsgResponse.success("success", list);
		}catch (Exception e) {
			e.printStackTrace();
			//返回查询失败信息
			return MsgResponse.error(e.getMessage());
		}
	}
	

	@ApiOperation(value="查询题库所有题目",notes="查询问题中包含该问题所有的属性信息")
	@GetMapping("findAllQuestionVM")
	public MsgResponse findAllQuestionVM(){
		try{
			List<QuestionVM> list=questionService.findAllQuestionVM();
			//返回查询成功信息
			return MsgResponse.success("success", list);
		}catch (Exception e) {
			e.printStackTrace();
			//返回查询失败信息
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	@ApiOperation(value="通过ID查询题目")
	@GetMapping("findById")
	public MsgResponse findById(long id){
		try {
			Question question=questionService.findById(id);
			//返回成功查询信息
			return MsgResponse.success("success", question);
		} catch (Exception e) {
			e.printStackTrace();
			//返回查询失败信息
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="保存或更新题目")
	@PostMapping("saveOrUpdate")
	public String saveOrUpdate(Question question){
		try {
			questionService.saveOrUpdate(question);
			//返回保存或者更新成功信息
			return "保存或更新成功";
		} catch (Exception e) {
			// 返回保存或者更新失败信息
			return "保存或更新失败"+e.getMessage();
		}
	}
	
	@ApiOperation(value="通过id删除题目")
	@GetMapping("deleteById")
	public MsgResponse deleteById(long id){
		try {
			questionService.deleteById(id);
			//返回删除成功信息
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			//返回删除失败信息
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="批量删除")
	@GetMapping("baticDelete")
	public String baticDelete(Long[] ids){
		try {
			questionService.baticDelete(ids);
			//返回批量删除成功信息
			return "批量删除成功";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			//返回删除失败信息
			return "批量删除失败"+e.getMessage();
		}
	}
	
	    @ApiOperation(value="通过名字查询题目")
	    @GetMapping("query")
	    public MsgResponse query(String keywords){
	    	try {
				List<Question> list = questionService.query(keywords);
				//返回查询成功信息
				return MsgResponse.success("success", list);
			} catch (Exception e) {
				e.printStackTrace();
				//返回查询失败信息
				return MsgResponse.error(e.getMessage());
			}
	    }

}
