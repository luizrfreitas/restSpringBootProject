package br.com.luiz;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.luiz.mathHelper.MathHelper;

import br.com.luiz.exceptions.UnsupportedMathOperationExcetion;

@RestController
public class MathController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			
		) throws Exception {
		
		if (!MathHelper.isNumeric(numberOne) || !MathHelper.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationExcetion("Please set a numeric value!"); 
		}
		return MathHelper.convertToDouble(numberOne) + MathHelper.convertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double subtraction (
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {

		if (!MathHelper.isNumeric(numberOne) || !MathHelper.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationExcetion("Please set a numereic value!");
		}
		
		return MathHelper.convertToDouble(numberOne) - MathHelper.convertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/mul/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double multiplication (
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {

		if (!MathHelper.isNumeric(numberOne) || !MathHelper.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationExcetion("Please set a numereic value!");
		}
		
		return MathHelper.convertToDouble(numberOne) * MathHelper.convertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double division (
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {

		if (!MathHelper.isNumeric(numberOne) || !MathHelper.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationExcetion("Please set a numereic value!");
		}
		
		if (MathHelper.isZero(numberTwo)) {
			throw new UnsupportedMathOperationExcetion("The second number can't be zero!");
		}
		
		return MathHelper.convertToDouble(numberOne) / MathHelper.convertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/sqr/{numberOne}", method=RequestMethod.GET)
	public Double squareRoot (
			@PathVariable(value = "numberOne") String numberOne
			) throws Exception {

		if (!MathHelper.isNumeric(numberOne)) {
			throw new UnsupportedMathOperationExcetion("Please set a numereic value!");
		}
		
		if (MathHelper.isZero(numberOne)) {
			throw new UnsupportedMathOperationExcetion("The second number can't be zero!");
		}
		
		return Math.sqrt(Double.parseDouble(numberOne));
	}

}
