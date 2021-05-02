package com.ram.SendingEmail;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class CowinResponse {

	List<Centers> centers;

	public List<Centers> getCenters() {
		return centers;
	}

	public void setCenters(List<Centers> centers) {
		this.centers = centers;
	}

	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
	    String json = null;
		try {
			json = mapper.writeValueAsString(centers);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
}
