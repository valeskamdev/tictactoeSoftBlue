package br.com.softblue.tictactoe.core;

public class Move {

    private int linha;
    private int coluna;

    /* um construtor que recebe uma string e a divide em dois tokens.
     o primeiro token é a linha e o segundo é a coluna*/
    public Move(String moveStr) {
        String[] tokens = moveStr.split(",");

        this.linha = Integer.parseInt(tokens[0]);  // convertendo String para int
        this.coluna = Integer.parseInt(tokens[1]);

        // TODO validar se a estrutura do moveStr esta correta
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }
}
