package br.com.softblue.tictactoe.core;

import br.com.softblue.tictactoe.Constantes;
import br.com.softblue.tictactoe.ui.UI;

public class Game {

    private Board board = new Board();
    private Player[] players = new Player[Constantes.SYMBOL_PLAYERS.length];  // definindo o numero de jogadores pela quantidade de simbolos

    public void play() {

        UI.printGameTitle();

        // criando um novo jogador para cada símbolo
        for (int i = 0; i < players.length; i++) {
            players[i] = createPlayer(i);
        }
    }

    // criando jogador
    private Player createPlayer(int index) {

        String name = UI.readInput("Jogador " + (index + 1) + " ->");
        char symbol = Constantes.SYMBOL_PLAYERS[index];
        Player player = new Player(name, board, symbol );  // criando um novo jogador com o nome, tabuleiro e símbolo
        UI.printText("O jogador " + "'" + name + "'" + " vai usar o símbolo " + "'" + symbol + "'");
        return player;

    }
}
