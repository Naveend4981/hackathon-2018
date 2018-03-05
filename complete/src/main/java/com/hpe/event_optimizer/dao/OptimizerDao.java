package com.hpe.event_optimizer.dao;

import java.util.Set;

import com.hpe.event_optimizer.data.Event;

public interface OptimizerDao {

	public Set<String> getEvents();
	
	public boolean insertEvent(Event event);

}
