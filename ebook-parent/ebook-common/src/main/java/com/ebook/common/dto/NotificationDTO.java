package com.ebook.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class NotificationDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;

	private String notificationHeading;

	private BigDecimal notificationNumber;

	public NotificationDTO() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNotificationHeading() {
		return notificationHeading;
	}

	public void setNotificationHeading(String notificationHeading) {
		this.notificationHeading = notificationHeading;
	}

	public BigDecimal getNotificationNumber() {
		return notificationNumber;
	}

	public void setNotificationNumber(BigDecimal notificationNumber) {
		this.notificationNumber = notificationNumber;
	}

}