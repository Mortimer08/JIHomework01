import java.util.ArrayList;

/*
 * 2. Вывести все простые числа от 1 до 1000
 */
public class task02 {
    public static void main(String[] args) {
        int target = 1000;
        ArrayList<Integer> simplesArray = new ArrayList<Integer>(1);
        for (int i = 3; i < target; i += 2) {
            isSimple(i, simplesArray);
        }
        simplesArray.add(0, 1);
        System.out.println(simplesArray.toString());
    }

    public static void isSimple(int num, ArrayList<Integer> simplesArray) {

        for (int i : simplesArray) {
            if (num % i == 0)
                return;
        }
        simplesArray.add(num);

    }
}
