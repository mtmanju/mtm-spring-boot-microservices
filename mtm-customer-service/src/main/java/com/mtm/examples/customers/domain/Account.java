package com.mtm.examples.customers.domain;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Builder(toBuilder = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Account extends RepresentationModel<Account> {

    private Integer accountId;
    private String number;

}