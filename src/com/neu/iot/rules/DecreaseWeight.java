package com.neu.iot.rules;

import java.util.Date;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import org.easyrules.core.BasicRule;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;

import com.neu.iot.dao.MongoConnection;
import com.neu.iot.model.Alert;
import com.neu.iot.model.PersonData;

@Rule(name = "decrease weight", description = "Detects under weight")
public class DecreaseWeight extends BasicRule {

	public String dbName = new String("iot");
	public String packageName = "com.neu.iot.model";

	private PersonData personData;

	public DecreaseWeight(PersonData personData) {
		this.personData = personData;
	}

	@Condition
	public boolean evaluate() {
		System.out.println("Auto reach in boolean evaluate decrease");
		float weight = personData.getWeight();
		float baseWeight = personData.getBaseWeight();
		float thresholdBaseWt = (baseWeight - ((10 * baseWeight) / 100));
		if (weight < thresholdBaseWt) {
			return true;
		}
		return false;
	}

	@Action(order = 1)
	public void execute() throws Exception {
		System.out.println("Auto reach in execute evaluate descrease");
		Alert alert = new Alert();
		alert.setAlertName("Detects under weight");
		alert.setName(personData.getName());
		Date date = new Date();
		alert.setTimestamp(date.getTime());
		Datastore datastore = MongoConnection.datastoreConn(dbName, packageName);
		Key<Alert> savedAlert = datastore.save(alert);
		System.out.println(savedAlert.getId());

	}
}
