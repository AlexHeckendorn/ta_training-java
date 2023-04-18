package com.epam.training.Alexander_Heckendorn.beware_of_dogs.house;

import com.epam.training.Alexander_Heckendorn.beware_of_dogs.residents.cats.Cat;
import com.epam.training.Alexander_Heckendorn.beware_of_dogs.residents.dogs.Dog;


import java.util.ArrayList;
import java.util.List;

public class House<T> {

    private final List<T> residents = new ArrayList<>();

    public void enter(T resident) {
        if (resident instanceof Dog && !residents.isEmpty() && residents.get(0) instanceof Cat) {
            System.out.println("Dogs cannot enter cats' house");
            return;
        } else if (resident instanceof Cat && !residents.isEmpty() && residents.get(0) instanceof Dog) {
            System.out.println("Cats cannot enter dogs' house");
            return;
        }
        residents.add(resident);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("There are following residents in the house:\n");
        for (Object resident : residents) {
            builder.append(resident.toString()).append("\n");
        }
        return builder.toString();
    }
}
