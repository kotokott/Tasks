/*
Школьники из объединения КРОШ (Клуб Решателей Олимпиад Школьников) готовятся к участию в треке ML.
Начать подготовку они решили с изучения линейной алгебры. Выяснилось,
что существует две интересные операции над матрицами — умножение и траспонирование.
Они составили много примеров и решают их на листике, однако им нужна помощь в проверке результатов.
Напишите программу, которая по заданным матрицам A A и  B B вычисляет:

( A × B ) T ,
(A×B)T,

где A A — матрица размером n × m n×m, а B B — матрица размером m × k m×k.

Напомним, как работают данные операции:

    Умножение матриц A × B = C A×B=C:
    C i j = ∑ k = 1 m A i k B k j
    Cij​=k=1∑m​Aik​Bkj​

    Транспонирование матрицы (столбцы становятся строками):
    ( A T ) i j = A j i
    (AT)ij​=Aji​

Формат ввода

В первой стоке вводятся 3 числа n , m , k n,m,k ( 1 ≤ n , m , k ≤ 100 ) (1≤n,m,k≤100).

Далее следуют n n строк по m m чисел в каждой — элементы матрицы A A ( 0 ≤ A i , j ≤ 10 ) (0≤Ai,j​≤10).

Затем вводятся m m строк по k k чисел в каждой — элементы матрицы B B ( 0 ≤ B i , j ≤ 10 ) (0≤Bi,j​≤10).

Элементы строк разделены ровно одним пробелом, каждая строка может оканчиваться произвольным количеством пробелов.
Формат вывода

Выведите матрицу результата операции ( A × B ) T (A×B)T.

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
    String[] input = reader.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]);
    int k = Integer.parseInt(input[2]);

    String[][] aMatrix = new String[n][m];
    for (int i = 0; i < n; i++) {
      aMatrix[i] = reader.readLine().split(" ");
    }
    String[][] bMatrix = new String[m][k];
    for (int i = 0; i < m; i++) {
      bMatrix[i] = reader.readLine().split(" ");
    }

    int[][] cMatrix = new int[k][n];
    for (int i = 0; i < n; i++) {
      for (int g = 0; g < k; g++) {
        int elem = 0;
        for (int j = 0; j < m; j++) {
          elem += Integer.parseInt(aMatrix[i][j]) * Integer.parseInt(bMatrix[j][g]);
        }
        cMatrix[g][i] = elem;
      }
    }

    for (int i = 0; i < k; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(cMatrix[i][j] + " ");
      }
      System.out.println();
    }

    reader.close();
    writer.close();
  }
}

/*
3 3 3
1 2 1
4 2 2
0 1 7
7 5 1
2 1 2
4 3 4
*/
