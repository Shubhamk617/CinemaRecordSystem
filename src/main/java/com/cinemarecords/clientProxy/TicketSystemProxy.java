package com.cinemarecords.clientProxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties.FeignClientConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cinemarecords.model.Ticket;

@FeignClient(name = "ticket-booking-system", configuration = FeignClientConfiguration.class)
public interface TicketSystemProxy {

	@GetMapping("/ticket/getTicketsByMovieId")
	public List<Ticket> getTicketsByMovieId(@RequestParam int movieId);
}
