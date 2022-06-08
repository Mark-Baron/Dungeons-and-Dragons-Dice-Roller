package diceroller;

import java.util.ArrayList;
import java.util.List;

public class Druid implements Class{

    List<String> savingThrows = new ArrayList<>();


    public Druid(){
        savingThrows.add("intelligence");
        savingThrows.add("wisdom");
    }

    public List<String> getSavingThrowProf(){
        return savingThrows;
    }
}
