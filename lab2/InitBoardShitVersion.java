public class InitBoardShitVersion{

	public int width;
	public int height;

	public static void main(String[]args){

		String[] s = args;
		
		long start = System.nanoTime();       

               
		Reader reader = new Reader(s[0]);
 		
		long start2 = System.nanoTime();       

		TableShitVersion table = new TableShitVersion(reader.getBoard(),reader.getWidth(), reader.getHeight());
		
		long end = System.nanoTime();
                double time =(end-start)/(Math.pow(10,9));

		long end2 = System.nanoTime();
                double time2 =(end2-start2)/(Math.pow(10,9));

		System.out.println("temps total = " + time);
		System.out.println("temps sans reader = " + time2);

		table.printMoves();

	}
}
