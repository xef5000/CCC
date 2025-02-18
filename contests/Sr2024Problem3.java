import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem can be found here: <a href="https://cemc.uwaterloo.ca/sites/default/files/documents/2024/2024CCCSrProblems.html">waterloo</a>
 * */
public class Sr2024Problem3 {
    /**
     * Determine if the arrays can be the same using only leftSwipe and rightSwipe
     * Rule #1: If the arrays are the same, return true
     * Rule #2: If array B has numbers that array A doesn't have, return false
     * */

    private static List<String> results = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // length of each arrays
        int[] arr1 = new int[n]; // array that we have
        int[] arr2 = new int[n]; // array that we want
        for (int j = 0; j < arr1.length; j++) {
            arr1[j] = scanner.nextInt(); // fill array that we have
        }
        scanner.nextLine();
        for (int j = 0; j < arr2.length; j++) {
            arr2[j] = scanner.nextInt(); // fill array that we want
        }

        for (int i = 0; i < arr1.length/2; i++) { // Checking from the extremities of the list
            if (check(arr1, arr1.length-1 - i, arr2)) return; // Checking left
            if (check(arr1, i, arr2)) return; // Checking right

        }
        if (check(arr1, arr1.length / 2, arr2)) return; // Checking middle

        System.out.println("YES");
        System.out.println(results.size());
        for (String result : results) {
            System.out.println(result);
        }

    }

    // Returns if should end
    private static boolean check(int[] arr1, int index, int[] arr2) {
        int curr = arr1[index];
        int lookingfor = arr2[index];
        if (curr == lookingfor) return false; // return early, don't end
        // From here, we know that we will need to do a swipe
        int closest = findClosest(arr1, index, lookingfor);

        if (closest == -1) { // END IT, there is no way to make it the same
            System.out.println("NO");
            return true; // return early, should end
        }

        if (closest > index) {
            swipeLeft(index, closest, arr1);
            results.add("L " + index + " " + (closest));
        } else {
            swipeRight(closest, index, arr1);
            results.add("R " + (closest) + " " + index);
        }
        return false; // return late, don't end
    }

    private static int findClosest(int[] arr, int startingIndex, int lookingFor) {
        for (int i = 1; i < arr.length; i++) {
            if (startingIndex + i < arr.length) { // Trying to explore right
                if (arr[startingIndex + i] == lookingFor)
                    return startingIndex + i;
            }
            if (startingIndex - i >= 0) { // Trying to explore left
                if (arr[startingIndex - i] == lookingFor)
                    return startingIndex - i;
            }
        }
        return -1;
    }


    private static void swipeRight(int left, int right, int[] arr) {
        for (int i = left; i <= right; i++) {
            arr[i] = arr[left];
        }
    }

    private static void swipeLeft(int left, int right, int[] arr) {
        for (int i = right; i >= left; i--) {
            arr[i] = arr[right];
        }
    }
}
