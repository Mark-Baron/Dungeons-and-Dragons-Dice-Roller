package diceroller.classes;

import java.util.ArrayList;
import java.util.List;

public class Barbarian implements Class {
    List<String> savingThrows = new ArrayList<>();

    public Barbarian(){
//        savingThrows.add("strength");
//        savingThrows.add("constitution");
        savingThrows.add("1");
        savingThrows.add("3");
    }

    public List<String> getSavingThrowProf(){
        return savingThrows;
    }

}
