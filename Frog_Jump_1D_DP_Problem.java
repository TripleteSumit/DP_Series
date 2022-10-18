import java.util.Arrays;

/*There is a frag on the 1st step of an N stairs long staircase. The frong wants to reach the Nth stair. HEIGHT[I] is the given by HEIGHT[i-1]-HEIGHT[J-1].In the Frong is no ith staircse, he can jump eigther to (i+1)the stair of to (i+2)th stiar. You tast is to find theminimum toatl energy used by the frong ot reach from 1st stair to Nth stair.
*/
public class DP_Lecture_3 {
    static int dp[];

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 10 };
        dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        System.out.println(tabulationMethod(arr, arr.length - 1));
    }

    // Simpel approch means that Normal recursion
    public static int frongJumpNormalRecursion(int h[], int n) {
        if (n == 0)
            return 0;
        int left = frongJumpNormalRecursion(h, n - 1) + Math.abs(h[n] - h[n - 1]);
        int right = Integer.MAX_VALUE;
        if (n > 1)
            right = frongJumpNormalRecursion(h, n - 2) + Math.abs(h[n] - h[n - 2]);
        return Math.min(left, right);
    }

    // Uisng Memoization
    public static int frogJumpUsingMemoization(int h[], int n) {
        if (n == 0)
            return 0;
        if (dp[n] != -1)
            return dp[n];
        int left = frogJumpUsingMemoization(h, n - 1) + Math.abs(h[n] - h[n - 1]);
        int right = Integer.MAX_VALUE;
        if (n > 1)
            right = frogJumpUsingMemoization(h, n - 2) + Math.abs(h[n] - h[n - 2]);
        return dp[n] = Math.min(left, right);
    }

    // Using Tabulation method
    public static int tabulationMethod(int h[], int n) {
        dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int left = dp[i - 1] + Math.abs(h[i] - h[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1)
                right = dp[i - 2] + Math.abs(h[i] - h[i - 2]);
            dp[i] = Math.min(left, right);
        }
        return dp[n - 1];
    }

    // The Optimize one problem
    public static int spaceOptimization(int h[], int n) {
        int prev = 0, prev2 = 0;
        for (int i = 1; i < n; i++) {
            int left = prev + Math.abs(h[i] - h[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1)
                right = prev2 + Math.abs(h[i] - h[i - 2]);
            int cur = Math.min(left, right);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }

}
