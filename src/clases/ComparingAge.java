package clases;

import java.time.LocalDate;
import java.time.Year;

public class ComparingAge implements Comparable<ComparingAge> {
	
	private int age;
	
	public ComparingAge() {
		this.age=0;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void calcAge(LocalDate birthDate) {
		this.age=Year.now().getValue()-birthDate.getYear();
	}

	@Override
	public String toString() {
		return "Trabajador [Edad: "+age+"]";
	}

	@Override
	public int compareTo(ComparingAge o) {
		return Integer.compare(this.age, o.getAge());
	}

}
