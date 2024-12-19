package src.src.crackingTheCodingInterview.stacksAndQueues;

import java.util.*;

class Animal {
    String name;
    long timeOfArrival;

    Animal(String nam, long timeOfArr) {
        this.name = nam;
        this.timeOfArrival = timeOfArr;
    }

    Animal(String nam) {
        this.name = nam;
        this.timeOfArrival = System.currentTimeMillis();
    }

}


class Dog extends Animal{
    Dog(String name, long timeOfArrival) {
        super(name, timeOfArrival);
    }

    Dog(String name) {
        super(name);
    }
}

class Cat extends Animal{
    Cat(String name, long timeOfArrival) {
        super(name, timeOfArrival);
    }
    Cat(String name) {
        super(name);
    }
}



class AnimalShelter {

    LinkedList<Cat> cats  = new LinkedList<>();
    LinkedList<Dog> dogs  = new LinkedList<>();


    void enqueue(Animal animal) {


        if (animal instanceof Dog) {
            LinkedList<Dog> newDog = new LinkedList<>();
            newDog.add((Dog) animal);
            newDog.addAll(dogs);
            dogs = newDog;
        } else if (animal instanceof Cat) {
            LinkedList<Cat> newCat = new LinkedList<>();
            newCat.add((Cat) animal);
            newCat.addAll(cats);
            cats = newCat;
        }

    }

    Animal dequeueAny() {
        long oldestCat;
        if (cats.getFirst() != null) {
            oldestCat = cats.getFirst().timeOfArrival;
        }else {
            oldestCat = -1;
        }

        long oldestDog;
        if (dogs.getFirst() != null) {
            oldestDog = dogs.getFirst().timeOfArrival;
        }else {
            oldestDog = -1;
        }

        if (oldestCat == -1 && oldestDog == -1) {
            return null;
        }


        if (oldestCat >= oldestDog) {
            Cat cat = cats.getFirst();
            if (cats.get(1) != null) {
                cats.removeFirst();
            }else {
                cats  = new LinkedList<>();
            }
            return cat;

        } else {
            Dog dog = dogs.getFirst();
            if (dogs.get(1) != null) {
                dogs.removeFirst();
            }else {
                dogs  = new LinkedList<>();
            }
            return dog;
        }

    }

    Dog dequeueDog() {
        Dog dog;
        if (dogs.getFirst() != null ) {
            dog = dogs.getFirst();
        }else {
            return null;
        }

        if (dogs.get(1) != null) {
            dogs.removeFirst();
        }else {
            dogs = new LinkedList<>();
        }

        return dog;

    }

    Cat dequeueCat() {
        Cat cat;
        if (cats.getFirst() != null ) {
            cat = cats.getFirst();
        }else {
            return null;
        }

        if (cats.get(1) != null) {
            cats.removeFirst();
        }else {
            cats = new LinkedList<>();
        }
        return cat;
    }

    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();

        shelter.enqueue(new Cat("1"));
        shelter.enqueue(new Cat("2"));
        shelter.enqueue(new Cat("3"));


        shelter.enqueue(new Dog("1"));
        shelter.enqueue(new Dog("2"));
        shelter.enqueue(new Dog("3"));

        Animal an = shelter.dequeueAny();

        Dog d = shelter.dequeueDog();
        Cat x = shelter.dequeueCat();

        System.out.println(an.getClass());
        System.out.println(d.name);
        System.out.println(x.name);


    }


}
