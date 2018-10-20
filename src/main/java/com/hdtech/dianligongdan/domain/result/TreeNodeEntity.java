package com.hdtech.dianligongdan.domain.result;

import java.util.List;
import java.util.Map;

public class TreeNodeEntity {
    /**
     * 节点ID
     */
    private String id;
    /**
     * 显示节点文本
     */
    private String text;
    /**
     * 节点状态，'open' 或 'closed'，默认：'open'。如果为'closed'的时候，将不自动展开该节点。
     */
    private String state;
    /**
     * 表示该节点是否被选中
     */
    private boolean checked;
    /**
     * 被添加到节点的自定义属性
     */
    private Map<String, Object> attributes;
    /**
     * 父节点ID
     */
    private String parentId;
    /**
     * 若干子节点
     */
    private List<TreeNodeEntity> children;

    public TreeNodeEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public List<TreeNodeEntity> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNodeEntity> children) {
        this.children = children;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}