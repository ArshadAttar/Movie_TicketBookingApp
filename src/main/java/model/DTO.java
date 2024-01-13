package model;

public class DTO {
	private String movieName;
	private String  movieTheater;
	private int ticket;
	
	public double getPrice(double d) {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	private double price;
	public double getPrice;
	
	public int getTicket() {
		return ticket;
	}
	public void setTicket(int ticket) {
		this.ticket = ticket;
	}
	public DTO() {
		super();
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieTheater() {
		return movieTheater;
	}
	public void setMovieTheater(String movieTheater) {
		this.movieTheater = movieTheater;
	}
}
