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
	public void canItMove(int y, int x, ArrayList<Move> moveList){	

		//check haut
		if(check(y,x,0,-1)==true){
			moveList.add(new Move(new Point(y,x),new Point(y,x-1),new Point(y,x-2))); 
		}
		//check bas
		if(check(y,x,0,1)==true){
			moveList.add(new Move(new Point(y,x),new Point(y,x+1),new Point(y,x+2))); 
		}
		//check gauche
		if(check(y,x,-1,0)==true){
			moveList.add(new Move(new Point(y,x),new Point(y-1,x),new Point(y-2,x))); 
		}
		//check droit
		if(check(y,x,1,0)==true){
			moveList.add(new Move(new Point(y,x),new Point(y+1,x),new Point(y+2,x))); 
		}
        }



	//regarde s'il y a une tige a cote (pour "manger" la tige)
	//et si la position a cote est vide (rend le move possible)
	public boolean check(int y, int x, int dy,int dx){

	boolean check = false;
	
	if(isInBounds(y,x,dy,dx)==true){

		if((board[y+dy][x+dx].get(5)==true)  && (board[y+(2*dy)][x+(2*dx)].get(6) == true)){
			check = true;
			//System.out.println("should give true");
		}
		else{
			//System.out.println("not withing rules");
			check = false;
		}
	}
	return check;
	}

	public boolean isInBounds(int y, int x, int dy, int dx){

	boolean check = true;
	
	int[] borders= {x + 2*dx,y + 2*dy};
	
	int i = 0;

	//s'assure que la tige reste dans le board
	while(check == true && i<2){
		if(!(-1<borders[i] && borders[i]<7)){
			//System.out.println("out of bounds");
			check =false;
		}
		i++;
	} 

	//s'assure qu'il y a vraiment une tige
	if(board[y][x].get(5)==false){
		//System.out.println("no tige");
		check=false;
	}
	return check;	

	}


	public String iExist(){
	String s = "what";
	return s;
	}
}










