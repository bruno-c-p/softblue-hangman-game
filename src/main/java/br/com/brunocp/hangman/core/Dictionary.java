package br.com.brunocp.hangman.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class Dictionary {

    private static Dictionary instance;

    public static Dictionary getInstance() {

        if (instance == null) {

            try {

                String dictionaryClassName = Config.get("dictionaryClassName");
                Class<?> dictionaryClass = Class.forName(dictionaryClassName);
                Constructor<?> constructor = dictionaryClass.getConstructor();

                instance = (Dictionary) constructor.newInstance();

            } catch (Exception e) {

                throw new RuntimeException(e);
            }

            return instance;
        }

        return instance;
    }

    public abstract Word nextWord();

    public abstract String getName();
}
