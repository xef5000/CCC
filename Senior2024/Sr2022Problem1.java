import java.util.Scanner;

public class Sr2022Problem1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = n % 5;
        int a0 = (4 * r) % 5;
        int fourA0 = 4 * a0;
        System.out.println(fourA0 > n ? 0 : (n - fourA0) / 20 + 1);
    }
}
