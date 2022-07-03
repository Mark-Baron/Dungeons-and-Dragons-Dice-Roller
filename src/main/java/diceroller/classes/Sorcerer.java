package diceroller.classes;

import diceroller.classes.Class;

import java.util.ArrayList;
import java.util.List;

public class Sorcerer implements Class {

    List<String> savingThrows = new ArrayList<>();

    public Sorcerer(){
//        savingThrows.add("charisma");
//        savingThrows.add("constitution");
        savingThrows.add("6");
        savingThrows.add("3");
    }

    public List<String> getSavingThrowProf(){
        return savingThrows;
    }
}
