package br.com.luiz;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			
		) throws Exception {
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new Exception(); 
		}
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}

	private Double convertToDouble(String numberStr) {
		if (numberStr == null ) return 0D;
		
		String number = numberStr.replaceAll(",", ".");
		if (isNumeric(number)) return Double.parseDouble(number);
		
		return 0D;
	}

	private boolean isNumeric(String numberStr) {
		if (numberStr == null ) return false;
		String number = numberStr.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
