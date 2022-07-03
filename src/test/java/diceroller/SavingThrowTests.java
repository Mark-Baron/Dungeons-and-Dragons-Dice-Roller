package diceroller;

import diceroller.roll.SavingThrowRoll;
import org.junit.Assert;
import org.junit.Test;

public class SavingThrowTests {

    @Test
    public void make_saving_throw_roll_when_proficient_test() {
        String classType = "1"; //Barbarian (proficient in strength and dexterity saving throws)
        String typeSavingThrow = "1"; //strength
        Character character = new Character();
        character.setStrengthScore(18);
        character.setProfBonus(3);
        SavingThrowRoll savingThrowRoll = new SavingThrowRoll();

        Object[] testSavingThrow = savingThrowRoll.makeSavingThrowRoll(typeSavingThrow, character, classType);
        String randomRoll = testSavingThrow[0].toString();
        boolean numberCheck;
        try{
            Integer.parseInt(randomRoll);
            numberCheck = true;
        } catch (NumberFormatException e){
            numberCheck = false;
        }

        Assert.assertEquals(4, testSavingThrow.length);
        Assert.assertTrue(numberCheck);
        Assert.assertEquals(4, testSavingThrow[1]);
        Assert.assertEquals(3, testSavingThrow[2]);

    }

    @Test
    public void make_saving_throw_roll_when_not_proficient_test() {
        String classType = "1"; //Barbarian (proficient in strength and constitution saving throws)
        String typeSavingThrow = "2"; //dexterity
        Character character = new Character();
        character.setDexScore(16);
        SavingThrowRoll savingThrowRoll = new SavingThrowRoll();

        Object[] testSavingThrow = savingThrowRoll.makeSavingThrowRoll(typeSavingThrow, character, classType);
        String randomRoll = testSavingThrow[0].toString();
        boolean numberCheck;
        try{
            Integer.parseInt(randomRoll);
            numberCheck = true;
        } catch (NumberFormatException e){
            numberCheck = false;
        }

        Assert.assertEquals(3, testSavingThrow.length);
        Assert.assertTrue(numberCheck);
        Assert.assertEquals(3, testSavingThrow[1]);

    }
}
