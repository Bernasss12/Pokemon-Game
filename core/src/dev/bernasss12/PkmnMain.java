package dev.bernasss12;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import dev.bernasss12.screen.GameScreen;

public class PkmnMain extends Game {

	private GameScreen gameScreen;

	private AssetManager assetManager;

	@Override
	public void create () {
        assetManager = new AssetManager();
        assetManager.load("textures/actors/players/brendan_walking.atlas", TextureAtlas.class);
        assetManager.load("textures/actors/players/brendan_standing.atlas", TextureAtlas.class);
        assetManager.finishLoading();
        gameScreen = new GameScreen(this);
        this.setScreen(gameScreen);
	}

	@Override
	public void render () {
        Gdx.gl20.glClearColor(0.3f, 0.3f, 0.3f, 1f);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    super.render();
	}
	
	@Override
	public void dispose () {

	}

	public AssetManager getAssetManager(){
	    return assetManager;
    }
}
