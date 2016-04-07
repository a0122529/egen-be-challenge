package com.neu.iot.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neu.iot.commonUtils.CommomGenerator;
import com.neu.iot.model.PersonData;

@Controller
public class SchedulerController {

	static int count = 0;

	// implemented spring scheduler to run the add weight rest service after
	// every 5 seconds
	 @Scheduled(cron = "*/05 * * * * *")
	public void callDataSendRest() throws ClientProtocolException, IOException {
		//
		PersonData personData = new PersonData();
		personData.setName("name" + count);
		Date date = new Date();
		personData.setTimestamp(date.getTime());
		personData.setWeight(CommomGenerator.randomFloat(120, 200));
		personData.setBaseWeight(CommomGenerator.randomFloat(120, 200));

		// calling the rest service from here to add data to mongodb
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost("http://localhost:8080/IoTApplication/rest/weightEntry");
		ObjectMapper mapper = new ObjectMapper();
		String personJSON = mapper.writeValueAsString(personData);
		StringEntity input = new StringEntity(personJSON);
		input.setContentType("application/json");
		post.setEntity(input);
		// HttpResponse response = client.execute(post);
		client.execute(post);
		count++;
	}

	public void callMetricsAllFetch() throws ClientProtocolException, IOException {
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet("http://localhost:8080/IoTApplication/rest/read/allMetrics");
		HttpResponse response = client.execute(request);
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line = "";
		while ((line = rd.readLine()) != null) {
			System.out.println(line);
		}
	}

	public void callAlertAllFetch() throws ClientProtocolException, IOException {
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet("http://localhost:8080/IoTApplication/rest/read/allAlerts");
		HttpResponse response = client.execute(request);
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line = "";
		while ((line = rd.readLine()) != null) {
			System.out.println(line);
		}
	}

	public void callMetricsSpecific() throws ClientProtocolException, IOException {
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(
				"http://localhost:8080/IoTApplication/rest/read/metrics/2006-01-01--07:14:38.000/2016-04-07--23:14:38.000");
		HttpResponse response = client.execute(request);
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line = "";
		while ((line = rd.readLine()) != null) {
			System.out.println(line);
		}
	}

	public void callAlertSpecific() throws ClientProtocolException, IOException {
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(
				"http://localhost:8080/IoTApplication/rest/read/alert/2006-01-01--07:14:38.000/2016-04-07--23:14:38.000");
		HttpResponse response = client.execute(request);
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line = "";
		while ((line = rd.readLine()) != null) {
			System.out.println(line);
		}
	}

}
