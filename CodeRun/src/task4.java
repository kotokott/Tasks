/*
Большинство задач сезона CodeRun имеют теги, помогающие пользователям выбрать подходящий алгоритм для решения. Известно, что для первой и второй задач каждого трека количество тегов равно 1 ( t [ 1 ] = t [ 2 ] = 1 ) (t[1]=t[2]=1), а для всех следующих количество тегов вычисляется по следующему правилу:

t [ i ] = t [ i − 1 ] + t [ i − 2 ] ,
t[i]=t[i−1]+t[i−2],

где t [ i ] t[i] — количество тегов задачи с номером i i.

Было установлено, что на выставление одного тега требуется одна секунда. Посчитайте, сколько всего времени потребуется для выставления всех тегов для всех задач.
Формат ввода

На вход подаётся одно целое число n n ( 1 ≤ n ≤ 35 ) (1≤n≤35) — количество задач в треке.
Формат вывода

Выведите одно целое число — сумму t [ i ] t[i] — время, необходимое для расстановки тегов для всех задач.
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

        int n = Integer.parseInt(reader.readLine());
        int sum = Math.min(n, 2);

        int prevInd = 1;
        int prevPrevInd = 1;
        for (int i = sum; i < n; i++) {
            int ind = prevInd + prevPrevInd;
            sum += ind;

            prevPrevInd = prevInd;
            prevInd = ind;
        }

        writer.write(String.valueOf(sum));

        reader.close();
        writer.close();
    }
}
