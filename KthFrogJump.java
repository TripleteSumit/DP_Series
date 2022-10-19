import java.util.Arrays;

/*
This is same as previous one but the twik is that previous question is about some step
but here k step to jump 
find out the output the minimum energy required the jump out k step
*/
public class DP_Lecture_4 {
    static int dp[];

    public static void main(String[] args) {
        int height[] = { 30, 10, 60, 10, 60, 50 };
        int n = height.length;
        int k = 2;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(usingTabulation(height, n, k));
    }

    public static int normalRecursion(int h[], int n, int k) {
        if (n == 0)
            return 0;
        int minStep = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if (n - j >= 0) {
                int jump = normalRecursion(h, n - j, k) + Math.abs(h[n] - h[n - j]);
                minStep = Math.min(minStep, jump);
            }
        }
        return minStep;
    }

    public static int usingMemoization(int h[], int n, int k) {
        if (n == 0)
            return 0;
        if (dp[n] != -1)
            return dp[n];
        int minStep = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if (n - j >= 0) {
                int jump = usingMemoization(h, n - j, k) + Math.abs(h[n] - h[n - j]);
                minStep = Math.min(minStep, jump);
            }

        }
        return dp[n] = minStep;
    }

    public static int usingTabulation(int h[], int n, int k) {
        dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int minStep = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int mins = dp[i - j] + Math.abs(h[i] - h[i - j]);
                    minStep = Math.min(minStep, mins);
                }
            }
            dp[i] = minStep;
        }
        return dp[n-1];
    }
}
