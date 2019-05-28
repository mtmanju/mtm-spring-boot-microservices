package com.mtm.examples.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mtm.examples.domain.Account;

@FeignClient("account-service")
public interface AccountClient {

	@GetMapping("/accounts/customer/{customerId}")
	List<Account> getAccounts(@PathVariable("customerId") Integer customerId);

}