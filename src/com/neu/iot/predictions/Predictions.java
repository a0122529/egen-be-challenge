package com.neu.iot.predictions;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.neu.iot.dao.ReadDataDAO;
import com.neu.iot.model.Alert;

public class Predictions {

	public static String dbName = new String("iot");
	public static String packageName = "com.neu.iot.model";

	public void weightAnalysis() {
		ReadDataDAO readData = new ReadDataDAO();
		List<Alert> alerts = null;
		ArrayList<Alert> overWeight = new ArrayList<>();
		ArrayList<Alert> underrWeight = new ArrayList<>();
		try {
			alerts = readData.readAlertAll();
			System.out.println("total alerts for weight are " + alerts.size());
			for (Alert alert : alerts) {
				System.out.println(alert.getAlertName());
				if (alert.getAlertName().equals("Detects over weight")) {
					overWeight.add(alert);

				} else {
					underrWeight.add(alert);
				}
			}
			System.out.println("Total over weight counts is " + overWeight.size());
			System.out.println("Total under weight counts is " + underrWeight.size());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
