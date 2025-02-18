import java.util.Scanner;
/**
 * Problem can be found here: <a href="https://cemc.uwaterloo.ca/sites/default/files/documents/2023/2023CCCSrProblemSet.html">waterloo</a>
 * */
public class Sr2023Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // size of both lists
        int[] topTiles = new int[N];
        int[] bottomTiles = new int[N];
        for (int i = 0; i < N; i++) {
            topTiles[i] = sc.nextInt();
        }
        sc.nextLine(); // consume next line
        for (int i = 0; i < N; i++) {
            bottomTiles[i] = sc.nextInt();
        }

        int tapeLength = 0;
        for (int i = 0; i <= N - 2; i++) {
            int top = topTiles[i];
            int bottom = bottomTiles[i];
            int topRight = topTiles[i + 1];
            int bottomRight = bottomTiles[i + 1];
            if (bottom == 1) // bottom is black
                tapeLength += 3;
            if (top == 1) // top is black
                tapeLength += 3;
            if (i % 2 == 0 && bottom == 1 && top == 1) // on even column and both squares are black
                tapeLength -= 2;
            if (top == 1 && topRight == 1) // top is black as well as topright
                tapeLength -= 2;
            if (bottom == 1 && bottomRight == 1) // bottom is black as well as bottomright
                tapeLength -= 2;
        }
        // check last line
        int top = topTiles[N - 1];
        int bottom = bottomTiles[N - 1];
        if (bottom == 1)
            tapeLength += 3;
        if (top == 1)
            tapeLength += 3;
        if ((N - 1) % 2 == 0 && bottom == 1 && top == 1) {
            tapeLength -= 2;
        }
        System.out.println(tapeLength);
    }
}
