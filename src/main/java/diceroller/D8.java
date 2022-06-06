package diceroller;

import java.util.Random;

public class D8 implements Dice{
    public int getRandom(){
        Random generator = new Random();
        return (generator.nextInt(8) + 1);
    }
}
