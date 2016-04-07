package com.neu.iot.controller;

import java.util.Date;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.neu.iot.dao.SendDataDAO;
import com.neu.iot.model.PersonData;

// creating rest controller to add data using post in the mongodb

@Controller
@Path("/weightEntry")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CreateDataController {

	@Autowired
	private SendDataDAO sendWeightDAO;

	@POST()
	@PermitAll
	public void addWeightService(PersonData personData) {
		if (personData.getTimestamp() == 0) {
			Date date = new Date();
			personData.setTimestamp(date.getTime());
		}
		sendWeightDAO.sendData(personData);
	}

}
