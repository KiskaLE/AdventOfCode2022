import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class day12 {

    public static void main(String[] args) {
        System.out.println("SbccccccccaaaaaccccccccaacaaccccccccaaaaaaaaaaccccccccccaaaaaaccccccccccccaaacccaaccccccccccccccaaaacccaaaaaiiiqqtttxxxxE".length());
        PathFinding pathFinding = new PathFinding(new File("day12/input.txt"), 20, 0, 20, 121);
        System.out.println("Part1: "+ pathFinding.getLenght());
    }


}
