package com.automation.pages.base;

import static java.time.Duration.ofSeconds;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/** Abstract model page for POM pattern. */
@Getter
public abstract class BasePage {

  private final WebDriver driver;
  private final WebDriverWait wait;

  /**
   * Constructor of the class, for initialize the driver.
   *
   * @param driver Object WebDriver
   */
  public BasePage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, ofSeconds(5));
    driver.manage().window().maximize();
    this.driver = driver;
  }

  public abstract boolean isPageLoaded();
}
