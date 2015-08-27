package uk.ac.aber.users.jov2.langtonant;

public class Cell {
	
	private boolean state;
	
	 public Cell(boolean state) {
		this.state = state;
	}

	public boolean isState() { return state; }
	public void setState(boolean state) { this.state = state; }

}
