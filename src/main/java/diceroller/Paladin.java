package diceroller;

import java.util.ArrayList;
import java.util.List;

public class Paladin implements Class{

    List<String> savingThrows = new ArrayList<>();

    public Paladin(){
        savingThrows.add("wisdom");
        savingThrows.add("charisma");
    }

    public List<String> getSavingThrowProf(){
        return savingThrows;
    }
}
