package com.ebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.services.service.NotificationService;

@SpringBootApplication(scanBasePackages = "com.ebook")
@ImportResource("classpath:application-context-services.xml")
@RestController
public class EbookApplicationLoader {

    private final NotificationService myService;

    public EbookApplicationLoader(NotificationService myService) {
        this.myService = myService;
    }

    @GetMapping("/")
    public String home() {
//        return myService.message();
    	
    	
//    	Notification entity = new Notification();
//    	entity.setFileName("ABC");
//    	entity.setNotificationName("N1");
//    	entity.setFileLocation("ABCC");	
//    	
//		NotificationDTO notificationDTO = myService.save(entity );
//		System.out.println("Notification DTO : " + notificationDTO);
//		
//		Collection<NotificationDTO> list = myService.getAll();
//		System.out.println(list.size());

		return "Notification Crated";
    }

    public static void main(String[] args) {
        SpringApplication.run(EbookApplicationLoader.class, args);
    }
}
