package Babylon;

import java.util.Arrays;

public class DistinctSubsequencesDFSandMemo {
    static void main() {
        DistinctSubsequencesDFSandMemo ds = new DistinctSubsequencesDFSandMemo();
        System.out.println(ds.numDistinct("rabbbit", "rabbit"));
    }
    public int numDistinct(String s, String t) {
        int [][] memo = new int [s.length()][t.length()];
        for(int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return helper(0,0,s,t, memo);
    }

    public int helper(int i,int j,String s,String t, int [][] memo){
        int count;
        if (j == t.length()) {
            return 1;
        }
        if (i == s.length()) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if(s.charAt(i) == t.charAt(j)){
            count = helper(i + 1,j,s,t, memo) + helper(i+1,j+1,s,t, memo);
        } else {
            count = helper(i + 1, j , s, t, memo);
        }
        memo[i][j] = count;
        return count;
    }
}
