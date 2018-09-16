package dev.bernasss12.model.World;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class WorldRenderer {

    private World world;
    private AssetManager manager;

    private Texture grass;
    private Texture tree;

    public WorldRenderer(World world, AssetManager manager) {
        this.world = world;
        this.manager = manager;

    }
}
