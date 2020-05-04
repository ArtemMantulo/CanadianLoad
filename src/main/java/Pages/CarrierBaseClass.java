package Pages;

import ProjectConfigs.Configs;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.*;

import static Utils.ConfigProvider.getProperty;
import static com.codeborne.selenide.Selenide.*;

public class CarrierBaseClass extends Configs {
    public LoginPage loginPage = new LoginPage();
    public CarrierMyCapacityPage carrierCapacityPage;

   @BeforeMethod
    public void logInAsCarrier() {
        System.out.println("BeforeMethod LoginAsCarrier");

        this.loginPage.getUserEmail().setValue(getProperty("carrier.email"));
        this.loginPage.getUserPassword().setValue(getProperty("carrier.password"));
        this.loginPage.getSelectAccountOption().selectOption(getProperty("carrier.type"));
        this.loginPage.getSubmitButton().click();
        sleep(3000);
    }

}
