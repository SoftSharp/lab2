import java.util.BitSet;

public class FindMoves{

	public BitSet[][] board;
	public BitSet tige;
	public BitSet empty;

	public FindMoves(BitSet[][] board){
	this.board = board;
	makeBitSetComp();
	canItMove();
	}


	public void makeBitSetComp(){
	
	tige = new BitSet(2);
	tige.flip(1);

	empty = new BitSet(2);
	empty.flip(1,3);
	}

	public void canItMove(){
	for(int i=0;i<7;i++){
		for(int j=0;j<7;j++){
			//check haut
			if(check(i,j,0,-1)==true){
				board[i][j].flip(1);	
			}
			//check bas
			if(check(i,j,0,1)==true){
				board[i][j].flip(2);	
			}
			//check gauche
			if(check(i,j,-1,0)==true){
				board[i][j].flip(3);	
			}
			//check droit
			if(check(i,j,1,0)==true){
				board[i][j].flip(4);	
			}
		}
	}
	
        }


	public boolean check(int x, int y, int dx,int dy){

	boolean check = false;

	if(isInBounds(x,y,dx,dy)==true){
		if(board[x+dx][y+dy].get(5,7).intersects(tige)  && board[x+(2*dx)][y+(2*dy)].intersects(empty)){
			check = true;
		}
		else{
			check = false;
		}
	}
	return check;
	}

	public boolean isInBounds(int x, int y, int dx, int dy){

	boolean check = true;
	
	int[] borders= {x + 2*dx,y + 2*dy};
	
	int i = 0;

	while(check == true && i<2){
		if(!(-1<borders[i] && borders[i]<7)){
			
			check =false;
		}
		i++;
	} 
	return check;	

	}


}










