import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class day12 {

    static List<String> input = new ArrayList<>();
    static int[][] map;

    public static enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    public static void main(String[] args) {
    }

    public static int part1(String url) {
        map = parseInput(url);

        return 0;
    }

    private static int[][] parseInput(String url) {
        try {
            Scanner scanner = new Scanner(new File(url));
            while (scanner.hasNextLine()) {
                input.add(scanner.nextLine());
            }
            int[][] matrix = new int[input.size()][input.get(0).length()];
            for (int i = 0; i < input.size(); i++) {
                String line = input.get(i);
                for (int j = 0; j < line.length(); j++) {
                    matrix[i][j] = Character.valueOf(line.charAt(j));
                }
            }
            return matrix;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void generateCombinations(List<List<Integer>> paths) {
        for (List<Integer> path : paths) {
            if (path.isEmpty()){
                String[] possibleDirections = getPossibleDirections();
            }else {
                String[] possibleDirections = getPossibleDirections();
            }
        }
    }

    private static String[] getPossibleDirections(int x, int y, String lastMove) {
        List<String> moves = new ArrayList<>(Arrays.asList("UP","DOWN","LEFT","RIGHT"));
        switch (lastMove) {
            case "UP":
                moves.remove("DOWN");
                break;
            case "DOWN":
                moves.remove("UP");
                break;
            case "LEFT":
                moves.remove("RIGHT");
                break;
            case "RIGHT":
                moves.remove("LEFT");
                break;

        }
        return moves.toArray(new String[0]);
    }
    private static String[] getPossibleDirections() {
        List<String> moves = new ArrayList<>(Arrays.asList("UP","DOWN","LEFT","RIGHT"));
        return moves.toArray(new String[0]);
    }

}
