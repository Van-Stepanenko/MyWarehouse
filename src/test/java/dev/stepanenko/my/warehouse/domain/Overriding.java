package dev.stepanenko.my.warehouse.domain;

import java.util.Random;

public class Overriding {
    public static void main(String[] args) {
        A a = new A();
        a.method();
        a.method("foo");
        B b = new B();
        b.method();
        b.method("bar");

        NameProvider nameProviders[] = {new Dog(), new Cat(), new A(), new B()};

        for (NameProvider nameProvider : nameProviders) {
            System.out.println(nameProvider.name());
        }

    }
    static class A implements NameProvider {
        void method(){
            System.out.println("я метод класса А");
        }
        void method(String arg){
            method();
            System.out.println("я перегруженый метод класса А, с аргументом String: "+arg);
        }

        @Override
        public String name() {
            return "Я вообще не животное! Я очень абстрактный класс!";
        }
    }
    static class B extends A{
        @Override
        void method(){
            System.out.println("я метод класса Б");
        }
    }
   static abstract class Animal implements NameProvider {
        abstract public String name();
    }
    interface NameProvider {
       String name();
    }
    static class Dog extends Animal{

        @Override
       public String name() {
            return "Sharik#"+ new Random().nextInt();
        }
    }
    static class Cat extends Animal{
        private String[] names = {"Barsik","Murzik","Kotya"};
        @Override
        public String name() {
            return names[new Random().nextInt(names.length-1)];
        }
    }
    static class Frog extends Animal{

        @Override
        public String name() {
            throw new RuntimeException("какое нах имя!? я Легуха!");
        }
    }

}
