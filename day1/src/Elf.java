import java.util.ArrayList;
import java.util.List;

public class Elf {
    List<Integer> calories;

    public Elf() {
        calories = new ArrayList<>();
    }

    public void addCalories(int calories){
        this.calories.add(calories);
    }

    public Integer getSumCalories(){
        int sumCalories = 0;
        for (int cal:
             calories) {
            sumCalories += cal;
        }
        return sumCalories;
    }
}
