package com.ebook.service.test;


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;

import com.ebook.common.dto.PartDTO;
import com.ebook.common.dto.SectionDTO;
import com.ebook.services.service.NotificationService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ImportResource("classpath:application-context-services.xml")
@ComponentScan("com.ebook")
public class PartServiceTest {
 
//    @Autowired
//    private PartService partService;
@Autowired
private NotificationService ns;
	
    @Test
    public void contextLoads() {
    	
    	PartDTO partDto = new PartDTO();
    	partDto.setPartHeading("Part test");
    	partDto.setPartNumber(new BigDecimal(2.1));
    	Set<SectionDTO> sections = new HashSet<>();
    	SectionDTO sectionDTO = new SectionDTO();
    	sectionDTO.setSectionNumber(new BigDecimal("223"));
    	sectionDTO.setSectionHeading("this is section");
		partDto.setSections(sections);
		
//		partService.save(partDto);
    }

    @SpringBootApplication
    static class TestConfiguration {
    }

}
