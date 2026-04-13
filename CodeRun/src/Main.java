import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
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
