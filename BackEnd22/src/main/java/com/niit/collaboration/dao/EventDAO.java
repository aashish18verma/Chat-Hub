package com.niit.collaboration.dao;

import java.util.List;


import com.niit.collaboration.model.Event;

public interface EventDAO {
	public List<Event> list();
	public boolean save(Event event);
	public boolean update(Event event);

	public boolean delete(Event event);
	public Event getEventByID(int id);
	public Event getEventByName(String name);

}
