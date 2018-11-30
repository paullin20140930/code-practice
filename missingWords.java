import java.util.*;
public class HelloWorld{
     public static void main(String []args){
        System.out.println(missingWords( "I like cheese I like cheese I like cheese"  ,    " "));
     }
     
     public static List<String> missingWords(String s, String t){
         String[] str1 = s.split(" ");
         String[] str2 = t.split(" ");
         if(t.length()==0)
            return Arrays.asList(str1);
         List<String> ans = new LinkedList<String>();
         int p = 0;
         for(String elem : str1){
             if(p<str2.length&&elem.equals(str2[p]))  //if missing last word, in the case where p points to str2 last string, but elem still proceeds, which will cause OUT of Index error.  
                p++;
            else{
                ans.add(elem);
            }
         }
         return ans;
     }
     
}