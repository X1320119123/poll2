package com.briup.apps.poll.dao.extend;

import java.util.List;

import com.briup.apps.poll.bean.extend.UserVM;

public interface UserVMMapper {
	
	List<UserVM> selectAll();
	
	List<UserVM> selectByGradeID(long id);
}
