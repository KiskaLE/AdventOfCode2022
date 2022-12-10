import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class day8 {
    static int up, down, left, right;
    static List<Integer> watchDistance = new ArrayList<>();

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
                if (isVisibleUp(tree, j, i, treeMap) || isVisibleDown(tree, j, i, treeMap) || isVisibleLeft(tree, j, i, treeMap) || isVisibleRight(tree, j, i, treeMap)) {
                    part1++;
                }
                //part2
                isVisibleUp(tree, j, i, treeMap);
                isVisibleDown(tree, j, i, treeMap);
                isVisibleLeft(tree, j, i, treeMap);
                isVisibleRight(tree, j, i, treeMap);
                watchDistance.add(getWatchDistance());
            }
        }
        System.out.println("part1: " + part1);
        System.out.println("part2: " + part2());
    }

    private static String part2() {
        Collections.sort(watchDistance);
        return watchDistance.get(watchDistance.size()-1).toString();
    }

    private static int getWatchDistance() {
        return up * down * left * right;
    }

    static boolean isVisibleRight(int tree, int x, int y, int[][] treeMap) {
        int sumOfTrees = 0;
        boolean b = true;
        for (int i = x + 1; i < treeMap[y].length; i++) {
            if (treeMap[y][i] >= tree) {
                b = false;
                sumOfTrees++;
                break;
            }
            sumOfTrees++;
        }
        right = sumOfTrees;
        return b;
    }

    static boolean isVisibleLeft(int tree, int x, int y, int[][] treeMap) {
        int sumOfTrees = 0;
        boolean b = true;
        for (int i = x - 1; i >= 0; i--) {
            if (treeMap[y][i] >= tree) {
                b = false;
                sumOfTrees++;
                break;
            }
            sumOfTrees++;
        }
        left = sumOfTrees;
        return b;
    }

    static boolean isVisibleDown(int tree, int x, int y, int[][] treeMap) {
        int sumOfTrees = 0;
        boolean b = true;
        for (int i = y + 1; i < treeMap.length; i++) {
            if (treeMap[i][x] >= tree) {
                b = false;
                sumOfTrees++;
                break;
            }
            sumOfTrees++;
        }
        down = sumOfTrees;
        return b;
    }

    static boolean isVisibleUp(int tree, int x, int y, int[][] treeMap) {
        int sumOfTrees = 0;
        boolean b = true;
        for (int i = y - 1; i >= 0; i--) {
            if (treeMap[i][x] >= tree) {
                b = false;
                sumOfTrees++;
                break;
            }
            sumOfTrees++;
        }
        up = sumOfTrees;
        return b;
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
