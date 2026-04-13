package all.tech.practice.java8;

import java.util.Optional;

public class OptionalEx {
    public static void main(String[] args) {
        String nullObject = null;
        String notNullObject = "15";

       Optional<String> optionalNullObject = Optional.ofNullable(nullObject);
        System.out.println(optionalNullObject.isPresent()? optionalNullObject.get() : false);

        Optional<String> optionalNotNullObject = Optional.ofNullable(notNullObject);
        System.out.println(optionalNotNullObject.isPresent()? optionalNotNullObject.get() : false);

        //System.out.println(Optional.of(nullObject)); // this will throw null pointer exception.
        System.out.println(Optional.of(notNullObject)); // this will print simply Optional value.
    }
}
