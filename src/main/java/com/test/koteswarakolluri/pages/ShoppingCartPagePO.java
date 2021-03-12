package com.test.koteswarakolluri.pages;

import static com.test.koteswarakolluri.utils.Constants.PAYBANKWIRE;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.koteswarakolluri.utils.ServiceFactory;

public class ShoppingCartPagePO extends ServiceFactory {

	private List<String> productDetails = new ArrayList<String>();

	@FindBy(id = "total_product")
	WebElement totalproducts;

	@FindBy(id = "total_shipping")
	WebElement totalshipping;

	@FindBy(id = "total_price_without_tax")
	WebElement totalpricewithouttax;

	@FindBy(css = "a[title='Proceed to checkout']")
	WebElement proceedtocheckout;

	@FindBy(name = "processAddress")
	WebElement processaddress;

	@FindBy(name = "processCarrier")
	WebElement processcarrier;

	@FindBy(id = "cgv")
	WebElement agreeterms;

	@FindBy(css = "a[title='Pay by bank wire']")
	WebElement paybybankwire;

	@FindBy(css = "a[title='Pay by check.']")
	WebElement paybycheck;

	@FindBy(xpath = "//*[contains(text(),'I confirm my order')]")
	WebElement confirmorder;

	@FindBy(className = "box")
	WebElement referenceno;

	public ShoppingCartPagePO() {
		PageFactory.initElements(driver, this);
	}

	public void summarypageCheckout() {

		productDetails.add(eventHandler.getText(totalproducts));

		productDetails.add(eventHandler.getText(totalshipping));

		productDetails.add(eventHandler.getText(totalpricewithouttax));

		capture.takescreenShot("Summary");

		eventHandler.click(driver.findElements(By.cssSelector("a[title='Proceed to checkout']")).get(1));

	}

	public void addresspageCheckout() {

		capture.takescreenShot("Address");

		eventHandler.click(processaddress);

	}

	public void shippingpageCheckout() {

		eventHandler.click(agreeterms);

		capture.takescreenShot("Shipping");

		eventHandler.click(processcarrier);

	}

	public void addPayment(String paymentType) {

		if (paymentType.equals(PAYBANKWIRE)) {
			eventHandler.click(paybybankwire);
		} else {
			eventHandler.click(paybycheck);
		}

		capture.takescreenShot("Payment");

	}

	/***
	 * Get Reference ID for the order purchased using regular expression
	 * 
	 * @return
	 */
	public String confirmOrder() {
		String referenceNo = "";
		eventHandler.click(confirmorder);
		Matcher match = Pattern.compile("[A-Z]{9}(\\s|.)").matcher(eventHandler.getText(referenceno));
		while (match.find()) {
			referenceNo = match.group();
		}
		capture.takescreenShot("ConfirmOrder");
		return referenceNo.substring(0, referenceNo.length() - 1);
	}
}
