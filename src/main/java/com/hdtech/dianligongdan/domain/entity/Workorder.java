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
	private Level level;
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
	private Filing filing;
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
	private Status status;

	public Workorder() {
	}
}
enum Level{
	normal,high
}
enum Filing{
	y,n
}
enum Status{
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
