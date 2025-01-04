package clases;
import java.time.LocalDate;

public class Vuelo {
	private String id;
	private String origin;
	private String destination;
	private LocalDate start;
	private LocalDate end;
	private String planeType;

	public Vuelo(String o, String d, LocalDate s, LocalDate e, String pT) {
		this.id = generateID(o,d);
		this.origin = o;
		this.destination = d;
		this.start = s;
		this.end = e;
		this.planeType = pT;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDate getStart() {
		return start;
	}

	public void setStart(LocalDate start) {
		this.start = start;
	}

	public LocalDate getEnd() {
		return end;
	}

	public void setEnd(LocalDate end) {
		this.end = end;
	}

	public String getPlaneType() {
		return planeType;
	}

	public void setPlaneType(String planeType) {
		this.planeType = planeType;
	}

	@Override
	public String toString() {
		return "Vuelo [ID:" + id + ", origin=" + origin + ", destination=" + destination + ", start=" + start + ", end=" + end + ", planeType=" + planeType + "]";
	}

	public String generateID(String origin, String destination) {
		String o=origin.substring(0,2).toUpperCase();
		String d=destination.substring(0,2).toUpperCase();
		return o+"/"+d;
	}
}
