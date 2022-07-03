package diceroller;

import java.util.HashMap;
import java.util.Map;

public class Character {

    Map<String, Integer> abilityScores = new HashMap<>();

    //Refer to the comment directly above each setter for a version that actually contains the ability name

//    public void setStrengthScore(int score){
//        abilityScores.put("strength", score);
//    }
    public void setStrengthScore(int score){
    abilityScores.put("1", score);
}

//    public void setDexScore(int score){
//        abilityScores.put("dexterity", score);
//    }
    public void setDexScore(int score){
    abilityScores.put("2", score);
}

//    public void setConScore(int score){
//        abilityScores.put("constitution", score);
//    }
    public void setConScore(int score){
    abilityScores.put("3", score);
}

//    public void setIntScore(int score){
//        abilityScores.put("intelligence", score);
//    }
    public void setIntScore(int score){
    abilityScores.put("4", score);
}

//    public void setWisScore(int score){
//        abilityScores.put("wisdom", score);
//    }
    public void setWisScore(int score){
    abilityScores.put("5", score);
}

//    public void setCharScore(int score){
//        abilityScores.put("charisma", score);
//    }
    public void setCharScore(int score){
    abilityScores.put("6", score);
}

//    public void setProfBonus(int score){
//        abilityScores.put("proficiency", score);
//    }
    public void setProfBonus(int score){
    abilityScores.put("7", score);
}


    public Integer getAbilityScores(String ability) {
        return abilityScores.get(ability);
    }


}
