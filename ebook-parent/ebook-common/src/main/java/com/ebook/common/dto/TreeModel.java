package com.ebook.common.dto;

import java.util.List;

public class TreeModel {

	private Data data;
	
	private List<TreeModel> children;

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public List<TreeModel> getChildren() {
		return children;
	}

	public void setChildren(List<TreeModel> children) {
		this.children = children;
	}

	public void setData(String number, String data, String nodeType) {
		this.setData(new Data(data, number, nodeType));
	}

}

class Data {
	private String name;
	private String number;

	private String nodeType;

	public Data(String data, String number ,String nodeType) {
		this.name = data;
		this.nodeType = nodeType;
		this.number = number;
	}

	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

}
