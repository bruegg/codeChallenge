package main.guessinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GuessingGame {
    private Scanner reader = new Scanner(System.in);

    private int topNumber = 0;
    private int lowNumber = 0;

    public GuessingGame() {
        int numberOfGames = 0;
        System.out.println("Please enter a number n: ");
        int n = reader.nextInt();
        String playAgain = "y";
        ArrayList<Integer> guessCount = new ArrayList<>();
        while (playAgain.equals("y")) {
            topNumber = n;
            lowNumber = 0;
            numberOfGames++;

            guessCount.add(guessNumber());
            System.out.println("Play again (y/n)? ");
            System.out.println("I averaged " + getAverage(guessCount) + " per game for " + numberOfGames + " games.");
            playAgain = reader.next().toLowerCase();
        }
        reader.close();
    }

    private double getAverage(List<Integer> counterList) {
        return counterList.stream()
                .mapToDouble(a -> a)
                .average().orElse(0);
    }

    /**
     * Use a binary search to determine what our guess will be
     *
     * @return the number we guessed
     */
    private int guessNumber() {
        int counter = 0;
        int guess = topNumber / 2;
        Guess guessEnum = null;
        while (true) {
            counter++;
            guessEnum = compareNumber(guess);
            switch (guessEnum) {
                case H:
                    topNumber = guess;
                    guess = guess - ((guess - lowNumber) / 2);
                    break;
                case L:
                    lowNumber = guess;
                    guess = ((topNumber - lowNumber) / 2) + guess;
                    break;
                case C:
                    System.out.println("Your number is " + guess);
                    System.out.println("It took me " + counter + " guesses.");
                    return counter;
            }
        }
    }

    /**
     * Ask user if guess is correct
     *
     * @param guess the number the computer guessed
     * @return the enum representing high, low, or correct
     */
    private Guess compareNumber(Integer guess) {
        Guess ret;
        while (true) {
            System.out.print(guess + "? ");
            String answer = reader.next();

            if (answer == null || answer.equals("")) {
                System.out.println("Invalid input");
            } else {
                ret = Guess.nameOf(answer.toLowerCase());
                if (ret == null) {
                    System.out.println("Invalid input");
                } else {
                    return ret;
                }
            }
        }
    }

    public static void main(String[] args) {
        new GuessingGame();
    }

    private enum Guess {
        H("h"),
        L("l"),
        C("c");

        private String value;

        Guess(String val) {
            this.value = val;
        }

        public static Guess nameOf(String num) {
            for (Guess val : Guess.values()) {
                if (val.value.equals(num)) {
                    return val;
                }
            }
            return null;
        }
    }
}
