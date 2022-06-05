package Creatures.Animals;

import Creatures.NatureFactory;
import Creatures.NatureObject;
import Creatures.NatureType;

public class Snake extends Predator {
    public Snake() {
        this.weight = 15;
        this.maxPopulation = 30;
        this.speed = 1;
        this.dailyFoodAllowance = 3;
    }

    @Override
    public NatureObject reproduction() {
        return NatureFactory.getAnimal(NatureType.SNAKE);
    }


    @Override
    public String getAvatar() {
        return "\uD83D\uDC0D";
    }
}
