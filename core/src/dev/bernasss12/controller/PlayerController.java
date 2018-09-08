package dev.bernasss12.controller;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import dev.bernasss12.model.Actor;
import dev.bernasss12.model.EnumActorFacing;

public class PlayerController extends InputAdapter {

    private Actor player;

    private boolean up, down, left, right;

    public PlayerController(Actor player) {
        this.player = player;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode){
            case Keys.UP:
                up = true;
                break;
            case Keys.DOWN:
                down = true;
                break;
            case Keys.LEFT:
                left = true;
                break;
            case Keys.RIGHT:
                right = true;
                break;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode){
            case Keys.UP:
                up = false;
                break;
            case Keys.DOWN:
                down = false;
                break;
            case Keys.LEFT:
                left = false;
                break;
            case Keys.RIGHT:
                right = false;
                break;
        }
        return false;
    }

    public void update(float delta){
        if(up){
            player.move(EnumActorFacing.UP);
            return;
        }
        if(down){
            player.move(EnumActorFacing.DOWN);
            return;
        }
        if(right){
            player.move(EnumActorFacing.RIGHT);
            return;
        }
        if(left){
            player.move(EnumActorFacing.LEFT);
            return;
        }
    }
}
