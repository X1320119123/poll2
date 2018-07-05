package com.briup.apps.poll.bean.extend;

import java.util.List;


public class UserVM {
	private Long id;
	private String name;
	private String gender;
	private String birth;
	private String hiredate;
	private String genre;
	
	private List<ClazzVM> clazzVMs;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	

	public List<ClazzVM> getClazzVMs() {
		return clazzVMs;
	}

	public void setClazzVMs(List<ClazzVM> clazzVMs) {
		this.clazzVMs = clazzVMs;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	

	
	
}
