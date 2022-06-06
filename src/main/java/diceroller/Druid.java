package diceroller;

import java.util.ArrayList;
import java.util.List;

public class Druid implements Class{

    List savingThrows = new ArrayList<>();

    public void setSavingThrowProf() {
        savingThrows.add("intelligence");
        savingThrows.add("wisdom");
    }

    public List getSavingThrowProf(){
        return savingThrows;
    }
}
