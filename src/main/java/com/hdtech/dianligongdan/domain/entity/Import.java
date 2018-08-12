package com.hdtech.dianligongdan.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "dianli_import")
public class Import extends BaseEntity implements Serializable {
	@Column(name = "address_column")
	private String addressColumn;
	@Column(name = "end_tag_column")
	private int endTagColumn;
	@Column(name = "organization_column")
	private String organizationColumn;
	@Column(name = "start_row")
	private int startRow;
	private String name;
	@Column(name = "cat_id")
	private int catId;
	@Column(name = "create_work_rule")
	private String createWorkRule;
	@Id
	private int id;
	@Column(name = "end_tag")
	private String endTag;

	public Import() {
	}

	public String getAddressColumn() {
		return addressColumn;
	}

	public void setAddressColumn(String addressColumn) {
		this.addressColumn = addressColumn;
	}

	public int getEndTagColumn() {
		return endTagColumn;
	}

	public void setEndTagColumn(int endTagColumn) {
		this.endTagColumn = endTagColumn;
	}

	public String getOrganizationColumn() {
		return organizationColumn;
	}

	public void setOrganizationColumn(String organizationColumn) {
		this.organizationColumn = organizationColumn;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCreateWorkRule() {
		return createWorkRule;
	}

	public void setCreateWorkRule(String createWorkRule) {
		this.createWorkRule = createWorkRule;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEndTag() {
		return endTag;
	}

	public void setEndTag(String endTag) {
		this.endTag = endTag;
	}
}
