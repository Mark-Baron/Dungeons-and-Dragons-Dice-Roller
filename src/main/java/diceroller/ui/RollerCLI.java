package diceroller.ui;

import diceroller.roll.AbilityCheckRoll;
import diceroller.roll.AttackRoll;
import diceroller.Character;
import diceroller.roll.SavingThrowRoll;

import java.util.*;

public class RollerCLI {

    private Character character;
    private AttackRoll attackRoll;
    private SavingThrowRoll savingThrowRoll;
    private AbilityCheckRoll abilityCheckRoll;
    private Menu menu;
    private Scanner scanner;

    private static final String CHARACTER_MENU_BARBARIAN = "1) Barbarian";
    private static final String CHARACTER_MENU_BARD = "2) Bard";
    private static final String CHARACTER_MENU_CLERIC = "3) Cleric";
    private static final String CHARACTER_MENU_DRUID = "4) Druid";
    private static final String CHARACTER_MENU_MONK = "5) Monk";
    private static final String CHARACTER_MENU_PALADIN = "6) Paladin";
    private static final String CHARACTER_MENU_ROGUE = "7) Rogue";
    private static final String CHARACTER_MENU_SORCERER = "8) Sorcerer";
    private static final String CHARACTER_MENU_WARLOCK = "9) Warlock";
    private static final String CHARACTER_MENU_WIZARD = "10) Wizard";
    private static final String[] CHARACTER_MENU_OPTIONS = {CHARACTER_MENU_BARBARIAN, CHARACTER_MENU_BARD, CHARACTER_MENU_CLERIC, CHARACTER_MENU_DRUID,
            CHARACTER_MENU_MONK, CHARACTER_MENU_PALADIN, CHARACTER_MENU_ROGUE, CHARACTER_MENU_SORCERER,
            CHARACTER_MENU_WARLOCK, CHARACTER_MENU_WIZARD};

    private static final String ROLL_MENU_ATTACK_ROLL = "1) Attack Roll";
    private static final String ROLL_MENU_SAVING_THROW = "2) Saving Throw";
    private static final String ROLL_MENU_ABILITY_CHECK = "3) Ability Check";
    private static final String ROLL_MENU_EXIT = "4) Exit";
    private static final String[] ROLL_MENU_OPTIONS = {ROLL_MENU_ATTACK_ROLL, ROLL_MENU_SAVING_THROW, ROLL_MENU_ABILITY_CHECK, ROLL_MENU_EXIT};

    private static final String ABILITY_MENU_ACROBATICS = "1) Acrobatics";
    private static final String ABILITY_MENU_SLEIGHT = "2) Sleight of Hand";
    private static final String ABILITY_MENU_STEALTH = "3) Stealth";
    private static final String ABILITY_MENU_ATHLETICS = "4) Athletics";
    private static final String ABILITY_MENU_ARCANA = "5) Arcana";
    private static final String ABILITY_MENU_HISTORY = "6) History";
    private static final String ABILITY_MENU_INVESTIGATION = "7) Investigation";
    private static final String ABILITY_MENU_NATURE = "8) Nature";
    private static final String ABILITY_MENU_RELIGION = "9) Religion";
    private static final String ABILITY_MENU_HANDLING = "10) Animal Handling";
    private static final String ABILITY_MENU_INSIGHT = "11) Insight";
    private static final String ABILITY_MENU_MEDICINE = "12) Medicine";
    private static final String ABILITY_MENU_PERCEPTION = "13) Perception";
    private static final String ABILITY_MENU_SURVIVAL = "14) Survival";
    private static final String ABILITY_MENU_DECEPTION = "15) Deception";
    private static final String ABILITY_MENU_INTIMIDATION = "16) Intimidation";
    private static final String ABILITY_MENU_PERFORMANCE = "17) Performance";
    private static final String ABILITY_MENU_PERSUASION = "18) Persuasion";
    private static final String[] ABILITY_MENU_OPTIONS = {ABILITY_MENU_ACROBATICS, ABILITY_MENU_SLEIGHT, ABILITY_MENU_STEALTH, ABILITY_MENU_ATHLETICS,
            ABILITY_MENU_ARCANA, ABILITY_MENU_HISTORY, ABILITY_MENU_INVESTIGATION, ABILITY_MENU_NATURE, ABILITY_MENU_RELIGION,
            ABILITY_MENU_HANDLING, ABILITY_MENU_INSIGHT, ABILITY_MENU_MEDICINE, ABILITY_MENU_PERCEPTION, ABILITY_MENU_SURVIVAL,
            ABILITY_MENU_DECEPTION, ABILITY_MENU_INTIMIDATION, ABILITY_MENU_PERFORMANCE, ABILITY_MENU_PERSUASION};

