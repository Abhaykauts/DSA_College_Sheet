class Solution {
    public String frequencySort(String s) {
        if(s.length()==1) return s;

        HashMap<Character,Integer> map = new HashMap<>();

        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Map.Entry<Character,Integer>> queue = new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());

        queue.addAll(map.entrySet());

        StringBuilder result = new StringBuilder();

       while(!queue.isEmpty()){
        Map.Entry<Character,Integer> x = queue.poll();
        for( int i=0;i<x.getValue();i++) result.append(x.getKey());
       }

       return result.toString();
    }
}