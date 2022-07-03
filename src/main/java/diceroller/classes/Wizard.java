package diceroller.classes;

import diceroller.classes.Class;

import java.util.ArrayList;
import java.util.List;

public class Wizard implements Class {

    List<String> savingThrows = new ArrayList<>();

    public Wizard(){
//        savingThrows.add("intelligence");
//        savingThrows.add("wisdom");
        savingThrows.add("4");
        savingThrows.add("5");
    }

    public List<String> getSavingThrowProf(){
        return savingThrows;
    }
}
