package br.com.softblue.tictactoe.core;

import br.com.softblue.tictactoe.Constantes;
import br.com.softblue.tictactoe.ui.UI;

public class Game {

    private Board board = new Board();
    private Player[] players = new Player[Constantes.SYMBOL_PLAYERS.length];  // definindo o numero de jogadores pela quantidade de simbolos
    private int currentPlayerIndex = -1; // indice do jogador atual

    public void play() {

        UI.printGameTitle();

        // criando um novo jogador para cada símbolo
        for (int i = 0; i < players.length; i++) {
            players[i] = createPlayer(i);
        }

        boolean gameEnded = false;  // indicar se o jogo terminou ou nao
        Player currentPlayer = nextPlayer();  // retorna proximo jogador
        Player winner = null;  // vencedor

        //  loop que será executado até o jogo terminar
        while(!gameEnded) {
            board.print();
            boolean sequenceFound;

            try {
                sequenceFound = currentPlayer.play();

                if (sequenceFound) {  // verificando se tem uma sequencia de simbolos
                    gameEnded = true;  // encerrará o jogo
                    winner = currentPlayer;  // atribuindo o vencedor ao jogador atual
                } else if (board.isFull()) {  // verificando se o jogo esta cheio
                    gameEnded = true;  // encerrará o jogo
                } else { // movimentos para jogar
                    currentPlayer = nextPlayer(); // passando para o proximo jogador
                }
            } catch (InvalidMoveException e) {
                UI.printText("ERRO: " + e.getMessage());  // imprimindo a mensagem de erro
                continue;  // diz ao programa para pular o resto do código no loop e voltar ao início do laço (while)
            }
        }
       if(winner ==  null) {  // verificando se nao tem vencedores
            UI.printText("EMPATE!");  // se nao tiver, empate
        }else {
            UI.printText("O jogador " + "'" + winner.getName() + "'" + " venceu o jogo!"); // se tiver, mostra vencedor
        }
        board.print();
        UI.printText("FIM DE JOGO!");
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
