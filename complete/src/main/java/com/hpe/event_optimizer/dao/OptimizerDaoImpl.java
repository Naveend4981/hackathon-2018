package com.hpe.event_optimizer.dao;

import org.springframework.stereotype.Repository;

@Repository
public class OptimizerDaoImpl implements OptimizerDao {

	@Override
	public String getHello() {
		return "Hello World !!";
	}

}
