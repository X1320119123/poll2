package com.briup.apps.poll.bean.extend;

import java.util.List;

public class QuestionnaireVM {
  private long id;
  private String name;
  private String description;
  private List<QuestionVM> questionVMs;
  
  
public List<QuestionVM> getQuestionVMs() {
	return questionVMs;
}
public void setQuestionVMs(List<QuestionVM> questionVMs) {
	this.questionVMs = questionVMs;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

}
