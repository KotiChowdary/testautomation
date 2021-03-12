package com.test.koteswarakolluri.steps;

import com.test.koteswarakolluri.utils.ServiceFactory;

import cucumber.api.java.en.Then;

public class ConfirmOrder extends ServiceFactory {

	private String orderreferenceNo = "";
	
	@Then("^User need to add payment \"([^\"]*)\" and confirm the order$")
	public void user_need_to_add_payment_and_confirm_the_order(String paymentMethod)  {
		shoppingcartpagePO.summarypageCheckout();

		shoppingcartpagePO.addresspageCheckout();

		shoppingcartpagePO.shippingpageCheckout();

		shoppingcartpagePO.addPayment(paymentMethod);

		orderreferenceNo = shoppingcartpagePO.confirmOrder();
	}

	@Then("^User need to verify the order$")
	public void user_need_to_verify_the_order()  {
		orderhistorypagePO.launchOrderHistory();
		if (orderhistorypagePO.validateOrder(orderreferenceNo)) {
			System.out.println("Order Sucessfully Validated With Reference No :" + orderreferenceNo);
		} else {
			System.out.println("Order With Reference No :" + orderreferenceNo + " Not Found in order history");
		}
	}

}
