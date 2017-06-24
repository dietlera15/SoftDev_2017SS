package at.fhj.swd;

public class MyException extends Exception {

	public MyException(String message) {
		super(message);
	}
	public MyException(Throwable cause) {
		super(cause);
	}
}
