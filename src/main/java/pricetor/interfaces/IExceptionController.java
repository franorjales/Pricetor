package pricetor.interfaces;

import pricetor.exceptions.NoPriceFoundException;

public interface IExceptionController {
	public String NoPriceFoundExceptionHandler(NoPriceFoundException ex);
}
