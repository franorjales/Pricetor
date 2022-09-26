package pricetor.exceptions;

public class NoPriceFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public NoPriceFoundException(String errorMessage) {
        super(errorMessage);
    }
}
