package com.hpe.event_optimizer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hpe.event_optimizer.service.EventService;
import com.hpe.event_optimizer.service.ServiceImpl;

@RestController
@RequestMapping("/")
public class ApplicatonController {
	
	@Autowired
	private EventService service;
	
	@GetMapping("test")
	public String getHello(){
		return service.getHello();
		//return "Hello World";
	}
}
