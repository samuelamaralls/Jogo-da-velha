package tictactoe.core;

import tictactoe.Constants;
import tictactoe.UI.UI;

public class Game {

	private Board board = new Board();
	private Player[] players = new Player[Constants.SYMBOL_PLAYERS.length];
	int currentPlayerIndex = -1;

	public void play() {

		UI.printGameTitle();

		for (int i = 0; i < players.length; i++) {
			players[i] = createPlayer(i);
		}

		boolean gameEnded = false;
		Player currentPlayer = nextPlayer();
		Player winner = null;

		while (!gameEnded) {
			board.print();

			boolean sequenceFound = currentPlayer.play();

			if (sequenceFound) {
				gameEnded = true;
				winner = currentPlayer;
			} else if (board.isFull()) {
				gameEnded = true;
			} else {
				currentPlayer = nextPlayer();
			}
		}

		if (winner == null) {
			UI.printText("O jogo terminou empatado!");
		} else {
			UI.printText("O jogador '" + winner.getName() + "' venceu o jogo!");
		}

		board.print();
		UI.printText("The end!");
	}

	private Player createPlayer(int index) {
		String name = UI.readInput("Jogador " + (index + 1) + "=>");
		char symbol = Constants.SYMBOL_PLAYERS[index];
		Player player = new Player(name, board, symbol);

		UI.printText("O jogador " + name + " vai usar o simbolo '" + symbol + "'");

		return player;
	}

	private Player nextPlayer() {

		currentPlayerIndex++;

		if (currentPlayerIndex >= players.length) {
			currentPlayerIndex = 0;
		}
		return players[currentPlayerIndex];
	}
}
