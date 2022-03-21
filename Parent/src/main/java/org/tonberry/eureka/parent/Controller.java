package org.tonberry.eureka.parent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tonberry.eureka.schema.FetchParentResponse;

import java.util.Optional;

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
