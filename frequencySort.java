import java.util.*;
public class Solution{
     public static void main(String []args){
        System.out.println(frequencySort( "acacaa"));
     }
     

    public static String frequencySort(String s) {
        Map<String,Integer> freq = new HashMap<String,Integer>();
        for(char ch: s.toCharArray()){
            String temp = Character.toString(ch);
            if(!freq.containsKey(temp))
                freq.put(temp ,0);
            freq.put(temp, freq.get(temp).intValue()+1);
        }
        Queue<String> pq = new PriorityQueue( freq.keySet().size(),  new Comparator(){
            public int compare(Object o1, Object o2){
                String s1 =(String) o1; String s2 =(String) o2;
                return -freq.get(s1).compareTo(freq.get(s2));
            }
        });
        for(String e : freq.keySet()){
            pq.add(e);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            String temp = pq.poll();
            int i = 0;
            while(i<freq.get(temp).intValue()){
                sb.append(temp);
                i++;
            }
        }
        
        return new String(sb);
        
        
    }
     
}