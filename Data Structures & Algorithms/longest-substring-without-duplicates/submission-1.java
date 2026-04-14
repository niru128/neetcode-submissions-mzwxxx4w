class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0 ) return 0;
        
        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLen = 1;
        int right = 0;

        while(right < s.length()){
            char c = s.charAt(right);
            if(!set.contains(c)){
                set.add(c);
                maxLen = Math.max(maxLen , right - left + 1);
                right++;
            }else{
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxLen;
    }
}
