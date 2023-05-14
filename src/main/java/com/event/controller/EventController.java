package com.event.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.entity.Event;
import com.event.service.IEventService;




   @RestController
   @RequestMapping("/events")
   public class EventController {
	   
	   
	@Autowired
	private IEventService eventService;

	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getEventById(@PathVariable("id") int eventId) {
		System.out.println("Inside get method");
		Event event = eventService.getEventById(eventId);
		if (event == null) {
			System.out.println("This Event Was Not Found");
			return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
		}
		return new ResponseEntity<>(event,HttpStatus.OK);
	}

	@GetMapping("/get")
	public ResponseEntity<?> getAllEvent() {
		System.out.println("Inside get All method");
		List<Event> event = eventService.getAllEvent();
		if (event == null) {
			System.out.println("This Event Was Not Found");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(event,HttpStatus.OK);
	}

	
	@PostMapping("/create")
	public ResponseEntity<?> createEvent(@RequestBody Event event){   
		return new ResponseEntity<>(eventService.createEvent(event),HttpStatus.OK);
				
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateEvent(@RequestBody Event event,@PathVariable (name = "id")int eventId) throws Exception{
			return ResponseEntity.status(HttpStatus.CREATED).body(eventService.updateEvent(eventId,event));
		
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEvent(@PathVariable("id") int eventId) throws Exception {
		 try {
			 System.out.println("Inside Delete Controller");
	            eventService.deleteEvent(eventId);
	            return new ResponseEntity<>("Event deleted successfully", HttpStatus.OK);
	        } catch (NoSuchElementException e) {
	            return new ResponseEntity<>("Event with id not found", HttpStatus.NOT_FOUND);
	        }
	}}






