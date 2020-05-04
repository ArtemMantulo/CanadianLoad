import ProjectConfigs.Configs;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertThat;

public class InitialTest extends Configs {

    @Test(priority = 1)
    public void InitialTestOfLoginPage() {
       loginPage.getLabelText().shouldBe(exactText("The Canadian Load Board"));
       loginPage.getUserEmail().shouldBe(visible).shouldBe(empty);
       loginPage.getUserPassword().shouldBe().shouldBe(empty);
       loginPage.getSelectAccountOption().is(enabled);
       loginPage.getSubmitButton().is(enabled);
       loginPage.getForgetPasswordLink().shouldBe(visible);
       loginPage.getSignUpLink().shouldBe(visible);
   }

}
