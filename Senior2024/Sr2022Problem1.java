import java.util.Scanner;

public class Sr2022Problem1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int total = 0;

        if ((n-19) % 20 == 0) {
            total += 1;
            n -= 19;
        } else if ((n-18) % 20 == 0) {
            total += 1;
            n -= 18;
        } else if ((n - 17) % 20 == 0) {
            total += 1;
            n -= 17;
        } else if ((n - 16) % 20 == 0) {
            total += 1;
            n -= 16;
        } else if ((n - 15) % 20 == 0) {
            total += 1;
            n -= 15;
        } else if ((n - 14) % 20 == 0) {
            total += 1;
            n -= 14;
        } else if ((n - 13) % 20 == 0) {
            total += 1;
            n -= 13;
        } else if ((n - 12) % 20 == 0) {
            total += 1;
            n -= 12;
        } else if ((n - 10) % 20 == 0) {
            total += 1;
            n -= 10;
        } else if ((n - 9) % 20 == 0) {
            total += 1;
            n -= 9;
        } else if ((n - 8) % 20 == 0) {
            total += 1;
            n -= 8;
        } else if ((n - 5) % 20 == 0) {
            total += 1;
            n -= 5;
        } else if ((n - 4) % 20 == 0) {
            total += 1;
            n -= 4;
        }
        if (n!=0) {
            if (n % 20 == 0) {
                int rest = n / 20;
                total += rest;
            } else if (n % 4 == 0) {
                total += 1;
            } else if (n % 5 == 0) {
                total += 1;
            } else {
                total += 0;
            }
        }

        System.out.println(total + "");
    }
}
