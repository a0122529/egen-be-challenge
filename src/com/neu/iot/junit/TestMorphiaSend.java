package com.neu.iot.junit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.neu.iot.controller.CreateDataController;
import com.neu.iot.controller.SchedulerController;
import com.neu.iot.dao.ReadDataDAO;
import com.neu.iot.dao.SendDataDAO;
import com.neu.iot.model.Alert;
import com.neu.iot.model.PersonData;

public class TestMorphiaSend {

	@Test
	public void checkInsert() throws UnknownHostException {

		SendDataDAO sendData = new SendDataDAO();
		PersonData pd = new PersonData();
		pd.setName("Rahul5");
		pd.setBaseWeight(100);
		pd.setWeight(200);
		Date date = new Date();
		pd.setTimestamp(date.getTime());
		sendData.sendData(pd);

		ReadDataDAO readData = new ReadDataDAO();
		List<PersonData> justData = readData.readMetricsAll();
		PersonData foundData = new PersonData();
		for (PersonData pd1 : justData) {
			System.out.println(pd1.getName());
			if (pd1.getName().equals("Rahul5")) {
				foundData = pd1;
			}
		}
		assertEquals("Rahul5", foundData.getName());
	}

	public void alertCheckOverWeight() throws UnknownHostException {
		ReadDataDAO readData = new ReadDataDAO();
		List<Alert> justData = readData.readAlertAll();
		Alert newAlert = new Alert();
		for (Alert alert : justData) {
			System.out.println(alert.getName());
			if (alert.getName().equals("Rahul5")) {
			}
		}
		assertEquals("Detects over weight", newAlert.getAlertName());
	}
}
