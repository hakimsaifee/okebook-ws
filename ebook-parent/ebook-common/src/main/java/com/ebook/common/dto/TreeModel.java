package com.ebook.common.dto;

import java.math.BigDecimal;
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

	public void setData(BigDecimal number, String data, NodeTypeEnum nodeType) {
		this.setData(new Data(data, number, nodeType));
	}

}

class Data {
	private String name;
	private BigDecimal number;

	private NodeTypeEnum nodeType;

	public Data(String data, BigDecimal number ,NodeTypeEnum nodeType) {
		this.name = data;
		this.nodeType = nodeType;
		this.number = number;
	}

	public BigDecimal getNumber() {
		return number;
	}

	public void setNumber(BigDecimal number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NodeTypeEnum getNodeType() {
		return nodeType;
	}

	public void setNodeType(NodeTypeEnum nodeType) {
		this.nodeType = nodeType;
	}

}
