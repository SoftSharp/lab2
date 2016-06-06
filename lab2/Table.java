import java.util.BitSet;
import java.util.ArrayList;

public class Table{

	public ArrayList<Action> action = new ArrayList<Action>();
	public BitSet[][] board;

	public Table(BitSet[][] board){
	this.board = board;
	FindMoves finder = new FindMoves(board);

	test(5);
	}

	public void test(int k){
	
	for(int i =0;i<7;i++){
		for(int j=0;j<7;j++){
			System.out.print(board[i][j].get(k));
		}
		System.out.println("");
	}
	}
}
