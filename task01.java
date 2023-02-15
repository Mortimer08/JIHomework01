
/*
 * 1. Вычислить n-ое треугольного число(сумма чисел от 1 до n), n!
(произведение чисел от 1 до n)
коммент для внесения изменений в ветку github_checkout
 */
import java.util.Scanner;

public class task01 {
    public static void main(String[] args) { // треугольное число и факториал циклом
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Введите целое положительное число: ");
        int number = Integer.valueOf(myScanner.nextLine());
        // int number = 4;
        myScanner.close();
        int triangle = 0;
        int factorial = 1;
        for (int i = 1; i < number + 1; i++) {
            triangle += i;
            factorial *= i;
        }
        System.out.printf("%d - е треугольное число: %d\n",number, triangle);
        System.out.printf("%d - е треугольное число (рассчитанное рекурсивно): %d\n",number,triangleRec(number));
        System.out.printf("Факториал %d: %d\n",number, factorial);
        System.out.printf("Факториал %d (рассчитанный рекурсивно): %d\n",number, factorialRec(number));

    }

    public static int triangleRec(int num) { // треугольное число рекурсией
        if (num == 1) {
            return num;
        } else {
            return num + triangleRec(num - 1);
        }
    }

    public static int factorialRec(int num) { // факториал рекурсией
        if (num == 1) {
            return num;
        } else {
            return num * factorialRec(num - 1);
        }

    }
}
