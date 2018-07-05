package com.briup.apps.poll.bean.extend;

import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.bean.User;

public class SurveyVM {
	private long id;
	private String status;
	private String surveyDate;
	private String code;
	private Double average;
	private Course course;
	private ClazzVM clazzVM;
	private User user;
	private QuestionnaireVM questionnaireVM;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSurveyDate() {
		return surveyDate;
	}
	public void setSurveyDate(String surveyDate) {
		this.surveyDate = surveyDate;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}

	public ClazzVM getClazzVM() {
		return clazzVM;
	}
	public void setClazzVM(ClazzVM clazzVM) {
		this.clazzVM = clazzVM;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public QuestionnaireVM getQuestionnaireVM() {
		return questionnaireVM;
	}
	public void setQuestionnaireVM(QuestionnaireVM questionnaireVM) {
		this.questionnaireVM = questionnaireVM;
	}
	public Double getAverage() {
		return average;
	}
	public void setAverage(Double average) {
		this.average = average;
	}
	
}
