package me.sseob.learnrestclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class WebClientRunner implements ApplicationRunner {

	@Autowired
	WebClient.Builder builder;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		System.out.println("================= Start WebClient Runner =================");

		WebClient build = builder.build();

		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		// Mono 객체 생성
		Mono<String> helloMono = build
				.get()
				.uri("http://localhost:8080/hello")
				.retrieve()
				.bodyToMono(String.class); //body를 mono type으로 변경하자

		helloMono.subscribe(str -> {
			System.out.println(str);

			if (stopWatch.isRunning()) {
				stopWatch.stop();
			}
			System.out.println(stopWatch.prettyPrint());
			stopWatch.start();
		});

		Mono<String> sseobMono = build
				.get()
				.uri("http://localhost:8080/sseob")
				.retrieve()
				.bodyToMono(String.class);

		sseobMono.subscribe(str -> {
			System.out.println(str);

			if (stopWatch.isRunning()) {
				stopWatch.stop();
			}
			System.out.println(stopWatch.prettyPrint());
			stopWatch.start();
		});
		
		System.out.println("================= End WebClient Runner =================");
	}
}