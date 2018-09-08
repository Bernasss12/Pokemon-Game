package dev.bernasss12.screen;

import com.badlogic.gdx.Screen;
import dev.bernasss12.PkmnMain;

public abstract class AbstractScreen implements Screen {

    private PkmnMain app;

    public AbstractScreen(PkmnMain app){
        this.app = app;
    }

    @Override
    public abstract void show();

    @Override
    public abstract void render(float delta);

    @Override
    public abstract void resize(int width, int height);

    @Override
    public abstract void pause();

    @Override
    public abstract void resume();

    @Override
    public abstract void hide();

    @Override
    public abstract void dispose();
}
