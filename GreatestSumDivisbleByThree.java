import java.util.*;

public class Solution {
    public int maxSumDivThree(int[] nums) {
        int total = 0;
        List<Integer> mod1 = new ArrayList<>();
        List<Integer> mod2 = new ArrayList<>();

        for (int num : nums) {
            total += num;
            if (num % 3 == 1) {
                mod1.add(num);
            } else if (num % 3 == 2) {
                mod2.add(num);
            }
        }

        Collections.sort(mod1); // Smallest first
        Collections.sort(mod2);

        if (total % 3 == 0) {
            return total;
        } else if (total % 3 == 1) {
            int remove1 = mod1.size() >= 1 ? mod1.get(0) : Integer.MAX_VALUE;
            int remove2 = mod2.size() >= 2 ? mod2.get(0) + mod2.get(1) : Integer.MAX_VALUE;
            return total - Math.min(remove1, remove2);
        } else { // total % 3 == 2
            int remove1 = mod2.size() >= 1 ? mod2.get(0) : Integer.MAX_VALUE;
            int remove2 = mod1.size() >= 2 ? mod1.get(0) + mod1.get(1) : Integer.MAX_VALUE;
            return total - Math.min(remove1, remove2);
        }
    }
}
