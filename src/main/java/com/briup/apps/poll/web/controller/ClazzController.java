package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.extend.ClazzVM;
import com.briup.apps.poll.service.IClazzService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="班级相关接口")
@RestController
@RequestMapping("/clazz")
public class ClazzController {
	@Autowired
	private IClazzService clazzService;
	 @ApiOperation(value="查找所有班级信息",notes="单表")	
	 @GetMapping("findAllClazz")
	 public MsgResponse findAllClazz(){
			try {
				List<Clazz> list = clazzService.findAll();
				//返回成功信息
				return MsgResponse.success("success", list);
			} catch (Exception e) {
				e.printStackTrace();
				//返回失败信息
				return MsgResponse.error(e.getMessage());
			}
		}
	 @ApiOperation(value="查找所有班级信息",
			 notes="班级中携带班级所有属性年级信息及班主任信息")	
	 @GetMapping("findAllClazzVM")
	 public MsgResponse findAllClazzVM(){
			try {
				List<ClazzVM> list = clazzService.findAllClazzVM();
				//返回成功信息
				return MsgResponse.success("success", list);
			} catch (Exception e) {
				e.printStackTrace();
				//返回失败信息
				return MsgResponse.error(e.getMessage());
			}
		}
	 @ApiOperation(value="Id搜索班级信息")
	 @GetMapping("findById")
	 public MsgResponse findClazzById(@RequestParam long id){
			try {
				Clazz clazz= clazzService.findById(id);
				//返回成功信息
				return MsgResponse.success("success",clazz );
			} catch (Exception e) {
				e.printStackTrace();
				//返回失败信息
				return MsgResponse.error(e.getMessage());
			}
		}
	 @ApiOperation(value="关键字搜索班级信息")
	 @GetMapping("query")
		public  MsgResponse query(String keywords){
			try {
				List<Clazz> list = clazzService.query(keywords);
				//返回成功信息
				return MsgResponse.success("success",list);
			} catch (Exception e) {
				e.printStackTrace();
				//返回失败信息
				return MsgResponse.error(e.getMessage());
			}
		}
	 @ApiOperation(value="单个删除班级信息")
	  @GetMapping("deleteclazzById")
	  public MsgResponse deleteclazzById(@RequestParam long id){
		  //调用service层代码完成课程信息的删除
		  try {
			clazzService.deleteById(id);
			return MsgResponse.success("success","删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		} 
 
	 }
	 
	 @ApiOperation(value="保存或者更新班级信息")
	 @GetMapping("saveOrUpdateClazz")
		public MsgResponse saveOrUpdate(Clazz clazz){
			try {
				clazzService.saveOrUpdate(clazz);
				return MsgResponse.success("success",clazz);
			}
			catch (Exception e){
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}

	 @ApiOperation(value="批量删除班级信息")
	  @GetMapping("baticDelete")
	  public MsgResponse baticDelete(@RequestParam List<Long> ids){
		  //调用service层代码完成课程信息的删除
		  try {
			clazzService.baticDelete(ids);
			return MsgResponse.success("success","删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		} 

	 }
	 
	 
	 
	
}
