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

		WebClient build = builder.build();

		System.out.println("================= Start WebClient Runner =================");

		// 간단하게 지역적인 custom
//		WebClient build = builder
//				.baseUrl("http://localhost:8080")
//				.build();

		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		// Mono 객체 생성
		Mono<String> helloMono = build
				.get()
				.uri("/hello")
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
				.uri("/sseob")
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
		
		// Non-Blocking I/O 이기 때문에 위에 비동기적인 소스코드들을 지나쳐, StopWatch로 측정하려는 시간 print보다 아래 print가 먼저 찍힌다.
		System.out.println("================= End WebClient Runner =================");
	}
}
