package com.neu.iot.junit;

import static org.junit.Assert.*;

import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.List;

import org.junit.Test;

import com.neu.iot.dao.ReadDataDAO;
import com.neu.iot.dao.SendDataDAO;
import com.neu.iot.model.Alert;
import com.neu.iot.model.PersonData;

public class TestCheckData {

	@Test
	public void notEmptyTestMetrics() throws UnknownHostException {
		ReadDataDAO readDataDAO = new ReadDataDAO();
		List<PersonData> allData = readDataDAO.readMetricsAll();
		assertNotEquals(0, allData.size());
	}

	@Test
	public void notEmptyTestAlert() throws UnknownHostException {
		ReadDataDAO readDataDAO = new ReadDataDAO();
		List<Alert> allData = readDataDAO.readAlertAll();
		assertNotEquals(0, allData.size());
	}

	@Test
	public void specificDataMetrics() throws ParseException {
		ReadDataDAO readData = new ReadDataDAO();
		List<PersonData> allData = readData.readSpecificMetrics("2006-04-07--23:14:38.000", "2014-04-07--23:14:38.000");
		assertEquals(0, allData.size());
	}

	@Test
	public void specificDataAlert() throws ParseException {
		ReadDataDAO readData = new ReadDataDAO();
		List<Alert> allData = readData.readSpecificAlert("2006-04-07--23:14:38.000", "2014-04-07--23:14:38.000");
		assertEquals(0, allData.size());
	}

}
