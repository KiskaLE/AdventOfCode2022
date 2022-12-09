import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day3 {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("day3/input.txt"));
            List<String> lines = new ArrayList<>();
            int score = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String sameLetter = "";
                String fistPocket = line.substring(0, line.length() / 2);
                String secondPocket = line.substring(line.length() / 2);
                sameLetter = findSameLetters(fistPocket, secondPocket);
                score += getLetterValue(sameLetter);
            }
            System.out.println("part1: " + score);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //part 2
        try {
            Scanner scanner = new Scanner(new File("day3/input.txt"));
            List<String> lines = new ArrayList<>();
            int score = 0;
            while (scanner.hasNextLine()) {
                String fistLine = scanner.nextLine();
                String secondLine = scanner.nextLine();
                String thirdLine = scanner.nextLine();
                String sameLetter = findSameLetters(thirdLine, findSameLetters(fistLine, secondLine));
                score += getLetterValue(sameLetter);
            }
            System.out.println("part2: " + score);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int getLetterValue(String letter) {
        int score = letter.codePointAt(0);
        if (score >= 65 && score <= 90) {
            score -= 64 - 26;
        } else {
            score -= 96;
        }
        return score;
    }

    private static String findSameLetters(String fist, String second) {
        String s = "";
        for (int i = 0; i < fist.length(); i++) {
            String fistChar = String.valueOf(fist.charAt(i));
            for (int j = 0; j < second.length(); j++) {
                String secondChar = String.valueOf(second.charAt(j));
                if (fistChar.equals(secondChar)) {
                    s += fistChar;
                }
            }
        }
        return s;
    }
}

