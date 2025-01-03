package exceptions;

import java.util.regex.*;

public class InvalidOriginException extends Exception {
	private static final long serialVersionUID = 1L;
	
	
	Pattern modelo = Pattern.compile("[a-zA-Z]{5,10}");
	Matcher matcher = modelo.matcher(origen);
}
