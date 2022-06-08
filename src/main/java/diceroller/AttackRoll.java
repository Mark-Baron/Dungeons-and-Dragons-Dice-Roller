package diceroller;

import java.util.*;

public class AttackRoll extends DiceRolls {
    Modifiers modifiers = new Modifiers();

    public String makeAttackRoll(String attackAbility, Character character) {
        int randomRoll = getRandomRoll();
        if (attackAbility.equals("strength")) {
            return (randomRoll + " + " + modifiers.getModifier(character.getAbilityScores(attackAbility.toLowerCase())) + " + " + character.getAbilityScores("proficiency") + " = " + (randomRoll + modifiers.getModifier(character.getAbilityScores(attackAbility.toLowerCase())) + character.getAbilityScores("proficiency")));
        } else {
            return (randomRoll + " + " + modifiers.getModifier(character.getAbilityScores(attackAbility.toLowerCase())) + " + " + character.getAbilityScores("proficiency") + " = " + (randomRoll + modifiers.getModifier(character.getAbilityScores(attackAbility.toLowerCase())) + character.getAbilityScores("proficiency")));
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
