package util;

import Creatures.NatureObject;
import GameArea.AreaView;
import GameArea.Cell;

import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;

public class RenderAndStatistics implements Runnable {
    private final Properties properties = Settings.getProperties();
    private final int width = Integer.parseInt(properties.getProperty("areaWidth"));
    private final int height = Integer.parseInt(properties.getProperty("areaHeight"));
    private final Cell[][] cells;
    private int wolf;
    private int snake;
    private int fox;
    private int bear;
    private int eagle;
    private int horse;
    private int deer;
    private int rabbit;
    private int buffalo;
    private int goat;
    private int sheep;
    private int mouse;
    private int hog;
    private int duck;
    private int caterpillar;
    private int grass;
    private int berries;

    public RenderAndStatistics(Cell[][] cells) {
        this.cells = cells;
    }

    @Override
    public void run() {
        StringBuilder infoString = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                StringBuilder renderString = new StringBuilder();
                for (CopyOnWriteArrayList<NatureObject> natureObjects : cells[i][j].getEntityOnCell()) {
                    renderString.append(natureObjects.get(0).getAvatar() + "(" + natureObjects.size() + ")\n");

                    switch (natureObjects.get(0).getClass().getSimpleName()) {
                        case "Wolf" -> wolf += natureObjects.size();
                        case "Snake" -> snake += natureObjects.size();
                        case "Fox" -> fox += natureObjects.size();
                        case "Bear" -> bear += natureObjects.size();
                        case "Eagle" -> eagle += natureObjects.size();
                        case "Horse" -> horse += natureObjects.size();
                        case "Deer" -> deer += natureObjects.size();
                        case "Rabbit" -> rabbit += natureObjects.size();
                        case "Buffalo" -> buffalo += natureObjects.size();
                        case "Goat" -> goat += natureObjects.size();
                        case "Sheep" -> sheep += natureObjects.size();
                        case "Mouse" -> mouse += natureObjects.size();
                        case "Hog" -> hog += natureObjects.size();
                        case "Duck" -> duck += natureObjects.size();
                        case "Caterpillar" -> caterpillar += natureObjects.size();
                        case "Grass" -> grass += natureObjects.size();
                        case "Berries" -> berries += natureObjects.size();
                    }
                }
                AreaView.table.setValueAt(renderString.toString(), i, j);
            }
        }

        infoString.append("Статистика: \n" +
                "wolf=" + wolf +
                ", \nsnake=" + snake +
                ", \nfox=" + fox +
                ", \nbear=" + bear +
                ", \neagle=" + eagle +
                ", \nhorse=" + horse +
                ", \ndeer=" + deer +
                ", \nrabbit=" + rabbit +
                ", \nbuffalo=" + buffalo +
                ", \ngoat=" + goat +
                ", \nsheep=" + sheep +
                ", \nmouse=" + mouse +
                ", \nhog=" + hog +
                ", \nduck=" + duck +
                ", \ncaterpillar=" + caterpillar +
                ", \ngrass=" + grass +
                ", \nberries=" + berries);
        AreaView.info.setText(infoString.toString());

        wolf = snake = fox = bear = eagle = horse = deer = rabbit = buffalo = goat = sheep = mouse = hog = duck = caterpillar = grass = berries = 0;
    }
}
