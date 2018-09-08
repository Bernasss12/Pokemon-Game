package dev.bernasss12.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import dev.bernasss12.PkmnMain;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "Pokémon: Ruby";
		config.height = 480;
		config.width = 720;
		config.resizable = false;
		config.vSyncEnabled = true;

		new LwjglApplication(new PkmnMain(), config);
	}
}
