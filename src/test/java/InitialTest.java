import Pages.CarrierMyCapacityPage;
import Utils.Configs;
import com.codeborne.selenide.Condition;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
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
   @Test(priority = 2)
   public void loginWithValidCredentialsAsBrokerConnect() {
      loginPage.getUserEmail().setValue(getProperty("user.email"));
      loginPage.getUserPassword().setValue(getProperty("user.password"));
      loginPage.getSelectAccountOption().selectOption("Carrier");
      loginPage.getSubmitButton().click();
      mainPage.getWelcomeTitle().shouldHave(text("Welcome"));
      mainPage.getCompanyNameTitle().shouldHave(exactText("Test Company"));
   }
   @Test(priority = 2)
   public void postCarrierCapacity() {
      open("/my-capacity");
      carrierCapacityPage.getCreateCapacityButton().click();
      carrierCapacityPage.getOpenDateField().setValue(getProperty("open.date"));
      carrierCapacityPage.getCloseDateField().setValue(getProperty("close.date"));
      carrierCapacityPage.getEquipment().selectOptionByValue(getProperty("equipment.type"));
      carrierCapacityPage.getLoadType().selectOptionByValue(getProperty("load.type"));
      carrierCapacityPage.getOriginCity().setValue(getProperty("origin.city"));
      carrierCapacityPage.getOriginProvince().selectOptionByValue(getProperty("origin.province"));
      carrierCapacityPage.getDestinationCity().setValue(getProperty("destination.city"));
      carrierCapacityPage.getDestinationProvince().selectOptionByValue(getProperty("destination.province"));
      carrierCapacityPage.getSubmitButton().click();

      sleep(5000);
   }

   @AfterClass
   public void deteleTestCaparity()
   {
      carrierCapacityPage.getCapacityListCheckboxItemOne().setSelected(true);
      carrierCapacityPage.getItemOptionsButton().click();
      carrierCapacityPage.getItemOptionDelete().shouldBe(visible).click();
      carrierCapacityPage.getConfirmDeleteOperationButton().click();
      sleep(3000);
      List<String> openDateText = new ArrayList<>();

      carrierCapacityPage.getCapacityListCheckboxItemOne().shouldBe(disabled);
      for(SelenideElement element : carrierCapacityPage.getCapacityListOpenDateField())
      {
         openDateText.add(element.getText());
      }
      assertThat(openDateText, hasSize(12));
      sleep(10000);
   }
}
