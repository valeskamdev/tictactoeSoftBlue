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
    public boolean play(Player player, Move move) throws  InvalidMoveException{

            int linha = move.getLinha();  // obtendo o valor da linha do "move"
            int coluna = move.getColuna();  // obtendo o valor da coluna do "move"

            if (linha < 0 || coluna < 0 || linha >= Constantes.BOARD_SIZE || coluna >= Constantes.BOARD_SIZE) {
                throw new InvalidMoveException("Posição inválida"); // lançando uma exceção se a posicao for inválida
            }

            if (matrix[linha][coluna] != ' ') {
                throw new InvalidMoveException("Esta jogada ja foi realizada");  // lançando uma exceção se a jogada ja foi realizada
            }

            matrix[linha][coluna] = player.getSymbol();  // colocando um simbolo na posicao desejada do jogador

            //essa anotação abaixo serve como marcação para criar tasks para não esquecer
            //TODO checar se o ganhador ganhou
            //task finalizada, mas vou deixar aqui para fins de estudos posteriores

            // verificar se o jogador ganhou em alguma linha, coluna ou diagonal
            return checkRows(player) || checkCols(player) || checkDiagonal1(player) || checkDiagonal2(player);

    }

    // verificando se todos os símbolos na linha sao iguais ao símbolo do jogador
    private boolean checkRow(int linha, Player player) {
        char symbol = player.getSymbol();  // obtendo o símbolo do jogador

        for (int coluna = 0; coluna < Constantes.BOARD_SIZE; coluna++) {

            // verificando se cada símbolo na linha é diferente do símbolo do jogador
           if(matrix[linha][coluna] != symbol) {
               return false;
           }
       }
        return true;
    }

    // verificando se o jogador ganhou em alguma linha
    private boolean checkRows(Player player) {

        for(int linha = 0; linha < Constantes.BOARD_SIZE; linha++) {
            if (checkRow(linha, player)) {
                return true;
            }
        }
        return false;
    }

    // verificando se todos os símbolos na coluna sao iguais ao símbolo do jogador
    private boolean checkCol(int coluna, Player player) {
        char symbol = player.getSymbol();  // obtendo o símbolo do jogador

        for (int linha = 0; linha < Constantes.BOARD_SIZE; linha++) {

            // verificando se cada símbolo na coluna é diferente do símbolo do jogador
            if(matrix[linha][coluna] != symbol) {
                return false;
            }
        }
        return true;
    }

    // verificando se o jogador ganhou em alguma coluna
    private boolean checkCols(Player player) {

        for(int coluna = 0; coluna < Constantes.BOARD_SIZE; coluna++) {
            if(checkRow(coluna, player)) {
                return true;
            }
        }
        return false;
    }

    // verificando se o jogador ganhou na primeira diagonal
    private boolean checkDiagonal1(Player player) {
        char symbol = player.getSymbol();  // obtendo o símbolo do jogador

        for (int i = 0; i < Constantes.BOARD_SIZE; i++) {
            if(matrix[i][i] != symbol) {
                return false;
            }
        }
        return true;
    }

    // verificando se o jogador ganhou na segunda diagonal
    private boolean checkDiagonal2(Player player) {
        char symbol = player.getSymbol(); // obtendo o símbolo do jogador
        int lastLine = Constantes.BOARD_SIZE - 1;

        //loop for que começa na última linha e na primeira coluna e vai até a primeira linha e a última coluna
        for(int linha = lastLine, coluna = 0; linha >= 0; linha--, coluna++) {
            if(matrix[linha][coluna] != symbol) {
                return false;
            }
        }
        return true;
    }
}
