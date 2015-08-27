package uk.ac.aber.users.jov2.langtonant;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

/**
 * This class holds all the cells, the ants, and the logic for the Langont problem
 * 
 * @author Jota
 *
 */
public class Board {
	
	/**
	 * The camera for the graphics
	 */
	private OrthographicCamera camera;
	
	/**
	 * The Size for the board
	 */
	public final int SIZE;
	
	/**
	 * A 2D Array for hold the cells
	 */
	private Cell[][] cells;
	
	/**
	 * How many ants we want on the screen
	 */
	private static final int ANTS = 4;
	
	/**
	 * An array for all the ants
	 */
	private Ant[] ant;
	
	/**
	 * Constructor when initialise the camera, the cells 2d Array ant the ants
	 */
	public Board() {
		// Calculate how many cells can fit in the screen depending on the cell size and the window size
		SIZE = Gdx.graphics.getWidth() / Cell.CELLSIZE;
		
		// Initialise the camera
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		// Initialise the Board and create each cell from them
		cells = new Cell[SIZE][SIZE];
		for(int i = 0; i < cells.length; i++){
			for(int j = 0; j < cells[0].length; j++){
				cells[i][j] = new Cell(i, j, false);
			}
		}
		
		// Initialise the ants ant spawn each ant at random position in the board
		Random rand = new Random();
		ant = new Ant[ANTS];
		for(int i = 0; i < ant.length; i++){
			ant[i] = new Ant(rand.nextInt(SIZE), rand.nextInt(SIZE));
		}
	}
	
	/**
	 * Updated all the logic from the ant and check if is out of bound for change his position
	 * @param delta
	 */
	public void update(float delta){
		// See all the ants we have
		for(int i = 0; i < ant.length; i++){
			// Check the state of the cell from the ant position
			boolean state = cells[ant[i].getPosition().x][ant[i].getPosition().y].isState();
			
			// If the state front the ant cell is true whe turn left, if not we turn rigth
			if(state){
				ant[i].turn(Ant.TURN.LEFT);
			}else{
				ant[i].turn(Ant.TURN.RIGHT);
			}
			
			// We toggle the cell state value
			cells[ant[i].getPosition().x][ant[i].getPosition().y].toggle();
			
			//Move the ant forward one cell
			ant[i].move();
			
			// Check the ant position and if is out of bound change his position to the opposite side
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
	
	/**
	 * Render all the board and the ants
	 * @param sr The ShapeRenderer from the main class
	 */
	public void render(ShapeRenderer sr){
		sr.setProjectionMatrix(camera.combined);
		sr.begin(ShapeType.Filled);
		for(int i = 0; i < cells.length; i++){
			for(int j = 0; j < cells[0].length; j++){
				cells[i][j].render(sr);
			}
		}
		for(int i = 0; i < ant.length; i++) ant[i].render(sr);
		sr.end();
	}

}
