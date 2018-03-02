package com.ebook.domain.entity;

import java.io.Serializable;
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

	@Column(name = "file_location", nullable = false, length = 2000)
	private String fileLocation;

	@Column(name = "file_name", nullable = false, length = 512)
	private String fileName;

	@Column(name = "notification_name", nullable = false)
	@Lob
	private String notificationName;

	public Notification() {
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