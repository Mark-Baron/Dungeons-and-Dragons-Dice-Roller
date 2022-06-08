package diceroller;

import java.util.ArrayList;
import java.util.List;

public class Cleric implements Class{

    List<String> savingThrows = new ArrayList<>();

    public Cleric(){
        savingThrows.add("wisdom");
        savingThrows.add("charisma");
    }

    public List<String> getSavingThrowProf(){
        return savingThrows;
    }
}
