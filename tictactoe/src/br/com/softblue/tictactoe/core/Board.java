package br.com.softblue.tictactoe.core;

import br.com.softblue.tictactoe.Constantes;
import br.com.softblue.tictactoe.ui.UI;

public class Board {

    char[][] matrix = new char[Constantes.BOARD_SIZE][Constantes.BOARD_SIZE];  // definindo o tamanho de linhas e colunas pela constante BOARD_SIZE(3)

    public Board() {
        clear();
    }

    // percorre a matriz e limpa/remove a cada elemento
    public void clear() {

        for (int linha = 0; linha < matrix.length; linha++) {
            for (int coluna = 0; coluna < matrix[linha].length; coluna++) {
                matrix[linha][coluna] = ' ';
            }
        }
    }

    // imprime a matriz, com uma barra vertical (|) entre as colunas e uma linha horizontal entre as linhas
    public void print() {
        UI.printNewLine();
        for (int linha = 0; linha < matrix.length; linha++) {
            for (int coluna = 0; coluna < matrix[linha].length; coluna++) {
                UI.printTextWithNoNewLine(String.valueOf(matrix[linha][coluna]));  // convertendo char para String

                //  imprimindo um pipe(barra vertical) para separar os simbolos
                if (coluna < matrix[linha].length - 1) {
                    UI.printTextWithNoNewLine(" | ");
                }
            }
            UI.printNewLine();

            // imprimindo duas linhas para separar os pipe's
            if (linha < matrix.length - 1) {
                UI.printText("----------");
            }
        }
    }

    // retorna true se a matriz estiver cheia e alse se não estiver
    public boolean isFull() {

        for (int linha = 0; linha < matrix.length; linha++) {
            for (int coluna = 0; coluna < matrix[linha].length; coluna++) {
                if (matrix[linha][coluna] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    /*
    recebe um jogador e uma jogada, e então coloca o símbolo do
    jogador na matriz, na posição especificada pela jogada
    Parâmetros:
    jogador - o jogador que está jogando o movimento
    movimento – o movimento que o jogador quer fazer */
    public boolean play(Player player, Move move) {

        int linha = move.linha;  // obtendo o valor da linha do "move".
        int coluna = move.coluna;  // obtendo o valor da coluna do "move".

        matrix[linha][coluna] = player.symbol;  // colocando um simbolo na posicao desejada do jogador

        //TODO checar se o ganhador ganhou
        return false;
    }
}
