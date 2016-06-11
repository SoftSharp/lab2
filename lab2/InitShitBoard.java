public class InitShitBoard{


	public static void main(String[]args){

		String[] s = args;
		
		Reader reader = new Reader(s[0]);

		TableShitVersion table = new TableShitVersion(reader.getBoard());
			

	}
}
