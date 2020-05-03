package Pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
@Getter
public class LoginPage {
    private SelenideElement
            labelImage = $x("//img"),
            labelText = $x("//h1[@class= 'h3 mb-3 font-weight-normal']"),
            userEmail = $(By.name("email")),
            userPassword = $(By.name("password")),
            submitButton = $x("//button"),
            selectAccountOption = $(By.name("companyType")),
            invalidLoginOrPassLabel = $x("//*[@class='server-error__text']"),
            requiredFieldError = $x("//*[@class='form-input-error']"),
            homePageTitle = $x("//*[@class='home-page__title']"),
            signUpLink = $x("//span[text()=' click here']"),
            forgetPasswordLink = $x("//span[text()='Forgot password?']");



}


