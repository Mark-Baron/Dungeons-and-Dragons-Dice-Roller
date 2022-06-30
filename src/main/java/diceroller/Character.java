package diceroller;

import java.util.HashMap;
import java.util.Map;

public class Character {
    Map<String, Integer> abilityScores = new HashMap<>();

    //1 is dex
    public void setDexScore(int score) {
        abilityScores.put("1", score);
    }

    //2 is strength
    public void setStrengthScore(int score) {
        abilityScores.put("2", score);
    }

    //3 is charisma
    public void setCharScore(int score) {
        abilityScores.put("3", score);
    }

    //4 is constitution
    public void setConScore(int score) {
        abilityScores.put("4", score);
    }

    //5 is wisdom
    public void setWisScore(int score) {
        abilityScores.put("5", score);
    }

    //6 is intelligence
    public void setIntScore(int score) {
        abilityScores.put("6", score);
    }

    //7 is proficiency
    public void setProfScore(int score) {
        abilityScores.put("7", score);
    }

    public Integer getAbilityScores(String ability) {
        return abilityScores.get(ability);
    }


}
