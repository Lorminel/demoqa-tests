package tests;

import data.FormKeys;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static java.lang.String.format;
import static utils.RandomUtils.*;

public class RegistrationWithPageObjectsTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = getRandomFirstName(),
            lastName = getRandomLastName(),
            fullName = format("%s %s", firstName, lastName),
            userEmail = getRandomEmail(),
            userGender = getRandomGender(),
            userNumber = getRandomPhoneNumber(),
            birthDay = getRandomDay(),
            birthMonth = getRandomMonth(),
            birthYear = getRandomYear(),
            birthDate = format("%s %s,%s", birthDay, birthMonth, birthYear),
            userSubject = getRandomSubject(),
            userHobby = getRandomHobby(),
            userPictureDisplayed = getRandomPicture(),
            userPictureUpload = "images/" + userPictureDisplayed,
            userAddress = getRandomAddress(),
            state = getRandomState(),
            city = getRandomCity(state),
            stateAndCity = format("%s %s", state, city),
            emptyField = " ";

    SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM,yyyy", Locale.ENGLISH);
    Date Date = new Date();
    String currentDate = formatter.format(Date);

    @Feature("Форма регистрации")
    @Story("Заполнение формы")
    @Owner("dtsvetkova")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Отправка формы со всеми заполненными полями")
    @Tag("registration")
    @Test
    void successfulFillFormTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setBirthDate(birthDay, birthMonth, birthYear)
                .setSubject(userSubject)
                .setHobby(userHobby)
                .uploadPicture(userPictureUpload)
                .setAddress(userAddress)
                .setState(state)
                .setCity(city)
                .pressSubmit();

        registrationPage.checkResult(FormKeys.Name.getKey(), fullName)
                .checkResult(FormKeys.Email.getKey(), userEmail)
                .checkResult(FormKeys.Gender.getKey(), userGender)
                .checkResult(FormKeys.Mobile.getKey(), userNumber)
                .checkResult(FormKeys.Birth.getKey(), birthDate)
                .checkResult(FormKeys.Subject.getKey(), userSubject)
                .checkResult(FormKeys.Hobby.getKey(), userHobby)
                .checkResult(FormKeys.Picture.getKey(), userPictureDisplayed)
                .checkResult(FormKeys.Address.getKey(), userAddress)
                .checkResult(FormKeys.StateAndCity.getKey(), stateAndCity);

    }

    @Feature("Форма регистрации")
    @Story("Заполнение формы")
    @Owner("dtsvetkova")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Отправка формы с обязательными заполненными полями")
    @Tag("registration")
    @Test
    void minSuccessfulFillFormTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .pressSubmit();

        registrationPage.checkResult(FormKeys.Name.getKey(), fullName)
                .checkResult(FormKeys.Email.getKey(), emptyField)
                .checkResult(FormKeys.Gender.getKey(), userGender)
                .checkResult(FormKeys.Mobile.getKey(), userNumber)
                .checkResult(FormKeys.Birth.getKey(), currentDate)
                .checkResult(FormKeys.Subject.getKey(), emptyField)
                .checkResult(FormKeys.Hobby.getKey(), emptyField)
                .checkResult(FormKeys.Picture.getKey(), emptyField)
                .checkResult(FormKeys.Address.getKey(), emptyField)
                .checkResult(FormKeys.StateAndCity.getKey(), emptyField);

    }

    @Feature("Форма регистрации")
    @Story("Заполнение формы")
    @Owner("dtsvetkova")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Отправка формы без ввода имени пользователя")
    @Tags({
            @Tag("registration"),
            @Tag("negative")
    })
    @Test
    void emptyFirstNameTest() {
        registrationPage.openPage()
                .setLastName(lastName)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .pressSubmit();

        registrationPage.checkFormNotDisplayed()
                .checkEmptyFirstName();
    }

    @Feature("Форма регистрации")
    @Story("Заполнение формы")
    @Owner("dtsvetkova")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Отправка формы без выбора пола пользователя")
    @Tags({
            @Tag("registration"),
            @Tag("negative")
    })
    @Test
    void emptyGenderTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserNumber(userNumber)
                .pressSubmit();

        registrationPage.checkFormNotDisplayed()
                .checkEmptyGender();
    }
}
