import java.util.BitSet;

public class bitset{

	public static void main(String []args){

	BitSet bitset = new BitSet(2);
	bitset.flip(1);
	bitset.flip(2);
	bitset.flip(0);
	bitset.flip(4);
	System.out.println(bitset.toString());	
	}		
}
