class Solution {   // 123 456
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0"))
            return "0";
        int[] ans = new int[num1.length()+num2.length()];
        int i=0,j=0;
        int d1=0, d2=0;
        while( i<num1.length()){
            int sum=0;
            j = 0;
            d1 = (int)(num1.charAt(i)-'0');
            while(j<num2.length()){
                d2 = (int)(num2.charAt(j)-'0');
                sum = d1*d2;
                ans[i+j+1] += sum%10;
                ans[i+j] += sum/10;                
                j++;
            }
            i++;
        }
        int carry=0;
        StringBuilder sb = new StringBuilder();
        int start = 0;
        while(ans[start]==0)
            start++;
        for(int idx=ans.length-1; idx>=start; idx-- ){        
            int temp = ans[idx] + carry;   // array value + carry, temp is range 0 to 20
            if( temp <10 ){
                sb.insert(0,temp);
                carry=0;
                continue;
            }
            else{ // temp>=10, propogate carry 
                carry=temp/10;  
                temp %=10;  // add temp's digit number
                sb.insert(0,temp);
                
            }
        }
        if(carry!=0)//
            sb.insert(0,carry);
        
        
        return new String(sb);
    }
}