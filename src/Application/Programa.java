package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Programa {
										//Estou faando que no meu m�todo main eu posso
									//lan�ar uma excess�o desse tipo
	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("N�mero do quarto: ");
		int number = sc.nextInt();
		System.out.print("Data de check-in (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data de check-out (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reserva = new Reservation(number, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Entre com os dados para atualiza��o da reserva:");
			System.out.print("Data de check-in (dd/MM/yyyy): ");
			 checkIn = sdf.parse(sc.next());
			System.out.print("Data de check-out (dd/MM/yyyy): ");
			 checkOut = sdf.parse(sc.next());
			 
			 Date now = new Date();
			 if(checkIn.before(now) || checkOut.before(now)) {
				 System.out.println("Error in reservation: Reservation dates for update must be future dates");
			 }
			 else if(!checkOut.after(checkIn)) {
				 System.out.println("Error in reservation: Check-out date must be after check-in date");
			 }
			 else {
				 reserva.updateDates(checkIn, checkOut);
				 System.out.println("Reserva: " + reserva);
			 }

		}
		
		sc.close();
	}

}
