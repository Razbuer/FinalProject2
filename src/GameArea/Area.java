package GameArea;

import Creatures.Animals.Animal;
import Creatures.NatureFactory;
import Creatures.NatureObject;
import Creatures.NatureType;
import util.*;

import java.util.*;
import java.util.concurrent.*;

public class Area {
    private final Properties properties = Settings.getProperties();
    private final int width = Integer.parseInt(properties.getProperty("areaWidth"));
    private final int height = Integer.parseInt(properties.getProperty("areaHeight"));
    private final Cell[][] cells = new Cell[height][width];

    public Area() {
        new AreaView();
        init();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
        executorService.scheduleAtFixedRate(new RenderAndStatistics(cells) , 0, 5, TimeUnit.MILLISECONDS);
        executorService.scheduleAtFixedRate(new LifeCycle() , 1, 5, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(new SettlingPlants(cells) , 1, 5, TimeUnit.SECONDS);

    }

    private void init() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // Генерируем список ячеек
                cells[i][j] = new Cell(i, j);

                // Рандомно выбирает кого и сколько создавать и этот список отправляем в ячейку
                CopyOnWriteArrayList<NatureObject> listOfNatureOneType = new CopyOnWriteArrayList<>();
                int who = ThreadLocalRandom.current().nextInt(NatureType.values().length);
                NatureObject natureObject = NatureFactory.getAnimal(NatureType.values()[who]);
                int count = ThreadLocalRandom.current().nextInt(1, natureObject.getMaxPopulation() + 1);
                listOfNatureOneType.add(natureObject);
                for (int k = 1; k < count; k++) {
                    listOfNatureOneType.add(NatureFactory.getAnimal(NatureType.values()[who]));
                }

                cells[i][j].getEntityOnCell().add(listOfNatureOneType);
            }
        }
    }

//    class Motion implements Runnable {
//        @Override
//        public void run() {
//            for (int i = 0; i < height; i++) {
//                for (int j = 0; j < width; j++) {
//                    for (CopyOnWriteArrayList<NatureObject> natureObjects : cells[i][j].getEntityOnCell()) {
//                        // Если достали список из животных которые не двигались за такт
//                        if (natureObjects.get(0) instanceof Animal && !((Animal) natureObjects.get(0)).isMoved() && ((Animal) natureObjects.get(0)).getSpeed() > 0) {
//                            // move
//                            int currentSpeed = ThreadLocalRandom.current().nextInt(0, ((Animal) natureObjects.get(0)).getSpeed());
//                            List<Direction> directions = new ChooseDirection().choose(cells[i][j], currentSpeed);
//
//                            int where = ThreadLocalRandom.current().nextInt(directions.size());
//                            Direction whereMove = directions.get(where);
//
//                            new HerdMove().move(cells, cells[i][j], whereMove, currentSpeed, natureObjects);
//                            cells[i][j].getEntityOnCell().remove(natureObjects);
//                        }
//                    }
//                }
//            }
//
//            // Выставляем в конце тика, что движений пока не было
//            for (int i = 0; i < height; i++) {
//                for (int j = 0; j < width; j++) {
//                    for (CopyOnWriteArrayList<NatureObject> natureObjects : cells[i][j].getEntityOnCell()) {
//                        if (natureObjects.get(0) instanceof Animal && ((Animal) natureObjects.get(0)).getSpeed() > 0)
//                            for(NatureObject natureObject : natureObjects)
//                                ((Animal)natureObject).setMoved(false);
//                    }
//                }
//            }
//        }
//    }

    class LifeCycle implements Runnable {
        ExecutorService service = Executors.newCachedThreadPool();

        @Override
        public void run() {
            ExecutorService service = Executors.newCachedThreadPool();
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    service.submit(cells[y][x].new LifeCycleAnimalsOnCell(cells));
                }
            }
            service.shutdown();
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public static void main(String[] args) {

    }
}
