package com.hdtech.dianligongdan.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(name = "dianli_workorder")
public class Workorder  extends BaseEntity implements Serializable {
	@Column(name = "order_no")
	private String orderNo;
	private String address;
	@Enumerated(EnumType.STRING)
	private LevelEnum level;
	@Column(name = "refuse_reason")
	private String refuseReason;
	private LocalDateTime created;
	@Column(name = "import_id")
	private int importId;
	@Column(name = "organization_name")
	private String organizationName;
	@Column(name = "pros_content")
	private String prosContent;
	private String content;
	@Column(name = "finish_time")
	private LocalDateTime finishTime;
	@Enumerated(EnumType.STRING)
	private FilingEnum filing;
	@Column(name = "send_id")
	private int sendId;
	private int ishotwork;
	@Column(name = "send_time")
	private LocalDateTime sendTime;
	@Column(name = "organization_id")
	private int organizationId;
	@Column(name = "importrow_id")
	private int importrowId;
	@Id
	private int id;
	private LocalDateTime updated;
	@Enumerated(EnumType.STRING)
	private StatusEnum status;

	@Transient
	private String importName;
	@Transient
	private String sendName;
	@Transient
	private String workorderUserName;

	public Workorder() {
	}

	public String getWorkorderUserName() {
		return workorderUserName;
	}

	public void setWorkorderUserName(String workorderUserName) {
		this.workorderUserName = workorderUserName;
	}

	public String getSendName() {
		return sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LevelEnum getLevel() {
		return level;
	}

	public void setLevel(LevelEnum level) {
		this.level = level;
	}

	public String getRefuseReason() {
		return refuseReason;
	}

	public void setRefuseReason(String refuseReason) {
		this.refuseReason = refuseReason;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public int getImportId() {
		return importId;
	}

	public void setImportId(int importId) {
		this.importId = importId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getProsContent() {
		return prosContent;
	}

	public void setProsContent(String prosContent) {
		this.prosContent = prosContent;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(LocalDateTime finishTime) {
		this.finishTime = finishTime;
	}

	public FilingEnum getFiling() {
		return filing;
	}

	public void setFiling(FilingEnum filing) {
		this.filing = filing;
	}

	public int getSendId() {
		return sendId;
	}

	public void setSendId(int sendId) {
		this.sendId = sendId;
	}

	public int getIshotwork() {
		return ishotwork;
	}

	public void setIshotwork(int ishotwork) {
		this.ishotwork = ishotwork;
	}

	public LocalDateTime getSendTime() {
		return sendTime;
	}

	public void setSendTime(LocalDateTime sendTime) {
		this.sendTime = sendTime;
	}

	public int getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

	public int getImportrowId() {
		return importrowId;
	}

	public void setImportrowId(int importrowId) {
		this.importrowId = importrowId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public String getImportName() {
		return importName;
	}

	public void setImportName(String importName) {
		this.importName = importName;
	}
}
enum LevelEnum{
	normal,high
}
enum FilingEnum{
	y,n
}
enum StatusEnum{
	wait,
	send,
	accept,
	refuse,
	start,
	arrive,
	handle,
	nohandle,
	revoke,
	archive
}
