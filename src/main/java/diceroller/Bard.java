package diceroller;

import java.util.ArrayList;
import java.util.List;

public class Bard implements Class{

    List savingThrows = new ArrayList<>();

    public void setSavingThrowProf() {
        savingThrows.add("dexterity");
        savingThrows.add("charisma");
    }

    public List getSavingThrowProf(){
        return savingThrows;
    }
}
