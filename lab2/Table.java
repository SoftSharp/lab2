import java.util.BitSet;
import java.util.ArrayList;

public class Table{

	public ArrayList<Move> moveList = new ArrayList<Move>();
	public ArrayList<Integer> moveIndexList = new ArrayList<Integer>();
	public BitSet[][] board;
	public static MAXMOVES = 49;
	//IL FAUT COMPTER LA QUANTITE DE TIGE DANS LE READER
	public int Tige = 0;

	public Table(BitSet[][] board){
	this.board = board;
	FindMoves moveFinder = new FindMoves(board);
	
	test(5);
	}


	public void startGame(){
	 
	boolean found = false;
	
	int i = 0;	

	do{
		while(found == false && i<MAXMOVES) {
			found = findMove(i);
			i++;
			tige--;
		}
		if(!moveList.isEmpty()&& i==MAXMOVES-1){
			unPlayMove(moveList.remove(moveList.size()-1));
			tige++;
			i = moveIndexList.remove(moveIndexList.size()-1);
		}
		else{ 
			i = 0;
		}
	}while(!moveList.isEmpty() || tige == 1);
	}
	

	public boolean findMove(int i){

	boolean found=false;	
	
	int x = i%7;
	int y = i/7;	

	if(checkforTige(x,y)){
		if(moveFinder.canItMove(x,y) != null){
			moveList.add(moveFinder.canItMove(x,y));
			playMove(moveFinder.canItMove(x,y));
			found = true;
		}
	}
	return found;
	}

	public void playMove(Move move){

		flip_Tige(move.getInitialPos());
		eaten_Tige(move.getRemovedPos());
		flip_Tige(move.getFinalPos()):
	}

	public void unPlayMove(Move move){
		flip_Tige(move.getInitialPos());
		puked_Tige(move.getRemovedPos());
		flip_Tige(move.getFinalPos()):
	}

	public void flip_tige(Point point){
		board[point.getX()][point.getY()].flip(5,7);
	}

	public void eaten_Tige(Point point){
		board[point.getX()][point.getY()].flip(6);
	}
	
	public void puked_Tige(Point point){
		board[point.getX()][point.getY()].flip(5);
	}

	public boolean checkForTige(int x, int y){

	boolean tige = false;
	
	if(board[x][y].get(5) == true){
		tige = true;
	}
	return tige;
	}



	public void test(int k){
	
	for(int i =0;i<7;i++){
		for(int j=0;j<7;j++){
			System.out.print(board[i][j].get(k));
		}
		System.out.println("");
	}
	}
}





















