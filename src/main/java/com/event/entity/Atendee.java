package com.event.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="atendee")
public class Atendee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="attendee_id")
	private int attendeeId;
	
	@Column(name ="first_name" ,length =100)
	private String firstName;
	
	@Column(name ="last_name" ,length =100)
	private String lastName;
	
	@Column(name ="phone" ,length =100)
	private String phone;
	
	
//	@ManyToOne
//	@JoinColumn(name="event_id")
//	private Event event;

	

	
	
	
}
