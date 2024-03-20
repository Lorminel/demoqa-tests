package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormWithCommentsTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void successfulFillFormTest() {
        String userName = "Daria";

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Practice Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(userName);
        $("#lastName").setValue("Tsvetkova");
        $("#userEmail").setValue("dtsvetkova@qa.com");
        $("#genterWrapper").$(byText("Female")).click();
//        $("#gender-radio-2").parent().click(); // good
//        $("label[for=gender-radio-2]").click(); // good
        $("#userNumber").setValue("7338844660");
        $("#dateOfBirthInput").click();
//        $(".react-datepicker__month-select").selectOptionByValue("7");
        $(".react-datepicker__month-select").selectOption("August");
//        $(".react-datepicker__year-select").selectOptionByValue(String.valueOf(1994));
        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__day--022:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Biology").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("images/img.jpg");
        $("#currentAddress").setValue("Some address 1");
        $("#state").click();
        $("#stateCity-wrapper").$(new ByText("Haryana")).click();
//        $("#react-select-3-option-2").click();
        $("#city").click();
        $("#stateCity-wrapper").$(new ByText("Panipat")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text(userName), text("Tsvetkova"), text("dtsvetkova@qa.com")
                                ,text("Female"), text("7338844660"), text("22 August,1994"), text("Biology")
                                ,text("Reading"), text("img.jpg"), text("Some address 1"), text("Haryana Panipat"));
        
//        $$("tr").get(1).shouldHave(text("Daria Tsvetkova"));
//        $$("tr").get(2).shouldHave(text("dtsvetkova@qa.com"));
//        $$("tr").get(3).shouldHave(text("Female"));
//        $$("tr").get(4).shouldHave(text("7338844660"));
//        $$("tr").get(5).shouldHave(text("22 August,1994"));
//        $$("tr").get(6).shouldHave(text("Biology"));
//        $$("tr").get(7).shouldHave(text("Reading"));
//        $$("tr").get(8).shouldHave(text("img.jpg"));
//        $$("tr").get(9).shouldHave(text("Some address 1"));
//        $$("tr").get(10).shouldHave(text("Haryana Panipat"));
    }

}
