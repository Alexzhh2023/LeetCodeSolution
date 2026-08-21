package NewBirdTrain.Day1;

public class LongestRepeatingCharacterReplacement {
    static void main() {
        LongestRepeatingCharacterReplacement lcr = new LongestRepeatingCharacterReplacement();
        System.out.println(lcr.characterReplacement("AABABBA", 1));
    }

    public int characterReplacement(String s, int k) {
        int [] freq = new int[26];

        char[] arr = s.toCharArray();
        int left = 0;
        int right = 0;
        int maxFrequency = 0;
        int res = 0;
        while (right < arr.length) {
            freq[arr[right] - 'A']++;
            maxFrequency = Math.max(maxFrequency, freq[arr[right] - 'A']);
            while (right - left + 1 - maxFrequency > k) {
                freq[arr[left] - 'A']--;
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
