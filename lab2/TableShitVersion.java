import java.util.BitSet;
import java.util.ArrayList;
import java.awt.Point;
import java.util.Scanner;
public class TableShitVersion{

	public ArrayList<Move> moveList = new ArrayList<Move>();
	public ArrayList<Move> playedMoves = new ArrayList<Move>();
	public ArrayList<BitSet> storedBadBoards = new ArrayList<BitSet>();
	public BitSet[][] board;
	public FindMoves moveFinder;
	public int width;
	public int height;

	//for debugging
	public int compteur;

	
	public int Tige = 0;

	public TableShitVersion(BitSet[][] board, int width, int height){
	this.board = board;
	this.width = width;
	this.height = height;
	this.moveFinder = new FindMoves(board);
	startGame();	
	}


	public void startGame(){
	 
	boolean endGame = false;

	
	getBoardStatus();	

	compteur = 0;
	playedMoves.add(moveList.get(0));
	endGame = play(moveList.get(0).doMove());
	System.out.println(endGame);
	System.out.println("nb noeuds = " + compteur);	
	}
	
	public void getBoardStatus(){
	
	moveList.clear();
	
	for(int i=0;i<height;i++){
		for(int j=0;j<width;j++){
			moveFinder.canItMove(i,j,moveList);
						
		}
	}
	}

	public int getTotalTige(){
	
	int totalTige=0;	
	
	for(int i=0;i<height;i++){
		for(int j=0;j<width;j++){
			if(board[i][j].get(5) == true){
				totalTige++;
			}
		}
	}
	return totalTige;
	}

/*

	public boolean play(Point[] move, int i){
		i = i+1;

		printTable();
		flip_tige(move[0]);
		flip_tige(move[1]);
		flip_tige(move[2]);
		boolean completed = false;

		int totalTige = getTotalTige();

		getBoardStatus();
		Move trialMove = playedMoves.get(playedMoves.size()-1);
		
		if(totalTige == 1){
			completed = true;
		}
		if(moveList.size() !=0){
		completed = play(moveList.get(0).doMove(),i);
		}
	printTable();
	return completed;
	}

*/

	public boolean play(Move move){
	

		flip_tige(move.getInitialPos());
		flip_tige(move.getFinalPos());
		flip_tige(move.getRemovedPos());

		
		//printTable();

		boolean completed = false;
		int totalTige = getTotalTige();

		getBoardStatus();
	

		//System.out.println("moveList.size = " + moveList.size());
		compteur++;
		//System.out.println("compteur = "+ compteur);
		

		//boolean bad = compareBoards(convertBoard(board));

		//System.out.println(bad);

		if(playedMoves.size() != 0){	

			Move trialMove = playedMoves.get(playedMoves.size()-1);
			int index = move.getIndex();
			//System.out.println("index = " + index);
			if(totalTige == 1){
				completed = true;
			}
			else if(moveList.size() != 0 && moveList.size() >= index /*&& bad==false*/){
				//S'assure que pour un Xieme passage, on prenne le Xieme move

				//System.out.println("Move index = " +index);
				//System.out.println("moveList size = " + moveList.size());
				moveList.get(index-1).setIndex(index);

				//Met un nouveaux move comme played et joue le move
				playedMoves.add(moveList.get(index-1));	
				completed = play(moveList.get(index-1).doMove());
			}
			else{
				//System.out.println("move UNDONE");
				//storedBadBoards.add(convertBoard(board));
				playedMoves.remove(playedMoves.size()-1);
				completed = play(trialMove.undoMove());
			}
		}else{
			completed = false;
		}
	return completed;
	}


	public boolean compareBoards(BitSet board){

	boolean same = false;

	for(int i=0;i<storedBadBoards.size();i++){
		if(storedBadBoards.get(i).equals(board)){
			same=true;
		}
	}
	return same;
	}


	public BitSet convertBoard(BitSet[][] board){
	
	BitSet convert= new BitSet();


	for(int i=0;i<height;i++){
		for(int j=0;j<width;j++){
			if(board[i][j].get(6)==true){
				convert.set(i*j);
			}
		}
	}
	return convert;
	}


	public void flip_tige(Point point){
		board[(int)point.getX()][(int)point.getY()].flip(5,7);
	}

	public boolean checkForTige(int x, int y){

	boolean tige = false;
	
	if(board[x][y].get(5) == true){
		tige = true;
	}
	return tige;
	}



	public void printTable(){

	for(int i=0;i<height;i++){
		for(int j=0;j<width;j++){
			if(board[i][j].get(5)==true){
				System.out.print("1");
			}
			else if(board[i][j].get(6)==true){
				System.out.print("2");
			}
			else{
				System.out.print("0");
			}
		}
		System.out.println("");
	}
	System.out.println("THERE ARE " + getTotalTige() + " TIGES LEFT");
    	Scanner sc = new Scanner(System.in);
     	System.out.println("ENTER 1 to quit");
	int i = sc.nextInt();

	if(i == 1){
		System.exit(1);
	}
	}	



	public void printMoves(){
	
	System.out.println(playedMoves.size());

	for(int i=0;i<playedMoves.size()-1;i++){
		Point[] points = playedMoves.get(i).getMove();
		int x1 = (int) points[0].getY();
		int y1 = (int)points[0].getX();
		int x2 = (int)points[1].getY();
		int y2 = (int)points[1].getX();
		System.out.println("Tige " + x1+","+y1 + " vers " + x2+","+y2);
	}
	}


}














