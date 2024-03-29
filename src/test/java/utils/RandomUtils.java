package utils;

import com.github.javafaker.Faker;

import java.util.Date;

public class RandomUtils {
    static Faker faker = new Faker();
    private static Date date = faker.date().birthday();

    public static String getRandomFirstName(){
        String firstName = faker.name().firstName();

        return firstName;
    }
    public static String getRandomLastName(){
        String lastName = faker.name().lastName();

        return lastName;
    }
    public static String getRandomEmail(){
        String email = faker.internet().emailAddress();

        return email;
    }
    public static String getRandomGender(){
        String[] genders = {"Male", "Female", "Other"};
        String gender = faker.options().option(genders);

        return gender;
    }
    public static String getRandomPhoneNumber(){
        String phoneNumber = faker.phoneNumber().subscriberNumber(10);

        return phoneNumber;
    }
    public static String getRandomDay(){
       String day = String.valueOf(date.getDate());
       if(day.length() < 2){
           return "0"+day;
       } else{
           return day;
       }
    }
    public static String getRandomMonth(){
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        int monthIndex = date.getMonth();
        String month = months[monthIndex];

        return month;
    }

    public static String getRandomYear(){
        String year = String.valueOf(date.getYear()+1900);

        return year;
    }


    public static String getRandomSubject(){
        String[] subjects = {"English", "Chemistry", "Computer Science","Commerce",
                "Economics", "Social Studies", "Arts", "History", "Biology", "Math",
                "Accounting", "Physics", "Hindi", "Civics"};
        String subject = faker.options().option(subjects);

        return subject;
    }
    public static String getRandomHobby(){
        String[] hobbies = {"Sports", "Reading", "Music"};
        String hobby = faker.options().option(hobbies);

        return hobby;
    }
    public static String getRandomPicture(){
        String[] pictures = {"img.jpg", "img2.png", "img3.jpg",
                            "img4.png"};
        String picture = faker.options().option(pictures);

        return picture;
    }
    public static String getRandomAddress(){
        String address = faker.address().streetAddress();

        return address;
    }
    public static String getRandomState(){
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        String state = faker.options().option(states);

        return state;
    }
    public static String getRandomCity(String state){
        int cityIndex;
        String city;
        if (state == "NCR"){
            String cities[] = {"Delhi", "Gurgaon", "Noida"};
            city = faker.options().option(cities);
        } else if (state == "Uttar Pradesh"){
            String cities[] = {"Agra", "Lucknow", "Merrut"};
            city = faker.options().option(cities);
        } else if (state == "Haryana"){
            String cities[] = {"Karnal", "Panipat"};
            city = faker.options().option(cities);
        } else {
            String cities[] = {"Jaipur", "Jaiselmer"};
            city = faker.options().option(cities);
        }

        return city;
    }




}
