class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
       
        if (m < n)
            return "";
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int i = 0;
        int j = 0;
        int req = n;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        while (j < m) {
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                if (map.get(ch) > 0) {
                    req--;
                } 
             map.put(ch, map.get(ch) - 1);    
            }
            else{
                map.put(ch, -1);
            }

            while(req==0){
                int currLen = j-i+1;
                if(minLen > currLen){
                    minLen = currLen;
                    start = i;
                }
                map.put(s.charAt(i),map.get(s.charAt(i))+1);

                if( map.get(s.charAt(i)) > 0 ){
                    req++;
                }
                i++;
            }
            j++;
        }

        if(minLen!=Integer.MAX_VALUE){
            return s.substring(start,start+minLen);
        }
        return "";
    }
}