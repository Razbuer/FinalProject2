package util;

import Creatures.NatureFactory;
import Creatures.NatureObject;
import Creatures.NatureType;
import Creatures.Plants.Plants;
import Creatures.Plants.PlantsFactory;
import Creatures.Plants.PlantsType;
import GameArea.Cell;

import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class SettlingPlants implements Runnable {
    private final Properties properties = Settings.getProperties();
    private final int width = Integer.parseInt(properties.getProperty("areaWidth"));
    private final int height = Integer.parseInt(properties.getProperty("areaHeight"));
    private final Cell[][] cells;

    public SettlingPlants(Cell[][] cells) {
        this.cells = cells;
    }

    @Override
    public void run() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // выбираем чем будем заселять
                CopyOnWriteArrayList<NatureObject> listOfPlants = new CopyOnWriteArrayList<>();
                int what = ThreadLocalRandom.current().nextInt(PlantsType.values().length);
                Plants plants = PlantsFactory.getPlant(PlantsType.values()[what]);
                // сколько
                int count = ThreadLocalRandom.current().nextInt(1, plants.getMaxPopulation() + 1);
                boolean foundSimilar = false;
                for (CopyOnWriteArrayList<NatureObject> natureObjects : cells[i][j].getEntityOnCell()) {
                    //if (count > plants.getMaxPopulation() - natureObjects.size())
                    if (natureObjects.get(0).getClass() == plants.getClass()) {
                        // Добавляем расстения, но не больше того, сколько возможно, учитывая популяцию
                        count = count + natureObjects.size() > plants.getMaxPopulation() ? plants.getMaxPopulation() - natureObjects.size() : count;
                        for (int k = 0; k < count; k++) {
                            natureObjects.add(PlantsFactory.getPlant(PlantsType.values()[what]));
                        }
                        foundSimilar = true;
                    }
                }
                // Если подобных растейний нет на клетке
                if (!foundSimilar) {
                    for (int k = 0; k < count; k++) {
                        listOfPlants.add(PlantsFactory.getPlant(PlantsType.values()[what]));
                    }
                    cells[i][j].getEntityOnCell().add(listOfPlants);
                }
            }
        }
    }
}
