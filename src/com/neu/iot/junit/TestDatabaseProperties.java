package com.neu.iot.junit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.mongodb.MongoClient;
import com.neu.iot.dao.MongoConnection;

public class TestDatabaseProperties {

	@Test
	public void dataBaseProperties() {

		MongoConnection mc = new MongoConnection();
		MongoClient mongoClient = mc.connection();
		List<String> dbName = mongoClient.getDatabaseNames();
		assertEquals("iot", dbName.get(0));

	}
}
