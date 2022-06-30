package diceroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbilityCheckRoll extends DiceRolls {
    Modifiers modifiers = new Modifiers();
    Map<String, String> abilitySkills = new HashMap<>();

    public AbilityCheckRoll() {
        abilitySkills.put("1", "1");
        abilitySkills.put("2", "1");
        abilitySkills.put("3", "1");
        abilitySkills.put("4", "2");
        abilitySkills.put("5", "6");
        abilitySkills.put("6", "6");
        abilitySkills.put("7", "6");
        abilitySkills.put("8", "6");
        abilitySkills.put("9", "6");
        abilitySkills.put("10", "5");
        abilitySkills.put("11", "5");
        abilitySkills.put("12", "5");
        abilitySkills.put("13", "5");
        abilitySkills.put("14", "5");
        abilitySkills.put("15", "3");
        abilitySkills.put("16", "3");
        abilitySkills.put("17", "3");
        abilitySkills.put("18", "3");
    }

    public String makeAbilityCheckRoll(String typeAbilityCheck, Character character, List<String> characterSkills) {
        int randomRoll = getRandomRoll();
        if (characterSkills.contains(typeAbilityCheck)) {
            return (randomRoll + " + " + modifiers.getModifier(character.getAbilityScores(abilitySkills.get(typeAbilityCheck))) + " + " + character.getAbilityScores("7") + " = " + (randomRoll + modifiers.getModifier(character.getAbilityScores(abilitySkills.get(typeAbilityCheck))) + character.getAbilityScores("7")));
        } else {
            return (randomRoll + " + " + modifiers.getModifier(character.getAbilityScores(abilitySkills.get(typeAbilityCheck))) + " = " + (randomRoll + modifiers.getModifier(character.getAbilityScores(abilitySkills.get(typeAbilityCheck)))));
        }
    }

}
