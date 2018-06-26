package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.School;
import com.briup.apps.poll.service.ISchoolService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;

@Api(description="学校相关接口")
@RestController
@RequestMapping("/school")
public class SchoolController {
	@Autowired
	private ISchoolService schoolService;
	
	@GetMapping("findAllSchool")
	public MsgResponse findAllSchool(){
		try {
			List<School> list=schoolService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("saveOrUpdate")
	public String saveOrUpdate(School school){
		try {
			schoolService.saveOrUpdate(school);
			return "成功";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "失败"+e.getMessage();
		}
	}

}
