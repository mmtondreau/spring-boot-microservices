package org.tonberry.eureka.childtwo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tonberry.eureka.schema.FetchChildTwoResponse;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    private static final List<Long> DATA = List.of(21L, 23L, 67L);

    @RequestMapping("/ping")
    ResponseEntity<String> ping() {
        return ResponseEntity.of(Optional.of("pong"));
    }

    @RequestMapping("/fetch")
    Flux<FetchChildTwoResponse> fetch() {
        return Flux.fromStream(DATA.stream().map(FetchChildTwoResponse::new));
    }
}
