package diceroller.classes;

import diceroller.classes.Class;

import java.util.ArrayList;
import java.util.List;

public class Monk implements Class {
    List <String> savingThrows = new ArrayList<>();


    public Monk(){
//        savingThrows.add("strength");
//        savingThrows.add("dexterity");
        savingThrows.add("1");
        savingThrows.add("2");
    }

    public List<String> getSavingThrowProf(){
        return savingThrows;
    }

}
