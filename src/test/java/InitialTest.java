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
      loginPage.getUserEmail().setValue("");
      loginPage.getUserPassword().setValue("");
      loginPage.getSelectAccountOption().selectOption("Carrier");
      loginPage.getSubmitButton().click();
      mainPage.getWelcomeTitle().shouldHave(text("Welcome"));
      mainPage.getCompanyNameTitle().shouldHave(exactText("Test Company"));
   }
   @Test(priority = 2)
   public void postCarrierCapacity() {
      open("/my-capacity");
      carrierCapacityPage.getCreateCapacityButton().click();
      carrierCapacityPage.getOpenDateField().setValue("May 3nd 2020, 1:30 pm");
      carrierCapacityPage.getCloseDateField().setValue("May 4nd 2020, 1:30 pm");
      carrierCapacityPage.getEquipment().selectOptionByValue("dryVan");
      carrierCapacityPage.getLoadType().selectOptionByValue("full");
      carrierCapacityPage.getOriginCity().setValue("NY city");
      carrierCapacityPage.getOriginProvince().selectOptionByValue("NY");
      carrierCapacityPage.getDestinationCity().setValue("Toronto");
      carrierCapacityPage.getDestinationProvince().selectOptionByValue("NY");
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
      assertThat(openDateText, hasSize(3));
      sleep(20000);
   }
}
