package br.com.brunocp.hangman.core;

import br.com.brunocp.hangman.game.exception.GameException;
import br.com.brunocp.hangman.utils.RandomUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dictionary {

    private static final String FILE_NAME = "dicionario.txt";
    private List<String> words = new ArrayList<>();
    private static Dictionary instance;

    private Dictionary() {
        load();
    }

    public static Dictionary getInstance() {

        if (instance == null) {

            instance = new Dictionary();
        }

        return instance;
    }

    private void load() {

        try (Scanner scanner = new Scanner(getClass().getResourceAsStream("/" + FILE_NAME))) {

            while (scanner.hasNextLine()) {

                String word = scanner.nextLine().trim();

                words.add(word);
            }

            if (words.size() == 0) {
                throw new GameException("A lista de palavras não pode ser vazia");
            }
        };
    }

    public Word nextWord() {

        int pos = RandomUtils.newRandomNumber(0, words.size());

        return new Word(words.get(pos));
    }
}
