/*
В трек аналитики второго сезона вошло 28 задач, однако кроме них была подготовлена ещё одна задача. Так как в сезон она не вошла, то предлагаем решить вам её сейчас.

Вам дано квадратное уравнение вида:

a x2 + b x + c = 0 ax2+bx+c=0,

где a a, b b и c c — целые числа, такие что a ≠ 0 a=0.

Напишите программу, которая решает это уравнение.
Формат ввода

Единственная строка входных данных содержит три целых числа a a, b b, c c ( − 1 03 ≤ a , b , c ≤ 1 03 −103≤a,b,c≤103, a ≠ 0 a=0).
Формат вывода

В первой строке выведите количество действительных корней уравнения.

Во второй строке выведите сами корни. Если уравнение имеет два корня, то выведите их через пробел в порядке возрастания. Если корень один, то выведите его. Если корней нет, то ничего выводить не нужно. Ваш ответ будет принят, если введенные числа отличаются от правильных ответов на величину не более 1 0 − 6 10−6.
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
        int c = Integer.parseInt(input[2]);

        double d = b * b - 4 * a * c;
        if (d < 0) {
            writer.write("0");
            reader.close();
            writer.close();
            return;
        }

        double x1 = (-b + Math.sqrt(d)) / (2 * a);
        double x2 = (-b - Math.sqrt(d)) / (2 * a);

        String answer;
        if (d == 0) {
            answer = String.format("%.6f", x1);
        } else {
            answer = String.format("%.6f", Math.min(x1, x2))
                + " "
                + String.format("%.6f", Math.max(x1, x2));
        }

        writer.write(String.valueOf(x1 == x2 ? 1 : 2) + "\n");
        writer.write(answer);

        reader.close();
        writer.close();
    }
}
