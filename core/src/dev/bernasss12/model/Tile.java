package dev.bernasss12.model;

import dev.bernasss12.enums.EnumFacing;
import dev.bernasss12.enums.EnumTileTerrain;
import dev.bernasss12.enums.EnumTileType;

import java.util.ArrayList;
import java.util.List;

public class Tile {

    private EnumTileTerrain terrain;
    private EntityActor actor;
    private EntityObject object;
    private EnumTileType type;
    private List<EnumFacing> sides;

    public Tile(EnumTileTerrain terrain) {
        this.terrain = terrain;
        this.type = EnumTileType.NORMAL;
        this.sides = new ArrayList<EnumFacing>();
    }

    public void setActor(EntityActor actor) {
        this.actor = actor;
    }

    public EntityActor getActor() {
        return actor;
    }

    public void setObject(EntityObject object){ this.object = object; }

    public EntityObject getObject(){ return object; }

    public EnumTileTerrain getTerrain() {
        return terrain;
    }

    public void addSide(EnumFacing side){
        this.sides.add(side);
        return;
    }

    public void addSides(EnumFacing side1, EnumFacing side2){
        this.sides.add(side1);
        this.sides.add(side2);
        return;
    }
    public void addSides(EnumFacing side1, EnumFacing side2, EnumFacing side3){
        this.sides.add(side1);
        this.sides.add(side2);
        this.sides.add(side3);
        return;
    }

    public void setType(EnumTileType type) {
        this.type = type;
    }

    public EnumTileType getType() {
        return type;
    }

    public List<EnumFacing> getSides() {
        return sides;
    }
}
