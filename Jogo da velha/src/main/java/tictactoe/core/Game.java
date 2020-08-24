package tictactoe.core;

import tictactoe.Constants;
import tictactoe.UI.UI;

public class Game {

	private Board board = new Board();
	private Player[] players = new Player[Constants.SYMBOL_PLAYERS.length];

	public void play() {

		UI.printGameTitle();

	}
}
