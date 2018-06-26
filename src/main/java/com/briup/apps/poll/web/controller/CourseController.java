package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.service.ICourseService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description="课程相关接口")
@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private ICourseService courseService;
	@ApiOperation(value="查询所有课程")
    @GetMapping("findAllCourse")
	public MsgResponse findAllCourse(){
		try {
			List<Course> list = courseService.findAll();
			//返回成功信息
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			//返回失败信息
			return MsgResponse.error(e.getMessage());
		}
	}
    @ApiOperation(value="通过id查询课程")
    @GetMapping("findById")
    public MsgResponse findById(long id){
    	try {
			Course course = courseService.findById(id);
			return MsgResponse.success("success", course);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}		
    }
    @ApiOperation(value="通过名字查询课程")
    @GetMapping("query")
    public MsgResponse query(String keywords){
    	try {
			List<Course> list = courseService.query(keywords);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
    }
    @ApiOperation(value="保存或更新")
    @PostMapping("saveOrUpdate")
    public String saveOrUpdate(Course course){
    	try {
			courseService.saveOrUpdate(course);
			return "保存或更新成功";
		} catch (Exception e) {
			return "失败"+e.getMessage();
		}
    }
    @ApiOperation(value="通过id删除")
    @GetMapping("deleteById")
    public String deleteById(long id){
    	try {
			courseService.deleteById(id);
			return "删除成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "删除失败"+e.getMessage();
		}
    }
    @ApiOperation(value="批量删除")
    @GetMapping("baticDelete")
    public String baticDelete(Long[] ids){
    	try {
			courseService.baticDelete(ids);
			return "批量删除成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "批量删除失败"+e.getMessage();
		}
    }
    
}
