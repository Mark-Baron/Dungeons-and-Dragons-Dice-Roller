package diceroller;

import java.util.Random;

public class D20 implements Dice {

    public int getRandom() {
        Random generator = new Random();
        return (generator.nextInt(20) + 1);
    }
}
