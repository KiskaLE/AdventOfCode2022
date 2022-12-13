import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

// https://en.wikipedia.org/wiki/Pathfinding
public class PathFinding {
    char[][] map;
    Point[][] counterMap;
    private int startX, startY, endX, endY;

    public PathFinding(File input, int startX, int startY, int endX, int endY) {
        appendInput(input);
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    //TODO dodělat getLenght
    public int getLenght() {
        List<Point> list = createQueue(startX, startY, endX, endY);

        return list.get(list.size()-1).count;
    }

    private void appendInput(File inputFile) {
        List<String> input = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNextLine()) {
                input.add(scanner.nextLine());
            }
            this.map = new char[input.size()][input.get(0).length()];
            for (int i = 0; i < input.size(); i++) {
                String line = input.get(i);
                for (int j = 0; j < line.length(); j++) {
                    map[i][j] = line.charAt(j);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File was not found: " + e);
        }
    }


    private List<Point> createQueue(final int startX, final int startY, final int endX, final int endY) {
        List<Point> queue = new LinkedList<>();
        queue.add(new Point(endX, endY, 0));
        int count = 1;
        boolean repeat = true;
        while (repeat) {
            List<Point> children = new ArrayList<>();
            for (Point parent : queue) {
                if (parent.count == count - 1) {
                    children.add(new Point(parent.x + 1, parent.y, count));
                    children.add(new Point(parent.x, parent.y + 1, count));
                    children.add(new Point(parent.x - 1, parent.y, count));
                    children.add(new Point(parent.x, parent.y - 1, count));
                    //remove duplicated
                    //children = children.stream().distinct().collect(Collectors.toList());
                    //remove not valid Points
                    List<Point> remove = new ArrayList<>();
                    for (int i = 0; i < children.size(); i++) {
                        Point child = children.get(i);
                        if (child.x < 0 || child.y < 0 || child.x >= map.length || child.y >= map[child.x].length) {
                            remove.add(child);
                        } else {
                            int childValue = Character.valueOf(map[child.x][child.y]);
                            int parentValue = Character.valueOf(map[parent.x][parent.y]);
                            if (!(parentValue <= childValue + 1)) {
                                remove.add(child);
                            }
                        }

                    }
                try {
                    children.removeAll(remove);
                }
                catch (Exception e) {
                }



                //remove duplicates in queue
                remove = new ArrayList<>();
                for (int i = children.size();  i >= 0; i-- ) {
                    Point child = children.get(i);
                    //remove duplicates in queue
                    for (Point oneQueue : queue) {
                        if (oneQueue.x == child.x && oneQueue.y == child.y) {
                            remove.add(child);
                            break;
                        }
                    }
                }
                children.removeAll(remove);

            }
        }
        Collections.addAll(queue, children.toArray(new Point[0]));
        for (int i = 0; i < children.size(); i++) {
            Point child = children.get(i);
            if (child.x == startX && child.y == startY) repeat = false;
        }
        count++;
            System.out.println(count);
    }
        return queue;
}
}

