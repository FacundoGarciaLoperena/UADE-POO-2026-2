package ej2;

import java.util.Objects;

public class Pasajero extends Persona {
	private String seatNumber;
	
	public Pasajero(int DNI, String name, String surname, String gender, int age,String seat) {
		super(DNI, name, surname, gender, age);
		this.seatNumber = seat;
	}

	public String getSeat() {
		return seatNumber;
	}

	public void setSeat(String seat) {
		this.seatNumber = seat;
	}
	
	@Override
	public String toString() {
		return "Asiento: %s | %s".formatted(seatNumber,super.toString());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Pasajero other))
			return false;
		return this.getDNI() == other.getDNI() && Objects.equals(seatNumber, other.seatNumber);
	}
}
