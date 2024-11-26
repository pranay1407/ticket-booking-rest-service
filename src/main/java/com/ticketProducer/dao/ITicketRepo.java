package com.ticketProducer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketProducer.pojo.Passenger;

public interface ITicketRepo extends JpaRepository<Passenger, Integer> 
{

}
