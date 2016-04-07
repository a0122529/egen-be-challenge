package com.neu.iot.controller;

import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.neu.iot.dao.ReadDataDAO;
import com.neu.iot.model.Alert;
import com.neu.iot.model.PersonData;

// creating rest calls to read data from the monogodb

@Controller
@Path("/read")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReadDataController {
	public static String dbName = new String("iot");
	public static String packageName = "com.neu.iot.model";

	@Autowired
	private ReadDataDAO readData;

	// rest controller to fetch all the metrics data at once
	@GET
	@Path("/allMetrics")
	public List<PersonData> readAllMetricsData() throws UnknownHostException {
		System.out.println("entered all metircs");
		List<PersonData> allMetrics = readData.readMetricsAll();
		return allMetrics;
	}

	// rest controller to fetch all the alert data at once
	@GET
	@Path("/allAlerts")
	public List<Alert> readAllAlertData() throws UnknownHostException {
		List<Alert> allMetrics = readData.readAlertAll();
		return allMetrics;
	}

	// rest controller to fetch  the metrics data based on time conditions using rest input
	@GET
	@Path("/metrics/{startTimeStamp}/{endTimeStamp}")
	public List<PersonData> readSpecificMetrics(@PathParam("startTimeStamp") String startTime,
			@PathParam("endTimeStamp") String endTime) throws UnknownHostException, ParseException {
		List<PersonData> allMetrics = readData.readSpecificMetrics(startTime, endTime);
		return allMetrics;
	}

	// rest controller to fetch  the alert data based on time conditions using rest input
	@GET
	@Path("/alert/{startTimeStamp}/{endTimeStamp}")
	public List<Alert> readSpecificAlert(@PathParam("startTimeStamp") String startTime,
			@PathParam("endTimeStamp") String endTime) throws UnknownHostException, ParseException {
		List<Alert> allMetrics = readData.readSpecificAlert(startTime, endTime);
		return allMetrics;
	}

}
