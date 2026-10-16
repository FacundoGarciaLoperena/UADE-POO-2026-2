package ej2;


public class Avion {
	private String model;
	private int idNumber;
	private int capacity;

	public Avion(String model, int idNumber, int capacity) {
		this.model = model;
		this.idNumber = idNumber;
		this.capacity = capacity;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Avion %d | Modelo: %s | Capacidad %d".formatted(idNumber,model,capacity)  ;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Avion other))
			return false;
		return this.idNumber == other.idNumber;
	}
}
