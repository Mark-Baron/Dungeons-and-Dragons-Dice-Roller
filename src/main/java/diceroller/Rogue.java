package diceroller;

import java.util.ArrayList;
import java.util.List;

public class Rogue implements Class{

    List<String> savingThrows = new ArrayList<>();

    public Rogue(){
        savingThrows.add("dexterity");
        savingThrows.add("intelligence");
    }

    public List<String> getSavingThrowProf(){
        return savingThrows;
    }
}
