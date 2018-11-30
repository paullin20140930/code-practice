 public  int KthLeastSigBit( int k, int nums){
	 
	 int i=0, bit = 1;
	 while(i<k){
		 bit=(bit<<1);
		 i++;
	 }
	 bit = 1&nums;
	 return bit;
 }