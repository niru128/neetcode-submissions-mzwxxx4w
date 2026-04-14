class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int left = 0;
        int right = s1.length()-1;

        while(right < s2.length()){

            String str1 = s2.substring(left,right+1);
            
            if(!isAnagram(str1,s1)){
                left++;
                right++;
            }else{
                return true;
            }
        }

        return false;
    }

    boolean isAnagram(String s, String t){

        if(s.length()!=t.length()) return false;
        int[] freq = new int[26];

        for(int i = 0 ; i < s.length() ; i++){
            freq[s.charAt(i) - 'a']++;
        }

        for(int j = 0 ;j < t.length() ; j++){
            freq[t.charAt(j) - 'a']--;
        }

        for(int i = 0 ; i < freq.length ; i++){
            if(freq[i]!=0) return false;
        }

        return true;

    }
}
