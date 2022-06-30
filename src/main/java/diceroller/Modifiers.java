package diceroller;

import java.util.HashMap;
import java.util.Map;

public class Modifiers {
    Map<Integer, Integer> scoreModifiers = new HashMap<>();

    public Modifiers(){
        scoreModifiers.put(1, -5);
        scoreModifiers.put(2, -5);
        scoreModifiers.put(3, -4);
        scoreModifiers.put(4, -3);
        scoreModifiers.put(5, -3);
        scoreModifiers.put(6, -2);
        scoreModifiers.put(7, -2);
        scoreModifiers.put(8, -1);
        scoreModifiers.put(9, -1);
        scoreModifiers.put(10, 0);
        scoreModifiers.put(11, 0);
        scoreModifiers.put(12, 1);
        scoreModifiers.put(13, 1);
        scoreModifiers.put(14, 2);
        scoreModifiers.put(15, 2);
        scoreModifiers.put(16, 3);
        scoreModifiers.put(17, 3);
        scoreModifiers.put(18, 4);
        scoreModifiers.put(19, 4);
        scoreModifiers.put(20, 5);
        scoreModifiers.put(21, 5);
        scoreModifiers.put(22, 6);
        scoreModifiers.put(23, 6);
        scoreModifiers.put(24, 7);
        scoreModifiers.put(25, 7);
        scoreModifiers.put(26, 8);
        scoreModifiers.put(27, 8);
        scoreModifiers.put(28, 9);
        scoreModifiers.put(29, 9);
        scoreModifiers.put(30, 10);
    }

    public int getModifier(int score){
        return scoreModifiers.get(score);
    }
}
