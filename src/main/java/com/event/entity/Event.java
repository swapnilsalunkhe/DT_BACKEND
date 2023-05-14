package com.event.entity;

import java.sql.Array;
import java.time.LocalDate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="event")
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="event_id" )
	private int event_id;
	
	@Column(name ="event_name" ,length =100)
	private String eventName;
	
	@Column
	private String type;
	
	@Column(name = "tag_line", length =100)
	private String tagLine;
	
	@Column(name="discription")
	private String description;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "schedule")
	private LocalDateTime schedule;
	
	@Column(name ="image")
	private String image;
	
	@Column(name = "moderator_id")
	private int moderator;
	
	
	@Column
	private String category;
	
	
	@Column(name="sub_category")
	private String subCategory;
	
	
	@Column(name = "regor_rank")
	private int regorRank;
	

	@OneToMany( cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Atendee> atendees;

	}
	
	
	
	
	
	
	


