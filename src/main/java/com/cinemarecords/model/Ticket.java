package com.cinemarecords.model;

public class Ticket {
	private int ticketId;
	private int ticketPrice;
	private String movieTimings;
	private int totalNumberOfSeats;

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ticket(int ticketId, int ticketPrice, String movieTimings, int totalNumberOfSeats) {
		super();
		this.ticketId = ticketId;
		this.ticketPrice = ticketPrice;
		this.movieTimings = movieTimings;
		this.totalNumberOfSeats = totalNumberOfSeats;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getMovieTimings() {
		return movieTimings;
	}

	public void setMovieTimings(String movieTimings) {
		this.movieTimings = movieTimings;
	}

	public int getTotalNumberOfSeats() {
		return totalNumberOfSeats;
	}

	public void setTotalNumberOfSeats(int totalNumberOfSeats) {
		this.totalNumberOfSeats = totalNumberOfSeats;
	}
}
