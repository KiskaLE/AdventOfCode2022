import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class day7 {


    public static void main(String[] args) {
        try {
            makeDatabase(new File("day7/input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void makeDatabase(File file) throws FileNotFoundException {
        MyTreeNode root = new MyTreeNode("root");
        MyTreeNode curNode = root;
        MyTreeNode prevNode = null;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(" ");
            //Příkazy
            if (line[0].equals("$")) {
                // Změna souboru
                if (line[1].equals("cd")) {
                    // zpět
                    if (line[2].equals("..")) {
                        curNode = curNode.getParent();
                        prevNode = curNode.getParent();
                    } else {
                        prevNode = curNode;
                        if (curNode != new MyTreeNode<>(line[2])) {
                            curNode = new MyTreeNode<>(line[2]);
                            List<MyTreeNode> temp = new ArrayList<>();
                            temp.add(curNode);
                            prevNode.addChildren(temp);
                        }
                    }
                }
            } else if (isFile(line)) {
                curNode.addChild(line[0]);
            }

        }
        List<Long> files = new ArrayList<>();
        long spaceNeeded = Math.abs(70_000_000 -getTreeSize(root, files) - 30_000_000);
        Collections.sort(files);
        for (long fileSize :
                files) {
            if (fileSize> spaceNeeded){
                System.out.println("part2: "+fileSize);
                break;
            }
        }
        long part1 = 0;
        for (long fileSize :
                files) {
            if (fileSize <= 100_000){
                part1 += fileSize;
            }
        }
        System.out.println("part1: "+part1);
    }

    private static long getTreeSize(MyTreeNode node, List<Long> files) {
        long size = 0;
        List<MyTreeNode> childrens = node.getChildren();
        for (int i = 0; i < childrens.size(); i++) {
            MyTreeNode child = childrens.get(i);
            if (child.hasChildren()) {
                size += getTreeSize(child, files);
            } else {
                size += Integer.parseInt((String) child.getData());
            }
        }
        files.add(size);
        return size;
    }

    private static boolean isFile(String[] line) {
        if (Character.isDigit(line[0].charAt(0))) return true;
        return false;
    }
}
