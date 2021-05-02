package com.ram.SendingEmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

	@Autowired
	ServiceImpl serviceImpl;
	
	@Scheduled(fixedRate = 60000*5)
	public void fixedRateSch() {
		
		serviceImpl.checkForAvailability();

	}
}
