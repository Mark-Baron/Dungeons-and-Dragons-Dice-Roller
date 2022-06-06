package diceroller;

import java.util.ArrayList;
import java.util.List;

public class Barbarian implements Class{
    List savingThrows = new ArrayList<>();

    public void setSavingThrowProf() {
        savingThrows.add("strength");
        savingThrows.add("constitution");
    }

    public List getSavingThrowProf(){
        return savingThrows;
    }

}
