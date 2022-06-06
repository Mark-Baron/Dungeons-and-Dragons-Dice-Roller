package diceroller;

import java.util.Random;

public class D12 implements Dice{

    public int getRandom(){
        Random generator = new Random();
        return (generator.nextInt(12) + 1);
    }
}
