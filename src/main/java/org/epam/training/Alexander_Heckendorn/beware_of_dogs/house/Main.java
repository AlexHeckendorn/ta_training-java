package org.epam.training.Alexander_Heckendorn.beware_of_dogs.house;



import org.epam.training.Alexander_Heckendorn.beware_of_dogs.residents.dogs.Dog;
import org.epam.training.Alexander_Heckendorn.beware_of_dogs.residents.cats.Cat;
import org.epam.training.Alexander_Heckendorn.beware_of_dogs.residents.dogs.Puppy;
import org.epam.training.Alexander_Heckendorn.beware_of_dogs.residents.cats.Kitten;



public class Main {

    public static void main(String[] args) {
        Dog rex = new Dog("Rax");
        Puppy randy = new Puppy("Randy");
        Cat barbos = new Cat("Barbos");
        Kitten murzik = new Kitten("Murzik");

        House<Dog> dogHouse = new House<>();
        dogHouse.enter(rex);
        dogHouse.enter(randy);
        //dogHouse.enter(murzik); //This must fail on compilation stage if you parameterize the dogHouse. Delete the line when solution is ready
        System.out.println(dogHouse);

        House<Cat> catHouse = new House<>();
        catHouse.enter(barbos);
        catHouse.enter(murzik);
        //catHouse.enter(rex); //This must fail on compilation stage if you parameterize the catHouse. Delete the line when solution is ready
        System.out.println(catHouse);
    }
}