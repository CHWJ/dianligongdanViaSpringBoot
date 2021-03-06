package com.hdtech.dianligongdan.domain.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "dianli_workorder_user")
@IdClass(WorkorderUser.class)
public class WorkorderUser extends BaseEntity implements Serializable {
	@Id @Column(name = "workorder_id")
	private int workorderId;
	@Id @Column(name = "manager_id")
	private int managerId;
	private String status;

	@Transient
	private String managerName;

	public WorkorderUser() {
	}

	public WorkorderUser(int workorderId, int managerId, String status, String managerName) {
		this.workorderId = workorderId;
		this.managerId = managerId;
		this.status = status;
		this.managerName = managerName;
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
}
