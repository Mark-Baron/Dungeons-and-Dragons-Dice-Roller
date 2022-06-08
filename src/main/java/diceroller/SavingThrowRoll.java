package diceroller;

import java.util.HashMap;
import java.util.Map;

public class SavingThrowRoll extends DiceRolls {
    Modifiers modifiers = new Modifiers();
    Map<String, Class> classInstance = new HashMap<>();

    public SavingThrowRoll(){
        classInstance.put("1", new Barbarian());
        classInstance.put("7", new Rogue());
        classInstance.put("10", new Wizard());
        classInstance.put("6", new Paladin());
        classInstance.put("3", new Cleric());
        classInstance.put("8", new Sorcerer());
        classInstance.put("4", new Druid());
        classInstance.put("2", new Bard());
        classInstance.put("9", new Warlock());
        classInstance.put("5", new Monk());
    }

    public String makeSavingThrowRoll(String typeSavingThrow, Character character, String classType){
        int randomRoll = getRandomRoll();
        if (classInstance.get(classType).getSavingThrowProf().contains(typeSavingThrow)) {
            return (randomRoll + " + " + modifiers.getModifier(character.getAbilityScores(typeSavingThrow)) + " + " + character.getAbilityScores("proficiency")) + " = " + (randomRoll + modifiers.getModifier(character.getAbilityScores(typeSavingThrow)) + character.getAbilityScores("proficiency"));
        } else {
            return (randomRoll + " + " + modifiers.getModifier(character.getAbilityScores(typeSavingThrow)) + " = " + (randomRoll + modifiers.getModifier(character.getAbilityScores(typeSavingThrow))));
        }
    }
}
