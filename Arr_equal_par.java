 /*
 *  divide array into 2 part such that equal sum and they remain order.
 */
 
 public static int balancedSale( int[] arr){
	 int i = 0 , j = arr.length-1;
	 int laccu = 0, raccu=0;
	 //int mark=0; 
	 while(i<j){    // ending condition: i==j
		 if(laccu<=raccu){
			 
			 laccu+=arr[i];
			 i++;
			 //mark=1;
		 }else if( laccu > raccu){
			 
			 raccu+=arr[j];
			 j--;
			 //mark=0;
		 }
	 }

	return i;
 }