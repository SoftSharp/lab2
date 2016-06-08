import java.awt.Point;

public class Move{

	Point initialPos;
	Point finalPos;
	Point removedPos;

	public Move(Point initialPos, Point removedPos, Point finalPos){
	this.initialPos = initialPos;
	this.removedPos = removedPos;
	this.finalPos = finalPos;
	}

	public Move(){
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
