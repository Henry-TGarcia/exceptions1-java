package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	//Atributos
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	//Construtores
	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		if(!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		 }
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	//Gets e Sets
	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	//Métodos
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		//Na variavel diff do tipo long estou pegando a diferença em MILLISEGUNDOS.
		//Agora preciso passa para DIAS.
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
		//updateDates pode lancar uma excessao
	public void updateDates(Date checkIn, Date checkOut){
														//não estou tratando a excessao
														//estou adiando
		Date now = new Date();
		 if(checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Reservation dates for update must be future dates");
		 }
		 if(!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		 }
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+", check-in: "
				+ sdf.format(checkIn)
				+", check-out: "
				+ sdf.format(checkOut)
				+", "
				+ duration()
				+ " noites.";
	}
	
}
