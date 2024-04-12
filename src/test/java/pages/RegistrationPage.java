package pages;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.FormComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName"),
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
            submitButton = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    FormComponent formComponent = new FormComponent();

    @Step("Открыть страницу регистрационной формы")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $(".practice-form-wrapper").shouldHave(text("Practice Form"));

        return this;
    }

    @Step("Вввести имя пользователя")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Вввести фамилию пользователя")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Вввести email")
    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    @Step("Выбрать пол")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Ввести номер телефона")
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    @Step("Установить дату рождения")
    public RegistrationPage setBirthDate(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    @Step("Выбрать предмет")
    public RegistrationPage setSubject(String value) {

        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Выбрать хобби")
    public RegistrationPage setHobby(String value) {

        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Загрузить изображение")
    public RegistrationPage uploadPicture(String value) {

        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    @Step("Ввести адрес")
    public RegistrationPage setAddress(String value) {

        addressInput.setValue(value);

        return this;
    }

    @Step("Выбрать штат")
    public RegistrationPage setState(String value) {

        stateInput.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Выбрать город")
    public RegistrationPage setCity(String value) {

        cityInput.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Нажать на кнопку Submit")
    public RegistrationPage pressSubmit() {

        submitButton.click();

        return this;
    }

    @Step("Проверить, что введенные данные отображаются в форме")
    public RegistrationPage checkResult(String key, String value) {

        formComponent.checkForm(key, value);

        return this;
    }

    @Step("Проверить, что форма не появляется")
    public RegistrationPage checkFormNotDisplayed() {

        formComponent.formDoesNotAppear();

        return this;
    }

    @Step("Проверить, что поле имени пустое и подсвечено красным")
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

    @Step("Проверить, что пол не заполнен и кнопки подсвечены красным")
    public RegistrationPage checkEmptyGender() {

        genderWrapper.$(byText("Male")).
                shouldHave(cssValue("color", "rgba(220, 53, 69, 1)"));
        genderWrapper.$(byText("Female")).
                shouldHave(cssValue("color", "rgba(220, 53, 69, 1)"));
        genderWrapper.$(byText("Other")).
                shouldHave(cssValue("color", "rgba(220, 53, 69, 1)"));

        return this;
    }

}

