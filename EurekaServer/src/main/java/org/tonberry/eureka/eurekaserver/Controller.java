package org.tonberry.eureka.eurekaserver;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class Controller {
    @RequestMapping("/ping")
    ResponseEntity<String> ping() {
        return ResponseEntity.of(Optional.of("pong"));
    }
}
