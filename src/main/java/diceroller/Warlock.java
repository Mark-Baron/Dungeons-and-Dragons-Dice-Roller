package diceroller;

import java.util.ArrayList;
import java.util.List;

public class Warlock implements Class{

    List<String> savingThrows = new ArrayList<>();

    public Warlock(){
        savingThrows.add("wisdom");
        savingThrows.add("charisma");
    }

    public List<String> getSavingThrowProf(){
        return savingThrows;
    }
}
