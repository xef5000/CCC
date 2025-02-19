import java.util.Scanner;

public class Sr2021Problem2 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt(); // ROW
        int N = scanner.nextInt(); // COLUMN
        int K = scanner.nextInt(); // AMOUNT OF ACTIONS
        int[] rowToggles = new int[M];
        int[] colToggles = new int[N]; // all zero by default
        for (int i = 0; i < K; i++) {
            String x = scanner.next(); // going to be "R" or "C"
            int y = scanner.nextInt(); // going to be a row or column index
            if (x.equals("R")) {
                rowToggles[y - 1]++;
            } else {
                colToggles[y - 1]++;
            }
        }
        scanner.close();
        System.out.println(getTotal1s(rowToggles, colToggles, M, N));
    }

    private static int getTotal1s(int[] rowToggles, int[] colToggles, int M, int N) {
        int total = 0;
        int rowOnes = 0;
        int colOnes = 0;

        for (int i = 0; i < M; i++) {
            if (rowToggles[i] % 2 != 0) {
                rowOnes++;
            }
        }

        for (int j = 0; j < N; j++) {
            if (colToggles[j] % 2 != 0) {
                colOnes++;
            }
        }

        total = rowOnes * N + colOnes * M - 2 * rowOnes * colOnes;
        return total;
    }

    private static void paintTiles(int[][] canvas, int M, int N, String x, int y) {
        if (x.equals("R")) {
            for (int i = 0; i < N; i++) {
                canvas[y][i] = canvas[y][i] == 0 ? 1 : 0;
            }
        } else {
            for (int i = 0; i < M; i++) {
                canvas[i][y] = canvas[i][y] == 0 ? 1 : 0;
            }
        }
    }
}
