package org.tonberry.eureka.parent;

import org.springframework.web.bind.annotation.GetMapping;
import org.tonberry.eureka.schema.FetchChildOneResponse;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Flux;

@ReactiveFeignClient(value = "ChildOne", url = "https://ChildOne")
public interface ChildOneClient {
    @GetMapping("fetch")
    Flux<FetchChildOneResponse> fetch();
}
