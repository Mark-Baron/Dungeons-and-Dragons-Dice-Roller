package diceroller;

import java.util.ArrayList;
import java.util.List;

public class Paladin implements Class{

    List savingThrows = new ArrayList<>();

    public void setSavingThrowProf() {
        savingThrows.add("wisdom");
        savingThrows.add("charisma");
    }

    public List getSavingThrowProf(){
        return savingThrows;
    }
}
