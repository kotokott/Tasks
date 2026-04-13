/*
Даны три натуральных числа. Возможно ли построить треугольник с такими сторонами? Если это возможно, выведите строку YES, иначе выведите строку NO.

Треугольник — это три точки, не лежащие на одной прямой.
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

        int[] nums = new int[3];
        for(int i = 0; i < 3; i++) {
            nums[i] = Integer.valueOf(reader.readLine());
        }

        int maxx = Math.max(Math.max(nums[0], nums[1]), nums[2]);
        writer.write(nums[0] + nums[1] > maxx
           && nums[0] + nums[2] > maxx
           && nums[1] + nums[2] > maxx
           ? "YES" : "NO");

        reader.close();
        writer.close();
    }
}
