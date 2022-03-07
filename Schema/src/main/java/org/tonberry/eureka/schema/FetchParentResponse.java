package org.tonberry.eureka.schema;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder(setterPrefix = "with")
public class FetchParentResponse {
    FetchChildOneResponse childOne;
    FetchChildTwoResponse childTwo;
}
