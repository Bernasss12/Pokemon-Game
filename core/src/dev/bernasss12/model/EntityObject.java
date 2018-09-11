package dev.bernasss12.model;

public class EntityObject extends Entity{
    private int x, y;
    private TileMap tileMap;
    private int tileWidth, tileHeight;
    private float drawWidth = 0f, drawHeight = 0f;
    private boolean solid;

    public EntityObject(TileMap tileMap, int x, int y, boolean solid){
        this.tileMap = tileMap;
        this.x = x;
        this.y = y;
        this.tileWidth = 1;
        this.tileHeight = 1;
        this.solid = solid;
        if(solid){
            tileMap.getTile(x, y).setType(EnumTileType.SOLID);
        }
    }

    public int getTileWidth() {
        return tileWidth;
    }

    public void setTileWidth(int tileWidth) {
        this.tileWidth = tileWidth;
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
}
