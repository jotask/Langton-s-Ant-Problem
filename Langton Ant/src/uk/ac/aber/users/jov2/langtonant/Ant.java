package uk.ac.aber.users.jov2.langtonant;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ant {
	
	private int x, y;
	
	private static enum DIRECTION { UP, RIGHT, DOWN, LEFT }
	private DIRECTION currentDir;
	
	public Ant(int x, int y) {
		this.x = x;
		this.y = y;
		
		currentDir = DIRECTION.LEFT;
		
	}
	
	public void update(float delta){
		if(currentDir == DIRECTION.UP){
			y += 1;
		}else if(currentDir == DIRECTION.RIGHT){
			x += 1;
		}else if(currentDir == DIRECTION.DOWN){
			y -= 1;
		}else if(currentDir == DIRECTION.LEFT){
			x -= 1;
		}
	}
	
	public void render(SpriteBatch sb){
		
	}
	
	public void debugRender(ShapeRenderer sr){
		sr.setColor(Color.RED);
		sr.box(x * Cell.CELLSIZE, y * Cell.CELLSIZE, 0, Cell.CELLSIZE, Cell.CELLSIZE, 0);
	}

}
