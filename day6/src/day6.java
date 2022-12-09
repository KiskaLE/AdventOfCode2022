import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day6 {
    public static void main(String[] args) {
        String data = "";
        try {
            Scanner sc = new Scanner(new File("day6/input.txt"));
            data += sc.next();
        } catch (Exception e) {
        }
        int part1 = findStart(data, 4);
        int part2 = findStart(data, 14);
        System.out.println("part1: " + part1 +
                "\npart2: " + part2);
    }

    private static int findStart(final String data, int length) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < data.length(); i++) {
            char letter = data.charAt(i);
            list.add(letter);
            if (list.size() >= length) {
                if (!isUnique(list)) {
                    list.remove(0);
                } else {
                    return i + 1;
                }
            }
        }
        return 0;
    }

    private static boolean isUnique(List<Character> list) {
        for (int j = 0; j < list.size(); j++) {
            int count = 0;
            char let1 = list.get(j);
            for (char let2 : list) {
                if (let1 == let2) count++;
            }
            if (count > 1) return false;
        }
        return true;
    }
}
