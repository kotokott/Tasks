/*
Лене очень нравится теория чисел. В прошлый раз она просила участников сезона угадать функцию Эйлера. К сожалению, для некоторых пользователей эта задача оказалась слишком сложной, поэтому Лена придумала задачку попроще.

Вам даны 2 натуральных числа a a и b b. Необходимо посчитать НОД(a, b) и НОК(a, b).

Напомним, что:

НОД ( a , b ) − НОД(a,b)− наибольшее натуральное число, на которое числа a a, b b делятся без остатка.

НОК ( a , b ) − НОК(a,b)− наименьшее натуральное число, которое делится на числа a a, b b без остатка.
Формат ввода

Единственная входная строка содержит два числа − − a , b ( 1 ≤ a , b ≤ 1 0 9 ) a,b(1≤a,b≤109).
Формат вывода

Выведите 2 целых числа − − НОД ( a , b ) НОД(a,b) и НОК ( a , b ) НОК(a,b).
*/


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        Пример ввода и вывода числа n, где -10^9 < n < 10^9:
        int n = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(n));
        */
      String[] input = reader.readLine().split(" ");
      int a = Integer.parseInt(input[0]);
      int b = Integer.parseInt(input[1]);

      int maxNum = Math.max(a, b);
      int minNum = Math.min(a, b);

      int remainder = maxNum % minNum;
      while (remainder != 0) {
        maxNum = minNum;
        minNum = remainder;
        remainder = maxNum % minNum;
        }

        writer.write(String.valueOf(minNum + " " + (long) a * b / minNum));

        reader.close();
        writer.close();
    }

}
