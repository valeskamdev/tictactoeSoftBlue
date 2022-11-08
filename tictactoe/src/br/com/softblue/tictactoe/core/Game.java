package br.com.softblue.tictactoe.core;

import br.com.softblue.tictactoe.Constantes;
import br.com.softblue.tictactoe.ui.UI;

public class Game {

    Board board = new Board();
    Player[] players = new Player[Constantes.SYMBOL_PLAYERS.length];  // definindo o numero de jogadores pela quantidade de simbolos

    public void play() {

        UI.printGameTitle();
        UI.readInput("Nome do jogador:");
    }
}
