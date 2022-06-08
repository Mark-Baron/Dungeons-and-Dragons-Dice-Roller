package diceroller;

import java.util.ArrayList;
import java.util.List;

public class Bard implements Class{

    List<String> savingThrows = new ArrayList<>();

    public Bard(){
        savingThrows.add("dexterity");
        savingThrows.add("charisma");
    }

    public List<String> getSavingThrowProf(){
        return savingThrows;
    }
}
