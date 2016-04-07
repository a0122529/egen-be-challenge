package com.neu.iot.dao;

import java.net.UnknownHostException;
import java.text.ParseException;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Component;


import com.neu.iot.commonUtils.CommonConverters;
import com.neu.iot.model.Alert;
import com.neu.iot.model.PersonData;

@Component
public class ReadDataDAO extends MongoConnection {
	public static String dbName = new String("iot");
	public static String packageName = "com.neu.iot.model";

	public List<PersonData> readMetricsAll() throws UnknownHostException {
		Datastore datastore = datastoreConn(dbName, packageName);
		Query<PersonData> query = datastore.createQuery(PersonData.class);
		List<PersonData> personData = query.asList();
//		for (PersonData person : personData) {
//			System.out.println(person.getName());
//		}
		return personData;
	}

	public List<Alert> readAlertAll() throws UnknownHostException {
		Datastore datastore = datastoreConn(dbName, packageName);
		Query<Alert> query = datastore.createQuery(Alert.class);
		List<Alert> alertData = query.asList();
//		for (Alert person : alertData) {
//			System.out.println(person.getName());
//		}
		return alertData;
	}

	public List<PersonData> readSpecificMetrics(String startTime, String endTime) throws ParseException {
		Datastore datastore = datastoreConn(dbName, packageName);
		System.out.println(startTime);
		System.out.println(endTime);
		long startSeconds = CommonConverters.stringToSeconds(startTime);
		long endSeconds = CommonConverters.stringToSeconds(endTime);
		System.out.println(startSeconds);
		System.out.println(endSeconds);
		Query<PersonData> query = datastore.createQuery(PersonData.class).disableValidation();
		query.field("timestamp").greaterThan(startSeconds);
		query.field("timestamp").lessThan(endSeconds);
		List<PersonData> allPersonData = query.asList();
		return allPersonData;

	}
	
	public List<Alert> readSpecificAlert(String startTime, String endTime) throws ParseException {
		Datastore datastore = datastoreConn(dbName, packageName);
		System.out.println(startTime);
		System.out.println(endTime);
		long startSeconds = CommonConverters.stringToSeconds(startTime);
		long endSeconds = CommonConverters.stringToSeconds(endTime);
		System.out.println(startSeconds);
		System.out.println(endSeconds);
		Query<Alert> query = datastore.createQuery(Alert.class).disableValidation();
		query.field("timestamp").greaterThan(startSeconds);
		query.field("timestamp").lessThan(endSeconds);
		List<Alert> allPersonData = query.asList();
		return allPersonData;

	}
}
