package br.com.softblue.tictactoe.core;

// classe de excecao
public class InvalidMoveException extends Exception {  // herdando objetos da classe Exception

    public InvalidMoveException(String message) {
        super(message);
    }

}
