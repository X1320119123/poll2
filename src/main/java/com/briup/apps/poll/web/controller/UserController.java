package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.User;
import com.briup.apps.poll.bean.extend.UserVM;
import com.briup.apps.poll.service.IUserService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

@Api(description="用户相关接口")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	
	@ApiOperation(value="查询所有用户信息",notes="单表")
	@GetMapping("findAllUser")
	public MsgResponse findAllUser(){
		try {
			List<User> list=userService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="查询所有用户信息",notes="查询教师信息中包含教师所在班级信息")
	@GetMapping("findAllUserVM")
	public MsgResponse findAllUserVM(){
		try {
			List<UserVM> list=userService.findAllUserVM();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过id查询")
	@GetMapping("findById")
	public MsgResponse findById(long id){
		try {
			 	User user=userService.findById(id);
			 	return MsgResponse.success("success", user);
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
			 List<User> list=userService.query(keywords);
			 return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="保存或更新")
	@PostMapping("saveOrUpdate")
	public String saveOrUpdate(User user){
		try {
			 	userService.saveOrUpdate(user);
			 	return "保存或更新";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "失败"+e.getMessage();
		}
	}
	
	@ApiOperation(value="通过id删除")
	@GetMapping("deleteById")
	public String deleteById(long id){
		try {
			 	userService.deleteById(id);
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
			 	userService.baticDelete(ids);
			 	return "删除成功";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "删除失败"+e.getMessage();
		}
	}
}
