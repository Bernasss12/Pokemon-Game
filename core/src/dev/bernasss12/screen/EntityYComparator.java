package dev.bernasss12.screen;

import dev.bernasss12.model.Entity;

import java.util.Comparator;

public class EntityYComparator implements Comparator<Entity> {
    @Override
    public int compare(Entity o1, Entity o2) {
        if (o1.getY() < o2.getY()) {
            return -1;
        } else if (o1.getY() > o2.getY()) {
            return 1;
        }
        return 0;
    }
}
