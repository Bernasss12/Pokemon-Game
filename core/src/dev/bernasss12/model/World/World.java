package dev.bernasss12.model.World;

import dev.bernasss12.enums.EnumTileType;
import dev.bernasss12.model.*;

import java.util.ArrayList;
import java.util.List;

public class World {
    
    private String name;
    private TileMap tileMap;
    private List<Entity> entities;

    public World(int x, int y) {
        this.tileMap = new TileMap(x, y);
        entities = new ArrayList<Entity>();
    }

    public void addActor(EntityActor a){
        entities.add(a);
        tileMap.getTile(a.getX(), a.getY()).setActor(a);
    }

    public void addObject(EntityObject o){
        entities.add(o);
        if(o.isSolid()){
            for(int x = 0; x < o.getTileWidth(); x++){
                for(int y = 0; y < o.getTileHeight(); y++){
                    tileMap.getTile(o.getX() + x, o.getY() + y).setType(EnumTileType.SOLID);
                }
            }
        }
    }

    public void update(float delta){
        for(Entity e : entities){
            e.update(delta);
        }
    }

    public String getName() {
        return name;
    }

    public TileMap getTileMap() {
        return tileMap;
    }

    public List<Entity> getEntities() {
        return entities;
    }
}
