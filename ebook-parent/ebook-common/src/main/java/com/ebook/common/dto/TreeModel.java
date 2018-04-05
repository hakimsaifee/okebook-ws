package com.ebook.common.dto;

import java.util.List;

public class TreeModel {

	private String id;

	private String name;

	private String icon;

	private List<TreeModel> children;

	private String additionalData;

	@Override
	public String toString() {
		return "TreeModel [name=" + name + ", icon=" + icon + ", children=" + children + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public List<TreeModel> getChildren() {
		return children;
	}

	public void setChildren(List<TreeModel> children) {
		this.children = children;
	}

	public String getAdditionalData() {
		return additionalData;
	}

	public void setAdditionalData(String additionalData) {
		this.additionalData = additionalData;
	}
}
