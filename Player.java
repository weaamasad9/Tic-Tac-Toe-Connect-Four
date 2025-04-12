package game;

public class Player {
	private String name;
	private char mark;
	
	//constructor for player class
	public Player(String name, char mark) {
		this.mark = mark;
		this.name = name;
	}
    
	// return the name of the player
	public String getName() {
		return this.name;
	}
	
	// return the mark of the player
	public char getMark() {
		return this.mark;
	}
	
	// return the string that decribe player info
	public String toString() {
		return name + "(" + mark + ")";
	}
}
