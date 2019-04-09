package com.mtm.examples.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder(toBuilder = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	private Integer id;
	private String pesel;
	private String name;
	private CustomerType type;
	private List<Account> accounts;

}