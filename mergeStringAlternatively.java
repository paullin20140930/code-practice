/*
 "abc"  "cd"  return "acdbc"

*/
 public static String mergeStringAlternatively(  String str1, String str2 ){
	 if(str1.length()==0)
		return str2;
	 if(str2.length()==0)
		return str1;
	 
	 int i =0 , j = 0;
	 StringBuilder sb = new StringBuilder();
	 
	 while(i<str1.length() && j<str2.length()){
		
		sb.append( str1.charAt(i) );
		i++;
	
		sb.append(str2.charAt(j));
		j++;
	 
	 }
	 
	 while(i<str1.length()){
		sb.append( str1.charAt(i) );
		i++;             
	 }
	 while(j<str2.length()){
		sb.append( str2.charAt(j) );
		j++;             
	 }         
	 
	 return new String(sb);
 }