/*
В новой программе OpenCalculator появилась новая возможность – можно настроить, какие кнопки отображаются, а какие – нет. Если кнопка не отображается на экране, то ввести соответствующую цифру с клавиатуры или копированием из другой программы нельзя. Петя настроил калькулятор так, что он отображает только кнопки с цифрами x, y, z. Напишите программу, определяющую, сможет ли Петя ввести число N, а если нет, то какое минимальное количество кнопок надо дополнительно отобразить на экране для его ввода.
Формат ввода

Сначала вводятся три различных числа из диапазона от 0 до 9: x, y и z (числа разделяются пробелами). Далее вводится целое неотрицательное число N, которое Петя хочет ввести в калькулятор. Число N не превышает 10000.
Формат вывода

Выведите, какое минимальное количество кнопок должно быть добавлено для того, чтобы можно было ввести число N (если число может быть введено с помощью уже имеющихся кнопок, выведите 0)
Примечание

Комментарии к примерам тестов.

    Число может быть введено имеющимися кнопками.

    Нужно добавить кнопку 0.

    Нужно добавить кнопки 1 и 2.

*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
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

        List<Integer> buttonNumbers = Arrays.stream(reader.readLine().split(" "))
            .map(t -> Integer.parseInt(t)).toList();
        List<Integer> number = new ArrayList<>(Arrays.stream(reader.readLine().split(""))
            .map(t -> Integer.parseInt(t)).toList());

        number.removeAll(buttonNumbers);
        Set<Integer> numberSet = number.stream().collect(Collectors.toSet());
        writer.write(String.valueOf(numberSet.size()));

        reader.close();
        writer.close();
    }
}
