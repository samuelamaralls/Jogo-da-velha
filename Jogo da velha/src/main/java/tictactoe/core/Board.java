package tictactoe.core;

import tictactoe.Constants;
import tictactoe.UI.UI;

public class Board {

	private char[][] matriz;

	public Board() {
		matriz = new char[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
		clear();
	}

	// metodo para apagar dados da matriz/tabuleiro
	public void clear() {

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = ' ';
			}
		}

	}

	public void print() {

		UI.printNewLine();

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				// convertendo caractere para String
				UI.printTextWithNoNewLine(String.valueOf(matriz[i][j]));

				if (j < matriz[i].length - 1) {

					UI.printTextWithNoNewLine(" | ");
				}

			}

			UI.printNewLine();

			if (i < matriz.length - 1) {
				UI.printText("---------");
			}

		}

	}

	public boolean isFull() {

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] == ' ') {
					return false;
				}
			}
		}

		return true;

	}

	public boolean play(Player player, Move move) {
		int i = move.getI();
		int j = move.getJ();

		// TODO validar os documentos

		matriz[i][j] = player.getSymbol();

		// TODO Checar se o jogador ganhou
		return false;
	}

	private boolean checkRow(int i, Player player) {
		char symbol = player.getSymbol();
		for (int j = 0; j < Constants.BOARD_SIZE; j++) {
			if (matriz[i][j] != symbol) {
				return false;
			}
		}

		return true;
	}
}
