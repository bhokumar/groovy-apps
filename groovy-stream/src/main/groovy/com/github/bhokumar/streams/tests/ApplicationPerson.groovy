package com.github.bhokumar.streams.tests

import com.github.bhokumar.streams.model.Gender
import com.github.bhokumar.streams.model.Person

class ApplicationPerson {
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
        // Find the first lady who is older than 30
        println createPeople().stream()
                .filter({person -> person.age > 30})
                .filter({person -> person.gender == Gender.FEMALE})
                .map({person -> person.name})
                .findFirst()
                .orElse('No One Found')

    }
}
