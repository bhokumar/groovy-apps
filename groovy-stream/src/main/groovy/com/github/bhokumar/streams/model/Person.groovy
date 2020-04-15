package com.github.bhokumar.streams.model

class Person {
    String name
    Gender gender
    int age

    Person(String name, Gender gender, int age) {
        this.name = name
        this.gender = gender
        this.age = age
    }
}
