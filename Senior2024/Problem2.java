import java.util.Scanner;

/**
 * Problem can be found here: <a href="https://cemc.uwaterloo.ca/sites/default/files/documents/2024/2024CCCSrProblems.html">waterloo</a>
 * */
public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Number of strings
        scanner.nextInt(); // Length of each string (don't need to store)

        // Consume the newline character
        scanner.nextLine();

        // Read the n strings
        Character[] results = new Character[n];
        for (int i = 0; i < n; i++) {
            results[i] = process(scanner.nextLine());
        }

        // Print the strings (for verification)
        for (Character str : results) {
            System.out.println(str);
        }
    }

    private static char process(String strings) {
        int[] letters = new int[26];
        for (int j = 0; j < strings.length(); j++) {
            letters[strings.charAt(j) - 'a']++;
        }

        for (int j = 0; j <= strings.length()/2; j+=2) {
            char c1 = strings.charAt(j);
            char c2 = strings.charAt(j+1);
            if (c1 != c2) {
                int c1p = letters[c1 - 'a'];
                int c2p = letters[c2 - 'a'];
                if ((c1p > 1 && c2p > 1) ||
                (c1p == c2p)) return 'F';
            } else
                return 'F';
        }

        return 'T';
    }
}