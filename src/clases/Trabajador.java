package clases;
import java.time.LocalDate;

public class Trabajador {
	protected String dni;
	protected String name;
	protected String surN;
	protected LocalDate birthD;
	protected LocalDate altaD;
	
	public Trabajador(String d, String n, String sN, LocalDate bD, LocalDate aD) {
		this.dni = d;
		this.name = n;
		this.surN = sN;
		this.birthD = bD;
		this.altaD = aD;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurN() {
		return surN;
	}

	public void setSurN(String surN) {
		this.surN = surN;
	}

	public LocalDate getBirthD() {
		return birthD;
	}

	public void setBirthD(LocalDate birthD) {
		this.birthD = birthD;
	}

	public LocalDate getAltaD() {
		return altaD;
	}

	public void setAltaD(LocalDate altaD) {
		this.altaD = altaD;
	}

	@Override
	public String toString() {
		return "Trabajador [DNI: "+dni+", Nombre: "+name+", Apellido: "+surN+", Fecha de Nacimiento: "+birthD+", Fecha de Alta: "+altaD+"";
	}
}
