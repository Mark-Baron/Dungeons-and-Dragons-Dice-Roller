package diceroller;

import java.util.ArrayList;
import java.util.List;

public class Monk implements Class{
    List <String> savingThrows = new ArrayList<>();


    public Monk(){
        savingThrows.add("strength");
        savingThrows.add("dexterity");
    }

    public List<String> getSavingThrowProf(){
        return savingThrows;
    }

}
