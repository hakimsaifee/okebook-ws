package com.ebook.domain.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * The persistent class for the chapter database table.
 * 
 */
@Entity
@Table(name = "article")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ARTICLE_GENERATOR")
	@GenericGenerator(name = "ARTICLE_GENERATOR", strategy = "sequence", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequence", value = "ARTICLE_SEQ") })
	@Column(unique = true, nullable = false)
	private long id;


	@Column(name = "article_name", length=1024)
	private String articleName;

	@Column(name = "article_path", length=1024)
	private String articlePath;

	@Column(name = "publish_date")
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


	@Override
	public String toString() {
		return "Article [id=" + id + ", articleName=" + articleName + ", articlePath=" + articlePath + ", publishDate="
				+ publishDate + "]";
	}

	
}