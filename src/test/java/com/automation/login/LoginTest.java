package com.automation.login;

import static com.automation.enums.ErrorMessage.LOCKED_ERROR;
import static com.automation.enums.ErrorMessage.WRONG_USER;
import static com.automation.enums.User.*;
import static io.qameta.allure.SeverityLevel.BLOCKER;
import static org.hamcrest.Matchers.is;

import com.automation.core.base.Listener;
import com.automation.core.login.LoginBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/** Login tests. */
@Listeners(Listener.class)
public class LoginTest extends LoginBaseTest {

  @Test
  @Severity(BLOCKER)
  @Story("CA-3966")
  @TmsLink("CA-25939")
  @Description("Validate login with locked user")
  public void validateLoginWithLockedUser() {
    loginPage = loginPage.setUsername(LOCKED).setPassword(LOCKED).clickOnLoginButton(false);

    checkThat.softAssert(
        "The login error is displayed", loginPage.isValidationErrorDisplayed(), is(true));
    checkThat.softAssert(
        "Inputs are highlighted", loginPage.usernameAndPasswordAreHighlighted(), is(true));
    checkThat.softAssert(
        "Locked error message", loginPage.getErrorMessage(), is(LOCKED_ERROR.getMessage()));
  }

  @Test
  @Severity(BLOCKER)
  @Story("CA-3966")
  @TmsLink("CA-25939")
  @Description("Validate login with wrong user")
  public void validateLoginWithWrongUser() {
    loginPage = loginPage.setUsername(WRONG).setPassword(WRONG).clickOnLoginButton(false);

    checkThat.softAssert(
        "The login error is displayed", loginPage.isValidationErrorDisplayed(), is(true));
    checkThat.softAssert(
        "Inputs are highlighted", loginPage.usernameAndPasswordAreHighlighted(), is(true));
    checkThat.softAssert(
        "Wrong error message", loginPage.getErrorMessage(), is(WRONG_USER.getMessage()));
  }

  @Test
  @Severity(BLOCKER)
  @Story("CA-3966")
  @TmsLink("CA-25939")
  @Description("Validate login with wrong user")
  public void validateLoginWithStandardUser() {
    inventoryPage = loginPage.setUsername(STANDARD).setPassword(STANDARD).clickOnLoginButton(true);

    checkThat.hardAssert("Inventory page is displayed", inventoryPage.isPageLoaded(), is(true));
    checkThat.softAssert("Hamburger menzu", inventoryPage.isHamburgerMenuVisible(), is(true));
    checkThat.softAssert("Shopping cart", inventoryPage.isShoppingCartVisible(), is(true));
  }
}
