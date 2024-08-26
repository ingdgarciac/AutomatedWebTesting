package com.automation.core.login;

import static org.hamcrest.Matchers.is;

import com.automation.core.base.BaseTest;
import com.automation.pages.inventory.InventoryPage;
import com.automation.pages.login.LoginPage;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/** Login base test class. */
public abstract class LoginBaseTest extends BaseTest {

  protected LoginPage loginPage;
  protected InventoryPage inventoryPage;

  /** Before method to navigate to login page. */
  @BeforeMethod
  @Parameters({"url"})
  @Step("Given swag labs login page")
  public void navigateToLoginPage(String url) {
    loginPage = new LoginPage(driver.getDriver(), url);

    checkThat.hardAssert("The login page is visible", loginPage.isPageLoaded(), is(true));
  }
}
