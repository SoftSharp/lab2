import java.util.BitSet;
import java.util.ArrayList;
import java.awt.Point;

public class FindMoves{

	
	public BitSet[][] board;
	/*devrait etre des constante, sont utiliser pour savoir
	si le bitset represente un trou vide ou une tige
	*/

	public FindMoves(BitSet[][] board){
	this.board = board;
	}


	//OMG LES 4 PREMIER BIT SERVENT A RIEN FUCKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK
	public void canItMove(int i, int j, ArrayList<Move> moveList){


		//check haut
		if(check(i,j,0,-1)==true){
			moveList.add(new Move(new Point(i,j),new Point(i,j-1),new Point(i,j-2))); 
		}
		//check bas
		if(check(i,j,0,1)==true){
			moveList.add(new Move(new Point(i,j),new Point(i,j+1),new Point(i,j+2))); 
		}
		//check gauche
		if(check(i,j,-1,0)==true){
			moveList.add(new Move(new Point(i,j),new Point(i-1,j),new Point(i-2,j))); 
		}
		//check droit
		if(check(i,j,1,0)==true){
			moveList.add(new Move(new Point(i,j),new Point(i+1,j),new Point(i+2,j))); 
		}
        }




	//regarde s'il y a une tige a cote (pour "manger" la tige)
	//et si la position a cote est vide (rend le move possible)
	public boolean check(int x, int y, int dx,int dy){

	boolean check = false;

	if(isInBounds(x,y,dx,dy)==true){
		if((board[x+dx][y+dy].get(5)==true)  && (board[x+(2*dx)][y+(2*dy)].get(6) == true)){
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


	public String iExist(){
	String s = "what";
	return s;
	}
}










