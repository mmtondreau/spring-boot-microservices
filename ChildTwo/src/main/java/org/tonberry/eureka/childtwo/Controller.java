package org.tonberry.eureka.childtwo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tonberry.eureka.schema.FetchChildTwoResponse;

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
    ResponseEntity<FetchChildTwoResponse> fetch() {
        return ResponseEntity.of(Optional.of(FetchChildTwoResponse.builder().withData(DATA).build()));
    }
}
