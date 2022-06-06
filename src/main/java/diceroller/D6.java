package diceroller;

import java.util.Random;

public class D6 implements Dice{
    public int getRandom() {
        Random generator = new Random();
        return (generator.nextInt(6) + 1);
    }
}
