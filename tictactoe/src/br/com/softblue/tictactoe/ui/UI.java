package br.com.softblue.tictactoe.ui;

import java.util.Scanner;

public class UI {

    /* se eu coloco static, não preciso de objeto para chamar o método, pois pertence a classe
    se não colocar static, o método é do objeto, então precisa criar um objeto antes para chamar o método */

    // método que pula linha
    public static void printText(String text) {
        System.out.println(text);
    }

    // método que nao pula linha
    public static void printTextWithNoNewLine(String text) {
        System.out.print(text);
    }

    // método quebra de linha
    public static void printNewLine() {
        System.out.println();
    }

    // titulo do jogo
    public static void printGameTitle() {
        printText("=================");
        printText("| JOGO DA VELHA |");
        printText("=================");
        printNewLine();
    }

    // lendo nome do player
    public static String readInput(String text) {
        printTextWithNoNewLine(text + " ");
        Scanner ler = new Scanner(System.in);
        return ler.nextLine();
    }
}