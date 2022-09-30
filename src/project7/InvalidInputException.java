package project7;
/**
 * This class extends the Exception class.
 * This class helps to deal with invalid input exception.
 * @author PC
 *
 */
public class InvalidInputException extends Exception {
	/**
	 * Returns a message warning the user when the exception is thrown.
	 * @return a message warning the user when the exception is thrown
	 */
	public String getMessage() {
		return "Invalid input!";
	}
}
