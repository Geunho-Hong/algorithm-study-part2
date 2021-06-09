package min.queue;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CastleOnTheGrid {

    // ...
    // .X.
    // .X.
    public static int minimumMoves(List<String> grid, int startX, int startY, int goalX, int goalY) {
        grid.forEach(System.out::println);


        return 0;
    }
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int startX = Integer.parseInt(firstMultipleInput[0]);
        int startY = Integer.parseInt(firstMultipleInput[1]);
        int goalX = Integer.parseInt(firstMultipleInput[2]);
        int goalY = Integer.parseInt(firstMultipleInput[3]);

        int result = CastleOnTheGrid.minimumMoves(grid, startX, startY, goalX, goalY);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }

}
