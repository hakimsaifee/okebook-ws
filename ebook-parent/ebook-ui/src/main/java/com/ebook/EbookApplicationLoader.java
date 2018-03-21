package com.ebook;

import java.math.BigDecimal;
import java.util.Collection;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.common.dto.PartDTO;
import com.ebook.services.service.NotificationService;
import com.ebook.services.service.PartService;

@SpringBootApplication(scanBasePackages = "com.ebook")
@ImportResource("classpath:application-context-services.xml")
@RestController
public class EbookApplicationLoader {

    private final NotificationService myService;

    public EbookApplicationLoader(NotificationService myService) {
        this.myService = myService;
    }

    @Autowired
    private PartService partService;
    @GetMapping("/")
    public String home() {

		return "Notification Crated";
    }

    public static void main(String[] args) {
        SpringApplication.run(EbookApplicationLoader.class, args);
    }
    
    @PostConstruct
    public void init() {
    	
    	Collection<PartDTO> parts = partService.getAll();   
    	System.out.println(parts);
    }
}
