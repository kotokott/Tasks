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
        Arrays.sort(nums); //O(n log n)

        int numToFind = Integer.parseInt(reader.readLine());

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            //System.out.println("stats: ");
            //System.out.println(nums[left]);
            //System.out.println(nums[right]);
            int mid = ((left + right) / 2);
            //System.out.println(nums[mid]);

            if (nums[mid] == numToFind) {
                writer.write(String.valueOf(nums[mid]));

                reader.close();
                writer.close();
                return;
            }
            else if (nums[mid] < numToFind) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        if (left >= nums.length) {
            writer.write(String.valueOf(nums[right]));
        }
        else if (right < 0) {
            writer.write(String.valueOf(nums[left]));
        }
        else {
            int ans = Math.abs(nums[left] - numToFind) < Math.abs(nums[right] - numToFind)
                    ? nums[left]
                    : nums[right];
            writer.write(String.valueOf(ans));
        }

        reader.close();
        writer.close();
    }
}
