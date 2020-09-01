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

		return checkRows(player) || checkCols(player) || checkDiagonal1(player) || checkDiagonal2(player);
	}

	private boolean checkRows(Player player) {

		for (int i = 0; i < Constants.BOARD_SIZE; i++) {
			if (checkRow(i, player)) {
				return true;
			}
		}

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
	
	

	private boolean checkCol(int j, Player player) {

		char symbol = player.getSymbol();
		for (int i = 0; i < Constants.BOARD_SIZE; i++) {
			if (matriz[i][j] != symbol) {
				return false;
			}
		}

		return true;
	}

	private boolean checkCols(Player player) {

		for (int j = 0; j < Constants.BOARD_SIZE; j++) {
			if (checkRow(j, player)) {
				return true;
			}
		}

		return false;
	}

	private boolean checkDiagonal1(Player player) {

		char symbol = player.getSymbol();
		for (int i = 0; i < Constants.BOARD_SIZE; i++) {
			if (matriz[i][i] != symbol) {
				return false;
			}
		}

		return true;
	}

	private boolean checkDiagonal2(Player player) {

		char symbol = player.getSymbol();
		for (int i = 2, j = 0; i >= 0; i--, j++) {
			if (matriz[i][j] != symbol) {
				return false;
			}
		}

		return true;
	}
}
