package Creatures.Animals;

import Creatures.NatureFactory;
import Creatures.NatureObject;
import Creatures.NatureType;

public class Sheep extends Herbivores {
    public Sheep() {
        this.weight = 70;
        this.maxPopulation = 140;
        this.speed = 3;
        this.dailyFoodAllowance = 15;
    }

    @Override
    public NatureObject reproduction() {
        return NatureFactory.getAnimal(NatureType.SHEEP);
    }


    @Override
    public String getAvatar() {
        return "\uD83D\uDC11";
    }
}
