package tests;

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
    nameKey = "Student Name",
    emailKey = "Student Email",
    genderKey = "Gender",
    mobileKey = "Mobile",
    birthKey = "Date of Birth",
    subjectsKey = "Subjects",
    hobbiesKey = "Hobbies",
    pictureKey = "Picture",
    addressKey = "Address",
    stateAndCityKey = "State and City",
    emptyField = " ";

    SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM,yyyy", Locale.ENGLISH);
    Date Date = new Date();
    String currentDate = formatter.format(Date);


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

        registrationPage.checkResult(nameKey, fullName)
                .checkResult(emailKey, userEmail)
                .checkResult(genderKey, userGender)
                .checkResult(mobileKey, userNumber)
                .checkResult(birthKey, birthDate)
                .checkResult(subjectsKey, userSubject)
                .checkResult(hobbiesKey, userHobby)
                .checkResult(pictureKey, userPictureDisplayed)
                .checkResult(addressKey, userAddress)
                .checkResult(stateAndCityKey, stateAndCity);

    }

    @Test
    void minSuccessfulFillFormTest(){
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .pressSubmit();

        registrationPage.checkResult(nameKey, fullName)
                .checkResult(emailKey, emptyField)
                .checkResult(genderKey, userGender)
                .checkResult(mobileKey, userNumber)
                .checkResult(birthKey, currentDate)
                .checkResult(subjectsKey, emptyField)
                .checkResult(hobbiesKey, emptyField)
                .checkResult(pictureKey, emptyField)
                .checkResult(addressKey, emptyField)
                .checkResult(stateAndCityKey, emptyField);

    }

    @Test
    void emptyFirstNameTest(){
        registrationPage.openPage()
                .setLastName(lastName)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .pressSubmit();

        registrationPage.checkFormNotDisplayed()
                .checkEmptyFirstName();
    }

    @Test
    void emptyGenderTest(){
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserNumber(userNumber)
                .pressSubmit();

        registrationPage.checkFormNotDisplayed()
                .checkEmptyGender();
    }
}
