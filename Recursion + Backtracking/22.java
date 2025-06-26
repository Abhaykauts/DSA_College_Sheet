class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(n,result,new StringBuilder(""),0,0);
        return result;
    }

    private void generate(int n,List<String> result,StringBuilder s,int l,int r){
        if(l==n&&r==n){
            result.add(s.toString());
            return;
        }
        if(l>n||r>n){
            return;
        }
         if (l < n) {
            s.append('(');
            generate(n, result, s, l + 1, r);
            s.deleteCharAt(s.length() - 1); // backtrack
        }

        if (r < l) {
            s.append(')');
            generate(n, result, s, l, r + 1);
            s.deleteCharAt(s.length() - 1); // backtrack
        }

    }
}