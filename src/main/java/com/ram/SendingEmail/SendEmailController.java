package com.ram.SendingEmail;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class SendEmailController {
	

	@Autowired
	ServiceImpl service;
	
	@Autowired
	DataModel dataModel;

	@RequestMapping(value = "/sendemail")
	public String send() throws AddressException, MessagingException, IOException {
		
	   return "Email sent successfully";   
	}
	
	@GetMapping(value = "/check")
	public String checkAvailability() {
		return service.checkForAvailability();
	}
	
	@GetMapping(value = "/addpin")
	public DataModel addpin(@RequestParam String pin, @RequestParam String email) {
		Map<String, Set<String>> searchData = dataModel.getSearchData();
		if(searchData.containsKey(pin)) {
			Set<String> newList = searchData.get(pin);
			newList.add(email);
			searchData.put(pin, newList);
		} else {
			Set<String> emails =  new HashSet<>();
			emails.add(email);
			searchData.put(pin, emails);
		}
		return dataModel;
	}
	
	@GetMapping(value = "/removepin")
	public DataModel removepin(@RequestParam String pin) {
		Map<String, Set<String>> searchData = dataModel.getSearchData();
		searchData.remove(pin);
		return dataModel;
	}
	
	@GetMapping(value = "/removemail")
	public DataModel removemail(@RequestParam String pin, @RequestParam String email) {
		Map<String, Set<String>> searchData = dataModel.getSearchData();
		if(searchData.containsKey(pin)) {
			Set<String> newList = searchData.get(pin);
			newList.remove(email);
			searchData.put(pin, newList);
		} else {
			Set<String> emails =  new HashSet<>();
			emails.remove(email);
			searchData.put(pin, emails);
		}
		return dataModel;
	}	
	
	
	@GetMapping(value = "/getdata")
	public DataModel getData() {
		return dataModel;
	}
	
	@GetMapping(value = "/setage")
	public DataModel setage() {
		dataModel.setAge45(true);
		return dataModel;
	}
	
	
}
