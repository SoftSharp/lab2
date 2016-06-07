import java.awt.point

public class Player{

	public Board board;
	public BitSet tige;
	public BitSet empty;

	public Player(Board board){
	this.board=board;
	makeBitSetComp();
	}
	

	public void makeBitSetComp(){

        tige = new BitSet(2);
        tige.flip(1);

        empty = new BitSet(2);
        empty.flip(1,3);
        }


	public Move MakeMove(){

	Move move = findMove();
	executeMove(move);

	return move;
	}

	public void undoMove(Move move){
	
	}

	public void executeMove();
	
	}


	public Move findMove(){
	
	Point initialPos = new Point();
	Point[] foundPos = new Points[2];

	for(int i=0;i<7;i++){
		for(int j=0;j<7;j++){
			for(int k=1;k<7;k++){
				if(board[i][j].get(k) == true){
					initialPos.setLocation(i,j);
					foundPos = findPositions(i,j,k);
					Move move = new Move(initialPos,foundPos[0],foundPos[1]);
				}
			}
		}
	}
	return move;
	}



	public Point[] findPositions(int i, int j, int k){
	
	Point[] points = new Point[2];
	//haut
	if(k==1){
		points[0] = new Point(i,j-1);
		points[1] = new Point(i,j-2);
	}
	//bas
	if(k==2){
		points[0] = new Point(i,j+1);
		points[1] = new Point(i,j+2);

	}
	//gauche
	if(k==3){
		points[0] = new Point(i-1,j);
		points[1] = new Point(i-2,j);
	
	}
	//droite
	if(k==4){
		points[0] = new Point(i,j);
		points[1] = new Point(i,j);

	}
	return points;
	}






















