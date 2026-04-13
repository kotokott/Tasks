/*
Дан список чисел. Определите, сколько в этом списке элементов, которые больше двух своих соседей. Выведите количество таких элементов.
Формат ввода

Вводится список чисел. Все числа списка находятся на одной строке.
Формат вывода

Выведите ответ на задачу.
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

        String[] strNums = reader.readLine().split(" ");
        int[] nums = new int[strNums.length];
        for (int i = 0; i < strNums.length; i++) {
            nums[i] = Integer.parseInt(strNums[i]);
        }

        if (nums.length < 3) {
            writer.write("0");
            reader.close();
            writer.close();
            return;
        }

        int counter = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                counter++;
            }
        }

        writer.write(String.valueOf(counter));

        reader.close();
        writer.close();
    }
}
