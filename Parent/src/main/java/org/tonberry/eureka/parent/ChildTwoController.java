package org.tonberry.eureka.parent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.tonberry.eureka.schema.FetchChildTwoResponse;

import java.time.Duration;
import java.util.List;

@Service
public class ChildTwoController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public List<FetchChildTwoResponse> fetch() {
        return webClientBuilder.build()
                .get()
                .uri("http://ChildTwo/fetch")
                .retrieve()
                .bodyToFlux(FetchChildTwoResponse.class)
                .collectList().block(Duration.ofSeconds(30));
    }

}
