import java.util.*;
public class HelloWorld{

     public static void main(String []args){
        System.out.println("Hello World");
        
        String version1 = ".";
        
        //String[] v1 = version1.split("/");
        List<List<String>> l = new ArrayList<List<String>>();
        List<String> l1 = new ArrayList<String>();
        l1.add("2"); l1.add("3"); l1.add("4");
        List<String> l2 = new ArrayList<String>();
        l2.add("a"); l2.add("a"); l2.add("c");
        l.add(l1);
        l.add(l2);
        
        System.out.print( listPermutation(l));
     }
     
     public static List<String> listPermutation(List<List<String>> l){
         Stack<String> stack = new Stack<String> ();
         int pos = 0;
         List<String> ans = new LinkedList<String>();
         for(String s : l.get(pos)){
             stack.push(s);
         }
         pos++;  // index of next list to be pushed - l[pos]
         
         while(!stack.empty()){
             String top= stack.pop();
             pos = top.length(); // index of next list to be pushed in    
             if(pos< l.size()){
                for(String e : l.get( top.length())){
                    stack.push(top+e);
                }                
             }else{  // no further list, end depth of one single path.
                 ans.add(top);
             }             
         }
         return ans;
     }
     
}