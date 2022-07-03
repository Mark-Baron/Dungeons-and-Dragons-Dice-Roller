package diceroller.classes;

import diceroller.classes.Class;

import java.util.ArrayList;
import java.util.List;

public class Rogue implements Class {

    List<String> savingThrows = new ArrayList<>();

    public Rogue(){
//        savingThrows.add("dexterity");
//        savingThrows.add("intelligence");
        savingThrows.add("2");
        savingThrows.add("4");
    }

    public List<String> getSavingThrowProf(){
        return savingThrows;
    }
}
