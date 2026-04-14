/*
Во входном файле записан текст. Словом считается последовательность непробельных символов,
идущих подряд. Слова разделены одним или большим числом пробелов,
переводами строк или символами конца строки.

Определите, сколько различных слов содержится в этом тексте.
Формат ввода

Вводится текст.
Формат вывода

Выведите ответ на задачу.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

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

        Set<String> wordSet = new HashSet<>();
        String input = reader.readLine();
        while(input != null) {
            String[] words = input.split("\\s+");
            for (String word : words) {
                if (!word.equals(""))
                    wordSet.add(word);
            }
            input = reader.readLine();
        }

        //wordSet.stream().forEach(System.out::println);

        writer.write(String.valueOf(wordSet.size()));

        reader.close();
        writer.close();
    }
}
