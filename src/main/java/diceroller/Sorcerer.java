package diceroller;

import java.util.ArrayList;
import java.util.List;

public class Sorcerer implements Class{

    List<String> savingThrows = new ArrayList<>();

    public Sorcerer(){
        savingThrows.add("charisma");
        savingThrows.add("constitution");
    }

    public List<String> getSavingThrowProf(){
        return savingThrows;
    }
}
