package ej2;

import java.util.List;

public class Vuelo {
	private Ciudad origin;
	private Ciudad destination;
	private List<Ciudad> layovers;
	private String flightCode;
	private Avion plane;
	private List<Pasajero> passangers;
	private List<Tripulante> crew;

	public Vuelo(Ciudad origin, Ciudad destination, List<Ciudad> layovers, String flightCode, Avion plane,
			List<Pasajero> passangers, List<Tripulante> crew) {
		this.origin = origin;
		this.destination = destination;
		this.layovers = layovers;
		this.flightCode = flightCode;
		this.plane = plane;
		this.passangers = passangers;
		this.crew = crew;
	}

	public Vuelo(Ciudad origin, Ciudad destination, String flightCode, Avion plane, List<Pasajero> passangers,
			List<Tripulante> crew) {
		this.origin = origin;
		this.destination = destination;
		this.flightCode = flightCode;
		this.plane = plane;
		this.passangers = passangers;
		this.crew = crew;
	}

	public Ciudad getOrigin() {
		return origin;
	}

	public void setOrigin(Ciudad origin) {
		this.origin = origin;
	}

	public Ciudad getDestination() {
		return destination;
	}

	public void setDestination(Ciudad destination) {
		this.destination = destination;
	}

	public List<Ciudad> getLayovers() {
		return layovers;
	}

	public void setLayovers(List<Ciudad> layovers) {
		this.layovers = layovers;
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public Avion getPlane() {
		return plane;
	}

	public void setPlane(Avion plane) {
		this.plane = plane;
	}

	public List<Pasajero> getPassangers() {
		return passangers;
	}

	public void setPassangers(List<Pasajero> passangers) {
		this.passangers = passangers;
	}

	public List<Tripulante> getCrew() {
		return crew;
	}

	public void setCrew(List<Tripulante> crew) {
		this.crew = crew;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Vuelo other))
			return false;
		return this.flightCode == other.flightCode;
	}
	
	private String stringifyLayovers()
	{
		String result = "";
		for(Ciudad city : layovers)
			result += "(%s) -> ".formatted(city);
		return result;
	}
		
	@Override
	public String toString() {
		if(!(layovers.isEmpty()))
			return "Vuelo con escalas %s | Origen: %s | Destino: %s | Ruta Prevista: (%s) -> %s (%s)".formatted(flightCode,origin,destination,origin,stringifyLayovers(),destination);
		return "Vuelo directo %s | Origen: %s | Destino: %s | Ruta Prevista: (%s) -> (%s)".formatted(flightCode,origin,destination,origin,destination);
	}
	
	
	

}
