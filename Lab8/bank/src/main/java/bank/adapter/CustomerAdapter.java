package bank.adapter;

import bank.domain.Customer;
import bank.dto.CustomerDTO;


public class CustomerAdapter {
	public static CustomerDTO getCustomerDto(Customer customer) {
		CustomerDTO customerDTO = new CustomerDTO(customer.getName());
		return customerDTO;
	}
}
