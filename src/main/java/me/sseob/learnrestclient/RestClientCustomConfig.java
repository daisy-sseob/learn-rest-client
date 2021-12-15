package me.sseob.learnrestclient;

import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


/**
 * Global하게 RestClient를 custom하기 위해 !
 */
@Configuration
public class RestClientCustomConfig {
	
	/*
		WebClient custom
	 */
	@Bean
	public WebClientCustomizer webClientCustomizer() {

		return new WebClientCustomizer() {
			@Override
			public void customize(WebClient.Builder webClientBuilder) {
				webClientBuilder.baseUrl("http://localhost:8080");
			}
		};
	}
	
	/*
		RestTemplate custom. apache httpClient를 사용하게 custom한다.
		HttpConnection을 사용하지 않고 apache hpptclient를 사용한다.
	 */
	public RestTemplateCustomizer restTemplateCustomizer() {
		return new RestTemplateCustomizer() {
			@Override
			public void customize(RestTemplate restTemplate) {
				restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
			}
		};
	}
}
