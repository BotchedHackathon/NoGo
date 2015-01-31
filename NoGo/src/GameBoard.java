
public class GameBoard {
	
	public int m_boardSize;
	public int[][] boardState = new int[m_boardSize + 2][m_boardSize + 2];
	public int blackScore;
	public int whiteScore;
	static final int defaultGameBoardSize = 9;
	
    /**
     * Default constructor.
     * Sets board size to 9x9
     */
	public GameBoard(){
		initializeGameBoard(defaultGameBoardSize);
	}
    
    /**
     * A constructor.
     * A more elaborate description of the constructor.
     * @param boardSize The size of the desired board.
     */
    public GameBoard(int boardSize){
        initializeGameBoard(boardSize);
    }
    
    /**
     * Initialize the board
     * Sets the board size and blacks and white score
     */
	private void initializeGameBoard(int boardSize){
		m_boardSize = boardSize;
		blackScore = 0;
		whiteScore = 0;
		
		// Specify boundary nodes
		
	}
	
	
	
	public boolean checkMove(int x, int y){
		// Check if move is legal
		return true;
	}
	
	public void placeBlack(int x, int y){
		// Place a black stone (set to 1)
		boardState[x][y]=1;
	}
	
	public void placeWhite(int x, int y){
		// Place a white stone (set to 2)
		boardState[x][y]=2;
	}
	
	public void calculateScore(){
		// Update Score
		blackScore = 0;
		whiteScore = 0;
	}
	


}
