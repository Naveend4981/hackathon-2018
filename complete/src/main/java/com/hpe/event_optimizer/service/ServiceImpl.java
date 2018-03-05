package com.hpe.event_optimizer.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hpe.event_optimizer.dao.OptimizerDao;
import com.hpe.event_optimizer.data.Event;

@Service
public class ServiceImpl implements EventService{

	@Autowired
	private OptimizerDao optimizerDao;

	@Override
	public Set<String> getEvents() {
		return optimizerDao.getEvents();
	}
	
	@Override
	public boolean insertEvent(Event event){
		return optimizerDao.insertEvent(event);
	}
}
