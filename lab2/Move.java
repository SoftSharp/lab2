import java.awt.Point;

public class Move{

	Point initialPos;
	Point finalPos;
	Point removedPos;
	int moveIndex = 1;

	public Move(Point initialPos, Point removedPos, Point finalPos){
	this.initialPos = initialPos;
	this.removedPos = removedPos;
	this.finalPos = finalPos;
/*
	System.out.println(initialPos.toString());
	System.out.println(removedPos.toString());
	System.out.println(finalPos.toString());
*/	
	}

	public Move(){
	}

	public Move doMove(){
	return this;
	
	}

	public Move undoMove(){
	moveIndex++;
	Point temp = finalPos;
	finalPos = initialPos;
	initialPos = temp;
	
	return this;
	}

	public int getIndex(){
	return moveIndex;
	}
	
	public void setIndex(int index){
	this.moveIndex=index;
	}

	public void setInitialPos(Point initialPos){
	this.initialPos = initialPos;
	}


	public void setFinalPos(Point finalPos){
	this.finalPos = finalPos;
	}

	public void setRemovedPos(Point removedPos){
	this.removedPos = removedPos;
	}

	public Point getInitialPos(){
	return initialPos;
	}

	public Point getFinalPos(){
	return finalPos;
	}
	
	public Point getRemovedPos(){
	return removedPos;
	}
}
