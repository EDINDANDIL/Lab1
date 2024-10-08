## Отчет по лабораторной работе № 1

#### № группы: `ПМ-2402`

#### Выполнил: `Гладких Василий Васильевич`

#### Вариант: `6`

### Cодержание:

- [Постановка задачи](#1-постановка-задачи)
- [Входные и выходные данные](#2-входные-и-выходные-данные)
- [Выбор структуры данных](#3-выбор-структуры-данных)
- [Алгоритм](#4-алгоритм)
- [Программа](#5-программа)
- [Анализ правильности решения](#6-анализ-правильности-решения)

### 1. Постановка задачи

> Программа получает на вход 2 числа a и b - коэффициенты при x, не превышающих по модулю 10<sup>308</sup>.
> Нужно решить неравенство относительно x, учитывая ограничения.

Данную задачу можно разделить на 2 подзадачи: предобработка входных данных и решение самого неравенства.

Чтобы программа адекватно реагировала на неправильный формат введенных данных, был написан метод, который 
возвращает значение true, если число корректно для решения неравенства, и false в противном случае.

Для решения неравенства следует рассмотреть следующие случаи:

- Перед решением стоит определить, корректны ли введенные данные:
  
  
       
### 2. Входные и выходные данные

#### Данные на вход

На вход программа должна получать 2 числа, при этом в условии не сказано, к какому множеству
принадлежать получаемые числа, поэтому будем считать их вещественными. Верхняя и нижняя границы получаемых
чисел есть диапазон допустимых значений типа double.

|             | Тип                | min значение    | max значение   |
|-------------|--------------------|-----------------|----------------|
| a (Число 1) | Вещественное число |-(1.79<sup>308</sup>)|1.79<sup>308</sup>|
| b (Число 2) | Вещественное число |-(1.79<sup>308</sup>)|1.79<sup>308</sup>|

#### Данные на выход

Программа в зависимости от введенных параметров выводит решение неравенства в выражения.   
Решение выводится в виде строчке, куда добавляется корень числителя, который ограничивается возможными значениями типа double.
Если формат не данных не подходит, программа выводит сообшение об этом.

|         | Тип                                | min  | max значение   |
|---------|------------------------------------|--------------|----------------|
| Логическое выражение | Строка | -        | - |

### 3. Выбор структуры данных

Программа получает 2 числа (в строке), происходит проверка на корректность, далее двум переменным типа double присваивается значение этих введенных чисел (проверка в теории должна отсеить все неподходящие данные).

|             | название переменной | Тип (в Java) | 
|-------------|---------------------|--------------|
| a (Число 1) | `a`                 | `double`     |
| b (Число 2) | `b`                 | `double`     | 



### 4. Алгоритм
 -Если b положительное, знак остается таким же.       
   *Если a = 0, то x !=0.*   
   *Если -a < 0, то -a >= x && x > 0*    
   *Если -a > 0, то 0 > x && x >= -a*
    
   -Если b отрицательное, знак менеятся.
   *Если a = 0, то x пренадлежит пустому множеству.*   
   *Если -a < 0, то -a <= x < 0*    
   *Если -a > 0, то 0 < x <= -a*

#### Алгоритм выполнения программы:

1. **Ввод данных:**  
   Программа считывает две строки, обозначенные как `first` и `second`.

2. **Проверка на корректность:**
   f(x) - обозначение метода
   Проверяется условие,выдадут ли f(first) и f(second) значение true   
   Если все хорошо, то в переменные a и b записываются значения   

4. **Начало решения неравенства:**
   После того, как мы присвоили значения a и b, следует проверить, не равен ли параметр b нулю.     
   Если это так, программа завершается и выводит сообщение о том, что вы ввели 0 в знаменатель.    

   Если b != 0, нужно понять, поменяется ли знак неравенства.     
   
   -Если b положительное, знак остается таким же.       
   *Если a = 0, то x !=0.*   
   *Если -a < 0, то -a >= x && x > 0*    
   *Если -a > 0, то 0 > x && x >= -a*
    
   -Если b отрицательное, знак менеятся.
   *Если a = 0, то x пренадлежит пустому множеству.*   
   *Если -a < 0, то -a <= x < 0*    
   *Если -a > 0, то 0 < x <= -a*
   
    

6. **Вывод результата:**  
   На экран  выводится полуинтервал, которому пренадлжеит x, или сообщение о том, что решений нет. 

#### Блок-схема

```mermaid
graph TD
    A([Начало]) --> B[/Ввести: first, second/]
    B --> C{first, second - вообще числа?}
    C -- Нет --> P[/Вывод: Данные некорректны/]
    C -- Да --> D[/a = first, b = second/]
    D --> F{b == 0}
    F -- Да --> O[/Вывод: b не должен быть равен 0/]
    F -- Нет --> M{b<0}
    M -- Да --> N{a==0}
    M -- Нет --> L{a==0}
    N -- Да --> N1[/Вывод: x ∈ Ø /]
    N -- Нет --> N2{-a<0}
    L -- Да --> L1[/Вывод: x ≠ 0/]
    L -- Нет --> L2{-a<0}
    L2 -- Да --> E1[/f/]
    L2 -- Нет --> E2[/g/]
    N2 -- Да --> E3[/h/]
    N2 -- Нет --> E4[/j/]
    

    

  
   

```

### 5. Программа

```java
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
                hasMinusSign = true; // теперь в потенциальном числе есть минус, если найдется еще, то метод вернет false
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

        System.out.println("Введите два параметра a и b - коэффициенты при x линейного неравенства.");
        System.out.println("a,b лежат в диапазоне [-(1.79^308) ; 1.79^308]");
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
                        System.out.println("Ответ: x ∈ Ø");
                    } else { // Нужно понимать, где лежит корень относительно 0
                        if (-a < 0) {
                            System.out.println("Ответ: x ∈ [" + (-a) + " ; 0)");
                        } else {
                            System.out.println("Ответ: x ∈ ( 0;" + (-a)+" ]");
                        }
                    }

                } else {
                    // знак остается >=
                    if (a == 0) {
                        System.out.println("Ответ: x ≠ 0");
                    } else {
                        if (-a < 0) {
                            System.out.println("Ответ: x ∈ (-∞ ; " + (-a)+"]" + "∪ (0 ; +∞)");
                        } else {
                            System.out.println("Ответ: x ∈ (-∞ ; 0) ∪ [" + (-a) +" ; +∞");
                        }
                    }
                }
            }
        }

        
    }
}
```

### 6. Анализ правильности решения

Программа работает корректно на всем множестве решений с учетом ограничений.

1. Тест на `X > Y > 0`:

    - **Input**:
        ```
        5 1.3
        ```

    - **Output**:
        ```
        5
        ```

2. Тест на `X < Y < 0`:

    - **Input**:
        ```
        -4 -2.2
        ```

    - **Output**:
        ```
        2.2
        ```

3. Тест на `X < 0 < Y`:

    - **Input**:
        ```
        -4 5
        ```

    - **Output**:
        ```
        5
        ```

4. Тест на `X = 0` или `Y = 0`:

    - **Input**:
        ```
        0 -3
        ```

    - **Output**:
        ```
        3
        ```

5. Тест на ограничение задачи:

    - **Input**:
        ```
        -1000000000 1000000000
        ```

    - **Output**:
        ```
        1000000000
        ```
