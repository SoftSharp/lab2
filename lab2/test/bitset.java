import java.util.BitSet;

public class bitset{

	public static void main(String []args){

	BitSet bitset = new BitSet(4);
	bitset.flip(4);
	System.out.println(bitset.get(4));
	
	}		
}
