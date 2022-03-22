package org.tonberry.eureka.childone;

import lombok.Builder;
import lombok.Value;

import javax.persistence.Id;

@Value
@Builder
public class Data {
    @Id
    Long id;
    String value;
}
