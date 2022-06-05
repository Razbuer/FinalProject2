package util;

import GameArea.Cell;

import java.util.*;

public class ChooseDirection {
    private final Properties properties = Settings.getProperties();
    private final int width = Integer.parseInt(properties.getProperty("areaWidth"));
    private final int height = Integer.parseInt(properties.getProperty("areaHeight"));

    public List<Direction> choose(Cell cell, int speed) {
        List<Direction> directions = new ArrayList<>(List.of(Direction.values()));

        if (speed > cell.getX())
            directions.remove(Direction.UP);
        if (speed > cell.getY())
            directions.remove(Direction.LEFT);
        if (speed > height - cell.getX() - 1)
            directions.remove(Direction.DOWN);
        if (speed > width - cell.getY() - 1)
            directions.remove(Direction.RIGHT);

        return directions;
    }
}
