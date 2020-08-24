package tictactoe.core;

public class Move {

	private int i;
	private int j;

	public Move(String moveStr) {
		
		//delimitador de Strings
		// "1,2"
		// [ "1" "2" ]
		String[] token = moveStr.split(",");
		
		//convertendo string para int 
		this.i = Integer.parseInt(token[0]);
		this.j = Integer.parseInt(token[1]);

		//TODO Validar se a estrutura do moveStr esta correta ("0,1")
	}

	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}

}
