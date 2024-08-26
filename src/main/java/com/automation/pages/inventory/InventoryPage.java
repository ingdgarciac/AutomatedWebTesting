package com.automation.pages.inventory;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import com.automation.pages.base.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/** Inventory page of the app. */
public class InventoryPage extends BasePage {

  @FindBy(id = "react-burger-menu-btn")
  private WebElement hamburgerMenu;

  @FindBy(id = "shopping_cart_container")
  private WebElement shoppingCartButton;

  /**
   * Constructor of the class, for initialize the driver.
   *
   * @param driver Object WebDriver
   */
  public InventoryPage(WebDriver driver) {
    super(driver);
  }

  public boolean isHamburgerMenuVisible() {
    return hamburgerMenu.isDisplayed();
  }

  public boolean isShoppingCartVisible() {
    return shoppingCartButton.isDisplayed();
  }

  @Override
  public boolean isPageLoaded() {
    getWait()
        .withTimeout(ofSeconds(2))
        .pollingEvery(ofMillis(500))
        .ignoring(NoSuchElementException.class)
        .until(visibilityOf(hamburgerMenu));
    return hamburgerMenu.isDisplayed();
  }
}
