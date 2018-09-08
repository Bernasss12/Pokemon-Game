package dev.bernasss12.model;

public class GameCamera {
    private float cameraX = 0f;
    private float cameraY = 0f;

    public void update(float dx, float dy){
        cameraX = dx;
        cameraY = dy;
    }

    public float getCameraX() {
        return cameraX;
    }

    public float getCameraY() {
        return cameraY;
    }
}
