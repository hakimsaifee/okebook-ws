package com.ebook.common.dto;

import java.io.Serializable;

public class NotificationDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;

	private String fileLocation;

	private String fileName;

	private String notificationName;

	public NotificationDTO() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFileLocation() {
		return this.fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getNotificationName() {
		return notificationName;
	}

	public void setNotificationName(String notificationName) {
		this.notificationName = notificationName;
	}

}