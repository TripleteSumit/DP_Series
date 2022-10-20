// House Robber
/*
 * problem statement: 
 * 
 * A thief needs to rob money in a street. The houses in the street are arranged in a circular manner.
 * Therefore the first and the last house are adjacent to each other. The security system int he street is such
 * that if adjacent houses are rubbed, the police will be notified.
 * 
 * Given an array of integer "Arr" which represnets money at each house, 
 * we need to return maximum amount of money that the thief can rob without alerting the police.
 */
public class DP_Lecture_6 {
    public static void main(String[] args) {
        int arr[] = { 1, 5, 2, 1, 6 };
        int N = arr.length;
        int temp1[] = new int[N - 1],
                temp2[] = new int[N - 1];
        for (int i = 0; i < N; i++) {
            if (i != 0)
                temp1[i - 1] = arr[i];
            if (i != N - 1)
                temp2[i] = arr[i];
        }
        System.out.println(Math.max(optimalApproch(temp1, temp1.length), optimalApproch(temp2, temp2.length)));
    }

    public static int optimalApproch(int cost[], int indx) {
        int perv2 = 0, prev = cost[0];
        for (int i = 1; i < indx; i++) {
            int pick = cost[i];
            if (i > 1)
                pick += perv2;
            int unPick = 0 + prev;
            int cur = Math.max(pick, unPick);
            perv2 = prev;
            prev = cur;
        }
        return prev;
    }
}
