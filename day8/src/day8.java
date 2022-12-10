import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class day8 {
    public static void main(String[] args) {
        int[][] treeMap;
        try {
            treeMap = generateMap(new File("day8/input.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int part1 = 0;
        for (int i = 0; i < treeMap.length; i++) {
            for (int j = 0; j < treeMap[i].length; j++) {
                int tree = treeMap[i][j];
                if (isVisibleUp(tree) || isVisibleDown(tree) || isVisibleLeft(tree) || isVisibleRight(tree)) {
                    part1++;
                }
            }
        }
    }
//TODO dodělat funkce:
    private static boolean isVisibleRight(int tree) {
        return false;
    }

    private static boolean isVisibleLeft(int tree) {
        return false;
    }

    private static boolean isVisibleDown(int tree) {
        return false;
    }

    private static boolean isVisibleUp(int tree) {
        return false;
    }

    private static int[][] generateMap(File input) throws FileNotFoundException {
        Scanner scanner = new Scanner(input);
        List<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        int[][] result = new int[lines.size()][lines.get(0).length()];
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            for (int j = 0; j < line.length(); j++) {
                result[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }
        return result;
    }


}
