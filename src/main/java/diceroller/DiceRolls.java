package diceroller;

import java.util.Random;

public abstract class DiceRolls {
    private Random generator = new Random();

    public int getRandomRoll(){
        return (generator.nextInt(20) + 1);
    }
}
