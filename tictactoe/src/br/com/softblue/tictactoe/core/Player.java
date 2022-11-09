package br.com.softblue.tictactoe.core;

import br.com.softblue.tictactoe.ui.UI;
public class Player {

    private String name;
    private Board board;
    private char symbol;

    // construtor que recebe tres parametros
    public Player(String name, Board board, char symbol) {
        this.name = name;  // this = faz referencia ao atributo
        this.board = board;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    // alterado para private pq somente a própria classe Player pode acessar
    private Move inputMove() throws InvalidMoveException {
       String moveStr = UI.readInput("Jogador " + name + " -> ");
        return new Move(moveStr);
    }

    public boolean play() throws InvalidMoveException, InvalidNumberException {
       Move move = inputMove();
       return board.play(this, move);  // chamando o método da classe Board e passando o jogador atual e o movimento como parâmetros
    }

}
