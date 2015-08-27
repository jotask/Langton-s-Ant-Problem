package uk.ac.aber.users.jov2.langtonant;

public class Vector2 {
	
	public int x;
	public int y;
	
	public Vector2() {
		this(0,0);
	}

	public Vector2(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void set(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}

}
