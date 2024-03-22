package pages;


import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.FormComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            cityInput = $("#city"),
            submitButton = $("#submit"),
            modalDialog = $("modal-dialog"),
            genderMale = $("#genterWrapper").$(byText("Male")),
            genderFemale = $("#genterWrapper").$(byText("Male")),
            genderOther = $("#genterWrapper").$(byText("Male"));

    CalendarComponent calendarComponent = new CalendarComponent();
    FormComponent formComponent = new FormComponent();

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Practice Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }
    public RegistrationPage setBirthDate(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }
    public RegistrationPage setSubject(String value) {

        subjectsInput.setValue(value).pressEnter();

        return this;
    }
    public RegistrationPage setHobby(String value) {

        hobbiesWrapper.$(byText(value)).click();

        return this;
    }
    public RegistrationPage uploadPicture(String value) {

        uploadPicture.uploadFromClasspath(value);

        return this;
    }
    public RegistrationPage setAddress(String value) {

        addressInput.setValue(value);

        return this;
    }
    public RegistrationPage setState(String value) {

        stateInput.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }   public RegistrationPage setCity(String value) {

        cityInput.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }
    public RegistrationPage pressSubmit() {

        submitButton.click();

        return this;
    }
    public RegistrationPage checkResult(String key, String value){

        formComponent.checkForm(key, value);

        return this;
    } public RegistrationPage checkFormNotDisplayed(){

        formComponent.formDoesNotAppear();

        return this;
    }
    public RegistrationPage checkEmptyFirstName() {
        firstNameInput.shouldBe(empty);
        firstNameInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        firstNameInput.shouldHave(cssValue("background-image",
                "url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='12' " +
                        "height='12' fill='none' stroke='%23dc3545' viewBox='0 0 12 12'%3e%3ccircle cx='6' cy='6' " +
                        "r='4.5'/%3e%3cpath stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3e%3ccircle cx='6' cy='8.2' r='.6' " +
                        "fill='%23dc3545' stroke='none'/%3e%3c/svg%3e\")"));

        return this;
    }
    public RegistrationPage checkEmptyGender(){

        genderWrapper.$(byText("Male")).
                shouldHave(cssValue("color", "rgba(220, 53, 69, 1)"));
        genderWrapper.$(byText("Female")).
                shouldHave(cssValue("color", "rgba(220, 53, 69, 1)"));
        genderWrapper.$(byText("Other")).
                shouldHave(cssValue("color", "rgba(220, 53, 69, 1)"));

        return this;
    }

}

