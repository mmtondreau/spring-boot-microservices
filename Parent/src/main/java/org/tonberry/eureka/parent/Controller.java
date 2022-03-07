package org.tonberry.eureka.parent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.tonberry.eureka.schema.FetchChildOneResponse;
import org.tonberry.eureka.schema.FetchChildTwoResponse;
import org.tonberry.eureka.schema.FetchParentResponse;

import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.of(Optional.of("pong"));
    }

    @RequestMapping("/fetch")
    public ResponseEntity<FetchParentResponse> fetch() {
        FetchChildOneResponse fetchChildOneResponse = restTemplate
                .getForObject("http://ChildOne/fetch", FetchChildOneResponse.class);
        FetchChildTwoResponse fetchChildTwoResponse = restTemplate
                .getForObject("http://ChildTwo/fetch", FetchChildTwoResponse.class);
        return ResponseEntity.of(Optional.of(FetchParentResponse.builder()
                .withChildOne(fetchChildOneResponse)
                .withChildTwo(fetchChildTwoResponse)
                .build()));
    }
}
