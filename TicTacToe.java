package game;

public class TicTacToe extends Game {
	//Constructs a new TicTacToe object with given  two players and enhance from game class.
	public TicTacToe(String player1, String player2) {
        super(3, 3, new Player(player1, 'X'), new Player(player2, 'O'));
	}
	//the same method in Game but different check(checks if there is line length 3)
	@Override
    protected boolean doesWin(int row, int col) {
        return maxLineContaining(row, col) == 3;
    }

}
