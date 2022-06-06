package diceroller;

import java.util.Random;

public class D10 implements Dice{

    public int getRandom(){
        Random generator = new Random();
        return (generator.nextInt(10) + 1);
    }
}
