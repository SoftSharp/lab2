import java.awt.Point;

public class Move{

	Point initialPos;
	Point finalPos;
	Point removedPos;
	int moveIndex = 0;

	public Move(Point initialPos, Point removedPos, Point finalPos){
	this.initialPos = initialPos;
	this.removedPos = removedPos;
	this.finalPos = finalPos;
	}

	public Move(){
	}

	public Point[] doMove(){
	return (new Point[] {initialPos,finalPos,removedPos});
	
	}

	public Point[] undoMove(){
	moveIndex++;
	return (new Point[]{finalPos, initialPos, removedPos});
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
