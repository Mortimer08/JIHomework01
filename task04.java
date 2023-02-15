
/*
 * 4. *+Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры
могут быть заменены знаком вопроса, например 2? + ?5 = 69. Требуется
восстановить выражение до верного равенства. Предложить хотя бы
одно решение или сообщить, что его нет.
 */
import java.util.Scanner;
public class task04 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Введите искомое выражение вида:\n2? + ?5 = 69");
        String exp = myScanner.nextLine();
        myScanner.close();
        exp = exp.trim();
        exp = exp.replace(" ", "");
        exp = exp.replace("+", " + ");
        exp = exp.replace("-", " - ");
        exp = exp.replace("*", " * ");
        exp = exp.replace("/", " / ");
        exp = exp.replace("=", " = ");
        int expCount = 0;
        String newExp = exp;
        /* Релизовано решение для двух неизвестных цифр, только для операции сложение 
        вложенные циклы перебирают возможные сочетания цифр, подствляют в исходное выражение вместо знаков вопроса
        Проверка равенства в отдельном модуле isEquals, в котором сформированное выражение парсится,
        расчитывается результат и проверяется равенство
        */
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                int firstUnknown = exp.indexOf("?");
                int secondUnknown = exp.indexOf("?", firstUnknown+1);
                newExp = newExp.substring(0,firstUnknown)+String.valueOf(i)+newExp.substring(firstUnknown+1,newExp.length());
                newExp = newExp.substring(0,secondUnknown)+String.valueOf(j)+newExp.substring(secondUnknown+1,newExp.length());;
                if (isEquals(newExp)) {
                    System.out.println(newExp);
                    expCount++;
                }

            }
        }
        if (expCount==0){
            System.out.println("Решения нет");
        }
    }

    public static boolean isEquals(String expression) {
        int plusIndex = expression.indexOf("+");
        int equalsIndex = expression.indexOf("=");
        String firstNumber = expression.substring(0, plusIndex - 1);
        String secondNumber = expression.substring(plusIndex + 2, equalsIndex - 1);
        String result = expression.substring(equalsIndex + 2, expression.length());

        return Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber) == Double.parseDouble(result);
    }
}