package main;
import java.util.regex.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

import clases.*;
import exceptions.*;
import enums.*;
import utilidades.Utilidades;

public class Aerolinea {

	public static void main(String[] args) {
		HashMap <String, Trabajador> t=new HashMap <String, Trabajador>();
		int menu=menu();

		switch (menu) {
		case 1:
			add(t);
			break;

		case 2:
			listAll(t);
			break;

		case 3:
			addFlights(t);
			break;

		case 4:
			addLang(t);
			break;

		case 5:
			listFlightDNI(t);
			break;

		case 6:
			listFlightDates(t);
			break;

		case 7:
			listPilotoDestination(t);
			break;

		case 8:
			auxiliarIdioma(t);
			break;

		case 9:
			listAge(t);
			break;

		case 10:

			break;

		case 11:

			break;

		case 12:

			break;

		case 13:

			break;

		case 14:

			break;

		case 15:

			break;

		case 16:

			break;

		case 17:

			break;

		case 18:

			break;

		case 19:

			break;

		case 20:

			break;

		case 21:
			System.out.println("Adios!");
		}

	}

	public static int menu() {
		System.out.println("1. Alta trabajador a partir del DNI");
		System.out.println("2. Listado trabajadores indicando si es piloto o mostrando su cargo (Todos)");
		System.out.println("3. Añadir vuelo(s) a un piloto");
		System.out.println("4. Añadir idioma(s) a un auxiliar");
		System.out.println("5. Listado de los vuelos de un piloto concreto a partir de su DNI");
		System.out.println("6. Listado de los vuelos realizados entre dos fechas");
		System.out.println("7. Listado de los pilotos que han participado en los vuelos de un destino concreto");
		System.out.println("8. Listado de los auxiliares que se manejan en un idioma concreto");
		System.out.println("9. Listado de los trabajadores ordenados por antigüedad");
		System.out.println("10. Listado de los pilotos ordenados por horas de vuelo ");
		System.out.println("11. Cálculo de la duración media de los vuelos de un piloto concreto indicando los detalles de su vuelo más largo y del más corto");
		System.out.println("12. Listado agrupado por destinos y nº de vuelos (con las fechas en las que han sido realizados) en un mes concreto con origen en una ciudad concreta");
		System.out.println("13. Mostrar el piloto con más antigüedad (indicando los años que lleva en la empresa) y el auxiliar más joven (en edad) de la empresa");
		System.out.println("14. Listado de los pilotos con residencia en un lugar concreto");
		System.out.println("15. Cálculo de la edad y de los años que lleva en la empresa un trabajador concreto");
		System.out.println("16. Modificar el cargo de un auxiliar concreto");
		System.out.println("17. Modificar un vuelo de un piloto. Se pide el piloto a partir de su DNI");
		System.out.println("18. Listado de los auxiliares con cargo concreto");
		System.out.println("19. Media de edad de los pilotos con una residencia concreta");
		System.out.println("20. Estadística de edad de los pilotos ordenada en ascendente por edad");
		System.out.println("21. Salir");
		return Utilidades.leerInt(1,21);
	}

	public static void invalidOrigin(String origin) throws InvalidOriginException {
		Pattern modelo = Pattern.compile("[a-zA-Z]{5,10}");
		Matcher matcher = modelo.matcher(origin);
		if (!matcher.find()) {
			throw new InvalidOriginException();
		}
	}


