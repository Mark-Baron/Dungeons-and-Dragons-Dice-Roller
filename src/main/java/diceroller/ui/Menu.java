package diceroller.ui;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private Scanner in;
    private PrintWriter out;

    public Menu(InputStream inputStream, OutputStream outputStream){
        in = new Scanner(inputStream);
        out = new PrintWriter(outputStream);
    }

    public String getUserInput(String[] menu){
        int userInputInt;
        String userInput;
        do {
            displayMenu(menu);
            userInput = in.nextLine();
            try {
                userInputInt = Integer.parseInt(userInput);
                if (!(userInputInt >= 1 && userInputInt <= menu.length)) {
                    userInputInt = 0;
                    out.println();
                    out.println("Please select an option from the menu.");
                } else {
                    userInputInt = 1;
                }
            } catch (NumberFormatException e) {
                //eat the exception
                userInputInt = 0;
                out.println();
                out.println("Please select an option from the menu.");
            }
        } while (userInputInt == 0);

        return userInput;
    }

    public String[] getMultiUserInput(String[] menu){
        int userInputInt;
        int loopController = 1;
        String[] userInput;
        do {
            displayLongMenu(menu);
            userInput = in.nextLine().split(" ");
            for (String inputItem : userInput){
                try {
                    userInputInt = Integer.parseInt(inputItem);
                    if(!(userInputInt >= 1 && userInputInt <= menu.length)){
                        out.println("Please select only options from the menu.");
                        loopController = 0;
                        break;
                    } else {
                        loopController = 1;
                    }
                } catch (NumberFormatException e){
                    out.println("Please select only options from the menu.");
                    loopController = 0;
                }
            }
        } while (loopController == 0);

        return userInput;
    }

    public String getUserInputFromLongMenu(String[] menu){
        int userInputInt;
        String userInput;
        do {
            displayLongMenu(menu);
            userInput = in.nextLine();
            try {
                userInputInt = Integer.parseInt(userInput);
                if (!(userInputInt >= 1 && userInputInt <= menu.length)) {
                    userInputInt = 0;
                    out.println();
                    out.println("Please select an option from the menu.");
                } else {
                    userInputInt = 1;
                }
            } catch (NumberFormatException e) {
                //eat the exception
                userInputInt = 0;
                out.println();
                out.println("Please select an option from the menu.");
            }
        } while (userInputInt == 0);

        return userInput;
    }


    private void displayMenu(String[] menu){
        out.println();
        for(String menuItem : menu){
            out.println(menuItem);
        }
        out.flush();
    }

    private void displayLongMenu(String[] menu){
        out.println();
        int lineTracker = 1;
        for(String menuItem : menu){
            out.printf(menuItem + "\t");
            if (lineTracker % 3 == 0){
                out.println();
            }
            lineTracker++;
        }
        out.flush();
    }
}
