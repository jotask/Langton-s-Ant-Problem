package uk.ac.aber.users.jov2.langtonant;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ant {
	
	private Vector2 pos;
	
	public static enum TURN { LEFT, RIGHT }
	public static enum DIRECTION {
		UP, RIGHT, DOWN, LEFT;
		
		public DIRECTION next(){
			return values()[(this.ordinal() + 1) % values().length];
		}
		public DIRECTION previous(){
			return values()[(this.ordinal() + values().length - 1) % values().length];
		}
		
	}
	private DIRECTION currentDir;
	
	public Ant(int x, int y) {
		pos = new Vector2(x, y);
		
		currentDir = DIRECTION.LEFT;
		
	}
	
	public void update(float delta){ }
	
	public void turn(TURN turn){
		if(turn == TURN.LEFT){
			currentDir = currentDir.previous();
		}else if(turn == TURN.RIGHT){
			currentDir = currentDir.next();
		}else{
			System.err.println("Something is wrong");
		}
	}
	
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
	
	public void render(SpriteBatch sb){
		
	}
	
	public void debugRender(ShapeRenderer sr){
		sr.setColor(Color.RED);
		sr.box(pos.x * Cell.CELLSIZE, pos.y * Cell.CELLSIZE, 0, Cell.CELLSIZE, Cell.CELLSIZE, 0);
	}
	
	public Vector2 getPosition() { return this.pos; }

}
