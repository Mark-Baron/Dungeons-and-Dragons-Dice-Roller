package diceroller.classes;

import diceroller.classes.Class;

import java.util.ArrayList;
import java.util.List;

public class Cleric implements Class {

    List<String> savingThrows = new ArrayList<>();

    public Cleric(){
//        savingThrows.add("wisdom");
//        savingThrows.add("charisma");
        savingThrows.add("5");
        savingThrows.add("6");
    }

    public List<String> getSavingThrowProf(){
        return savingThrows;
    }
}
