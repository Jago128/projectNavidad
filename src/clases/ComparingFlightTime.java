package clases;

import java.time.LocalDate;
import java.time.Year;
import java.util.HashMap;

@SuppressWarnings("unused")
public class ComparingFlightTime implements Comparable<ComparingFlightTime> {
	
	private int flightTime;
	
	public ComparingFlightTime() {
		this.flightTime=0;
	}
	
	public int getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(int flightTime) {
		this.flightTime = flightTime;
	}

	public void calcFlightTime(HashMap <String, Trabajador> t, String dni) {
		for (int i=0;i<((Piloto)t.get(dni)).getV().size();i++) {
			/*this.flightTime=this.flightTime+((Piloto)t.get(dni)).getV().get(i).getStart().
			TBD until LocalTime stuff is dealt with*/
		}
		
	}

	@Override
	public String toString() {
		return "Piloto [Edad: "+flightTime+"]";
	}

	@Override
	public int compareTo(ComparingFlightTime o) {
		return Integer.compare(this.flightTime, o.getFlightTime());
	}

}
