package Dersler;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class C19_Faker {
    @Test
    public void test() {
    Faker faker = new Faker();
        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.name().fullName());
        System.out.println(faker.internet().emailAddress());
        System.out.println(faker.internet().password());
        System.out.println(faker.phoneNumber().cellPhone());
        System.out.println(faker.address().fullAddress());
        System.out.println(faker.address().country());
        System.out.println(faker.address().city());
        System.out.println(faker.date().birthday());
        System.out.println(faker.date().birthday(20,80));
        System.out.println(faker.animal().name());
    }

}
