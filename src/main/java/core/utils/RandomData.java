package core.utils;

import com.github.javafaker.Faker;

public class RandomData {
    private static final Faker faker = new Faker();

    public static String loginRandom = faker.name().firstName();
    public static String passwordRandom = faker.number().digits(7);
    public static String emailRandom = faker.internet().emailAddress();
}
