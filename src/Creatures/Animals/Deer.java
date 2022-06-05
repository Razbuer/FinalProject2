package Creatures.Animals;

import Creatures.NatureFactory;
import Creatures.NatureObject;
import Creatures.NatureType;

public class Deer extends Predator {
    public Deer() {
        this.weight = 300;
        this.maxPopulation = 20;
        this.speed = 4;
        this.dailyFoodAllowance = 50;
    }

    @Override
    public NatureObject reproduction() {
        return NatureFactory.getAnimal(NatureType.DEER);
    }

    @Override
    public String getAvatar() {
        return "\uD83E\uDD8C";
    }
}
