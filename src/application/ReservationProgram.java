/**
 * 
 */
package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

/**
 * @author Matos
 *
 */
public class ReservationProgram {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter formatoDataUm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		try {
			
			System.out.print("Room number: ");
			int numRoom = sc.nextInt();
			
			System.out.print("Check-in date (dd/MM/yyyy): ");
			LocalDate checkin = LocalDate.parse(sc.next(), formatoDataUm);
			
			System.out.print("Check-out date (dd/MM/yyyy): ");
			LocalDate checkout = LocalDate.parse(sc.next(), formatoDataUm);
			
			Reservation reservation = new Reservation(numRoom, checkin, checkout);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = LocalDate.parse(sc.next(), formatoDataUm);
			
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = LocalDate.parse(sc.next(), formatoDataUm);
			
			reservation.updateDates(checkin, checkout);
			System.out.println("Reservation: " + reservation);
			
		} catch (DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
			
		} catch (RuntimeException e) {
			System.out.println("Erro inesperado.");
		}
		
		sc.close();
	}

}
