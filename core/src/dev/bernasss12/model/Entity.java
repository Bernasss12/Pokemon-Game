package dev.bernasss12.model;

import com.badlogic.gdx.graphics.Texture;
import dev.bernasss12.enums.EnumTileType;

public abstract class Entity {
    private TileMap tileMap;
    private int x, y, tileWidth, tileHeight;
    private float drawWidth, drawHeight;
    private boolean solid;

    public Entity(TileMap map, int x, int y) {
        this.tileMap = tileMap;
        this.x = x;
        this.y = y;
    }

    public Entity(TileMap tileMap, int x, int y, int tileWidth, int tileHeight, float drawWidth, float drawHeight, boolean solid) {
        this.tileMap = tileMap;
        this.x = x;
        this.y = y;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.drawWidth = drawWidth;
        this.drawHeight = drawHeight;
        this.solid = solid;
    }

    public Entity(TileMap tileMap, int x, int y, int tileWidth, int tileHeight, boolean solid) {
        this.tileMap = tileMap;
        this.x = x;
        this.y = y;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.solid = solid;
    }

    public abstract void update(float delta);

    public TileMap getMap() {
        return tileMap;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getTileWidth() {
        return tileWidth;
    }

    public int getTileHeight() {
        return tileHeight;
    }

    public float getDrawWidth() {
        if(drawWidth == 0f) return (float) tileWidth;
        return drawWidth;
    }

    public float getDrawHeight() {
        if(drawHeight == 0f) return (float) tileHeight;
        return drawHeight;
    }

    public void setTileSize(int height, int width) {
        this.tileHeight = height;
        this.tileWidth = width;
        if(solid){
            for(int x = 0; x < width; x++){
                for(int y = 0; y < height; y++){
                    tileMap.getTile(this.x + x, this.y + y).setType(EnumTileType.SOLID);
                }
            }
        }
    }

    public void setDrawSize(float width, float height) {
        this.drawHeight = height;
        this.drawWidth = width;
    }

    public TileMap getTileMap() {
        return tileMap;
    }

    public boolean isSolid() {
        return solid;
    }
}
