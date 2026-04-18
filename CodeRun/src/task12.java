/*
Напишите программу, которая находит в массиве элемент,
самый близкий по величине к данному числу.

Формат ввода
В первой строке задается одно натуральное число
N
N, не превосходящее 1000 — размер массива. Во второй строке содержатся
N
N чисел — элементы массива, целые числа, не превосходящие по модулю 1000.
В третьей строке вводится одно целое число
x
x, не превосходящее по модулю 1000.

Формат вывода
Вывести значение элемента массива, ближайшее к
x
x. Если таких чисел несколько, выведите любое из них.
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
        Map<Integer, List<Integer>> nums = new HashMap<>();
        int n = Integer.parseInt(reader.readLine());
        int[] nums = new int[n];
        String[] strNums = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = strNums[i]
        }

        reader.close();
        writer.close();
    }
}
