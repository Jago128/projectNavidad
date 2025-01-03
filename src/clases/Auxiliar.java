package clases;
import java.time.LocalDate;
import java.util.ArrayList;

import enums.Cargo;

public class Auxiliar extends Trabajador {
	private Cargo cargo;
	private ArrayList <String> langs;
	
	public Auxiliar(String d, String n, String sN, LocalDate bD, LocalDate aD, Cargo c, ArrayList<String> l) {
		super(d,n,sN,bD,aD);
		this.cargo = c;
		this.langs = l;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public ArrayList<String> getLangs() {
		return langs;
	}

	public void setLangs(ArrayList<String> langs) {
		this.langs = langs;
	}

	@Override
	public String toString() {
		return "Auxiliar [cargo=" + cargo + ", langs=" + langs + "]";
	}
}
