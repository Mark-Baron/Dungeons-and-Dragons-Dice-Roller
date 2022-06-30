package diceroller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AttackRollTests {
    Character character;
    AttackRoll attackRoll;

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

        attackRoll = new AttackRoll();
    }

}
