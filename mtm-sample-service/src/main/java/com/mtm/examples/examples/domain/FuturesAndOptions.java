package com.mtm.examples.examples.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class FuturesAndOptions {

    private String orderType;
    private String orderAveragePrice;
    private Double orderQuantity;
}
