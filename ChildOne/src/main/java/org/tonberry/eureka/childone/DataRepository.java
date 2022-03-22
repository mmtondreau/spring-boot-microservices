package org.tonberry.eureka.childone;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface DataRepository extends R2dbcRepository<Data, Long> {
    Mono<Data> findById(long id);
}
