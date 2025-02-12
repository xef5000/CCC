import java.util.Arrays;
import java.util.Scanner;

public class Sr2023Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        int[] output = new int[N];
        output[0] = 0; // Single mountain is always symmetrical;
        for (int i = 2; i <= N; i++) {
            int newSize = i;
            for (int j = 0; j +newSize <= nums.length; j++) {
                int[] newList = Arrays.copyOfRange(nums, j, j + newSize);
                int asvalue = computeASValue(newList);
                if (j == 0) {
                    output[i-1] = asvalue;
                    continue;
                }
                if (output[i-1] > asvalue) {
                    output[i-1] = asvalue;
                }
            }
        }

        for (int i = 0; i < output.length; i++) {
            System.out.printf(output[i] + " ");
        }
    }

    private static int computeASValue(int[] nums) {
        int asvalue = 0;
        for (int i = 0; i < nums.length/2; i++) {
            int a = nums[i];
            int b = nums[nums.length - 1 - i];
            asvalue += Math.abs(a - b);
        }
        return asvalue;
    }
}
