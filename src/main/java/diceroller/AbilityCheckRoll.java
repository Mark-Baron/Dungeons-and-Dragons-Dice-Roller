package diceroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbilityCheckRoll extends DiceRolls{
    Modifiers modifiers = new Modifiers();
    Map<String, String> abilitySkills = new HashMap<>();

    public AbilityCheckRoll(){
        abilitySkills.put("acrobatics", "dexterity");
        abilitySkills.put("sleight of hand", "dexterity");
        abilitySkills.put("stealth", "dexterity");
        abilitySkills.put("athletics", "strength");
        abilitySkills.put("arcana", "intelligence");
        abilitySkills.put("history", "intelligence");
        abilitySkills.put("investigation", "intelligence");
        abilitySkills.put("nature", "intelligence");
        abilitySkills.put("religion", "intelligence");
        abilitySkills.put("animal handling", "wisdom");
        abilitySkills.put("insight", "wisdom");
        abilitySkills.put("medicine", "wisdom");
        abilitySkills.put("perception", "wisdom");
        abilitySkills.put("survival", "wisdom");
        abilitySkills.put("deception", "charisma");
        abilitySkills.put("intimidation", "charisma");
        abilitySkills.put("performance", "charisma");
        abilitySkills.put("persuasion", "charisma");
    }

    public String makeAbilityCheckRoll(String typeAbilityCheck, Character character, List<String> characterSkills){
        int randomRoll = getRandomRoll();
        if (characterSkills.contains(typeAbilityCheck)) {
            return(randomRoll + " + " + modifiers.getModifier(character.getAbilityScores(abilitySkills.get(typeAbilityCheck))) + " + " + character.getAbilityScores("proficiency") + " = " + (randomRoll + modifiers.getModifier(character.getAbilityScores(abilitySkills.get(typeAbilityCheck))) + character.getAbilityScores("proficiency")));
        } else {
            return(randomRoll + " + " + modifiers.getModifier(character.getAbilityScores(abilitySkills.get(typeAbilityCheck))) + " = " + (randomRoll + modifiers.getModifier(character.getAbilityScores(abilitySkills.get(typeAbilityCheck)))));
        }
    }
}
