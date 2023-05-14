package com.event.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.custom_exception.ResourceNotFoundException;
import com.event.entity.Event;
import com.event.repo.EventRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EventServiceImpl implements IEventService {
	    @Autowired
	    private EventRepo eventRepository;

	   
	   
	    @Override
	    public Event getEventById(int id) {
	        Optional<Event> optionalEvent = eventRepository.findById(id);
	        if (optionalEvent.isPresent()) {
	            Event event = optionalEvent.get();
	            return event;
	        } else {
	            throw new ResourceNotFoundException("Event not found with id: " + id);
	        }
	    }

	    
	    @Override
	    public Event createEvent(Event event) {
	        Event savedEvent = eventRepository.save(event);
	        return savedEvent;
	    }
	    
	    @Override
	    public Event updateEvent(int id, Event event) throws Exception {
	        Optional<Event> optionalEvent = eventRepository.findById(id);
	        if (optionalEvent.isPresent()) {
	            Event existingEvent = optionalEvent.get();
	            existingEvent.setEventName(event.getEventName());
	            existingEvent.setTagLine(event.getTagLine());
	            existingEvent.setSchedule(event.getSchedule());
	            existingEvent.setDescription(event.getDescription());
	            existingEvent.setModerator(event.getModerator());
	            existingEvent.setImage(event.getImage());
	            existingEvent.setCategory(event.getCategory());
	            existingEvent.setSubCategory(event.getSubCategory());
	            existingEvent.setRegorRank(event.getRegorRank());
	            existingEvent.setAtendees(event.getAtendees());

	            return eventRepository.save(existingEvent);
	        }else {
	        	
	        	throw new ResourceNotFoundException("Not Found");
	        }
	        
		
	        
	    }
	    
	    //For Deleting An Event
	    @Override
	    public void deleteEvent(int id)  {
	    	
	    	Event event = eventRepository.findById(id).
	    			orElseThrow(()-> new ResourceNotFoundException("invalid User"));
	        eventRepository.deleteById(id);
			
	      
	    }

	    // For getting All Events 

		@Override
		public List<Event> getAllEvent() {
			return eventRepository.findAll();
		}
	
}
