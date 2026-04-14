class Solution {
    public String minWindow(String s, String t) {



        int[] mapS = new int[128];
        int[] mapT = new int[128];


        for(char c : t.toCharArray()){
            mapT[c]++;
        }

        int left = 0;
        int right =0 ;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        for(; right < s.length() ; right++){

            mapS[s.charAt(right)]++;

            while(contains(mapS,mapT)){
                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    start = left;
                }
                mapS[s.charAt(left++)]--;
            }
        }
        

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start,start+minLen);
    }

    boolean contains(int[] mapS, int[] mapT){

        for(int i = 0 ; i < 128 ; i++){
            if(mapT[i] > mapS[i] ){
                return false;
            }


        }
        return true;
    }
}
