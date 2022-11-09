package br.com.softblue.tictactoe.core;

import br.com.softblue.tictactoe.Constantes;
import br.com.softblue.tictactoe.ui.UI;

public class Board {

    private char[][] matrix = new char[Constantes.BOARD_SIZE][Constantes.BOARD_SIZE];  // definindo o tamanho de linhas e colunas pela constante BOARD_SIZE(3)

    public Board() {
        clear();
    }

    //percorre o array "limpando" os símbolos e inserindo espaços em branco
    public void clear() {

        for (int linha = 0; linha < matrix.length; linha++) {
            for (int coluna = 0; coluna < matrix[linha].length; coluna++) {
                matrix[linha][coluna] = ' ';
            }
        }
    }

    //percorre a matriz imprimindo o símbolo + pipe + linha tracejada
    public void print() {
        UI.printNewLine();
        for (int linha = 0; linha < matrix.length; linha++) {
            for (int coluna = 0; coluna < matrix[linha].length; coluna++) {
                UI.printTextWithNoNewLine(String.valueOf(matrix[linha][coluna]));  // convertendo char para String

                // se for a última coluna (coluna 3), não imprime o pipe
                if (coluna < matrix[linha].length - 1) {
                    UI.printTextWithNoNewLine(" | ");
                }
            }
            //quebra de linha após preenchimento da linha atual
            UI.printNewLine();

            //se for a última linha (linha 3) não imprime a linha tracejada
            if (linha < matrix.length - 1) {
                UI.printText("----------");
            }
        }
    }

    //valida se o tabuleiro está cheio
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

        int linha = move.getLinha();  // obtendo o valor da linha do "move".
        int coluna = move.getColuna();  // obtendo o valor da coluna do "move".

        matrix[linha][coluna] = player.getSymbol();  // colocando um simbolo na posicao desejada do jogador

        //essa anotação abaixo serve como marcação para criar tasks para não esquecer
        //TODO checar se o ganhador ganhou

        return false;
    }
}
