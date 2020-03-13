package com.bycsmys.character10;

import lombok.Getter;

import java.util.Optional;

/**
 * @Author wangqd
 * @DATE 2020-03-13
 */
public class OptionalTest {


    public static void main(String[] args) {
        Person person = new Person();


        String s = Optional.ofNullable(person)
                .map(Person::getInsurance)
                .map(Insurance::getCar)
                .map(Car::getName).orElse("1");
        System.out.println(s);

        System.out.println("----------------");

        Optional<Person> optionalPerson = Optional.ofNullable(person);

        //NullPointerException
        Optional<Insurance> optionalInsurance = optionalPerson.flatMap(Person::getOptionalInsurance);

        Optional<Car> optionalCar = optionalInsurance.flatMap(Insurance::getOptionalCar);
        String name = optionalCar.map(Car::getName).orElse("1");

        System.out.println(name);

    }


    @Getter
    public static class Person {
        private Insurance insurance;
        private Optional<Insurance> optionalInsurance;

    }

    @Getter
    public static class Insurance {
        private Car car;
        private Optional<Car> optionalCar;
    }

    @Getter
    public static class Car {
        private String name = "123";
    }

}


