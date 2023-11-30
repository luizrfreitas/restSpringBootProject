package br.com.luiz.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationExcetion extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
}
