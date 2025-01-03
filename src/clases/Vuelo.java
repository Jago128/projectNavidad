package clases;
import java.time.LocalDateTime;

public class Vuelo {
	private String id;
	private String origin;
	private String destination;
	private LocalDateTime start;
	private LocalDateTime end;
	private String planeType;

	public Vuelo(String o, String d, LocalDateTime s, LocalDateTime e, String pT) {
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

	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public LocalDateTime getEnd() {
		return end;
	}

	public void setEnd(LocalDateTime end) {
		this.end = end;
	}

	public String getPlaneType() {
		return planeType;
	}

	public void setPlaneType(String planeType) {
		this.planeType = planeType;
	}

	public String generateID(String origin, String destination) {
		String o=origin.substring(0,2).toUpperCase();
		String d=origin.substring(0,2).toUpperCase();
		return o+"/"+d;
	}
}
