package dev.bernasss12.model;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import dev.bernasss12.Settings;
import dev.bernasss12.utilities.AnimationSet;

public class Actor {
    private int x, y;
    private TileMap tileMap;
    private EnumActorFacing direction;

    private float drawX, drawY, walkTimer;
    private int srcX, srcY, destX, destY;
    
    private float animationTimer;
    private boolean moveRequestThisFrame;

    private EnumActorState state;

    private AnimationSet animations;

    public Actor(TileMap tileMap, int x, int y, AnimationSet animations) {
        this.tileMap = tileMap;
        this.x = x;
        this.y = y;
        this.drawX = x;
        this.drawY = y;
        this.animations = animations;
        tileMap.getTile(x, y).setActor(this);
        this.state = EnumActorState.STANDING;
        this.direction = EnumActorFacing.S;
    }

    public void update(float delta) {
        if (state == EnumActorState.WALKING){
            walkTimer += delta;
            animationTimer += delta;
            this.drawX = Interpolation.linear.apply(srcX, destX, walkTimer / Settings.TIME_PER_TILE);
            this.drawY = Interpolation.linear.apply(srcY, destY, walkTimer / Settings.TIME_PER_TILE);

            if(walkTimer > Settings.TIME_PER_TILE){
                animationTimer -= (walkTimer - Settings.TIME_PER_TILE);
                finishMove();
                if(moveRequestThisFrame){
                    move(direction);
                }else {
                    walkTimer = 0f;
                }
            }
        }
        System.out.println("XY: " + this.x + "   " + this.y);
        System.out.println("DR: " + this.drawX + " " + this.drawY);
        moveRequestThisFrame = false;
    }

    public boolean move(EnumActorFacing dir){
        if(state == EnumActorState.WALKING){
            if(direction == dir) moveRequestThisFrame = true;
            return false;
        }
        if(x+dir.getX() < 0 || x+dir.getX() >= tileMap.getWidth() || y+dir.getY() < 0 || y+dir.getY() >= tileMap.getHeight()){
            return false;
        }
        if (tileMap.getTile(x+dir.getX(), y+dir.getY()).getActor() != null) {
            return false;
        }
        initializeMove(dir);
        tileMap.getTile(x, y).setActor(null);
        x += dir.getX();
        y += dir.getY();
        tileMap.getTile(x, y).setActor(this);
        return true;
    }

    private void initializeMove(EnumActorFacing dir){
        this.direction = dir;
        this.srcX = x;
        this.srcY = y;
        this.destX = srcX + dir.getX();
        this.destY = srcY + dir.getY();
        this.drawX = x;
        this.drawY = y;
        walkTimer = 0f;
        state = EnumActorState.WALKING;
    }

    private void finishMove(){
        state = EnumActorState.STANDING;
        this.drawX = x;
        this.drawY = y;
        this.srcX = 0;
        this.srcY = 0;
        this.destX = 0;
        this.destY = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public float getDrawX() {
        return drawX;
    }

    public float getDrawY() {
        return drawY;
    }

    public TextureRegion getSprite(){
        switch(state){
            case WALKING:
                return animations.getWalking(direction).getKeyFrame(animationTimer);
            case STANDING:
                return animations.getStanding(direction);
            default:
                return animations.getStanding(EnumActorFacing.N);
        }
    }
}
