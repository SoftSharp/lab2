public class Board{


	public Trous[][] board = new Trous[7][7];
	public int moveIndex;

	public Board(){
	moveIndex = 0;
	}

	public Board(Trous[][] board){
	this.board = board;
	moveIndex = 0;
	}

	public void setTrous(int x, int y, Trous trous){
		
		board[x][y] = trous;
	}

	public Trous getBitSet(int x, int y){
	return board[x][y];
	}

	public int getValue(int x, int y){
	return board[x][y].getValue();
	}

	public void addIndex(){
	moveIndex++;
	}

	public Trous[][] getBoard(){
	return board;
	}


	public void fillBoard(){
		for(int i = 0 ; i<7;i++){
			for(int j=0;j<7;j++){
				board.setTrous(i,j, new Trous(0));
			}
		}
	}

	//permet de copier un board
	public void setAllValues(Board oldBoard){
	for(int i =0;i<7;i++){
		for(int j=0;j<7;j++){
			board.getBitSet(i,j).setValue(oldBoard.getBitSet(i,j).getValue());	
		}
	}
	}



	public void printValues(){
	
	for(int i = 0;i<7;i++){
		for(int j=0;j<7;j++){
			System.out.print(board[i][j].getValue());
		}
		System.out.println("");
	}
	}
	public void printBool(){
	
	for(int i = 0;i<7;i++){
		for(int j=0;j<7;j++){
			if(board[i][j].getCanMove() == true){
				System.out.print(1);
			}
			else System.out.print(0);
		}
		System.out.println("");
	}
	}

}
