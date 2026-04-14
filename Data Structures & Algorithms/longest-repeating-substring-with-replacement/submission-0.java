class Solution {
    public int characterReplacement(String s, int k) {
        
        int[] freq = new int[26];
        int maxFreq = 0;
        int windowLen = 0;
        int left = 0;

        for(int right = 0 ; right < s.length() ; right++){

            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            int len = right - left + 1;

            if(len - maxFreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            len = right - left + 1;

            windowLen = Math.max(windowLen , len);
        }

        return windowLen;
    }
}
