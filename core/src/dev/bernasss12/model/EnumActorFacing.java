package dev.bernasss12.model;

public enum EnumActorFacing {
    //Directions
    NORTH(0, 1),
    SOUTH(0, -1),
    EAST(1, 0),
    WEST(-1, 0);

    //Convinience names
    public static final EnumActorFacing N = NORTH;
    public static final EnumActorFacing S = SOUTH;
    public static final EnumActorFacing E = EAST;
    public static final EnumActorFacing W = WEST;
    public static final EnumActorFacing UP = NORTH;
    public static final EnumActorFacing DOWN = SOUTH;
    public static final EnumActorFacing RIGHT = EAST;
    public static final EnumActorFacing LEFT = WEST;

    private int x, y;

    EnumActorFacing(int x, int y){
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
