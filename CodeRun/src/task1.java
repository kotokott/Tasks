/*
Подготовка задач к сезону это долгий и кропотливый процесс. Юля знает, что уже готово A A задач. Никита выяснил, что ещё B B задач почти готовы и в ближайшее время будут добавлены в сезон. Помогите Юле и Никите узнать, сколько всего задач планируется в сезоне.
Формат ввода

Первая строка содержит два числа A и B ( 0 ≤ A , B ≤ 2 ∗ 1 0 18 ) (0≤A,B≤2∗1018), разделённые пробелом.
Формат вывода

Выведите одно число − − A + B A+B − − суммарное количество задач в сезоне.
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        long result = Arrays
            .stream(reader
                .readLine()
                .split(" "))
            .mapToLong(Long::parseLong)
            .sum();
        
        writer.write(String.valueOf(result));

        reader.close();
        writer.close();
    }
}
