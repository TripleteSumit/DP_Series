import java.util.Arrays;

/*
 * Ninja's Training(2D DP)
 *
 * problem statement: 
 * 
 * A Ninja has an ‘N’ Day training schedule. He has to perform one of these three activities (Running, Fighting Practice, or Learning New Moves) each day. There are merit points associated with performing an activity each day. The same activity can’t be performed on two consecutive days. We need to find the maximum merit points the ninja can attain in N Days.

We are given a 2D Array POINTS of size ‘N*3’ which tells us the merit point of specific activity on that particular day. Our task is to calculate the maximum number of merit points that the ninja can earn.


example: 

Days = 3;

points = 10,40,70
         20,50,80
         30,60,90

ouput = 210 // 70(Day 0) + 50(Day2) + 90(Day3)
 */
public class DP_Lecture_7 {
    static int dp[][];

    public static void main(String[] args) {
        int points[][] = { { 10, 40, 70 },
                { 20, 50, 80 },
                { 30, 60, 90 } };
        int N = points.length;
        int last = 3;
        dp = new int[N][4];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        System.out.println(usingTabulation(points));
    }

    public static int normalRecursion(int points[][], int days, int last) {
        if (days == 0) {
            int maxi = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last)
                    maxi = Math.max(maxi, points[0][task]);
            }
            return maxi;
        }
        int maxi = 0;
        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int point = points[days][task] + normalRecursion(points, days - 1, task);
                maxi = Math.max(maxi, point);
            }
        }
        return maxi;
    }

    public static int usingMemoization(int points[][], int days, int last) {
        if (dp[days][last] != -1)
            return dp[days][last];
        if (days == 0) {
            int maxi = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last)
                    maxi = Math.max(maxi, points[days][task]);
            }
            return dp[days][last] = maxi;
        }

        int maxi = 0;
        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int point = points[days][task] + usingMemoization(points, days - 1, task);
                maxi = Math.max(point, maxi);
            }
        }
        return dp[days][last] = maxi;
    }

    public static int usingTabulation(int points[][]) {
        dp = new int[points.length][4];
        for (int i = 0; i < 4; i++) {
            int maxi = 0;
            for (int j = 0; j < 3; j++) {
                if (j != i)
                    maxi = Math.max(maxi, points[0][j]);
            }
            dp[0][i] = maxi;
        }
        for (int day = 1; day < points.length; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], point);
                    }
                }
            }
        }
        return dp[points.length - 1][3];
    }

}
