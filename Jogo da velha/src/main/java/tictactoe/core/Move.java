package tictactoe.core;

import tictactoe.InvalidMoveException;

public class Move {

	private int i;
	private int j;

	public Move(String moveStr) throws InvalidMoveException {

		try {
			// split == delimitador de Strings
			// "1,2"
			// [ "1" "2" ]
			String[] token = moveStr.split(",");

			// convertendo string para int
			this.i = Integer.parseInt(token[0]);
			this.j = Integer.parseInt(token[1]);
			
		} catch (Exception e) {
			throw new InvalidMoveException("A jogada é inválida");			
		}
	}

	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}

}
