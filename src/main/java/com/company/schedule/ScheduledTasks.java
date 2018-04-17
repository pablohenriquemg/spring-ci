package com.company.schedule;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.company.model.Product;
import com.company.service.ProductService;

@Component
public class ScheduledTasks {

	@Autowired
	private ProductService productService;

	// every 10 hours
	@Scheduled(fixedRate = 36000000)
	public void reportCurrentTime() {
		Product p = new Product();
		p.setName("Fruit on day " + ZonedDateTime.now().getDayOfMonth());
		p.setDescription("Description on month " + ZonedDateTime.now().getMonth());
		productService.save(p);
	}
}
