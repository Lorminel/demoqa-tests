package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

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
                .setBirthDate("22", "August", "1994")
                .setSubject("Biology")
                .setHobby("Reading")
                .uploadPicture("images/img.jpg")
                .setAddress("Some address 1")
                .setState("Haryana")
                .setCity("Panipat")
                .pressSubmit();

        registrationPage.checkResult("Student Name", "Daria Tsvetkova")
                .checkResult("Student Email", "dtsvetkova@qa.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "7338844660")
                .checkResult("Date of Birth", "22 August,1994")
                .checkResult("Subjects", "Biology")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "img.jpg")
                .checkResult("Address", "Some address 1")
                .checkResult("State and City", "Haryana Panipat");

    }

    @Test
    void minSuccessfulFillFormTest(){
        registrationPage.openPage()
                .setFirstName("Daria")
                .setLastName("Tsvetkova")
                .setGender("Female")
                .setUserNumber("7338844660")
                .pressSubmit();

        registrationPage.checkResult("Student Name", "Daria Tsvetkova")
                .checkResult("Student Email", " ")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "7338844660")
                .checkResult("Date of Birth", "22 March,2024")
                .checkResult("Subjects", " ")
                .checkResult("Hobbies", " ")
                .checkResult("Picture", " ")
                .checkResult("Address", " ")
                .checkResult("State and City", " ");

    }

    @Test
    void emptyFirstNameTest(){
        registrationPage.openPage()
                .setLastName("Tsvetkova")
                .setGender("Female")
                .setUserNumber("7338844660")
                .pressSubmit();

        registrationPage.checkFormNotDisplayed()
                .checkEmptyFirstName();
    }

    @Test
    void emptyGenderTest(){
        registrationPage.openPage()
                .setFirstName("Daria")
                .setLastName("Tsvetkova")
                .setUserNumber("7338844660")
                .pressSubmit();

        registrationPage.checkFormNotDisplayed()
                .checkEmptyGender();
    }
}
