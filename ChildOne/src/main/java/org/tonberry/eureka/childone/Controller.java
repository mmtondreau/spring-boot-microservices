package org.tonberry.eureka.childone;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tonberry.eureka.schema.FetchChildOneResponse;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    private static final List<String> DATA = List.of("Cat", "Dog", "Bird");

    @Value("${pingMessage}")
    private String pingMessage;

    @RequestMapping("/ping")
    ResponseEntity<String> ping() {
        return ResponseEntity.of(Optional.of(pingMessage));
    }

    @RequestMapping("/fetch")
    Flux<FetchChildOneResponse> fetch() {
        return Flux.fromStream(DATA.stream().map(FetchChildOneResponse::new));

    }
}
