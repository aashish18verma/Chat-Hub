package com.niit.collaboration.test;

import org.junit.Assert;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.EventDAO;
import com.niit.collaboration.model.Event;

public class EventTestCase {
	@Autowired
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static Event event;
	@Autowired
	private static EventDAO eventDAO;

	@BeforeClass
	public static void initialize() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		event = (Event) context.getBean("event");

		eventDAO = (EventDAO) context.getBean("eventDAO");

	}

	@Test
	public void createEventTestCase() {
		event.setId("3004");
		event.setName("My event");

		event.setVenue("colloboartion event");

		boolean flag = eventDAO.save(event);
		Assert.assertEquals("createEventTestCase", true, flag);
	}

	@Test
	public void deleteEventTestCase() {
		Event event = (Event) eventDAO.getEventByID(3004);
		boolean flag = eventDAO.delete(event);
		Assert.assertEquals("delete event test case", true, flag);
	}

	@Test
	public void updateEventTestCase() {
		Event event = (Event) eventDAO.getEventByID(3007);
		event.setId("3012");
		event.setName("MCameras");

		event.setVenue("collaboration event");

		boolean flag = eventDAO.update(event);

		Assert.assertEquals("update event test case", true, flag);
	}

}
