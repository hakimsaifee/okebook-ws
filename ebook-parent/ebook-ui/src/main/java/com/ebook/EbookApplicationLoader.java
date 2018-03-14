package com.ebook;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.common.dto.PartDTO;
import com.ebook.common.dto.SectionDTO;
import com.ebook.services.service.NotificationService;
import com.ebook.services.service.PartService;

@SpringBootApplication(scanBasePackages = "com.ebook")
@ImportResource("classpath:application-context-services.xml")
@RestController
public class EbookApplicationLoader {

    private final NotificationService myService;

    @Autowired
    private PartService partService;
    
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
    
    @PostConstruct
    public void init() {}
}
