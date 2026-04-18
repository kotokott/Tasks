/*
Последовательность чисел назовём симметричной, если она одинаково читается как слева направо, так и справа налево.
Например, следующие последовательности являются симметричными:

1 2 3 4 5 4 3 2 1

1 2 1 2 2 1 2 1

Вашей программе будет дана последовательность чисел.
Требуется определить, какое минимальное количество и каких чисел надо приписать в конец этой последовательности,
чтобы она стала симметричной.
Формат ввода

Сначала вводится число N N — количество элементов исходной последовательности (1 ≤ ≤ N N ≤ ≤ 100).
Далее идут N N чисел — элементы этой последовательности, натуральные числа от 1 до 9.
Формат вывода

Выведите сначала число M M — минимальное количество элементов, которое надо дописать к последовательности,
а потом M M чисел (каждое — от 1 до 9) — числа, которые надо дописать к последовательности.
*/


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        Пример ввода и вывода числа n, где -10^9 < n < 10^9:
        int n = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(n));
        */

        int n = Integer.parseInt(reader.readLine());

        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }


        if (n == 1) {
            writer.write("0");

            reader.close();
            writer.close();
            return;
        }
        if (n == 2) {
            if (nums[0] == nums[1]) {
                writer.write("0");
            }
            else {
                writer.write(String.valueOf(nums[1]) + String.valueOf(nums[0]));
            }

            reader.close();
            writer.close();
            return;
        }

        int midUp = Math.ceil(((double) n) / 2);
        for (int i = midUp; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                if (nums[i - j] != nums[Math.min(n, i + j - 1)])
                    break;
            }
        }

        reader.close();
        writer.close();
    }

    private static int[] reverseList(int[] n) {
        int[] result = new int[n.length];
        for (int i = 0; i < n.length; i++) {
            result[n.length - i - 1] = n[i];
        }
        return result;
    }

    private static String stringifyList(int[] n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n.length; i++) {
            sb.append(n[i]);
            if (i < n.length - 1) sb.append(" ");
        }
        return sb.toString();
    }
}
