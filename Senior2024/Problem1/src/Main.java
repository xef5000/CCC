import java.util.Scanner;

/**
 * Problem can be found here: <a href="https://cemc.uwaterloo.ca/sites/default/files/documents/2024/2024CCCSrProblems.html">waterloo</a>
 * */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // Number of people in the circle
        int[] people = new int[N/2];

        for (int i = 0; i < N/2; i++) {
            people[i] = sc.nextInt();
        }

        int total = 0;
        for (int i = 0; i < N/2; i++) {
            int person = sc.nextInt();
            if (person == people[i]) {
                total += 2;
            }
        }
        System.out.println(total);
    }
}