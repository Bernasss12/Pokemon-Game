package dev.bernasss12.model;

import com.badlogic.gdx.graphics.Texture;
import dev.bernasss12.enums.EnumTileType;

public class EntityObject extends Entity{
    private boolean solid;

    public EntityObject(TileMap tileMap, int x, int y, boolean solid){
        super(tileMap, x, y, 1, 1, 1f, 1f, solid);
    }

    public EntityObject(TileMap tileMap, int x, int y, int tileWidth, int tileHeight, boolean solid) {
        super(tileMap, x, y, tileWidth, tileHeight, solid);
    }


    public EntityObject(TileMap tileMap, int x, int y, int tileWidth, int tileHeight, float drawWidth, float drawHeight) {
        super(tileMap, x, y, tileWidth, tileHeight, drawWidth, drawHeight, true);
    }


    @Override
    public void update(float delta) {

    }
}
