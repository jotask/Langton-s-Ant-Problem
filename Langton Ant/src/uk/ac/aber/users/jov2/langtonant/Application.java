package uk.ac.aber.users.jov2.langtonant;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Application implements ApplicationListener {

	private SpriteBatch batch;
	private Board board;
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		board = new Board();
	}
	@Override
	public void pause() {}

	@Override
	public void render() {
//		if(Gdx.input.isKeyJustPressed(Keys.SPACE))
			board.update(Gdx.graphics.getDeltaTime());
		board.render(batch);
	}

	@Override
	public void resize(int width, int height) {}

	@Override
	public void resume() {}

	@Override
	public void dispose() {
		batch.dispose();
		board.dispose();
	}

	
	public static void main(String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = "Langton's Ant Problem";
		config.width = 600;
		config.height = 600;
		config.fullscreen = false;
		config.resizable = false;
		
		new LwjglApplication(new Application(), config);
	}

}
