import java.util.Scanner;

public class Main {

    public static Scanner in = new Scanner(System.in);

    // Метод, который проверяет введенное число на корректность

    public static boolean isNumber(String str) {


        if (str == null || str.isEmpty()) {
            return false; // Пустая строка или null не является числом
        }

        boolean hasDecimalPoint = false; // флаг для плавающей точки
        boolean hasMinusSign = false; // флаг для минуса

        // пробегаемся по строчке и смотрим символы
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (i == 0 && ch == '-') { // Первый символ - минус
                hasMinusSign = true; // теперь в потенциальном числе есть минус, если найдется еще, метод вернет false
                continue;
            }
            if (Character.isDigit(ch)) {
                continue; // Если символ - цифра, пропускаем его

            } else if ((ch == '.' || ch == ',') && !hasDecimalPoint) {
                // Десятичная точка(запятая) может быть только один раз
                hasDecimalPoint = true; // аналогично ставим true для точки, еще одно вхождение вернет false
                continue;
            } else {
                return false; // Если символ не цифра, не минус(который является первым символом) или не точка, то это не число
            }
        }
        return true; // Если все символы прошли проверку, то это число
    }

    public static void main(String[] args) {

        System.out.println("Введите два параметра a и b - коэффиценты при x линейного неравенства.");
        System.out.println("a,b лежат в диапазоне [-10^308 ; 10^308]");
        System.out.println("(x+a)/bx >= 0");
        // ввод параметров a и b
        System.out.print("Ввод a: ");
        String first = in.next();
        System.out.print("Ввод b: ");
        String second = in.next();


        //Решение неравенства

        if (!(isNumber(first) && isNumber(second))) { // Проверка на корректность ввода

            System.out.println("Введенные данные некорректны");

        } else {

            // Если все хорошо, присваиваю переменным заведомо корректные значения

            double a = Double.parseDouble(first.replace(',', '.')); // Так как сюда может попасть число
            double b = Double.parseDouble(second.replace(',', '.'));// с запятой, меняю ее на точку для
                                                                                    // перевода в double без ошибок.

            if (b == 0) { // Если условие b!=0 не соблюдено, то

                System.out.println("Параметр b не должен быть равен 0!");

            } else { // Если a,b - числа и b!=0

                if (b < 0) {
                    // меняем знак на <=
                    if (a == 0) {
                        System.out.println("Ответ: no such x");
                    } else { // Нужно понимать, где лежит корень относительно 0
                        if (-a < 0) {
                            System.out.println("Ответ: " + (-a) + "<=x<0");
                        } else {
                            System.out.println("Ответ: 0<x<=" + (-a));
                        }
                    }

                } else {
                    // знак остается >=
                    if (a == 0) {
                        System.out.println("Ответ: x!=0");
                    } else {
                        if (-a < 0) {
                            System.out.println("Ответ: x<=" + (-a) + " && x>0");
                        } else {
                            System.out.println("Ответ: x<0" + " && x>=" + (-a));
                        }
                    }
                }
            }
        }


    }
}


