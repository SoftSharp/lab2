public class InitBoard{


	public static void main(String[]args){

		String[] s = args;
		
		Reader reader = new Reader(s[0]);

		Table table = new Table(reader.getBoard());
			

	}
}
