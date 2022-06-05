package Creatures.Animals;

import Creatures.NatureFactory;
import Creatures.NatureObject;
import Creatures.NatureType;

public class Eagle extends Predator {
    public Eagle() {
        this.weight = 6;
        this.maxPopulation = 20;
        this.speed = 3;
        this.dailyFoodAllowance = 1;
    }

    @Override
    public NatureObject reproduction() {
        return NatureFactory.getAnimal(NatureType.EAGLE);
    }

    @Override
    public String getAvatar() {
        return "\uD83E\uDD85";
    }
}
