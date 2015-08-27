package uk.ac.aber.users.jov2.langtonant;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Board {
	
	private OrthographicCamera camera;
	
	private static final int SIZE = 75;
	private Cell[][] cells;
	
	private Ant ant;
	
	ShapeRenderer sr = new ShapeRenderer();
	
	public Board() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		cells = new Cell[SIZE][SIZE];
		
		Random ran = new Random();
		
		for(int i = 0; i < cells.length; i++){
			for(int j = 0; j < cells[0].length; j++){
				cells[i][j] = new Cell(i, j, ran.nextBoolean());
			}
		}
		ant = new Ant(SIZE / 2, SIZE / 2);
	}
	
	public void update(float delta){
		ant.turn(Ant.TURN.LEFT);
		ant.move();
	}
	
	public void render(SpriteBatch sb){
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		for(int i = 0; i < cells.length; i++){
			for(int j = 0; j < cells[0].length; j++){
				cells[i][j].render(sb);
			}
		}
		ant.render(sb);
		sb.end();
		
		sr.setProjectionMatrix(camera.combined);
		sr.begin(ShapeType.Filled);
		for(int i = 0; i < cells.length; i++){
			for(int j = 0; j < cells[0].length; j++){
				cells[i][j].renderDebug(sr);
			}
		}
		ant.debugRender(sr);
		sr.end();
	}

	public void dispose() {
		sr.dispose();
	}

}
