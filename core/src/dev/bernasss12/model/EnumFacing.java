package dev.bernasss12.model;

public enum EnumFacing {
    //Directions
    NORTH(0, 1),
    SOUTH(0, -1),
    EAST(1, 0),
    WEST(-1, 0);

    //Convinience names
    public static final EnumFacing N = NORTH;
    public static final EnumFacing S = SOUTH;
    public static final EnumFacing E = EAST;
    public static final EnumFacing W = WEST;
    public static final EnumFacing UP = NORTH;
    public static final EnumFacing DOWN = SOUTH;
    public static final EnumFacing RIGHT = EAST;
    public static final EnumFacing LEFT = WEST;

    private int x, y;

    EnumFacing(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
