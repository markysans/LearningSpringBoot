package com.springtransaction.flightservice;

import com.springtransaction.flightservice.dto.FlightBookingAcknowledgement;
import com.springtransaction.flightservice.dto.FlightBookingRequest;
import com.springtransaction.flightservice.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class FlightServiceApplication {

	@Autowired
	FlightBookingService flightBookingService;

	@PostMapping("/bookFlightTicket")
	public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest flightBookingRequest) {
		return flightBookingService.bookFlightTicket(flightBookingRequest);
	}

	public static void main(String[] args) {
		SpringApplication.run(FlightServiceApplication.class, args);
	}

}
