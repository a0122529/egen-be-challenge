package com.neu.iot.dao;

import org.easyrules.api.RulesEngine;
import org.easyrules.core.RulesEngineBuilder;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.springframework.stereotype.Component;

import com.neu.iot.model.PersonData;
import com.neu.iot.rules.DecreaseWeight;
import com.neu.iot.rules.IncreaseWeight;

@Component
public class SendDataDAO extends MongoConnection{
	public static String dbName = new String("iot");
	public static String packageName = "com.neu.iot.model";

	public void sendData(PersonData personData) {
		Datastore datastore = datastoreConn(dbName, packageName);
		Key<PersonData> savedPerson = datastore.save(personData);
		RulesEngine rulesEngine = RulesEngineBuilder.aNewRulesEngine().build();
		rulesEngine.registerRule(new DecreaseWeight(personData));
		rulesEngine.registerRule(new IncreaseWeight(personData));
		rulesEngine.fireRules();
	}

}
