import java.io.*;
import java.util.BitSet;

public class Reader{

	public String fileName;
	public BitSet[][] board= new BitSet[7][7];
	public int width;
	public int height;

	public Reader(String arg){
	fileName = arg;
	populate();
	readFile();
	//PrintOut();
	}

	//met tous les bitset dans le board	
	public void populate(){
	for(int i=0;i<7;i++){
		for(int j = 0;j<7;j++){
			board[i][j] = new BitSet(6);
		}
	}
	}

	public void readFile(){
		try{

		height = 0;	

		FileReader fileReader =
		new FileReader(new File(fileName));

		BufferedReader bufferedReader =
		new BufferedReader(fileReader);

		String line = "";
		
		int j = 0;

		while((line = bufferedReader.readLine()) != null) {
			if(j == 0){
				width = line.length();
			}
			for(int i=0; i<line.length();i++){
				//indique que c'est une tige	
				if(Character.getNumericValue(line.charAt(i)) == 1){
					
					board[j][i].flip(5);
				}
				//indique que la position est vide
				if(Character.getNumericValue(line.charAt(i)) == 2){
					board[j][i].flip(6);
				}
			}
			j++;
			height++;
		}

		bufferedReader.close();

		}
		catch(FileNotFoundException ex) {
			System.out.println("Unable to open file '" +fileName + "'");
		}
		
		catch(IOException ex) {
			System.out.println("Error reading file '"+ fileName + "'");
		}
	System.out.println("height = " +height);

	}

	public BitSet[][] getBoard(){
	return board;
	}

	public int getHeight(){
	return height;
	}
	public int getWidth(){
	return width;
	}

	public void PrintOut(){
	for(int i = 0;i<7;i++){
		for(int j=0;j<7;j++){
			System.out.print(board[i][j].get(1));
		}
		System.out.println("");
	}
	}

} 
