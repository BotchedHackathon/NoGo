
public class GameBoard {
	
	public int m_boardSize;
	public int[][] boardState = new int[m_boardSize][m_boardSize];
	public int blackScore;
	public int whiteScore;
	static final int defaultGameBoardSize = 9;
	
	// Constructors
	public GameBoard(int boardSize){
		initializeGameBoard(boardSize);
	}
	
	public GameBoard(){
		initializeGameBoard(defaultGameBoardSize);
	}
	
	private void initializeGameBoard(int boardSize){
		m_boardSize = boardSize;
		blackScore = 0;
		whiteScore = 0;
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
	
	
	


}
