package com.test.koteswarakolluri.utils;

import static com.test.koteswarakolluri.utils.Constants.CHROME;
import static com.test.koteswarakolluri.utils.Constants.CHROMEEXE;
import static com.test.koteswarakolluri.utils.Constants.EDGE;
import static com.test.koteswarakolluri.utils.Constants.EDGEEXE;
import static com.test.koteswarakolluri.utils.Constants.INTERNETEXPLORER;
import static com.test.koteswarakolluri.utils.Constants.INTERNETEXPLOREREXE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.test.koteswarakolluri.pages.HomePagePO;
import com.test.koteswarakolluri.pages.OrderHistoryPagePO;
import com.test.koteswarakolluri.pages.PersonalInformationPagePO;
import com.test.koteswarakolluri.pages.ShoppingCartPagePO;
import com.test.koteswarakolluri.pages.TShirtsPagePO;

public class ServiceFactory {

	protected static WebDriver driver = null;

	protected static EventHandler eventHandler = null;

	protected static HomePagePO homepagePO = null;

	protected static TShirtsPagePO tshirtspagePO = null;

	protected static OrderHistoryPagePO orderhistorypagePO = null;

	protected static ShoppingCartPagePO shoppingcartpagePO = null;

	protected static PersonalInformationPagePO personalinformationpagePO = null;

	protected static String testcaseName = "";

	protected static String screenshotfolderLocation = "";

	protected static CaptureScreenShots capture = null;

	protected static WebDriver getDriver(String browserName) {

		if (driver == null) {

			switch (browserName) {

			case CHROME:

				System.setProperty("webdriver.chrome.driver", CHROMEEXE);

				driver = new ChromeDriver();

				break;

			case INTERNETEXPLORER:

				System.setProperty("webdriver.ie.driver", INTERNETEXPLOREREXE);

				driver = new InternetExplorerDriver();

				break;

			case EDGE:

				System.setProperty("webdriver.edge.driver", EDGEEXE);

				driver = new InternetExplorerDriver();

				break;

			default:

				driver = new FirefoxDriver();

				break;

			}

			eventHandler = new EventHandler();

			homepagePO = new HomePagePO();

			tshirtspagePO = new TShirtsPagePO();

			shoppingcartpagePO = new ShoppingCartPagePO();

			orderhistorypagePO = new OrderHistoryPagePO();

			personalinformationpagePO = new PersonalInformationPagePO();

			capture = new CaptureScreenShots();

			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		}

		return driver;

	}

	protected void tearDown() {

		if (driver != null) {

			driver.quit();

			driver = null;

		}

	}

}
