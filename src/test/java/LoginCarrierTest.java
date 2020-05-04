
import Pages.CarrierBaseClass;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.sleep;

public class LoginCarrierTest extends CarrierBaseClass {
    @Test
    public void loginWithValidCredentialsAsBrokerConnect() {
        mainPage.getWelcomeTitle().shouldHave(text("Welcome"));
        mainPage.getCompanyNameTitle().shouldHave(exactText("Test Company"));
        mainPage.getAccountIcon().click();
        mainPage.getLogOutButton().click();
        sleep(3000);
    }

}
