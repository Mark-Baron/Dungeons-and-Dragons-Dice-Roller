package diceroller;

import diceroller.roll.AttackRoll;
import org.junit.Assert;
import org.junit.Test;

public class AttackRollTests {

    @Test
    public void make_attack_roll_test(){
        String attackAbility = "1"; //strength
        Character character = new Character();
        character.setStrengthScore(18);
        character.setProfBonus(3);
        AttackRoll attackRoll = new AttackRoll();

        Object[] testRoll = attackRoll.makeAttackRoll(attackAbility, character);
        String randomRoll = testRoll[0].toString();
        boolean numberCheck;
        try{
            Integer.parseInt(randomRoll);
            numberCheck = true;
        } catch (NumberFormatException e){
            numberCheck = false;
        }

        Assert.assertEquals(4, testRoll.length); //Check to see there are 4 numbers in the array
        Assert.assertTrue(numberCheck); //Check to see if randomRoll is a number
        Assert.assertEquals(4, testRoll[1]); //Check to see that the modifier is the correct value
        Assert.assertEquals(3, testRoll[2]);
    }

    @Test
    public void make_damage_roll_test(){
        String[] diceToRoll = {"10", "10"};
        Character character = new Character();
        character.setStrengthScore(18);
        character.setProfBonus(3);
        AttackRoll attackRoll = new AttackRoll();
        String attackAbility = "1"; //strength

        Object[] testDmgRoll = attackRoll.makeDamageRoll(diceToRoll, attackAbility, character);
        boolean numberCheck = true;
        for(Object number : testDmgRoll){
            try{
                Integer.parseInt(number.toString());
            } catch (NumberFormatException e){
                numberCheck = false;
            }
        }

        Assert.assertEquals(4, testDmgRoll.length); //check to see there are 4 nums in the array
        Assert.assertTrue(numberCheck); //check to see that all values in array are numbers
        Assert.assertEquals(4, testDmgRoll[2]); //check to see that the modifier is the correct value
    }
}
