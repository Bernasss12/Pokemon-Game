package dev.bernasss12.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import dev.bernasss12.PkmnMain;
import dev.bernasss12.Settings;
import dev.bernasss12.controller.PlayerController;
import dev.bernasss12.enums.EnumFacing;
import dev.bernasss12.enums.EnumTileType;
import dev.bernasss12.model.*;
import dev.bernasss12.model.World.World;
import dev.bernasss12.utilities.AnimationSet;

import java.util.WeakHashMap;

public class GameScreen extends AbstractScreen {

    private GameCamera camera;

    private SpriteBatch batch;

    private World world;

    private EntityActor player;

    private Texture brendan;
    private Texture grass;
    private Texture tree;

    private PlayerController controller;


    public GameScreen(PkmnMain app) {
        super(app);

        camera = new GameCamera();

        brendan = new Texture("brendan_standing_south.png");
        grass = new Texture("littleroot_grass.png");
        tree = new Texture("littleroot_tree.png");

        batch = new SpriteBatch();

        TextureAtlas walking = app.getAssetManager().get("textures/actors/players/brendan_walking.atlas", TextureAtlas.class);
        TextureAtlas standing = app.getAssetManager().get("textures/actors/players/brendan_standing.atlas", TextureAtlas.class);

        AnimationSet animations = new AnimationSet(
                new Animation(Settings.TIME_PER_TILE/2f, walking.findRegions("brendan_walking_north"), Animation.PlayMode.LOOP_PINGPONG),
                new Animation(Settings.TIME_PER_TILE/2f, walking.findRegions("brendan_walking_south"), Animation.PlayMode.LOOP_PINGPONG),
                new Animation(Settings.TIME_PER_TILE/2f, walking.findRegions("brendan_walking_east"), Animation.PlayMode.LOOP_PINGPONG),
                new Animation(Settings.TIME_PER_TILE/2f, walking.findRegions("brendan_walking_west"), Animation.PlayMode.LOOP_PINGPONG),
                standing.findRegion("brendan_standing_north"),
                standing.findRegion("brendan_standing_south"),
                standing.findRegion("brendan_standing_east"),
                standing.findRegion("brendan_standing_west")
                );


        world = new  World(20, 20);
        player = new EntityActor(world.getTileMap(),0, 0, animations);
        world.addActor(player);
        world.getTileMap().getTile(1, 1).setType(EnumTileType.SOLID);
        world.getTileMap().getTile(2,2).setType(EnumTileType.LEDGE);
        world.getTileMap().getTile(2, 2).addSide(EnumFacing.UP);
        world.addObject(new EntityObject(world.getTileMap(), 3, 4, 2, 2, 2f, 2.5f));
        world.addObject(new EntityObject(world.getTileMap(), 5, 2, 2, 2, 2f, 2.5f));

        controller = new PlayerController(player);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(controller);
    }

    @Override
    public void render(float delta) {
        controller.update(delta);
        world.update(delta);
        camera.update(player.getDrawX()+0.5f, player.getDrawY()+0.5f);

        batch.begin();

        float worldStartX = Gdx.graphics.getWidth()/2 - camera.getCameraX()*Settings.SCALED_TILE_SIZE;
        float worldStartY = Gdx.graphics.getHeight()/2 - camera.getCameraY()*Settings.SCALED_TILE_SIZE;

        for(int x = 0; x < world.getTileMap().getWidth(); x++){
            for(int y = 0; y < world.getTileMap().getHeight(); y++){
                batch.draw(grass,
                        worldStartX + x * Settings.SCALED_TILE_SIZE,
                        worldStartY + y * Settings.SCALED_TILE_SIZE,
                        Settings.SCALED_TILE_SIZE,
                        Settings.SCALED_TILE_SIZE);
            }
        }

        for(Entity e : world.getEntities()){
            if(e instanceof EntityActor){
                batch.draw(((EntityActor) e).getSprite(),
                        worldStartX + ((EntityActor) e).getDrawX()* Settings.SCALED_TILE_SIZE,
                        worldStartY + ((EntityActor) e).getDrawY()* Settings.SCALED_TILE_SIZE,
                        Settings.SCALED_TILE_SIZE * 1.0f,
                        Settings.SCALED_TILE_SIZE * 1.5f);
            }else{
                batch.draw(tree,
                        worldStartX + e.getX()* Settings.SCALED_TILE_SIZE,
                        worldStartY + e.getY()* Settings.SCALED_TILE_SIZE,
                        Settings.SCALED_TILE_SIZE * e.getDrawWidth(),
                        Settings.SCALED_TILE_SIZE * e.getDrawHeight());
            }
        }

        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

}
