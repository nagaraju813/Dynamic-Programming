🔢 Problem Statement:
How many distinct phone numbers of length 3 can be formed by moving a knight on the keypad?

⌨️ Keypad Layout:
Copy
Edit
1 2 3  
4 5 6  
7 8 9  
 0  
♞ Knight Moves:
less
Copy
Edit
From digit:
0 → [4, 6]  
1 → [6, 8]  
2 → [7, 9]  
3 → [4, 8]  
4 → [0, 3, 9]  
5 → []  
6 → [0, 1, 7]  
7 → [2, 6]  
8 → [1, 3]  
9 → [2, 4]
🪜 Step-by-Step for n = 3:
We'll maintain dp[step][digit] = number of ways to reach digit in step steps.

🔹 Initialization (step = 1):
At step 1, each digit has 1 way (starting point):

Copy
Edit
dp[1][0..9] = 1
🔹 Step 2:
Now we calculate how many ways to reach each digit in 2 steps.

Example:

dp[2][0] = dp[1][4] + dp[1][6] = 1 + 1 = 2

dp[2][1] = dp[1][6] + dp[1][8] = 1 + 1 = 2

...
(Compute for all digits)

After all calculations:

Copy
Edit
dp[2] = [2, 2, 2, 2, 3, 0, 3, 2, 2, 2]
🔹 Step 3:
Now use step 2 values to compute step 3.

Example:

dp[3][0] = dp[2][4] + dp[2][6] = 3 + 3 = 6

dp[3][1] = dp[2][6] + dp[2][8] = 3 + 2 = 5

dp[3][2] = dp[2][7] + dp[2][9] = 2 + 2 = 4

dp[3][3] = dp[2][4] + dp[2][8] = 3 + 2 = 5

dp[3][4] = dp[2][0] + dp[2][3] + dp[2][9] = 2 + 2 + 2 = 6

dp[3][5] = 0 (no moves)

dp[3][6] = dp[2][0] + dp[2][1] + dp[2][7] = 2 + 2 + 2 = 6

dp[3][7] = dp[2][2] + dp[2][6] = 2 + 3 = 5

dp[3][8] = dp[2][1] + dp[2][3] = 2 + 2 = 4

dp[3][9] = dp[2][2] + dp[2][4] = 2 + 3 = 5

So,

Copy
Edit
dp[3] = [6, 5, 4, 5, 6, 0, 6, 5, 4, 5]
➕ Final Result:
Add all values in dp[3]:

Copy
Edit
6 + 5 + 4 + 5 + 6 + 0 + 6 + 5 + 4 + 5 = 46
