package com.hpe.event_optimizer.service;

import java.util.Set;

import com.hpe.event_optimizer.data.Event;

public interface EventService {

	public Set<String> getEvents();
	
	public boolean insertEvent(Event event);

}
