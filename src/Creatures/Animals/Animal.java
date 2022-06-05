package Creatures.Animals;

import Creatures.Eatable;
import Creatures.NatureFactory;
import Creatures.NatureObject;
import Creatures.Plants.Plants;
import GameArea.Cell;

public abstract class Animal extends NatureObject implements Eatable {
    protected int speed;
    protected float dailyFoodAllowance;
    protected int health = 100;
    protected boolean isMoved;

    // если животное не наелось за ход
    public int hunger() {
        return health -= dailyFoodAllowance * 100 / getWeight();
    }

    //
    public void eat(int howMany) {
        int saturation = (int) (howMany * 100 / dailyFoodAllowance);

//        if (meal instanceof Animal) {
//            Animal animal = (Animal)meal;
//            saturation = (int) (animal.getWeight() * 100 / dailyFoodAllowance);
//        }
//        if (meal instanceof Plants) {
//            Plants plants = (Plants)meal;
//            saturation = (int) (plants.getWeight() * 100 / dailyFoodAllowance);
//        }

        health += saturation;

        if (health > 100)
            health = 100;
    }

    public abstract NatureObject reproduction();

    // При движении животное голодает, если у него не хватит здоровья он может умереть
    public void move() {
        hunger();
        isMoved = true;
    }

    public boolean isMoved() {
        return isMoved;
    }

    public void setMoved(boolean moved) {
        isMoved = moved;
    }

    public int getSpeed() {
        return speed;
    }

    public float getDailyFoodAllowance() {
        return dailyFoodAllowance;
    }

    public int getHealth() {
        return health;
    }
}
