package diceroller.roll;

import diceroller.Character;
import diceroller.Modifiers;

import java.util.Random;

public abstract class DiceRolls {
    private Random generator = new Random();
    private Modifiers modifiers = new Modifiers();

    public int getRandomRoll(){
        return (generator.nextInt(20) + 1);
    }

    public int getModifier(String ability, Character character){
        return modifiers.getModifier(character.getAbilityScores(ability));
    }
}
