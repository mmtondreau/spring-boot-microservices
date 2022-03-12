package org.tonberry.eureka.parent;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.tonberry.eureka.schema.FetchChildOneResponse;
import org.tonberry.eureka.schema.FetchChildTwoResponse;
import org.tonberry.eureka.schema.FetchParentResponse;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class Controller {

    @Autowired
    ChildOneController childOneController;

    @Autowired
    ChildTwoController childTwoController;

    @RequestMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.of(Optional.of("pong"));
    }

    @RequestMapping("/fetch")
    public ResponseEntity<FetchParentResponse> fetch() {


        return ResponseEntity.of(Optional.of(FetchParentResponse.builder()
                .withChildOne(childOneController.fetch())
                .withChildTwo(childTwoController.fetch())
                .build()));
    }
}
