class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        boolean[] used = new boolean[strs.length];
        List<List<String>> list = new ArrayList<>();

        for(int i = 0 ; i < strs.length ; i++){
            
            if(used[i]) continue;
            List<String> newList = new ArrayList<>();
            String s = strs[i];
            newList.add(s);
            used[i] = true;

            for(int j = i + 1 ; j < strs.length ; j++){

                if(used[j] == false){
                    if(valid(s,strs[j])){
                        newList.add(strs[j]);
                        used[j] = true;
                    }
                }
            }

            list.add(newList);
        }

        return list;
    }

    boolean valid(String s, String t){

        if(s.length()!=t.length()) return false;

        int[] count = new int[26];

        for(int i = 0 ; i < s.length() ; i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(int c : count){
            if(c != 0) return false;
        }

        return true;
    }
}
