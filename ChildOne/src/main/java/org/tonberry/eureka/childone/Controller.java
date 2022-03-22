package org.tonberry.eureka.childone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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

    @Autowired
    DataRepository dataRepository;

    @Autowired
    ConfigProperties configProperties;

    @RequestMapping("/ping")
    ResponseEntity<String> ping() {
        return ResponseEntity.of(Optional.of(configProperties.getPingMessage()));
    }

    @RequestMapping("/fetch")
    Flux<FetchChildOneResponse> fetch() {
        return dataRepository.findAll().map(data -> new FetchChildOneResponse(data.getValue()));

    }
}
