package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

@Getter
public class CarrierMyCapacityPage {
    private SelenideElement
            createCapacityButton = $(".plus"),
            openDateField = $("#rw_1_input"),
            closeDateField = $("#rw_2_input"),
            equipment = $(By.name("equipment")),
            loadType = $(By.name("loadType")),
            originCity = $(By.name("orignTownOrCity")),
            originProvince = $(By.name("originProvOrState")),
            destinationCity = $(By.name("destTownOrCity")),
            destinationProvince = $(By.name("destProvOrState")),
            submitButton = $("#saveBtn"),
            capacityListCheckboxItemOne = $x("//div[@class='rt-tr -odd']/div/input"),
            itemOptionsButton = $("i.fa.fa-gear"),
            itemOptionDelete = $x("//button[text()='Delete']"),
            confirmDeleteOperationButton = $x("//span[@class = \"ladda-label\"]"),
            capacityListFirstCapacityItemCheckbox = $x("//div[@class= \"rt-tr -odd\"]/div/input");
    private ElementsCollection
            capacityListOpenDateField = $$x("//div[@class= \"rt-td\"][2]");



}
