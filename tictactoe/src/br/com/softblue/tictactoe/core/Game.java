package br.com.softblue.tictactoe.core;

import br.com.softblue.tictactoe.Constantes;
import br.com.softblue.tictactoe.ui.UI;

public class Game {

    private Board board = new Board();
    private Player[] players = new Player[Constantes.SYMBOL_PLAYERS.length];  // definindo o numero de jogadores pela quantidade de simbolos

    public void play() {

        UI.printGameTitle();
        board.print();
      //  UI.readInput("Nome do jogador:");
    }
}
