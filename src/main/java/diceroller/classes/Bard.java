package diceroller.classes;

import java.util.ArrayList;
import java.util.List;

public class Bard implements Class {

    List<String> savingThrows = new ArrayList<>();

    public Bard(){
//        savingThrows.add("dexterity");
//        savingThrows.add("charisma");
        savingThrows.add("2");
        savingThrows.add("6");
    }

    public List<String> getSavingThrowProf(){
        return savingThrows;
    }
}
