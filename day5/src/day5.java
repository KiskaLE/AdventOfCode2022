import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class day5 {

    public static void main(String[] args) {

        try {
            String[] input;
            input = new String[]{
                    "DLJRVGF",
                    "TPMBVHJS",
                    "VHMFDGPC",
                    "MDPNGQ",
                    "JLHNF",
                    "NFVQDGTZ",
                    "FDBL",
                    "MJBSVDN",
                    "GLD"
            };
            Scanner sc = new Scanner(new File("day5/input.txt"));
            int cout = 0;
            while (sc.hasNextLine()) {
                final String regex = "[a-z]";
                input = crane5000(sc.nextLine().replaceAll(regex, "").strip(), input);
                cout++;
            }
            System.out.println(Arrays.toString(input) + cout);
        } catch (Exception e) {

        }

    }

    private static String[] crane5000(String command, String[] input) {
        List<Integer> com = new ArrayList<>();
        Arrays.stream(command.split(" ")).forEach(string -> {
            if (!string.isBlank()) com.add(Integer.parseInt(string));
        });
        int from = com.get(1);
        int move = com.get(0);
        int to = com.get(2);
        String primary = input[from - 1];
        String secondary = input[to - 1];
        if (!primary.isBlank()) {
            StringBuilder sb = new StringBuilder(primary.substring(primary.length() - move));
            secondary += sb.reverse();
            primary = primary.substring(0, primary.length() - move);

            input[from - 1] = primary;
            input[to - 1] = secondary;
        }
        return input;
    }

}
