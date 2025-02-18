import java.util.Scanner;

public class Sr2023Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int rowPalindromes = sc.nextInt();
        int colPalindromes = sc.nextInt();
        char[][] grid = new char[row][col];
        for (int i = 0; i < rowPalindromes/2; i++) {
            int midRow = (row/2) + i;
            for (int j = 0; j < colPalindromes/2; j++) {
                grid[midRow][j] = 'h';
                grid[midRow][col-1-j] = 'h';
            }
            if (colPalindromes % 2 != 0) {
                grid[midRow][colPalindromes/2] = 'h';
            }
            midRow = (row/2) - i;
            for (int j = 0; j < colPalindromes/2; j++) {
                grid[midRow][j] = 'h';
                grid[midRow][col-1-j] = 'h';
            }
            if (colPalindromes % 2 != 0) {
                grid[midRow][colPalindromes/2] = 'h';
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}
