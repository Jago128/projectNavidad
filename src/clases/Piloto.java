package clases;
import java.time.LocalDate;
import java.util.ArrayList;

public class Piloto extends Trabajador {
	private LocalDate license;
	private String residence;
	private ArrayList<Vuelo> v;
	
	public Piloto(String d, String n, String sN, LocalDate bD, LocalDate aD, LocalDate license, String residence,
			ArrayList<Vuelo> v) {
		super(d, n, sN, bD, aD);
		this.license = license;
		this.residence = residence;
		this.v = v;
	}
	
	public LocalDate getLicense() {
		return license;
	}
	public void setLicense(LocalDate license) {
		this.license = license;
	}
	public String getResidence() {
		return residence;
	}
	public void setResidence(String residence) {
		this.residence = residence;
	}
	public ArrayList<Vuelo> getV() {
		return v;
	}
	public void setV(ArrayList<Vuelo> v) {
		this.v = v;
	}
	
	@Override
	public String toString() {
		return "Piloto [license=" + license + ", residence=" + residence + ", v=" + v + "]";
	}
}
