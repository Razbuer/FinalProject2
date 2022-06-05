package GameArea;

import Creatures.Animals.Animal;
import Creatures.ChanceToEat;
import Creatures.NatureFactory;
import Creatures.NatureObject;
import Creatures.NatureType;
import util.*;

import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Cell {
    private final Properties properties = Settings.getProperties();
    private final int width = Integer.parseInt(properties.getProperty("areaWidth"));
    private final int height = Integer.parseInt(properties.getProperty("areaHeight"));
    private final int x;
    private final int y;
    private CopyOnWriteArrayList<CopyOnWriteArrayList<NatureObject>> entityOnCell = new CopyOnWriteArrayList<>();


    public CopyOnWriteArrayList<CopyOnWriteArrayList<NatureObject>> getEntityOnCell() {
        return entityOnCell;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    class LifeCycleAnimalsOnCell implements Runnable {
        private final Cell[][] cells;

        public LifeCycleAnimalsOnCell(Cell[][] cells) {
            this.cells = cells;
        }

        @Override
        public void run() {
            // едим
            for (int i = 0; i < entityOnCell.size(); i++) {
                for (int j = 0; j < entityOnCell.size(); j++) {
                    int chanceToEat = ChanceToEat.getChance(entityOnCell.get(i).get(0).getClass(), entityOnCell.get(j).get(0).getClass());
                    if (chanceToEat > 0 && ThreadLocalRandom.current().nextInt(100) < chanceToEat) {
                        Collections.shuffle(entityOnCell.get(i), ThreadLocalRandom.current());
                        int howManyFood = (int) (entityOnCell.get(j).size() * entityOnCell.get(j).get(0).getWeight());
                        for (NatureObject natureObject : entityOnCell.get(i)) {
                            Animal whoEat = (Animal) natureObject;
                            whoEat.eat(howManyFood -= (int) whoEat.getDailyFoodAllowance());
                        }
                        // Удаляем того кого съели
                        entityOnCell.remove(entityOnCell.get(j));
                    }
                }
            }

            // размножаемся
            for (CopyOnWriteArrayList<NatureObject> natureObjects : entityOnCell) {
                if (natureObjects.get(0) instanceof Animal) {
                    CopyOnWriteArrayList<NatureObject> listOfNewPopulation = new CopyOnWriteArrayList<>();
                    int currentPopulation = natureObjects.size();
                    int maxPopulation = natureObjects.get(0).getMaxPopulation();
                    int howManyNewAnimals = ThreadLocalRandom.current().nextInt(0, currentPopulation / 2);
                    howManyNewAnimals = howManyNewAnimals + currentPopulation > maxPopulation ? maxPopulation - currentPopulation : howManyNewAnimals;
                    for (int i = 0; i < howManyNewAnimals; i++) {
                        listOfNewPopulation.add(((Animal) natureObjects.get(0)).reproduction());
                    }
                    natureObjects.addAll(listOfNewPopulation);
                }
            }

            // двигаемся
            for (CopyOnWriteArrayList<NatureObject> natureObjects : entityOnCell) {
                // Если достали список из животных которые не двигались за такт
                if (natureObjects.get(0) instanceof Animal && !((Animal) natureObjects.get(0)).isMoved() && ((Animal) natureObjects.get(0)).getSpeed() > 0) {
                    int currentSpeed = ThreadLocalRandom.current().nextInt(1, ((Animal) natureObjects.get(0)).getSpeed() + 1);
                    List<Direction> directions = new ChooseDirection().choose(Cell.this, currentSpeed);

                    int where = ThreadLocalRandom.current().nextInt(directions.size());
                    Direction whereMove = directions.get(where);

                    new HerdMove().move(cells, Cell.this, whereMove, currentSpeed, natureObjects);
                    entityOnCell.remove(natureObjects);
                }
            }

            // Выставляем в конце тика, что движений пока не было
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    for (CopyOnWriteArrayList<NatureObject> natureObjects : entityOnCell) {
                        if (natureObjects.get(0) instanceof Animal && ((Animal) natureObjects.get(0)).getSpeed() > 0)
                            for(NatureObject natureObject : natureObjects)
                                ((Animal)natureObject).setMoved(false);
                    }
                }
            }

            // смерть от нехватки здоровья
            for (CopyOnWriteArrayList<NatureObject> natureObjects : entityOnCell) {
                for (NatureObject natureObject : natureObjects) {
                    if (natureObject instanceof Animal && ((Animal) natureObject).getHealth() == 0) {
                        natureObjects.remove(natureObject);
                    }
                }
                // Если умерли все животные от голода удаляем лист
                if (natureObjects.size() == 0)
                    entityOnCell.remove(natureObjects);
            }

        }
    }
}