    private static final String SAVING_THROW_MENU_STRENGTH = "1) Strength";
    private static final String SAVING_THROW_MENU_DEXTERITY = "2) Dexterity";
    private static final String SAVING_THROW_MENU_CONSTITUTION = "3) Constitution";
    private static final String SAVING_THROW_MENU_INTELLIGENCE = "4) Intelligence";
    private static final String SAVING_THROW_MENU_WISDOM = "5) Wisdom";
    private static final String SAVING_THROW_MENU_CHARISMA = "6) Charisma";
    private static final String[] SAVING_THROW_MENU_OPTIONS = {SAVING_THROW_MENU_STRENGTH, SAVING_THROW_MENU_DEXTERITY, SAVING_THROW_MENU_CONSTITUTION, SAVING_THROW_MENU_INTELLIGENCE,
            SAVING_THROW_MENU_WISDOM, SAVING_THROW_MENU_CHARISMA};

    private static final String ATTACK_ROLL_MENU_STRENGTH = "1) Strength";
    private static final String ATTACK_ROLL_MENU_DEXTERITY = "2) Dexterity";
    private static final String[] ATTACK_ROLL_MENU_OPTIONS = {ATTACK_ROLL_MENU_STRENGTH,
            ATTACK_ROLL_MENU_DEXTERITY};

    public static void main(String[] args) {
        RollerCLI rollerCLI = new RollerCLI();
        rollerCLI.run();
    }

    public RollerCLI() {
        this.character = new Character();
        this.attackRoll = new AttackRoll();
        this.savingThrowRoll = new SavingThrowRoll();
        this.abilityCheckRoll = new AbilityCheckRoll();
        this.menu = new Menu(System.in, System.out);
        this.scanner = new Scanner(System.in);
    }

    private void run() {
        //Ask the user to enter their character's class
        printHeading("Please select your character's class.");
        String classType;
        classType = menu.getUserInput(CHARACTER_MENU_OPTIONS);

        //Prompt the user to enter their character's stats
        printHeading("Please enter your character's ability scores.");
        setStrengthScore();
        setDexScore();
        setConScore();
        setIntScore();
        setWisScore();
        setCharScore();
        setProfBonus();

        //Prompt the user to enter their skill proficiencies
        printHeading("Please enter your character's skill proficiencies separated by a space (ex. 1 2 3)");
        String[] skillProficiencies;
        List<String> charactersSkills = new ArrayList<>();
        skillProficiencies = menu.getMultiUserInput(ABILITY_MENU_OPTIONS);
        charactersSkills.addAll(Arrays.asList(skillProficiencies));

        //Prompt the user for the type of roll, attack roll, saving throw, or ability check
        printHeading("What kind of roll?");
        boolean running = true;
        while (running) {
            String rollType = menu.getUserInput(ROLL_MENU_OPTIONS);
            if (rollType.equals("1")) {
                handleAttackRoll();
            } else if (rollType.equals("2")) {
                handleSavingThrow(classType);
            } else if (rollType.equals("3")) {
                handleAbilityCheck(charactersSkills);
            } else if (rollType.equals("4")) {
                running = false;
            }
        }
    }

    private int checkCharacterStats(String stat) {
        int statInt = 0;
        try {
            statInt = Integer.parseInt(stat);
            if (statInt >= 1 && statInt <= 30) {
                return statInt;
            }
        } catch (NumberFormatException e) {
            //Eat the exception, output below is the same for both the else and the exception
        }

        System.out.println("Please enter a number between 1 and 30.");

        return 0;
    }

    private boolean checkDmgDice(String[] dmgDice) {

        for (String die : dmgDice) {
            int dieInt;
            try {
                dieInt = Integer.parseInt(die);
                if (dieInt != 4 && dieInt != 6 && dieInt != 8 && dieInt != 10 && dieInt != 12) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Please enter dice from these choices (4,6,8,10,12).");
                return false;
            }
        }
        return true;
    }

