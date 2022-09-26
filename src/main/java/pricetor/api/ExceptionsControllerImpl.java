package pricetor.api;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import pricetor.exceptions.NoPriceFoundException;
import pricetor.interfaces.IExceptionController;

@ControllerAdvice
public class ExceptionsControllerImpl implements IExceptionController{
	
	  @Override
	  @ResponseBody
	  @ExceptionHandler(NoPriceFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  public String NoPriceFoundExceptionHandler(NoPriceFoundException ex) {
	    return ex.getMessage();
	  }

}
