/*
Дан список. Определите, является ли он монотонно возрастающим
(то есть верно ли, что каждый элемент этого списка строго больше предыдущего).

Выведите YES, если массив монотонно возрастает и NO в противном случае.
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

        Integer lastNum = null;
        for (String numStr : reader.readLine().split(" ")) {
            int num = Integer.parseInt(numStr);
            if (lastNum == null) {
                lastNum = num;
                continue;
            }
            if (num <= lastNum) {
                writer.write("NO");
                reader.close();
                writer.close();
                return;
            }
            lastNum = num;
        }
        writer.write("YES");

        reader.close();
        writer.close();
    }
}