    private void printHeading(String heading) {
        System.out.println("\n" + heading);
        for (int i = 0; i < heading.length(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private void setStrengthScore() {
        int strengthScoreInt;
        do {
            System.out.println("Strength: ");
            String strengthScore = scanner.nextLine();
            strengthScoreInt = checkCharacterStats(strengthScore);
        } while (strengthScoreInt == 0);
        character.setStrengthScore(strengthScoreInt);
    }

    private void setDexScore() {
        int dexScoreInt;
        do {
            System.out.println("Dexterity: ");
            String dexScore = scanner.nextLine();
            dexScoreInt = checkCharacterStats(dexScore);
        } while (dexScoreInt == 0);

        character.setDexScore(dexScoreInt);
    }

    private void setConScore() {
        int conScoreInt;
        do {
            System.out.println("Constitution: ");
            String conScore = scanner.nextLine();
            conScoreInt = checkCharacterStats(conScore);
        } while (conScoreInt == 0);

        character.setConScore(conScoreInt);
    }

    private void setIntScore() {
        int intScoreInt;
        do {
            System.out.println("Intelligence: ");
            String intScore = scanner.nextLine();
            intScoreInt = checkCharacterStats(intScore);
        } while (intScoreInt == 0);
        character.setIntScore(intScoreInt);
    }

    private void setWisScore() {
        int wisScoreInt;
        do {
            System.out.println("Wisdom: ");
            String wisdomScore = scanner.nextLine();
            wisScoreInt = checkCharacterStats(wisdomScore);
        } while (wisScoreInt == 0);
        character.setWisScore(wisScoreInt);
    }

    private void setCharScore() {
        int charScoreInt;
        do {
            System.out.println("Charisma: ");
            String charismaScore = scanner.nextLine();
            charScoreInt = checkCharacterStats(charismaScore);
        } while (charScoreInt == 0);
        character.setCharScore(charScoreInt);
    }

    private void setProfBonus() {
        int profBonusInt;
        do {
            System.out.println("Proficiency Bonus: ");
            String profBonus = scanner.nextLine();
            try {
                profBonusInt = Integer.parseInt(profBonus);
                if (profBonusInt >= 2 && profBonusInt <= 6) {
                    character.setProfBonus(profBonusInt);
                } else {
                    System.out.println("Please enter a number between 2 and 6.");
                    profBonusInt = 0;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number between 2 and 6");
                profBonusInt = 0;
            }
        } while (profBonusInt == 0);
    }

    private void handleAttackRoll() {
        printHeading("Strength or Dexterity?");
        String attackAbility = menu.getUserInput(ATTACK_ROLL_MENU_OPTIONS);

        Object[] attackRollNums = attackRoll.makeAttackRoll(attackAbility, character);

        System.out.println();
        printHeading("Roll Result");
        System.out.printf("%s (d20) + %s (modifier) + %s (proficiency) = %s", attackRollNums[0], attackRollNums[1], attackRollNums[2], attackRollNums[3]);
        System.out.println();

        boolean diceCheck;
        String[] diceToRoll;

        printHeading("Please enter the damage dice you would like to roll, separated by a space:");

        do {
            diceToRoll = scanner.nextLine().split(" ");
            diceCheck = checkDmgDice(diceToRoll);
        } while (!diceCheck);

        Object[] diceResults = attackRoll.makeDamageRoll(diceToRoll, attackAbility, character);
        printHeading("Did you do big damage?");

        for (int i = 0; i < diceResults.length; i++) {
            if (i == diceResults.length - 1) {
                System.out.printf(" = %s", diceResults[i]);
                System.out.println();
            } else if (i == diceResults.length - 2) {
                System.out.printf("%s (modifier)", diceResults[i]);
            } else {
                System.out.printf("%s + ", diceResults[i]);
            }
        }

    }

    private void handleSavingThrow(String classType) {
        printHeading("What kind of saving throw?");
        String typeSavingThrow = menu.getUserInput(SAVING_THROW_MENU_OPTIONS);

        Object[] savingThrowNums = savingThrowRoll.makeSavingThrowRoll(typeSavingThrow, character, classType);
        printHeading("Roll Result");
        if (savingThrowNums.length == 3) {
            System.out.printf("%s (d20) + %s (modifier) = %s", savingThrowNums[0], savingThrowNums[1], savingThrowNums[2]);
            System.out.println();
        } else {
            System.out.printf("%s (d20) + %s (modifier) + %s (proficiency) = %s", savingThrowNums[0], savingThrowNums[1], savingThrowNums[2], savingThrowNums[3]);
            System.out.println();
        }
    }

    private void handleAbilityCheck(List<String> charactersSkills) {
        printHeading("What kind of ability check? Please select only one");
        String typeAbilityCheck = menu.getUserInputFromLongMenu(ABILITY_MENU_OPTIONS);

        Object[] abilityCheckNums = abilityCheckRoll.makeAbilityCheckRoll(typeAbilityCheck, character, charactersSkills);
        printHeading("Roll Result");
        if (abilityCheckNums.length == 3) {
            System.out.printf("%s (d20) + %s (modifier) = %s", abilityCheckNums[0], abilityCheckNums[1], abilityCheckNums[2]);
            System.out.println();
        } else {
            System.out.printf("%s (d20) + %s (modifier) + %s (proficiency) = %s", abilityCheckNums[0], abilityCheckNums[1], abilityCheckNums[2], abilityCheckNums[3]);
            System.out.println();
        }
    }
}