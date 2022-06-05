package Creatures;

import Creatures.Animals.*;
import Creatures.Plants.*;
import util.Pair;

import java.util.concurrent.ConcurrentHashMap;

public class ChanceToEat {
    private static final ConcurrentHashMap<Pair, Integer> chanceToEat = new ConcurrentHashMap<>();
    
    static {
        // Кого ест волк
        chanceToEat.put(new Pair(Wolf.class, Horse.class), 20);
        chanceToEat.put(new Pair(Wolf.class, Horse.class), 10);
        chanceToEat.put(new Pair(Wolf.class, Deer.class), 15);
        chanceToEat.put(new Pair(Wolf.class, Rabbit.class), 60);
        chanceToEat.put(new Pair(Wolf.class, Mouse.class), 80);
        chanceToEat.put(new Pair(Wolf.class, Goat.class), 60);
        chanceToEat.put(new Pair(Wolf.class, Sheep.class), 70);
        chanceToEat.put(new Pair(Wolf.class, Hog.class), 15);
        chanceToEat.put(new Pair(Wolf.class, Buffalo.class), 10);
        chanceToEat.put(new Pair(Wolf.class, Duck.class), 40);

        // Кого ест удав
        chanceToEat.put(new Pair(Snake.class, Fox.class), 15);
        chanceToEat.put(new Pair(Snake.class, Rabbit.class), 20);
        chanceToEat.put(new Pair(Snake.class, Mouse.class), 40);
        chanceToEat.put(new Pair(Snake.class, Duck.class), 10);

        // Кого ест лиса
        chanceToEat.put(new Pair(Fox.class, Rabbit.class), 70);
        chanceToEat.put(new Pair(Fox.class, Mouse.class), 90);
        chanceToEat.put(new Pair(Fox.class, Duck.class), 60);
        chanceToEat.put(new Pair(Fox.class, Caterpillar.class), 40);

        // Кого ест медведь
        chanceToEat.put(new Pair(Bear.class, Snake.class), 80);
        chanceToEat.put(new Pair(Bear.class, Horse.class), 40);
        chanceToEat.put(new Pair(Bear.class, Deer.class), 80);
        chanceToEat.put(new Pair(Bear.class, Rabbit.class), 80);
        chanceToEat.put(new Pair(Bear.class, Mouse.class), 90);
        chanceToEat.put(new Pair(Bear.class, Goat.class), 70);
        chanceToEat.put(new Pair(Bear.class, Sheep.class), 70);
        chanceToEat.put(new Pair(Bear.class, Hog.class), 50);
        chanceToEat.put(new Pair(Bear.class, Buffalo.class), 20);
        chanceToEat.put(new Pair(Bear.class, Duck.class), 10);

        // Кого ест орел
        chanceToEat.put(new Pair(Eagle.class, Fox.class), 10);
        chanceToEat.put(new Pair(Eagle.class, Rabbit.class), 90);
        chanceToEat.put(new Pair(Eagle.class, Mouse.class), 90);
        chanceToEat.put(new Pair(Eagle.class, Duck.class), 80);

        // Кого ест лошадь
        chanceToEat.put(new Pair(Horse.class, Grass.class), 100);
        chanceToEat.put(new Pair(Horse.class, Berries.class), 100);

        // Кого ест олень
        chanceToEat.put(new Pair(Deer.class, Grass.class), 100);
        chanceToEat.put(new Pair(Deer.class, Berries.class), 100);

        // Кого ест кролик
        chanceToEat.put(new Pair(Rabbit.class, Grass.class), 100);
        chanceToEat.put(new Pair(Rabbit.class, Berries.class), 100);

        // Кого ест мышь
        chanceToEat.put(new Pair(Mouse.class, Caterpillar.class), 90);
        chanceToEat.put(new Pair(Mouse.class, Grass.class), 100);
        chanceToEat.put(new Pair(Mouse.class, Berries.class), 100);

        // Кого ест коза
        chanceToEat.put(new Pair(Goat.class, Grass.class), 100);
        chanceToEat.put(new Pair(Goat.class, Berries.class), 100);

        // Кого ест овца
        chanceToEat.put(new Pair(Sheep.class, Grass.class), 100);
        chanceToEat.put(new Pair(Sheep.class, Berries.class), 100);

        // Кого ест кабан
        chanceToEat.put(new Pair(Hog.class, Mouse.class), 50);
        chanceToEat.put(new Pair(Hog.class, Caterpillar.class), 90);
        chanceToEat.put(new Pair(Hog.class, Grass.class), 100);
        chanceToEat.put(new Pair(Hog.class, Berries.class), 100);

        // Кого ест буйвол
        chanceToEat.put(new Pair(Buffalo.class, Grass.class), 100);
        chanceToEat.put(new Pair(Buffalo.class, Berries.class), 100);

        // Кого ест утка
        chanceToEat.put(new Pair(Duck.class, Caterpillar.class), 90);
        chanceToEat.put(new Pair(Duck.class, Grass.class), 100);
        chanceToEat.put(new Pair(Duck.class, Berries.class), 100);

        // Кого ест гусеница
        chanceToEat.put(new Pair(Caterpillar.class, Grass.class), 100);
        chanceToEat.put(new Pair(Caterpillar.class, Berries.class), 100);


    }

    public static Integer getChance(Class who, Class whom) {
        Pair pair = new Pair(who, whom);
        return chanceToEat.containsKey(pair) ? chanceToEat.get(pair) : 0;
    }
}
