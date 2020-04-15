package com.github.bhokumar.streams.collectors

import com.github.bhokumar.streams.model.Gender
import com.github.bhokumar.streams.model.Person

import java.util.stream.Collectors

class ApplicationStream {

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
        print createPeople().stream()
            .map({it.getAge()})
            .reduce(0, {total, item -> total + item})

        // Get the list of names, in upper case,
        // of those who are older than 30

       println createPeople().parallelStream()
        .filter({it.age > 30})
        .map({it.name})
        .map({it.toUpperCase()})
        //.reduce([], {names, name -> names << name}, {names1, names2 -> names1 << names2})
        .collect(Collectors.toList())

        println createPeople().parallelStream()
            .map({it.name})
            .collect(Collectors.toUnmodifiableList())
    }

}
