package com.test.koteswarakolluri.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.koteswarakolluri.utils.ServiceFactory;

public class TShirtsPagePO extends ServiceFactory {
	@FindBy(css = "a[title='T-shirts']")
	WebElement tshirts;

	@FindBy(css = "a[title='Faded Short Sleeve T-shirts']")
	WebElement fadedshortsleeve;

	@FindBy(id = "color_1")
	WebElement orangetshirt;

	@FindBy(id = "color_2")
	WebElement bluetshirt;

	@FindBy(name = "Submit")
	WebElement addtocart;

	@FindBy(css = "a[title='Proceed to checkout']")
	WebElement proceedtocheckout;

	public TShirtsPagePO() {
		PageFactory.initElements(driver, this);
	}

	public void launchTShirtsViewer() {
		eventHandler.click(tshirts);
		capture.takescreenShot("TShirtOrder");
	}

	public void selectTShirt(String tshirtColor) {
		eventHandler.waitforPageToLoad();
		Actions action = new Actions(driver);
		action.moveToElement(fadedshortsleeve).perform();
		if (tshirtColor.equalsIgnoreCase("Orange")) {
			eventHandler.click(orangetshirt);
		} else {
			eventHandler.click(bluetshirt);
		}
		capture.takescreenShot("AddtoCart");
		eventHandler.waitforPageToLoad();
		eventHandler.click(addtocart);
	}

	public void proceedtoCheckout() {
		capture.takescreenShot("ProceedtoCheckout");
		eventHandler.click(proceedtocheckout);
	}
}
