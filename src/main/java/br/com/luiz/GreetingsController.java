package br.com.luiz;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greetings")
	public Greetings greeting(
			@RequestParam(value = "name", defaultValue = "World")
			String name) {
		return new Greetings(counter.incrementAndGet(), String.format(template, name));
	}
}
