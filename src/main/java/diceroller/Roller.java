package diceroller;

import java.util.*;

public class Roller {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> charactersSkills = new ArrayList<>();

        Character character = new Character();
        AttackRoll attackRoll = new AttackRoll();
        SavingThrowRoll savingThrowRoll = new SavingThrowRoll();
        AbilityCheckRoll abilityCheckRoll = new AbilityCheckRoll();

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


        //Take user input for class, ability scores and proficiency score
        System.out.println("Please select your character's class:");
        System.out.println("1) Barbarian");
        System.out.println("2) Bard");
        System.out.println("3) Cleric");
        System.out.println("4) Druid");
        System.out.println("5) Monk");
        System.out.println("6) Paladin");
        System.out.println("7) Rogue");
        System.out.println("8) Sorcerer");
        System.out.println("9) Warlock");
        System.out.println("10) Wizard");
        classType = scanner.nextLine();

        System.out.println("Please enter your character's stats \nStrength: ");
        strengthScore = scanner.nextLine();
        character.setStrengthScore(Integer.parseInt(strengthScore));

        System.out.println("Dexterity: ");
        dexScore = scanner.nextLine();
        character.setDexScore(Integer.parseInt(dexScore));

        System.out.println("Constitution: ");
        conScore = scanner.nextLine();
        character.setConScore(Integer.parseInt(conScore));

        System.out.println("Intelligence: ");
        intScore = scanner.nextLine();
        character.setIntScore(Integer.parseInt(intScore));

        System.out.println("Wisdom: ");
        wisdomScore = scanner.nextLine();
        character.setWisScore(Integer.parseInt(wisdomScore));

        System.out.println("Charisma: ");
        charismaScore = scanner.nextLine();
        character.setCharScore(Integer.parseInt(charismaScore));

        System.out.println("Proficiency Bonus: ");
        profBonus = scanner.nextLine();
        character.setProfScore(Integer.parseInt(profBonus));

        System.out.println("Enter your skill proficiencies separated by a space (ex. acrobatics stealth deception): ");
        skillProficiencies = scanner.nextLine().split(" ");
        charactersSkills.addAll(Arrays.asList(skillProficiencies));


        //Prompt the user for the type of roll, attack roll, saving throw, or ability check
        while (keepPlayingInput.equals("y")) {
            System.out.println("What kind of roll?");
            System.out.println("1) Attack Roll");
            System.out.println("2) Saving Throw");
            System.out.println("3) Ability Check");
            String rollType = scanner.nextLine();

            if (rollType.equals("1")) {
                System.out.println("Strength or Dexterity?: ");
                attackAbility = scanner.nextLine().toLowerCase();

                System.out.println(attackRoll.makeAttackRoll(attackAbility, character));

                System.out.println("Please enter the damage dice you would like to roll, separated by a space: ");
                String[] diceToRoll = scanner.nextLine().split(" ");

                attackRoll.makeDamageRoll(diceToRoll);

            } else if (rollType.equals("2")) {
                System.out.println("What kind of saving throw? ");
                String typeSavingThrow = scanner.nextLine().toLowerCase();

                System.out.println(savingThrowRoll.makeSavingThrowRoll(typeSavingThrow, character, classType));

            } else if (rollType.equals("3")) {
                System.out.println("What kind of ability check (ex. acrobatics): ");
                String typeAbilityCheck = scanner.nextLine().toLowerCase();

                System.out.println(abilityCheckRoll.makeAbilityCheckRoll(typeAbilityCheck, character, charactersSkills));

            }
            System.out.println("Keep playing? (Y or N): ");
            keepPlayingInput = scanner.nextLine().toLowerCase();
            if (keepPlayingInput.equals("n")) {
                System.out.println("Thanks for playing!");
            }
        }
    }
}