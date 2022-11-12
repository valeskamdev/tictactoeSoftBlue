package br.com.softblue.tictactoe.score;

import br.com.softblue.tictactoe.core.Player;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// classe que implementa a interface ScoreManager"
public class FileScoreManager implements ScoreManager {

    // declarando uma constante e criando um objeto Path que representa o arquivo score.txt
    private static final Path SCORE_FILE = Path.of("score.txt");
    private Map<String, Integer> scoreMap = new HashMap<>();  // mapea chave pra um valor

    // lendo o arquivo de pontuação e carregando as pontuações no scoreMap
    public FileScoreManager() throws IOException {
        setup();
    }


    /* se o arquivo de pontuação não existir, crie-o. Em seguida, leia o arquivo linha por
     linha dividindo cada linha em tokens e adicionando os tokens ao mapa de pontuação */
    private void setup() throws IOException {

        if (!Files.exists(SCORE_FILE)) {  // verificando se o arquivo existe
            Files.createFile(SCORE_FILE);  // cria um arquivo no diretório atual, createFile = lanca uma excecao
        }

        // leitura de arquivo linha a linha, chamando reader.close() automaticamente usando try
        try (BufferedReader reader = Files.newBufferedReader(SCORE_FILE)) {
            String line;

            // lendo o arquivo linha por linha e verificando se a linha é nula
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\|");  // dividindo a linha em tokens, usando barra pipe como separador
                scoreMap.put(tokens[0], Integer.parseInt(tokens[1]));  // primeiro token é a chave e o segundo token é o valor
            }
        }
    }

    // sobrescrevendo os métodos da interface

    // recebendo a pontuação do jogador
    @Override
    public Integer getScore(Player player) {
        return scoreMap.get(player.getName().toUpperCase());
    }

    @Override
    public void saveScore(Player player) throws IOException {
        Integer score = getScore(player);

        // se o jogador não tiver pontuação, define a pontuação como 0. Se não, aumenta a pontuação em 1
        if (score == null) {
            score = 0;
        }
        scoreMap.put(player.getName().toUpperCase(), score + 1);

        try (BufferedWriter writer = Files.newBufferedWriter(SCORE_FILE)) {
            Set<Map.Entry<String, Integer>> entries = scoreMap.entrySet();  // recebendo as entradas do mapa

            // iterando sobre as entradas do "scoreMap"
            for (Map.Entry<String, Integer> entry : entries) {

                String name = entry.getKey().toUpperCase();  // obtendo o nome do jogador
                Integer s = entry.getValue();  // obtendo a pontuação da entrada
                writer.write(name + "|" + s);  // escrevendo o nome do jogador e a pontuação no arquivo
                writer.newLine(); // quebra de linha
            }
        }
    }
}
