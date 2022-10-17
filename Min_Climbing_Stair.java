/*
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.


Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.
Example 2:

Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.
 */

public class DP_Lecture_2 {
    static int dp[];

    public static void main(String[] args) {
        // Climbing stair
        int cost[] = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
        int n = cost.length;
        dp = new int[n];
        System.out.println(optimalApproch(cost));

    }

    // only using normal recursion
    public static int normalRecursion(int cost[], int n) {
        if (n < 0)
            return 0;
        if (n == 0 || n == 1)
            return cost[n];
        return cost[n] + Math.min(normalRecursion(cost, n - 1), normalRecursion(cost, n - 2));
    }

    // Using memorization
    public static int usingMemoization(int cost[], int n) {
        if (n < 0)
            return 0;
        if (n == 0 || n == 1)
            return cost[n];
        if (dp[n] != 0)
            return dp[n];
        return dp[n] = cost[n] + Math.min(usingMemoization(cost, n - 1), usingMemoization(cost, n - 2));
    }

    // using tabulation
    public static int usingTabulation(int cost[]) {
        int n = cost.length;
        int dp[] = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[n - 2], dp[n - 1]);
    }

    // Optimal approch
    public static int optimalApproch(int cost[]) {
        int first = cost[0];
        int second = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int cur = cost[i] + Math.min(first, second);
            first = second;
            second = cur;
        }
        return Math.min(first, second);
    }
}
