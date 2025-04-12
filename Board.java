package game;

public class Board {
	protected Player[][] board;
	protected int n,m;
    private String result;

	//constructor for Borad class
	public Board(int n, int m) {
		this.n = n;
		this.m = m;
	    this.board = new Player[n][m];
	    this.result = "";
	}
	
	//set the board's game
	protected boolean set(int i, int j, Player p) {
		if(isEmpty(i, j)) {
			this.board[i][j] = p;
			return true;
		}
		else {
			return false;
		}
	}
	
	//this method check if an index in the board is empty
	public boolean isEmpty(int i, int j) {
		if(this.board[i][j] == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//getting the player according to the index board
	public Player get(int i, int j) {
		if(this.board[i][j] != null) {
			return this.board[i][j];
		}
		else {
			return null;
		}
	}
	
	//check if the board entirely full 
	public boolean isFull() {
		for(int x = 0; x < this.n; x++) {
	          for(int y = 0; y < this.m; y++) {
	        	  if(this.board[x][y] == null) {
	        		  return false;
	        	  }
	        	 	  
	          }      
	     }
		return true;
	}
	
	public String toString() {
		
		for(int x = 0; x < this.n; x++) {
	          for(int y = 0; y < this.m; y++) {
	        	  if(this.board[x][y] != null) {
	        		  result += this.board[x][y].getMark();
	        	  }
	        	  else {
	        		  result += ".";
	        	  }
	        		  
	          }
              result += "\n";
        
	     }
		return result;

	}
	
	/**
	 * Returns the length of the longest straight line (including diagonals)
	 * that passes through (i, j) and contains only the same player's marks.
	 */
	protected int maxLineContaining(int i, int j) {

	    int max = 1;

	    // 4 base directions to scan (check both forward and backward for each)
	    int[][] directions = {
	        {0, 1},   // Horizontal
	        {1, 0},   // Vertical
	        {1, 1},   // Diagonal
	        {1, -1}   // Anti-diagonal
	    };

	    for (int k = 0; k < directions.length; k++) {
	        int di = directions[k][0];
	        int dj = directions[k][1];

	        int lineLength = 1 + rayLength(i, j, di, dj) + rayLength(i, j, -di, -dj);
	        if (lineLength > max) {
	            max = lineLength;
	        }
	    }

	    return max;
	}

	/**
	 * Returns how many same-player cells are connected in the direction (di, dj),
	 * starting from (i + di, j + dj) until the sequence breaks or out of bounds.
	 */
	private int rayLength(int i, int j, int di, int dj) {
	    int count = 0;
	    Player player = this.board[i][j];

	    int ni = i + di;
	    int nj = j + dj;

	    while (ni >= 0 && ni < this.board.length && nj >= 0 && nj < this.board[0].length
	           && this.board[ni][nj] == player) {
	        count++;
	        ni += di;
	        nj += dj;
	    }

	    return count;
	}

}
