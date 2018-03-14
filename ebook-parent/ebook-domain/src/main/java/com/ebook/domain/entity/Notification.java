package com.ebook.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

/**
 * The persistent class for the notification database table.
 * 
 */
@Entity
@Table(name = "notification")
@NamedQuery(name = "Notification.findAll", query = "SELECT n FROM Notification n")
public class Notification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "NOTIFICATION_ID_GENERATOR", sequenceName = "AUTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTIFICATION_ID_GENERATOR")
	@Column(unique = true, nullable = false)
	private long id;

	@Column(name = "notification_heading", nullable = false, columnDefinition = "TEXT")
	private String notificationHeading;

	@Column(name = "notification_number", nullable = false, precision = 10, scale = 2)
	private BigDecimal notificationNumber;

	public Notification() {
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