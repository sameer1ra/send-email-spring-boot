package com.ram.SendingEmail;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class DataModel {

	@PostConstruct
	public void init() {

		Map<String, Set<String>> searchData = this.searchData;
		if (searchData.isEmpty()) {
			Set<String> emails =  new HashSet<>();
			emails.add("aliveisawesome.india@gmail.com");
			searchData.put("410206", emails);
		}
		
		age18 = true;
	}

	private Map<String, Set<String>> searchData = new HashMap<>();
	private boolean age18;
	private boolean age45;
	
	public boolean isAge18() {
		return age18;
	}

	public void setAge18(boolean age18) {
		this.age18 = age18;
	}

	public boolean isAge45() {
		return age45;
	}

	public void setAge45(boolean age45) {
		this.age45 = age45;
	}

	public Map<String, Set<String>> getSearchData() {
		return searchData;
	}

	public void setSearchData(Map<String, Set<String>> searchData) {
		this.searchData = searchData;
	}

	@Override
	public String toString() {
		return "DataModel [searchData=" + searchData + "]";
	}

}
