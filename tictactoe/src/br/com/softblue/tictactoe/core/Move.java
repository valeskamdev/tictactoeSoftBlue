package br.com.softblue.tictactoe.core;

public class Move {

    private int linha;
    private int coluna;

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public int getColuna() {
        return coluna;
    }
}
