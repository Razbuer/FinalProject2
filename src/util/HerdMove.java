package util;

import Creatures.Animals.Animal;
import Creatures.NatureObject;
import GameArea.Cell;

import java.util.concurrent.CopyOnWriteArrayList;

public class HerdMove {
    public void move(Cell[][] cells, Cell cell, Direction whereMove, int speed, CopyOnWriteArrayList<NatureObject> animals) {
        switch(whereMove) {
            case UP -> cells[cell.getX() - speed][cell.getY()].getEntityOnCell().add(animals);
            case RIGHT -> cells[cell.getY() + speed][cell.getY()].getEntityOnCell().add(animals);
            case DOWN -> cells[cell.getX() + speed][cell.getY()].getEntityOnCell().add(animals);
            case LEFT -> cells[cell.getY() - speed][cell.getY()].getEntityOnCell().add(animals);
        }

        // Вызываем метод move у каждого животного, чтобы вызвать голод и выставить флаг о движении
        for (NatureObject animal : animals) {
            ((Animal)animal).move();
        }
    }
}
