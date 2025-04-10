package kr.co.sjo112777.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class WebClientConfig {

    @Bean
    public WebClient getWebClient(WebClient.Builder webClientBuilder) {

        return webClientBuilder
                .baseUrl("http://localhost:8082/service2")
                .build();
    }

}