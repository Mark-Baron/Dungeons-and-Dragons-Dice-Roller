package diceroller;

import java.util.ArrayList;
import java.util.List;

public class Sorcerer implements Class{

    List savingThrows = new ArrayList<>();

    public void setSavingThrowProf() {
        savingThrows.add("charisma");
        savingThrows.add("constitution");
    }

    public List getSavingThrowProf(){
        return savingThrows;
    }
}
