package uk.ac.aber.users.jov2.langtonant;

import java.util.Random;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * This class is for the logic for the ant can do and how is rendered
 * 
 * @author Jota
 *
 */
public class Ant {
	
	/**
	 * The ant position
	 */
	private Vector2 pos;
	
	/**
	 * The two possible turns the ant can do
	 * @author Jota
	 *
	 */
	public static enum TURN { LEFT, RIGHT }
	
	/**
	 * The direction the ant can be looking
	 * @author Jota
	 *
	 */
	public static enum DIRECTION {
		UP, RIGHT, DOWN, LEFT;
		
		// Get the next direction clockwise
		public DIRECTION next(){
			return values()[(this.ordinal() + 1) % values().length];
		}
		// Get previous direction anticlockwise
		public DIRECTION previous(){
			return values()[(this.ordinal() + values().length - 1) % values().length];
		}
		
	}
	
	/**
	 * The current ant direction is looking
	 */
	private DIRECTION currentDir;
	
	/**
	 * The constructor for initialise the ant on the board, with a random initial direction
	 * This call the main constructor for this class but with a random initial direction
	 * @param x the ant X initial position
	 * @param y the ant Y initial position
	 */
	public Ant(int x, int y) {
		this(x, y, DIRECTION.values()[new Random().nextInt(DIRECTION.values().length)]);
	}
	
	/**
	 * The constructor for initialise the ant on the board and his direction
	 * @param x the ant X initial position
	 * @param y the ant Y initial position
	 * @param dir the default direction for this Ant
	 */
	public Ant(int x, int y, DIRECTION dir){
		pos = new Vector2(x, y);
		currentDir = dir;
	}
	
	/**
	 * Method for turn the ant in one of the two possible direction
	 * @param turn
	 */
	public void turn(TURN turn){
		if(turn == TURN.LEFT){
			currentDir = currentDir.previous();
		}else if(turn == TURN.RIGHT){
			currentDir = currentDir.next();
		}else{
			System.err.println("Something is wrong");
		}
	}
	
	/**
	 * Move the ant forward depending in which direction is looking
	 */
	public void move(){
		if(currentDir == DIRECTION.UP){
			pos.y += 1;
		}else if(currentDir == DIRECTION.RIGHT){
			pos.x += 1;
		}else if(currentDir == DIRECTION.DOWN){
			pos.y -= 1;
		}else if(currentDir == DIRECTION.LEFT){
			pos.x -= 1;
		}else{
			System.err.println("Something is wrong");
		}
	}
	
	/**
	 * Render the ant on the board
	 * @param sr the ShapeRenderer
	 */
	public void render(ShapeRenderer sr){
		sr.setColor(Color.RED);
		sr.box(pos.x * Cell.CELLSIZE, pos.y * Cell.CELLSIZE, 0, Cell.CELLSIZE, Cell.CELLSIZE, 0);
	}
	
	/**
	 * Know the ant position
	 * @return the ant position
	 */
	public Vector2 getPosition() { return this.pos; }
	
	/**
	 * Get the ant direction
	 * @return the ant direction
	 */
	public DIRECTION getDir(){ return currentDir; }

}