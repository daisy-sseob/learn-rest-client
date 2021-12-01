package me.sseob.learnrestclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateRunner implements ApplicationRunner {

	@Autowired
	RestTemplateBuilder restTemplateBuilder;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("================= Start RestTemplate Runner =================");
		
		RestTemplate restTemplate = restTemplateBuilder.build();

		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		// 5초 짜리 요청 호출
		String hello = restTemplate.getForObject("http://localhost:8080/hello", String.class);
		System.out.println(hello);
		
		// 3초 짜리 요청 호출
		String sseob = restTemplate.getForObject("http://localhost:8080/sseob", String.class);
		System.out.println(sseob);

		stopWatch.stop();
		
		//blocking request이므로 합산하여 8초정도 출력된다.
		System.out.println(stopWatch.prettyPrint());
		System.out.println("total running seconds: " + stopWatch.getTotalTimeSeconds());

		System.out.println("================= End RestTemplate Runner =================\n");
	}
}
