package tests;

import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectsTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulFillFormTest() {
        registrationPage.openPage()
                .setFirstName("Daria")
                .setLastName("Tsvetkova")
                .setEmail("dtsvetkova@qa.com")
                .setGender("Female")
                .setUserNumber("7338844660")
                .setBirthDate("22", "August", "1994");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__day--022:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Biology").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("images/img.jpg");
        $("#currentAddress").setValue("Some address 1");
        $("#state").click();
        $("#stateCity-wrapper").$(new ByText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(new ByText("Panipat")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Daria "), text("Tsvetkova"), text("dtsvetkova@qa.com")
                , text("Female"), text("7338844660"), text("22 August,1994"), text("Biology")
                , text("Reading"), text("img.jpg"), text("Some address 1"), text("Haryana Panipat"));
        registrationPage.checkResult("Student Name", "Daria Tsvetkova");

    }

}
