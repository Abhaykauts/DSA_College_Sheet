class Solution {
    public String removeDuplicateLetters(String s) {
        if(s.length()==1) return s;

        int[] freq = new int[26];
        boolean[] visited = new boolean[26];

        char[] ch = s.toCharArray();

        Stack<Character> stack = new Stack<>();
        for(char i : ch){
            freq[i-'a']++;
        }

        for(char i : ch){
            freq[i-'a']--;
            if(visited[i-'a']) continue;

            while(!stack.isEmpty() && stack.peek()>i && freq[stack.peek()-'a']>0){
                visited[stack.pop()-'a'] = false;
            }

            stack.push(i);
            visited[i-'a'] = true;
        }

        StringBuilder sb = new StringBuilder();

        for(Character i : stack){
            sb.append(i);
        }

        return sb.toString();
    }
}