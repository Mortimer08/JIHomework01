
// 3. Реализовать простой калькулятор
public class task03 {
    public static void main(String[] args) {
        String expr = "7+2*2-9*2/4-2";
        expr = expr.trim();
        expr = expr.replace(" ", "");
        expr = expr.replace("+", " + ");
        expr = expr.replace("-", " - ");
        expr = expr.replace("*", " * ");
        expr = expr.replace("/", " / ");
        String result = calc(expr);
        System.out.println(result);

    }

    public static String calc(String expression) {

        if (!(expression.contains("+") || expression.contains("-") || expression.contains("*")
                || expression.contains("/"))) {
            return expression;
        }
        if (expression.contains("*")) {
            expression = expression.trim();
            String left = "";
            String right = "";
            int index = expression.indexOf("*");
            String leftPart = expression.substring(0, index - 1);
            String rightPart = expression.substring(index + 2, expression.length());
            if (leftPart.contains(" ")) {
                left = leftPart.substring(leftPart.lastIndexOf(" ") + 1, leftPart.length());
                leftPart = leftPart.substring(0, leftPart.lastIndexOf(" "));
            } else {
                left = leftPart;
                leftPart = "";
            }
            if (rightPart.contains(" ")) {
                right = rightPart.substring(0, rightPart.indexOf(" "));
                rightPart = rightPart.substring(rightPart.indexOf(" ") + 1, rightPart.length());
            } else {
                right = rightPart;
                rightPart = "";
            }
            String midle = String.valueOf(Double.parseDouble(left) * Double.parseDouble(right));
            expression = String.format("%s %s %s", leftPart, midle, rightPart);
            return calc(expression);
        }
        if (expression.contains("/")) {
            expression = expression.trim();
            String left = "";
            String right = "";
            int index = expression.indexOf("/");
            String leftPart = expression.substring(0, index - 1);
            String rightPart = expression.substring(index + 2, expression.length());
            if (leftPart.contains(" ")) {
                left = leftPart.substring(leftPart.lastIndexOf(" ") + 1, leftPart.length());
                leftPart = leftPart.substring(0, leftPart.lastIndexOf(" "));
            } else {
                left = leftPart;
                leftPart = "";
            }
            if (rightPart.contains(" ")) {
                right = rightPart.substring(0, rightPart.indexOf(" "));
                rightPart = rightPart.substring(rightPart.indexOf(" ") + 1, rightPart.length());
            } else {
                right = rightPart;
                rightPart = "";
            }
            String midle = String.valueOf(Double.parseDouble(left) / Double.parseDouble(right));
            expression = String.format("%s %s %s", leftPart, midle, rightPart);
            return calc(expression);
        }
        if (expression.contains("+")) {
            expression = expression.trim();
            String left = "";
            String right = "";
            int index = expression.indexOf("+");
            String leftPart = expression.substring(0, index - 1);
            String rightPart = expression.substring(index + 2, expression.length());
            if (leftPart.contains(" ")) {
                left = leftPart.substring(leftPart.lastIndexOf(" ") + 1, leftPart.length());
                leftPart = leftPart.substring(0, leftPart.lastIndexOf(" "));
            } else {
                left = leftPart;
                leftPart = "";
            }
            if (rightPart.contains(" ")) {
                right = rightPart.substring(0, rightPart.indexOf(" "));
                rightPart = rightPart.substring(rightPart.indexOf(" ") + 1, rightPart.length());
            } else {
                right = rightPart;
                rightPart = "";
            }
            String midle = String.valueOf(Double.parseDouble(left) + Double.parseDouble(right));
            expression = String.format("%s %s %s", leftPart, midle, rightPart);
            return calc(expression);
        }
        if (expression.contains("-")) {
            expression = expression.trim();
            String left = "";
            String right = "";
            int index = expression.indexOf("-");
            String leftPart = expression.substring(0, index - 1);
            String rightPart = expression.substring(index + 2, expression.length());
            if (leftPart.contains(" ")) {
                left = leftPart.substring(leftPart.lastIndexOf(" ") + 1, leftPart.length());
                leftPart = leftPart.substring(0, leftPart.lastIndexOf(" "));
            } else {
                left = leftPart;
                leftPart = "";
            }
            if (rightPart.contains(" ")) {
                right = rightPart.substring(0, rightPart.indexOf(" "));
                rightPart = rightPart.substring(rightPart.indexOf(" ") + 1, rightPart.length());
            } else {
                right = rightPart;
                rightPart = "";
            }
            String midle = String.valueOf(Double.parseDouble(left) - Double.parseDouble(right));
            expression = String.format("%s %s %s", leftPart, midle, rightPart);
            return calc(expression);
        }
        return expression;
    }
}