package exceptions;

public class InvalidOriginException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public void InvalidOriginExceptionMessage(String origin) {
		System.out.println("El origen es invalido.");
	}
}
