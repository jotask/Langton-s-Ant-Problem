package uk.ac.aber.users.jov2.langtonant;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Cell {
	
	private static final int CELLSIZE = 8;
	
	private boolean state;
	private int x, y;
	
	 public Cell(int x, int y, boolean state) {
		this.state = state;
		this.x = x;
		this.y = y;
		
		if(x == 5 && y == 5) this.state = true;
	}

	public boolean isState() { return state; }
	public void setState(boolean state) { this.state = state; }

	public void render(SpriteBatch sb) {
	}
	
	public void renderDebug(ShapeRenderer sr) {
		if(state){
			sr.setColor(Color.CYAN);
		}else{
			sr.setColor(Color.CORAL);
		}
		sr.box(x * CELLSIZE, y * CELLSIZE, 0, CELLSIZE, CELLSIZE, 0);
	}

}
