package with.templatemethod;

public class PaypalPaymentProcessor extends PaymentProcessor{
	private String paypalAddress;
	private Customer customer;
	
	public PaypalPaymentProcessor(String paypalAddress, Customer customer) {
		super();
		this.paypalAddress = paypalAddress;
		this.customer = customer;
	}

	@Override
	protected boolean validatePayment() {
		System.out.println("Validate paypal address "+paypalAddress);
		return true;
	}

	@Override
	protected void performPayment(double dollarAmount) {
		System.out.println("Perform payment with paypal address "+paypalAddress+" and amount $"+dollarAmount);		
	}

	@Override
	protected void notifyCustomer() {
		System.out.println("Notify customer "+customer.getName()+" with email "+customer.getEmail()+" about paypal payment to address "+paypalAddress);		
	}

}
