package org.tonberry.eureka.parent;

import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonberry.eureka.schema.FetchChildOneResponse;

import java.time.Duration;
import java.util.List;

@Service
public class ChildOneController {

    @Autowired
    private ChildOneClient client;

    @Retry(name = "ChildOne", fallbackMethod = "fetchFallback")
    public List<FetchChildOneResponse> fetch() {
        var result = client.fetch()
                .collectList()
                .block(Duration.ofSeconds(30));
        result.add(FetchChildOneResponse.builder().withData("Blarp-o-o-000").build());
        return result;
    }

    public List<FetchChildOneResponse> fetchFallback(Throwable t) {
        return List.of(FetchChildOneResponse.builder().withData("ERROR").build());
    }
}
