class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0|| digits==null)
            return new ArrayList<>();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> result = new ArrayList<>();
        combinations(digits, result, map,new StringBuilder(""), 0);
        return result;
    }

    private void combinations(String digits, List<String> result, Map<Character, String> map , StringBuilder curr, int i) {
        if (i == digits.length()) {
            result.add(curr.toString());
            return;
        }

        String s = map.get(digits.charAt(i));
        for (char ch : s.toCharArray()) {
            combinations(digits, result, map,curr.append(ch), i + 1);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}