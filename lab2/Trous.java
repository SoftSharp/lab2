public class Trous{

	public boolean canMove = false;
	public boolean[] moves = new boolean[4];
	public int moveIndex = 0;
	public int value;


	public Trous(int value){
	this.value=value;
	}

	public void setValue(int value){
	this.value = value;
	}
	
	public int getValue(){
	return value;
	}

	public void setCanMove(boolean canIt){
	this.canMove = canIt;
	}

	public void setMove(int index, boolean canIt){
	this.moves[index] = canIt;
	}

	public boolean getCanMove(){
	return canMove;
	}
}
