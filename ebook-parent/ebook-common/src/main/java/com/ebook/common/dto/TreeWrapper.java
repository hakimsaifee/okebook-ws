package com.ebook.common.dto;

import java.util.List;

public class TreeWrapper {

	List<TreeModel> treeModels;

	List<SectionDTO> sections;

	public List<SectionDTO> getSections() {
		return sections;
	}

	public void setSections(List<SectionDTO> sections) {
		this.sections = sections;
	}

	public List<TreeModel> getTreeModels() {
		return treeModels;
	}

	public void setTreeModels(List<TreeModel> treeModels) {
		this.treeModels = treeModels;
	}

}
