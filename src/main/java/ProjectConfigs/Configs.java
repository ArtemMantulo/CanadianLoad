package ProjectConfigs;

import Pages.CarrierMyCapacityPage;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.RepeatableCompotents;
import Utils.ConfigProvider;
import com.codeborne.selenide.Selenide;
import lombok.SneakyThrows;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.*;


import static Utils.DriverManager.setUpDriver;
import static com.codeborne.selenide.Selenide.open;


public class Configs  {
    public LoginPage loginPage;
    public MainPage mainPage;
    public RepeatableCompotents repeatableCompotents;

    @BeforeClass
    public void  beforeClassRunner() {
        System.out.println("BeforeClass Open LoginPage");
        setUpDriver();
        loginPage = open("", LoginPage.class);
        mainPage = new MainPage();
        repeatableCompotents = new RepeatableCompotents();


    }
    @AfterClass
    public void afterLginWithValidCredentialsAsBrokerConnect() {
        System.out.println("AfterClass Close Driver");
        Selenide.closeWebDriver();
    }
}
