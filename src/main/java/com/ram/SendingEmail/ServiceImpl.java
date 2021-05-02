package com.ram.SendingEmail;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceImpl {

	@Autowired
	EmailSender mailSender;

	@Autowired
	DataModel dataModel;

	public boolean checkForAvailability() {

		Map<String, Set<String>> searchData = dataModel.getSearchData();
		boolean vaccineAvailable18=false;
		boolean vaccineAvailable45=false;
		
		RestTemplate rt = new RestTemplate();
		// String pincode = "410206";

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String date = dateFormat.format(Calendar.getInstance().getTime());
		System.out.println("date is " + date);

		for (String pincode : searchData.keySet()) {
			CowinResponse res = rt
					.getForObject("https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByPin?pincode="
							+ pincode + "&date=" + date, CowinResponse.class);
			System.out.println("CowinResponse is " + res);

			for (Centers center : res.getCenters()) {
				for (Session session : center.getSessions()) {
					if (session.getMin_age_limit() == 18 && session.getAvailable_capacity() > 0) {
						vaccineAvailable18 = true;
					}
					if (session.getMin_age_limit() == 45 && session.getAvailable_capacity() > 0) {
						vaccineAvailable45 = true;
					}
				}
			}
			if(dataModel.isAge18() && vaccineAvailable18)
				mailSender.sendEmail(pincode, res.toString());
			
			if(dataModel.isAge45() && vaccineAvailable45)
				mailSender.sendEmail(pincode, res.toString());
		}
		return vaccineAvailable18;
	}

}
