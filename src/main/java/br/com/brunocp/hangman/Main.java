package br.com.brunocp.hangman;

import br.com.brunocp.hangman.game.Game;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        game.start(args);
    }
}
