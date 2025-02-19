import java.util.Scanner;

public class Sr2021Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] sides = new int[n+1];
        for (int i = 0; i <= n; i++) {
            sides[i] = scanner.nextInt();
        }
        int[] width = new int[n];
        for (int i = 0; i < n; i++) {
            width[i] = scanner.nextInt();
        }

        double sum = 0;

        for (int i = 0; i < n; i++) {
            int side1 = sides[i];
            int side2 = sides[i+1];
            int w = width[i];
            sum += (double) ((side1 + side2) * w) /2;
        }

        System.out.println(sum);
    }
}
