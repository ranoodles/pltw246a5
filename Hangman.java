import java.util.Scanner;
public class Hangman {
    private static String word;
    private static String display = "";
    public static int mistakesLeft = 6;
    private static String[] wordList = {"array","conditional","boolean","integer","string","variable","operator","algorithm","comment","iterating","polymorphism","inheritance","abstraction","object","github"};
    public static void randWord() {
        int index = (int) (Math.random() * wordList.length);
        word = wordList[index];
        for (int i=0; i < word.length(); i++) {
            display += "_";
        }
    } 
    public static boolean checkLetter(String letter) {
        if (word.indexOf(letter) >= 0 && letter.length() == 1){
            for (int i=0; i < word.length(); i++) {
                if (word.substring(i, i+1).equals(letter)) {
                    display = display.substring(0, i) + letter + display.substring(i+1);
                }
            }
            return true;
        } else if (word.indexOf(letter) >= 0 && letter.length() > 1) {
            if (word.equals(letter)) {
                display = word;
                return true;
            } else {
                return false;
            }
        } else {
            mistakesLeft--;
            return false;
        }
    }
    public static void main(String[] args) {
        randWord();
        Scanner input = new Scanner(System.in);
        do {
            System.out.println(display);
            System.out.println("Mistakes Left: "+mistakesLeft);
            System.out.println("\nEnter a letter");
            String letter = input.nextLine();
            if (checkLetter(letter)) {
                System.out.println("\nYou guessed the letter/word!");
            } else {
                System.out.println("\nNope, that letter/word isn't there!");
            }
        } while (word != display && mistakesLeft > 0);
        input.close();
        if (mistakesLeft > 0) {
            System.out.println("Congratulations, you won the game!!");
        } else {
            System.out.println("You lost, try again next time!");
        }
    }
}
