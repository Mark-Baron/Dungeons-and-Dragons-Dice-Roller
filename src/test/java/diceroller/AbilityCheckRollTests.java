package diceroller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AbilityCheckRollTests {

    Character character;
    List<String> characterSkills;
    AbilityCheckRoll abilityCheckRoll;

    @Before
    public void Setup(){
        character = new Character();
        character.setCharScore(12);
        character.setConScore(16);
        character.setDexScore(14);
        character.setIntScore(8);
        character.setProfScore(4);
        character.setStrengthScore(18);
        character.setWisScore(10);

        characterSkills = new ArrayList<>();

        abilityCheckRoll = new AbilityCheckRoll();
    }

}
