package com.ticketProducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticketProducer.pojo.Passenger;
import com.ticketProducer.pojo.Ticket;
import com.ticketProducer.service.ITicketBookingService;

@RestController
@RequestMapping("/api/ticket-booking")
public class TicketBookingController 
{
	@Autowired
   private ITicketBookingService service;
	
	@PostMapping("/getTicketNumber")
	public ResponseEntity<Ticket> enrollPassenger(@RequestBody Passenger passenger)
	{
		Passenger pas=service.registerPassenger(passenger);
		Ticket ticket =new Ticket();
	
		ticket.setTicketNumber(pas.getPid());
		
		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);		

	}
	
	@GetMapping("/getTicket/{ticketNumber}")
	public ResponseEntity<Ticket> getTicket(@PathVariable("ticketNumber")Integer ticketNumber)
	{
		Ticket ticket=new Ticket();
		Passenger pass = service.getPassengerInfo(ticketNumber);
		ticket.setTicketNumber(pass.getPid());
		ticket.setName(pass.getName());
		ticket.setDepature(pass.getDepature());
		ticket.setArrival(pass.getArrival());
		ticket.setDateOfJourney(pass.getDateOfJourney());
		ticket.setStatus("Confirmed");
		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
	}
	
}
