package com.mtm.examples.domain;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Builder(toBuilder = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Customer extends RepresentationModel<Customer> {

    private Integer customerId;
    private String pesel;
    private String name;
    private CustomerType type;
    private List<Account> accounts;

}