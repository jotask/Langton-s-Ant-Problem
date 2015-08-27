package uk.ac.aber.users.jov2.langtonant;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Application implements ApplicationListener {

	private SpriteBatch batch;
	
	@Override
	public void create() {}

	@Override
	public void dispose() {}

	@Override
	public void pause() {}

	@Override
	public void render() {}

	@Override
	public void resize(int arg0, int arg1) {}

	@Override
	public void resume() {}
	
	public static void main(String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.width = 800;
		config.height = 600;
		config.fullscreen = false;
		
		new LwjglApplication(new Application(), config);
	}

}
