package br.com.softblue.tictactoe.score;

import br.com.softblue.tictactoe.core.Player;

// interface, define assinaturas do objeto, o que faz, SEM IMPLEMENTACÕES
public interface ScoreManager {

    public Integer getScore(Player player);  //usando a classe int(Integer), suportando resposta nula como atribuicao
    public void saveScore(Player player);


}
