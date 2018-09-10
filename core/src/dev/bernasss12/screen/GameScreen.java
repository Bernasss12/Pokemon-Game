package dev.bernasss12.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import dev.bernasss12.PkmnMain;
import dev.bernasss12.Settings;
import dev.bernasss12.controller.PlayerController;
import dev.bernasss12.model.Actor;
import dev.bernasss12.model.GameCamera;
import dev.bernasss12.model.TileMap;
import dev.bernasss12.utilities.AnimationSet;

public class GameScreen extends AbstractScreen {

    private GameCamera camera;

    private TileMap tileMap;

    private Actor actor;

    private SpriteBatch batch;

    private Texture brendan;
    private Texture grass;

    private PlayerController controller;


    public GameScreen(PkmnMain app) {
        super(app);

        camera = new GameCamera();

        tileMap = new TileMap(10, 10);


        brendan = new Texture("brendan_standing_south.png");
        grass = new Texture("littleroot_grass.png");

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

        actor = new Actor(tileMap,0, 0, animations);

        controller = new PlayerController(actor);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(controller);
    }

    @Override
    public void render(float delta) {
        controller.update(delta);
        actor.update(delta);
        camera.update(actor.getDrawX()+0.5f, actor.getDrawY()+0.5f);

        batch.begin();

        float worldStartX = Gdx.graphics.getWidth()/2 - camera.getCameraX()*Settings.SCALED_TILE_SIZE;
        float worldStartY = Gdx.graphics.getHeight()/2 - camera.getCameraY()*Settings.SCALED_TILE_SIZE;

        for(int x = 0; x < tileMap.getWidth(); x++){
            for(int y = 0; y < tileMap.getHeight(); y++){
                batch.draw(grass,
                        worldStartX + x * Settings.SCALED_TILE_SIZE,
                        worldStartY + y * Settings.SCALED_TILE_SIZE,
                        Settings.SCALED_TILE_SIZE,
                        Settings.SCALED_TILE_SIZE);
            }
        }
        batch.draw(actor.getSprite(),
                worldStartX + actor.getDrawX()* Settings.SCALED_TILE_SIZE,
                worldStartY + actor.getDrawY()* Settings.SCALED_TILE_SIZE,
                Settings.SCALED_TILE_SIZE * 1.0f,
                Settings.SCALED_TILE_SIZE * 1.5f);
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
