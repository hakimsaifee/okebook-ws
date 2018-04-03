package com.ebook.common.dto;

import java.util.List;

public class TreeModel {

	private String value;

	private String icon;

	private List<TreeModel> children;
	
	private String additionalData;

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "TreeModel [value=" + value + ", icon=" + icon + ", children=" + children + "]";
	}

	public void setValue(String value) {
		this.value = value;
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
