package me.sseob.learnrestclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleApiController {

	/*
		5초 대기후 응답하는 handler
	 */
	@GetMapping("/hello")
	public String hello() throws InterruptedException {
		Thread.sleep(5000L);
		return "hello";
	}
	
	/*
		3초 대기후 응답하는 handler
	 */
	@GetMapping("/sseob")
	public String sseob() throws InterruptedException {
		Thread.sleep(3000L);
		return "sseob";
	}
}
