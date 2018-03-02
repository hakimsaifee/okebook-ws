package com.ebook.service.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;

import com.ebook.common.dto.NotificationDTO;
import com.ebook.domain.entity.Notification;
import com.ebook.services.service.NotificationService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ImportResource("classpath:application-context-services.xml")
public class NotificationServiceTest {

    @Autowired
    private NotificationService notificationService;

    @Test
    public void contextLoads() {/*
    	
    	Notification entity = new Notification();
    	entity.setFileName("ABC");
    	entity.setNotificationName("N1");
    	entity.setFileLocation("ABCC");
		NotificationDTO notificationDTO = notificationService.save(entity );
		System.out.println("Notification DTO : " + notificationDTO);
    */}

    @SpringBootApplication
    static class TestConfiguration {
    }

}