	public static void add(HashMap <String, Trabajador> t) {
		String dni, name, surname, setCargo=null;
		char choice;
		boolean error=false;
		LocalDate birthDate, fecAlta;

		System.out.println("Introduce el DNI.");
		dni=Utilidades.introducirCadena();

		if (t.containsKey(dni)) {
			System.err.println("Ya existe una persona con ese DNI.");
		} else {
			System.out.println("Introduce el nombre:");
			name=Utilidades.introducirCadena();
			System.out.println("Introduce el apellido:");
			surname=Utilidades.introducirCadena();
			System.out.println("Introduce la fecha de nacimiento: (DD/MM/AAAA)");
			birthDate=Utilidades.leerFechaDMA();
			System.out.println("Introduce la fecha de alta: (DD/MM/AAAA)");
			fecAlta=Utilidades.leerFechaDMAPosterior(birthDate);
			System.out.println("¿Quiere añadir un Piloto o Auxiliar? (P/A)");
			choice=Utilidades.leerChar('P','A');

			switch (choice) {
			case 'P':
				LocalDate lic;
				String residence;

				System.out.println("Introduce la fecha de licencia del piloto: (DD/MM/AAAA)");
				lic=Utilidades.leerFechaDMA();
				System.out.println("Introduce la residencia oficial del piloto:");
				residence=Utilidades.introducirCadena();
				t.put(dni, new Piloto(dni, name, surname, birthDate, fecAlta, lic, residence, new ArrayList <Vuelo>()));
				break;

			case 'A':
				Cargo cargo=null;
				do {
					try {
						error=false;
						System.out.println("¿Es Senior, Junior o Auxiliar?");
						setCargo=Utilidades.introducirCadena().toUpperCase();
						Cargo.valueOf(setCargo);
					} catch (IllegalArgumentException e) {
						System.err.println("La opcion introducida es invalida. Introducelo de nuevo.");
						error=true;
					}
				} while (error);

				switch (setCargo) {
				case "SENIOR":
					cargo=Cargo.SENIOR;
					break;

				case "JUNIOR":
					cargo=Cargo.JUNIOR;
					break;

				case "AUXILIAR":
					cargo=Cargo.AUXILIAR;
					break;
				}
				t.put(dni, new Auxiliar(dni, name, surname, birthDate, fecAlta, cargo, new ArrayList <String>()));
				break;
			}
		}
	}

	public static void listAll(HashMap <String, Trabajador> t) {
		for (Trabajador tr:t.values()) {
			if (tr instanceof Auxiliar) {
				System.out.println(((Auxiliar)tr).toString());
			}

			if (tr instanceof Piloto) {
				System.out.println(((Piloto)tr).toString());
			}
		}
	}

	public static void addFlights(HashMap <String, Trabajador> t) {
		String dni, origin=null, destination, planeType;
		boolean cont=true;
		LocalDate start, end;
		ArrayList <Vuelo> v=new ArrayList <>();

		System.out.println("Introduce el DNI del piloto:");
		dni=Utilidades.introducirCadena();
		if (t.containsKey(dni) && t.get(dni) instanceof Piloto) {
			v=((Piloto)t.get(dni)).getV();
			do {
				try {
					System.out.println("Introduce el origen:");
					origin=Utilidades.introducirCadena();
					invalidOrigin(origin);
				} catch (InvalidOriginException e) {
					e.InvalidOriginExceptionMessage(origin);
				}
				System.out.println("Introduce el destino:");
				destination=Utilidades.introducirCadena();
				System.out.println("El ID del vuelo ha sido automaticamente generado.");
				System.out.println("Introduce la fecha de inicio: (DD/MM/AAAA)");
				start=Utilidades.leerFechaDMA();
				System.out.println("Introduce la fecha de fin: (DD/MM/AAAA)");
				end=Utilidades.leerFechaDMA();
				System.out.println("Introduce el tipo de avión:");
				planeType=Utilidades.introducirCadena();
				Vuelo vI=new Vuelo(origin, destination, start, end, planeType);
				v.add(vI);
				System.out.println("Quiere añadir mas vuelos al piloto? (S/N)");
				if (Utilidades.introducirCadena("S","N").equalsIgnoreCase("N")) {
					cont=false;
				}
			} while (cont);
			((Piloto)t.get(dni)).setV(v);
		} else {
			System.err.println("El DNI introducido es invalido o no existe.");
		}
	}

	public static void addLang(HashMap <String, Trabajador> t) {
		String dni, lI;
		boolean cont=true;
		ArrayList <String> l=new ArrayList <>();
		System.out.println("Introduce el DNI del piloto:");
		dni=Utilidades.introducirCadena();
		if (t.containsKey(dni) && t.get(dni) instanceof Auxiliar) {
			l=((Auxiliar)t.get(dni)).getLangs();
			do {
				System.out.println("Introduce el idioma:");
				lI=Utilidades.introducirCadena();
				l.add(lI);
				System.out.println("Quiere añadir mas idiomas al auxiliar? (S/N)");
				if (Utilidades.introducirCadena("S","N").equalsIgnoreCase("N")) {
					cont=false;
				}
			} while (cont);
			((Auxiliar)t.get(dni)).setLangs(l);
		} else {
			System.err.println("El DNI introducido es invalido o no existe.");
		}
	}

