
/* 3. Реализовать простой калькулятор
Реализация через парсинг выражения. Функционал - базовый )) - нет скобок, нет возможности обработки отрицательных значений
*/
import java.util.Scanner;
public class task03 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Введите простое математическое выражение: ");
        String expr = myScanner.nextLine();
        myScanner.close();
        expr = expr.trim();
        expr = expr.replace(" ", "");
        expr = expr.replace("+", " + ");
        expr = expr.replace("-", " - ");
        expr = expr.replace("*", " * ");
        expr = expr.replace("/", " / ");
        String result = calc(expr);
        
        System.out.printf("Ответ: %s\n",result);

    }

    public static String calc(String expression) {

        if (!(expression.contains("+") || expression.contains("-") || expression.contains("*")
                || expression.contains("/"))) {
            return expression;
        }

        if (expression.contains("*")) {
            int index = expression.indexOf("*");
            String [] expressionParts = parseExpression(expression,index);
            String midle = String.valueOf(Double.parseDouble(expressionParts[1]) * Double.parseDouble(expressionParts[2]));
            expression = String.format("%s %s %s", expressionParts[0], midle, expressionParts[3]);
            expression = expression.trim();
            return calc(expression);
        }
        if (expression.contains("/")) {
            int index = expression.indexOf("/");
            String [] expressionParts = parseExpression(expression,index);
            String midle = String.valueOf(Double.parseDouble(expressionParts[1]) / Double.parseDouble(expressionParts[2]));
            expression = String.format("%s %s %s", expressionParts[0], midle, expressionParts[3]);
            expression = expression.trim();
            return calc(expression);
        }
        if (expression.contains("+")) {
            int index = expression.indexOf("+");
            String [] expressionParts = parseExpression(expression,index);
            String midle = String.valueOf(Double.parseDouble(expressionParts[1]) + Double.parseDouble(expressionParts[2]));
            expression = String.format("%s %s %s", expressionParts[0], midle, expressionParts[3]);
            expression = expression.trim();
            return calc(expression);
        }
        if (expression.contains("-")) {
            int index = expression.indexOf("-");
            String [] expressionParts = parseExpression(expression,index);
            String midle = String.valueOf(Double.parseDouble(expressionParts[1]) - Double.parseDouble(expressionParts[2]));
            expression = String.format("%s %s %s", expressionParts[0], midle, expressionParts[3]);
            expression = expression.trim();
            return calc(expression);
        }
        return expression;
    }
    public static String[] parseExpression(String expression, int signIndex) {
        String[]expressionParts = new String[4];
            expressionParts[0] = expression.substring(0, signIndex - 1);
            expressionParts[3] = expression.substring(signIndex + 2, expression.length());
            if (expressionParts[0].contains(" ")) {
                expressionParts[1] = expressionParts[0].substring(expressionParts[0].lastIndexOf(" ") + 1, expressionParts[0].length());
                expressionParts[0] = expressionParts[0].substring(0, expressionParts[0].lastIndexOf(" "));
            } else {
                expressionParts[1] = expressionParts[0];
                expressionParts[0] = "";
            }
            if (expressionParts[3].contains(" ")) {
                expressionParts[2] = expressionParts[3].substring(0, expressionParts[3].indexOf(" "));
                expressionParts[3] = expressionParts[3].substring(expressionParts[3].indexOf(" ") + 1, expressionParts[3].length());
            } else {
                expressionParts[2] = expressionParts[3];
                expressionParts[3] = "";
            }
        return expressionParts;
    }
}