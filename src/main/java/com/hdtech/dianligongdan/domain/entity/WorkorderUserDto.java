package com.hdtech.dianligongdan.domain.entity;

import java.io.Serializable;

public class WorkorderUserDto implements Serializable {
	private int workorderId;
	private int managerId;
	private String status;
	private String managerName;
	private String phoneNum;

	public WorkorderUserDto() {
	}

	public WorkorderUserDto(int workorderId, int managerId, String status, String managerName, String phoneNum) {
		this.workorderId = workorderId;
		this.managerId = managerId;
		this.status = status;
		this.managerName = managerName;
		this.phoneNum = phoneNum;
	}

	public void setWorkorderId(int workorderId){
		this.workorderId = workorderId;
	}

	public int getWorkorderId(){
		return workorderId;
	}

	public void setManagerId(int managerId){
		this.managerId = managerId;
	}

	public int getManagerId(){
		return managerId;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
}
