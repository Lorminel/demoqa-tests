package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Daria");
        $("#lastName").setValue("Tsvetkova");
        $("#userEmail").setValue("dtsvetkova@qa.com");
        $("#userNumber").setValue("7338844660");
        $("#currentAddress").setValue("Some address 1");
        $(byText("Female")).click();
        $(byText("Reading")).click();

        //birth date
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue(String.valueOf(7));
        $(".react-datepicker__year-select").selectOptionByValue(String.valueOf(1994));
        $(byText("22")).click();

        //select subject
        $("#subjectsContainer").click();
        actions().sendKeys("b").perform();
        $(byText("Biology")).click();

        //file upload
        File file = new File("src/test/resources/img.jpg");
        $("#uploadPicture").uploadFile(file);

        //select state
        $("#state").click();
        $(byText("Haryana")).click();

        //select city
        $("#city").click();
        $(byText("Panipat")).click();

        $("#submit").click();

        $$("tr").get(1).shouldHave(text("Daria Tsvetkova"));
        $$("tr").get(2).shouldHave(text("dtsvetkova@qa.com"));
        $$("tr").get(3).shouldHave(text("Female"));
        $$("tr").get(4).shouldHave(text("7338844660"));
        $$("tr").get(5).shouldHave(text("22 August,1994"));
        $$("tr").get(6).shouldHave(text("Biology"));
        $$("tr").get(7).shouldHave(text("Reading"));
        $$("tr").get(8).shouldHave(text("img.jpg"));
        $$("tr").get(9).shouldHave(text("Some address 1"));
        $$("tr").get(10).shouldHave(text("Haryana Panipat"));
    }
}
