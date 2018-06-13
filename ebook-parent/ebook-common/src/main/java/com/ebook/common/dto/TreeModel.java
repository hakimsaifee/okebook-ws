package com.ebook.common.dto;

import java.io.Serializable;
import java.util.List;

public class TreeModel<T extends Serializable> {

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

	public void setData(T number, String data, String nodeType) {
		this.setData(new Data(data, number, nodeType));
	}
	public void setData(T number, String data, String nodeType, Long id) {
		this.setData(new Data(data, number, nodeType, id));
	}

}

class Data<T extends Serializable> {
	private String name;
	private  T number;
	private Long id;

	private String nodeType;

	public Data(String data, T number ,String nodeType) {
		this.name = data;
		this.nodeType = nodeType;
		this.number = number;
	}
	public Data(String data, T number ,String nodeType, Long id) {
		this.name = data;
		this.nodeType = nodeType;
		this.number = number;
		this.id = id;
	}

	public T getNumber() {
		return number;
	}
	
	public void setNumber(T number) {
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

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}
