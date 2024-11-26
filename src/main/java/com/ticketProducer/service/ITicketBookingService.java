package com.ticketProducer.service;

import com.ticketProducer.pojo.Passenger;

public interface ITicketBookingService 
{
	public Passenger registerPassenger(Passenger passenger);
	public Passenger getPassengerInfo(Integer pid);

}
