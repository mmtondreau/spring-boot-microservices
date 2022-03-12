package org.tonberry.eureka.parent;

import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.tonberry.eureka.schema.FetchChildOneResponse;

import java.time.Duration;
import java.util.List;

@Service
public class ChildOneController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Retry(name = "ChildOne", fallbackMethod = "fetchFallback")
    public List<FetchChildOneResponse> fetch() {
        return webClientBuilder.build()
                .get()
                .uri("http://ChildOne/fetch")
                .retrieve()
                .bodyToFlux(FetchChildOneResponse.class)
                .collectList()
                .block(Duration.ofSeconds(30));
    }

    public List<FetchChildOneResponse> fetchFallback(Throwable t) {
        return List.of(FetchChildOneResponse.builder().withData("ERROR").build());
    }
}
