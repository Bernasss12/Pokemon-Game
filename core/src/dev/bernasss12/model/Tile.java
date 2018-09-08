package dev.bernasss12.model;

public class Tile {

    private EnumTerrain terrain;
    private Actor actor;

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Actor getActor() {
        return actor;
    }

    public Tile(EnumTerrain terrain) {
        this.terrain = terrain;
    }

    public EnumTerrain getTerrain() {
        return terrain;
    }
}
