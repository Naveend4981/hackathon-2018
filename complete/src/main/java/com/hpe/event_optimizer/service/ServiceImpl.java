package com.hpe.event_optimizer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hpe.event_optimizer.dao.OptimizerDao;
import com.hpe.event_optimizer.dao.OptimizerDaoImpl;

@Service
public class ServiceImpl implements EventService{

	@Autowired
	private OptimizerDao optimizerDao;

	@Override
	public String getHello() {
		return optimizerDao.getHello();
	}
}
