package customers.Service;

import customers.Domain.Address;
import customers.Domain.Customer;
import customers.Domain.CustomerEvent;
import customers.Repository.ICustomerDAO;
import customers.integration.IEmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
	@Autowired
	ICustomerDAO customerDAO;
	@Autowired
	IEmailSender emailSender;
	@Autowired
	private ApplicationEventPublisher publisher;

	public void addCustomer(String name, String email, String street, String city, String zip) {
		Customer customer = new Customer(name, email);
		Address address = new Address(street, city, zip);
		customer.setAddress(address);
		customerDAO.save(customer);
		emailSender.sendEmail(email, "Welcome " + name + " as a new customer");
		publisher.publishEvent(new CustomerEvent("Customer is saved in the DB: " + customer));
	}

	public void setCustomerDAO(ICustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	public void setEmailSender(IEmailSender emailSender) {
		this.emailSender = emailSender;
	}
	
}
