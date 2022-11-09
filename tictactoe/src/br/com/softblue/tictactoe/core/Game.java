package br.com.softblue.tictactoe.core;

import br.com.softblue.tictactoe.Constantes;
import br.com.softblue.tictactoe.ui.UI;

public class Game {

    private Board board = new Board();
    private Player[] players = new Player[Constantes.SYMBOL_PLAYERS.length];  // definindo o numero de jogadores pela quantidade de simbolos
    private int currentPlayerIndex = 0; // indice do jogador atual

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

    // método que retorna o próximo jogador
    private Player nextPlayer() {

        currentPlayerIndex++;  // incrementando o índice do player atual(0)

        //quando chega no final da fila, recomeça a fila do 0
        if(currentPlayerIndex >= players.length) {
            currentPlayerIndex = 0;
        }

        return players[currentPlayerIndex];

        /* ---OUTRA OPÇÃO DE ABORDAGEM---
           aqui ele vai pegar o valor atual do indice e dividir pelo tamanho do array
           jogadorAtual = (jogadorAtual +1) % players.length;
           return players[jogadorAtual]; */

    }
}
