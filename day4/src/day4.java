import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day4 {

    public static void main(String[] args) {
        try {
            int part1 = 0;
            int part2 = 0;
            Scanner scanner = new Scanner(new File("day4/input.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] shifts = line.split(",");
                if (contains(shifts[0], shifts[1])) part1++;
                if (isOverlap(shifts[0], shifts[1])) part2++;
            }
            System.out.println("part1: " +part1 + "\npart2: "+part2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static boolean isOverlap(String first, String second) {
        int firstMax = Integer.parseInt(first.split("-")[1]),
                firstMin = Integer.parseInt(first.split("-")[0]),
                secondMax = Integer.parseInt(second.split("-")[1]),
                secondMin = Integer.parseInt(second.split("-")[0]);
        if (firstMax < secondMin && firstMin < secondMin || firstMin>secondMax && firstMax >secondMax){
            return false;
        }else {
            return true;
        }
    }

    private static boolean contains(String first, String second) {
        int firstMax = Integer.parseInt(first.split("-")[1]),
                firstMin = Integer.parseInt(first.split("-")[0]),
                secondMax = Integer.parseInt(second.split("-")[1]),
                secondMin = Integer.parseInt(second.split("-")[0]);
        if (firstMin <= secondMin && firstMax >= secondMax || firstMin >= secondMin && firstMax <= secondMax){
            return true;
        }else {
            return false;
        }
    }
}
