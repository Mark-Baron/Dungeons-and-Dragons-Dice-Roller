package diceroller;

import java.util.HashMap;
import java.util.Map;

public class Character {
    Map<String, Integer> abilityScores = new HashMap<>();

    public void setDexScore(int score){
        abilityScores.put("dexterity", score);
    }

    public void setStrengthScore(int score){
        abilityScores.put("strength", score);    }

    public void setCharScore(int score){
        abilityScores.put("charisma", score);
    }

    public void setConScore(int score){
        abilityScores.put("constitution", score);
    }

    public void setWisScore(int score){
        abilityScores.put("wisdom", score);
    }

    public void setIntScore(int score){
        abilityScores.put("intelligence", score);
    }

    public void setProfScore(int score){
        abilityScores.put("proficiency", score);
    }

    public Integer getAbilityScores(String ability){
        return abilityScores.get(ability);
    }


}
