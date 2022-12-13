import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PathFinding {
    String[][] map;
    public PathFinding(){

    }

    public int getLenght(){

        return 0;
    }

    public void appendInput(File inputFile){
        List<String> input= new ArrayList<>();
        try {
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNextLine()) {
                input.add(scanner.nextLine());
            }
            this.map = new String[input.size()][input.get(0).length()];
            for (int i = 0; i < input.size(); i++) {
                String line = input.get(i);
                for (int j = 0; j < line.length(); j++) {
                    map[i][j] = String.valueOf(line.charAt(j));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File was not found: "+e);
        }
    }
}
