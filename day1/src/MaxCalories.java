import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MaxCalories {

    public static void main(String[] args) {
        File elfData = new File("day1/input.txt");
        int maxCalories = 0;
        List<Elf> elfs = new ArrayList<>();
        Elf elf = new Elf();
        try{
            Scanner scanner = new Scanner(elfData);
            while (scanner.hasNext()){
                String line = scanner.nextLine().trim();

                if (line.isEmpty()){
                    elfs.add(elf);
                    elf = new Elf();
                }else{
                    int cal = Integer.parseInt(line);
                    elf.addCalories(cal);
                }

            }

            // getting 3 elfs wiht max calories
            List<Integer> sumCalories = new ArrayList<>();
            int cals = 0;
            for (int i = 0; i < elfs.size(); i++) {
                sumCalories.add(elfs.get(i).getSumCalories());
            }
            Collections.sort(sumCalories);
            Collections.reverse(sumCalories);
            for (int i = 0; i < 3; i++) {
                cals += sumCalories.get(i);
            }
            System.out.println(cals);

        }catch (Exception e){

        }
    }

}
