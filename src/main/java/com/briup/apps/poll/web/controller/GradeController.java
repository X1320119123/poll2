package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.service.IGradeService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(description="年级相关接口")
@RestController
@RequestMapping("/grade")
public class GradeController {
	@Autowired
	private IGradeService gradeService;
	
	@ApiOperation(value="查询所有年级")
	@GetMapping("findAllGrade")
	public MsgResponse findAllGrade(){
		try {
			 List<Grade> list=gradeService.findAll();
			 return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过id查询")
	@GetMapping("findById")
	public MsgResponse findById(long id){
		try {
				Grade grade=gradeService.findById(id);
				return MsgResponse.success("success", grade);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过关键字查询")
	@GetMapping("query")
	public MsgResponse query(String keywords){
		try {
			 	List<Grade> list=gradeService.query(keywords);
			 	return MsgResponse.success("success",list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="保存或更新")
	@PostMapping("svaOrGrade")
	public MsgResponse saveOrGrade(Grade grade){
		try {
			 	gradeService.saveOrUpdate(grade);
			 	return MsgResponse.success("success", grade);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value="通过id删除")
	@GetMapping("deleteById")
	public String deleteById(long id){
		try {
			 	gradeService.deleteById(id);
			 	return "删除成功";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "删除失败"+e.getMessage();
		}
	}
	
	@ApiOperation(value="批量删除")
	@GetMapping("baticDelete")
	public String baticDelete(Long[] ids){
		try {
			 	gradeService.baticDelete(ids);
			 	return "删除成功";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "删除失败"+e.getMessage();
		}
	} 
	
}
