package com.test.koteswarakolluri.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.koteswarakolluri.utils.ServiceFactory;

public class OrderHistoryPagePO extends ServiceFactory {

	@FindBy(css = "a[title='View my customer account']")
	WebElement customeraccount;

	@FindBy(css = "a[title='Orders']")
	WebElement orders;

	@FindBy(id = "order-list")
	WebElement orderslist;

	public OrderHistoryPagePO() {
		PageFactory.initElements(driver, this);
	}

	public void launchOrderHistory() {
		eventHandler.click(customeraccount);
		eventHandler.click(orders);
		capture.takescreenShot("LaunchOrderHistory");
	}

	public boolean validateOrder(String orderreferenceNo) {
		eventHandler.waitforPageToLoad();
		capture.takescreenShot("ValidateOrder");
		List<WebElement> orderrows = orderslist.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
		for (int i = 0; i < orderrows.size(); i++) {
			List<WebElement> ordersdata = orderrows.get(i).findElements(By.tagName("td"));
			if (eventHandler.getText(ordersdata.get(0)).equalsIgnoreCase(orderreferenceNo)) {
				eventHandler.click(ordersdata.get(5).findElement(By.tagName("a")));
				return true;
			}
		}
		return false;
	}
}
