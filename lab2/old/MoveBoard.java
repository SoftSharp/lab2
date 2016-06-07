import java.util.ArrayList;

public class MoveBoard{


/*	cette class va contenir une array list de 2d arrays refletant la sitation du board
	a chaque noeud. La situation etant quel position on le droit de faire un move.
	lorsqu'une tige est bouger, les 4 tiges a 2 de distance de la position original
	de la tige bouger vont maintenant etre up for moves (si elle sont egale a 1)

	ce board doit aussi garder une valeur representant la n ieme position ou nous somme
	rendue. Exemple, si nous avons fait un move, et que ce move nous empeche de faire 
	une autre move, nous devons alors revenir en arriere. Dans ce cas, il faut savoir
	que nous ne devons pas recommencer avec la meme position, mais plutot passer a la 
	prochaine. Cette valeur va etre emagaziner dans la array list avec la array. Puisque
	la position est un array et que le board est un array, la array list va etre une
	array list de array.

	le temps d'execution pourrait etre reduit si on checkai la taille du board avant
	au lieu de tout le temp looper pour 7

*/

	public ArrayList<Board> boardTimeLine = new ArrayList<Board>();
	public Board currentBoard;
	public EvaluateTrous evaluateur;	
	public MoveMaker moveMaker;	

	public MoveBoard(Board board){
	
	this.currentBoard= board;
	evaluateur = new EvaluateTrous(board);
	moveMaker = new MoveMaker();
	findMoves();
	}

	public void findMoves(){

	for(int i = 0;i<7;i++){
		for(int j = 0;j<7;j++){
			Trous current = currentBoard.getTrous(i,j);
			if(current.getValue() ==1){
				evaluateur.evaluateCurrent(current,i,j);
			}
		}
	}

	}


	public void playMove(){

	makeNewBoard();

	current
	

	public void makeNewBoard(){

	boardTimeLine.add(currentBoard);

	Board tempBoard = new Board();
	
	tempBoard.fillBoard();
	
	tempBoard.setAllValues(currentBoard)
	
	currentBoard = tempBoard;
	
	}

	public void PlayTheMove(){

	

}


