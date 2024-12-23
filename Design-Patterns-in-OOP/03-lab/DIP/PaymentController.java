public class PaymentController {

	private Object paymentMethod;
	
	public void setPaymentMethod(Object paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	public void pay() {
		if (paymentMethod instanceof AliPay) {
			((AliPay) paymentMethod).pay();
		} 
		else if (paymentMethod instanceof PaoTang) {
			((PaoTang) paymentMethod).pay();
		}
		else if (paymentMethod instanceof PayPal) {
			((PayPal) paymentMethod).pay();
		}
		
	}
}
