package Utils;

import Pages.CarrierMyCapacityPage;
import Pages.LoginPage;
import Pages.MainPage;
import com.codeborne.selenide.Selenide;
import lombok.SneakyThrows;
import org.testng.annotations.BeforeClass;

import static Utils.DriverManager.setUpDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class Configs {
    public LoginPage loginPage;
    public MainPage mainPage;
    public CarrierMyCapacityPage carrierCapacityPage;


    @SneakyThrows
    @BeforeClass
    public void  beforeClassRunner() {
        setUpDriver();
        loginPage = open("", LoginPage.class);
        mainPage = new MainPage();
        carrierCapacityPage = new CarrierMyCapacityPage();


    }

}
