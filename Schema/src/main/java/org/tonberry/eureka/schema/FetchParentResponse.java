package org.tonberry.eureka.schema;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder(setterPrefix = "with")
public class FetchParentResponse {
    List<FetchChildOneResponse> childOne;
    List<FetchChildTwoResponse> childTwo;
}
