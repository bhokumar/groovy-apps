package com.github.bhokumar.streams.collectors

import com.github.bhokumar.streams.model.Gender
import com.github.bhokumar.streams.model.Person

import java.util.stream.Collectors

class ApplicationToMap {

    static List<Person> createPeople() {
        Arrays.asList(
                //new Person('Sara', Gender.FEMALE, 20),
                new Person('Sara', Gender.FEMALE, 22),
                new Person('Bob', Gender.MALE, 20),
                new Person('Paula', Gender.FEMALE, 32),
                new Person('Paul', Gender.MALE, 32),
                //new Person('Jack', Gender.MALE, 2),
                new Person('Jack', Gender.MALE, 72),
                new Person('Jill', Gender.MALE, 42)
        )
    }

    static void main(String[] args) {

       println createPeople().parallelStream()
        .collect(Collectors.toMap({it.name}, {it.age}))
    }

}
