## 이 프로젝트는 Spring의 Rest Client에 대해 다루는 프로젝트입니다.

> RestTemplate, WebClient의 동작 방식을 테스트를 통해 확인하고, Custom한다.

## Blocking I/O
- RestTemplate
  - RestTemplateAutoConfiguration을 통해 spring-web 의존성이 존재하면 RestTemplateBuilder를 Bean으로 등록한다.

## Non-Blocking I/O
- WebClient
  - WebClientAutoConfiguration을 통해 spring-webfux 의존성이 존재하면 WebClient.Builder를 Beand으로 등록한다.

## WebClient 학습 하기 ! 🧑🏻‍💻
- https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html#webflux-client
