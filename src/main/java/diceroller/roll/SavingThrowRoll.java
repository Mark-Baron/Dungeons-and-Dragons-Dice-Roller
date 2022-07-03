package diceroller.roll;

import diceroller.Character;
import diceroller.classes.*;
import diceroller.classes.Class;
import diceroller.roll.DiceRolls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SavingThrowRoll extends DiceRolls {
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

    public Object[] makeSavingThrowRoll(String typeSavingThrow, Character character, String classType){
        List<Integer> savingThrowNums = new ArrayList<>();
        int randomRoll = getRandomRoll();
        int rollTotal;
        savingThrowNums.add(randomRoll);
        savingThrowNums.add(getModifier(typeSavingThrow, character));

        if (classInstance.get(classType).getSavingThrowProf().contains(typeSavingThrow)) {
            savingThrowNums.add(character.getAbilityScores("7"));
            rollTotal = randomRoll + getModifier(typeSavingThrow, character) + character.getAbilityScores("7");
            savingThrowNums.add(rollTotal);
            return savingThrowNums.toArray();
        } else {
            rollTotal = randomRoll + getModifier(typeSavingThrow, character);
            savingThrowNums.add(rollTotal);
            return savingThrowNums.toArray();
        }
    }
}
