package diceroller;

import java.util.*;

public class AttackRoll extends DiceRolls {
    Modifiers modifiers = new Modifiers();

    public String makeAttackRoll(String attackAbility, Character character) {
        int randomRoll = getRandomRoll();
        //2 is a strength attack, 1 is a dexterity attack
        if (attackAbility.equals("2")) {
            return (randomRoll + " + " + modifiers.getModifier(character.getAbilityScores(attackAbility)) + " + " + character.getAbilityScores("7") + " = " + (randomRoll + modifiers.getModifier(character.getAbilityScores(attackAbility)) + character.getAbilityScores("7")));
        } else {
            return (randomRoll + " + " + modifiers.getModifier(character.getAbilityScores(attackAbility)) + " + " + character.getAbilityScores("7") + " = " + (randomRoll + modifiers.getModifier(character.getAbilityScores(attackAbility)) + character.getAbilityScores("7")));
        }
    }

    public void makeDamageRoll(String[] dice) {
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
            if (index == dice.length - 1) {
                System.out.printf("%d", diceResult);
            } else {
                System.out.printf("%d + ", diceResult);
            }
        }
        System.out.printf(" = %d\n", diceTotal);
    }


}
