package com.event.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.event.entity.Atendee;

@Repository
public interface AtendeeRepo  extends JpaRepository<Atendee, Integer>{

}
