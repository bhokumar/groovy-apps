package com.github.bhokumar.streams.collectors

import com.github.bhokumar.streams.model.Gender
import com.github.bhokumar.streams.model.Person

import static java.util.stream.Collectors.*

class ApplicationCollcetingAndThen {

    static List<Person> createPeople() {
        Arrays.asList(
                new Person('Sara', Gender.FEMALE, 20),
                new Person('Sara', Gender.FEMALE, 22),
                new Person('Bob', Gender.MALE, 20),
                new Person('Paula', Gender.FEMALE, 32),
                new Person('Paul', Gender.MALE, 32),
                new Person('Jack', Gender.MALE, 2),
                new Person('Jack', Gender.MALE, 72),
                new Person('Jill', Gender.MALE, 42)
        )
    }

    static void main(String[] args) {
/*
       println createPeople().parallelStream()
        .collect(Collectors.groupingBy({it.name}))

        println createPeople().parallelStream()
                .collect(Collectors.groupingBy({it.name}, Collectors.mapping({it.age}, Collectors.toList())))

        println createPeople().parallelStream()
                .collect(Collectors.groupingBy({it.name}, Collectors.counting()))
*/
        println createPeople().stream()
                .collect(groupingBy({ it.name}, collectingAndThen(
                        counting(),
                        {it.intValue()}
                )))
    }

}
