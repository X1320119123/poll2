package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
    @ApiOperation(value="保存或更新答案")
    @PostMapping("saveOrUpdate")
    public String saveOrUpdate(Answers answers){
    	try {
			answersService.saveOrUpdate(answers);
			return "保存或更新成功";
		} catch (Exception e) {
			return "失败"+e.getMessage();
		}
    }
    
    @ApiOperation(value="通过id删除答案")
    @GetMapping("deleteById")
    public MsgResponse deleteById(long id){
		try {
			answersService.deleteById(id);
			return MsgResponse.success("success","删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}	
    }

    @ApiOperation(value="删除答卷主观题",
			notes="单选题答案和多选题答案不收影响")
	@GetMapping("deleteAnswerContent")
	public MsgResponse deleteAnswerContent(long id){
		try {
			// 通过id找到答卷
			Answers answer = answersService.findById(id);
			// 设置答卷内容更为空
			answer.setContent("");
			answersService.saveOrUpdate(answer);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="修改答卷主观题",
			notes="")
	@GetMapping("updateAnswerContent")
	public MsgResponse updateAnswerContent(long id,String content){
		try {
			// 通过id找到答卷
			Answers answer = answersService.findById(id);
			// 设置答卷内容为content
			answer.setContent(content);
			answersService.saveOrUpdate(answer);
			return MsgResponse.success("修改成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

}
}
