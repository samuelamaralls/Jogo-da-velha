package tictactoe.core;

import tictactoe.UI.UI;

public class Player {

	private String name;
	private Board board;
	private char symbol;

	public Player(String name, Board board, char symbol) {
		this.name = name;
		this.board = board;
		this.symbol = symbol;
	}

	private Move inputMove() {
		String moveStr = UI.readInput("Jogador " + name + " -> ");
		return new Move(moveStr);
	}
	
	public void play() {
		Move move = inputMove();
		//passando o play como parametro
		board.play(this, move);
	}

	public String getName() {
		return name;
	}

	public Board getBoard() {
		return board;
	}

	public char getSymbol() {
		return symbol;
	}

}
