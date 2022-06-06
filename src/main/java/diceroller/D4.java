package diceroller;

import java.util.Random;

public class D4 implements Dice{

    public int getRandom() {
        Random generator = new Random();
        return (generator.nextInt(4) + 1);
    }
}
