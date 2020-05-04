package Utils;


import Pages.CarrierMyCapacityPage;
import Pages.LoginPage;
import Pages.MainPage;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.open;


public class DriverManager extends ConfigProvider {

   // private static final Logger LOGGER = Logger.getLogger(DriverManager.class);




    public static void setUpDriver() {

      //  LOGGER.info("Start chrome driver");

        Configuration.baseUrl = getProperty("app.url");
        Configuration.timeout= 40000;
        Configuration.browser = "chrome";
        Configuration.browserSize = "1855x1060";
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, false);
        desiredCapabilities.setBrowserName("chrome");
        Configuration.browserCapabilities = desiredCapabilities;
        //Configuration.holdBrowserOpen = true;

       // if (nonNull(System.getProperty("env"))) {
          //  Configuration.proxyHost = "172.17.0.1";
           // Configuration.remote = "http://localhost:4444/wd/hub";
     //   }

       // if (nonNull(System.getProperty("headless"))) {
        //    Configuration.headless = true;
      //  }
    }
}
