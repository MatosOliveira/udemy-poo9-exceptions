/**
 * 
 */
package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.exceptions.DomainException;

/**
 * Classe que contem as informacoes de uma reserva.
 * 
 * Obs: Para os calculos de datas utilizamos LocalDate e Duration.
 * 
 * @author Matos - 15.06.2023
 *
 */
public class Reservation {

	private Integer roomNumber;
	private LocalDate checkin;
	private LocalDate checkout;
	
	private static DateTimeFormatter formatoDataUm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Reservation() {
	}

	public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) {
		if (!checkout.isAfter(checkin)) {
			throw new DomainException("A data de checkout deve ser posterior a data de checkin.");
		}
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckin() {
		return checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}
	
	public Long duration() {
		Duration duration = Duration.between(checkin.atStartOfDay(), checkout.atStartOfDay());
		return duration.toDays();
	}
	
	public void updateDates(LocalDate newCheckin, LocalDate newCheckout) {
		
		if(newCheckin.isBefore(checkin) || checkout.isBefore(checkout)) {
			throw new DomainException("As datas de reservas devem ser posteriores as da atual reserva.");
		}
		
		if (!newCheckout.isAfter(newCheckin)) {
			throw new DomainException("A data de checkout deve ser posterior a data de checkin.");
		}
		
		this.checkin = newCheckin;
		this.checkout = newCheckout;
		
	}

	@Override
	public String toString() {
		return "Room " + roomNumber
				+ ", check-in: " + checkin.format(formatoDataUm)
				+ ", check-out: " + checkout.format(formatoDataUm)
				+ ", " + duration() 
				+ " nights";
	}
	
	
	
}
