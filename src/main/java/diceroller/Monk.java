package diceroller;

import java.util.ArrayList;
import java.util.List;

public class Monk implements Class{
    List savingThrows = new ArrayList<>();

    public void setSavingThrowProf(){
        savingThrows.add("strength");
        savingThrows.add("dexterity");
    }

    public List getSavingThrowProf(){
        return savingThrows;
    }

}
