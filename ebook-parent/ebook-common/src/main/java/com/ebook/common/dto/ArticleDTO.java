package com.ebook.common.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class ArticleDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5912156333502229472L;

	/**
	 * 
	 */

	private long id;

	private String articleName;

	private String articlePath;

	private Timestamp publishDate;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getArticleName() {
		return articleName;
	}


	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}


	public String getArticlePath() {
		return articlePath;
	}


	public void setArticlePath(String articlePath) {
		this.articlePath = articlePath;
	}


	public Timestamp getPublishDate() {
		return publishDate;
	}


	public void setPublishDate(Timestamp publishDate) {
		this.publishDate = publishDate;
	}
	
	
}
