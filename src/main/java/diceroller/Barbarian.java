package diceroller;

import java.util.ArrayList;
import java.util.List;

public class Barbarian implements Class{
    List<String> savingThrows = new ArrayList<>();

    public Barbarian(){
        savingThrows.add("strength");
        savingThrows.add("constitution");
    }

    public List<String> getSavingThrowProf(){
        return savingThrows;
    }

}
