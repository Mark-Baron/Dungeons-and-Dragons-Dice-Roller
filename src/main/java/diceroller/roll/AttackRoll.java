package diceroller.roll;

import diceroller.Character;
import diceroller.roll.DiceRolls;

import java.util.*;

public class AttackRoll extends DiceRolls {

    public Object[] makeAttackRoll(String attackAbility, Character character) {
        List<Integer> attackRollNums = new ArrayList<>();
        int randomRoll = getRandomRoll();
        int rollTotal = randomRoll + getModifier(attackAbility, character) + character.getAbilityScores("7");
        attackRollNums.add(randomRoll);
        attackRollNums.add(getModifier(attackAbility, character));
        attackRollNums.add(character.getAbilityScores("7"));
        attackRollNums.add(rollTotal);
        return attackRollNums.toArray();
    }

    public Object[] makeDamageRoll(String[] dice, String attackAbility, Character character) {
        int diceTotal = 0;
        int diceResult = 0;
        Random generator = new Random();
        List<Integer> diceResults = new ArrayList<>();

        for (int index = 0; index < dice.length; index++) {
            switch (dice[index]) {
                case "4":
                    diceResult = (generator.nextInt(4) + 1);
                    break;
                case "6":
                    diceResult = (generator.nextInt(6) + 1);
                    break;
                case "8":
                    diceResult = (generator.nextInt(8) + 1);
                    break;
                case "10":
                    diceResult = (generator.nextInt(10) + 1);
                    break;
                case "12":
                    diceResult = (generator.nextInt(12) + 1);
                    break;
            }
            diceTotal += diceResult;
            diceResults.add(diceResult);
        }
        diceResults.add(getModifier(attackAbility, character));
        diceTotal += getModifier(attackAbility, character);
        diceResults.add(diceTotal);

        return diceResults.toArray();

    }
}