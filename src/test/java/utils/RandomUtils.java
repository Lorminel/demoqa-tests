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
        int genderIndex = faker.random().nextInt(genders.length);
        String gender = genders[genderIndex];

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
        int genderIndex = faker.random().nextInt(subjects.length);
        String subject = subjects[genderIndex];

        return subject;
    }
    public static String getRandomHobby(){
        String[] hobbies = {"Sports", "Reading", "Music"};
        int genderIndex = faker.random().nextInt(hobbies.length);
        String hobby = hobbies[genderIndex];

        return hobby;
    }
    public static String getRandomAddress(){
        String address = faker.address().streetAddress();

        return address;
    }
    public static String getRandomState(){
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        int stateIndex = faker.random().nextInt(states.length);
        String state = states[stateIndex];

        return state;
    }
    public static String getRandomCity(String state){
        int cityIndex;
        String city;
        if (state == "NCR"){
            String cities[] = {"Delhi", "Gurgaon", "Noida"};
            cityIndex = faker.random().nextInt(cities.length);
            city = cities[cityIndex];
        } else if (state == "Uttar Pradesh"){
            String cities[] = {"Agra", "Lucknow", "Merrut"};
            cityIndex = faker.random().nextInt(cities.length);
            city = cities[cityIndex];
        } else if (state == "Haryana"){
            String cities[] = {"Karnal", "Panipat"};
            cityIndex = faker.random().nextInt(cities.length);
            city = cities[cityIndex];
        } else {
            String cities[] = {"Jaipur", "Jaiselmer"};
            cityIndex = faker.random().nextInt(cities.length);
            city = cities[cityIndex];
        }

        return city;
    }




}
