package dev.bernasss12.model;

import dev.bernasss12.enums.EnumTileTerrain;

public class TileMap {

    private int width, height;
    private Tile[][] tileMap;

    public TileMap(int width, int height) {
        this.width = width;
        this.height = height;
         tileMap = new Tile[width][height];
         for(int x = 0; x < width; x++){
             for(int y = 0; y < height; y++){
                 tileMap[x][y] = new Tile(EnumTileTerrain.littleroot_grass);
             }
         }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Tile getTile(int x, int y) {
        return tileMap[x][y];
    }
}
