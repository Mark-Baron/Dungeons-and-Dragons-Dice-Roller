package diceroller;

import java.util.*;

public class Roller {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Dice> diceRoller = new HashMap<>();
        Map<String, Integer> scoreModifiers = new HashMap<>();
        Map<String, String> abilityScores = new HashMap<>();
        Map<String, Boolean> proficiencies = new HashMap<>();
        Map<String, String> abilitySkills = new HashMap<>();
        Map<String, String> characterClasses = new HashMap<>();
        Map<String, Class> classInstance = new HashMap<>();
        List<String> charactersSkills = new ArrayList<>();


        String strengthScore;
        String dexScore;
        String conScore;
        String intScore;
        String wisdomScore;
        String charismaScore;
        String profBonus;
        String attackAbility;
        String keepPlayingInput = "y";
        String classType;
        String[] skillProficiencies;


        diceRoller.put("4", new D4());
        diceRoller.put("6", new D6());
        diceRoller.put("8", new D8());
        diceRoller.put("10", new D10());
        diceRoller.put("12", new D12());
        diceRoller.put("20", new D20());

        classInstance.put("barbarian", new Barbarian());
        classInstance.put("rogue", new Rogue());
        classInstance.put("wizard", new Wizard());
        classInstance.put("paladin", new Paladin());
        classInstance.put("cleric", new Cleric());
        classInstance.put("sorcerer", new Sorcerer());
        classInstance.put("druid", new Druid());
        classInstance.put("bard", new Bard());
        classInstance.put("warlock", new Warlock());
        classInstance.put("monk", new Monk());

        scoreModifiers.put("3", -4);
        scoreModifiers.put("4", -3);
        scoreModifiers.put("5", -3);
        scoreModifiers.put("6", -2);
        scoreModifiers.put("7", -2);
        scoreModifiers.put("8", -1);
        scoreModifiers.put("9", -1);
        scoreModifiers.put("10", 0);
        scoreModifiers.put("11", 0);
        scoreModifiers.put("12", 1);
        scoreModifiers.put("13", 1);
        scoreModifiers.put("14", 2);
        scoreModifiers.put("15", 2);
        scoreModifiers.put("16", 3);
        scoreModifiers.put("17", 3);
        scoreModifiers.put("18", 4);
        scoreModifiers.put("19", 4);
        scoreModifiers.put("20", 5);

        abilitySkills.put("acrobatics", "dexterity");
        abilitySkills.put("sleight of hand", "dexterity");
        abilitySkills.put("stealth", "dexterity");
        abilitySkills.put("athletics", "strength");
        abilitySkills.put("arcana", "intelligence");
        abilitySkills.put("history", "intelligence");
        abilitySkills.put("investigation", "intelligence");
        abilitySkills.put("nature", "intelligence");
        abilitySkills.put("religion", "intelligence");
        abilitySkills.put("animal handling", "wisdom");
        abilitySkills.put("insight", "wisdom");
        abilitySkills.put("medicine", "wisdom");
        abilitySkills.put("perception", "wisdom");
        abilitySkills.put("survival", "wisdom");
        abilitySkills.put("deception", "charisma");
        abilitySkills.put("intimidation", "charisma");
        abilitySkills.put("performance", "charisma");
        abilitySkills.put("persuasion", "charisma");


        //Take user input for class, ability scores and proficiency score
        System.out.println("Please enter your character's class: ");
        classType = scanner.nextLine().toLowerCase();

        System.out.println("Please enter your character's stats \nStrength: ");
        strengthScore = scanner.nextLine();
        abilityScores.put("strength", strengthScore);

        System.out.println("Dexterity: ");
        dexScore = scanner.nextLine();
        abilityScores.put("dexterity", dexScore);

        System.out.println("Constitution: ");
        conScore = scanner.nextLine();
        abilityScores.put("constitution", conScore);

        System.out.println("Intelligence: ");
        intScore = scanner.nextLine();
        abilityScores.put("intelligence", intScore);

        System.out.println("Wisdom: ");
        wisdomScore = scanner.nextLine();
        abilityScores.put("wisdom", wisdomScore);

        System.out.println("Charisma: ");
        charismaScore = scanner.nextLine();
        abilityScores.put("charisma", charismaScore);

        System.out.println("Proficiency Bonus: ");
        profBonus = scanner.nextLine();
        abilityScores.put("proficiency", profBonus);

        System.out.println("Enter your skill proficiencies separated by a space (ex. acrobatics stealth deception): ");
        skillProficiencies = scanner.nextLine().split(" ");
        charactersSkills.addAll(Arrays.asList(skillProficiencies));


        //Prompt the user for the type of roll, attack roll, saving throw, or ability check
        while (keepPlayingInput.equals("y")) {
            System.out.println("What kind of roll? (Attack roll, Saving Throw, or Ability Check): ");
            String rollType = scanner.nextLine().toLowerCase();

            //the action
            if (rollType.equals("attack roll")) {
                System.out.println("Strength or Dexterity?: ");
                attackAbility = scanner.nextLine().toLowerCase();
                int rollValue = diceRoller.get("20").getRandom();

                if (attackAbility.equals("strength")) {
                    System.out.println(rollValue + " + " + scoreModifiers.get(abilityScores.get(attackAbility.toLowerCase())) + " + " + abilityScores.get("proficiency"));
                } else {
                    System.out.println(rollValue + " + " + scoreModifiers.get(abilityScores.get(attackAbility.toLowerCase())) + " + " + abilityScores.get("proficiency"));
                }

                System.out.println("Please enter the damage dice you would like to roll, separated by a space: ");
                String[] diceToRoll = scanner.nextLine().split(" ");

                int diceTotal = 0;
                for (String diceType : diceToRoll) {
                    int diceResult = diceRoller.get(diceType).getRandom();

                    if (!diceType.equals("20")) {
                        diceTotal += diceResult;
                    }
                    System.out.println(diceResult);
                }

                System.out.printf("Total: %d\n", diceTotal);
            }

            else if (rollType.equals("saving throw")) {
                System.out.println("What kind of saving throw? ");
                String typeSavingThrow = scanner.nextLine().toLowerCase();
                int rollResult = diceRoller.get("20").getRandom();
                classInstance.get(classType).setSavingThrowProf(); //Protect the list here

                if(classInstance.get(classType).getSavingThrowProf().contains(typeSavingThrow)){
                    System.out.println(rollResult + " + " + scoreModifiers.get(abilityScores.get(typeSavingThrow)) + " + " + abilityScores.get("proficiency"));
                } else {
                    System.out.println(rollResult + " + " + scoreModifiers.get(abilityScores.get(typeSavingThrow)));
                }
            }

            else if (rollType.equals("ability check")) {
                System.out.println("What kind of ability check (ex. acrobatics): ");
                String typeAbilityCheck = scanner.nextLine().toLowerCase();
                int rollResult = diceRoller.get("20").getRandom();
                if (charactersSkills.contains(typeAbilityCheck)) {
                    System.out.println(rollResult + " + " + scoreModifiers.get(abilityScores.get(abilitySkills.get(typeAbilityCheck))) + " + " + abilityScores.get("proficiency"));
                } else {
                    System.out.println(rollResult + " + " + scoreModifiers.get(abilityScores.get(abilitySkills.get(typeAbilityCheck))));
                }
            }
            System.out.println("Keep playing? (Y or N): ");
            keepPlayingInput = scanner.nextLine().toLowerCase();
            if (keepPlayingInput.equals("n")) {
                System.out.println("Thanks for playing!");
            }
        }
    }
}