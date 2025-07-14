class Solution {
    public char findTheDifference(String s, String t) {
        if(s.equals("")) return t.charAt(0);
        int x =0;

        for(char ch:s.toCharArray()){
            x^=ch;
        }

        for(char ch:t.toCharArray()){
            x^=ch;
        }

        return (char)x;
    }
}