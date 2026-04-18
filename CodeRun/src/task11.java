/*
Вам дан словарь, состоящий из пар слов.
Каждое слово является синонимом к парному ему слову.
Все слова в словаре различны. Для одного данного слова определите его синоним.

Формат ввода
Программа получает на вход количество пар синонимов
N
N. Далее следует
N
N строк, каждая строка содержит ровно два слова-синонима.
После этого следует одно слово.

Формат вывода
Программа должна вывести синоним к данному слову.

Примечание
Эту задачу можно решить и без словарей (сохранив все входные данные в списке),
 но решение со словарем будет более простым.
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        Map<String, String> words = new HashMap<>();
        while(n > 0) {
            String[] input = reader.readLine().split(" ");
            words.put(input[0], input[1]);
            n--;
        }
        String wordToFind = reader.readLine();
        Map<Boolean, List<Map.Entry<String, String>>> collect = words.entrySet().stream()
                .collect(Collectors.groupingBy(
                        (t) -> t.getKey().equals(wordToFind)
                                || t.getValue().equals(wordToFind)
                ));

        if (collect.containsKey(true)) {
            Map.Entry<String, String> entry = collect.get(true).getFirst();

            writer.write(entry.getKey().equals(wordToFind) ? entry.getValue() : entry.getKey());
        }

        reader.close();
        writer.close();
    }
}
