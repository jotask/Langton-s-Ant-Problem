package uk.ac.aber.users.jov2.langtonant;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Board {
	
	private OrthographicCamera camera;
	
	public static final int SIZE = 75;
	private Cell[][] cells;
	
	private static final int ANTS = 1;
	private Ant[] ant;
	
	ShapeRenderer sr = new ShapeRenderer();
	
	public Board() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		cells = new Cell[SIZE][SIZE];
		
		for(int i = 0; i < cells.length; i++){
			for(int j = 0; j < cells[0].length; j++){
				cells[i][j] = new Cell(i, j, false);
			}
		}
		Random rand = new Random();
		ant = new Ant[ANTS];
		for(int i = 0; i < ant.length; i++){
			ant[i] = new Ant(rand.nextInt(SIZE), rand.nextInt(SIZE));
		}
	}
	
	public void update(float delta){
		// TODO check if the ant is out of bounds
		for(int i = 0; i < ant.length; i++){
			boolean state = cells[ant[i].getPosition().x][ant[i].getPosition().y].isState();
			if(state){
				ant[i].turn(Ant.TURN.LEFT);
			}else{
				ant[i].turn(Ant.TURN.RIGHT);
			}
			cells[ant[i].getPosition().x][ant[i].getPosition().y].toggle();
			ant[i].move();
			
			Vector2 p = ant[i].getPosition();
			if(p.x < 0){
				p.setX(SIZE - 1);
			}else if(p.x > SIZE - 1){
				p.setX(0);
			}
			if(p.y < 0){
				p.setY(SIZE - 1);
			}else if(p.y > SIZE - 1){
				p.setY(0);
			}
			
		}
	}
	
	public void render(SpriteBatch sb){
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		for(int i = 0; i < cells.length; i++){
			for(int j = 0; j < cells[0].length; j++){
				cells[i][j].render(sb);
			}
		}
		for(int i = 0; i < ant.length; i++) ant[i].render(sb);
		sb.end();
		
		sr.setProjectionMatrix(camera.combined);
		sr.begin(ShapeType.Filled);
		for(int i = 0; i < cells.length; i++){
			for(int j = 0; j < cells[0].length; j++){
				cells[i][j].renderDebug(sr);
			}
		}
		for(int i = 0; i < ant.length; i++) ant[i].debugRender(sr);
		sr.end();
	}

	public void dispose() {
		sr.dispose();
	}

}
