package in.pwskills.nitin.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.pwskills.nitin.bean.MyErrorReponse;
import in.pwskills.nitin.bean.ProductNotFoundException;


//by default if any exception has been occur then it will be handeled by class DefaultHandlerExceptionResolver 
//but we have to create our own exception JSON object then we need to do this process

@RestControllerAdvice //this annotation have two annotation  @ControllerAdvice and @ResponseBody
public class MakeCustomExceptionJsonObject {

	static {
		System.out.println("CustomException.class is loading");
	}
	
	private MakeCustomExceptionJsonObject() {
		System.out.println("MakeCustomExceptionJsonObject class is creating");
	}
	
	
	/*
	 * 
	 * 
		@ExceptionHandler(value = ProductNotFoundException.class)
		public ResponseEntity<String> showCustomErrorMsg(
				ProductNotFoundException pnfe
				){
		System.out.println("MyCustomExceptionHandler.showCustomErrorMsg()");
			return new ResponseEntity<>(pnfe.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	 * 
	 */
	
	
	
@ExceptionHandler(value=ProductNotFoundException.class)
public ResponseEntity<MyErrorReponse> getCustomException(ProductNotFoundException pnfe){
	
	MyErrorReponse response=new MyErrorReponse(new Date(), "ProductNotFoundException", 12, pnfe.getMessage());
	
	return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
}
}
