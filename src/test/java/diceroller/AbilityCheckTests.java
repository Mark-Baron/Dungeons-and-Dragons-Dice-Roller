package diceroller;

import diceroller.roll.AbilityCheckRoll;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AbilityCheckTests {

    @Test
    public void ability_check_when_proficient_test(){
        List<String> characterSkills = new ArrayList<>();
        characterSkills.add("1"); //Acrobatics
        Character character = new Character();
        character.setDexScore(14);
        character.setProfBonus(3);
        String typeAbilityCheck = "1"; //Acrobatics
        AbilityCheckRoll abilityCheckRoll = new AbilityCheckRoll();

        Object[] testAbilityCheck = abilityCheckRoll.makeAbilityCheckRoll(typeAbilityCheck, character, characterSkills);
        String randomRoll = testAbilityCheck[0].toString();
        boolean numberCheck;
        try{
            Integer.parseInt(randomRoll);
            numberCheck = true;
        } catch (NumberFormatException e){
            numberCheck = false;
        }

        Assert.assertEquals(4, testAbilityCheck.length);
        Assert.assertTrue(numberCheck);
        Assert.assertEquals(2, testAbilityCheck[1]);
        Assert.assertEquals(3, testAbilityCheck[2]);
    }

    @Test
    public void ability_check_when_not_proficient_test(){
        List<String> characterSkills = new ArrayList<>();
        characterSkills.add("1"); //Acrobatics
        Character character = new Character();
        character.setDexScore(16);
        String typeAbilityCheck = "3"; //Stealth
        AbilityCheckRoll abilityCheckRoll = new AbilityCheckRoll();

        Object[] testAbilityCheck = abilityCheckRoll.makeAbilityCheckRoll(typeAbilityCheck, character, characterSkills);
        String randomRoll = testAbilityCheck[0].toString();
        boolean numberCheck;
        try{
            Integer.parseInt(randomRoll);
            numberCheck = true;
        } catch (NumberFormatException e){
            numberCheck = false;
        }

        Assert.assertEquals(3, testAbilityCheck.length);
        Assert.assertTrue(numberCheck);
        Assert.assertEquals(3, testAbilityCheck[1]);
    }
}
