package org.tonberry.eureka.schema;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
@Getter
public class FetchChildTwoResponse {
    private Long data;
}
