// Knight Dialer Dynamic programming

class Solution {
    static final int MOD = 1000000007;

    public int knightDialer(int n) {
        // Define knight moves from each digit
        int[][] moves = {
            {4, 6},    // 0
            {6, 8},    // 1
            {7, 9},    // 2
            {4, 8},    // 3
            {0, 3, 9}, // 4
            {},        // 5 (no moves)
            {0, 1, 7}, // 6
            {2, 6},    // 7
            {1, 3},    // 8
            {2, 4}     // 9
        };

        // dp[i][j] = number of ways to reach digit i with j hops
        long[][] dp = new long[n + 1][10];

        // Base case: 1 way to start at each digit with 1 length
        for (int digit = 0; digit < 10; digit++) {
            dp[1][digit] = 1;
        }

        // Fill DP table
        for (int len = 2; len <= n; len++) {
            for (int digit = 0; digit < 10; digit++) {
                for (int move : moves[digit]) {
                    dp[len][digit] = (dp[len][digit] + dp[len - 1][move]) % MOD;
                }
            }
        }

        // Sum all ways to end with a number of length n
        long result = 0;
        for (int digit = 0; digit < 10; digit++) {
            result = (result + dp[n][digit]) % MOD;
        }

        return (int) result;
    }
}
