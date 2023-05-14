package com.event.service;

import java.util.List;

import com.event.entity.Event;

public interface IEventService {
	
	    Event getEventById(int id);

	    Event createEvent(Event event);

	    Event updateEvent(int id, Event event) throws Exception;

	    void deleteEvent(int id) throws Exception;

		List<Event> getAllEvent();

}
