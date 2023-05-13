package com.mtm.examples.domain;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Builder(toBuilder = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Account extends RepresentationModel {

    private Integer accountId;
    private Integer customerId;
    private String number;

}