package diceroller.roll;

import diceroller.Character;
import diceroller.roll.DiceRolls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbilityCheckRoll extends DiceRolls {
    Map<String, String> abilitySkills = new HashMap<>();

    public AbilityCheckRoll(){
        abilitySkills.put("1", "2");
        abilitySkills.put("2", "2");
        abilitySkills.put("3", "2");
        abilitySkills.put("4", "1");
        abilitySkills.put("5", "4");
        abilitySkills.put("6", "4");
        abilitySkills.put("7", "4");
        abilitySkills.put("8", "4");
        abilitySkills.put("9", "4");
        abilitySkills.put("10", "5");
        abilitySkills.put("11", "5");
        abilitySkills.put("12", "5");
        abilitySkills.put("13", "5");
        abilitySkills.put("14", "5");
        abilitySkills.put("15", "6");
        abilitySkills.put("16", "6");
        abilitySkills.put("17", "6");
        abilitySkills.put("18", "6");
    }

    //Below is what the map looks like with the actual skill names in it.
//        abilitySkills.put("acrobatics", "dexterity");
//        abilitySkills.put("sleight of hand", "dexterity");
//        abilitySkills.put("stealth", "dexterity");
//        abilitySkills.put("athletics", "strength");
//        abilitySkills.put("arcana", "intelligence");
//        abilitySkills.put("history", "intelligence");
//        abilitySkills.put("investigation", "intelligence");
//        abilitySkills.put("nature", "intelligence");
//        abilitySkills.put("religion", "intelligence");
//        abilitySkills.put("animal handling", "wisdom");
//        abilitySkills.put("insight", "wisdom");
//        abilitySkills.put("medicine", "wisdom");
//        abilitySkills.put("perception", "wisdom");
//        abilitySkills.put("survival", "wisdom");
//        abilitySkills.put("deception", "charisma");
//        abilitySkills.put("intimidation", "charisma");
//        abilitySkills.put("performance", "charisma");
//        abilitySkills.put("persuasion", "charisma");

    public Object[] makeAbilityCheckRoll(String typeAbilityCheck, Character character, List<String> characterSkills){
        List<Integer> abilityCheckNums = new ArrayList<>();
        int randomRoll = getRandomRoll();
        int rollTotal;
        abilityCheckNums.add(randomRoll);
        abilityCheckNums.add(getModifier(abilitySkills.get(typeAbilityCheck), character));

        if (characterSkills.contains(typeAbilityCheck)) {
            abilityCheckNums.add(character.getAbilityScores("7"));
            rollTotal = randomRoll + getModifier(abilitySkills.get(typeAbilityCheck), character) + character.getAbilityScores("7");
            abilityCheckNums.add(rollTotal);
            return abilityCheckNums.toArray();
        } else {
            rollTotal = randomRoll + getModifier(abilitySkills.get(typeAbilityCheck), character);
            abilityCheckNums.add(rollTotal);
            return abilityCheckNums.toArray();
        }
    }
}
