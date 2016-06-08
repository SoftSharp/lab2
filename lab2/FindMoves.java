import java.util.BitSet;
import java.util.ArrayList;

public class FindMoves{

	
	public BitSet[][] board;
	/*devrait etre des constante, sont utiliser pour savoir
	si le bitset represente un trou vide ou une tige
	*/
	public BitSet tige;
	public BitSet empty;

	public FindMoves(BitSet[][] board){
	this.board = board;
	makeBitSetComp();
	}


	//Fabrique les bitset tige et empty
	public void makeBitSetComp(){
	
	tige = new BitSet(2);
	tige.flip(1);

	empty = new BitSet(2);
	empty.flip(1,3);
	}


	//OMG LES 4 PREMIER BIT SERVENT A RIEN FUCKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK
	public Move canItMove(int i, int j){

	Move move = null;

		//check haut
		if(check(i,j,0,-1)==true){
			move = new move(new Point(i,j),new Point(i,j-1),new Point(i,j-2)); 
			check=true;
		}
		//check bas
		if(check(i,j,0,1)==true){
			move = new move(new Point(i,j),new Point(i,j+1),new Point(i,j+2)); 
			check=true;
		}
		//check gauche
		if(check(i,j,-1,0)==true){
			move = new move(new Point(i,j),new Point(i-1,j),new Point(i-2,j)); 
			check=true;
		}
		//check droit
		if(check(i,j,1,0)==true){
			move = new move(new Point(i,j),new Point(i+1,j),new Point(i+2,j)); 
			check=true;
		}
	return move;
        }




	//regarde s'il y a une tige a cote (pour "manger" la tige)
	//et si la position a cote est vide (rend le move possible)
	public boolean check(int x, int y, int dx,int dy){

	boolean check = false;

	if(isInBounds(x,y,dx,dy)==true){
		if(board[x+dx][y+dy].get(5,7).equals(tige)  && board[x+(2*dx)][y+(2*dy)].equals(empty)){
			check = true;
		}
		else{
			check = false;
		}
	}
	return check;
	}

	//s'assure que la tige reste dans le board
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










