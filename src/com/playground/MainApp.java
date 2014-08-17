package com.playground;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainApp {

    public static Predicate<Person> malesOver21() {
        return p -> p.getAge() > 21 && p.getGender().equalsIgnoreCase("M");
    }

    public static Predicate<Person> femalesOver18() {
        return p -> p.getAge() > 18 && p.getGender().equalsIgnoreCase("F");
    }

    public static void main(String[] args) {
        List<Person> people = getSamplePeople();

        //filters males over 21
        System.out.println("Males over 21");
        List<Person> maleAdults =
                people
                .stream()
                .filter( malesOver21() )
                .collect(Collectors.<Person>toList());
        maleAdults.forEach(p -> System.out.println(p.getFirstName() + "," +p.getAge()));

        System.out.println("\nFemales over 18");
        List<Person> femalesOver18 =
                people
                .stream()
                .filter(femalesOver18())
                .collect(Collectors.<Person>toList());
        femalesOver18.forEach(p -> System.out.println(p.getFirstName() + "," +p.getAge()));

    }

    public static List<Person> getSamplePeople() {
        return Arrays.asList(
            new Person(1, 23, "M", "Person1", "Person1"),
            new Person(2, 13, "F", "Person2", "Person2"),
            new Person(3, 43, "M", "Person3", "Person3"),
            new Person(4, 26, "M", "Person4", "Person4"),
            new Person(5, 19, "F", "Person5", "Person5"),
            new Person(6, 15, "M", "Person6", "Person6"),
            new Person(7, 68, "F", "Person7", "Person7"),
            new Person(8, 79, "M", "Person8", "Person8"),
            new Person(9, 15, "F", "Person8", "Person8"),
            new Person(10, 45, "M", "Person10", "Person10")
        );


    }
}


