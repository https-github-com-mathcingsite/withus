package com.project.withus.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * TeamInfoDto : contains team information
 * - userid
 * */
@ApiModel(value="TeamDto: 팀 정보", description = "팀의 상세 정보를 나타낸다")
public class TeamInfoDto {

	//Foreign Key
	@ApiModelProperty(value = "작성자 아이디")
	private String userid;
	
	
	//Team Info
	@ApiModelProperty(value = "팀 번호")
	private int teamno;
	@ApiModelProperty(value = "팀 모집 생성일")
	private String regtime;
	@ApiModelProperty(value = "제목")
	private String subject;
	@ApiModelProperty(value = "내용")
	private String content;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getTeamno() {
		return teamno;
	}
	public void setTeamno(int teamno) {
		this.teamno = teamno;
	}

	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	//Tags
	/*@ApiModelProperty(value = "C/C++")
	private boolean C; //tiny int로해놨는데 int 로 할까
	@ApiModelProperty(value = "Java")
	private boolean Java; 
	@ApiModelProperty(value = "Python")
	private boolean Python;
	@ApiModelProperty(value = "Spring")
	private boolean Spring;
	@ApiModelProperty(value = "Vue.js")
	private boolean Vue;
	@ApiModelProperty(value = "React")
	private boolean React;
	@ApiModelProperty(value = "swift")
	private boolean swift;
	@ApiModelProperty(value = "android")
	private boolean android;*/
	
	/*public boolean isC() {
		return C;
	}
	public void setC(boolean c) {
		C = c;
	}
	public boolean isJava() {
		return Java;
	}
	public void setJava(boolean java) {
		Java = java;
	}
	public boolean isPython() {
		return Python;
	}
	public void setPython(boolean python) {
		Python = python;
	}
	public boolean isSpring() {
		return Spring;
	}
	public void setSpring(boolean spring) {
		Spring = spring;
	}
	public boolean isVue() {
		return Vue;
	}
	public void setVue(boolean vue) {
		Vue = vue;
	}
	public boolean isReact() {
		return React;
	}
	public void setReact(boolean react) {
		React = react;
	}
	public boolean isSwift() {
		return swift;
	}
	public void setSwift(boolean swift) {
		this.swift = swift;
	}
	public boolean isAndroid() {
		return android;
	}
	public void setAndroid(boolean android) {
		this.android = android;
	}
	*/


}
