package diceroller;

import java.util.ArrayList;
import java.util.List;

public class Wizard implements Class{

    List<String> savingThrows = new ArrayList<>();

    public Wizard(){
        savingThrows.add("intelligence");
        savingThrows.add("wisdom");
    }

    public List<String> getSavingThrowProf(){
        return savingThrows;
    }
}
