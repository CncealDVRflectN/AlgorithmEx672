import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class AlgEx {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("input.txt"));
        FileWriter writer = new FileWriter("output.txt");
        int vertexNum = scanner.nextInt();
        int[][] mtr = new int[vertexNum][vertexNum];
        int[] indexes = new int[vertexNum];
        int counter = 1;
        for (int i = 0; i < vertexNum; i++) {
            for (int j = 0; j < vertexNum; j++) {
                mtr[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < vertexNum; i++) {
            if (indexes[i] == 0) {
                counter = fillIndexes(mtr, indexes, vertexNum, i, counter);
            }
        }
        for (int k = 0; k < vertexNum - 1; k++) {
            writer.write(indexes[k] + " ");
        }
        writer.write(indexes[vertexNum - 1] + "");
        writer.close();
        scanner.close();
    }

    private static int fillIndexes(int[][] mtr, int[] indexes, int vertexNum, int line, int counter) {
        if (indexes[line] == 0) {
            indexes[line] = counter++;
        }
        for (int j = 0; j < vertexNum; j++) {
            if (mtr[line][j] == 1 && indexes[j] == 0) {
                indexes[j] = counter++;
                counter = fillIndexes(mtr, indexes, vertexNum, j, counter);
            }
        }
        return counter;
    }
}
