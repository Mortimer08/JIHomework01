/*
 * 1. Вычислить n-ое треугольного число(сумма чисел от 1 до n), n!
(произведение чисел от 1 до n)
 */
public class task01 {
    public static void main(String[] args) { // треугольное число и факториал циклом
        int number = 4;
        int triangle = 0;
        int factorial = 1;
        for (int i = 1; i < number + 1; i++) {
            triangle += i;
            factorial *= i;
        }
        System.out.println(triangle);
        System.out.println(triangleRec(number));
        System.out.println(factorial);
        System.out.println(factorialRec(number));

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
