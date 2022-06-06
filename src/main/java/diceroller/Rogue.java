package diceroller;

import java.util.ArrayList;
import java.util.List;

public class Rogue implements Class{

    List savingThrows = new ArrayList<>();

    public void setSavingThrowProf() {
        savingThrows.add("dexterity");
        savingThrows.add("intelligence");
    }

    public List getSavingThrowProf(){
        return savingThrows;
    }
}