	public static void listFlightDNI(HashMap <String, Trabajador> t) {
		String dni;
		boolean found=false;
		System.out.println("Introduce el DNI del piloto:");
		dni=Utilidades.introducirCadena();
		for (int i=0;i<t.size()&&!found;i++) {
			if (t.containsKey(dni) && t.get(dni) instanceof Piloto) {
				found=true;
				for (int j=0;i<((Piloto)t.get(dni)).getV().size();j++) {
					System.out.println(((Piloto)t.get(dni)).getV().get(j).toString());
				}
			}
			if (!found) {
				System.err.println("El DNI introducido es invalido o no existe.");
			}
		}
	}

	public static ArrayList <Vuelo> fillData(ArrayList <Vuelo> v, HashMap <String, Trabajador> t) {
		for (Trabajador tr:t.values()) {
			if (tr instanceof Piloto) {
				for (int i=0;i<((Piloto)tr).getV().size();i++) {
					v.add(((Piloto)tr).getV().get(i));
				}
			}
		}
		return v;
	}

	public static void listFlightDates(HashMap <String, Trabajador> t) {
		LocalDate date1, date2;
		ArrayList <Vuelo> v=new ArrayList<>();
		v=fillData(v,t);
		System.out.println("Introduce la primera fecha: (DD/MM/AAAA)");
		date1=Utilidades.leerFechaDMA();
		System.out.println("Introduce la segunda fecha: (DD/MM/AAAA)");
		date2=Utilidades.leerFechaDMAPosterior(date1);
		for (Vuelo vu:v) {
			if (vu.getStart().isAfter(date1)&&vu.getEnd().isBefore(date2)) {
				System.out.println(vu.toString());
			}
		}
	}

	public static void listPilotoDestination(HashMap <String, Trabajador> t) {
		String destination;
		boolean found=false;

		System.out.println("Introduce el destino del vuelo:");
		destination=Utilidades.introducirCadena();
		for (Trabajador tr:t.values()) {
			for (int i=0;i<((Piloto)tr).getV().size(); i++) {
				if (((Piloto)tr).getV().get(i).getDestination().equalsIgnoreCase(destination)) {
					found=true;
					System.out.println(((Piloto)tr).toString());
					
				}
			}
		}
		if (!found) {
			System.out.println("No se han encontrado pilotos que hayan participado en vuelos hacia "+destination);
		}
	}

	public static void auxiliarIdioma(HashMap <String, Trabajador> t) {
		boolean found=false;
		String lang;

		System.out.println("Introduce un idioma en concreto:");
		lang=Utilidades.introducirCadena();
		for (Trabajador tr:t.values()) {
			for (int i=0;i<((Auxiliar)tr).getLangs().size(); i++) {
				if (((Auxiliar)tr).getLangs().get(i).equalsIgnoreCase(lang)) {
					found=true;
					System.out.println(((Auxiliar)tr).toString());
				}
			}
		}
		if (!found) {
			System.out.println("No se han encontrado auxiliares que hablen el idioma "+lang);
		}
	}

	public static void listAge(HashMap <String, Trabajador> t) {
		ArrayList <ComparingAge> cI=new ArrayList <>();
		for (Trabajador a:t.values()) {
			for (int i=0;i<t.size();i++) {
				cI.add(new ComparingAge());
				cI.get(i).calcAge(a.getBirthD());
			}
			Collections.sort(cI);
		}
		for (ComparingAge c:cI) {
			System.out.println(c.toString());
		}
	}
	
	public static void listFlightTime(HashMap <String, Trabajador> t) {
		//TBD
	}
	
	public static void avgDurPilotoFlights(HashMap <String, Trabajador> t) {
		//TBD
	}
	
	public static void listDestinationFlightCount(HashMap <String, Trabajador> t) {
		//TBD
	}
	
	public static void showOldestPilot(HashMap <String, Trabajador> t) {
		ArrayList <ComparingAge> cI=new ArrayList <>();
		for (Trabajador a:t.values()) {
			for (int i=0;i<t.size();i++) {
				cI.add(new ComparingAge());
				cI.get(i).calcAge(a.getBirthD());
			}
			cI.sort(Collections.reverseOrder());
		}
		System.out.println(cI.get(0).toString());
	}
	
	public static void listResidence(HashMap <String, Trabajador> t) {
		@SuppressWarnings("unused")
		String residence;
		System.out.println("");
	}
}